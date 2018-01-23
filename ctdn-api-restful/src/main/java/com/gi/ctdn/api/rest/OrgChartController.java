package com.gi.ctdn.api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gi.ctdn.biz.IndustryBiz;
import com.gi.ctdn.biz.OrgChartBiz;
import com.gi.ctdn.pojo.ChartOrgIndustry;
import com.gi.ctdn.pojo.ChartOrgRound;
import com.gi.ctdn.pojo.ChartProjectOrg;
import com.gi.ctdn.pojo.ChartProjectOrgCompete;
import com.gi.ctdn.pojo.ChartProjectOrgPartner;
import com.gi.ctdn.pojo.Industry;
import com.gi.ctdn.pojo.OrgProjectChart;
import com.gi.ctdn.view.common.MessageInfo;

//商业洞察-机构分析
@Controller
@RequestMapping("/orgChart")
public class OrgChartController {
	
	@Autowired
	private OrgChartBiz orgChartBiz;
	
	@Autowired
	private IndustryBiz industryBiz;

	
	@RequestMapping("/orgIndustry")
	@ResponseBody
	public MessageInfo<List<ChartOrgIndustry>> getAppChartOrgIndustry(@RequestBody ChartOrgIndustry chartOrgIndustry){
		MessageInfo<List<ChartOrgIndustry>> info = new MessageInfo<List<ChartOrgIndustry>> ();
		try {
			List<ChartOrgIndustry> orgIndustriyList = orgChartBiz.getChartOrgIndustry(chartOrgIndustry);
			info.setData(orgIndustriyList);
		} catch (Exception e) {
			e.printStackTrace();
			info.setMessage("系统繁忙");
		}
		return info;
	}
	
	@RequestMapping("/orgRound")
	@ResponseBody
	public MessageInfo<List<ChartOrgRound>> getAppChartOrgRound(@RequestBody ChartOrgRound chartOrgRound){
		MessageInfo<List<ChartOrgRound>> info = new MessageInfo<List<ChartOrgRound>> ();
		try {
			List<ChartOrgRound> orgIndustriyList = orgChartBiz.getChartOrgRound(chartOrgRound);
			info.setData(orgIndustriyList);
		} catch (Exception e) {
			e.printStackTrace();
			info.setMessage("系统繁忙");
		}
		return info;
	}
	
	//机构分析-热门机构投资关系图谱
	@RequestMapping("/orgProject")
	@ResponseBody
	public MessageInfo<OrgProjectChart> getAppChartOrgProject(@RequestBody ChartProjectOrg chartProjectOrg){
		MessageInfo<OrgProjectChart> info = new MessageInfo<OrgProjectChart> ();
		try {
			OrgProjectChart orgIndustriyList = orgChartBiz.getOrgProjectChart(chartProjectOrg);
			info.setData(orgIndustriyList);
		} catch (Exception e) {
			e.printStackTrace();
			info.setMessage("系统繁忙");
		}
		return info;
	}
	
	//获取机构竞争、合投数
	@RequestMapping("/getOrgPartnerAndCompeteCount")
	@ResponseBody
	public MessageInfo<ChartProjectOrgPartner> getOrgPartnerAndCompeteCount(@RequestBody ChartProjectOrgPartner chartProjectOrgPartner){
		MessageInfo<ChartProjectOrgPartner> info = new MessageInfo<ChartProjectOrgPartner> ();
		try {
			ChartProjectOrgPartner orgPartner= orgChartBiz.getOrgPartnerAndCompeteCount(chartProjectOrgPartner);
			info.setData(orgPartner);
		} catch (Exception e) {
			e.printStackTrace();
			info.setMessage("系统繁忙");
		}
		return info;
	}
	
	//机构分析-热门机构投资关系[合作]
	
	@RequestMapping("/orgPartner")
	@ResponseBody
	public MessageInfo<ChartProjectOrgPartner> getAppChartOrgPartner(@RequestBody ChartProjectOrgPartner chartProjectOrgPartner){
		MessageInfo<ChartProjectOrgPartner> info = new MessageInfo<ChartProjectOrgPartner> ();
		try {
			ChartProjectOrgPartner orgIndustriyList = orgChartBiz.getChartOrgPartner(chartProjectOrgPartner);
			info.setData(orgIndustriyList);
		} catch (Exception e) {
			e.printStackTrace();
			info.setMessage("系统繁忙");
		}
		return info;
	}
	
	//机构分析-热门机构投资关系[竞争]
	@RequestMapping("/orgCompete")
	@ResponseBody
	public MessageInfo<List<ChartProjectOrgCompete>> getAppChartOrgCompete(@RequestBody ChartProjectOrgCompete chartProjectOrgCompete){
		MessageInfo<List<ChartProjectOrgCompete>> info = new MessageInfo<List<ChartProjectOrgCompete>> ();
		try {
			List<ChartProjectOrgCompete> orgIndustriyList = orgChartBiz.getChartOrgCompete(chartProjectOrgCompete);
			info.setData(orgIndustriyList);
		} catch (Exception e) {
			e.printStackTrace();
			info.setMessage("系统繁忙");
		}
		return info;
	}
	
	//获取二级级行业
	@RequestMapping(value="/childIndustries/{parentId}",method=RequestMethod.POST)
	@ResponseBody
	public MessageInfo<List<Industry>> selectIndustryByParentId(@PathVariable("parentId") Integer parentId){
		MessageInfo<List<Industry>> info = new MessageInfo<List<Industry>> ();
		try {
			List<Industry> orgIndustriyList = industryBiz.selectIndustryByParentId(parentId);
			info.setData(orgIndustriyList);
		} catch (Exception e) {
			e.printStackTrace();
			info.setMessage("系统繁忙");
		}
		return info;
	}
	
}
