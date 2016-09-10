
package com.gi.xm.platform.facede.impl;

import java.util.List;
import java.util.Date;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import com.gi.xm.platform.biz.PostionBiz;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;

import com.gi.xm.platform.view.PostionInfo;
import com.gi.xm.platform.view.PostionQueryInfo;


import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.Postion;
import com.gi.xm.platform.query.PostionQuery;


import com.gi.xm.platform.facede.PostionFacede;
import com.gi.xm.platform.facede.convertor.PostionConvertor;
import com.gi.xm.platform.facede.convertor.MessageConvertor;

@Service
public class PostionFacedeImpl implements PostionFacede {

	@Autowired
	private PostionBiz postionBiz;
				
	public MessageInfo<Integer> deletePostion(Long id){
		
		Message<Integer> message  = postionBiz.deletePostion(id);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Long> createPostion(PostionInfo postionInfo){
		
		Postion postion = PostionConvertor.toPostion(postionInfo);
		Message<Long> message  =  postionBiz.createPostion( postion );
		MessageInfo<Long> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updatePostion(PostionInfo postionInfo){
		
		Postion postion = PostionConvertor.toPostion(postionInfo);
		Message<Integer> message  =  postionBiz.updatePostion( postion );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		@Cacheable(value = "postionInfo",keyGenerator = "wiselyKeyGenerator")
	public MessageInfo<PostionInfo> getPostion( Long id ){
		
		Message<Postion> message  = postionBiz.getPostion( id );
		MessageInfo<PostionInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		PostionInfo postionInfo = PostionConvertor.toPostionInfo(message.getData());
		messageInfo.setData(postionInfo);
		return messageInfo;
	}

    @Cacheable(value = "postionInfo",keyGenerator = "wiselyKeyGenerator")
    public MessageInfo<List<PostionInfo>> getAllPostion(){
	
		Message<List<Postion>> message  = postionBiz.getAllPostion();
		MessageInfo<List<PostionInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<PostionInfo> postionInfoList = PostionConvertor.toPostionInfoList(message.getData());
		messageInfo.setData(postionInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<PostionInfo>> queryPostion(PostionQueryInfo postionQueryInfo) {
		PostionQuery postionQuery = PostionConvertor.toPostionQuery(postionQueryInfo);
		Message<QueryResult<Postion>> message = postionBiz.queryPostion(postionQuery);
		MessageInfo<QueryResultInfo<PostionInfo>> messageInfo = new MessageInfo<QueryResultInfo<PostionInfo>>();
		QueryResultInfo<PostionInfo> queryResultInfo = PostionConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
	
}