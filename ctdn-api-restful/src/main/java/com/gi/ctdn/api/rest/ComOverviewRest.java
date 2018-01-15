package com.gi.ctdn.api.rest;

import com.gi.ctdn.biz.ComOverviewBiz;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("comOverview")
public class ComOverviewRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ComOverviewRest.class);

    @Autowired
    private ComOverviewBiz comOverviewBiz;

    @RequestMapping(value = "area",method = RequestMethod.GET)
    @ResponseBody
    @Cacheable(value = "area",keyGenerator = "baseKG")
    public List<Map<String, Object>> area(){
        return comOverviewBiz.area(2017);
    }

    @RequestMapping(value = "industry",method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, Object>> industry(){
        return comOverviewBiz.industry(2017);
    }

    @RequestMapping(value = "quarterOfIndustry",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> quarterOfIndustry(){
        return comOverviewBiz.quarterOfIndustry("");
    }
}
