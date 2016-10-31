package com.gi.xm.platform.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gi.xm.platform.facede.DataFacede;
import com.gi.xm.platform.view.DataInfo;
import com.gi.xm.platform.view.common.MessageInfo;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
