
package com.gi.xm.platform.facede.impl;

import java.util.List;
import java.util.Date;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import com.gi.xm.platform.biz.DataYearBiz;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;

import com.gi.xm.platform.view.DataYearInfo;
import com.gi.xm.platform.view.DataYearQueryInfo;


import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.DataYear;
import com.gi.xm.platform.query.DataYearQuery;


import com.gi.xm.platform.facede.DataYearFacede;
import com.gi.xm.platform.facede.convertor.DataYearConvertor;
import com.gi.xm.platform.facede.convertor.MessageConvertor;

@Service
public class DataYearFacedeImpl implements DataYearFacede {

	@Autowired
	private DataYearBiz dataYearBiz;
				
	public MessageInfo<Integer> deleteDataYear(Long id){
		
		Message<Integer> message  = dataYearBiz.deleteDataYear(id);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Long> createDataYear(DataYearInfo dataYearInfo){
		
		DataYear dataYear = DataYearConvertor.toDataYear(dataYearInfo);
		Message<Long> message  =  dataYearBiz.createDataYear( dataYear );
		MessageInfo<Long> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateDataYear(DataYearInfo dataYearInfo){
		
		DataYear dataYear = DataYearConvertor.toDataYear(dataYearInfo);
		Message<Integer> message  =  dataYearBiz.updateDataYear( dataYear );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		@Cacheable(value = "dataYearInfo",keyGenerator = "wiselyKeyGenerator")
	public MessageInfo<DataYearInfo> getDataYear( Long id ){
		
		Message<DataYear> message  = dataYearBiz.getDataYear( id );
		MessageInfo<DataYearInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		DataYearInfo dataYearInfo = DataYearConvertor.toDataYearInfo(message.getData());
		messageInfo.setData(dataYearInfo);
		return messageInfo;
	}

    @Cacheable(value = "dataYearInfo",keyGenerator = "wiselyKeyGenerator")
    public MessageInfo<List<DataYearInfo>> getAllDataYear(){
	
		Message<List<DataYear>> message  = dataYearBiz.getAllDataYear();
		MessageInfo<List<DataYearInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<DataYearInfo> dataYearInfoList = DataYearConvertor.toDataYearInfoList(message.getData());
		messageInfo.setData(dataYearInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<DataYearInfo>> queryDataYear(DataYearQueryInfo dataYearQueryInfo) {
		DataYearQuery dataYearQuery = DataYearConvertor.toDataYearQuery(dataYearQueryInfo);
		Message<QueryResult<DataYear>> message = dataYearBiz.queryDataYear(dataYearQuery);
		MessageInfo<QueryResultInfo<DataYearInfo>> messageInfo = new MessageInfo<QueryResultInfo<DataYearInfo>>();
		QueryResultInfo<DataYearInfo> queryResultInfo = DataYearConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
		


	public MessageInfo<List<DataYearInfo>> getListByDistrictId(Integer districtId){
	
		Message<List<DataYear>> message  = dataYearBiz.getListByDistrictId(districtId);
		MessageInfo<List<DataYearInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<DataYearInfo> dataYearInfoList = DataYearConvertor.toDataYearInfoList(message.getData());
		messageInfo.setData(dataYearInfoList);
		return messageInfo;	
	}
			


	public MessageInfo<List<DataYearInfo>> getListByIndustryId(Integer industryId){
	
		Message<List<DataYear>> message  = dataYearBiz.getListByIndustryId(industryId);
		MessageInfo<List<DataYearInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<DataYearInfo> dataYearInfoList = DataYearConvertor.toDataYearInfoList(message.getData());
		messageInfo.setData(dataYearInfoList);
		return messageInfo;	
	}
			


	public MessageInfo<List<DataYearInfo>> getListByMoneyLevelId(Integer moneyLevelId){
	
		Message<List<DataYear>> message  = dataYearBiz.getListByMoneyLevelId(moneyLevelId);
		MessageInfo<List<DataYearInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<DataYearInfo> dataYearInfoList = DataYearConvertor.toDataYearInfoList(message.getData());
		messageInfo.setData(dataYearInfoList);
		return messageInfo;	
	}
			


	public MessageInfo<List<DataYearInfo>> getListByRoundId(Integer roundId){
	
		Message<List<DataYear>> message  = dataYearBiz.getListByRoundId(roundId);
		MessageInfo<List<DataYearInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<DataYearInfo> dataYearInfoList = DataYearConvertor.toDataYearInfoList(message.getData());
		messageInfo.setData(dataYearInfoList);
		return messageInfo;	
	}
			


	public MessageInfo<List<DataYearInfo>> getListByYear(Integer year){
	
		Message<List<DataYear>> message  = dataYearBiz.getListByYear(year);
		MessageInfo<List<DataYearInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<DataYearInfo> dataYearInfoList = DataYearConvertor.toDataYearInfoList(message.getData());
		messageInfo.setData(dataYearInfoList);
		return messageInfo;	
	}
		
}