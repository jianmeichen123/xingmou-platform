
package com.gi.xm.platform.facede.impl;

import java.util.List;
import java.util.Date;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.gi.xm.platform.biz.InvestorCompanyBiz;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;

import com.gi.xm.platform.view.InvestorCompanyInfo;
import com.gi.xm.platform.view.InvestorCompanyQueryInfo;


import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.InvestorCompany;
import com.gi.xm.platform.query.InvestorCompanyQuery;


import com.gi.xm.platform.facede.InvestorCompanyFacede;
import com.gi.xm.platform.facede.convertor.InvestorCompanyConvertor;
import com.gi.xm.platform.facede.convertor.MessageConvertor;

@Service
public class InvestorCompanyFacedeImpl implements InvestorCompanyFacede {

	@Autowired
	private InvestorCompanyBiz investorCompanyBiz;
				
	public MessageInfo<Integer> deleteInvestorCompany(Long id){
		
		Message<Integer> message  = investorCompanyBiz.deleteInvestorCompany(id);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Long> createInvestorCompany(InvestorCompanyInfo investorCompanyInfo){
		
		InvestorCompany investorCompany = InvestorCompanyConvertor.toInvestorCompany(investorCompanyInfo);
		Message<Long> message  =  investorCompanyBiz.createInvestorCompany( investorCompany );
		MessageInfo<Long> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateInvestorCompany(InvestorCompanyInfo investorCompanyInfo){
		
		InvestorCompany investorCompany = InvestorCompanyConvertor.toInvestorCompany(investorCompanyInfo);
		Message<Integer> message  =  investorCompanyBiz.updateInvestorCompany( investorCompany );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		public MessageInfo<Integer> changeStatus(
			Long id,
			Integer status,
			String operatorId){
			
		Message<Integer> message  = investorCompanyBiz.changeStatus(id,status,operatorId);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		public MessageInfo<InvestorCompanyInfo> getInvestorCompany( Long id ){
		
		Message<InvestorCompany> message  = investorCompanyBiz.getInvestorCompany( id );
		MessageInfo<InvestorCompanyInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		InvestorCompanyInfo investorCompanyInfo = InvestorCompanyConvertor.toInvestorCompanyInfo(message.getData());
		messageInfo.setData(investorCompanyInfo);
		return messageInfo;
	}

    public MessageInfo<List<InvestorCompanyInfo>> getAllInvestorCompany(){
	
		Message<List<InvestorCompany>> message  = investorCompanyBiz.getAllInvestorCompany();
		MessageInfo<List<InvestorCompanyInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<InvestorCompanyInfo> investorCompanyInfoList = InvestorCompanyConvertor.toInvestorCompanyInfoList(message.getData());
		messageInfo.setData(investorCompanyInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<InvestorCompanyInfo>> queryInvestorCompany(InvestorCompanyQueryInfo investorCompanyQueryInfo) {
		InvestorCompanyQuery investorCompanyQuery = InvestorCompanyConvertor.toInvestorCompanyQuery(investorCompanyQueryInfo);
		Message<QueryResult<InvestorCompany>> message = investorCompanyBiz.queryInvestorCompany(investorCompanyQuery);
		MessageInfo<QueryResultInfo<InvestorCompanyInfo>> messageInfo = new MessageInfo<QueryResultInfo<InvestorCompanyInfo>>();
		QueryResultInfo<InvestorCompanyInfo> queryResultInfo = InvestorCompanyConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
	
}