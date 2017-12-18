package com.gi.xm.platform.dao;

import org.apache.ibatis.annotations.Param;

import com.gi.xm.platform.pojo.ExternalUser;

public interface ExternalUserDao {

	
	ExternalUser getUser(@Param("mobile") String mobile);
	
	int insert(ExternalUser externalUser);

	int update(ExternalUser externalUser);
}
