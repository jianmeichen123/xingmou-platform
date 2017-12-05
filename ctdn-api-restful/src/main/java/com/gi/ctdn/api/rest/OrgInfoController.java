package com.gi.ctdn.api.rest;

import java.util.List;


import com.gi.ctdn.biz.OrgInfoBiz;
import com.gi.ctdn.biz.OrgMediaInfoBiz;
import com.gi.ctdn.biz.OrgMemberInfoBiz;
import com.gi.ctdn.pojo.OrgInfo;
import com.gi.ctdn.pojo.OrgListInfo;
import com.gi.ctdn.view.common.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("orgInfo")
public class OrgInfoController {

    @Autowired
	private OrgInfoBiz orgInfoBiz;

    @Autowired
	private OrgMediaInfoBiz orgMediaInfoBiz;

    @Autowired
	private OrgMemberInfoBiz orgMemberInfoBiz;

//
//    @RequestMapping("getAll")
//    @ResponseBody
//    public MessageInfo<List<OrgInfo>> getAllOrgInfo(){
//		MessageInfo<List<OrgInfo>>  messageInfo = orgInfoBiz.getAllOrgInfo();
//		return messageInfo;
//	}


		
    @RequestMapping("getListByOrgCode/{orgCode}")
    @ResponseBody
	public MessageInfo<OrgListInfo> getListByOrgCode(@PathVariable String orgCode){
		MessageInfo<OrgListInfo> messageInfo = orgInfoBiz.getBaseInfoByOrgCode(orgCode);
		return messageInfo;
	}

}
