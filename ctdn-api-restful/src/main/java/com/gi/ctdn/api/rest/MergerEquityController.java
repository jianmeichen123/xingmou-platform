package com.gi.ctdn.api.rest;

import com.gi.ctdn.biz.MergerEquityBiz;
import com.gi.ctdn.pojo.MergerEquity;
import com.gi.ctdn.view.common.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("mergerEquity")
public class MergerEquityController {
    @Autowired
    MergerEquityBiz mergerEquityBiz;

    @ResponseBody
    @RequestMapping("getMergerEquitys/{timeType}")
    public MessageInfo<List<MergerEquity>> getMergerEquitys(@PathVariable Integer timeType){
        return mergerEquityBiz.getMergerEquitys(timeType);
    }
}
