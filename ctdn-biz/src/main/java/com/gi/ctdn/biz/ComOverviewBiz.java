package com.gi.ctdn.biz;

import com.gi.ctdn.dao.ComOverviewDao;
import com.gi.ctdn.dao.IndustryDAO;
import com.gi.ctdn.pojo.Industry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service("comOverviewBiz")
public class ComOverviewBiz {

    private static final Logger LOGGER = LoggerFactory.getLogger(ComOverviewBiz.class);

    @Autowired
    private ComOverviewDao comOverviewDao;

    @Autowired
    private IndustryDAO industryDAO;

    public  List<Map<String, Object>> area(String date) {
        return comOverviewDao.area(date);
    }

    public  List<Map<String, Object>> industry(String date) {
        return comOverviewDao.industry(date);
    }

    public  Map<String,Object> quarterOfIndustry(String date) {
        return null;
    }

    public  Map<String,Object> investedRate() {
        List<Map<String, String>> data = comOverviewDao.investedRate();
        List<String> industryName = new ArrayList<>();
        List<String> unInvestedNum = new ArrayList<>();
        List<String> investedNum = new ArrayList<>();
        List<String> investedRate = new ArrayList<>();
        List<String> investedRateLastYear = new ArrayList<>();
        for(Map<String,String> map:data){
            industryName.add(map.get("industryName"));
            unInvestedNum.add(map.get("unInvestedNum"));
            investedNum.add(map.get("investedNum"));
            investedRate.add(map.get("investedRate"));
            investedRateLastYear.add(map.get("investedRateLastYear"));
        }
        Map<String,Object> result = new HashMap<>();
        result.put("industryName",industryName);
        result.put("unInvestedNum",unInvestedNum);
        result.put("investedNum",investedNum);
        result.put("investedRate",investedRate);
        result.put("investedRateLastYear",investedRateLastYear);
        return result;

    }

    public Map<String, Object> projectSetup(){
        Map<String,Object> result = new HashMap<>();
        List<Map<String,String>> res = comOverviewDao.projectSetupQuarter();
        List<Industry> industries = industryDAO.selectParentindustrys();
        List<String> industryNames = new ArrayList<>();
        Map<String,Integer> nameIndex= new HashMap<>();
        int i = 0;
        for(Industry industry:industries){
            industryNames.add(industry.getName());
            nameIndex.put(industry.getName(),i);
            i++;
        }
        Map<String,int[]> data = new TreeMap<>();
        List<String> quarters = new ArrayList<>();
        Map<String,Integer> quartersCoumt = new TreeMap<>();
        for (int j=res.size();j>0;j--){
            Map<String,String> m = res.get(j-1);
            quarters.add(m.get("investQuarter"));
            data.put(m.get("investQuarter"),new int[industryNames.size()]);
            quartersCoumt.put(m.get("investQuarter"),0);
        }

        List<Map<String, Object>> projectSetupDate = comOverviewDao.projectSetup();
        for(Map<String, Object> map:projectSetupDate){
            int[] arr = data.get(map.get("investQuarter"));
            String name = (String) map.get("industryName");
            if (name ==null){
                name = "其他";
            }
            Integer index = nameIndex.get(name);
            arr[index] = (int) map.get("projNum");
            quartersCoumt.put((String) map.get("investQuarter"),quartersCoumt.get(map.get("investQuarter"))+(int) map.get("projNum"));
            //data.get(map.get("investQuarter"))[nameIndex.get("industryName")] =Integer.parseInt(map.get("projNum"));
        }
        result.put("names",industryNames);
        result.put("data:bar",data);
        result.put("quarters",quarters);
        result.put("quartersCoumt",quartersCoumt);
        return result;
    }
}

