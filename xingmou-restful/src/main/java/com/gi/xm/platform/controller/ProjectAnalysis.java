package com.gi.xm.platform.controller;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.report.biz.ChartProjectIndustrySubYearBiz;
import com.gi.xm.report.biz.ChartProjectIndustryYearBiz;
import com.gi.xm.report.common.ChartPojo;
import com.gi.xm.report.pojo.ChartProjectIndustrySubYear;
import com.gi.xm.report.pojo.ChartProjectIndustryYear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vincent on 16-9-29.
 */

@Controller
@RequestMapping("projectAnalysis")
public class ProjectAnalysis {
/*
    @Autowired
    private ChartEventIndustryDistictYearBiz chartEventIndustryDistictYearBiz;


    @RequestMapping("getMap/{years}")
    @ResponseBody
    public MessageInfo getList4Project(@PathVariable("years") Integer[] years){
        MessageInfo<ChartPojo>  messageInfo = new MessageInfo<>();
        MessageInfo<List<ChartEventIndustryDistictYear>> mdata = chartEventIndustryDistictYearBiz.getListByYear(years);
        if (!messageInfo.isSuccess()){
            //return messageInfo;
        }
        List<ChartEventIndustryDistictYear> cs = mdata.getData();
        Map<String,Map<String,Integer>> data = new HashMap<>();
        for(ChartEventIndustryDistictYear  c :cs){
            String districtName = c.getDistrictName();
            if(districtName != null){
              Map<String,Integer> m = data.get(districtName);
              if(m == null){
                  m = new HashMap<>();
                  data.put(districtName,m);
              }
              String industryName = c.getIndustryName();
              if (m.get(industryName)==null){
                  m.put(industryName,0);
              }
              m.put(industryName,m.get(industryName)+c.getInvestedNum());
          }
        }

        ChartPojo chartPojo = new ChartPojo();
        chartPojo.setRaw(data);
        messageInfo.setData(chartPojo);
        return messageInfo;
    }*/


    @Autowired
    private ChartProjectIndustryYearBiz chartProjectIndustryYearBiz;


    @Autowired
    private ChartProjectIndustrySubYearBiz chartProjectIndustrySubYearBiz;


    @RequestMapping("bar/{years}/{industryNames}/{industryId}")
    @ResponseBody
    public MessageInfo bar(@PathVariable("years") Integer[] years,@PathVariable("industryNames") String[] industryNames,@PathVariable("industryId") Integer industryId) {

        if (industryNames != null && industryId == 0) {
            MessageInfo<List<ChartProjectIndustryYear>> messageInfo = chartProjectIndustryYearBiz.selectByYear(years);
            if (!messageInfo.isSuccess()) {
                return messageInfo;
            }
            Map<String, Map<Integer, Map<String, Long>>> data = initMap(years, industryNames);
            for (ChartProjectIndustryYear c : messageInfo.getData()) {
                if (c.getYear() != null && c.getIndustryName() != null) {
                    data.get("projectNums").get(c.getYear()).put(c.getIndustryName(), c.getProjectNum().longValue());
                    data.get("projectInvestedNums").get(c.getYear()).put(c.getIndustryName(), c.getProjectInvestedNum().longValue());
                    data.get("projectunInvestedNums").get(c.getYear()).put(c.getIndustryName(), c.getProjectUninvestedNum().longValue());
                }
            }
            MessageInfo<ChartPojo> m = new MessageInfo<>();
            ChartPojo c = new ChartPojo();
            c.setRaw(data);
            m.setData(c);
            return m;
        } else if (industryNames != null && industryId > 0) {
            MessageInfo<List<ChartProjectIndustrySubYear>> messageInfo = chartProjectIndustrySubYearBiz.getListByYear(years, industryId);
            if (!messageInfo.isSuccess()) {
                return messageInfo;
            }
            Map<String, Map<Integer, Map<String, Long>>> data = initMap(years, industryNames);
            for (ChartProjectIndustrySubYear c : messageInfo.getData()) {
                if (c.getYear() != null && c.getIndustrySubName() != null&&data.get("projectNums").get(c.getYear())!=null) {
                    data.get("projectNums").get(c.getYear()).put(c.getIndustrySubName(), c.getProjectNum().longValue());
                    data.get("projectInvestedNums").get(c.getYear()).put(c.getIndustrySubName(), c.getProjectInvestedNum().longValue());
                    data.get("projectunInvestedNums").get(c.getYear()).put(c.getIndustrySubName(), c.getProjectUninvestedNum().longValue());
                }
            }
            MessageInfo<ChartPojo> m = new MessageInfo<>();
            ChartPojo c = new ChartPojo();
            c.setRaw(data);
            m.setData(c);
            return m;
        } else {
            return null;
        }
    }


    private Map<String,Map<Integer,Map<String,Long>>> initMap(Integer[] years, String[] industryNames){
        Map<Integer,Map<String,Long>> projectNums = new HashMap<>();
        Map<Integer,Map<String,Long>> projectInvestedNums = new HashMap<>();
        Map<Integer,Map<String,Long>> projectunInvestedNums = new HashMap<>();
        for(Integer year:years){
            Map<String,Long> pns = new HashMap<>();
            projectNums.put(year,pns);
            Map<String,Long> pins = new HashMap<>();
            projectInvestedNums.put(year,pins);
            Map<String,Long> puins = new HashMap<>();
            projectunInvestedNums.put(year,puins);
            for(String industryName :industryNames){
                pns.put(industryName,0l);
                pins.put(industryName,0l);
                puins.put(industryName,0l);
            }
        }
        Map<String,Map<Integer,Map<String,Long>>> data =new HashMap<>();
        data.put("projectNums",projectNums);
        data.put("projectInvestedNums",projectInvestedNums);
        data.put("projectunInvestedNums",projectunInvestedNums);
        return data;
    }

}
