package com.gi.ctdn.api.rest;

import com.gi.ctdn.biz.OrgRankBiz;
import com.gi.ctdn.biz.ProjectContactBiz;
import com.gi.ctdn.pojo.OrgRank;
import com.gi.ctdn.pojo.ProjectContact;
import com.gi.ctdn.view.common.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("projectContact")
public class ProjectContactController {

    @Autowired
	private ProjectContactBiz projectContactBiz;


	@RequestMapping("getListByProjCode/{sourceCode}")
	@ResponseBody
	public MessageInfo<List<ProjectContact>> getListByProjCode(@PathVariable String sourceCode){
		MessageInfo<List<ProjectContact>>  messageInfo = projectContactBiz.getListBySourceCode(sourceCode);
		return messageInfo;
	}
	
}
