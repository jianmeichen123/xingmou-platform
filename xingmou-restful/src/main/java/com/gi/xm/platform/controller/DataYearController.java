package com.gi.xm.platform.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.dubbo.config.annotation.Reference;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.DataYearInfo;
import com.gi.xm.platform.view.DataYearQueryInfo;
import com.gi.xm.platform.facede.DataYearFacede;

@Controller
@RequestMapping("dataYear")
public class DataYearController {

    @Reference
	private DataYearFacede dataYearFacede;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		return new ModelAndView("dataYear/index", modelMap);
	}

	@RequestMapping("query")
	@ResponseBody
	public MessageInfo<QueryResultInfo<DataYearInfo>>  queryDataYear (DataYearQueryInfo dataYearQueryInfo) {
		MessageInfo<QueryResultInfo<DataYearInfo>> resultMessageInfo = dataYearFacede.queryDataYear(dataYearQueryInfo);
		return resultMessageInfo;
	}

    @RequestMapping("create")
    @ResponseBody
    public MessageInfo<Long> createDataYear(DataYearInfo dataYearInfo){
        MessageInfo<Long> messageInfo =  dataYearFacede.createDataYear(dataYearInfo);
        return messageInfo;
    }

    @RequestMapping("update")
    @ResponseBody
	public MessageInfo<Integer> updateDataYear(DataYearInfo dataYearInfo){
		MessageInfo<Integer> messageInfo =  dataYearFacede.updateDataYear(dataYearInfo);
		return messageInfo;
	}

    @RequestMapping("get")
    @ResponseBody
	public MessageInfo<DataYearInfo> getDataYear( Long id ){
		MessageInfo<DataYearInfo> messageInfo =  dataYearFacede.getDataYear(id);
		return messageInfo;
	}

    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<DataYearInfo>> getAllDataYear(){
		MessageInfo<List<DataYearInfo>>  messageInfo = dataYearFacede.getAllDataYear();
		return messageInfo;
	}


		
    @RequestMapping("getListByDistrictId")
    @ResponseBody
	public MessageInfo<List<DataYearInfo>> getListByDistrictId(Integer districtId){
		MessageInfo<List<DataYearInfo>> messageInfo = dataYearFacede.getListByDistrictId(districtId);
		return messageInfo;
	}
			
    @RequestMapping("getListByIndustryId")
    @ResponseBody
	public MessageInfo<List<DataYearInfo>> getListByIndustryId(Integer industryId){
		MessageInfo<List<DataYearInfo>> messageInfo = dataYearFacede.getListByIndustryId(industryId);
		return messageInfo;
	}
			
    @RequestMapping("getListByMoneyLevelId")
    @ResponseBody
	public MessageInfo<List<DataYearInfo>> getListByMoneyLevelId(Integer moneyLevelId){
		MessageInfo<List<DataYearInfo>> messageInfo = dataYearFacede.getListByMoneyLevelId(moneyLevelId);
		return messageInfo;
	}
			
    @RequestMapping("getListByRoundId")
    @ResponseBody
	public MessageInfo<List<DataYearInfo>> getListByRoundId(Integer roundId){
		MessageInfo<List<DataYearInfo>> messageInfo = dataYearFacede.getListByRoundId(roundId);
		return messageInfo;
	}
			
    @RequestMapping("getListByYear")
    @ResponseBody
	public MessageInfo<List<DataYearInfo>> getListByYear(Integer[] years){
		MessageInfo<List<DataYearInfo>> messageInfo = dataYearFacede.getListByYear(years);
		return messageInfo;
	}

	@RequestMapping("getListByYearIndustryId")
	@ResponseBody
	public MessageInfo<List<DataYearInfo>> getListByYearIndustryId(Integer[] years, Integer industryId){
		MessageInfo<List<DataYearInfo>> messageInfo = dataYearFacede.getListByYearIndustryId(years, industryId);
		return messageInfo;
	}

	@RequestMapping("getListByYearIndustrySubId")
	@ResponseBody
	public MessageInfo<List<DataYearInfo>> getListByYearIndustrySubId(Integer[] years, Integer industrySubId){
		MessageInfo<List<DataYearInfo>> messageInfo = dataYearFacede.getListByYearIndustrySubId(years, industrySubId);
		return messageInfo;
	}
}
