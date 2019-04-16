package org.jasig.cas.adaptors.jdbc;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.ConfigurableHashService;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.HashRequest;
import org.apache.shiro.util.ByteSource;
import org.jasig.cas.authentication.*;
import org.jasig.cas.authentication.handler.support.AbstractUsernamePasswordAuthenticationHandler;
import org.jasig.cas.authentication.principal.SimplePrincipal;
import org.jasig.cas.dao.UserAuthenticationDao;
import org.jasig.cas.entity.UaUser;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;

import javax.security.auth.login.AccountNotFoundException;
import javax.security.auth.login.FailedLoginException;
import javax.validation.constraints.NotNull;
import java.security.GeneralSecurityException;
import java.util.Map;

public class ValidUserQueryDBAuthenticationHandler extends AbstractUsernamePasswordAuthenticationHandler {

    private static final String DEFAULT_SALT_FIELD = "salt";
    private static final String DEFAULT_NUM_ITERATIONS_FIELD = "numIterations";

    /**
     * The Algorithm name.
     */
    @NotNull
    protected String algorithmName;

    /**
     * The Salt field name.
     */
    @NotNull
    protected String saltFieldName = DEFAULT_SALT_FIELD;

    /**
     * The Number of iterations field name.
     */
    @NotNull
    protected String numberOfIterationsFieldName = DEFAULT_NUM_ITERATIONS_FIELD;

    /**
     * The number of iterations. Defaults to 0.
     */
    protected long numberOfIterations;

    /**
     * The static/private salt.
     */
    protected String staticSalt;

    /**
     * 用户验证dao
     */
    protected UserAuthenticationDao userAuthenticationDao;


    /**
     * Instantiates a new Query and encode database authentication handler.
     *
     * @param dataSource    The database datasource
     *                      for the user id. (i.e. <code>SELECT * FROM table WHERE username = ?</code>
     * @param algorithmName the algorithm name (i.e. <code>MessageDigestAlgorithms.SHA_512</code>)
     */

    public ValidUserQueryDBAuthenticationHandler(final UserAuthenticationDao userAuthenticationDao,
                                                 final String algorithmName) {
        super();
        this.userAuthenticationDao = userAuthenticationDao;
        this.algorithmName = algorithmName;
    }

    @Override
    protected final HandlerResult authenticateUsernamePasswordInternal(final UsernamePasswordCredential transformedCredential)
            throws GeneralSecurityException, PreventedException {
        final String username = getPrincipalNameTransformer().transform(transformedCredential.getUsername());

        try {
            final UaUser user = userAuthenticationDao.getPerson(username);

            // 如果账号已被停用
//            if ("1".equals(user.getAccountStatus())) {
//                throw new AccountDisabledException(username + "  has been disabled.");
//            }
            // 如果账号已被锁
//            if (Boolean.TRUE.equals(user.getAccountStatus())) {
//                throw new AccountLockedException(username + "  has been locked.");
//            }

            // 不是IC卡代理登录需要校验密码
            if (!"1".equals(((UsernamePasswordCaptchaCredential) transformedCredential).getLoginType())) {
                final String digestedPassword = digestEncodedPassword(transformedCredential.getPassword(), user);
                if (!user.getLoginPassword().equals(digestedPassword)) {
                    throw new FailedLoginException("Password does not match value on record.");
                }
            }
            return createHandlerResult(transformedCredential,
                    new SimplePrincipal(username), null);

        } catch (final IncorrectResultSizeDataAccessException e) {
            if (e.getActualSize() == 0) {
                throw new AccountNotFoundException(username + " not found with SQL query");
            } else {
                throw new FailedLoginException("Multiple records found for " + username);
            }
        } catch (final DataAccessException e) {
            throw new PreventedException("SQL exception while executing query for " + username, e);
        }

    }

    /**
     * Digest encoded password.
     *
     * @param encodedPassword the encoded password
     * @param user          the user retrieved from database
     * @return the digested password
     */
    protected String digestEncodedPassword(final String encodedPassword, final UaUser user) {
        final ConfigurableHashService hashService = new DefaultHashService();

        if (StringUtils.isNotBlank(this.staticSalt)) {
            hashService.setPrivateSalt(ByteSource.Util.bytes(this.staticSalt));
        }
        hashService.setHashAlgorithmName(this.algorithmName);
        // 暂时没有hash迭代器数量可配置
        Long numOfIterations = this.numberOfIterations;
        hashService.setHashIterations(numOfIterations.intValue());
        final HashRequest request = new HashRequest.Builder()
                // 暂时不加盐
//                .setSalt(saltFieldName)
                .setSource(encodedPassword)
                .build();
        return hashService.computeHash(request).toHex();
    }

    /**
     * Gets and sets the real numberOfIterations
     *
     * @return
     */
    public long getAndSetRealNumberOfIterations(final Map<String, Object> values) {
        if (values.containsKey(this.numberOfIterationsFieldName)) {
            final String longAsStr = values.get(this.numberOfIterationsFieldName).toString();
            numberOfIterations = Long.valueOf(longAsStr);
        }
        return numberOfIterations;

    }

    /**
     * Sets static/private salt to be combined with the dynamic salt retrieved
     * from the database. Optional.
     * <p>
     * <p>If using this implementation as part of a password hashing strategy,
     * it might be desirable to configure a private salt.
     * A hash and the salt used to compute it are often stored together.
     * If an attacker is ever able to access the hash (e.g. during password cracking)
     * and it has the full salt value, the attacker has all of the input necessary
     * to try to brute-force crack the hash (source + complete salt).</p>
     * <p>
     * <p>However, if part of the salt is not available to the attacker (because it is not stored with the hash),
     * it is much harder to crack the hash value since the attacker does not have the complete inputs necessary.
     * The privateSalt property exists to satisfy this private-and-not-shared part of the salt.</p>
     * <p>If you configure this attribute, you can obtain this additional very important safety feature.</p>
     *
     * @param staticSalt the static salt
     */
    public final void setStaticSalt(final String staticSalt) {
        this.staticSalt = staticSalt;
    }

    /**
     * Sets salt field name. Default is {@link #DEFAULT_SALT_FIELD}.
     *
     * @param saltFieldName the password field name
     */
    public final void setSaltFieldName(final String saltFieldName) {
        this.saltFieldName = saltFieldName;
    }

    /**
     * Sets number of iterations field name. Default is {@link #DEFAULT_NUM_ITERATIONS_FIELD}.
     *
     * @param numberOfIterationsFieldName the password field name
     */
    public final void setNumberOfIterationsFieldName(final String numberOfIterationsFieldName) {
        this.numberOfIterationsFieldName = numberOfIterationsFieldName;
    }

    /**
     * Sets number of iterations. Default is 0.
     *
     * @param numberOfIterations the number of iterations
     */
    public final void setNumberOfIterations(final long numberOfIterations) {
        this.numberOfIterations = numberOfIterations;
    }

    public String getAlgorithmName() {
        return algorithmName;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public UserAuthenticationDao getUserAuthenticationDao() {
        return userAuthenticationDao;
    }

    public void setUserAuthenticationDao(UserAuthenticationDao userAuthenticationDao) {
        this.userAuthenticationDao = userAuthenticationDao;
    }
}
