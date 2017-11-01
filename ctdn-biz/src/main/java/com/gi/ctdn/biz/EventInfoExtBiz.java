

package com.gi.ctdn.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.dao.EventInfoExtDAO;
import com.gi.ctdn.view.common.MessageStatus;
import com.gi.ctdn.view.common.MessageInfo;

import com.gi.ctdn.pojo.EventInfoExt;

@Service("eventInfoExtBiz")
public class EventInfoExtBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(EventInfoExtBiz.class);

    @Autowired
	EventInfoExtDAO eventInfoExtDAO;


		
	public MessageInfo<List<EventInfoExt>> getListByInvstoridType(Integer invstorid){

		MessageInfo<List<EventInfoExt>> messageInfo = new MessageInfo<List<EventInfoExt>>();
		try {
			List<EventInfoExt> eventInfoExtList = eventInfoExtDAO.selectByInvstoridType(invstorid);
			messageInfo.setData(eventInfoExtList);
		} catch (Exception e) {
			LOGGER.error("getListByInvstoridType","查询EventInfoExt失败", e);
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
		}
		return messageInfo;
	}
		


    public MessageInfo<List<EventInfoExt>> getAllEventInfoExt(){

		MessageInfo<List<EventInfoExt>> messageInfo = new MessageInfo<List<EventInfoExt>>();
		try {
			List<EventInfoExt> eventInfoExtList = eventInfoExtDAO.selectAll();
			messageInfo.setData( eventInfoExtList);
		} catch (Exception e) {
			LOGGER.error("getAllEventInfoExt","查询全部EventInfoExt失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
}