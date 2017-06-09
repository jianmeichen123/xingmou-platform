package com.gi.ctdn.api.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.gi.ctdn.biz.EventMergerDetailBiz;
import com.gi.ctdn.pojo.EventMergerDetail;
import com.gi.xm.platform.view.common.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("eventMergerDetail")
public class EventMergerDetailController {

    @Autowired
	private EventMergerDetailBiz eventMergerDetailBiz;


    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<EventMergerDetail>> getAllEventMergerDetail(){
		MessageInfo<List<EventMergerDetail>>  messageInfo = eventMergerDetailBiz.getAllEventMergerDetail();
		return messageInfo;
	}

    @RequestMapping("getEventMergerDetailByEventId")
    @ResponseBody
    public MessageInfo<List<EventMergerDetail>> getEventMergerDetailByEventId(Integer eventId){
        MessageInfo<List<EventMergerDetail>>  messageInfo = eventMergerDetailBiz.getEventMergerDetailByEventId(eventId);
        return messageInfo;
    }

    @RequestMapping("getEventMergerDetailByProjTitle")
    @ResponseBody
    public MessageInfo<List<EventMergerDetail>> getEventMergerDetailByProjTitle(String projTitle){
        MessageInfo<List<EventMergerDetail>>  messageInfo = eventMergerDetailBiz.getEventMergerDetailByProjTitle(projTitle);
        return messageInfo;
    }
}
