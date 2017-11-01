package com.gi.ctdn.restful;

import java.util.List;


import com.gi.ctdn.ods.biz.ProjectCertificateInfoBiz;
import com.gi.ctdn.ods.pojo.ProjectCertificateInfo;
import com.gi.ctdn.view.common.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("projectCertificateInfo")
public class ProjectCertificateInfoController {

    @Autowired
	private ProjectCertificateInfoBiz projectCertificateInfoBiz;



    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<ProjectCertificateInfo>> getAllProjectCertificateInfo(){
		MessageInfo<List<ProjectCertificateInfo>>  messageInfo = projectCertificateInfoBiz.getAllProjectCertificateInfo();
		return messageInfo;
	}


		
    @RequestMapping("getListBySourceCode")
    @ResponseBody
	public MessageInfo<List<ProjectCertificateInfo>> getListBySourceCode(String sourceCode){
		MessageInfo<List<ProjectCertificateInfo>> messageInfo = projectCertificateInfoBiz.getListBySourceCode(sourceCode);
		return messageInfo;
	}
		
}
