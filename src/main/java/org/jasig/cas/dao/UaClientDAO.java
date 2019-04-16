package org.jasig.cas.dao;

import org.jasig.cas.entity.UaClient;

public interface UaClientDAO {
	
	UaClient getUaClient(String clientCode);

}
