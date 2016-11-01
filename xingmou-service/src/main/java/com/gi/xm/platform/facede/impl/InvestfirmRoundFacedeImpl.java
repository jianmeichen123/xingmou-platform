
package com.gi.xm.platform.facede.impl;

import java.util.List;
import java.util.Date;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import com.gi.xm.platform.biz.InvestfirmRoundBiz;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;

import com.gi.xm.platform.view.InvestfirmRoundInfo;
import com.gi.xm.platform.view.InvestfirmRoundQueryInfo;


import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.InvestfirmRound;
import com.gi.xm.platform.query.InvestfirmRoundQuery;


import com.gi.xm.platform.facede.InvestfirmRoundFacede;
import com.gi.xm.platform.facede.convertor.InvestfirmRoundConvertor;
import com.gi.xm.platform.facede.convertor.MessageConvertor;

@Service
public class InvestfirmRoundFacedeImpl implements InvestfirmRoundFacede {

	@Autowired
	private InvestfirmRoundBiz investfirmRoundBiz;
				
	public MessageInfo<Integer> deleteInvestfirmRound(Long id){
		
		Message<Integer> message  = investfirmRoundBiz.deleteInvestfirmRound(id);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Long> createInvestfirmRound(InvestfirmRoundInfo investfirmRoundInfo){
		
		InvestfirmRound investfirmRound = InvestfirmRoundConvertor.toInvestfirmRound(investfirmRoundInfo);
		Message<Long> message  =  investfirmRoundBiz.createInvestfirmRound( investfirmRound );
		MessageInfo<Long> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateInvestfirmRound(InvestfirmRoundInfo investfirmRoundInfo){
		
		InvestfirmRound investfirmRound = InvestfirmRoundConvertor.toInvestfirmRound(investfirmRoundInfo);
		Message<Integer> message  =  investfirmRoundBiz.updateInvestfirmRound( investfirmRound );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}

	public MessageInfo<InvestfirmRoundInfo> getInvestfirmRound( Long id ){
		
		Message<InvestfirmRound> message  = investfirmRoundBiz.getInvestfirmRound( id );
		MessageInfo<InvestfirmRoundInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		InvestfirmRoundInfo investfirmRoundInfo = InvestfirmRoundConvertor.toInvestfirmRoundInfo(message.getData());
		messageInfo.setData(investfirmRoundInfo);
		return messageInfo;
	}

    public MessageInfo<List<InvestfirmRoundInfo>> getAllInvestfirmRound(){
	
		Message<List<InvestfirmRound>> message  = investfirmRoundBiz.getAllInvestfirmRound();
		MessageInfo<List<InvestfirmRoundInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<InvestfirmRoundInfo> investfirmRoundInfoList = InvestfirmRoundConvertor.toInvestfirmRoundInfoList(message.getData());
		messageInfo.setData(investfirmRoundInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<InvestfirmRoundInfo>> queryInvestfirmRound(InvestfirmRoundQueryInfo investfirmRoundQueryInfo) {
		InvestfirmRoundQuery investfirmRoundQuery = InvestfirmRoundConvertor.toInvestfirmRoundQuery(investfirmRoundQueryInfo);
		Message<QueryResult<InvestfirmRound>> message = investfirmRoundBiz.queryInvestfirmRound(investfirmRoundQuery);
		MessageInfo<QueryResultInfo<InvestfirmRoundInfo>> messageInfo = new MessageInfo<QueryResultInfo<InvestfirmRoundInfo>>();
		QueryResultInfo<InvestfirmRoundInfo> queryResultInfo = InvestfirmRoundConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
	public MessageInfo<List<InvestfirmRoundInfo>> getListByInvestfrimId(Integer investfrimId){
	
		Message<List<InvestfirmRound>> message  = investfirmRoundBiz.getListByInvestfrimId(investfrimId);
		MessageInfo<List<InvestfirmRoundInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<InvestfirmRoundInfo> investfirmRoundInfoList = InvestfirmRoundConvertor.toInvestfirmRoundInfoList(message.getData());
		messageInfo.setData(investfirmRoundInfoList);
		return messageInfo;	
	}
		
}