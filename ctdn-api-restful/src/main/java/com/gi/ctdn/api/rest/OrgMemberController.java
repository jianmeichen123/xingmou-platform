package com.gi.ctdn.api.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.gi.ctdn.biz.OrgMemberBiz;
import com.gi.ctdn.pojo.OrgMember;
import com.gi.xm.platform.view.common.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("orgMember")
public class OrgMemberController {

    @Autowired
	private OrgMemberBiz orgMemberFacede;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		return new ModelAndView("orgMember/index", modelMap);
	}







    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<OrgMember>> getAllOrgMember(){
		MessageInfo<List<OrgMember>>  messageInfo = orgMemberFacede.getAllOrgMember();
		return messageInfo;
	}


	
}
