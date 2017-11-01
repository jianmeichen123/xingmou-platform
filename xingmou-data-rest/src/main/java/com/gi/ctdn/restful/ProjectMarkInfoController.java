package com.gi.ctdn.restful;

import java.util.List;
import java.util.Map;


import com.gi.ctdn.ods.biz.ProjectMarkInfoBiz;
import com.gi.ctdn.ods.pojo.ProjectMarkInfo;
import com.gi.ctdn.view.common.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("projectMarkInfo")
public class ProjectMarkInfoController {

    @Autowired
	private ProjectMarkInfoBiz projectMarkInfoBiz;


    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<ProjectMarkInfo>> getAllProjectMarkInfo(){
		MessageInfo<List<ProjectMarkInfo>>  messageInfo = projectMarkInfoBiz.getAllProjectMarkInfo();
		return messageInfo;
	}


		
    @RequestMapping("getListBySourceCode/{sourceCode}")
    @ResponseBody
	public MessageInfo<Map> getListBySourceCode(@PathVariable String sourceCode){
		MessageInfo<Map> messageInfo = projectMarkInfoBiz.getListBySourceCode(sourceCode);
		return messageInfo;
	}
		
}
