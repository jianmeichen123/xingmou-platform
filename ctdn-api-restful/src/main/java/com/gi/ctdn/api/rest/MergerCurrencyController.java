package com.gi.ctdn.api.rest;

import com.gi.ctdn.biz.MergerCurrencyBiz;
import com.gi.ctdn.pojo.MergerCurrency;
import com.gi.ctdn.view.common.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("mergerCurrency")
public class MergerCurrencyController {
    @Autowired
    MergerCurrencyBiz mergerCurrencyBiz;

    @ResponseBody
    @RequestMapping("getMergerCurrencys/{timeType}")
    public MessageInfo<List<MergerCurrency>> getMergerCurrencys(@PathVariable  Integer timeType){
        return  mergerCurrencyBiz.getMergerCurrencyList(timeType);
    }
}
