package com.gi.xm.platform.controller;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.StringUtils;
import com.gi.xm.report.biz.ChartEventIndustryDistictYearBiz;
import com.gi.xm.report.biz.ChartEventIndustryMoneylevelYearBiz;
import com.gi.xm.report.biz.ChartEventIndustrySubDistictYearBiz;
import com.gi.xm.report.biz.ChartEventIndustrySubMoneylevelYearBiz;
import com.gi.xm.report.common.ChartPojo;
import com.gi.xm.report.common.NameValue;
import com.gi.xm.report.pojo.ChartEventIndustryDistictYear;
import com.gi.xm.report.pojo.ChartEventIndustryMoneylevelYear;
import com.gi.xm.report.pojo.ChartEventIndustrySubDistictYear;
import com.gi.xm.report.pojo.ChartEventIndustrySubMoneylevelYear;
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
 * Created by vincent on 16-10-5.
 */
@Controller
@RequestMapping("zbrd")
public class ZBRDController {

    @Autowired
    private ChartEventIndustryDistictYearBiz chartEventIndustryDistictYearBiz;

    @Autowired
    private ChartEventIndustrySubDistictYearBiz chartEventIndustrySubDistictYearBiz;

    @Autowired
    private ChartEventIndustryMoneylevelYearBiz chartEventIndustryMoneylevelYearBiz;

    @Autowired
    private ChartEventIndustrySubMoneylevelYearBiz chartEventIndustrySubMoneylevelYearBiz;


    @RequestMapping("map/{years}/{industryId}")
    @ResponseBody
    public MessageInfo map(@PathVariable("years") Integer[] years,@PathVariable("industryId") Integer industryId){
        MessageInfo<ChartPojo>  messageInfo = new MessageInfo<>();
        MessageInfo<List<ChartEventIndustryDistictYear>> mdata = chartEventIndustryDistictYearBiz.selectByYearIndustryId(years,industryId);
        if (!messageInfo.isSuccess()){
            return mdata;
        }
        List<ChartEventIndustryDistictYear> cs = mdata.getData();
        Map<String,List<NameValue>> data = new HashMap<>();
        data.put("investedNum",new ArrayList<NameValue>());
        data.put("investedMoney",new ArrayList<NameValue>());
        data.put("investedNumCent",new ArrayList<NameValue>());

        for(ChartEventIndustryDistictYear  c :cs){
            String districtName = c.getDistrictName();
            if(districtName != null){
                districtName = StringUtils.makeDistrictName(c.getDistrictName());
                NameValue nameValue = NameValue.getNameValue(data.get("investedNum"),districtName);
                nameValue.setValue(nameValue.getValue()+c.getInvestedNum());
                nameValue = NameValue.getNameValue(data.get("investedMoney"),districtName);
                nameValue.setValue(nameValue.getValue()+c.getInvestedMoney());
                nameValue = NameValue.getNameValue(data.get("investedNumCent"),districtName);
                nameValue.setValue(nameValue.getValue()+c.getInvestedNumCent());
            }
        }

        ChartPojo chartPojo = new ChartPojo();
        chartPojo.setCal(data);
        messageInfo.setData(chartPojo);
        return messageInfo;
    }

    @RequestMapping("subMap/{years}/{industryId}/{industrySubId}")
    @ResponseBody
    public MessageInfo subMap(@PathVariable("years") Integer[] years, @PathVariable("industrySubId") Integer industrySubId){
        MessageInfo<ChartPojo>  messageInfo = new MessageInfo<>();
        MessageInfo<List<ChartEventIndustrySubDistictYear>> mdata = chartEventIndustrySubDistictYearBiz.selectByYearIndustrySubId(years, industrySubId);
        if (!messageInfo.isSuccess()){
            return mdata;
        }
        List<ChartEventIndustrySubDistictYear> cs = mdata.getData();
        Map<String,List<NameValue>> data = new HashMap<>();
        data.put("investedNum",new ArrayList<NameValue>());
        data.put("investedMoney",new ArrayList<NameValue>());
        data.put("investedNumCent",new ArrayList<NameValue>());

        for(ChartEventIndustrySubDistictYear  c :cs){
            String districtName = c.getDistrictName();
            if(districtName != null){
                districtName = StringUtils.makeDistrictName(c.getDistrictName());
                NameValue nameValue = NameValue.getNameValue(data.get("investedNum"),districtName);
                nameValue.setValue(nameValue.getValue()+c.getInvestedNum());
                nameValue = NameValue.getNameValue(data.get("investedMoney"),districtName);
                nameValue.setValue(nameValue.getValue()+c.getInvestedMoney());
                nameValue = NameValue.getNameValue(data.get("investedNumCent"),districtName);
                nameValue.setValue(nameValue.getValue()+c.getInvestedNumCent());
            }
        }

        ChartPojo chartPojo = new ChartPojo();
        chartPojo.setCal(data);
        messageInfo.setData(chartPojo);
        return messageInfo;
    }




    @RequestMapping("pie/{years}/{industryId}")
    @ResponseBody
    public MessageInfo pie(@PathVariable("years") Integer[] years,@PathVariable("industryId") Integer industryId){
        MessageInfo<ChartPojo>  messageInfo = new MessageInfo<>();
        MessageInfo<List<ChartEventIndustryMoneylevelYear>> mdata = chartEventIndustryMoneylevelYearBiz.selectByYearIndustryId(years,industryId);
        if (!messageInfo.isSuccess()){
            return mdata;
        }
        List<ChartEventIndustryMoneylevelYear> cs = mdata.getData();
        Map<String,List<NameValue>> data = new HashMap<>();
        data.put("num",new ArrayList<NameValue>());

        for(ChartEventIndustryMoneylevelYear  c :cs){
            String title = c.getMoneyLevelTitle();
            if(title != null){
                NameValue nameValue = NameValue.getNameValue(data.get("num"),title);
                nameValue.setValue(nameValue.getValue()+c.getMoneyLevelNum());
            }
        }

        ChartPojo chartPojo = new ChartPojo();
        chartPojo.setCal(data);
        messageInfo.setData(chartPojo);
        return messageInfo;
    }

    @RequestMapping("subPie/{years}/{industryId}/{industrySubId}")
    @ResponseBody
    public MessageInfo subPie(@PathVariable("years") Integer[] years, @PathVariable("industrySubId") Integer industrySubId){
        MessageInfo<ChartPojo>  messageInfo = new MessageInfo<>();
        MessageInfo<List<ChartEventIndustrySubMoneylevelYear>> mdata = chartEventIndustrySubMoneylevelYearBiz.selectByYearIndustrySubId(years, industrySubId);
        if (!messageInfo.isSuccess()){
            return mdata;
        }
        List<ChartEventIndustrySubMoneylevelYear> cs = mdata.getData();
        Map<String,List<NameValue>> data = new HashMap<>();
        data.put("num",new ArrayList<NameValue>());

        for(ChartEventIndustrySubMoneylevelYear  c :cs){
            String title = c.getMoneyLevelTitle();
            if(title != null){
                NameValue nameValue = NameValue.getNameValue(data.get("num"),title);
                nameValue.setValue(nameValue.getValue()+c.getMoneyLevelNum());
            }
        }

        ChartPojo chartPojo = new ChartPojo();
        chartPojo.setCal(data);
        messageInfo.setData(chartPojo);
        return messageInfo;
    }

}
