
package com.gi.xm.platform.facede.impl;

import java.util.List;
import java.util.Date;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import com.gi.xm.platform.biz.IndustryDataYearBiz;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;

import com.gi.xm.platform.view.IndustryDataYearInfo;
import com.gi.xm.platform.view.IndustryDataYearQueryInfo;


import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.IndustryDataYear;
import com.gi.xm.platform.query.IndustryDataYearQuery;


import com.gi.xm.platform.facede.IndustryDataYearFacede;
import com.gi.xm.platform.facede.convertor.IndustryDataYearConvertor;
import com.gi.xm.platform.facede.convertor.MessageConvertor;

@Service
public class IndustryDataYearFacedeImpl implements IndustryDataYearFacede {

	@Autowired
	private IndustryDataYearBiz industryDataYearBiz;
				
	public MessageInfo<Integer> deleteIndustryDataYear(Long id){
		
		Message<Integer> message  = industryDataYearBiz.deleteIndustryDataYear(id);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Long> createIndustryDataYear(IndustryDataYearInfo industryDataYearInfo){
		
		IndustryDataYear industryDataYear = IndustryDataYearConvertor.toIndustryDataYear(industryDataYearInfo);
		Message<Long> message  =  industryDataYearBiz.createIndustryDataYear( industryDataYear );
		MessageInfo<Long> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateIndustryDataYear(IndustryDataYearInfo industryDataYearInfo){
		
		IndustryDataYear industryDataYear = IndustryDataYearConvertor.toIndustryDataYear(industryDataYearInfo);
		Message<Integer> message  =  industryDataYearBiz.updateIndustryDataYear( industryDataYear );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		@Cacheable(value = "industryDataYearInfo",keyGenerator = "wiselyKeyGenerator")
	public MessageInfo<IndustryDataYearInfo> getIndustryDataYear( Long id ){
		
		Message<IndustryDataYear> message  = industryDataYearBiz.getIndustryDataYear( id );
		MessageInfo<IndustryDataYearInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		IndustryDataYearInfo industryDataYearInfo = IndustryDataYearConvertor.toIndustryDataYearInfo(message.getData());
		messageInfo.setData(industryDataYearInfo);
		return messageInfo;
	}

    @Cacheable(value = "industryDataYearInfo",keyGenerator = "wiselyKeyGenerator")
    public MessageInfo<List<IndustryDataYearInfo>> getAllIndustryDataYear(){
	
		Message<List<IndustryDataYear>> message  = industryDataYearBiz.getAllIndustryDataYear();
		MessageInfo<List<IndustryDataYearInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<IndustryDataYearInfo> industryDataYearInfoList = IndustryDataYearConvertor.toIndustryDataYearInfoList(message.getData());
		messageInfo.setData(industryDataYearInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<IndustryDataYearInfo>> queryIndustryDataYear(IndustryDataYearQueryInfo industryDataYearQueryInfo) {
		IndustryDataYearQuery industryDataYearQuery = IndustryDataYearConvertor.toIndustryDataYearQuery(industryDataYearQueryInfo);
		Message<QueryResult<IndustryDataYear>> message = industryDataYearBiz.queryIndustryDataYear(industryDataYearQuery);
		MessageInfo<QueryResultInfo<IndustryDataYearInfo>> messageInfo = new MessageInfo<QueryResultInfo<IndustryDataYearInfo>>();
		QueryResultInfo<IndustryDataYearInfo> queryResultInfo = IndustryDataYearConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
		


	public MessageInfo<List<IndustryDataYearInfo>> getListByIndustryIdYaar(Integer industryId, Integer[] yaars){
	
		Message<List<IndustryDataYear>> message  = industryDataYearBiz.getListByIndustryIdYaar(industryId, yaars);
		MessageInfo<List<IndustryDataYearInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<IndustryDataYearInfo> industryDataYearInfoList = IndustryDataYearConvertor.toIndustryDataYearInfoList(message.getData());
		messageInfo.setData(industryDataYearInfoList);
		return messageInfo;	
	}
			


	public MessageInfo<List<IndustryDataYearInfo>> getListByYaarIndustrySubId(Integer[] yaars, Integer industrySubId){
	
		Message<List<IndustryDataYear>> message  = industryDataYearBiz.getListByYaarIndustrySubId(yaars, industrySubId);
		MessageInfo<List<IndustryDataYearInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<IndustryDataYearInfo> industryDataYearInfoList = IndustryDataYearConvertor.toIndustryDataYearInfoList(message.getData());
		messageInfo.setData(industryDataYearInfoList);
		return messageInfo;	
	}
			


	public MessageInfo<List<IndustryDataYearInfo>> getListByIndustryId(Integer industryId){
	
		Message<List<IndustryDataYear>> message  = industryDataYearBiz.getListByIndustryId(industryId);
		MessageInfo<List<IndustryDataYearInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<IndustryDataYearInfo> industryDataYearInfoList = IndustryDataYearConvertor.toIndustryDataYearInfoList(message.getData());
		messageInfo.setData(industryDataYearInfoList);
		return messageInfo;	
	}
			


	public MessageInfo<List<IndustryDataYearInfo>> getListByYaar(Integer[] yaars){
	
		Message<List<IndustryDataYear>> message  = industryDataYearBiz.getListByYaar(yaars);
		MessageInfo<List<IndustryDataYearInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<IndustryDataYearInfo> industryDataYearInfoList = IndustryDataYearConvertor.toIndustryDataYearInfoList(message.getData());
		messageInfo.setData(industryDataYearInfoList);
		return messageInfo;	
	}
		
}