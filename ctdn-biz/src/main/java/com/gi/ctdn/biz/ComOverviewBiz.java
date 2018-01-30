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
            String name = map.get("industryName");
            if(name !=null){
                industryName.add(map.get("industryName"));
                unInvestedNum.add(map.get("unInvestedNum"));
                investedNum.add(map.get("investedNum"));
                investedRate.add(map.get("investedRate"));
                investedRateLastYear.add(map.get("investedRateLastYear"));
            }
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
        Calendar c =Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int quarter = month/4+1;
        String[] quarters = new String[8];
        for(int i=0;i<8;i++){
            quarters[i] = year+"Q"+quarter;
            quarter--;
            if (quarter==0){
                quarter = 4;
                year--;
            }
        }
        List<Industry> industries = industryDAO.selectParentindustrys();
        List<String> industryNames = new ArrayList<>();
        Map<String,Integer> nameIndex= new HashMap<>();
        int i = 0;
        for(Industry industry:industries){
            if (industry.getName()!=null){
                industryNames.add(industry.getName());
                nameIndex.put(industry.getName(),i);
                i++;
            }

        }
        Map<String,int[]> data = new TreeMap<>();

        Map<String,Integer> quartersCoumt = new TreeMap<>();
        for(String s:quarters){
            data.put(s,new int[industryNames.size()]);
            quartersCoumt.put(s,0);
        }

        List<Map<String, Object>> projectSetupDate = comOverviewDao.projectSetup(quarters);
        for(Map<String, Object> map:projectSetupDate){
            int[] arr = data.get(map.get("investQuarter"));
            String name = (String) map.get("industryName");
            if (name ==null||name.equals("null")){
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

