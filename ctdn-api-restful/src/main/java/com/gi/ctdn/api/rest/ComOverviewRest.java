package com.gi.ctdn.api.rest;

import com.gi.ctdn.biz.ComOverviewBiz;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("comOverview")
public class ComOverviewRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ComOverviewRest.class);

    @Autowired
    private ComOverviewBiz comOverviewBiz;

    private String lastyear(Integer recent){
        if(recent==1||recent==3||recent==6){
            SimpleDateFormat aSimpleDateFormat = new SimpleDateFormat("yyyy-MM");
            GregorianCalendar aGregorianCalendar = new GregorianCalendar();
            aGregorianCalendar.set(Calendar.YEAR, aGregorianCalendar.get(Calendar.YEAR) - recent);
            String year = aSimpleDateFormat.format(aGregorianCalendar.getTime());
            return year;
        }
        return null;
    }
    @RequestMapping(value = "area/{recent}",method = RequestMethod.GET)
    @ResponseBody
    //@Cacheable(value = "area",keyGenerator = "baseKG")
    public List<Map<String, Object>> area(@PathVariable int recent){
        String year = lastyear(recent);
        if (year != null){
           return comOverviewBiz.area(year);
        }
        return null;
    }

    @RequestMapping(value = "industry/{recent}",method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, Object>> industry(@PathVariable int recent){
        String year = lastyear(recent);
        if (year != null){
            return comOverviewBiz.industry(year);
        }
        return null;
    }

    @RequestMapping(value = "quarterOfIndustry",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> quarterOfIndustry(){
        return comOverviewBiz.quarterOfIndustry("");
    }


    @RequestMapping(value = "investedRate",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> investedRate(){
        return comOverviewBiz.investedRate();
    }

    @RequestMapping(value = "projectSetup",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> projectSetup(){
        return comOverviewBiz.projectSetup();
    }

}
