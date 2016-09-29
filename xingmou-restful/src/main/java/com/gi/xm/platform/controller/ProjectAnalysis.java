package com.gi.xm.platform.controller;

import com.alibaba.druid.sql.visitor.functions.Char;
import com.gi.xm.platform.view.LabelInfo;
import com.gi.xm.platform.view.common.Contants;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.report.biz.ChartEventIndustryDistictYearBiz;
import com.gi.xm.report.common.ChartPojo;
import com.gi.xm.report.common.Message;
import com.gi.xm.report.pojo.ChartEventIndustryDistictYear;
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
    }
}
