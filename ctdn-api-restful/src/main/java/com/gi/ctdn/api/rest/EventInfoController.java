package com.gi.ctdn.api.rest;

import com.gi.ctdn.biz.EventDetailBiz;
import com.gi.ctdn.biz.EventInfoBiz;
import com.gi.ctdn.pojo.EventInfo;
import com.gi.ctdn.pojo.EventInfoList;
import com.gi.ctdn.view.common.MessageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("eventInfo")
public class EventInfoController {

    @Autowired
	private EventInfoBiz eventInfoBiz;

    @Autowired
	private EventDetailBiz eventDetailBiz;

	private static final Logger LOGGER = LoggerFactory.getLogger(EventInfoController.class);

	/**
	 * 根据id查询详情
	 * @param eventId
	 * @return
	 */
	@RequestMapping(value = "getById/{eventId}", method = RequestMethod.GET)
	@ResponseBody
	public MessageInfo<EventInfoList> getEventInfo(@PathVariable Integer eventId ){
		MessageInfo<EventInfoList> messageInfo = eventInfoBiz.getByEventId(eventId);
		return messageInfo;
	}

	@RequestMapping(value = "getListByCompany", method = RequestMethod.POST)
	@ResponseBody
	public MessageInfo<EventInfo> getListByCompany(@RequestBody EventInfo eventInfo){
		MessageInfo<EventInfo>  messageInfo = eventInfoBiz.getListByName(eventInfo);
		return messageInfo;
	}

	@ApiOperation(value = "查找项目融资事件")
	@ApiImplicitParam(paramType = "body", dataType = "EventInfo", name = "eventInfo", value = "必填项:sourceCode", required = true)
	@RequestMapping(value = "queryProjectEventList",method = RequestMethod.POST)
	@ResponseBody
	public MessageInfo<List<EventInfo>> getListBySourceCode(@RequestBody EventInfo eventInfo){
		MessageInfo<List<EventInfo>> messageInfo  = eventInfoBiz.getListBySourceCode(eventInfo);
		return messageInfo;
	}


	@RequestMapping(value = "getLatestEventInfo",method = RequestMethod.POST)
	@ResponseBody
	public MessageInfo<List<EventInfo>> getLatestEventInfo(){
		MessageInfo<List<EventInfo>> messageInfo = eventInfoBiz.getByInvestDate();
		return messageInfo;
	}

	@RequestMapping(value = "getCtdnEventInfo",method = RequestMethod.POST)
	@ResponseBody
	public MessageInfo<List<EventInfo>> getCtdnEventInfo(@RequestBody EventInfo EventInfo){
		MessageInfo<List<EventInfo>> messageInfo = eventInfoBiz.getFromCtdnEventInfo(EventInfo);
		return messageInfo;

	}
}
