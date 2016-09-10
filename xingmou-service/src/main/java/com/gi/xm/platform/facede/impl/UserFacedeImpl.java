
package com.gi.xm.platform.facede.impl;

import java.util.List;
import java.util.Date;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import com.gi.xm.platform.biz.UserBiz;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;

import com.gi.xm.platform.view.UserInfo;
import com.gi.xm.platform.view.UserQueryInfo;


import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.User;
import com.gi.xm.platform.query.UserQuery;


import com.gi.xm.platform.facede.UserFacede;
import com.gi.xm.platform.facede.convertor.UserConvertor;
import com.gi.xm.platform.facede.convertor.MessageConvertor;

@Service
public class UserFacedeImpl implements UserFacede {

	@Autowired
	private UserBiz userBiz;
				
	public MessageInfo<Integer> deleteUser(Long id){
		
		Message<Integer> message  = userBiz.deleteUser(id);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Long> createUser(UserInfo userInfo){
		
		User user = UserConvertor.toUser(userInfo);
		Message<Long> message  =  userBiz.createUser( user );
		MessageInfo<Long> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateUser(UserInfo userInfo){
		
		User user = UserConvertor.toUser(userInfo);
		Message<Integer> message  =  userBiz.updateUser( user );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		public MessageInfo<Integer> changeStatus(
			Long id,
			String status,
			String operatorId){
			
		Message<Integer> message  = userBiz.changeStatus(id,status,operatorId);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		@Cacheable(value = "userInfo",keyGenerator = "wiselyKeyGenerator")
	public MessageInfo<UserInfo> getUser( Long id ){
		
		Message<User> message  = userBiz.getUser( id );
		MessageInfo<UserInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		UserInfo userInfo = UserConvertor.toUserInfo(message.getData());
		messageInfo.setData(userInfo);
		return messageInfo;
	}

    @Cacheable(value = "userInfo",keyGenerator = "wiselyKeyGenerator")
    public MessageInfo<List<UserInfo>> getAllUser(){
	
		Message<List<User>> message  = userBiz.getAllUser();
		MessageInfo<List<UserInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<UserInfo> userInfoList = UserConvertor.toUserInfoList(message.getData());
		messageInfo.setData(userInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<UserInfo>> queryUser(UserQueryInfo userQueryInfo) {
		UserQuery userQuery = UserConvertor.toUserQuery(userQueryInfo);
		Message<QueryResult<User>> message = userBiz.queryUser(userQuery);
		MessageInfo<QueryResultInfo<UserInfo>> messageInfo = new MessageInfo<QueryResultInfo<UserInfo>>();
		QueryResultInfo<UserInfo> queryResultInfo = UserConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
	
}