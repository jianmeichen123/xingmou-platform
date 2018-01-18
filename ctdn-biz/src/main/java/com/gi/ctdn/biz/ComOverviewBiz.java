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
}

