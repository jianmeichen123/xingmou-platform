package com.gi.ctdn.api.rest;

import java.util.List;


import com.gi.ctdn.biz.EventDetailBiz;
import com.gi.ctdn.pojo.EventDetail;
import com.gi.ctdn.view.common.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("eventDetail")
public class EventDetailController {

    @Autowired
	private EventDetailBiz eventDetailBiz;



    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<EventDetail>> getAllEventDetail(){
		MessageInfo<List<EventDetail>>  messageInfo = eventDetailBiz.getAllEventDetail();
		return messageInfo;
	}


		
    @RequestMapping("getListByEventId")
    @ResponseBody
	public MessageInfo<List<EventDetail>> getListByEventId(Integer eventId){
		MessageInfo<List<EventDetail>> messageInfo = eventDetailBiz.getListByEventId(eventId);
		return messageInfo;
	}

}
