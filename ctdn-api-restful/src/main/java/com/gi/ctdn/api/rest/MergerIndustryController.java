package com.gi.ctdn.api.rest;

import com.gi.ctdn.biz.MergerIndustryBiz;
import com.gi.ctdn.pojo.MergerIndustry;
import com.gi.ctdn.view.common.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("mergerIndustry")
public class MergerIndustryController {
    @Autowired
    MergerIndustryBiz mergerIndustryBiz;

    @ResponseBody
    @RequestMapping("getMergerIndustrys/{timeType}")
    public MessageInfo<List<MergerIndustry>> getMergerIndustrys(@PathVariable String timeType){
        return mergerIndustryBiz.getMergerIndustrys(timeType);
    }
}
