

package com.gi.ctdn.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.dao.EventDetailDAO;
import com.gi.ctdn.view.common.MessageStatus;
import com.gi.ctdn.view.common.MessageInfo;

import com.gi.ctdn.pojo.EventDetail;

@Service("eventDetailBiz")
public class EventDetailBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(EventDetailBiz.class);

    @Autowired
	EventDetailDAO eventDetailDAO;


		
	public MessageInfo<List<EventDetail>> getListByEventId(Integer eventId){

		MessageInfo<List<EventDetail>> messageInfo = new MessageInfo<List<EventDetail>>();
		try {
			List<EventDetail> eventDetailList = eventDetailDAO.selectByEventId(eventId);
			messageInfo.setData(eventDetailList);
		} catch (Exception e) {
			LOGGER.error("getListByEventId","查询EventDetail失败", e);
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
		}
		return messageInfo;
	}


    public MessageInfo<List<EventDetail>> getAllEventDetail(){

		MessageInfo<List<EventDetail>> messageInfo = new MessageInfo<List<EventDetail>>();
		try {
			List<EventDetail> eventDetailList = eventDetailDAO.selectAll();
			messageInfo.setData( eventDetailList);
		} catch (Exception e) {
			LOGGER.error("getAllEventDetail","查询全部EventDetail失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
}