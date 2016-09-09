
package com.gi.xm.platform.facede.impl;

import java.util.List;
import java.util.Date;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.gi.xm.platform.biz.IndustryBiz;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;

import com.gi.xm.platform.view.IndustryInfo;
import com.gi.xm.platform.view.IndustryQueryInfo;


import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.Industry;
import com.gi.xm.platform.query.IndustryQuery;


import com.gi.xm.platform.facede.IndustryFacede;
import com.gi.xm.platform.facede.convertor.IndustryConvertor;
import com.gi.xm.platform.facede.convertor.MessageConvertor;

@Service
public class IndustryFacedeImpl implements IndustryFacede {

	@Autowired
	private IndustryBiz industryBiz;
				
	public MessageInfo<Integer> deleteIndustry(Integer id){
		
		Message<Integer> message  = industryBiz.deleteIndustry(id);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Integer> createIndustry(IndustryInfo industryInfo){
		
		Industry industry = IndustryConvertor.toIndustry(industryInfo);
		Message<Integer> message  =  industryBiz.createIndustry( industry );
		MessageInfo<Integer> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateIndustry(IndustryInfo industryInfo){
		
		Industry industry = IndustryConvertor.toIndustry(industryInfo);
		Message<Integer> message  =  industryBiz.updateIndustry( industry );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		public MessageInfo<IndustryInfo> getIndustry( Integer id ){
		
		Message<Industry> message  = industryBiz.getIndustry( id );
		MessageInfo<IndustryInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		IndustryInfo industryInfo = IndustryConvertor.toIndustryInfo(message.getData());
		messageInfo.setData(industryInfo);
		return messageInfo;
	}

    public MessageInfo<List<IndustryInfo>> getAllIndustry(){
	
		Message<List<Industry>> message  = industryBiz.getAllIndustry();
		MessageInfo<List<IndustryInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<IndustryInfo> industryInfoList = IndustryConvertor.toIndustryInfoList(message.getData());
		messageInfo.setData(industryInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<IndustryInfo>> queryIndustry(IndustryQueryInfo industryQueryInfo) {
		IndustryQuery industryQuery = IndustryConvertor.toIndustryQuery(industryQueryInfo);
		Message<QueryResult<Industry>> message = industryBiz.queryIndustry(industryQuery);
		MessageInfo<QueryResultInfo<IndustryInfo>> messageInfo = new MessageInfo<QueryResultInfo<IndustryInfo>>();
		QueryResultInfo<IndustryInfo> queryResultInfo = IndustryConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
	
}