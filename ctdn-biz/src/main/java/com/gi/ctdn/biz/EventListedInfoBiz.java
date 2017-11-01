

package com.gi.ctdn.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.dao.EventListedInfoDAO;
import com.gi.ctdn.view.common.MessageStatus;
import com.gi.ctdn.view.common.MessageInfo;

import com.gi.ctdn.pojo.EventListedInfo;

@Service("eventListedInfoBiz")
public class EventListedInfoBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(EventListedInfoBiz.class);

    @Autowired
	EventListedInfoDAO eventListedInfoDAO;


		
	public MessageInfo<EventListedInfo> getByEventId(Integer eventId){

		MessageInfo<EventListedInfo> messageInfo = new MessageInfo<EventListedInfo>();
		try {
			EventListedInfo eventListedInfo = eventListedInfoDAO.selectByEventId(eventId);
			messageInfo.setData(eventListedInfo);
		} catch (Exception e) {
			LOGGER.error("getListByEventId","查询EventListedInfo失败", e);
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
		}
		return messageInfo;
	}
			
	public MessageInfo<List<EventListedInfo>> getListBySourceCode(String sourceCode){

		MessageInfo<List<EventListedInfo>> messageInfo = new MessageInfo<List<EventListedInfo>>();
		try {
			List<EventListedInfo> eventListedInfoList = eventListedInfoDAO.selectBySourceCode(sourceCode);
			messageInfo.setData(eventListedInfoList);
		} catch (Exception e) {
			LOGGER.error("getListBySourceCode","查询EventListedInfo失败", e);
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
		}
		return messageInfo;
	}
		


    public MessageInfo<List<EventListedInfo>> getAllEventListedInfo(){

		MessageInfo<List<EventListedInfo>> messageInfo = new MessageInfo<List<EventListedInfo>>();
		try {
			List<EventListedInfo> eventListedInfoList = eventListedInfoDAO.selectAll();
			messageInfo.setData( eventListedInfoList);
		} catch (Exception e) {
			LOGGER.error("getAllEventListedInfo","查询全部EventListedInfo失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
}