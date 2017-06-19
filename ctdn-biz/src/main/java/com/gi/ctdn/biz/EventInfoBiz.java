

package com.gi.ctdn.biz;

import com.gi.ctdn.dao.EventDetailDAO;
import com.gi.ctdn.dao.OrgInfoDAO;
import com.gi.ctdn.pojo.EventDetail;
import com.gi.ctdn.pojo.EventInfo;
import com.gi.ctdn.pojo.EventInfoList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.dao.EventInfoDAO;
import com.gi.xm.platform.view.common.MessageStatus;
import com.gi.xm.platform.view.common.MessageInfo;

import java.util.List;

@Service("eventInfoBiz")
public class EventInfoBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(EventInfoBiz.class);

    @Autowired
	EventInfoDAO eventInfoDAO;

    @Autowired
	OrgInfoDAO orgInfoDAO;

    @Autowired
	EventDetailDAO eventDetailDAO;


//
//	public MessageInfo<List<EventInfo>> getListBySourceCode(String sourceCode){
//
//		MessageInfo<List<EventInfo>> messageInfo = new MessageInfo<List<EventInfo>>();
//		try {
//			List<EventInfo> eventInfoList = eventInfoDAO.selectBySourceCode(sourceCode);
//			messageInfo.setData(eventInfoList);
//		} catch (Exception e) {
//			LOGGER.error("getListBySourceCode","查询EventInfo失败", e);
//			messageInfo.setStatus(MessageStatus.ERROR_CODE);
//		}
//		return messageInfo;
//	}
			
	public MessageInfo<EventInfoList> getByEventId(Integer eventId){
		MessageInfo<EventInfoList> messageInfo = new MessageInfo<>();

		try {
			EventInfoList eventInfoList = eventInfoDAO.selectByEventId(eventId);
			if(eventInfoList!=null){
				List<EventDetail> eventDetailList = eventDetailDAO.selectByEventId(eventId);
				eventInfoList.setEventDetailList(eventDetailList);
			}
			messageInfo.setData(eventInfoList);
		} catch (Exception e) {
			LOGGER.error("getByEventId","查询EventInfo失败", e);
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
		}
		return messageInfo;
	}

	public MessageInfo<List<EventInfo>> getListByName(String name) {
		MessageInfo<List<EventInfo>> messageInfo = new MessageInfo<List<EventInfo>>();
		try {
			List<EventInfo> eventInfo = eventInfoDAO.selectByName(name);
			messageInfo.setData(eventInfo);
		} catch (Exception e) {
			LOGGER.error("getListByName","查询EventInfo失败", e);
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
		}
		return messageInfo;
	}
}