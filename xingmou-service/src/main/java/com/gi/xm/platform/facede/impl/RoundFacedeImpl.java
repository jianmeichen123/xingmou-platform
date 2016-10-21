
package com.gi.xm.platform.facede.impl;

import java.util.List;
import java.util.Date;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import com.gi.xm.platform.biz.RoundBiz;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;

import com.gi.xm.platform.view.RoundInfo;
import com.gi.xm.platform.view.RoundQueryInfo;


import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.Round;
import com.gi.xm.platform.query.RoundQuery;


import com.gi.xm.platform.facede.RoundFacede;
import com.gi.xm.platform.facede.convertor.RoundConvertor;
import com.gi.xm.platform.facede.convertor.MessageConvertor;

@Service
public class RoundFacedeImpl implements RoundFacede {

	@Autowired
	private RoundBiz roundBiz;
				
	public MessageInfo<Integer> deleteRound(Integer id){
		
		Message<Integer> message  = roundBiz.deleteRound(id);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Integer> createRound(RoundInfo roundInfo){
		
		Round round = RoundConvertor.toRound(roundInfo);
		Message<Integer> message  =  roundBiz.createRound( round );
		MessageInfo<Integer> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateRound(RoundInfo roundInfo){
		
		Round round = RoundConvertor.toRound(roundInfo);
		Message<Integer> message  =  roundBiz.updateRound( round );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		@Cacheable(value = "roundInfo",keyGenerator = "wiselyKeyGenerator")
	public MessageInfo<RoundInfo> getRound( Integer id ){
		
		Message<Round> message  = roundBiz.getRound( id );
		MessageInfo<RoundInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		RoundInfo roundInfo = RoundConvertor.toRoundInfo(message.getData());
		messageInfo.setData(roundInfo);
		return messageInfo;
	}

    public MessageInfo<List<RoundInfo>> getAllRound(){
	
		Message<List<Round>> message  = roundBiz.getAllRound();
		MessageInfo<List<RoundInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<RoundInfo> roundInfoList = RoundConvertor.toRoundInfoList(message.getData());
		messageInfo.setData(roundInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<RoundInfo>> queryRound(RoundQueryInfo roundQueryInfo) {
		RoundQuery roundQuery = RoundConvertor.toRoundQuery(roundQueryInfo);
		Message<QueryResult<Round>> message = roundBiz.queryRound(roundQuery);
		MessageInfo<QueryResultInfo<RoundInfo>> messageInfo = new MessageInfo<QueryResultInfo<RoundInfo>>();
		QueryResultInfo<RoundInfo> queryResultInfo = RoundConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}

	@Override
	public MessageInfo<List<RoundInfo>> selectByTypeParentId(Integer type, Integer parentId) {

		Message<List<Round>> message  = roundBiz.getByTypeParentId(type, parentId);
		MessageInfo<List<RoundInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<RoundInfo> roundInfoList = RoundConvertor.toRoundInfoList(message.getData());
		messageInfo.setData(roundInfoList);
		return messageInfo;
	}


}