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
	public MessageInfo<Map<String,Object>> getListByOrgId(@PathVariable Integer orgId){
    	MessageInfo<Map<String,Object>> messageInfo = new MessageInfo<>();
    	Map<String,Object> map = new HashMap<>();

		MessageInfo<List<OrgInfo>> orgInfoMessageInfo = orgInfoBiz.getListByOrgId(orgId);
		map.put("orgInfoMessageInfo",orgInfoMessageInfo);
		orgInfoMessageInfo.setMessage(orgInfoMessageInfo.getMessage());
		orgInfoMessageInfo.setStatus(orgInfoMessageInfo.getStatus());

		MessageInfo<List<OrgMediaInfo>> orgMediaInfoMessageInfo = orgMediaInfoBiz.getListByOrgId(orgId);
		map.put("orgMediaInfoMessageInfo",orgMediaInfoMessageInfo);
		orgMediaInfoMessageInfo.setMessage(orgMediaInfoMessageInfo.getMessage());
		orgMediaInfoMessageInfo.setStatus(orgMediaInfoMessageInfo.getStatus());

		MessageInfo<List<OrgMemberInfo>> orgMemberInfoMessageInfo = orgMemberInfoBiz.getListByOrgId(orgId);
		map.put("orgMemberInfoMessageInfo",orgMemberInfoMessageInfo);
		orgMemberInfoMessageInfo.setMessage(orgMemberInfoMessageInfo.getMessage());
		orgMemberInfoMessageInfo.setStatus(orgMemberInfoMessageInfo.getStatus());

		messageInfo.setData(map);
		return messageInfo;
	}

}
