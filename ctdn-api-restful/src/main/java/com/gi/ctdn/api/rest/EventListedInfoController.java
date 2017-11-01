package com.gi.ctdn.api.rest;

import com.gi.ctdn.biz.EventListedInfoBiz;
import com.gi.ctdn.pojo.EventListedInfo;
import com.gi.ctdn.view.common.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 上市挂牌
 */
@Controller
@RequestMapping("eventListedInfo")
public class EventListedInfoController {

    @Autowired
	private EventListedInfoBiz eventListedInfoBiz;

	/**
	 *根据事件id查询事件
	 * @param id
	 * @return
	 */
	@RequestMapping("getListByEventId/{id}")
    @ResponseBody
	public MessageInfo<EventListedInfo> getListByEventId(@PathVariable  Integer id){
		MessageInfo<EventListedInfo> messageInfo = eventListedInfoBiz.getByEventId(id);
		return messageInfo;
	}

	/**
	 * 根据项目code查询事件
	 * @param sourceCode
	 * @return
	 */
    @RequestMapping("getListBySourceCode/{sourceCode}")
    @ResponseBody
	public MessageInfo<List<EventListedInfo>> getListBySourceCode(@PathVariable String sourceCode){
		MessageInfo<List<EventListedInfo>> messageInfo = eventListedInfoBiz.getListBySourceCode(sourceCode);
		return messageInfo;
	}
}
