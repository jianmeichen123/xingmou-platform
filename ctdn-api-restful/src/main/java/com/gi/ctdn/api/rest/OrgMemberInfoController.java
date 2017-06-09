package com.gi.ctdn.api.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.gi.ctdn.biz.OrgMemberInfoBiz;
import com.gi.ctdn.pojo.OrgMemberInfo;
import com.gi.xm.platform.view.common.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("orgMemberInfo")
public class OrgMemberInfoController {

    @Autowired
	private OrgMemberInfoBiz orgMemberInfoBiz;


    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<OrgMemberInfo>> getAllOrgMemberInfo(){
		MessageInfo<List<OrgMemberInfo>>  messageInfo = orgMemberInfoBiz.getAllOrgMemberInfo();
		return messageInfo;
	}


		
    @RequestMapping("getListByOrgId")
    @ResponseBody
	public MessageInfo<List<OrgMemberInfo>> getListByOrgId(Integer orgId){
		MessageInfo<List<OrgMemberInfo>> messageInfo = orgMemberInfoBiz.getListByOrgId(orgId);
		return messageInfo;
	}
		
}
