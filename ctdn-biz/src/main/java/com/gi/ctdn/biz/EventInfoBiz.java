

package com.gi.ctdn.biz;

import java.util.List;

import com.gi.ctdn.pojo.ProjectList;
import com.gi.xm.platform.view.common.QueryResultInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.dao.EventInfoDAO;
import com.gi.xm.platform.view.common.MessageStatus;
import com.gi.xm.platform.view.common.MessageInfo;

import com.gi.ctdn.pojo.EventInfo;

@Service("eventInfoBiz")
public class EventInfoBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(EventInfoBiz.class);

    @Autowired
	EventInfoDAO eventInfoDAO;


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
			
	public MessageInfo<EventInfo> getByEventId(Integer eventId){

		MessageInfo<EventInfo> messageInfo = new MessageInfo<EventInfo>();
		try {
			EventInfo eventInfo = eventInfoDAO.selectByEventId(eventId);
			messageInfo.setData(eventInfo);
		} catch (Exception e) {
			LOGGER.error("getListByEventId","查询EventInfo失败", e);
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
		}
		return messageInfo;
	}

}