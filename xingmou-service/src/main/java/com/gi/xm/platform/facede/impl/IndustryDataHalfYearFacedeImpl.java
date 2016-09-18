
package com.gi.xm.platform.facede.impl;

import java.util.List;
import java.util.Date;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import com.gi.xm.platform.biz.IndustryDataHalfYearBiz;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;

import com.gi.xm.platform.view.IndustryDataHalfYearInfo;
import com.gi.xm.platform.view.IndustryDataHalfYearQueryInfo;


import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.IndustryDataHalfYear;
import com.gi.xm.platform.query.IndustryDataHalfYearQuery;


import com.gi.xm.platform.facede.IndustryDataHalfYearFacede;
import com.gi.xm.platform.facede.convertor.IndustryDataHalfYearConvertor;
import com.gi.xm.platform.facede.convertor.MessageConvertor;

@Service
public class IndustryDataHalfYearFacedeImpl implements IndustryDataHalfYearFacede {

	@Autowired
	private IndustryDataHalfYearBiz industryDataHalfYearBiz;
				
	public MessageInfo<Integer> deleteIndustryDataHalfYear(Long id){
		
		Message<Integer> message  = industryDataHalfYearBiz.deleteIndustryDataHalfYear(id);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Long> createIndustryDataHalfYear(IndustryDataHalfYearInfo industryDataHalfYearInfo){
		
		IndustryDataHalfYear industryDataHalfYear = IndustryDataHalfYearConvertor.toIndustryDataHalfYear(industryDataHalfYearInfo);
		Message<Long> message  =  industryDataHalfYearBiz.createIndustryDataHalfYear( industryDataHalfYear );
		MessageInfo<Long> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateIndustryDataHalfYear(IndustryDataHalfYearInfo industryDataHalfYearInfo){
		
		IndustryDataHalfYear industryDataHalfYear = IndustryDataHalfYearConvertor.toIndustryDataHalfYear(industryDataHalfYearInfo);
		Message<Integer> message  =  industryDataHalfYearBiz.updateIndustryDataHalfYear( industryDataHalfYear );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		@Cacheable(value = "industryDataHalfYearInfo",keyGenerator = "wiselyKeyGenerator")
	public MessageInfo<IndustryDataHalfYearInfo> getIndustryDataHalfYear( Long id ){
		
		Message<IndustryDataHalfYear> message  = industryDataHalfYearBiz.getIndustryDataHalfYear( id );
		MessageInfo<IndustryDataHalfYearInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		IndustryDataHalfYearInfo industryDataHalfYearInfo = IndustryDataHalfYearConvertor.toIndustryDataHalfYearInfo(message.getData());
		messageInfo.setData(industryDataHalfYearInfo);
		return messageInfo;
	}

    @Cacheable(value = "industryDataHalfYearInfo",keyGenerator = "wiselyKeyGenerator")
    public MessageInfo<List<IndustryDataHalfYearInfo>> getAllIndustryDataHalfYear(){
	
		Message<List<IndustryDataHalfYear>> message  = industryDataHalfYearBiz.getAllIndustryDataHalfYear();
		MessageInfo<List<IndustryDataHalfYearInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<IndustryDataHalfYearInfo> industryDataHalfYearInfoList = IndustryDataHalfYearConvertor.toIndustryDataHalfYearInfoList(message.getData());
		messageInfo.setData(industryDataHalfYearInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<IndustryDataHalfYearInfo>> queryIndustryDataHalfYear(IndustryDataHalfYearQueryInfo industryDataHalfYearQueryInfo) {
		IndustryDataHalfYearQuery industryDataHalfYearQuery = IndustryDataHalfYearConvertor.toIndustryDataHalfYearQuery(industryDataHalfYearQueryInfo);
		Message<QueryResult<IndustryDataHalfYear>> message = industryDataHalfYearBiz.queryIndustryDataHalfYear(industryDataHalfYearQuery);
		MessageInfo<QueryResultInfo<IndustryDataHalfYearInfo>> messageInfo = new MessageInfo<QueryResultInfo<IndustryDataHalfYearInfo>>();
		QueryResultInfo<IndustryDataHalfYearInfo> queryResultInfo = IndustryDataHalfYearConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
		


	public MessageInfo<List<IndustryDataHalfYearInfo>> getListByIndustryIdYaar(Integer industryId, Integer yaar){
	
		Message<List<IndustryDataHalfYear>> message  = industryDataHalfYearBiz.getListByIndustryIdYaar(industryId, yaar);
		MessageInfo<List<IndustryDataHalfYearInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<IndustryDataHalfYearInfo> industryDataHalfYearInfoList = IndustryDataHalfYearConvertor.toIndustryDataHalfYearInfoList(message.getData());
		messageInfo.setData(industryDataHalfYearInfoList);
		return messageInfo;	
	}
			


	public MessageInfo<List<IndustryDataHalfYearInfo>> getListByYaarIndustrySubId(Integer yaar, Integer industrySubId){
	
		Message<List<IndustryDataHalfYear>> message  = industryDataHalfYearBiz.getListByYaarIndustrySubId(yaar, industrySubId);
		MessageInfo<List<IndustryDataHalfYearInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<IndustryDataHalfYearInfo> industryDataHalfYearInfoList = IndustryDataHalfYearConvertor.toIndustryDataHalfYearInfoList(message.getData());
		messageInfo.setData(industryDataHalfYearInfoList);
		return messageInfo;	
	}
			


	public MessageInfo<List<IndustryDataHalfYearInfo>> getListByIndustryId(Integer industryId){
	
		Message<List<IndustryDataHalfYear>> message  = industryDataHalfYearBiz.getListByIndustryId(industryId);
		MessageInfo<List<IndustryDataHalfYearInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<IndustryDataHalfYearInfo> industryDataHalfYearInfoList = IndustryDataHalfYearConvertor.toIndustryDataHalfYearInfoList(message.getData());
		messageInfo.setData(industryDataHalfYearInfoList);
		return messageInfo;	
	}
			


	public MessageInfo<List<IndustryDataHalfYearInfo>> getListByYaar(Integer yaar){
	
		Message<List<IndustryDataHalfYear>> message  = industryDataHalfYearBiz.getListByYaar(yaar);
		MessageInfo<List<IndustryDataHalfYearInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<IndustryDataHalfYearInfo> industryDataHalfYearInfoList = IndustryDataHalfYearConvertor.toIndustryDataHalfYearInfoList(message.getData());
		messageInfo.setData(industryDataHalfYearInfoList);
		return messageInfo;	
	}
		
}