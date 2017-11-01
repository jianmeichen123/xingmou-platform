package com.gi.ctdn.api.rest;


import com.gi.ctdn.biz.EventMergerDetailBiz;
import com.gi.ctdn.biz.EventMergerInfoBiz;
import com.gi.ctdn.pojo.EventMergerInfoSon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.gi.ctdn.view.common.MessageInfo;

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
    public MessageInfo<EventMergerInfoSon> getListByEventId(@PathVariable Integer eventId){
        MessageInfo<EventMergerInfoSon> messageInfo = eventMergerInfoBiz.getListByEventId(eventId);
        return messageInfo;
    }
}
