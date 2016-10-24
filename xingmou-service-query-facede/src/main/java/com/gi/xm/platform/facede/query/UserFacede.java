package com.gi.xm.platform.facede.query;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.UserInfo;
import com.gi.xm.platform.view.UserQueryInfo;

public interface UserFacede {

	MessageInfo<UserInfo> getUser(Long id);
		
    MessageInfo<List<UserInfo>> getAllUser();
			
    MessageInfo<QueryResultInfo<UserInfo>> queryUser(UserQueryInfo userQueryInfo);
	
	

}