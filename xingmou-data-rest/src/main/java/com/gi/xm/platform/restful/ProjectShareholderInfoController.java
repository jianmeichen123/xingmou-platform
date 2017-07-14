package com.gi.xm.platform.restful;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.gi.ctdn.ods.biz.ProjectShareholderInfoBiz;
import com.gi.ctdn.ods.pojo.ProjectShareholderInfo;
import com.gi.xm.platform.view.common.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("projectShareholderInfo")
public class ProjectShareholderInfoController {

    @Autowired
	private ProjectShareholderInfoBiz projectShareholderInfoBiz;


    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<ProjectShareholderInfo>> getAllProjectShareholderInfo(){
		MessageInfo<List<ProjectShareholderInfo>>  messageInfo = projectShareholderInfoBiz.getAllProjectShareholderInfo();
		return messageInfo;
	}


		
    @RequestMapping("getListBySourceCode")
    @ResponseBody
	public MessageInfo<List<ProjectShareholderInfo>> getListBySourceCode(String sourceCode){
		MessageInfo<List<ProjectShareholderInfo>> messageInfo = projectShareholderInfoBiz.getListBySourceCode(sourceCode);
		return messageInfo;
	}
		
}
