package org.jasig.cas.dao.impl;

import org.jasig.cas.dao.GVPersonDAO;
import org.jasig.cas.entity.SysOperator;
import org.jasig.cas.entity.UaResourceModel;
import org.jasig.cas.entity.UaUser;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;
import java.util.Map;

public class GVPersonDAOImpl extends SqlSessionDaoSupport implements GVPersonDAO {

	public List<SysOperator> getAPersonInfoByUsername(String username) {
		return  this.getSqlSession().selectList("PERSON.getAPersonByUsername",username);
	}

	public List<UaUser> getUPersonInfoByUsername(String username) {
		return  this.getSqlSession().selectList("PERSON.getUPersonByUsername",username);
	}

	public List<String> getUPersonRolesIdByUsername(String username) {
		return this.getSqlSession().selectList("PERSON.getURolesIdByUsername", username);
	}

	public List<String> getUpersonDistinctResourceId(List<String> roleList) {
		return this.getSqlSession().selectList("PERSON.getUpersonDistinctResourceId", roleList);
	}

	public List<UaResourceModel> getUPersonResours(List<String> distinctResourceids) {
		return this.getSqlSession().selectList("PERSON.getUPersonResours", distinctResourceids);
	}

	public List<Map<String,Object>> getUpersonRolesByUsername(String username) {
		return this.getSqlSession().selectList("PERSON.getUpersonRolesByUsername", username);
	}
	
}
