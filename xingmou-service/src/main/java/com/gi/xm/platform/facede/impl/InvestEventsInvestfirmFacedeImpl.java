
package com.gi.xm.platform.facede.impl;

import java.util.List;
import java.util.Date;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import com.gi.xm.platform.biz.InvestEventsInvestfirmBiz;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;

import com.gi.xm.platform.view.InvestEventsInvestfirmInfo;
import com.gi.xm.platform.view.InvestEventsInvestfirmQueryInfo;


import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.InvestEventsInvestfirm;
import com.gi.xm.platform.query.InvestEventsInvestfirmQuery;


import com.gi.xm.platform.facede.InvestEventsInvestfirmFacede;
import com.gi.xm.platform.facede.convertor.InvestEventsInvestfirmConvertor;
import com.gi.xm.platform.facede.convertor.MessageConvertor;

@Service
public class InvestEventsInvestfirmFacedeImpl implements InvestEventsInvestfirmFacede {

	@Autowired
	private InvestEventsInvestfirmBiz investEventsInvestfirmBiz;
				
	public MessageInfo<Integer> deleteInvestEventsInvestfirm(Long id){
		
		Message<Integer> message  = investEventsInvestfirmBiz.deleteInvestEventsInvestfirm(id);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Long> createInvestEventsInvestfirm(InvestEventsInvestfirmInfo investEventsInvestfirmInfo){
		
		InvestEventsInvestfirm investEventsInvestfirm = InvestEventsInvestfirmConvertor.toInvestEventsInvestfirm(investEventsInvestfirmInfo);
		Message<Long> message  =  investEventsInvestfirmBiz.createInvestEventsInvestfirm( investEventsInvestfirm );
		MessageInfo<Long> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateInvestEventsInvestfirm(InvestEventsInvestfirmInfo investEventsInvestfirmInfo){
		
		InvestEventsInvestfirm investEventsInvestfirm = InvestEventsInvestfirmConvertor.toInvestEventsInvestfirm(investEventsInvestfirmInfo);
		Message<Integer> message  =  investEventsInvestfirmBiz.updateInvestEventsInvestfirm( investEventsInvestfirm );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		@Cacheable(value = "investEventsInvestfirmInfo",keyGenerator = "wiselyKeyGenerator")
	public MessageInfo<InvestEventsInvestfirmInfo> getInvestEventsInvestfirm( Long id ){
		
		Message<InvestEventsInvestfirm> message  = investEventsInvestfirmBiz.getInvestEventsInvestfirm( id );
		MessageInfo<InvestEventsInvestfirmInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		InvestEventsInvestfirmInfo investEventsInvestfirmInfo = InvestEventsInvestfirmConvertor.toInvestEventsInvestfirmInfo(message.getData());
		messageInfo.setData(investEventsInvestfirmInfo);
		return messageInfo;
	}

    @Cacheable(value = "investEventsInvestfirmInfo",keyGenerator = "wiselyKeyGenerator")
    public MessageInfo<List<InvestEventsInvestfirmInfo>> getAllInvestEventsInvestfirm(){
	
		Message<List<InvestEventsInvestfirm>> message  = investEventsInvestfirmBiz.getAllInvestEventsInvestfirm();
		MessageInfo<List<InvestEventsInvestfirmInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<InvestEventsInvestfirmInfo> investEventsInvestfirmInfoList = InvestEventsInvestfirmConvertor.toInvestEventsInvestfirmInfoList(message.getData());
		messageInfo.setData(investEventsInvestfirmInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<InvestEventsInvestfirmInfo>> queryInvestEventsInvestfirm(InvestEventsInvestfirmQueryInfo investEventsInvestfirmQueryInfo) {
		InvestEventsInvestfirmQuery investEventsInvestfirmQuery = InvestEventsInvestfirmConvertor.toInvestEventsInvestfirmQuery(investEventsInvestfirmQueryInfo);
		Message<QueryResult<InvestEventsInvestfirm>> message = investEventsInvestfirmBiz.queryInvestEventsInvestfirm(investEventsInvestfirmQuery);
		MessageInfo<QueryResultInfo<InvestEventsInvestfirmInfo>> messageInfo = new MessageInfo<QueryResultInfo<InvestEventsInvestfirmInfo>>();
		QueryResultInfo<InvestEventsInvestfirmInfo> queryResultInfo = InvestEventsInvestfirmConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
	
}