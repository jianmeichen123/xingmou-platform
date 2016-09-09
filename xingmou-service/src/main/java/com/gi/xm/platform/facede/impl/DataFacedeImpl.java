
package com.gi.xm.platform.facede.impl;

import java.util.List;
import java.util.Date;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.gi.xm.platform.biz.DataBiz;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;

import com.gi.xm.platform.view.DataInfo;
import com.gi.xm.platform.view.DataQueryInfo;


import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.Data;
import com.gi.xm.platform.query.DataQuery;


import com.gi.xm.platform.facede.DataFacede;
import com.gi.xm.platform.facede.convertor.DataConvertor;
import com.gi.xm.platform.facede.convertor.MessageConvertor;

@Service
public class DataFacedeImpl implements DataFacede {

	@Autowired
	private DataBiz dataBiz;
				
	public MessageInfo<Integer> deleteData(Integer id){
		
		Message<Integer> message  = dataBiz.deleteData(id);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Integer> createData(DataInfo dataInfo){
		
		Data data = DataConvertor.toData(dataInfo);
		Message<Integer> message  =  dataBiz.createData( data );
		MessageInfo<Integer> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateData(DataInfo dataInfo){
		
		Data data = DataConvertor.toData(dataInfo);
		Message<Integer> message  =  dataBiz.updateData( data );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		public MessageInfo<DataInfo> getData( Integer id ){
		
		Message<Data> message  = dataBiz.getData( id );
		MessageInfo<DataInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		DataInfo dataInfo = DataConvertor.toDataInfo(message.getData());
		messageInfo.setData(dataInfo);
		return messageInfo;
	}

    public MessageInfo<List<DataInfo>> getAllData(){
	
		Message<List<Data>> message  = dataBiz.getAllData();
		MessageInfo<List<DataInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<DataInfo> dataInfoList = DataConvertor.toDataInfoList(message.getData());
		messageInfo.setData(dataInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<DataInfo>> queryData(DataQueryInfo dataQueryInfo) {
		DataQuery dataQuery = DataConvertor.toDataQuery(dataQueryInfo);
		Message<QueryResult<Data>> message = dataBiz.queryData(dataQuery);
		MessageInfo<QueryResultInfo<DataInfo>> messageInfo = new MessageInfo<QueryResultInfo<DataInfo>>();
		QueryResultInfo<DataInfo> queryResultInfo = DataConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
	
}