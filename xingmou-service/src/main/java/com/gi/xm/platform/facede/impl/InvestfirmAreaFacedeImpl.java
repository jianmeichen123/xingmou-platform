
package com.gi.xm.platform.facede.impl;

import java.util.List;
import java.util.Date;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import com.gi.xm.platform.biz.InvestfirmAreaBiz;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;

import com.gi.xm.platform.view.InvestfirmAreaInfo;
import com.gi.xm.platform.view.InvestfirmAreaQueryInfo;


import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.InvestfirmArea;
import com.gi.xm.platform.query.InvestfirmAreaQuery;


import com.gi.xm.platform.facede.InvestfirmAreaFacede;
import com.gi.xm.platform.facede.convertor.InvestfirmAreaConvertor;
import com.gi.xm.platform.facede.convertor.MessageConvertor;

@Service
public class InvestfirmAreaFacedeImpl implements InvestfirmAreaFacede {

	@Autowired
	private InvestfirmAreaBiz investfirmAreaBiz;
				
	public MessageInfo<Integer> deleteInvestfirmArea(Long id){
		
		Message<Integer> message  = investfirmAreaBiz.deleteInvestfirmArea(id);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Long> createInvestfirmArea(InvestfirmAreaInfo investfirmAreaInfo){
		
		InvestfirmArea investfirmArea = InvestfirmAreaConvertor.toInvestfirmArea(investfirmAreaInfo);
		Message<Long> message  =  investfirmAreaBiz.createInvestfirmArea( investfirmArea );
		MessageInfo<Long> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateInvestfirmArea(InvestfirmAreaInfo investfirmAreaInfo){
		
		InvestfirmArea investfirmArea = InvestfirmAreaConvertor.toInvestfirmArea(investfirmAreaInfo);
		Message<Integer> message  =  investfirmAreaBiz.updateInvestfirmArea( investfirmArea );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<InvestfirmAreaInfo> getInvestfirmArea( Long id ){
		
		Message<InvestfirmArea> message  = investfirmAreaBiz.getInvestfirmArea( id );
		MessageInfo<InvestfirmAreaInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		InvestfirmAreaInfo investfirmAreaInfo = InvestfirmAreaConvertor.toInvestfirmAreaInfo(message.getData());
		messageInfo.setData(investfirmAreaInfo);
		return messageInfo;
	}

    public MessageInfo<List<InvestfirmAreaInfo>> getAllInvestfirmArea(){
	
		Message<List<InvestfirmArea>> message  = investfirmAreaBiz.getAllInvestfirmArea();
		MessageInfo<List<InvestfirmAreaInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<InvestfirmAreaInfo> investfirmAreaInfoList = InvestfirmAreaConvertor.toInvestfirmAreaInfoList(message.getData());
		messageInfo.setData(investfirmAreaInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<InvestfirmAreaInfo>> queryInvestfirmArea(InvestfirmAreaQueryInfo investfirmAreaQueryInfo) {
		InvestfirmAreaQuery investfirmAreaQuery = InvestfirmAreaConvertor.toInvestfirmAreaQuery(investfirmAreaQueryInfo);
		Message<QueryResult<InvestfirmArea>> message = investfirmAreaBiz.queryInvestfirmArea(investfirmAreaQuery);
		MessageInfo<QueryResultInfo<InvestfirmAreaInfo>> messageInfo = new MessageInfo<QueryResultInfo<InvestfirmAreaInfo>>();
		QueryResultInfo<InvestfirmAreaInfo> queryResultInfo = InvestfirmAreaConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
		


	public MessageInfo<List<InvestfirmAreaInfo>> getListByInvestfrimId(Integer investfrimId){
	
		Message<List<InvestfirmArea>> message  = investfirmAreaBiz.getListByInvestfrimId(investfrimId);
		MessageInfo<List<InvestfirmAreaInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<InvestfirmAreaInfo> investfirmAreaInfoList = InvestfirmAreaConvertor.toInvestfirmAreaInfoList(message.getData());
		messageInfo.setData(investfirmAreaInfoList);
		return messageInfo;	
	}
		
}