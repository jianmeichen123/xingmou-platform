
package com.gi.xm.platform.facede.impl;

import java.util.List;
import java.util.Date;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import com.gi.xm.platform.biz.InvestfirmsBiz;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;

import com.gi.xm.platform.view.InvestfirmsInfo;
import com.gi.xm.platform.view.InvestfirmsQueryInfo;


import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.Investfirms;
import com.gi.xm.platform.query.InvestfirmsQuery;


import com.gi.xm.platform.facede.InvestfirmsFacede;
import com.gi.xm.platform.facede.convertor.InvestfirmsConvertor;
import com.gi.xm.platform.facede.convertor.MessageConvertor;

@Service
public class InvestfirmsFacedeImpl implements InvestfirmsFacede {

	@Autowired
	private InvestfirmsBiz investfirmsBiz;
				
	public MessageInfo<Integer> deleteInvestfirms(Long id){
		
		Message<Integer> message  = investfirmsBiz.deleteInvestfirms(id);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Long> createInvestfirms(InvestfirmsInfo investfirmsInfo){
		
		Investfirms investfirms = InvestfirmsConvertor.toInvestfirms(investfirmsInfo);
		Message<Long> message  =  investfirmsBiz.createInvestfirms( investfirms );
		MessageInfo<Long> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateInvestfirms(InvestfirmsInfo investfirmsInfo){
		
		Investfirms investfirms = InvestfirmsConvertor.toInvestfirms(investfirmsInfo);
		Message<Integer> message  =  investfirmsBiz.updateInvestfirms( investfirms );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}

	public MessageInfo<InvestfirmsInfo> getInvestfirms( Long id ){
		
		Message<Investfirms> message  = investfirmsBiz.getInvestfirms( id );
		MessageInfo<InvestfirmsInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		InvestfirmsInfo investfirmsInfo = InvestfirmsConvertor.toInvestfirmsInfo(message.getData());
		messageInfo.setData(investfirmsInfo);
		return messageInfo;
	}

    public MessageInfo<List<InvestfirmsInfo>> getAllInvestfirms(){
	
		Message<List<Investfirms>> message  = investfirmsBiz.getAllInvestfirms();
		MessageInfo<List<InvestfirmsInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<InvestfirmsInfo> investfirmsInfoList = InvestfirmsConvertor.toInvestfirmsInfoList(message.getData());
		messageInfo.setData(investfirmsInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<InvestfirmsInfo>> queryInvestfirms(InvestfirmsQueryInfo investfirmsQueryInfo) {
		InvestfirmsQuery investfirmsQuery = InvestfirmsConvertor.toInvestfirmsQuery(investfirmsQueryInfo);
		Message<QueryResult<Investfirms>> message = investfirmsBiz.queryInvestfirms(investfirmsQuery);
		MessageInfo<QueryResultInfo<InvestfirmsInfo>> messageInfo = new MessageInfo<QueryResultInfo<InvestfirmsInfo>>();
		QueryResultInfo<InvestfirmsInfo> queryResultInfo = InvestfirmsConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
		


	public MessageInfo<List<InvestfirmsInfo>> getListBySourceId(Long sourceId){
	
		Message<List<Investfirms>> message  = investfirmsBiz.getListBySourceId(sourceId);
		MessageInfo<List<InvestfirmsInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<InvestfirmsInfo> investfirmsInfoList = InvestfirmsConvertor.toInvestfirmsInfoList(message.getData());
		messageInfo.setData(investfirmsInfoList);
		return messageInfo;	
	}
		
}