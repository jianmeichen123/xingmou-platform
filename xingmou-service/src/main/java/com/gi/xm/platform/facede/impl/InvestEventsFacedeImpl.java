
package com.gi.xm.platform.facede.impl;

import java.util.*;

import com.alibaba.dubbo.config.annotation.Service;
import com.gi.xm.platform.biz.InvestEventsInvestfirmBiz;
import com.gi.xm.platform.facede.InvestEventsInvestfirmFacede;
import com.gi.xm.platform.pojo.InvestEventsInvestfirm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import com.gi.xm.platform.biz.InvestEventsBiz;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;

import com.gi.xm.platform.view.InvestEventsInfo;
import com.gi.xm.platform.view.InvestEventsQueryInfo;


import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.InvestEvents;
import com.gi.xm.platform.query.InvestEventsQuery;


import com.gi.xm.platform.facede.InvestEventsFacede;
import com.gi.xm.platform.facede.convertor.InvestEventsConvertor;
import com.gi.xm.platform.facede.convertor.MessageConvertor;

@Service
public class InvestEventsFacedeImpl implements InvestEventsFacede {

	@Autowired
	private InvestEventsBiz investEventsBiz;

    @Autowired
    private InvestEventsInvestfirmBiz investEventsInvestfirmBiz;
				
	public MessageInfo<Integer> deleteInvestEvents(Long id){
		
		Message<Integer> message  = investEventsBiz.deleteInvestEvents(id);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Long> createInvestEvents(InvestEventsInfo investEventsInfo){
		
		InvestEvents investEvents = InvestEventsConvertor.toInvestEvents(investEventsInfo);
		Message<Long> message  =  investEventsBiz.createInvestEvents( investEvents );
		MessageInfo<Long> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateInvestEvents(InvestEventsInfo investEventsInfo){
		
		InvestEvents investEvents = InvestEventsConvertor.toInvestEvents(investEventsInfo);
		Message<Integer> message  =  investEventsBiz.updateInvestEvents( investEvents );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		@Cacheable(value = "investEventsInfo",keyGenerator = "wiselyKeyGenerator")
	public MessageInfo<InvestEventsInfo> getInvestEvents( Long id ){
		
		Message<InvestEvents> message  = investEventsBiz.getInvestEvents( id );
		MessageInfo<InvestEventsInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		InvestEventsInfo investEventsInfo = InvestEventsConvertor.toInvestEventsInfo(message.getData());
		messageInfo.setData(investEventsInfo);
		return messageInfo;
	}

    @Cacheable(value = "investEventsInfo",keyGenerator = "wiselyKeyGenerator")
    public MessageInfo<List<InvestEventsInfo>> getAllInvestEvents(){
	
		Message<List<InvestEvents>> message  = investEventsBiz.getAllInvestEvents();
		MessageInfo<List<InvestEventsInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<InvestEventsInfo> investEventsInfoList = InvestEventsConvertor.toInvestEventsInfoList(message.getData());
		messageInfo.setData(investEventsInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<InvestEventsInfo>> queryInvestEvents(InvestEventsQueryInfo investEventsQueryInfo) {
		InvestEventsQuery investEventsQuery = InvestEventsConvertor.toInvestEventsQuery(investEventsQueryInfo);
		Message<QueryResult<InvestEvents>> message = investEventsBiz.queryInvestEvents(investEventsQuery);
		MessageInfo<QueryResultInfo<InvestEventsInfo>> messageInfo = new MessageInfo<QueryResultInfo<InvestEventsInfo>>();
		QueryResultInfo<InvestEventsInfo> queryResultInfo = InvestEventsConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}


}