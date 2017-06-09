package com.gi.ctdn.api.rest;

import com.gi.ctdn.biz.EventDetailBiz;
import com.gi.ctdn.biz.EventInfoBiz;
import com.gi.ctdn.pojo.EventDetail;
import com.gi.ctdn.pojo.EventInfo;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("eventInfo")
public class EventInfoController {

    @Autowired
	private EventInfoBiz eventInfoBiz;

    @Autowired
	private EventDetailBiz eventDetailBiz;

	/**
	 * 根据id查询详情
	 * @param eventId
	 * @return
	 */
	@RequestMapping("getById/{eventId}")
	@ResponseBody
	public MessageInfo<Map<String,Object>> getEventInfo(@PathVariable Integer eventId ){
		MessageInfo<Map<String,Object>> messageInfo = new MessageInfo<>();
		Map<String,Object> map = new HashMap<>();

		MessageInfo<EventInfo> eventInfoMessageInfo =  eventInfoBiz.getByEventId(eventId);
		map.put("eventInfoMessageInfo",eventInfoMessageInfo.getData());
		messageInfo.setMessage(eventInfoMessageInfo.getMessage());
		messageInfo.setStatus(eventInfoMessageInfo.getStatus());

		MessageInfo<List<EventDetail>> eventDetailInfoMessageInfo = eventDetailBiz.getListByEventId(eventId);
		map.put("eventDetailInfoMessageInfo",eventDetailInfoMessageInfo.getData());
		messageInfo.setMessage(eventDetailInfoMessageInfo.getMessage());
		messageInfo.setStatus(eventDetailInfoMessageInfo.getStatus());

		messageInfo.setData(map);
		return messageInfo;
	}

//	/**
//	 * 根据项目code查询列表
//	 * @param sourceCode
//	 * @return
//	 */
//	@RequestMapping("getListBySourceCode/{sourceCode}")
//	@ResponseBody
//	public MessageInfo<List<EventInfo>> getListBySourceCode(@PathVariable  String sourceCode){
//		MessageInfo<List<EventInfo>> messageInfo = eventInfoBiz.getListBySourceCode(sourceCode);
//		return messageInfo;
//	}
}
