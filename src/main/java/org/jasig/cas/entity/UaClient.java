package org.jasig.cas.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "ua_client")
public class UaClient implements Serializable {
    /**
     * id
     */
    @Id
    private String id;

    /**
     * 项目标识
     */
    @Column(name = "client_code")
    private String clientCode;

    /**
     * 项目名称
     */
    @Column(name = "client_name")
    private String clientName;

    @Column(name = "client_url")
    private String clientUrl;

    /**
     * 客户端状态  0 - 停用 1 - 正常 
     */
    @Column(name = "client_status")
    private String clientStatus;

    /**
     * 项目类型 1 - 前台 2 - 后台
     */
    @Column(name = "client_type")
    private String clientType;

    /**
     * 客户端描述
     */
    @Column(name = "client_desc")
    private String clientDesc;

    @Column(name = "client_language")
    private String clientLanguage;

    /**
     * 版本
     */
    private String version;

    /**
     * 备注
     */
    private String note;

    /**
     * 项目加入时间
     */
    @Column(name = "crt_date")
    private Date crtDate;

    /**
     * 更新时间
     */
    @Column(name = "upd_date")
    private Date updDate;

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

    /**
     * 获取id
     *
     * @return id - id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取项目标识
     *
     * @return client_code - 项目标识
     */
    public String getClientCode() {
        return clientCode;
    }

    /**
     * 设置项目标识
     *
     * @param clientCode 项目标识
     */
    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    /**
     * 获取项目名称
     *
     * @return client_name - 项目名称
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * 设置项目名称
     *
     * @param clientName 项目名称
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * @return client_url
     */
    public String getClientUrl() {
        return clientUrl;
    }

    /**
     * @param clientUrl
     */
    public void setClientUrl(String clientUrl) {
        this.clientUrl = clientUrl;
    }

    /**
     * 获取客户端状态  0 - 停用 1 - 正常 
     *
     * @return client_status - 客户端状态  0 - 停用 1 - 正常 
     */
    public String getClientStatus() {
        return clientStatus;
    }

    /**
     * 设置客户端状态  0 - 停用 1 - 正常 
     *
     * @param clientStatus 客户端状态  0 - 停用 1 - 正常 
     */
    public void setClientStatus(String clientStatus) {
        this.clientStatus = clientStatus;
    }

    /**
     * 获取项目类型 1 - 前台 2 - 后台
     *
     * @return client_type - 项目类型 1 - 前台 2 - 后台
     */
    public String getClientType() {
        return clientType;
    }

    /**
     * 设置项目类型 1 - 前台 2 - 后台
     *
     * @param clientType 项目类型 1 - 前台 2 - 后台
     */
    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    /**
     * 获取客户端描述
     *
     * @return client_desc - 客户端描述
     */
    public String getClientDesc() {
        return clientDesc;
    }

    /**
     * 设置客户端描述
     *
     * @param clientDesc 客户端描述
     */
    public void setClientDesc(String clientDesc) {
        this.clientDesc = clientDesc;
    }

    /**
     * @return client_language
     */
    public String getClientLanguage() {
        return clientLanguage;
    }

    /**
     * @param clientLanguage
     */
    public void setClientLanguage(String clientLanguage) {
        this.clientLanguage = clientLanguage;
    }

    /**
     * 获取版本
     *
     * @return version - 版本
     */
    public String getVersion() {
        return version;
    }

    /**
     * 设置版本
     *
     * @param version 版本
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * 获取备注
     *
     * @return note - 备注
     */
    public String getNote() {
        return note;
    }

    /**
     * 设置备注
     *
     * @param note 备注
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * 获取项目加入时间
     *
     * @return crt_date - 项目加入时间
     */
    public Date getCrtDate() {
        return crtDate;
    }

    /**
     * 设置项目加入时间
     *
     * @param crtDate 项目加入时间
     */
    public void setCrtDate(Date crtDate) {
        this.crtDate = crtDate;
    }

    /**
     * 获取更新时间
     *
     * @return upd_date - 更新时间
     */
    public Date getUpdDate() {
        return updDate;
    }

    /**
     * 设置更新时间
     *
     * @param updDate 更新时间
     */
    public void setUpdDate(Date updDate) {
        this.updDate = updDate;
    }

    /**
     * 获取扩展
     *
     * @return ext1 - 扩展
     */
    public String getExt1() {
        return ext1;
    }

    /**
     * 设置扩展
     *
     * @param ext1 扩展
     */
    public void setExt1(String ext1) {
        this.ext1 = ext1;
    }

    /**
     * 获取扩展
     *
     * @return ext2 - 扩展
     */
    public String getExt2() {
        return ext2;
    }

    /**
     * 设置扩展
     *
     * @param ext2 扩展
     */
    public void setExt2(String ext2) {
        this.ext2 = ext2;
    }

    /**
     * 获取扩展
     *
     * @return ext3 - 扩展
     */
    public String getExt3() {
        return ext3;
    }

    /**
     * 设置扩展
     *
     * @param ext3 扩展
     */
    public void setExt3(String ext3) {
        this.ext3 = ext3;
    }

    /**
     * 获取扩展
     *
     * @return ext4 - 扩展
     */
    public String getExt4() {
        return ext4;
    }

    /**
     * 设置扩展
     *
     * @param ext4 扩展
     */
    public void setExt4(String ext4) {
        this.ext4 = ext4;
    }

    /**
     * 获取扩展
     *
     * @return ext5 - 扩展
     */
    public String getExt5() {
        return ext5;
    }

    /**
     * 设置扩展
     *
     * @param ext5 扩展
     */
    public void setExt5(String ext5) {
        this.ext5 = ext5;
    }
}