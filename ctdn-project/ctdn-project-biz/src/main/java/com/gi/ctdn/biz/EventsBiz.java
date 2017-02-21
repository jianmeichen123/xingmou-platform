

package com.gi.ctdn.biz;

import com.gi.ctdn.dao.EventsDAO;
import com.gi.ctdn.pojo.EventsInfo;
import com.gi.xm.platform.view.common.MessageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("eventsBiz")
public class EventsBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(EventsBiz.class);

    @Autowired
	EventsDAO eventsDAO;



    public MessageInfo<Long> createEvents(EventsInfo events){
		MessageInfo<Long> messageInfo = new MessageInfo<Long>();
		try {
			eventsDAO.insert( events );
			messageInfo.setData(events.getId());

		} catch (Exception e) {
			LOGGER.error("createEvents","创建Events失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

	public MessageInfo<Long> updateEvents(EventsInfo events){
		MessageInfo<Long> messageInfo = new MessageInfo<Long>();
		try {
			eventsDAO.insert( events );
			messageInfo.setData(events.getId());

		} catch (Exception e) {
			LOGGER.error("createEvents","修Events失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

	public MessageInfo<List<EventsInfo>> getListByProjectId(Long projectId){

		MessageInfo<List<EventsInfo>> messageInfo = new MessageInfo<List<EventsInfo>>();
		try {
			List<EventsInfo> eventsList = eventsDAO.selectByProjectId(projectId);
			messageInfo.setData(eventsList);
		} catch (Exception e) {
			LOGGER.error("getListByProjectId","查询Events失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}



	public MessageInfo<EventsInfo> queryById(Long id) {
		MessageInfo<EventsInfo> messageInfo = new MessageInfo<EventsInfo>();
		try {
			EventsInfo eventsInfo = eventsDAO.queryById(id);
			messageInfo.setData(eventsInfo);
		} catch (Exception e) {
			LOGGER.error("queryById", "查询Events失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

}