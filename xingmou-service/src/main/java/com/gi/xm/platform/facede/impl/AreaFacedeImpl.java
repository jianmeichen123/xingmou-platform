
package com.gi.xm.platform.facede.impl;

import java.util.List;
import java.util.Date;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.gi.xm.platform.biz.AreaBiz;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;

import com.gi.xm.platform.view.AreaInfo;
import com.gi.xm.platform.view.AreaQueryInfo;


import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.Area;
import com.gi.xm.platform.query.AreaQuery;


import com.gi.xm.platform.facede.AreaFacede;
import com.gi.xm.platform.facede.convertor.AreaConvertor;
import com.gi.xm.platform.facede.convertor.MessageConvertor;

@Service
public class AreaFacedeImpl implements AreaFacede {

	@Autowired
	private AreaBiz areaBiz;
				
	public MessageInfo<Integer> deleteArea(Long id){
		
		Message<Integer> message  = areaBiz.deleteArea(id);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Long> createArea(AreaInfo areaInfo){
		
		Area area = AreaConvertor.toArea(areaInfo);
		Message<Long> message  =  areaBiz.createArea( area );
		MessageInfo<Long> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateArea(AreaInfo areaInfo){
		
		Area area = AreaConvertor.toArea(areaInfo);
		Message<Integer> message  =  areaBiz.updateArea( area );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		public MessageInfo<AreaInfo> getArea( Long id ){
		
		Message<Area> message  = areaBiz.getArea( id );
		MessageInfo<AreaInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		AreaInfo areaInfo = AreaConvertor.toAreaInfo(message.getData());
		messageInfo.setData(areaInfo);
		return messageInfo;
	}

    public MessageInfo<List<AreaInfo>> getAllArea(){
	
		Message<List<Area>> message  = areaBiz.getAllArea();
		MessageInfo<List<AreaInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<AreaInfo> areaInfoList = AreaConvertor.toAreaInfoList(message.getData());
		messageInfo.setData(areaInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<AreaInfo>> queryArea(AreaQueryInfo areaQueryInfo) {
		AreaQuery areaQuery = AreaConvertor.toAreaQuery(areaQueryInfo);
		Message<QueryResult<Area>> message = areaBiz.queryArea(areaQuery);
		MessageInfo<QueryResultInfo<AreaInfo>> messageInfo = new MessageInfo<QueryResultInfo<AreaInfo>>();
		QueryResultInfo<AreaInfo> queryResultInfo = AreaConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
	
}