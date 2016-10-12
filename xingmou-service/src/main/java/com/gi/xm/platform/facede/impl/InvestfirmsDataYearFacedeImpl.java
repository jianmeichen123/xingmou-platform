
package com.gi.xm.platform.facede.impl;

import java.util.List;
import java.util.Date;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import com.gi.xm.platform.biz.InvestfirmsDataYearBiz;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;

import com.gi.xm.platform.view.InvestfirmsDataYearInfo;
import com.gi.xm.platform.view.InvestfirmsDataYearQueryInfo;


import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.InvestfirmsDataYear;
import com.gi.xm.platform.query.InvestfirmsDataYearQuery;


import com.gi.xm.platform.facede.InvestfirmsDataYearFacede;
import com.gi.xm.platform.facede.convertor.InvestfirmsDataYearConvertor;
import com.gi.xm.platform.facede.convertor.MessageConvertor;

@Service
public class InvestfirmsDataYearFacedeImpl implements InvestfirmsDataYearFacede {

	@Autowired
	private InvestfirmsDataYearBiz investfirmsDataYearBiz;
				
	public MessageInfo<Integer> deleteInvestfirmsDataYear(Long id){
		
		Message<Integer> message  = investfirmsDataYearBiz.deleteInvestfirmsDataYear(id);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Long> createInvestfirmsDataYear(InvestfirmsDataYearInfo investfirmsDataYearInfo){
		
		InvestfirmsDataYear investfirmsDataYear = InvestfirmsDataYearConvertor.toInvestfirmsDataYear(investfirmsDataYearInfo);
		Message<Long> message  =  investfirmsDataYearBiz.createInvestfirmsDataYear( investfirmsDataYear );
		MessageInfo<Long> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateInvestfirmsDataYear(InvestfirmsDataYearInfo investfirmsDataYearInfo){
		
		InvestfirmsDataYear investfirmsDataYear = InvestfirmsDataYearConvertor.toInvestfirmsDataYear(investfirmsDataYearInfo);
		Message<Integer> message  =  investfirmsDataYearBiz.updateInvestfirmsDataYear( investfirmsDataYear );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		@Cacheable(value = "investfirmsDataYearInfo",keyGenerator = "wiselyKeyGenerator")
	public MessageInfo<InvestfirmsDataYearInfo> getInvestfirmsDataYear( Long id ){
		
		Message<InvestfirmsDataYear> message  = investfirmsDataYearBiz.getInvestfirmsDataYear( id );
		MessageInfo<InvestfirmsDataYearInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		InvestfirmsDataYearInfo investfirmsDataYearInfo = InvestfirmsDataYearConvertor.toInvestfirmsDataYearInfo(message.getData());
		messageInfo.setData(investfirmsDataYearInfo);
		return messageInfo;
	}

    @Cacheable(value = "investfirmsDataYearInfo",keyGenerator = "wiselyKeyGenerator")
    public MessageInfo<List<InvestfirmsDataYearInfo>> getAllInvestfirmsDataYear(){
	
		Message<List<InvestfirmsDataYear>> message  = investfirmsDataYearBiz.getAllInvestfirmsDataYear();
		MessageInfo<List<InvestfirmsDataYearInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<InvestfirmsDataYearInfo> investfirmsDataYearInfoList = InvestfirmsDataYearConvertor.toInvestfirmsDataYearInfoList(message.getData());
		messageInfo.setData(investfirmsDataYearInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<InvestfirmsDataYearInfo>> queryInvestfirmsDataYear(InvestfirmsDataYearQueryInfo investfirmsDataYearQueryInfo) {
		InvestfirmsDataYearQuery investfirmsDataYearQuery = InvestfirmsDataYearConvertor.toInvestfirmsDataYearQuery(investfirmsDataYearQueryInfo);
		Message<QueryResult<InvestfirmsDataYear>> message = investfirmsDataYearBiz.queryInvestfirmsDataYear(investfirmsDataYearQuery);
		MessageInfo<QueryResultInfo<InvestfirmsDataYearInfo>> messageInfo = new MessageInfo<QueryResultInfo<InvestfirmsDataYearInfo>>();
		QueryResultInfo<InvestfirmsDataYearInfo> queryResultInfo = InvestfirmsDataYearConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}


	public MessageInfo<QueryResultInfo<InvestfirmsDataYearInfo>> queryInvestfirmsDataYearByIndustry(InvestfirmsDataYearQueryInfo investfirmsDataYearQueryInfo) {
		InvestfirmsDataYearQuery investfirmsDataYearQuery = InvestfirmsDataYearConvertor.toInvestfirmsDataYearQuery(investfirmsDataYearQueryInfo);
		Message<QueryResult<InvestfirmsDataYear>> message = investfirmsDataYearBiz.queryInvestfirmsDataYearByIndustry(investfirmsDataYearQuery);
		MessageInfo<QueryResultInfo<InvestfirmsDataYearInfo>> messageInfo = new MessageInfo<QueryResultInfo<InvestfirmsDataYearInfo>>();
		QueryResultInfo<InvestfirmsDataYearInfo> queryResultInfo = InvestfirmsDataYearConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}

	public MessageInfo<QueryResultInfo<InvestfirmsDataYearInfo>> queryInvestfirmsDataYearBySub(InvestfirmsDataYearQueryInfo investfirmsDataYearQueryInfo) {
		InvestfirmsDataYearQuery investfirmsDataYearQuery = InvestfirmsDataYearConvertor.toInvestfirmsDataYearQuery(investfirmsDataYearQueryInfo);
		Message<QueryResult<InvestfirmsDataYear>> message = investfirmsDataYearBiz.queryInvestfirmsDataYearBySub(investfirmsDataYearQuery);
		MessageInfo<QueryResultInfo<InvestfirmsDataYearInfo>> messageInfo = new MessageInfo<QueryResultInfo<InvestfirmsDataYearInfo>>();
		QueryResultInfo<InvestfirmsDataYearInfo> queryResultInfo = InvestfirmsDataYearConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}


	public MessageInfo<List<InvestfirmsDataYearInfo>> getListByInvestfirmId(Long investfirmId){
	
		Message<List<InvestfirmsDataYear>> message  = investfirmsDataYearBiz.getListByInvestfirmId(investfirmId);
		MessageInfo<List<InvestfirmsDataYearInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<InvestfirmsDataYearInfo> investfirmsDataYearInfoList = InvestfirmsDataYearConvertor.toInvestfirmsDataYearInfoList(message.getData());
		messageInfo.setData(investfirmsDataYearInfoList);
		return messageInfo;	
	}
			


	public MessageInfo<List<InvestfirmsDataYearInfo>> getListByYear(Integer year){
	
		Message<List<InvestfirmsDataYear>> message  = investfirmsDataYearBiz.getListByYear(year);
		MessageInfo<List<InvestfirmsDataYearInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<InvestfirmsDataYearInfo> investfirmsDataYearInfoList = InvestfirmsDataYearConvertor.toInvestfirmsDataYearInfoList(message.getData());
		messageInfo.setData(investfirmsDataYearInfoList);
		return messageInfo;	
	}
		
}