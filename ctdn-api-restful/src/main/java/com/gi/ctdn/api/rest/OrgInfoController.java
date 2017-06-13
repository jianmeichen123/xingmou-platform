package com.gi.ctdn.api.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


import com.gi.ctdn.biz.OrgInfoBiz;
import com.gi.ctdn.biz.OrgMediaInfoBiz;
import com.gi.ctdn.biz.OrgMemberInfoBiz;
import com.gi.ctdn.pojo.OrgInfo;
import com.gi.ctdn.pojo.OrgMediaInfo;
import com.gi.ctdn.pojo.OrgMemberInfo;
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

    @Autowired
	private OrgMediaInfoBiz orgMediaInfoBiz;

    @Autowired
	private OrgMemberInfoBiz orgMemberInfoBiz;


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

}
