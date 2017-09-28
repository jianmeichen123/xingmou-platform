package com.gi.ctdn.api.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.gi.ctdn.biz.OrgRankBiz;
import com.gi.ctdn.pojo.OrgRank;
import com.gi.xm.platform.view.common.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("orgRank")
public class OrgRankController {

    @Autowired
	private OrgRankBiz orgRankBiz;



    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<OrgRank>> getAllOrgRank(){
		MessageInfo<List<OrgRank>>  messageInfo = orgRankBiz.getAllOrgRank();
		return messageInfo;
	}

	@RequestMapping("getOrgsByTimes")
	@ResponseBody
	public MessageInfo<List<OrgRank>> getOrgsByTimes(){
		MessageInfo<List<OrgRank>>  messageInfo = orgRankBiz.getByTimes();
		return messageInfo;
	}

	@RequestMapping("getOrgsByAllTimes")
	@ResponseBody
	public MessageInfo<List<OrgRank>> getOrgsByAllTimes(){
		MessageInfo<List<OrgRank>>  messageInfo = orgRankBiz.getByAllTimes();
		return messageInfo;
	}
	
}
