package org.jasig.cas.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "ua_roles")
public class UaRoles implements Serializable {
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
     * 角色名称
     */
    @Column(name = "role_name")
    private String roleName;

    /**
     * 角色描述
     */
    @Column(name = "role_desc")
    private String roleDesc;

    /**
     * 是否有效 0 - 无效 1 - 有效
     */
    @Column(name = "is_valid")
    private String isValid;

    /**
     * 角色等级 1 一级 2 二级 3三级
     */
    @Column(name = "role_level")
    private String roleLevel;

    /**
     * 备注
     */
    private String note;

    /**
     * 拓展
     */
    private String ext1;

    /**
     * 拓展
     */
    private String ext2;

    /**
     * 拓展
     */
    private String ext3;

    /**
     * 拓展
     */
    private String ext4;

    /**
     * 拓展
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
     * 获取角色名称
     *
     * @return role_name - 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置角色名称
     *
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * 获取角色描述
     *
     * @return role_desc - 角色描述
     */
    public String getRoleDesc() {
        return roleDesc;
    }

    /**
     * 设置角色描述
     *
     * @param roleDesc 角色描述
     */
    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    /**
     * 获取是否有效 0 - 无效 1 - 有效
     *
     * @return is_valid - 是否有效 0 - 无效 1 - 有效
     */
    public String getIsValid() {
        return isValid;
    }

    /**
     * 设置是否有效 0 - 无效 1 - 有效
     *
     * @param isValid 是否有效 0 - 无效 1 - 有效
     */
    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }

    /**
     * 获取角色等级 1 一级 2 二级 3三级
     *
     * @return role_level - 角色等级 1 一级 2 二级 3三级
     */
    public String getRoleLevel() {
        return roleLevel;
    }

    /**
     * 设置角色等级 1 一级 2 二级 3三级
     *
     * @param roleLevel 角色等级 1 一级 2 二级 3三级
     */
    public void setRoleLevel(String roleLevel) {
        this.roleLevel = roleLevel;
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
     * 获取拓展
     *
     * @return ext1 - 拓展
     */
    public String getExt1() {
        return ext1;
    }

    /**
     * 设置拓展
     *
     * @param ext1 拓展
     */
    public void setExt1(String ext1) {
        this.ext1 = ext1;
    }

    /**
     * 获取拓展
     *
     * @return ext2 - 拓展
     */
    public String getExt2() {
        return ext2;
    }

    /**
     * 设置拓展
     *
     * @param ext2 拓展
     */
    public void setExt2(String ext2) {
        this.ext2 = ext2;
    }

    /**
     * 获取拓展
     *
     * @return ext3 - 拓展
     */
    public String getExt3() {
        return ext3;
    }

    /**
     * 设置拓展
     *
     * @param ext3 拓展
     */
    public void setExt3(String ext3) {
        this.ext3 = ext3;
    }

    /**
     * 获取拓展
     *
     * @return ext4 - 拓展
     */
    public String getExt4() {
        return ext4;
    }

    /**
     * 设置拓展
     *
     * @param ext4 拓展
     */
    public void setExt4(String ext4) {
        this.ext4 = ext4;
    }

    /**
     * 获取拓展
     *
     * @return ext5 - 拓展
     */
    public String getExt5() {
        return ext5;
    }

    /**
     * 设置拓展
     *
     * @param ext5 拓展
     */
    public void setExt5(String ext5) {
        this.ext5 = ext5;
    }
}