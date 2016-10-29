
package com.gi.xm.platform.facede.impl;

import java.util.List;
import java.util.Date;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import com.gi.xm.platform.biz.InvestorRoundsBiz;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;

import com.gi.xm.platform.view.InvestorRoundsInfo;
import com.gi.xm.platform.view.InvestorRoundsQueryInfo;


import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.InvestorRounds;
import com.gi.xm.platform.query.InvestorRoundsQuery;


import com.gi.xm.platform.facede.InvestorRoundsFacede;
import com.gi.xm.platform.facede.convertor.InvestorRoundsConvertor;
import com.gi.xm.platform.facede.convertor.MessageConvertor;

@Service
public class InvestorRoundsFacedeImpl implements InvestorRoundsFacede {

	@Autowired
	private InvestorRoundsBiz investorRoundsBiz;
				
	public MessageInfo<Integer> deleteInvestorRounds(Long id){
		
		Message<Integer> message  = investorRoundsBiz.deleteInvestorRounds(id);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Long> createInvestorRounds(InvestorRoundsInfo investorRoundsInfo){
		
		InvestorRounds investorRounds = InvestorRoundsConvertor.toInvestorRounds(investorRoundsInfo);
		Message<Long> message  =  investorRoundsBiz.createInvestorRounds( investorRounds );
		MessageInfo<Long> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateInvestorRounds(InvestorRoundsInfo investorRoundsInfo){
		
		InvestorRounds investorRounds = InvestorRoundsConvertor.toInvestorRounds(investorRoundsInfo);
		Message<Integer> message  =  investorRoundsBiz.updateInvestorRounds( investorRounds );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}

	public MessageInfo<InvestorRoundsInfo> getInvestorRounds( Long id ){
		
		Message<InvestorRounds> message  = investorRoundsBiz.getInvestorRounds( id );
		MessageInfo<InvestorRoundsInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		InvestorRoundsInfo investorRoundsInfo = InvestorRoundsConvertor.toInvestorRoundsInfo(message.getData());
		messageInfo.setData(investorRoundsInfo);
		return messageInfo;
	}

    public MessageInfo<List<InvestorRoundsInfo>> getAllInvestorRounds(){
	
		Message<List<InvestorRounds>> message  = investorRoundsBiz.getAllInvestorRounds();
		MessageInfo<List<InvestorRoundsInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<InvestorRoundsInfo> investorRoundsInfoList = InvestorRoundsConvertor.toInvestorRoundsInfoList(message.getData());
		messageInfo.setData(investorRoundsInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<InvestorRoundsInfo>> queryInvestorRounds(InvestorRoundsQueryInfo investorRoundsQueryInfo) {
		InvestorRoundsQuery investorRoundsQuery = InvestorRoundsConvertor.toInvestorRoundsQuery(investorRoundsQueryInfo);
		Message<QueryResult<InvestorRounds>> message = investorRoundsBiz.queryInvestorRounds(investorRoundsQuery);
		MessageInfo<QueryResultInfo<InvestorRoundsInfo>> messageInfo = new MessageInfo<QueryResultInfo<InvestorRoundsInfo>>();
		QueryResultInfo<InvestorRoundsInfo> queryResultInfo = InvestorRoundsConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
	
}