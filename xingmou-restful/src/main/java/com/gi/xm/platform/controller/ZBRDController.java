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
    @Autowired
    private ChartDataIndustryFirstYearBiz chartDataIndustryFirstYearBiz;

    @Autowired
    private ChartDataIndustryYearBiz chartDataIndustryYearBiz;

    @Autowired
    private ChartDataYearBiz chartDataYearBiz;
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
        List<String> names = new ArrayList<>();
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


    @RequestMapping("chartDataYear/{years}/{industryId}/{industrySubId}")
    @ResponseBody
    public MessageInfo chartDataYear(@PathVariable("years") Integer[] years,@PathVariable("industryId") Integer industryId, @PathVariable("industrySubId") Integer industrySubId){
        MessageInfo<ChartDataYearVO>  messageInfo = new MessageInfo<>();
        ChartDataYearVO vo  = new ChartDataYearVO();
        //年统计
        if (industryId==0&&industrySubId==0) {

            MessageInfo<List<ChartDataYear>>  mData = chartDataYearBiz.getListByYaar(years);
           // return mData;
          /*  if (!messageInfo.isSuccess()){
                return mData;
            }*/
            List<ChartDataYear> dataYearList =  mData.getData();

            for (ChartDataYear data:dataYearList) {
                vo.getYearList().add(data.getYaar());
                vo.getInvestedMaxMoneyList().add(data.getInvestedMaxMoney());
                vo.getInvestedMedianMoneyList().add(data.getInvestedMedianMoney());
                vo.getInvestedNumList().add(data.getInvestedNum());
                vo.getInvestedNumRateList().add(data.getInvestedNumRate()/100+"%");
                vo.getInvestedPerMoneyList().add(data.getInvestedPerMoney());
                vo.getMarketMoneyList().add(data.getInvestedMoney());
                vo.getMarketMoneyRateList().add(data.getInvestedMoneyRate()/100+"%");
            }



        }else if (industrySubId!=0) {
            //子行业

            MessageInfo<List<ChartDataIndustryYear>>  mData = chartDataIndustryYearBiz.getListByYaarIndustrySubId(years,industrySubId);
            List<ChartDataIndustryYear> dataYearList =  mData.getData();
           
            for (ChartDataIndustryYear data:dataYearList) {
                vo.getYearList().add(data.getYaar());
                vo.getInvestedMaxMoneyList().add(data.getInvestedMaxMoney());
                vo.getInvestedMedianMoneyList().add(data.getInvestedMedianMoney());
                vo.getInvestedNumList().add(data.getInvestedNum());
                vo.getInvestedNumRateList().add(data.getInvestedNumRate()/100+"%");
                vo.getInvestedPerMoneyList().add(data.getInvestedPerMoney());
                vo.getMarketMoneyList().add(data.getInvestedMoney());
                vo.getMarketMoneyRateList().add(data.getInvestedMoneyRate()/100+"%");
            }

            messageInfo.setData(vo);

        }else{
            //一级行业

            MessageInfo<List<ChartDataIndustryFirstYear>>  mData = chartDataIndustryFirstYearBiz.getListByIndustryIdYaar(years,industryId);
            List<ChartDataIndustryFirstYear> dataYearList =  mData.getData();

            for (ChartDataIndustryFirstYear data:dataYearList) {
                vo.getYearList().add(data.getYaar());
                vo.getInvestedMaxMoneyList().add(data.getInvestedMaxMoney());
                vo.getInvestedMedianMoneyList().add(data.getInvestedMedianMoney());
                vo.getInvestedNumList().add(data.getInvestedNum());
                vo.getInvestedNumRateList().add(data.getInvestedNumRate()/100+"%");
                vo.getInvestedPerMoneyList().add(data.getInvestedPerMoney());
                vo.getMarketMoneyList().add(data.getInvestedMoney());
                vo.getMarketMoneyRateList().add(data.getInvestedMoneyRate()/100+"%");
            }
        }

        messageInfo.setData(vo);
        return messageInfo;

    }
}
