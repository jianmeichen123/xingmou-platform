package com.gi.ctdn.api.rest;

import com.gi.ctdn.biz.ListedExchangeBiz;
import com.gi.ctdn.pojo.ListedExchange;
import com.gi.ctdn.view.common.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("listedExchange")
public class ListedExchangeController {
    @Autowired
    ListedExchangeBiz listedExchangeBiz;

    @ResponseBody
    @RequestMapping("getListedExchanges")
    public MessageInfo<List<ListedExchange>> getListedExchanges(){
        return listedExchangeBiz.getListedExchages();
    }
}
