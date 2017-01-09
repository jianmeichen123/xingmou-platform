package com.gi.xm.platform.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.dubbo.config.annotation.Reference;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.IndustryInfo;
import com.gi.xm.platform.view.IndustryQueryInfo;
import com.gi.xm.platform.facede.IndustryFacede;

@Controller
@RequestMapping("industry")
public class IndustryController {

	@Reference(check = false)
	private IndustryFacede industryFacede;

	@RequestMapping("getListByParentId")
	@ResponseBody
	@Cacheable(value = "industryInfo:parentId",keyGenerator = "api")
	public MessageInfo<List<IndustryInfo>> getListByParentId(Integer parentId){
		MessageInfo<List<IndustryInfo>> messageInfo = industryFacede.getListByParentId(parentId);
		return messageInfo;
	}
	@RequestMapping("getAll")
	@ResponseBody
	@Cacheable(value = "industryInfo:all",keyGenerator = "api")
	public MessageInfo<List<IndustryInfo>> getAllIndustry(){
		MessageInfo<List<IndustryInfo>>  messageInfo = industryFacede.getAllIndustry();
		return messageInfo;
	}
}
