
package com.gi.xm.platform.facede.impl;

import java.util.List;
import java.util.Date;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import com.gi.xm.platform.biz.InvestorBiz;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;

import com.gi.xm.platform.view.InvestorInfo;
import com.gi.xm.platform.view.InvestorQueryInfo;


import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.Investor;
import com.gi.xm.platform.query.InvestorQuery;


import com.gi.xm.platform.facede.InvestorFacede;
import com.gi.xm.platform.facede.convertor.InvestorConvertor;
import com.gi.xm.platform.facede.convertor.MessageConvertor;

@Service
public class InvestorFacedeImpl implements InvestorFacede {

	@Autowired
	private InvestorBiz investorBiz;
				
	public MessageInfo<Integer> deleteInvestor(Long id){
		
		Message<Integer> message  = investorBiz.deleteInvestor(id);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Long> createInvestor(InvestorInfo investorInfo){
		
		Investor investor = InvestorConvertor.toInvestor(investorInfo);
		Message<Long> message  =  investorBiz.createInvestor( investor );
		MessageInfo<Long> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateInvestor(InvestorInfo investorInfo){
		
		Investor investor = InvestorConvertor.toInvestor(investorInfo);
		Message<Integer> message  =  investorBiz.updateInvestor( investor );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}

	public MessageInfo<InvestorInfo> getInvestor( Long id ){
		
		Message<Investor> message  = investorBiz.getInvestor( id );
		MessageInfo<InvestorInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		InvestorInfo investorInfo = InvestorConvertor.toInvestorInfo(message.getData());
		messageInfo.setData(investorInfo);
		return messageInfo;
	}

    public MessageInfo<List<InvestorInfo>> getAllInvestor(){
	
		Message<List<Investor>> message  = investorBiz.getAllInvestor();
		MessageInfo<List<InvestorInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<InvestorInfo> investorInfoList = InvestorConvertor.toInvestorInfoList(message.getData());
		messageInfo.setData(investorInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<InvestorInfo>> queryInvestor(InvestorQueryInfo investorQueryInfo) {
		InvestorQuery investorQuery = InvestorConvertor.toInvestorQuery(investorQueryInfo);
		Message<QueryResult<Investor>> message = investorBiz.queryInvestor(investorQuery);
		MessageInfo<QueryResultInfo<InvestorInfo>> messageInfo = new MessageInfo<QueryResultInfo<InvestorInfo>>();
		QueryResultInfo<InvestorInfo> queryResultInfo = InvestorConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
	
}