package org.jasig.cas.dao.impl;

import org.jasig.cas.dao.UaClientDAO;
import org.jasig.cas.entity.UaClient;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class UaClientDAOImpl extends SqlSessionDaoSupport
        implements UaClientDAO {

    public UaClient getUaClient(String clientCode) {
        return (UaClient) this.getSqlSession().selectOne("CLIENT.getUaClient", clientCode);
    }
}
