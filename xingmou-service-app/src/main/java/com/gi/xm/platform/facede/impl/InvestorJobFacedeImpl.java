
package com.gi.xm.platform.facede.impl;

import java.util.List;
import java.util.Date;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import com.gi.xm.platform.biz.InvestorJobBiz;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;

import com.gi.xm.platform.view.InvestorJobInfo;
import com.gi.xm.platform.view.InvestorJobQueryInfo;


import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.InvestorJob;
import com.gi.xm.platform.query.InvestorJobQuery;


import com.gi.xm.platform.facede.InvestorJobFacede;
import com.gi.xm.platform.facede.convertor.InvestorJobConvertor;
import com.gi.xm.platform.facede.convertor.MessageConvertor;

@Service
public class InvestorJobFacedeImpl implements InvestorJobFacede {

	@Autowired
	private InvestorJobBiz investorJobBiz;
				
	public MessageInfo<Integer> deleteInvestorJob(Long id){
		
		Message<Integer> message  = investorJobBiz.deleteInvestorJob(id);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Long> createInvestorJob(InvestorJobInfo investorJobInfo){
		
		InvestorJob investorJob = InvestorJobConvertor.toInvestorJob(investorJobInfo);
		Message<Long> message  =  investorJobBiz.createInvestorJob( investorJob );
		MessageInfo<Long> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateInvestorJob(InvestorJobInfo investorJobInfo){
		
		InvestorJob investorJob = InvestorJobConvertor.toInvestorJob(investorJobInfo);
		Message<Integer> message  =  investorJobBiz.updateInvestorJob( investorJob );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		@Cacheable(value = "investorJobInfo",keyGenerator = "wiselyKeyGenerator")
	public MessageInfo<InvestorJobInfo> getInvestorJob( Long id ){
		
		Message<InvestorJob> message  = investorJobBiz.getInvestorJob( id );
		MessageInfo<InvestorJobInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		InvestorJobInfo investorJobInfo = InvestorJobConvertor.toInvestorJobInfo(message.getData());
		messageInfo.setData(investorJobInfo);
		return messageInfo;
	}

    @Cacheable(value = "investorJobInfo",keyGenerator = "wiselyKeyGenerator")
    public MessageInfo<List<InvestorJobInfo>> getAllInvestorJob(){
	
		Message<List<InvestorJob>> message  = investorJobBiz.getAllInvestorJob();
		MessageInfo<List<InvestorJobInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<InvestorJobInfo> investorJobInfoList = InvestorJobConvertor.toInvestorJobInfoList(message.getData());
		messageInfo.setData(investorJobInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<InvestorJobInfo>> queryInvestorJob(InvestorJobQueryInfo investorJobQueryInfo) {
		InvestorJobQuery investorJobQuery = InvestorJobConvertor.toInvestorJobQuery(investorJobQueryInfo);
		Message<QueryResult<InvestorJob>> message = investorJobBiz.queryInvestorJob(investorJobQuery);
		MessageInfo<QueryResultInfo<InvestorJobInfo>> messageInfo = new MessageInfo<QueryResultInfo<InvestorJobInfo>>();
		QueryResultInfo<InvestorJobInfo> queryResultInfo = InvestorJobConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
	
}