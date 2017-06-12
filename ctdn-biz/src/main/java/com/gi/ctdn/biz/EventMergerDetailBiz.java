

package com.gi.ctdn.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.dao.EventMergerDetailDAO;
import com.gi.xm.platform.view.common.MessageStatus;
import com.gi.xm.platform.view.common.MessageInfo;

import com.gi.ctdn.pojo.EventMergerDetail;

@Service("eventMergerDetailBiz")
public class EventMergerDetailBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(EventMergerDetailBiz.class);

    @Autowired
	EventMergerDetailDAO eventMergerDetailDAO;


    public MessageInfo<List<EventMergerDetail>> getAllEventMergerDetail(){

		MessageInfo<List<EventMergerDetail>> messageInfo = new MessageInfo<List<EventMergerDetail>>();
		try {
			List<EventMergerDetail> eventMergerDetailList = eventMergerDetailDAO.selectAll();
			messageInfo.setData( eventMergerDetailList);
		} catch (Exception e) {
			LOGGER.error("getAllEventMergerDetail","查询全部EventMergerDetail失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

	public MessageInfo<List<EventMergerDetail>> getEventMergerDetailByEventId(Integer eventId){

		MessageInfo<List<EventMergerDetail>> messageInfo = new MessageInfo<List<EventMergerDetail>>();
		try {
			List<EventMergerDetail> eventMergerDetailList = eventMergerDetailDAO.getEventMergerDetailByEventId(eventId);
			messageInfo.setData( eventMergerDetailList);
		} catch (Exception e) {
			LOGGER.error("getEventMergerDetailByEventId","查询全部getEventMergerDetailByEventId失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}


}