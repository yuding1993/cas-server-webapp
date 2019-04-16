package org.jasig.cas.dao;


import org.jasig.cas.entity.UaUser;

public interface UserAuthenticationDao {

	UaUser getPerson(String userName);
	
}
