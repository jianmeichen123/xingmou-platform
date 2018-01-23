

package com.gi.ctdn.biz;

import java.util.List;

import com.gi.ctdn.dao.EventMergerDetailDAO;
import com.gi.ctdn.pojo.EventMergerDetail;
import com.gi.ctdn.pojo.EventMergerInfo;
import com.gi.ctdn.pojo.EventMergerInfoSon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.dao.EventMergerInfoDAO;
import com.gi.ctdn.view.common.MessageStatus;
import com.gi.ctdn.view.common.MessageInfo;

@Service("eventMergerInfoBiz")
public class EventMergerInfoBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(EventMergerInfoBiz.class);

    @Autowired
	EventMergerInfoDAO eventMergerInfoDAO;

    @Autowired
	EventMergerDetailDAO eventMergerDetailDAO;

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


	public MessageInfo<EventMergerInfoSon> getListByEventId(Integer eventId){

		MessageInfo<EventMergerInfoSon> messageInfo = new MessageInfo<EventMergerInfoSon>();
		try {
			EventMergerInfoSon eventMergerInfoSon = eventMergerInfoDAO.selectByEventId(eventId);
			if(eventMergerInfoSon!=null){

				List<EventMergerDetail> mergerSideList = eventMergerDetailDAO.selectEventMergerDetailByEventIdAndPartyB(eventId);
				List<EventMergerDetail> beenMergerSideList = eventMergerDetailDAO.selectEventMergerDetailByEventIdAndPartyC(eventId);

				eventMergerInfoSon.setMergeSideList(mergerSideList);
				eventMergerInfoSon.setBeenMergeSideList(beenMergerSideList);

			}
			messageInfo.setData(eventMergerInfoSon);
		} catch (Exception e) {
			LOGGER.error("getListByEventId","查询EventMergerInfo失败", e);
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
		}
		return messageInfo;
	}

	public MessageInfo<Integer> getMergerCount(){
		MessageInfo<Integer> messageInfo = new MessageInfo<>();
		try{
			Integer count = eventMergerInfoDAO.selectMergerCount();
			messageInfo.setData(count);
			messageInfo.setStatus(MessageStatus.OK_CODE);
			messageInfo.setMessage(MessageStatus.OK_MESSAGE);
		}catch (Exception e){
			LOGGER.error(e.getMessage());
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
			messageInfo.setMessage(MessageStatus.ERROR_MESSAGE);
		}
		return messageInfo;
	}
}