
package com.gi.xm.platform.facede.impl;

import java.util.List;
import java.util.Date;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.gi.xm.platform.biz.FilesBiz;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;

import com.gi.xm.platform.view.FilesInfo;
import com.gi.xm.platform.view.FilesQueryInfo;


import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.Files;
import com.gi.xm.platform.query.FilesQuery;


import com.gi.xm.platform.facede.FilesFacede;
import com.gi.xm.platform.facede.convertor.FilesConvertor;
import com.gi.xm.platform.facede.convertor.MessageConvertor;

@Service
public class FilesFacedeImpl implements FilesFacede {

	@Autowired
	private FilesBiz filesBiz;
				
	public MessageInfo<Integer> deleteFiles(Long id){
		
		Message<Integer> message  = filesBiz.deleteFiles(id);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Long> createFiles(FilesInfo filesInfo){
		
		Files files = FilesConvertor.toFiles(filesInfo);
		Message<Long> message  =  filesBiz.createFiles( files );
		MessageInfo<Long> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateFiles(FilesInfo filesInfo){
		
		Files files = FilesConvertor.toFiles(filesInfo);
		Message<Integer> message  =  filesBiz.updateFiles( files );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		public MessageInfo<FilesInfo> getFiles( Long id ){
		
		Message<Files> message  = filesBiz.getFiles( id );
		MessageInfo<FilesInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		FilesInfo filesInfo = FilesConvertor.toFilesInfo(message.getData());
		messageInfo.setData(filesInfo);
		return messageInfo;
	}

    public MessageInfo<List<FilesInfo>> getAllFiles(){
	
		Message<List<Files>> message  = filesBiz.getAllFiles();
		MessageInfo<List<FilesInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<FilesInfo> filesInfoList = FilesConvertor.toFilesInfoList(message.getData());
		messageInfo.setData(filesInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<FilesInfo>> queryFiles(FilesQueryInfo filesQueryInfo) {
		FilesQuery filesQuery = FilesConvertor.toFilesQuery(filesQueryInfo);
		Message<QueryResult<Files>> message = filesBiz.queryFiles(filesQuery);
		MessageInfo<QueryResultInfo<FilesInfo>> messageInfo = new MessageInfo<QueryResultInfo<FilesInfo>>();
		QueryResultInfo<FilesInfo> queryResultInfo = FilesConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
			
	public MessageInfo<List<FilesInfo>> getListBySourceId(Long sourceId){
	
		Message<List<Files>> message  = filesBiz.getListBySourceId(sourceId);
		MessageInfo<List<FilesInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<FilesInfo> filesInfoList = FilesConvertor.toFilesInfoList(message.getData());
		messageInfo.setData(filesInfoList);
		return messageInfo;	
	}
		
}