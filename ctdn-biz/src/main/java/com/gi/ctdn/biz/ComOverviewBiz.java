package com.gi.ctdn.biz;

import com.gi.ctdn.dao.ComOverviewDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service("comOverviewBiz")
public class ComOverviewBiz {

    private static final Logger LOGGER = LoggerFactory.getLogger(ComOverviewBiz.class);

    @Autowired
    private ComOverviewDao comOverviewDao;

    public  List<Map<String, Object>> area(Integer year) {
        return comOverviewDao.area(year);
    }

    public  List<Map<String, Object>> industry(Integer year) {
        return comOverviewDao.industry(year);
    }

    public  Map<String,Object> quarterOfIndustry(String date) {
        List<Map<String, Object>> rows = comOverviewDao.quarterOfIndustry(date);

        Map<String,Map<String, Integer>> bars = new TreeMap<>();

        for(Map<String, Object> row :rows){
            if (row.get("industryName") != null && row.get("setupDT").toString().contains("-")){
                String k = row.get("setupDT").toString().split("-")[0]+"Q"+((Integer.parseInt(row.get("setupDT").toString().split("-")[1])-1)/3+1);
                Map<String, Integer> bar = bars.get(k);
                if(bar==null){
                    bar = new HashMap<>();
                    bars.put(k,bar);
                }
                Integer v = bar.get(row.get("industryName").toString());
                if (v==null){
                    v = 0;
                    bar.put(row.get("industryName").toString(),v);
                }
                bar.put(row.get("industryName").toString(),v+1);
            }
        }
        Map<String,Object>  data = new HashMap<>();
        data.put("bar",bars);
        return data;
    }

}
