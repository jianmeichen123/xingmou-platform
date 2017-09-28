package com.gi.ctdn.api.rest;

import com.gi.ctdn.biz.EventIndustryMonthBiz;
import com.gi.ctdn.pojo.EventIndustryMonth;
import com.gi.ctdn.pojo.EventIndustryMonthChart;
import com.gi.xm.platform.view.common.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("eventIndustryMonth")
public class EventIndustryMonthController {

    @Autowired
	private EventIndustryMonthBiz eventIndustryMonthBiz;


	@RequestMapping("query")
	@ResponseBody
	public MessageInfo<EventIndustryMonthChart>  queryEventIndustryMonth (@RequestBody EventIndustryMonth eventIndustryMonth) {
		MessageInfo<EventIndustryMonthChart> resultMessageInfo = eventIndustryMonthBiz.getChartDataByCondition(eventIndustryMonth);
		return resultMessageInfo;
	}
}
