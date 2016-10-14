
package com.gi.xm.platform.facede.impl;

import java.util.List;
import java.util.Date;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import com.gi.xm.platform.biz.InvestorAreasBiz;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;

import com.gi.xm.platform.view.InvestorAreasInfo;
import com.gi.xm.platform.view.InvestorAreasQueryInfo;


import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.InvestorAreas;
import com.gi.xm.platform.query.InvestorAreasQuery;


import com.gi.xm.platform.facede.InvestorAreasFacede;
import com.gi.xm.platform.facede.convertor.InvestorAreasConvertor;
import com.gi.xm.platform.facede.convertor.MessageConvertor;

@Service
public class InvestorAreasFacedeImpl implements InvestorAreasFacede {

	@Autowired
	private InvestorAreasBiz investorAreasBiz;
				
	public MessageInfo<Integer> deleteInvestorAreas(Long id){
		
		Message<Integer> message  = investorAreasBiz.deleteInvestorAreas(id);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Long> createInvestorAreas(InvestorAreasInfo investorAreasInfo){
		
		InvestorAreas investorAreas = InvestorAreasConvertor.toInvestorAreas(investorAreasInfo);
		Message<Long> message  =  investorAreasBiz.createInvestorAreas( investorAreas );
		MessageInfo<Long> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateInvestorAreas(InvestorAreasInfo investorAreasInfo){
		
		InvestorAreas investorAreas = InvestorAreasConvertor.toInvestorAreas(investorAreasInfo);
		Message<Integer> message  =  investorAreasBiz.updateInvestorAreas( investorAreas );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		@Cacheable(value = "investorAreasInfo",keyGenerator = "wiselyKeyGenerator")
	public MessageInfo<InvestorAreasInfo> getInvestorAreas( Long id ){
		
		Message<InvestorAreas> message  = investorAreasBiz.getInvestorAreas( id );
		MessageInfo<InvestorAreasInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		InvestorAreasInfo investorAreasInfo = InvestorAreasConvertor.toInvestorAreasInfo(message.getData());
		messageInfo.setData(investorAreasInfo);
		return messageInfo;
	}

    @Cacheable(value = "investorAreasInfo",keyGenerator = "wiselyKeyGenerator")
    public MessageInfo<List<InvestorAreasInfo>> getAllInvestorAreas(){
	
		Message<List<InvestorAreas>> message  = investorAreasBiz.getAllInvestorAreas();
		MessageInfo<List<InvestorAreasInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<InvestorAreasInfo> investorAreasInfoList = InvestorAreasConvertor.toInvestorAreasInfoList(message.getData());
		messageInfo.setData(investorAreasInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<InvestorAreasInfo>> queryInvestorAreas(InvestorAreasQueryInfo investorAreasQueryInfo) {
		InvestorAreasQuery investorAreasQuery = InvestorAreasConvertor.toInvestorAreasQuery(investorAreasQueryInfo);
		Message<QueryResult<InvestorAreas>> message = investorAreasBiz.queryInvestorAreas(investorAreasQuery);
		MessageInfo<QueryResultInfo<InvestorAreasInfo>> messageInfo = new MessageInfo<QueryResultInfo<InvestorAreasInfo>>();
		QueryResultInfo<InvestorAreasInfo> queryResultInfo = InvestorAreasConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
	
}