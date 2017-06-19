package com.gi.ctdn.api.rest;

import com.gi.ctdn.biz.EventDetailBiz;
import com.gi.ctdn.biz.EventInfoBiz;
import com.gi.ctdn.pojo.EventInfo;
import com.gi.ctdn.pojo.EventInfoList;
import com.gi.xm.platform.view.common.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
	public MessageInfo<EventInfoList> getEventInfo(@PathVariable Integer eventId ){
		MessageInfo<EventInfoList> messageInfo = eventInfoBiz.getByEventId(eventId);
		return messageInfo;
	}

	@RequestMapping("getListByName")
	@ResponseBody
	public MessageInfo<List<EventInfo>> getListByName(@RequestBody EventInfo eventInfo){
		MessageInfo<List<EventInfo>> messageInfo = eventInfoBiz.getListByName(eventInfo.getCompany());
		return messageInfo;
	}
}
