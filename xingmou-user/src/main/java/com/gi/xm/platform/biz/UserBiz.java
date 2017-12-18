package com.gi.xm.platform.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.xm.platform.dao.ExternalUserDao;
import com.gi.xm.platform.pojo.ExternalUser;

@Service("userBiz")
public class UserBiz {

	
	@Autowired
	private ExternalUserDao externalUserDao;
	
	
	public ExternalUser getUser(String mobile){
		return externalUserDao.getUser(mobile);
	}
	
	public int insert(ExternalUser externalUser){
		return externalUserDao.insert(externalUser);
	}
	
	public int update(ExternalUser externalUser){
		return externalUserDao.update(externalUser);
	}
	
}
