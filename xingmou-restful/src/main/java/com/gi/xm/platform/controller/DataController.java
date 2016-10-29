package com.gi.xm.platform.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.dubbo.config.annotation.Reference;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.DataInfo;
import com.gi.xm.platform.view.DataQueryInfo;
import com.gi.xm.platform.facede.DataFacede;

@Controller
@RequestMapping("data")
public class DataController {

	@Reference(check = false)
	private DataFacede dataFacede;

    @RequestMapping("getAll")
    @ResponseBody
    @Cacheable(value = "allData",keyGenerator = "api")
    public MessageInfo<List<DataInfo>> allData(){
		MessageInfo<List<DataInfo>>  messageInfo = dataFacede.getAllData();
		return messageInfo;
	}


	
}
