
package com.gi.xm.platform.facede.impl;

import java.util.List;
import java.util.Date;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import com.gi.xm.platform.biz.MoneyLevelBiz;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;

import com.gi.xm.platform.view.MoneyLevelInfo;
import com.gi.xm.platform.view.MoneyLevelQueryInfo;


import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.MoneyLevel;
import com.gi.xm.platform.query.MoneyLevelQuery;


import com.gi.xm.platform.facede.MoneyLevelFacede;
import com.gi.xm.platform.facede.convertor.MoneyLevelConvertor;
import com.gi.xm.platform.facede.convertor.MessageConvertor;

@Service
public class MoneyLevelFacedeImpl implements MoneyLevelFacede {

	@Autowired
	private MoneyLevelBiz moneyLevelBiz;
				
	public MessageInfo<Integer> deleteMoneyLevel(Integer id){
		
		Message<Integer> message  = moneyLevelBiz.deleteMoneyLevel(id);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Integer> createMoneyLevel(MoneyLevelInfo moneyLevelInfo){
		
		MoneyLevel moneyLevel = MoneyLevelConvertor.toMoneyLevel(moneyLevelInfo);
		Message<Integer> message  =  moneyLevelBiz.createMoneyLevel( moneyLevel );
		MessageInfo<Integer> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateMoneyLevel(MoneyLevelInfo moneyLevelInfo){
		
		MoneyLevel moneyLevel = MoneyLevelConvertor.toMoneyLevel(moneyLevelInfo);
		Message<Integer> message  =  moneyLevelBiz.updateMoneyLevel( moneyLevel );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		@Cacheable(value = "moneyLevelInfo",keyGenerator = "wiselyKeyGenerator")
	public MessageInfo<MoneyLevelInfo> getMoneyLevel( Integer id ){
		
		Message<MoneyLevel> message  = moneyLevelBiz.getMoneyLevel( id );
		MessageInfo<MoneyLevelInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		MoneyLevelInfo moneyLevelInfo = MoneyLevelConvertor.toMoneyLevelInfo(message.getData());
		messageInfo.setData(moneyLevelInfo);
		return messageInfo;
	}

    @Cacheable(value = "moneyLevelInfo",keyGenerator = "wiselyKeyGenerator")
    public MessageInfo<List<MoneyLevelInfo>> getAllMoneyLevel(){
	
		Message<List<MoneyLevel>> message  = moneyLevelBiz.getAllMoneyLevel();
		MessageInfo<List<MoneyLevelInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<MoneyLevelInfo> moneyLevelInfoList = MoneyLevelConvertor.toMoneyLevelInfoList(message.getData());
		messageInfo.setData(moneyLevelInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<MoneyLevelInfo>> queryMoneyLevel(MoneyLevelQueryInfo moneyLevelQueryInfo) {
		MoneyLevelQuery moneyLevelQuery = MoneyLevelConvertor.toMoneyLevelQuery(moneyLevelQueryInfo);
		Message<QueryResult<MoneyLevel>> message = moneyLevelBiz.queryMoneyLevel(moneyLevelQuery);
		MessageInfo<QueryResultInfo<MoneyLevelInfo>> messageInfo = new MessageInfo<QueryResultInfo<MoneyLevelInfo>>();
		QueryResultInfo<MoneyLevelInfo> queryResultInfo = MoneyLevelConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
	
}