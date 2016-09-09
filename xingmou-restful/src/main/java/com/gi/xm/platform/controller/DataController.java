package com.gi.xm.platform.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gi.xm.platform.facede.DataFacede;
import com.gi.xm.platform.view.DataInfo;
import com.gi.xm.platform.view.DataQueryInfo;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("data")
public class DataController {

    @Reference
	private DataFacede dataFacede;

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
