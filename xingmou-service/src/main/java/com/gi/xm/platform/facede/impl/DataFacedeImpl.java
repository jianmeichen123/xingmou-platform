
package com.gi.xm.platform.facede.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.gi.xm.platform.biz.DataBiz;
import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.facede.DataFacede;
import com.gi.xm.platform.facede.convertor.DataConvertor;
import com.gi.xm.platform.facede.convertor.MessageConvertor;
import com.gi.xm.platform.pojo.Data;
import com.gi.xm.platform.view.DataInfo;
import com.gi.xm.platform.view.common.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class 	DataFacedeImpl implements DataFacede {

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


	
}