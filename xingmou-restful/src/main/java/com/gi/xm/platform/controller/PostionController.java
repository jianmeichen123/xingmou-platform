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
import com.gi.xm.platform.view.PostionInfo;
import com.gi.xm.platform.view.PostionQueryInfo;
import com.gi.xm.platform.facede.PostionFacede;

@Controller
@RequestMapping("postion")
public class PostionController {

    @Reference
	private PostionFacede postionFacede;


	@RequestMapping("query")
	@ResponseBody
	public MessageInfo<QueryResultInfo<PostionInfo>>  queryPostion (PostionQueryInfo postionQueryInfo) {
		MessageInfo<QueryResultInfo<PostionInfo>> resultMessageInfo = postionFacede.queryPostion(postionQueryInfo);
		return resultMessageInfo;
	}

    @RequestMapping("create")
    @ResponseBody
    public MessageInfo<Long> createPostion(PostionInfo postionInfo){
        MessageInfo<Long> messageInfo =  postionFacede.createPostion(postionInfo);
        return messageInfo;
    }

    @RequestMapping("update")
    @ResponseBody
	public MessageInfo<Integer> updatePostion(PostionInfo postionInfo){
		MessageInfo<Integer> messageInfo =  postionFacede.updatePostion(postionInfo);
		return messageInfo;
	}

    @RequestMapping("get")
    @ResponseBody
	public MessageInfo<PostionInfo> getPostion( Long id ){
		MessageInfo<PostionInfo> messageInfo =  postionFacede.getPostion(id);
		return messageInfo;
	}

    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<PostionInfo>> getAllPostion(){
		MessageInfo<List<PostionInfo>>  messageInfo = postionFacede.getAllPostion();
		return messageInfo;
	}


	
}
