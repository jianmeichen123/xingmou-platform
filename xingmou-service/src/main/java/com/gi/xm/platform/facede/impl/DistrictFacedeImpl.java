
package com.gi.xm.platform.facede.impl;

import java.util.List;
import java.util.Date;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.gi.xm.platform.biz.DistrictBiz;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;

import com.gi.xm.platform.view.DistrictInfo;
import com.gi.xm.platform.view.DistrictQueryInfo;


import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.District;
import com.gi.xm.platform.query.DistrictQuery;


import com.gi.xm.platform.facede.DistrictFacede;
import com.gi.xm.platform.facede.convertor.DistrictConvertor;
import com.gi.xm.platform.facede.convertor.MessageConvertor;

@Service
public class DistrictFacedeImpl implements DistrictFacede {

	@Autowired
	private DistrictBiz districtBiz;
				
	public MessageInfo<Integer> deleteDistrict(Integer id){
		
		Message<Integer> message  = districtBiz.deleteDistrict(id);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Integer> createDistrict(DistrictInfo districtInfo){
		
		District district = DistrictConvertor.toDistrict(districtInfo);
		Message<Integer> message  =  districtBiz.createDistrict( district );
		MessageInfo<Integer> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateDistrict(DistrictInfo districtInfo){
		
		District district = DistrictConvertor.toDistrict(districtInfo);
		Message<Integer> message  =  districtBiz.updateDistrict( district );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		public MessageInfo<DistrictInfo> getDistrict( Integer id ){
		
		Message<District> message  = districtBiz.getDistrict( id );
		MessageInfo<DistrictInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		DistrictInfo districtInfo = DistrictConvertor.toDistrictInfo(message.getData());
		messageInfo.setData(districtInfo);
		return messageInfo;
	}

    public MessageInfo<List<DistrictInfo>> getAllDistrict(){
	
		Message<List<District>> message  = districtBiz.getAllDistrict();
		MessageInfo<List<DistrictInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<DistrictInfo> districtInfoList = DistrictConvertor.toDistrictInfoList(message.getData());
		messageInfo.setData(districtInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<DistrictInfo>> queryDistrict(DistrictQueryInfo districtQueryInfo) {
		DistrictQuery districtQuery = DistrictConvertor.toDistrictQuery(districtQueryInfo);
		Message<QueryResult<District>> message = districtBiz.queryDistrict(districtQuery);
		MessageInfo<QueryResultInfo<DistrictInfo>> messageInfo = new MessageInfo<QueryResultInfo<DistrictInfo>>();
		QueryResultInfo<DistrictInfo> queryResultInfo = DistrictConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
			
	public MessageInfo<List<DistrictInfo>> getListByUpidDisplayorder(Integer upid, Integer displayorder){
	
		Message<List<District>> message  = districtBiz.getListByUpidDisplayorder(upid, displayorder);
		MessageInfo<List<DistrictInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<DistrictInfo> districtInfoList = DistrictConvertor.toDistrictInfoList(message.getData());
		messageInfo.setData(districtInfoList);
		return messageInfo;	
	}
		
}