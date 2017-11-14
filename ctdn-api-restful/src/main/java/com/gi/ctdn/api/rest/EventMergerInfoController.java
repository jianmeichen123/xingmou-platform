package com.gi.ctdn.api.rest;


import com.gi.ctdn.biz.EventMergerDetailBiz;
import com.gi.ctdn.biz.EventMergerInfoBiz;
import com.gi.ctdn.pojo.EventMergerInfo;
import com.gi.ctdn.pojo.EventMergerInfoSon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.gi.ctdn.view.common.MessageInfo;

import java.util.List;

@Controller
@RequestMapping("eventMergerInfo")
public class EventMergerInfoController {

    @Autowired
	private EventMergerInfoBiz eventMergerInfoBiz;

    @Autowired
    private EventMergerDetailBiz eventMergerDetailBiz;

	/**
	 * 根据项目code查询并购事件
	 * @return
	 */
    @RequestMapping("queryMergeEventBySourceCode")
    @ResponseBody
	public MessageInfo<List<EventMergerInfo>> getListBySourceCode(@RequestBody EventMergerInfo eventMergerInfo){
		MessageInfo<List<EventMergerInfo>> messageInfo = eventMergerInfoBiz.getListBySourceCode(eventMergerInfo.getSourceCode());
		return messageInfo;
	}

    @RequestMapping("getListByEventId/{eventId}")
    @ResponseBody
    public MessageInfo<EventMergerInfoSon> getListByEventId(@PathVariable Integer eventId){
        MessageInfo<EventMergerInfoSon> messageInfo = eventMergerInfoBiz.getListByEventId(eventId);
        return messageInfo;
    }
}
