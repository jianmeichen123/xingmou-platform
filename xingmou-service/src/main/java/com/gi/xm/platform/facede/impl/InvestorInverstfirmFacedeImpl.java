
package com.gi.xm.platform.facede.impl;

import java.util.List;
import java.util.Date;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.gi.xm.platform.biz.InvestorInverstfirmBiz;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;

import com.gi.xm.platform.view.InvestorInverstfirmInfo;
import com.gi.xm.platform.view.InvestorInverstfirmQueryInfo;


import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.InvestorInverstfirm;
import com.gi.xm.platform.query.InvestorInverstfirmQuery;


import com.gi.xm.platform.facede.InvestorInverstfirmFacede;
import com.gi.xm.platform.facede.convertor.InvestorInverstfirmConvertor;
import com.gi.xm.platform.facede.convertor.MessageConvertor;

@Service
public class InvestorInverstfirmFacedeImpl implements InvestorInverstfirmFacede {

	@Autowired
	private InvestorInverstfirmBiz investorInverstfirmBiz;
				
	public MessageInfo<Integer> deleteInvestorInverstfirm(Long id){
		
		Message<Integer> message  = investorInverstfirmBiz.deleteInvestorInverstfirm(id);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Long> createInvestorInverstfirm(InvestorInverstfirmInfo investorInverstfirmInfo){
		
		InvestorInverstfirm investorInverstfirm = InvestorInverstfirmConvertor.toInvestorInverstfirm(investorInverstfirmInfo);
		Message<Long> message  =  investorInverstfirmBiz.createInvestorInverstfirm( investorInverstfirm );
		MessageInfo<Long> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateInvestorInverstfirm(InvestorInverstfirmInfo investorInverstfirmInfo){
		
		InvestorInverstfirm investorInverstfirm = InvestorInverstfirmConvertor.toInvestorInverstfirm(investorInverstfirmInfo);
		Message<Integer> message  =  investorInverstfirmBiz.updateInvestorInverstfirm( investorInverstfirm );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		public MessageInfo<InvestorInverstfirmInfo> getInvestorInverstfirm( Long id ){
		
		Message<InvestorInverstfirm> message  = investorInverstfirmBiz.getInvestorInverstfirm( id );
		MessageInfo<InvestorInverstfirmInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		InvestorInverstfirmInfo investorInverstfirmInfo = InvestorInverstfirmConvertor.toInvestorInverstfirmInfo(message.getData());
		messageInfo.setData(investorInverstfirmInfo);
		return messageInfo;
	}

    public MessageInfo<List<InvestorInverstfirmInfo>> getAllInvestorInverstfirm(){
	
		Message<List<InvestorInverstfirm>> message  = investorInverstfirmBiz.getAllInvestorInverstfirm();
		MessageInfo<List<InvestorInverstfirmInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<InvestorInverstfirmInfo> investorInverstfirmInfoList = InvestorInverstfirmConvertor.toInvestorInverstfirmInfoList(message.getData());
		messageInfo.setData(investorInverstfirmInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<InvestorInverstfirmInfo>> queryInvestorInverstfirm(InvestorInverstfirmQueryInfo investorInverstfirmQueryInfo) {
		InvestorInverstfirmQuery investorInverstfirmQuery = InvestorInverstfirmConvertor.toInvestorInverstfirmQuery(investorInverstfirmQueryInfo);
		Message<QueryResult<InvestorInverstfirm>> message = investorInverstfirmBiz.queryInvestorInverstfirm(investorInverstfirmQuery);
		MessageInfo<QueryResultInfo<InvestorInverstfirmInfo>> messageInfo = new MessageInfo<QueryResultInfo<InvestorInverstfirmInfo>>();
		QueryResultInfo<InvestorInverstfirmInfo> queryResultInfo = InvestorInverstfirmConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
	
}