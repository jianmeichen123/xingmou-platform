package com.gi.ctdn.api.rest;

import com.gi.ctdn.biz.CapitalTypeBiz;
import com.gi.ctdn.pojo.CapitalType;
import com.gi.xm.platform.view.common.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by vincent on 17-4-24.
 */
@Controller
@RequestMapping("common")
public class CommonRest {

    @Autowired
    private CapitalTypeBiz capitalTypeBiz;

    @RequestMapping("capitalType")
    @ResponseBody
    @Cacheable(value = "capitalType",keyGenerator = "baseKG")
    public MessageInfo<List<CapitalType>> capitalType(){
        return capitalTypeBiz.getAllCapitalType();
    }


    @RequestMapping("comQuery")
    @ResponseBody
    @Cacheable(value = "proQuery",keyGenerator = "baseKG")
    public MessageInfo<Map> proQuery(){

        return null;
    }


}
