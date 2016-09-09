
package com.gi.xm.platform.facede.impl;

import java.util.List;
import java.util.Date;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.gi.xm.platform.biz.LabelBiz;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;

import com.gi.xm.platform.view.LabelInfo;
import com.gi.xm.platform.view.LabelQueryInfo;


import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.Label;
import com.gi.xm.platform.query.LabelQuery;


import com.gi.xm.platform.facede.LabelFacede;
import com.gi.xm.platform.facede.convertor.LabelConvertor;
import com.gi.xm.platform.facede.convertor.MessageConvertor;

@Service
public class LabelFacedeImpl implements LabelFacede {

	@Autowired
	private LabelBiz labelBiz;
				
	public MessageInfo<Integer> deleteLabel(Long id){
		
		Message<Integer> message  = labelBiz.deleteLabel(id);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Long> createLabel(LabelInfo labelInfo){
		
		Label label = LabelConvertor.toLabel(labelInfo);
		Message<Long> message  =  labelBiz.createLabel( label );
		MessageInfo<Long> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateLabel(LabelInfo labelInfo){
		
		Label label = LabelConvertor.toLabel(labelInfo);
		Message<Integer> message  =  labelBiz.updateLabel( label );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		public MessageInfo<LabelInfo> getLabel( Long id ){
		
		Message<Label> message  = labelBiz.getLabel( id );
		MessageInfo<LabelInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		LabelInfo labelInfo = LabelConvertor.toLabelInfo(message.getData());
		messageInfo.setData(labelInfo);
		return messageInfo;
	}

    public MessageInfo<List<LabelInfo>> getAllLabel(){
	
		Message<List<Label>> message  = labelBiz.getAllLabel();
		MessageInfo<List<LabelInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<LabelInfo> labelInfoList = LabelConvertor.toLabelInfoList(message.getData());
		messageInfo.setData(labelInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<LabelInfo>> queryLabel(LabelQueryInfo labelQueryInfo) {
		LabelQuery labelQuery = LabelConvertor.toLabelQuery(labelQueryInfo);
		Message<QueryResult<Label>> message = labelBiz.queryLabel(labelQuery);
		MessageInfo<QueryResultInfo<LabelInfo>> messageInfo = new MessageInfo<QueryResultInfo<LabelInfo>>();
		QueryResultInfo<LabelInfo> queryResultInfo = LabelConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
	
}