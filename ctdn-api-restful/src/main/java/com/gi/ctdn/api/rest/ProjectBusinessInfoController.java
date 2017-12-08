package com.gi.ctdn.api.rest;

import com.gi.ctdn.biz.ProjectBusinessInfoBiz;
import com.gi.ctdn.pojo.ProjectBusinessInfo;
import com.gi.ctdn.pojo.ProjectBusinessListInfo;
import com.gi.ctdn.view.common.MessageInfo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("businessInfo")
public class ProjectBusinessInfoController {

    @Autowired
	private ProjectBusinessInfoBiz projectBusinessInfoBiz;

	@ApiOperation("查询工商信息,股东信息,工商变更")
	@ApiImplicitParam(paramType = "query", dataType = "String", name = "sourceCode", value = "公司code", required = true)
    @RequestMapping(value = "getListBySourceCode/{sourceCode}",method = RequestMethod.GET)
    @ResponseBody
	public MessageInfo<ProjectBusinessListInfo> getListBySourceCode(@PathVariable String sourceCode){
		MessageInfo<ProjectBusinessListInfo> messageInfo = projectBusinessInfoBiz.getProjectBusinessListInfoBySourceCode(sourceCode);
		return messageInfo;
	}

	@RequestMapping("getListByRegName/{company}")
	@ResponseBody
	public MessageInfo<ProjectBusinessInfo> getListByRegName(@PathVariable String company){
		MessageInfo<ProjectBusinessInfo> messageInfo = projectBusinessInfoBiz.getListByRegName(company);
		return messageInfo;
	}
}
