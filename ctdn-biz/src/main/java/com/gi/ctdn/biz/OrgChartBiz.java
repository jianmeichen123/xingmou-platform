package com.gi.ctdn.biz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gi.ctdn.dao.ChartOrgIndustryDao;
import com.gi.ctdn.dao.ChartOrgRoundDao;
import com.gi.ctdn.dao.ChartProjectOrgCompeteDao;
import com.gi.ctdn.dao.ChartProjectOrgDao;
import com.gi.ctdn.dao.ChartProjectOrgPartnerDao;
import com.gi.ctdn.dao.IndustryDAO;
import com.gi.ctdn.pojo.ChartOrgIndustry;
import com.gi.ctdn.pojo.ChartOrgRound;
import com.gi.ctdn.pojo.ChartProjectOrg;
import com.gi.ctdn.pojo.ChartProjectOrgCompete;
import com.gi.ctdn.pojo.ChartProjectOrgPartner;
import com.gi.ctdn.pojo.Industry;
import com.gi.ctdn.pojo.OrgProjectChart;

@Service("orgChartBiz")
public class OrgChartBiz {
	
	@Autowired
	private ChartOrgIndustryDao chartOrgIndustryDao;
	
	@Autowired
	private ChartOrgRoundDao chartOrgRoundDao;
	
	@Autowired
	private ChartProjectOrgDao chartProjectOrgDao;
	
	@Autowired
	private ChartProjectOrgPartnerDao chartProjectOrgPartnerDao;
	
	@Autowired
	private ChartProjectOrgCompeteDao chartProjectOrgCompeteDao;
	
	
	@Autowired
	private IndustryDAO industryDAO;

	public List<ChartOrgIndustry> getChartOrgIndustry(ChartOrgIndustry chartOrgIndustry) {
		return chartOrgIndustryDao.selectChartOrgIndustry(chartOrgIndustry);
	}

	public List<ChartOrgRound> getChartOrgRound(ChartOrgRound chartOrgRound) {
		return chartOrgRoundDao.selectChartOrgRound(chartOrgRound);
	}

	public OrgProjectChart getOrgProjectChart(ChartProjectOrg chartProjectOrg) {
		OrgProjectChart orgProjectChart = new OrgProjectChart();
		List<String> ids = chartProjectOrgDao.getTopOrgEventId(chartProjectOrg);
		List<String> eventIds = new ArrayList<String>();
		for(String s:ids){
			String[] ss = s.split(",");
			for(String id:ss){
				eventIds.add(id);
			}
		}
		chartProjectOrg.setEventIds(eventIds);
		List<ChartProjectOrg> chartProjectOrgList = chartProjectOrgDao.selectChartProjectOrg(chartProjectOrg);
		List<String> resultOrgNameList = new ArrayList<String>();
		HashSet<String> orgNameAndCodeSet = new HashSet<String>();
		Map<String,HashSet<String>> orgNameAndCodeToProjNameMap = new HashMap<String,HashSet<String>>();
		for(ChartProjectOrg po: chartProjectOrgList){
			String projName = po.getProjName();
			String orgNameAndCodes = po.getOrgNameAndCodes();
			String[] orgNameAndCodeArr = orgNameAndCodes.split(",");
			for(String orgNameAndCode : orgNameAndCodeArr){
				if(orgNameAndCodeToProjNameMap.containsKey(orgNameAndCode)){
					HashSet<String> projNameSet = orgNameAndCodeToProjNameMap.get(orgNameAndCode);
//					if(projNameSet.size()>=5){
//						continue;
//					}
					orgNameAndCodeToProjNameMap.get(orgNameAndCode).add(projName);
				}else{
					HashSet<String> projNameSet = new HashSet<String>();
					projNameSet.add(projName);
					orgNameAndCodeToProjNameMap.put(orgNameAndCode, projNameSet);
				}
				orgNameAndCodeSet.add(orgNameAndCode);
			}
		}
		List<ChartProjectOrg> resultList = new ArrayList<ChartProjectOrg>();
		List<String> projNameList = new ArrayList<>(new HashSet<String>());
		HashSet<String> resultProjNameSet = new HashSet<String>();
		for(Entry<String, HashSet<String>> entry:orgNameAndCodeToProjNameMap.entrySet()){
			String orgAndCode = entry.getKey();
			String orgName = orgAndCode.split(":")[0];
			HashSet<String> projNameSet = entry.getValue();
			for(String projName :projNameSet){
				ChartProjectOrg result = new ChartProjectOrg();
				result.setProjName(projName);
				result.setOrgName(orgName);
				resultList.add(result);
				resultProjNameSet.add(projName);
			}
		}
		orgProjectChart.setChartProjectOrgList(resultList);
		resultOrgNameList.addAll(orgNameAndCodeSet);
		orgProjectChart.setOrgNames(resultOrgNameList);
		projNameList.addAll(resultProjNameSet);
		orgProjectChart.setProjNames(projNameList);
		return orgProjectChart;
	}

	public ChartProjectOrgPartner getChartOrgPartner(ChartProjectOrgPartner chartProjectOrgPartner) {
		ChartProjectOrgPartner orgPartner = new ChartProjectOrgPartner();
		Long parentId  = chartProjectOrgPartner.getIndustryId();
		List<Industry> industryList = industryDAO.selectIndustryByParentId(Integer.valueOf(parentId.intValue()));
		orgPartner.setIndustryList(industryList);
		List<ChartProjectOrgPartner> partnerList = new ArrayList<ChartProjectOrgPartner>();
		if(parentId == 0){ //一级行业
			partnerList = chartProjectOrgPartnerDao.getParentPartnerList(chartProjectOrgPartner);
		}else{ //二级行业
			partnerList = chartProjectOrgPartnerDao.getChildPartnerList(chartProjectOrgPartner);
		}
		orgPartner.setPartnerList(partnerList);
		return orgPartner;
	}

	public synchronized ChartProjectOrgCompete getChartOrgCompete(ChartProjectOrgCompete chartProjectOrgCompete) {
		ChartProjectOrgCompete orgCompete = new ChartProjectOrgCompete();
		Long parentId  = chartProjectOrgCompete.getIndustryId();
		List<Industry> industryList = industryDAO.selectIndustryByParentId(Integer.valueOf(parentId.intValue()));
		orgCompete.setIndustryList(industryList);
		List<ChartProjectOrgCompete> partnerList = new ArrayList<ChartProjectOrgCompete>();
		chartProjectOrgCompeteDao.deleteAll();
		if(parentId == 0){ //一级行业
			chartProjectOrgCompeteDao.insertParentCompete(chartProjectOrgCompete);
			partnerList = chartProjectOrgCompeteDao.getParentCompeteList(chartProjectOrgCompete);
		}else{ //二级行业
			chartProjectOrgCompeteDao.insertChiltCompete(chartProjectOrgCompete);
			partnerList = chartProjectOrgCompeteDao.getChildCompeteList(chartProjectOrgCompete);
		}
		orgCompete.setCompeteList(partnerList);
		return orgCompete;
	}

	public ChartProjectOrgPartner getOrgPartnerAndCompeteCount(ChartProjectOrgPartner chartProjectOrgPartner) {
		ChartProjectOrgPartner orgPartner = new ChartProjectOrgPartner();
		Long partnerCount = chartProjectOrgPartnerDao.getPartnerCount(chartProjectOrgPartner);
		orgPartner.setPartnerCount(partnerCount);
		Long competeCount = 0l;
		if(chartProjectOrgPartner.getIndustryId() == null){
			 competeCount = chartProjectOrgCompeteDao.getParentCompeteCount(chartProjectOrgPartner);
		}else{
			 competeCount = chartProjectOrgCompeteDao.getChildCompeteCount(chartProjectOrgPartner);
		}
		orgPartner.setCompeteCount(competeCount);
		orgPartner.setOrgCode(chartProjectOrgPartner.getOrgCode());
		return orgPartner;
	}

}
