
package com.gi.xm.platform.facede.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import com.alibaba.dubbo.config.annotation.Service;
import com.gi.xm.platform.biz.CompanyBiz;
import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.facede.CompanyFacede;
import com.gi.xm.platform.facede.convertor.CompanyConvertor;
import com.gi.xm.platform.facede.convertor.MessageConvertor;
import com.gi.xm.platform.pojo.Company;
import com.gi.xm.platform.query.CompanyQuery;
import com.gi.xm.platform.view.CompanyInfo;
import com.gi.xm.platform.view.CompanyQueryInfo;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;

@Service
public class CompanyFacedeImpl implements CompanyFacede {

	@Autowired
	private CompanyBiz companyBiz;
				
		
    
	@Cacheable(value = "companyInfo",keyGenerator = "wiselyKeyGenerator")
	public MessageInfo<CompanyInfo> getCompany( Long id ){
		
		Message<Company> message  = companyBiz.getCompany( id );
		MessageInfo<CompanyInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		CompanyInfo companyInfo = CompanyConvertor.toCompanyInfo(message.getData());
		messageInfo.setData(companyInfo);
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