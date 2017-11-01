package com.gi.ctdn.restful;

import java.util.List;


import com.gi.ctdn.ods.biz.ProjectBusinessChangeBiz;
import com.gi.ctdn.ods.pojo.ProjectBusinessChange;
import com.gi.ctdn.view.common.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("projectBusinessChange")
public class ProjectBusinessChangeController {

    @Autowired
	private ProjectBusinessChangeBiz projectBusinessChangeBiz;



    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<ProjectBusinessChange>> getAllProjectBusinessChange(){
		MessageInfo<List<ProjectBusinessChange>>  messageInfo = projectBusinessChangeBiz.getAllProjectBusinessChange();
		return messageInfo;
	}


		
    @RequestMapping("getListBySourceCode")
    @ResponseBody
	public MessageInfo<List<ProjectBusinessChange>> getListBySourceCode(String sourceCode){
		MessageInfo<List<ProjectBusinessChange>> messageInfo = projectBusinessChangeBiz.getListBySourceCode(sourceCode);
		return messageInfo;
	}
		
}
