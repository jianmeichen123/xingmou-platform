
package com.gi.xm.platform.facede.impl;

import java.util.List;
import java.util.Date;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.gi.xm.platform.biz.InvestProjectInvestfirmBiz;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;

import com.gi.xm.platform.view.InvestProjectInvestfirmInfo;
import com.gi.xm.platform.view.InvestProjectInvestfirmQueryInfo;


import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.InvestProjectInvestfirm;
import com.gi.xm.platform.query.InvestProjectInvestfirmQuery;


import com.gi.xm.platform.facede.InvestProjectInvestfirmFacede;
import com.gi.xm.platform.facede.convertor.InvestProjectInvestfirmConvertor;
import com.gi.xm.platform.facede.convertor.MessageConvertor;

@Service
public class InvestProjectInvestfirmFacedeImpl implements InvestProjectInvestfirmFacede {

	@Autowired
	private InvestProjectInvestfirmBiz investProjectInvestfirmBiz;
				
	public MessageInfo<Integer> deleteInvestProjectInvestfirm(Long id){
		
		Message<Integer> message  = investProjectInvestfirmBiz.deleteInvestProjectInvestfirm(id);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Long> createInvestProjectInvestfirm(InvestProjectInvestfirmInfo investProjectInvestfirmInfo){
		
		InvestProjectInvestfirm investProjectInvestfirm = InvestProjectInvestfirmConvertor.toInvestProjectInvestfirm(investProjectInvestfirmInfo);
		Message<Long> message  =  investProjectInvestfirmBiz.createInvestProjectInvestfirm( investProjectInvestfirm );
		MessageInfo<Long> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateInvestProjectInvestfirm(InvestProjectInvestfirmInfo investProjectInvestfirmInfo){
		
		InvestProjectInvestfirm investProjectInvestfirm = InvestProjectInvestfirmConvertor.toInvestProjectInvestfirm(investProjectInvestfirmInfo);
		Message<Integer> message  =  investProjectInvestfirmBiz.updateInvestProjectInvestfirm( investProjectInvestfirm );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		public MessageInfo<InvestProjectInvestfirmInfo> getInvestProjectInvestfirm( Long id ){
		
		Message<InvestProjectInvestfirm> message  = investProjectInvestfirmBiz.getInvestProjectInvestfirm( id );
		MessageInfo<InvestProjectInvestfirmInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		InvestProjectInvestfirmInfo investProjectInvestfirmInfo = InvestProjectInvestfirmConvertor.toInvestProjectInvestfirmInfo(message.getData());
		messageInfo.setData(investProjectInvestfirmInfo);
		return messageInfo;
	}

    public MessageInfo<List<InvestProjectInvestfirmInfo>> getAllInvestProjectInvestfirm(){
	
		Message<List<InvestProjectInvestfirm>> message  = investProjectInvestfirmBiz.getAllInvestProjectInvestfirm();
		MessageInfo<List<InvestProjectInvestfirmInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<InvestProjectInvestfirmInfo> investProjectInvestfirmInfoList = InvestProjectInvestfirmConvertor.toInvestProjectInvestfirmInfoList(message.getData());
		messageInfo.setData(investProjectInvestfirmInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<InvestProjectInvestfirmInfo>> queryInvestProjectInvestfirm(InvestProjectInvestfirmQueryInfo investProjectInvestfirmQueryInfo) {
		InvestProjectInvestfirmQuery investProjectInvestfirmQuery = InvestProjectInvestfirmConvertor.toInvestProjectInvestfirmQuery(investProjectInvestfirmQueryInfo);
		Message<QueryResult<InvestProjectInvestfirm>> message = investProjectInvestfirmBiz.queryInvestProjectInvestfirm(investProjectInvestfirmQuery);
		MessageInfo<QueryResultInfo<InvestProjectInvestfirmInfo>> messageInfo = new MessageInfo<QueryResultInfo<InvestProjectInvestfirmInfo>>();
		QueryResultInfo<InvestProjectInvestfirmInfo> queryResultInfo = InvestProjectInvestfirmConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
			
	public MessageInfo<List<InvestProjectInvestfirmInfo>> getListByInvestId(Long investId){
	
		Message<List<InvestProjectInvestfirm>> message  = investProjectInvestfirmBiz.getListByInvestId(investId);
		MessageInfo<List<InvestProjectInvestfirmInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<InvestProjectInvestfirmInfo> investProjectInvestfirmInfoList = InvestProjectInvestfirmConvertor.toInvestProjectInvestfirmInfoList(message.getData());
		messageInfo.setData(investProjectInvestfirmInfoList);
		return messageInfo;	
	}
				
	public MessageInfo<List<InvestProjectInvestfirmInfo>> getListByInvestfirmId(Long investfirmId){
	
		Message<List<InvestProjectInvestfirm>> message  = investProjectInvestfirmBiz.getListByInvestfirmId(investfirmId);
		MessageInfo<List<InvestProjectInvestfirmInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<InvestProjectInvestfirmInfo> investProjectInvestfirmInfoList = InvestProjectInvestfirmConvertor.toInvestProjectInvestfirmInfoList(message.getData());
		messageInfo.setData(investProjectInvestfirmInfoList);
		return messageInfo;	
	}
				
	public MessageInfo<List<InvestProjectInvestfirmInfo>> getListByProjectId(Long projectId){
	
		Message<List<InvestProjectInvestfirm>> message  = investProjectInvestfirmBiz.getListByProjectId(projectId);
		MessageInfo<List<InvestProjectInvestfirmInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<InvestProjectInvestfirmInfo> investProjectInvestfirmInfoList = InvestProjectInvestfirmConvertor.toInvestProjectInvestfirmInfoList(message.getData());
		messageInfo.setData(investProjectInvestfirmInfoList);
		return messageInfo;	
	}
		
}