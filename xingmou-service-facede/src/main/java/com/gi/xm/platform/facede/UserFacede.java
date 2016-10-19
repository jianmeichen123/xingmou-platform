package com.gi.xm.platform.facede;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.UserInfo;
import com.gi.xm.platform.view.UserQueryInfo;

public interface UserFacede {
	MessageInfo<Integer> deleteUser(Long id);
		
    MessageInfo<Long> createUser(UserInfo userInfo);
		
	MessageInfo<Integer> updateUser(UserInfo userInfo);
			
	MessageInfo<Integer> changeStatus(Long id, String status, String operatorId);
		
	MessageInfo<UserInfo> getUser(Long id);
		
    MessageInfo<List<UserInfo>> getAllUser();
			
    MessageInfo<QueryResultInfo<UserInfo>> queryUser(UserQueryInfo userQueryInfo);
	
	

}