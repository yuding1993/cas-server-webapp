package org.jasig.cas.dao.impl;

import org.jasig.cas.dao.UserAuthenticationDao;
import org.jasig.cas.entity.UaUser;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class UserAuthenticationDaoImpl extends SqlSessionDaoSupport
	implements UserAuthenticationDao {

	public UaUser getPerson(String userName) {
		return (UaUser)this.getSqlSession().selectOne("PERSON.getUPersonByUsername", userName);
	}

	
}
