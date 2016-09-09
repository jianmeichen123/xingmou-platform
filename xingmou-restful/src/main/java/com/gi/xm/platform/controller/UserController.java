package com.gi.xm.platform.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.dubbo.config.annotation.Reference;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.UserInfo;
import com.gi.xm.platform.view.UserQueryInfo;
import com.gi.xm.platform.facede.UserFacede;

@Controller
@RequestMapping("user")
public class UserController {

    @Reference
	private UserFacede userFacede;


	@RequestMapping("query")
	@ResponseBody
	public MessageInfo<QueryResultInfo<UserInfo>>  queryUser (UserQueryInfo userQueryInfo) {
		MessageInfo<QueryResultInfo<UserInfo>> resultMessageInfo = userFacede.queryUser(userQueryInfo);
		return resultMessageInfo;
	}

    @RequestMapping("create")
    @ResponseBody
    public MessageInfo<Long> createUser(UserInfo userInfo){
        MessageInfo<Long> messageInfo =  userFacede.createUser(userInfo);
        return messageInfo;
    }

    @RequestMapping("update")
    @ResponseBody
	public MessageInfo<Integer> updateUser(UserInfo userInfo){
		MessageInfo<Integer> messageInfo =  userFacede.updateUser(userInfo);
		return messageInfo;
	}

    @RequestMapping("get")
    @ResponseBody
	public MessageInfo<UserInfo> getUser( Long id ){
		MessageInfo<UserInfo> messageInfo =  userFacede.getUser(id);
		return messageInfo;
	}

    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<UserInfo>> getAllUser(){
		MessageInfo<List<UserInfo>>  messageInfo = userFacede.getAllUser();
		return messageInfo;
	}


	
}
