package org.jasig.cas.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class UaUser {

	@Id
    private String id;
    /**
     * 登录名
     */
    @Column(name = "login_name")
    private String loginName;

    /**
     * 登录密码
     */
    @Column(name = "login_password")
    private String loginPassword;

    /**
     * 操作员姓名
     */
    @Column(name = "op_name")
    private String opName;

    /**
     * 登录类型 0、登录名和密码登录; 1、电子口岸介质登录
     */
    @Column(name = "login_type")
    private String loginType;

    /**
     * 账号状态 0 - 正常 1 - 停用
     */
    @Column(name = "account_status")
    private String accountStatus;

    /**
     * 账号类型 1、企业管理员; 3、企业操作员 4、内部用户
     */
    @Column(name = "account_type")
    private String accountType;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 手机号验证状态 0、未验证; 1、已验证
     */
    @Column(name = "mobile_stucd")
    private String mobileStucd;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 邮箱验证状态 0、未验证; 1、已验证
     */
    @Column(name = "email_stucd")
    private String emailStucd;

    /**
     * 用户证件类型 01:身份证;
06:护照; 07:外国人居留证; 08:港澳居民来往内地通行证; 09:台湾同胞来往内地通行证;
     */
    @Column(name = "iddoc_typecd")
    private String iddocTypecd;

    /**
     * 用户证件号码
     */
    @Column(name = "iddoc_type")
    private String iddocType;
    
    /**
     * 组织机构id
     */
    @Column(name = "org_id")
    private String orgId;

    /**
     * 统一社会信用代码
     */
    @Column(name = "social_credit_code")
    private String socialCreditCode;

    /**
     * 组织机构代码
     */
    @Column(name = "org_code")
    private String orgCode;

    /**
     * 企业名称
     */
    @Column(name = "etps_name")
    private String etpsName;

    /**
     * 企业地址
     */
    @Column(name = "etps_address")
    private String etpsAddress;

    /**
     * 企业身份核验状态 0、未认证;1、已认证
     */
    @Column(name = "etps_vrffy_stucd")
    private String etpsVrffyStucd;

    /**
     * 法人姓名
     */
    @Column(name = "correp_name")
    private String correpName;

    /**
     * 海关 10 位注册编号,多个编号以 $做区分
     */
    @Column(name = "cus_reg_no")
    private String cusRegNo;
    
    /**
     * 法人 用户证件类型 01:身份证;
06:护照; 07:外国人居留证; 08:港澳居民来往内地通行证; 09:台湾同胞来往内地通行证;
     */
    @Column(name = "iddoc_typecd")
    private String correpIddocTypecd;

    /**
     * 法人  用户证件号码
     */
    @Column(name = "iddoc_type")
    private String correpIddocType;

    /**
     * 绑定的介质号集合
     */
    private String cards;
    
    /*
     * ic卡密码
     */
    private String ext1;
    
    /*
     * 国检邮箱
     */
    private String ext2;

    private String ext3;

    private String ext4;

    private String ext5;
    
    /**
     * ic卡号
     */
    @Column(name = "ic_number")
    private String icNumber;

    /**
     * 操作员卡证书编号
     */
    @Column(name = "cert_number")
    private String certNumber;

    /**
     * 报检账号
     */
    @Column(name = "inspection_account")
    private String inspectionAccount;

    /**
     * 报检密码
     */
    @Column(name = "inspection_password")
    private String inspectionPassword;
    
    /**
     * 企业用户编号(向海关申请的企业ID)
     */
    @Column(name = "company_number")
    private String companyNumber;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getOpName() {
		return opName;
	}

	public void setOpName(String opName) {
		this.opName = opName;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMobileStucd() {
		return mobileStucd;
	}

	public void setMobileStucd(String mobileStucd) {
		this.mobileStucd = mobileStucd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailStucd() {
		return emailStucd;
	}

	public void setEmailStucd(String emailStucd) {
		this.emailStucd = emailStucd;
	}

	public String getIddocTypecd() {
		return iddocTypecd;
	}

	public void setIddocTypecd(String iddocTypecd) {
		this.iddocTypecd = iddocTypecd;
	}

	public String getIddocType() {
		return iddocType;
	}

	public void setIddocType(String iddocType) {
		this.iddocType = iddocType;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getSocialCreditCode() {
		return socialCreditCode;
	}

	public void setSocialCreditCode(String socialCreditCode) {
		this.socialCreditCode = socialCreditCode;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getEtpsName() {
		return etpsName;
	}

	public void setEtpsName(String etpsName) {
		this.etpsName = etpsName;
	}

	public String getEtpsAddress() {
		return etpsAddress;
	}

	public void setEtpsAddress(String etpsAddress) {
		this.etpsAddress = etpsAddress;
	}

	public String getEtpsVrffyStucd() {
		return etpsVrffyStucd;
	}

	public void setEtpsVrffyStucd(String etpsVrffyStucd) {
		this.etpsVrffyStucd = etpsVrffyStucd;
	}

	public String getCorrepName() {
		return correpName;
	}

	public void setCorrepName(String correpName) {
		this.correpName = correpName;
	}

	public String getCorrepIddocTypecd() {
		return correpIddocTypecd;
	}

	public void setCorrepIddocTypecd(String correpIddocTypecd) {
		this.correpIddocTypecd = correpIddocTypecd;
	}

	public String getCorrepIddocType() {
		return correpIddocType;
	}

	public void setCorrepIddocType(String correpIddocType) {
		this.correpIddocType = correpIddocType;
	}

	public String getCusRegNo() {
		return cusRegNo;
	}

	public void setCusRegNo(String cusRegNo) {
		this.cusRegNo = cusRegNo;
	}

	public String getCards() {
		return cards;
	}

	public void setCards(String cards) {
		this.cards = cards;
	}

	public String getExt1() {
		return ext1;
	}

	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}

	public String getExt2() {
		return ext2;
	}

	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}

	public String getExt3() {
		return ext3;
	}

	public void setExt3(String ext3) {
		this.ext3 = ext3;
	}

	public String getExt4() {
		return ext4;
	}

	public void setExt4(String ext4) {
		this.ext4 = ext4;
	}

	public String getExt5() {
		return ext5;
	}

	public void setExt5(String ext5) {
		this.ext5 = ext5;
	}

	public String getIcNumber() {
		return icNumber;
	}

	public void setIcNumber(String icNumber) {
		this.icNumber = icNumber;
	}

	public String getCertNumber() {
		return certNumber;
	}

	public void setCertNumber(String certNumber) {
		this.certNumber = certNumber;
	}

	public String getInspectionAccount() {
		return inspectionAccount;
	}

	public void setInspectionAccount(String inspectionAccount) {
		this.inspectionAccount = inspectionAccount;
	}

	public String getInspectionPassword() {
		return inspectionPassword;
	}

	public void setInspectionPassword(String inspectionPassword) {
		this.inspectionPassword = inspectionPassword;
	}

	public String getCompanyNumber() {
		return companyNumber;
	}

	public void setCompanyNumber(String companyNumber) {
		this.companyNumber = companyNumber;
	}
}
