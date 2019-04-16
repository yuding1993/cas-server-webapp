package org.jasig.cas.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "ua_resource")
public class UaResourceModel implements Serializable {
	
	private String clientCode;
    /**
     * id
     */
    @Id
    private String id;

    /**
     * 子系统id
     */
    @Column(name = "client_id")
    private String clientId;

    /**
     * 父id
     */
    private String pid;

    /**
     * 资源层级，根节点为0，其他依次类推
     */
    @Column(name = "node_level")
    private Integer nodeLevel;

    /**
     * 资源名称
     */
    @Column(name = "resource_name")
    private String resourceName;

    /**
     * 资源描述
     */
    @Column(name = "resource_desc")
    private String resourceDesc;

    /**
     * 资源类型 1- 模块名称 2 - 菜单名称 3 - 一般资源
     */
    @Column(name = "resource_type")
    private String resourceType;

    /**
     * 资源排序
     */
    @Column(name = "resource_order")
    private String resourceOrder;

    /**
     * 资源路径
     */
    @Column(name = "resource_url")
    private String resourceUrl;

    /**
     * 图标
     */
    @Column(name = "resource_icon")
    private String resourceIcon;

    /**
     * 资源所属模块
     */
    @Column(name = "module_id")
    private String moduleId;

    /**
     * 打开类型 0 - 当前窗口 1 - 新窗口
     */
    @Column(name = "view_type")
    private String viewType;

    /**
     * 是否有效 0 - 无效 1 -  有效
     */
    @Column(name = "is_valid")
    private String isValid;

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
     * 获取子系统id
     *
     * @return client_id - 子系统id
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * 设置子系统id
     *
     * @param clientId 子系统id
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /**
     * 获取父id
     *
     * @return pid - 父id
     */
    public String getPid() {
        return pid;
    }

    /**
     * 设置父id
     *
     * @param pid 父id
     */
    public void setPid(String pid) {
        this.pid = pid;
    }

    /**
     * 获取资源层级，根节点为0，其他依次类推
     *
     * @return node_level - 资源层级，根节点为0，其他依次类推
     */
    public Integer getNodeLevel() {
        return nodeLevel;
    }

    /**
     * 设置资源层级，根节点为0，其他依次类推
     *
     * @param nodeLevel 资源层级，根节点为0，其他依次类推
     */
    public void setNodeLevel(Integer nodeLevel) {
        this.nodeLevel = nodeLevel;
    }

    /**
     * 获取资源名称
     *
     * @return resource_name - 资源名称
     */
    public String getResourceName() {
        return resourceName;
    }

    /**
     * 设置资源名称
     *
     * @param resourceName 资源名称
     */
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    /**
     * 获取资源描述
     *
     * @return resource_desc - 资源描述
     */
    public String getResourceDesc() {
        return resourceDesc;
    }

    /**
     * 设置资源描述
     *
     * @param resourceDesc 资源描述
     */
    public void setResourceDesc(String resourceDesc) {
        this.resourceDesc = resourceDesc;
    }

    /**
     * 获取资源类型 1- 模块名称 2 - 菜单名称 3 - 一般资源
     *
     * @return resource_type - 资源类型 1- 模块名称 2 - 菜单名称 3 - 一般资源
     */
    public String getResourceType() {
        return resourceType;
    }

    /**
     * 设置资源类型 1- 模块名称 2 - 菜单名称 3 - 一般资源
     *
     * @param resourceType 资源类型 1- 模块名称 2 - 菜单名称 3 - 一般资源
     */
    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    /**
     * 获取资源排序
     *
     * @return resource_order - 资源排序
     */
    public String getResourceOrder() {
        return resourceOrder;
    }

    /**
     * 设置资源排序
     *
     * @param resourceOrder 资源排序
     */
    public void setResourceOrder(String resourceOrder) {
        this.resourceOrder = resourceOrder;
    }

    /**
     * 获取资源路径
     *
     * @return resource_url - 资源路径
     */
    public String getResourceUrl() {
        return resourceUrl;
    }

    /**
     * 设置资源路径
     *
     * @param resourceUrl 资源路径
     */
    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    /**
     * 获取图标
     *
     * @return resource_icon - 图标
     */
    public String getResourceIcon() {
        return resourceIcon;
    }

    /**
     * 设置图标
     *
     * @param resourceIcon 图标
     */
    public void setResourceIcon(String resourceIcon) {
        this.resourceIcon = resourceIcon;
    }

    /**
     * 获取资源所属模块
     *
     * @return module_id - 资源所属模块
     */
    public String getModuleId() {
        return moduleId;
    }

    /**
     * 设置资源所属模块
     *
     * @param moduleId 资源所属模块
     */
    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    /**
     * 获取打开类型 0 - 当前窗口 1 - 新窗口
     *
     * @return view_type - 打开类型 0 - 当前窗口 1 - 新窗口
     */
    public String getViewType() {
        return viewType;
    }

    /**
     * 设置打开类型 0 - 当前窗口 1 - 新窗口
     *
     * @param viewType 打开类型 0 - 当前窗口 1 - 新窗口
     */
    public void setViewType(String viewType) {
        this.viewType = viewType;
    }

    /**
     * 获取是否有效 0 - 无效 1 -  有效
     *
     * @return is_valid - 是否有效 0 - 无效 1 -  有效
     */
    public String getIsValid() {
        return isValid;
    }

    /**
     * 设置是否有效 0 - 无效 1 -  有效
     *
     * @param isValid 是否有效 0 - 无效 1 -  有效
     */
    public void setIsValid(String isValid) {
        this.isValid = isValid;
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

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}
}