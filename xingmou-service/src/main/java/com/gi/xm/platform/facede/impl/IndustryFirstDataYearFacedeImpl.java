
package com.gi.xm.platform.facede.impl;

import java.util.List;

import com.alibaba.dubbo.config.annotation.Service;
import com.gi.xm.platform.pojo.IndustryDataYear;
import com.gi.xm.platform.view.IndustryDataYearInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import com.gi.xm.platform.biz.IndustryFirstDataYearBiz;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;

import com.gi.xm.platform.view.IndustryFirstDataYearInfo;
import com.gi.xm.platform.view.IndustryFirstDataYearQueryInfo;


import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.IndustryFirstDataYear;
import com.gi.xm.platform.query.IndustryFirstDataYearQuery;


import com.gi.xm.platform.facede.IndustryFirstDataYearFacede;
import com.gi.xm.platform.facede.convertor.IndustryFirstDataYearConvertor;
import com.gi.xm.platform.facede.convertor.MessageConvertor;

@Service
public class IndustryFirstDataYearFacedeImpl implements IndustryFirstDataYearFacede {

	@Autowired
	private IndustryFirstDataYearBiz industryFirstDataYearBiz;
				
	public MessageInfo<Integer> deleteIndustryFirstDataYear(Long id){
		
		Message<Integer> message  = industryFirstDataYearBiz.deleteIndustryFirstDataYear(id);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Long> createIndustryFirstDataYear(IndustryFirstDataYearInfo industryFirstDataYearInfo){
		
		IndustryFirstDataYear industryFirstDataYear = IndustryFirstDataYearConvertor.toIndustryFirstDataYear(industryFirstDataYearInfo);
		Message<Long> message  =  industryFirstDataYearBiz.createIndustryFirstDataYear( industryFirstDataYear );
		MessageInfo<Long> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateIndustryFirstDataYear(IndustryFirstDataYearInfo industryFirstDataYearInfo){
		
		IndustryFirstDataYear industryFirstDataYear = IndustryFirstDataYearConvertor.toIndustryFirstDataYear(industryFirstDataYearInfo);
		Message<Integer> message  =  industryFirstDataYearBiz.updateIndustryFirstDataYear( industryFirstDataYear );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		@Cacheable(value = "industryFirstDataYearInfo",keyGenerator = "wiselyKeyGenerator")
	public MessageInfo<IndustryFirstDataYearInfo> getIndustryFirstDataYear( Long id ){
		
		Message<IndustryFirstDataYear> message  = industryFirstDataYearBiz.getIndustryFirstDataYear( id );
		MessageInfo<IndustryFirstDataYearInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		IndustryFirstDataYearInfo industryFirstDataYearInfo = IndustryFirstDataYearConvertor.toIndustryFirstDataYearInfo(message.getData());
		messageInfo.setData(industryFirstDataYearInfo);
		return messageInfo;
	}

    @Cacheable(value = "industryFirstDataYearInfo",keyGenerator = "wiselyKeyGenerator")
    public MessageInfo<List<IndustryFirstDataYearInfo>> getAllIndustryFirstDataYear(){
	
		Message<List<IndustryFirstDataYear>> message  = industryFirstDataYearBiz.getAllIndustryFirstDataYear();
		MessageInfo<List<IndustryFirstDataYearInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<IndustryFirstDataYearInfo> industryFirstDataYearInfoList = IndustryFirstDataYearConvertor.toIndustryFirstDataYearInfoList(message.getData());
		messageInfo.setData(industryFirstDataYearInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<IndustryDataYearInfo>> queryIndustryFirstDataYear(IndustryFirstDataYearQueryInfo industryFirstDataYearQueryInfo) {
		IndustryFirstDataYearQuery industryFirstDataYearQuery = IndustryFirstDataYearConvertor.toIndustryFirstDataYearQuery(industryFirstDataYearQueryInfo);
		industryFirstDataYearQuery.setYearList(industryFirstDataYearQueryInfo.getYearList());
		Message<QueryResult<IndustryFirstDataYear>> message = industryFirstDataYearBiz.queryIndustryFirstDataYear(industryFirstDataYearQuery);
		MessageInfo<QueryResultInfo<IndustryDataYearInfo>> messageInfo = new MessageInfo<QueryResultInfo<IndustryDataYearInfo>>();
		QueryResultInfo<IndustryDataYearInfo> queryResultInfo = IndustryFirstDataYearConvertor.toQueryResultInfo1(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
		


	public MessageInfo<List<IndustryDataYearInfo>> getListByIndustryIdYaar(Integer industryId, Integer[] yaars){
	
		Message<List<IndustryFirstDataYear>> message  = industryFirstDataYearBiz.getListByIndustryIdYaar(industryId, yaars);
		MessageInfo<List<IndustryDataYearInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<IndustryDataYearInfo> industryFirstDataYearInfoList = IndustryFirstDataYearConvertor.toIndustryFirstDataYearInfoList1(message.getData());
		messageInfo.setData(industryFirstDataYearInfoList);
		return messageInfo;	
	}
			



			


	public MessageInfo<List<IndustryFirstDataYearInfo>> getListByIndustryId(Integer industryId){
	
		Message<List<IndustryFirstDataYear>> message  = industryFirstDataYearBiz.getListByIndustryId(industryId);
		MessageInfo<List<IndustryFirstDataYearInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<IndustryFirstDataYearInfo> industryFirstDataYearInfoList = IndustryFirstDataYearConvertor.toIndustryFirstDataYearInfoList(message.getData());
		messageInfo.setData(industryFirstDataYearInfoList);
		return messageInfo;	
	}
			


	public MessageInfo<List<IndustryFirstDataYearInfo>> getListByYaar(Integer[] yaars){
	
		Message<List<IndustryFirstDataYear>> message  = industryFirstDataYearBiz.getListByYaar(yaars);
		MessageInfo<List<IndustryFirstDataYearInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<IndustryFirstDataYearInfo> industryFirstDataYearInfoList = IndustryFirstDataYearConvertor.toIndustryFirstDataYearInfoList(message.getData());
		messageInfo.setData(industryFirstDataYearInfoList);
		return messageInfo;	
	}
		
}