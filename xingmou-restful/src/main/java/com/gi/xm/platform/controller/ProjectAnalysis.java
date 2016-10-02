package com.gi.xm.platform.controller;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.StringUtils;
import com.gi.xm.report.biz.*;
import com.gi.xm.report.common.ChartPojo;
import com.gi.xm.report.common.NameValue;
import com.gi.xm.report.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vincent on 16-9-29.
 */

@Controller
@RequestMapping("projectAnalysis")
public class ProjectAnalysis {

    @Autowired
    private ChartEventIndustryDistictYearBiz chartEventIndustryDistictYearBiz;

    @Autowired
    private ChartEventIndustrySubDistictYearBiz chartEventIndustrySubDistictYearBiz;

    @RequestMapping("map/{years}/{industryId}")
    @ResponseBody
    public MessageInfo map(@PathVariable("years") Integer[] years,@PathVariable("industryId") Integer industryId){
        MessageInfo<ChartPojo>  messageInfo = new MessageInfo<>();
        MessageInfo<List<ChartEventIndustryDistictYear>> mdata = chartEventIndustryDistictYearBiz.getListByYear(years);
        if (!messageInfo.isSuccess()){
            return mdata;
        }
        List<ChartEventIndustryDistictYear> cs = mdata.getData();
        Map<String,Map<String,Integer>> data = new HashMap<>();
        for(ChartEventIndustryDistictYear  c :cs){
            String industryName = c.getIndustryName();
            if(industryName != null){
                Map<String,Integer> m = data.get(industryName);
                if(m == null){
                    m = new HashMap<>();
                    data.put(industryName,m);
                }
                String districtName = StringUtils.makeDistrictName(c.getDistrictName());
              if (m.get(districtName)==null){
                  m.put(districtName,0);
              }
              m.put(districtName,m.get(districtName)+c.getInvestedNum());
          }
        }

        ChartPojo chartPojo = new ChartPojo();
        chartPojo.setRaw(data);
        messageInfo.setData(chartPojo);
        return messageInfo;
    }

    @RequestMapping("subMap/{years}/{industryId}")
    @ResponseBody
    public MessageInfo subMap(@PathVariable("years") Integer[] years,@PathVariable("industryId") Integer industryId){
        MessageInfo<ChartPojo>  messageInfo = new MessageInfo<>();
        MessageInfo<List<ChartEventIndustrySubDistictYear>> mdata = chartEventIndustrySubDistictYearBiz.selectByYearIndustryId(years, industryId);
        if (!messageInfo.isSuccess()){
            return mdata;
        }
        List<ChartEventIndustrySubDistictYear> cs = mdata.getData();
        Map<String,Map<String,Integer>> data = new HashMap<>();
        for(ChartEventIndustrySubDistictYear  c :cs){
            String industryName = c.getIndustrySubName();
            if(industryName != null){
                Map<String,Integer> m = data.get(industryName);
                if(m == null){
                    m = new HashMap<>();
                    data.put(industryName,m);
                }
                String districtName = StringUtils.makeDistrictName(c.getDistrictName());
                if (m.get(districtName)==null){
                    m.put(districtName,0);
                }
                m.put(districtName,m.get(districtName)+c.getInvestedNum());
            }
        }

        ChartPojo chartPojo = new ChartPojo();
        chartPojo.setRaw(data);
        messageInfo.setData(chartPojo);
        return messageInfo;
    }

    @Autowired
    private ChartProjectIndustryYearBiz chartProjectIndustryYearBiz;


    @Autowired
    private ChartProjectIndustrySubYearBiz chartProjectIndustrySubYearBiz;

    @Autowired
    private ChartEventIndustryRoundYearBiz chartEventIndustryRoundYearBiz;

    @Autowired
    private ChartEventIndustrySubRoundYearBiz chartEventIndustrySubRoundYearBiz;

    @RequestMapping("bar/{years}/{industryNames}/{industryId}")
    @ResponseBody
    public MessageInfo bar(@PathVariable("years") Integer[] years,@PathVariable("industryNames") String[] industryNames,@PathVariable("industryId") Integer industryId) {

        if (industryNames != null && industryId == 0) {
            MessageInfo<List<ChartProjectIndustryYear>> messageInfo = chartProjectIndustryYearBiz.selectByYear(years);
            if (!messageInfo.isSuccess()) {
                return messageInfo;
            }
            MessageInfo<List<ChartEventIndustryRoundYear>> messageInfoRound = chartEventIndustryRoundYearBiz.getListByYear(years);
            if (!messageInfoRound.isSuccess()) {
                return messageInfoRound;
            }
            Map<String, Map<Integer, List<Long>>> data = initBarMap(years, industryNames);
            for (ChartProjectIndustryYear c : messageInfo.getData()) {
                int index = 0;
                for(String name:industryNames){
                    if (name.equalsIgnoreCase(c.getIndustryName())&&data.get("projectNums").get(c.getYear())!=null){
                        data.get("projectNums").get(c.getYear()).set(index,c.getProjectNum().longValue());
                        data.get("projectInvestedNums").get(c.getYear()).set(index,c.getProjectInvestedNum().longValue());
                        data.get("projectunInvestedNums").get(c.getYear()).set(index,c.getProjectUninvestedNum().longValue());

                    }
                    index ++;
                }
            }
            Map<Integer,List<NameValue>> rounds = new HashMap<>();
            for(ChartEventIndustryRoundYear c:messageInfoRound.getData()){
                if (rounds.get(c.getYear())==null){
                    rounds.put(c.getYear(),new ArrayList<NameValue>());
                }
                NameValue nameValue = getNameValue(rounds.get(c.getYear()),c.getRoundName());
                nameValue.setValue(nameValue.getValue()+c.getInvestedNum());
            }
            MessageInfo<ChartPojo> m = new MessageInfo<>();
            ChartPojo c = new ChartPojo();
            c.setRaw(data);
            Map<String,Object> cal = new HashMap<>();
            cal.put("rounds",rounds);
            c.setCal(cal);
            m.setData(c);
            return m;

        } else if (industryNames != null && industryId > 0) {
            MessageInfo<List<ChartProjectIndustrySubYear>> messageInfo = chartProjectIndustrySubYearBiz.getListByYear(years, industryId);
            if (!messageInfo.isSuccess()) {
                return messageInfo;
            }
            MessageInfo<List<ChartEventIndustrySubRoundYear>> messageInfoRound = chartEventIndustrySubRoundYearBiz.getListByYearIndustryId(years, industryId);
            if (!messageInfoRound.isSuccess()) {
                return messageInfoRound;
            }
            Map<String, Map<Integer, List<Long>>> data = initBarMap(years, industryNames);
            for (ChartProjectIndustrySubYear c : messageInfo.getData()) {
                int index = 0;
                for(String name:industryNames){
                    if (name.equalsIgnoreCase(c.getIndustrySubName())&&data.get("projectNums").get(c.getYear())!=null){
                        data.get("projectNums").get(c.getYear()).set(index,c.getProjectNum().longValue());
                        data.get("projectInvestedNums").get(c.getYear()).set(index,c.getProjectInvestedNum().longValue());
                        data.get("projectunInvestedNums").get(c.getYear()).set(index,c.getProjectUninvestedNum().longValue());

                    }
                    index ++;
                }
            }
            Map<Integer,List<NameValue>> rounds = new HashMap<>();
            for(ChartEventIndustrySubRoundYear c:messageInfoRound.getData()){
                if (rounds.get(c.getYear())==null){
                    rounds.put(c.getYear(),new ArrayList<NameValue>());
                }
                NameValue nameValue = getNameValue(rounds.get(c.getYear()),c.getRoundName());
                nameValue.setValue(nameValue.getValue()+c.getInvestedNum());
            }
            MessageInfo<ChartPojo> m = new MessageInfo<>();
            ChartPojo c = new ChartPojo();
            c.setRaw(data);
            Map<String,Object> cal = new HashMap<>();
            cal.put("rounds",rounds);
            c.setCal(cal);
            m.setData(c);
            return m;
        } else {
            return null;
        }
    }


    private Map<String,Map<Integer,List<Long>>> initBarMap(Integer[] years, String[] industryNames){
        Map<Integer,List<Long>> projectNums = new HashMap<>();
        Map<Integer,List<Long>> projectInvestedNums = new HashMap<>();
        Map<Integer,List<Long>> projectunInvestedNums = new HashMap<>();
        for(Integer year:years){
            projectNums.put(year,new ArrayList<Long>());
            projectInvestedNums.put(year,new ArrayList<Long>());
            projectunInvestedNums.put(year,new ArrayList<Long>());
            for(String industryName :industryNames){
                projectNums.get(year).add(0l);
                projectInvestedNums.get(year).add(0l);
                projectunInvestedNums.get(year).add(0l);
            }
        }
        Map<String,Map<Integer,List<Long>>> data =new HashMap<>();
        data.put("projectNums",projectNums);
        data.put("projectInvestedNums",projectInvestedNums);
        data.put("projectunInvestedNums",projectunInvestedNums);

        return data;
    }

    private NameValue getNameValue(List<NameValue> nameValues,String roundName){
        for (NameValue nameValue : nameValues){
            if (roundName.equalsIgnoreCase(nameValue.getName())){
                return nameValue;
            }
        }
        NameValue nameValue = new NameValue();
        nameValue.setName(roundName);
        nameValue.setValue(0l);
        nameValues.add(nameValue);
        return nameValue;
    }
}
