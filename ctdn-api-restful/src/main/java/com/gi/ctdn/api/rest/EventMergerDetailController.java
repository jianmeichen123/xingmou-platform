package com.gi.ctdn.api.rest;

import java.util.List;


import com.gi.ctdn.biz.EventMergerDetailBiz;
import com.gi.ctdn.pojo.EventMergerDetail;
import com.gi.ctdn.view.common.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


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

}
