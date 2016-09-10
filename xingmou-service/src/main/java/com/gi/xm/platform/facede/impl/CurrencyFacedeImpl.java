
package com.gi.xm.platform.facede.impl;

import java.util.List;
import java.util.Date;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import com.gi.xm.platform.biz.CurrencyBiz;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;

import com.gi.xm.platform.view.CurrencyInfo;
import com.gi.xm.platform.view.CurrencyQueryInfo;


import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.Currency;
import com.gi.xm.platform.query.CurrencyQuery;


import com.gi.xm.platform.facede.CurrencyFacede;
import com.gi.xm.platform.facede.convertor.CurrencyConvertor;
import com.gi.xm.platform.facede.convertor.MessageConvertor;

@Service
public class CurrencyFacedeImpl implements CurrencyFacede {

	@Autowired
	private CurrencyBiz currencyBiz;
				
	public MessageInfo<Integer> deleteCurrency(Long id){
		
		Message<Integer> message  = currencyBiz.deleteCurrency(id);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Long> createCurrency(CurrencyInfo currencyInfo){
		
		Currency currency = CurrencyConvertor.toCurrency(currencyInfo);
		Message<Long> message  =  currencyBiz.createCurrency( currency );
		MessageInfo<Long> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateCurrency(CurrencyInfo currencyInfo){
		
		Currency currency = CurrencyConvertor.toCurrency(currencyInfo);
		Message<Integer> message  =  currencyBiz.updateCurrency( currency );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		@Cacheable(value = "currencyInfo",keyGenerator = "wiselyKeyGenerator")
	public MessageInfo<CurrencyInfo> getCurrency( Long id ){
		
		Message<Currency> message  = currencyBiz.getCurrency( id );
		MessageInfo<CurrencyInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		CurrencyInfo currencyInfo = CurrencyConvertor.toCurrencyInfo(message.getData());
		messageInfo.setData(currencyInfo);
		return messageInfo;
	}

    @Cacheable(value = "currencyInfo",keyGenerator = "wiselyKeyGenerator")
    public MessageInfo<List<CurrencyInfo>> getAllCurrency(){
	
		Message<List<Currency>> message  = currencyBiz.getAllCurrency();
		MessageInfo<List<CurrencyInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<CurrencyInfo> currencyInfoList = CurrencyConvertor.toCurrencyInfoList(message.getData());
		messageInfo.setData(currencyInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<CurrencyInfo>> queryCurrency(CurrencyQueryInfo currencyQueryInfo) {
		CurrencyQuery currencyQuery = CurrencyConvertor.toCurrencyQuery(currencyQueryInfo);
		Message<QueryResult<Currency>> message = currencyBiz.queryCurrency(currencyQuery);
		MessageInfo<QueryResultInfo<CurrencyInfo>> messageInfo = new MessageInfo<QueryResultInfo<CurrencyInfo>>();
		QueryResultInfo<CurrencyInfo> queryResultInfo = CurrencyConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
	
}