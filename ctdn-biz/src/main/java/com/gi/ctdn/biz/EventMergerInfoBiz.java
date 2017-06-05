

package com.gi.ctdn.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.dao.EventMergerInfoDAO;
import com.gi.xm.platform.view.common.MessageStatus;
import com.gi.xm.platform.view.common.MessageInfo;

import com.gi.ctdn.pojo.EventMergerInfo;

@Service("eventMergerInfoBiz")
public class EventMergerInfoBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(EventMergerInfoBiz.class);

    @Autowired
	EventMergerInfoDAO eventMergerInfoDAO;


		
	public MessageInfo<List<EventMergerInfo>> getListBySourceCode(String sourceCode){

		MessageInfo<List<EventMergerInfo>> messageInfo = new MessageInfo<List<EventMergerInfo>>();
		try {
			List<EventMergerInfo> eventMergerInfoList = eventMergerInfoDAO.selectBySourceCode(sourceCode);
			messageInfo.setData(eventMergerInfoList);
		} catch (Exception e) {
			LOGGER.error("getListBySourceCode","查询EventMergerInfo失败", e);
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
		}
		return messageInfo;
	}
		


    public MessageInfo<List<EventMergerInfo>> getAllEventMergerInfo(){

		MessageInfo<List<EventMergerInfo>> messageInfo = new MessageInfo<List<EventMergerInfo>>();
		try {
			List<EventMergerInfo> eventMergerInfoList = eventMergerInfoDAO.selectAll();
			messageInfo.setData( eventMergerInfoList);
		} catch (Exception e) {
			LOGGER.error("getAllEventMergerInfo","查询全部EventMergerInfo失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
}