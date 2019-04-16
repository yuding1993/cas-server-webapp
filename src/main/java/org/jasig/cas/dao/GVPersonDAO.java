package org.jasig.cas.dao;

import org.jasig.cas.entity.SysOperator;
import org.jasig.cas.entity.UaResourceModel;
import org.jasig.cas.entity.UaUser;

import java.util.List;
import java.util.Map;


public interface GVPersonDAO {

	/**
	 * 后台用户
	 * @param username
	 * @return
	 */
	List<SysOperator> getAPersonInfoByUsername(String username);

	/**
	 * 前台用户
	 * @param username
	 * @return
	 */
	List<UaUser> getUPersonInfoByUsername(String username);

	/**
	 * 前台用户角色
	 * @param username
	 * @return
	 */
	List<String> getUPersonRolesIdByUsername(String username);

	/**
	 * 前台用户唯一资源id
	 * @param roleList
	 * @return
	 */
	List<String> getUpersonDistinctResourceId(List<String> roleList);

	/**
	 * 前台用户菜单信息
	 * @param distinctResourceids
	 * @return
	 */
	List<UaResourceModel> getUPersonResours(List<String> distinctResourceids);

	/**
	 * 前台用户角色代码
	 * @param username
	 * @return
	 */
	List<Map<String,Object>> getUpersonRolesByUsername(String username);

}
