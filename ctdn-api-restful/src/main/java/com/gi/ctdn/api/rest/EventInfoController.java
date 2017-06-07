package com.gi.ctdn.api.rest;

import com.gi.ctdn.biz.EventInfoBiz;
import com.gi.ctdn.pojo.EventInfo;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("eventInfo")
public class EventInfoController {

    @Autowired
	private EventInfoBiz eventInfoBiz;

	/**
	 * 根据id查询详情
	 * @param eventId
	 * @return
	 */
	@RequestMapping("getById")
	@ResponseBody
	public MessageInfo<EventInfo> getEventInfo( Integer eventId ){
		MessageInfo<EventInfo> messageInfo =  eventInfoBiz.getByEventId(eventId);
		return messageInfo;
	}

	/**
	 * 根据项目code查询列表
	 * @param sourceCode
	 * @return
	 */
	@RequestMapping("getListBySourceCode/{sourceCode}")
	@ResponseBody
	public MessageInfo<List<EventInfo>> getListBySourceCode(@PathVariable  String sourceCode){
		MessageInfo<List<EventInfo>> messageInfo = eventInfoBiz.getListBySourceCode(sourceCode);
		return messageInfo;
	}
}
