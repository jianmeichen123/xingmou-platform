

package com.gi.ctdn.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.dao.EventListedDetailDAO;
import com.gi.ctdn.view.common.MessageStatus;
import com.gi.ctdn.view.common.MessageInfo;

import com.gi.ctdn.pojo.EventListedDetail;

@Service("eventListedDetailBiz")
public class EventListedDetailBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(EventListedDetailBiz.class);

    @Autowired
	EventListedDetailDAO eventListedDetailDAO;


		
	public MessageInfo<List<EventListedDetail>> getListByEventId(Integer eventId){

		MessageInfo<List<EventListedDetail>> messageInfo = new MessageInfo<List<EventListedDetail>>();
		try {
			List<EventListedDetail> eventListedDetailList = eventListedDetailDAO.selectByEventId(eventId);
			messageInfo.setData(eventListedDetailList);
		} catch (Exception e) {
			LOGGER.error("getListByEventId","查询EventListedDetail失败", e);
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
		}
		return messageInfo;
	}

    public MessageInfo<List<EventListedDetail>> getAllEventListedDetail(){

		MessageInfo<List<EventListedDetail>> messageInfo = new MessageInfo<List<EventListedDetail>>();
		try {
			List<EventListedDetail> eventListedDetailList = eventListedDetailDAO.selectAll();
			messageInfo.setData( eventListedDetailList);
		} catch (Exception e) {
			LOGGER.error("getAllEventListedDetail","查询全部EventListedDetail失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
}