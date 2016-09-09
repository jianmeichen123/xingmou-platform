
package com.gi.xm.platform.facede.impl;

import java.util.List;
import java.util.Date;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.gi.xm.platform.biz.InvestorStudyBiz;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;

import com.gi.xm.platform.view.InvestorStudyInfo;
import com.gi.xm.platform.view.InvestorStudyQueryInfo;


import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.InvestorStudy;
import com.gi.xm.platform.query.InvestorStudyQuery;


import com.gi.xm.platform.facede.InvestorStudyFacede;
import com.gi.xm.platform.facede.convertor.InvestorStudyConvertor;
import com.gi.xm.platform.facede.convertor.MessageConvertor;

@Service
public class InvestorStudyFacedeImpl implements InvestorStudyFacede {

	@Autowired
	private InvestorStudyBiz investorStudyBiz;
				
	public MessageInfo<Integer> deleteInvestorStudy(Long id){
		
		Message<Integer> message  = investorStudyBiz.deleteInvestorStudy(id);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Long> createInvestorStudy(InvestorStudyInfo investorStudyInfo){
		
		InvestorStudy investorStudy = InvestorStudyConvertor.toInvestorStudy(investorStudyInfo);
		Message<Long> message  =  investorStudyBiz.createInvestorStudy( investorStudy );
		MessageInfo<Long> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateInvestorStudy(InvestorStudyInfo investorStudyInfo){
		
		InvestorStudy investorStudy = InvestorStudyConvertor.toInvestorStudy(investorStudyInfo);
		Message<Integer> message  =  investorStudyBiz.updateInvestorStudy( investorStudy );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		public MessageInfo<InvestorStudyInfo> getInvestorStudy( Long id ){
		
		Message<InvestorStudy> message  = investorStudyBiz.getInvestorStudy( id );
		MessageInfo<InvestorStudyInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		InvestorStudyInfo investorStudyInfo = InvestorStudyConvertor.toInvestorStudyInfo(message.getData());
		messageInfo.setData(investorStudyInfo);
		return messageInfo;
	}

    public MessageInfo<List<InvestorStudyInfo>> getAllInvestorStudy(){
	
		Message<List<InvestorStudy>> message  = investorStudyBiz.getAllInvestorStudy();
		MessageInfo<List<InvestorStudyInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<InvestorStudyInfo> investorStudyInfoList = InvestorStudyConvertor.toInvestorStudyInfoList(message.getData());
		messageInfo.setData(investorStudyInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<InvestorStudyInfo>> queryInvestorStudy(InvestorStudyQueryInfo investorStudyQueryInfo) {
		InvestorStudyQuery investorStudyQuery = InvestorStudyConvertor.toInvestorStudyQuery(investorStudyQueryInfo);
		Message<QueryResult<InvestorStudy>> message = investorStudyBiz.queryInvestorStudy(investorStudyQuery);
		MessageInfo<QueryResultInfo<InvestorStudyInfo>> messageInfo = new MessageInfo<QueryResultInfo<InvestorStudyInfo>>();
		QueryResultInfo<InvestorStudyInfo> queryResultInfo = InvestorStudyConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
	
}