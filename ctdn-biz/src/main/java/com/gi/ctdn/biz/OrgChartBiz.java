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
		List<ChartProjectOrg> chartProjectOrgList = chartProjectOrgDao.selectChartProjectOrg(chartProjectOrg);
		
		List<String> orgNames = new ArrayList<>(new HashSet<String>());
		HashSet<String> orgNameSet = new HashSet<String>();
		HashMap<String,HashSet<String>> orgToProjMap = new HashMap<String,HashSet<String>>();
		
		for(ChartProjectOrg po: chartProjectOrgList){
			String key = po.getOrgName() + ":" + po.getOrgCode();
			orgNameSet.add(key);
			if(orgToProjMap.containsKey(key)){
				HashSet<String> projSet = (HashSet<String>) orgToProjMap.get(key);
				if(projSet.size() >=2){
					continue;
				}
				projSet.add(po.getProjName());
			}else{
				HashSet<String> projSet  = new HashSet<String>();
				projSet.add(po.getProjName());
				orgToProjMap.put(key, projSet);
			}
		}
		orgNames.addAll(orgNameSet);
		
		List<String> projNames = new ArrayList<>(new HashSet<String>());
		HashSet<String> projNameSet = new HashSet<String>();
		List<ChartProjectOrg> resultList = new ArrayList<ChartProjectOrg>();
		for(Entry<String, HashSet<String>>  entry: orgToProjMap.entrySet()){
			String[] nameAndCodes = entry.getKey().split(":");
			String orgName = nameAndCodes[0];
			String orgCode = nameAndCodes[1];
			HashSet<String> val = entry.getValue();
			Iterator<String> projIterator = val.iterator();
			while(projIterator.hasNext()){
				ChartProjectOrg result = new ChartProjectOrg();
				result.setOrgName(orgName);
				result.setOrgCode(orgCode);
				String projName = projIterator.next();
				result.setProjName(projName);
				projNameSet.add(projName);
				resultList.add(result);
			}
		}
		projNames.addAll(projNameSet);
		orgProjectChart.setChartProjectOrgList(resultList);
		orgProjectChart.setOrgNames(orgNames);
		orgProjectChart.setProjNames(projNames);
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

	public ChartProjectOrgCompete getChartOrgCompete(ChartProjectOrgCompete chartProjectOrgCompete) {
		ChartProjectOrgCompete orgCompete = new ChartProjectOrgCompete();
		Long parentId  = chartProjectOrgCompete.getIndustryId();
		List<Industry> industryList = industryDAO.selectIndustryByParentId(Integer.valueOf(parentId.intValue()));
		orgCompete.setIndustryList(industryList);
		List<ChartProjectOrgCompete> partnerList = new ArrayList<ChartProjectOrgCompete>();
		if(parentId == 0){ //一级行业
			partnerList = chartProjectOrgCompeteDao.getParentCompeteList(chartProjectOrgCompete);
		}else{ //二级行业
			partnerList = chartProjectOrgCompeteDao.getChildCompeteList(chartProjectOrgCompete);
		}
		orgCompete.setCompeteList(partnerList);
		return orgCompete;
	}

	public ChartProjectOrgPartner getOrgPartnerAndCompeteCount(ChartProjectOrgPartner chartProjectOrgPartner) {
		ChartProjectOrgPartner orgPartner = new ChartProjectOrgPartner();
		Long partnerCount = chartProjectOrgPartnerDao.getPartnerCount(chartProjectOrgPartner);
		orgPartner.setPartnerCount(partnerCount);
		Long competeCount = chartProjectOrgCompeteDao.getCompeteCount(chartProjectOrgPartner);
		orgPartner.setCompeteCount(competeCount);
		orgPartner.setOrgCode(chartProjectOrgPartner.getOrgCode());
		return orgPartner;
	}

}
