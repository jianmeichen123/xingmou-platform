package com.gi.ctdn.api.rest;

import com.gi.ctdn.biz.EventDetailBiz;
import com.gi.ctdn.biz.EventInfoBiz;
import com.gi.ctdn.pojo.EventInfo;
import com.gi.xm.platform.view.common.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public MessageInfo<EventInfo> getEventInfo(@PathVariable Integer eventId ){
		MessageInfo<EventInfo> messageInfo = eventInfoBiz.getByEventId(eventId);
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
