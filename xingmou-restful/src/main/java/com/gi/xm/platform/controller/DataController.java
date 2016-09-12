package com.gi.xm.platform.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.dubbo.config.annotation.Reference;

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

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		return new ModelAndView("data/index", modelMap);
	}

	@RequestMapping("query")
	@ResponseBody
	public MessageInfo<QueryResultInfo<DataInfo>>  queryData (DataQueryInfo dataQueryInfo) {
		MessageInfo<QueryResultInfo<DataInfo>> resultMessageInfo = dataFacede.queryData(dataQueryInfo);
		return resultMessageInfo;
	}

    @RequestMapping("create")
    @ResponseBody
    public MessageInfo<Integer> createData(DataInfo dataInfo){
        MessageInfo<Integer> messageInfo =  dataFacede.createData(dataInfo);
        return messageInfo;
    }

    @RequestMapping("update")
    @ResponseBody
	public MessageInfo<Integer> updateData(DataInfo dataInfo){
		MessageInfo<Integer> messageInfo =  dataFacede.updateData(dataInfo);
		return messageInfo;
	}

    @RequestMapping("get")
    @ResponseBody
	public MessageInfo<DataInfo> getData( Integer id ){
		MessageInfo<DataInfo> messageInfo =  dataFacede.getData(id);
		return messageInfo;
	}

    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<DataInfo>> getAllData(){
		MessageInfo<List<DataInfo>>  messageInfo = dataFacede.getAllData();
		return messageInfo;
	}


	
}
