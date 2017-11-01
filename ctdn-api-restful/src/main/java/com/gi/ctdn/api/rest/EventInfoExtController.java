package com.gi.ctdn.api.rest;

import java.util.List;

import com.gi.ctdn.biz.EventInfoExtBiz;
import com.gi.ctdn.pojo.EventInfoExt;
import com.gi.ctdn.view.common.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("eventInfoExt")
public class EventInfoExtController {

    @Autowired
	private EventInfoExtBiz eventInfoExtBiz;



    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<EventInfoExt>> getAllEventInfoExt(){
		MessageInfo<List<EventInfoExt>> messageInfo = eventInfoExtBiz.getAllEventInfoExt();
		return messageInfo;
	}


		
    @RequestMapping("getListByInvstoridType")
    @ResponseBody
	public MessageInfo<List<EventInfoExt>> getListByInvstoridType(Integer invstorid){
		MessageInfo<List<EventInfoExt>> messageInfo = eventInfoExtBiz.getListByInvstoridType(invstorid);
		return messageInfo;
	}
		
}
