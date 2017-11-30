package com.gi.ctdn.api.rest;

import com.gi.ctdn.biz.CurrencyTypeBiz;
import com.gi.ctdn.biz.EventDetailBiz;
import com.gi.ctdn.biz.EventInfoBiz;
import com.gi.ctdn.pojo.EventInfo;
import com.gi.ctdn.pojo.EventInfoList;
import com.gi.ctdn.view.common.MessageInfo;
import com.gi.ctdn.view.common.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static final Logger LOGGER = LoggerFactory.getLogger(EventInfoController.class);

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

//	@RequestMapping("getListByName")
//	@ResponseBody
//	public MessageInfo<List<EventInfo>> getListByName(@RequestBody EventInfo eventInfo){
//		MessageInfo<List<EventInfo>> messageInfo = eventInfoBiz.getListByName(eventInfo.getCompany());
//		return messageInfo;
//	}


	@RequestMapping("getListByCompany")
	@ResponseBody
	public Result getListByCompany(@RequestBody EventInfo eventInfo){
		Result ret = eventInfoBiz.getListByName(eventInfo);
		return ret;
	}

	@RequestMapping("queryProjectEventList")
	@ResponseBody
	public MessageInfo<List<EventInfo>> getListBySourceCode(@RequestBody EventInfo eventInfo){
		MessageInfo<List<EventInfo>> messageInfo  = eventInfoBiz.getListBySourceCode(eventInfo);
		return messageInfo;
	}


	/**
	 * 根据id查询详情
	 * @param
	 * @return
	 */
	@RequestMapping("getLatestEventInfo")
	@ResponseBody
	public MessageInfo<List<EventInfo>> getLatestEventInfo(){
		MessageInfo<List<EventInfo>> messageInfo = eventInfoBiz.getByInvestDate();
		return messageInfo;
	}

	/**
	 *
	 */
	@RequestMapping("getCtdnEventInfo")
	@ResponseBody
	public MessageInfo<List<EventInfo>> getCtdnEventInfo(@RequestBody EventInfo EventInfo){
		MessageInfo<List<EventInfo>> messageInfo = eventInfoBiz.getFromCtdnEventInfo(EventInfo);
		return messageInfo;

	}
}
