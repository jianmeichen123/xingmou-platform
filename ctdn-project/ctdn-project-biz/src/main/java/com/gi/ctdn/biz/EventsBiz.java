

package com.gi.ctdn.biz;

import com.gi.ctdn.dao.EventsDAO;
import com.gi.ctdn.pojo.EventsInfo;
import com.gi.ctdn.query.EventsQueryInfo;
import com.gi.ctdn.util.DateUtil;
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



    public MessageInfo<Long> createEvents(EventsInfo eventsInfo){
		MessageInfo<Long> messageInfo = new MessageInfo<Long>();
		try {
			eventsInfo.setAddTime(DateUtil.getNow());
			eventsDAO.insert( eventsInfo );
			messageInfo.setData(eventsInfo.getId());

		} catch (Exception e) {
			LOGGER.error("createEvents","创建Events失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

	public MessageInfo<Long> updateEvents(EventsInfo eventsInfo){
		MessageInfo<Long> messageInfo = new MessageInfo<Long>();
		try {
			eventsInfo.setUpdateTime(DateUtil.getNow());
			eventsDAO.update( eventsInfo );
			messageInfo.setData(eventsInfo.getId());
		} catch (Exception e) {
			LOGGER.error("updateEvents","修Events失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

	public MessageInfo<List<EventsInfo>> getListByProjectId(Long projectId){

		MessageInfo<List<EventsInfo>> messageInfo = new MessageInfo<List<EventsInfo>>();
		try {
			List<EventsInfo> eventsList = eventsDAO.queryByProjectId(projectId);
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

	public MessageInfo<List<EventsInfo>> queryListByProjects(List<Long> idList) {
		MessageInfo<List<EventsInfo>> messageInfo = new MessageInfo<List<EventsInfo>>();
		try {
			EventsQueryInfo eventQuery = new EventsQueryInfo();
			eventQuery.setProjectIdList(idList);
			List<EventsInfo> eventList = eventsDAO.queryListByProjects(eventQuery);
			messageInfo.setData(eventList);
		} catch (Exception e) {
			LOGGER.error("queryListByProjects", "查询Events失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

	public MessageInfo<Integer> deleteById(Long id) {
		MessageInfo<Integer> messageInfo = new MessageInfo<Integer>();
		try {
			int ret = eventsDAO.deleteById(id);
			messageInfo.setData(ret);
		} catch (Exception e) {
			LOGGER.error("deleteById", "删除Events失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
}