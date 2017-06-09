package com.gi.ctdn.api.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.gi.ctdn.biz.OrgInfoBiz;
import com.gi.ctdn.pojo.OrgInfo;
import com.gi.xm.platform.view.common.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("orgInfo")
public class OrgInfoController {

    @Autowired
	private OrgInfoBiz orgInfoBiz;


    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<OrgInfo>> getAllOrgInfo(){
		MessageInfo<List<OrgInfo>>  messageInfo = orgInfoBiz.getAllOrgInfo();
		return messageInfo;
	}


		
    @RequestMapping("getListByOrgId/{orgId}")
    @ResponseBody
	public MessageInfo<List<OrgInfo>> getListByOrgId(@PathVariable Integer orgId){
		MessageInfo<List<OrgInfo>> messageInfo = orgInfoBiz.getListByOrgId(orgId);
		return messageInfo;
	}

	@RequestMapping("getListByProjTitle")
	@ResponseBody
	public MessageInfo<List<OrgInfo>> getListByProjTitle(String projTitle){
		MessageInfo<List<OrgInfo>> messageInfo = orgInfoBiz.getListByProjTitle(projTitle);
		return messageInfo;
	}
}
