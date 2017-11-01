package com.gi.ctdn.api.rest;

import java.util.List;


import com.gi.ctdn.biz.OrgMemberInfoBiz;
import com.gi.ctdn.pojo.OrgMemberInfo;
import com.gi.ctdn.view.common.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


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
