
package com.gi.xm.platform.facede.impl;

import java.util.List;
import java.util.Date;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.gi.xm.platform.biz.CompanyBiz;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;

import com.gi.xm.platform.view.CompanyInfo;
import com.gi.xm.platform.view.CompanyQueryInfo;


import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.Company;
import com.gi.xm.platform.query.CompanyQuery;


import com.gi.xm.platform.facede.CompanyFacede;
import com.gi.xm.platform.facede.convertor.CompanyConvertor;
import com.gi.xm.platform.facede.convertor.MessageConvertor;

@Service
public class CompanyFacedeImpl implements CompanyFacede {

	@Autowired
	private CompanyBiz companyBiz;
				
	public MessageInfo<Integer> deleteCompany(Long id){
		
		Message<Integer> message  = companyBiz.deleteCompany(id);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Long> createCompany(CompanyInfo companyInfo){
		
		Company company = CompanyConvertor.toCompany(companyInfo);
		Message<Long> message  =  companyBiz.createCompany( company );
		MessageInfo<Long> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateCompany(CompanyInfo companyInfo){
		
		Company company = CompanyConvertor.toCompany(companyInfo);
		Message<Integer> message  =  companyBiz.updateCompany( company );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		public MessageInfo<CompanyInfo> getCompany( Long id ){
		
		Message<Company> message  = companyBiz.getCompany( id );
		MessageInfo<CompanyInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		CompanyInfo companyInfo = CompanyConvertor.toCompanyInfo(message.getData());
		messageInfo.setData(companyInfo);
		return messageInfo;
	}

    public MessageInfo<List<CompanyInfo>> getAllCompany(){
	
		Message<List<Company>> message  = companyBiz.getAllCompany();
		MessageInfo<List<CompanyInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<CompanyInfo> companyInfoList = CompanyConvertor.toCompanyInfoList(message.getData());
		messageInfo.setData(companyInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<CompanyInfo>> queryCompany(CompanyQueryInfo companyQueryInfo) {
		CompanyQuery companyQuery = CompanyConvertor.toCompanyQuery(companyQueryInfo);
		Message<QueryResult<Company>> message = companyBiz.queryCompany(companyQuery);
		MessageInfo<QueryResultInfo<CompanyInfo>> messageInfo = new MessageInfo<QueryResultInfo<CompanyInfo>>();
		QueryResultInfo<CompanyInfo> queryResultInfo = CompanyConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
	
}