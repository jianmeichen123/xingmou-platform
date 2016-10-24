
package com.gi.xm.platform.facede.impl;

import java.util.List;
import java.util.Date;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import com.gi.xm.platform.biz.InvestfirmsDataBiz;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;

import com.gi.xm.platform.view.InvestfirmsDataInfo;
import com.gi.xm.platform.view.InvestfirmsDataQueryInfo;


import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.InvestfirmsData;
import com.gi.xm.platform.query.InvestfirmsDataQuery;


import com.gi.xm.platform.facede.InvestfirmsDataFacede;
import com.gi.xm.platform.facede.convertor.InvestfirmsDataConvertor;
import com.gi.xm.platform.facede.convertor.MessageConvertor;

@Service
public class InvestfirmsDataFacedeImpl implements InvestfirmsDataFacede {

	@Autowired
	private InvestfirmsDataBiz investfirmsDataBiz;
				
	public MessageInfo<Integer> deleteInvestfirmsData(Integer id){
		
		Message<Integer> message  = investfirmsDataBiz.deleteInvestfirmsData(id);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Integer> createInvestfirmsData(InvestfirmsDataInfo investfirmsDataInfo){
		
		InvestfirmsData investfirmsData = InvestfirmsDataConvertor.toInvestfirmsData(investfirmsDataInfo);
		Message<Integer> message  =  investfirmsDataBiz.createInvestfirmsData( investfirmsData );
		MessageInfo<Integer> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateInvestfirmsData(InvestfirmsDataInfo investfirmsDataInfo){
		
		InvestfirmsData investfirmsData = InvestfirmsDataConvertor.toInvestfirmsData(investfirmsDataInfo);
		Message<Integer> message  =  investfirmsDataBiz.updateInvestfirmsData( investfirmsData );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		@Cacheable(value = "investfirmsDataInfo",keyGenerator = "wiselyKeyGenerator")
	public MessageInfo<InvestfirmsDataInfo> getInvestfirmsData( Integer id ){
		
		Message<InvestfirmsData> message  = investfirmsDataBiz.getInvestfirmsData( id );
		MessageInfo<InvestfirmsDataInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		InvestfirmsDataInfo investfirmsDataInfo = InvestfirmsDataConvertor.toInvestfirmsDataInfo(message.getData());
		messageInfo.setData(investfirmsDataInfo);
		return messageInfo;
	}

    @Cacheable(value = "investfirmsDataInfo",keyGenerator = "wiselyKeyGenerator")
    public MessageInfo<List<InvestfirmsDataInfo>> getAllInvestfirmsData(){
	
		Message<List<InvestfirmsData>> message  = investfirmsDataBiz.getAllInvestfirmsData();
		MessageInfo<List<InvestfirmsDataInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<InvestfirmsDataInfo> investfirmsDataInfoList = InvestfirmsDataConvertor.toInvestfirmsDataInfoList(message.getData());
		messageInfo.setData(investfirmsDataInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<InvestfirmsDataInfo>> queryInvestfirmsData(InvestfirmsDataQueryInfo investfirmsDataQueryInfo) {
		InvestfirmsDataQuery investfirmsDataQuery = InvestfirmsDataConvertor.toInvestfirmsDataQuery(investfirmsDataQueryInfo);
		Message<QueryResult<InvestfirmsData>> message = investfirmsDataBiz.queryInvestfirmsData(investfirmsDataQuery);
		MessageInfo<QueryResultInfo<InvestfirmsDataInfo>> messageInfo = new MessageInfo<QueryResultInfo<InvestfirmsDataInfo>>();
		QueryResultInfo<InvestfirmsDataInfo> queryResultInfo = InvestfirmsDataConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
		


	public MessageInfo<List<InvestfirmsDataInfo>> getListByInvestfirmId(Long investfirmId){
	
		Message<List<InvestfirmsData>> message  = investfirmsDataBiz.getListByInvestfirmId(investfirmId);
		MessageInfo<List<InvestfirmsDataInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<InvestfirmsDataInfo> investfirmsDataInfoList = InvestfirmsDataConvertor.toInvestfirmsDataInfoList(message.getData());
		messageInfo.setData(investfirmsDataInfoList);
		return messageInfo;	
	}
		
}