package org.jasig.cas.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class SysOperator {

	/**
     * id
     */
    @Id
    private String id;

    /**
     * 创建者id
     */
    @Column(name = "crt_id")
    private String crtId;

    /**
     * 登录名
     */
    private String username;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 昵称
     */
    private String alias;

    /**
     * 操作员编号
     */
    @Column(name = "operator_no")
    private String operatorNo;

    /**
     * 用户单位类型 
     */
    @Column(name = "operator_type")
    private String operatorType;

    /**
     * 电子邮件
     */
    private String email;

    /**
     * 身份证号
     */
    private String idnumber;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 性别 性别 1 - 男 2 - 女 3 - 未知
     */
    private String sex;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 办公电话
     */
    @Column(name = "office_tel")
    private String officeTel;

    /**
     * 家庭电话
     */
    @Column(name = "home_tel")
    private String homeTel;

    /**
     * 是否有效 0 - 无效 1 -有效
     */
    @Column(name = "is_valid")
    private String isValid;

    /**
     * 密码找回问题
     */
    private String question;

    /**
     * 密码找回答案
     */
    private String answer;

    /**
     * 注册时间
     */
    @Column(name = "reg_time")
    private Date regTime;

    /**
     * 最新一次信息修改时间
     */
    @Column(name = "last_update")
    private Date lastUpdate;

    /**
     * 上次登录时间
     */
    @Column(name = "last_time")
    private Date lastTime;

    /**
     * 上次登录IP
     */
    @Column(name = "last_ip")
    private String lastIp;

    /**
     * 访问次数
     */
    @Column(name = "visit_count")
    private Integer visitCount;

    /**
     * QQ
     */
    private String qq;

    /**
     * 用户自设欢迎词
     */
    private String welcome;

    /**
     * 备注
     */
    private String note;

    /**
     * 扩展
     */
    private String ext1;

    /**
     * 扩展
     */
    private String ext2;

    /**
     * 扩展
     */
    private String ext3;

    /**
     * 扩展
     */
    private String ext4;

    /**
     * 扩展
     */
    private String ext5;

    private static final long serialVersionUID = 1L;

	private String groupId;

	private String groupName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCrtId() {
		return crtId;
	}

	public void setCrtId(String crtId) {
		this.crtId = crtId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getOperatorNo() {
		return operatorNo;
	}

	public void setOperatorNo(String operatorNo) {
		this.operatorNo = operatorNo;
	}

	public String getOperatorType() {
		return operatorType;
	}

	public void setOperatorType(String operatorType) {
		this.operatorType = operatorType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdnumber() {
		return idnumber;
	}

	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getOfficeTel() {
		return officeTel;
	}

	public void setOfficeTel(String officeTel) {
		this.officeTel = officeTel;
	}

	public String getHomeTel() {
		return homeTel;
	}

	public void setHomeTel(String homeTel) {
		this.homeTel = homeTel;
	}

	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Date getRegTime() {
		return regTime;
	}

	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Date getLastTime() {
		return lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

	public String getLastIp() {
		return lastIp;
	}

	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}

	public Integer getVisitCount() {
		return visitCount;
	}

	public void setVisitCount(Integer visitCount) {
		this.visitCount = visitCount;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getWelcome() {
		return welcome;
	}

	public void setWelcome(String welcome) {
		this.welcome = welcome;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
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

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

}
