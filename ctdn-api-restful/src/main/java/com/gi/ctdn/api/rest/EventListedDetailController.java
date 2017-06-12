package com.gi.ctdn.api.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.gi.ctdn.biz.EventListedDetailBiz;
import com.gi.ctdn.pojo.EventListedDetail;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("eventListedDetail")
public class EventListedDetailController {

    @Autowired
	private EventListedDetailBiz eventListedDetailBiz;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		return new ModelAndView("eventListedDetail/index", modelMap);
	}


    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<EventListedDetail>> getAllEventListedDetail(){
		MessageInfo<List<EventListedDetail>>  messageInfo = eventListedDetailBiz.getAllEventListedDetail();
		return messageInfo;
	}


		
    @RequestMapping("getListByEventId")
    @ResponseBody
	public MessageInfo<List<EventListedDetail>> getListByEventId(Integer eventId){
		MessageInfo<List<EventListedDetail>> messageInfo = eventListedDetailBiz.getListByEventId(eventId);
		return messageInfo;
	}

}
