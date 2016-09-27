package com.gi.xm.platform.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.dubbo.config.annotation.Reference;

import com.gi.xm.platform.view.DataEventYearInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.DataEventYearInfo;
import com.gi.xm.platform.view.DataEventYearQueryInfo;
import com.gi.xm.platform.facede.DataEventYearFacede;

@Controller
@RequestMapping("dataEventYear")
public class DataEventYearController {

    @Reference
	private DataEventYearFacede dataEventYearFacede;

/*

	@RequestMapping("query")
	@ResponseBody
	public MessageInfo<QueryResultInfo<DataEventYearInfo>>  queryDataEventYear (DataEventYearQueryInfo dataEventYearQueryInfo) {
		MessageInfo<QueryResultInfo<DataEventYearInfo>> resultMessageInfo = dataEventYearFacede.queryDataEventYear(dataEventYearQueryInfo);
		return resultMessageInfo;
	}

    @RequestMapping("create")
    @ResponseBody
    public MessageInfo<Long> createDataEventYear(DataEventYearInfo dataEventYearInfo){
        MessageInfo<Long> messageInfo =  dataEventYearFacede.createDataEventYear(dataEventYearInfo);
        return messageInfo;
    }

    @RequestMapping("update")
    @ResponseBody
	public MessageInfo<Integer> updateDataEventYear(DataEventYearInfo dataEventYearInfo){
		MessageInfo<Integer> messageInfo =  dataEventYearFacede.updateDataEventYear(dataEventYearInfo);
		return messageInfo;
	}

    @RequestMapping("get")
    @ResponseBody
	public MessageInfo<DataEventYearInfo> getDataEventYear( Long id ){
		MessageInfo<DataEventYearInfo> messageInfo =  dataEventYearFacede.getDataEventYear(id);
		return messageInfo;
	}

    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<DataEventYearInfo>> getAllDataEventYear(){
		MessageInfo<List<DataEventYearInfo>>  messageInfo = dataEventYearFacede.getAllDataEventYear();
		return messageInfo;
	}

*/

		
   /* @RequestMapping("getListByYearIndustryId")
    @ResponseBody
	public MessageInfo<List<DataEventYearInfo>> getListByYearIndustryId(Integer year, Integer industryId){
		MessageInfo<List<DataEventYearInfo>> messageInfo = dataEventYearFacede.getListByYearIndustryId(year, industryId);
		return messageInfo;
	}*/
			
/*    @RequestMapping("getListByYearIndustrySubId")
    @ResponseBody
	public MessageInfo<List<DataEventYearInfo>> getListByYearIndustrySubId(Integer year, Integer industrySubId){
		MessageInfo<List<DataEventYearInfo>> messageInfo = dataEventYearFacede.getListByYearIndustrySubId(year, industrySubId);
		return messageInfo;
	}*/
			
    @RequestMapping("getListByDistrictId")
    @ResponseBody
	public MessageInfo<List<DataEventYearInfo>> getListByDistrictId(Integer districtId){
		MessageInfo<List<DataEventYearInfo>> messageInfo = dataEventYearFacede.getListByDistrictId(districtId);
		return messageInfo;
	}
			
    @RequestMapping("getListByIndustryId")
    @ResponseBody
	public MessageInfo<List<DataEventYearInfo>> getListByIndustryId(Integer industryId){
		MessageInfo<List<DataEventYearInfo>> messageInfo = dataEventYearFacede.getListByIndustryId(industryId);
		return messageInfo;
	}
			
    @RequestMapping("getListByMoneyLevelId")
    @ResponseBody
	public MessageInfo<List<DataEventYearInfo>> getListByMoneyLevelId(Integer moneyLevelId){
		MessageInfo<List<DataEventYearInfo>> messageInfo = dataEventYearFacede.getListByMoneyLevelId(moneyLevelId);
		return messageInfo;
	}
			
    @RequestMapping("getListByRoundId")
    @ResponseBody
	public MessageInfo<List<DataEventYearInfo>> getListByRoundId(Integer roundId){
		MessageInfo<List<DataEventYearInfo>> messageInfo = dataEventYearFacede.getListByRoundId(roundId);
		return messageInfo;
	}
			
 /*   @RequestMapping("getListByYear")
    @ResponseBody
	public MessageInfo<List<DataEventYearInfo>> getListByYear(Integer year){
		MessageInfo<List<DataEventYearInfo>> messageInfo = dataEventYearFacede.getListByYear(year);
		return messageInfo;
	}
		*/
 @RequestMapping("analysis/{year}/{industryId}/{industrySubId}")
 @ResponseBody
 public MessageInfo<List<DataEventYearInfo>> analysis(
		 @PathVariable("year") Integer[] years, @PathVariable("industryId") Integer industryId, @PathVariable("industrySubId") Integer industrySubId){
	 if (years != null  && industrySubId != 0){
		 MessageInfo<List<DataEventYearInfo>> messageInfo = dataEventYearFacede.getListByYearIndustrySubId(years, industrySubId);
		 return messageInfo;
	 }else if(years != null  && industryId != 0){
		 MessageInfo<List<DataEventYearInfo>> messageInfo = dataEventYearFacede.getListByYearIndustryId( years,industryId);
		 return messageInfo;
	 }else if (years != null){
		 MessageInfo<List<DataEventYearInfo>> messageInfo = dataEventYearFacede.getListByYear(years);
		 return messageInfo;
	 }else {
		 return null;
	 }
 }


}
