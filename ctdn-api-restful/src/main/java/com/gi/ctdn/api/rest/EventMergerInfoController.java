package com.gi.ctdn.api.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.gi.ctdn.biz.EventMergerDetailBiz;
import com.gi.ctdn.biz.EventMergerInfoBiz;
import com.gi.ctdn.pojo.EventMergerDetail;
import com.gi.ctdn.pojo.EventMergerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;

@Controller
@RequestMapping("eventMergerInfo")
public class EventMergerInfoController {

    @Autowired
	private EventMergerInfoBiz eventMergerInfoBiz;

    @Autowired
    private EventMergerDetailBiz eventMergerDetailBiz;

//	/**
//	 * 根据项目code查询并购事件
//	 * @param sourceCode
//	 * @return
//	 */
//    @RequestMapping("getListBySourceCode/{sourceCode}")
//    @ResponseBody
//	public MessageInfo<List<EventMergerInfo>> getListBySourceCode(String sourceCode){
//		MessageInfo<List<EventMergerInfo>> messageInfo = eventMergerInfoBiz.getListBySourceCode(sourceCode);
//		return messageInfo;
//	}

    @RequestMapping("getListByEventId/{eventId}")
    @ResponseBody
    public MessageInfo<Map<String,Object>> getListByEventId(@PathVariable Integer eventId){
        MessageInfo<Map<String,Object>> messageInfo = new MessageInfo<>();
        Map<String,Object> map = new HashMap<>();

        MessageInfo<List<EventMergerInfo>> eventMergerInfoMessageInfo = eventMergerInfoBiz.getListByEventId(eventId);
        map.put("eventMergerInfoMessageInfo",eventMergerInfoMessageInfo);
        eventMergerInfoMessageInfo.setMessage(eventMergerInfoMessageInfo.getMessage());
        eventMergerInfoMessageInfo.setStatus(eventMergerInfoMessageInfo.getStatus());

        MessageInfo<List<EventMergerDetail>> eventMergerDetailInfoMessageInfo = eventMergerDetailBiz.getEventMergerDetailByEventId(eventId);
        map.put("eventMergerDetailInfoMessageInfo",eventMergerDetailInfoMessageInfo);
        eventMergerDetailInfoMessageInfo.setMessage(eventMergerDetailInfoMessageInfo.getMessage());
        eventMergerDetailInfoMessageInfo.setStatus(eventMergerDetailInfoMessageInfo.getStatus());

        messageInfo.setData(map);
        return messageInfo;
    }
}
