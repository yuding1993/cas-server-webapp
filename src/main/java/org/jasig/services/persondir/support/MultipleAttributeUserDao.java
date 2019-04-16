package org.jasig.services.persondir.support;

import com.google.gson.Gson;
import org.jasig.cas.dao.GVPersonDAO;
import org.jasig.cas.entity.UaResourceModel;
import org.jasig.cas.entity.UaUser;
import org.jasig.services.persondir.IPersonAttributes;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 扩展用户自定义属性
 * Created by Administrator on 2016/4/30 0030.
 */
public class MultipleAttributeUserDao extends StubPersonAttributeDao {

    private GVPersonDAO gVPersonDAO;

    public GVPersonDAO getgVPersonDAO() {
        return gVPersonDAO;
    }

    public void setgVPersonDAO(GVPersonDAO gVPersonDAO) {
        this.gVPersonDAO = gVPersonDAO;
    }

    @Override
    public IPersonAttributes getPerson(String uid) {
        Map<String, Object> backingMap = new HashMap<String, Object>(16);
        try {
            //获取登录用户基本信息
            this.getPersonCommInfo(uid, backingMap);
            //转换 数据
            Map<String, List<Object>> backingMutiledMap
                    = MultivaluedPersonAttributeUtils.toMultivaluedMap(backingMap);
            IPersonAttributes backingPerson = new AttributeNamedPersonImpl(backingMutiledMap);
            return backingPerson;
        } catch (Exception e) {
            logger.fatal("uid[" + uid + "]", e);
        }
        return null;
    }

    private void getPersonCommInfo(String pricinpaId, Map<String, Object> backingMap) {

        List<UaUser> pmList = this.gVPersonDAO.getUPersonInfoByUsername(pricinpaId);
        if (pmList != null && pmList.size() > 0) {
            UaUser pm = pmList.get(0);
            backingMap.put("uid", pm.getId());
            backingMap.put("login_name", pm.getLoginName());
            backingMap.put("account_status", pm.getAccountStatus());
            backingMap.put("account_type", pm.getAccountType());
            backingMap.put("op_name", pm.getOpName());
            backingMap.put("iddoc_typecd", pm.getIddocTypecd());
            backingMap.put("iddoc_type", pm.getIddocType());
            backingMap.put("mobile", pm.getMobile());
            backingMap.put("mobile_stucd", pm.getMobileStucd());
            backingMap.put("email", pm.getEmail());
            backingMap.put("email_stucd", pm.getEmailStucd());
            backingMap.put("org_id", pm.getOrgId());
            backingMap.put("etps_name", pm.getEtpsName());
            backingMap.put("social_credit_code", pm.getSocialCreditCode());
            backingMap.put("org_code", pm.getOrgCode());
            backingMap.put("etps_address", pm.getEtpsAddress());
            backingMap.put("correp_name", pm.getCorrepName());
            backingMap.put("correp_iddoc_typecd", pm.getCorrepIddocTypecd());
            backingMap.put("correp_iddoc_type", pm.getCorrepIddocType());
            backingMap.put("cus_reg_no", pm.getCusRegNo());
            backingMap.put("cards", pm.getCards());
            backingMap.put("ic_pwd", pm.getExt1());
            backingMap.put("aqsiq_box", pm.getExt2());
            backingMap.put("app_type", pm.getExt3());
            backingMap.put("ic_number", pm.getIcNumber());
            backingMap.put("cert_number", pm.getCertNumber());
            backingMap.put("inspection_account", pm.getInspectionAccount());
            backingMap.put("inspection_password", pm.getInspectionPassword());
            backingMap.put("company_number", pm.getCompanyNumber());

        }
        //获取子平台菜单资源
        List<UaResourceModel> uaResources = null;

        List<String> roleList = this.gVPersonDAO.getUPersonRolesIdByUsername(pricinpaId);
        if (null != roleList && roleList.size() > 0) {
            List<String> distinctResourceids = this.gVPersonDAO.getUpersonDistinctResourceId(roleList);
            if (null != distinctResourceids && distinctResourceids.size() > 0) {
                uaResources = this.gVPersonDAO.getUPersonResours(distinctResourceids);
            }
        }
        Gson gson = new Gson();
        String resourcesJson = gson.toJson(uaResources);

        backingMap.put("ua_resources", resourcesJson);

        //获取用户角色代码
        List<Map<String, Object>> roleNameList = this.gVPersonDAO.getUpersonRolesByUsername(pricinpaId);
        String roleJson = gson.toJson(roleNameList);
        backingMap.put("ua_roles", roleJson);
    }
}
