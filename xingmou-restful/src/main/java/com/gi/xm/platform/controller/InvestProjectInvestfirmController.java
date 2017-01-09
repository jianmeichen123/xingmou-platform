package com.gi.xm.platform.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.dubbo.config.annotation.Reference;

import com.gi.xm.platform.facede.InvestEventsFacede;
import com.gi.xm.platform.view.*;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.facede.InvestProjectInvestfirmFacede;

@Controller
@RequestMapping("investProjectInvestfirm")
public class InvestProjectInvestfirmController {

	@Reference(check = false)
	private InvestProjectInvestfirmFacede investProjectInvestfirmFacede;
	@Reference(check = false)
	private InvestEventsFacede investEventsFacede;

	@RequestMapping("query")
	@ResponseBody
	public RelationVO  queryInvestProjectInvestfirm (@RequestBody InvestProjectInvestfirmQueryInfo investProjectInvestfirmQueryInfo) {

		RelationVO vo = new RelationVO();
		InvestEventsQueryInfo info = new InvestEventsQueryInfo();
		info.setIndustryId(investProjectInvestfirmQueryInfo.getIndustryId());
		info.setIndustrySubId(investProjectInvestfirmQueryInfo.getIndustrySubId());
		info.setYear(investProjectInvestfirmQueryInfo.getYear());
		//项目列表
		List<InvestEventsInfo>projectList = investEventsFacede.queryProject(info);
		MessageInfo<QueryResultInfo<InvestProjectInvestfirmInfo>> resultMessageInfo = investProjectInvestfirmFacede.queryInvestProjectInvestfirm(investProjectInvestfirmQueryInfo);
		QueryResultInfo<InvestProjectInvestfirmInfo> dddd = resultMessageInfo.getData();

		//投融资关系列表
		List<InvestProjectInvestfirmInfo> piList = dddd.getRecords();
		//投资机构列表
		List<InvestfirmsInfo> investfirmList = null;
		vo.setProjectList(projectList);
		vo.setInvestfirmList(investfirmList);
		vo.setPiList(piList);
		return vo;
	}
/*

    @RequestMapping("create")
    @ResponseBody
	@Deprecated
    public MessageInfo<Long> createInvestProjectInvestfirm(InvestProjectInvestfirmInfo investProjectInvestfirmInfo){
        MessageInfo<Long> messageInfo =  investProjectInvestfirmFacede.createInvestProjectInvestfirm(investProjectInvestfirmInfo);
        return messageInfo;
    }

    @RequestMapping("update")
    @ResponseBody
	@Deprecated
	public MessageInfo<Integer> updateInvestProjectInvestfirm(InvestProjectInvestfirmInfo investProjectInvestfirmInfo){
		MessageInfo<Integer> messageInfo =  investProjectInvestfirmFacede.updateInvestProjectInvestfirm(investProjectInvestfirmInfo);
		return messageInfo;
	}
*/

    @RequestMapping("get")
    @ResponseBody
	@Cacheable(value = "investProjectInvestfirmInfo:id",keyGenerator = "api")
	public MessageInfo<InvestProjectInvestfirmInfo> getInvestProjectInvestfirm( Long id ){
		MessageInfo<InvestProjectInvestfirmInfo> messageInfo =  investProjectInvestfirmFacede.getInvestProjectInvestfirm(id);
		return messageInfo;
	}
/*
    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<InvestProjectInvestfirmInfo>> getAllInvestProjectInvestfirm(){
		MessageInfo<List<InvestProjectInvestfirmInfo>>  messageInfo = investProjectInvestfirmFacede.getAllInvestProjectInvestfirm();
		return messageInfo;
	}*/


		
    @RequestMapping("getListByInvestId")
    @ResponseBody
	@Cacheable(value = "investProjectInvestfirmInfo:investId",keyGenerator = "api")
	public MessageInfo<List<InvestProjectInvestfirmInfo>> getListByInvestId(Long investId){
		MessageInfo<List<InvestProjectInvestfirmInfo>> messageInfo = investProjectInvestfirmFacede.getListByInvestId(investId);
		return messageInfo;
	}
			
    @RequestMapping("getListByInvestfirmId")
    @ResponseBody
	@Cacheable(value = "investProjectInvestfirmInfo:investfirmId",keyGenerator = "api")
	public MessageInfo<List<InvestProjectInvestfirmInfo>> getListByInvestfirmId(Long investfirmId){
		MessageInfo<List<InvestProjectInvestfirmInfo>> messageInfo = investProjectInvestfirmFacede.getListByInvestfirmId(investfirmId);
		return messageInfo;
	}
			
    @RequestMapping("getListByProjectId")
    @ResponseBody
	@Cacheable(value = "investProjectInvestfirmInfo:projectId",keyGenerator = "api")
	public MessageInfo<List<InvestProjectInvestfirmInfo>> getListByProjectId(Long projectId){
		MessageInfo<List<InvestProjectInvestfirmInfo>> messageInfo = investProjectInvestfirmFacede.getListByProjectId(projectId);
		return messageInfo;
	}
	/*@RequestMapping("getRelationInfo/{year}/{industryId}/{industrySubId}")
	@ResponseBody
	public MessageInfo<RelationInfo> getRelationInfo(
			@PathVariable("year") Integer year, @PathVariable("industryId") Integer industryId, @PathVariable("industrySubId") Integer industrySubId){
		MessageInfo<RelationInfo> messageInfo = investProjectInvestfirmFacede.getRelationInfo(year,industryId,industrySubId);
		return messageInfo;
	}*/
}
