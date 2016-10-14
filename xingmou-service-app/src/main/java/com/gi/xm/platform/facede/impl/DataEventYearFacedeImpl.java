
package com.gi.xm.platform.facede.impl;

import java.util.List;
import java.util.Date;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import com.gi.xm.platform.biz.DataEventYearBiz;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;

import com.gi.xm.platform.view.DataEventYearInfo;
import com.gi.xm.platform.view.DataEventYearQueryInfo;


import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.DataEventYear;
import com.gi.xm.platform.query.DataEventYearQuery;


import com.gi.xm.platform.facede.DataEventYearFacede;
import com.gi.xm.platform.facede.convertor.DataEventYearConvertor;
import com.gi.xm.platform.facede.convertor.MessageConvertor;

@Service
public class DataEventYearFacedeImpl implements DataEventYearFacede {

	@Autowired
	private DataEventYearBiz dataEventYearBiz;
				
	public MessageInfo<Integer> deleteDataEventYear(Long id){
		
		Message<Integer> message  = dataEventYearBiz.deleteDataEventYear(id);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Long> createDataEventYear(DataEventYearInfo dataEventYearInfo){
		
		DataEventYear dataEventYear = DataEventYearConvertor.toDataEventYear(dataEventYearInfo);
		Message<Long> message  =  dataEventYearBiz.createDataEventYear( dataEventYear );
		MessageInfo<Long> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateDataEventYear(DataEventYearInfo dataEventYearInfo){
		
		DataEventYear dataEventYear = DataEventYearConvertor.toDataEventYear(dataEventYearInfo);
		Message<Integer> message  =  dataEventYearBiz.updateDataEventYear( dataEventYear );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		@Cacheable(value = "dataEventYearInfo",keyGenerator = "wiselyKeyGenerator")
	public MessageInfo<DataEventYearInfo> getDataEventYear( Long id ){
		
		Message<DataEventYear> message  = dataEventYearBiz.getDataEventYear( id );
		MessageInfo<DataEventYearInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		DataEventYearInfo dataEventYearInfo = DataEventYearConvertor.toDataEventYearInfo(message.getData());
		messageInfo.setData(dataEventYearInfo);
		return messageInfo;
	}

    @Cacheable(value = "dataEventYearInfo",keyGenerator = "wiselyKeyGenerator")
    public MessageInfo<List<DataEventYearInfo>> getAllDataEventYear(){
	
		Message<List<DataEventYear>> message  = dataEventYearBiz.getAllDataEventYear();
		MessageInfo<List<DataEventYearInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<DataEventYearInfo> dataEventYearInfoList = DataEventYearConvertor.toDataEventYearInfoList(message.getData());
		messageInfo.setData(dataEventYearInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<DataEventYearInfo>> queryDataEventYear(DataEventYearQueryInfo dataEventYearQueryInfo) {
		DataEventYearQuery dataEventYearQuery = DataEventYearConvertor.toDataEventYearQuery(dataEventYearQueryInfo);
		Message<QueryResult<DataEventYear>> message = dataEventYearBiz.queryDataEventYear(dataEventYearQuery);
		MessageInfo<QueryResultInfo<DataEventYearInfo>> messageInfo = new MessageInfo<QueryResultInfo<DataEventYearInfo>>();
		QueryResultInfo<DataEventYearInfo> queryResultInfo = DataEventYearConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}



	@Cacheable(value = "dataEventYearInfo",keyGenerator = "wiselyKeyGenerator")
	public MessageInfo<List<DataEventYearInfo>> getListByYearIndustryId(Integer[] years, Integer industryId){
	
		Message<List<DataEventYear>> message  = dataEventYearBiz.getListByYearIndustryId(years, industryId);
		MessageInfo<List<DataEventYearInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<DataEventYearInfo> dataEventYearInfoList = DataEventYearConvertor.toDataEventYearInfoList(message.getData());
		messageInfo.setData(dataEventYearInfoList);
		return messageInfo;	
	}


	@Cacheable(value = "dataEventYearInfo",keyGenerator = "wiselyKeyGenerator")
	public MessageInfo<List<DataEventYearInfo>> getListByYearIndustrySubId(Integer[] years, Integer industrySubId){
	
		Message<List<DataEventYear>> message  = dataEventYearBiz.getListByYearIndustrySubId(years, industrySubId);
		MessageInfo<List<DataEventYearInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<DataEventYearInfo> dataEventYearInfoList = DataEventYearConvertor.toDataEventYearInfoList(message.getData());
		messageInfo.setData(dataEventYearInfoList);
		return messageInfo;	
	}
			


	public MessageInfo<List<DataEventYearInfo>> getListByDistrictId(Integer districtId){
	
		Message<List<DataEventYear>> message  = dataEventYearBiz.getListByDistrictId(districtId);
		MessageInfo<List<DataEventYearInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<DataEventYearInfo> dataEventYearInfoList = DataEventYearConvertor.toDataEventYearInfoList(message.getData());
		messageInfo.setData(dataEventYearInfoList);
		return messageInfo;	
	}
			


	public MessageInfo<List<DataEventYearInfo>> getListByIndustryId(Integer industryId){
	
		Message<List<DataEventYear>> message  = dataEventYearBiz.getListByIndustryId(industryId);
		MessageInfo<List<DataEventYearInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<DataEventYearInfo> dataEventYearInfoList = DataEventYearConvertor.toDataEventYearInfoList(message.getData());
		messageInfo.setData(dataEventYearInfoList);
		return messageInfo;	
	}
			


	public MessageInfo<List<DataEventYearInfo>> getListByMoneyLevelId(Integer moneyLevelId){
		Message<List<DataEventYear>> message  = dataEventYearBiz.getListByMoneyLevelId(moneyLevelId);
		MessageInfo<List<DataEventYearInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<DataEventYearInfo> dataEventYearInfoList = DataEventYearConvertor.toDataEventYearInfoList(message.getData());
		messageInfo.setData(dataEventYearInfoList);
		return messageInfo;	
	}
			


	public MessageInfo<List<DataEventYearInfo>> getListByRoundId(Integer roundId){
	
		Message<List<DataEventYear>> message  = dataEventYearBiz.getListByRoundId(roundId);
		MessageInfo<List<DataEventYearInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<DataEventYearInfo> dataEventYearInfoList = DataEventYearConvertor.toDataEventYearInfoList(message.getData());
		messageInfo.setData(dataEventYearInfoList);
		return messageInfo;	
	}




	@Cacheable(value = "dataEventYearInfo",keyGenerator = "wiselyKeyGenerator")
	public MessageInfo<List<DataEventYearInfo>> getListByYear(Integer[] years){
		Message<List<DataEventYear>> message  = dataEventYearBiz.getListByYear(years);
		MessageInfo<List<DataEventYearInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<DataEventYearInfo> dataEventYearInfoList = DataEventYearConvertor.toDataEventYearInfoList(message.getData());
		messageInfo.setData(dataEventYearInfoList);
		return messageInfo;	
	}
		
}