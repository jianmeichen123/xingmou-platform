package com.gi.xm.platform.restful;

import com.gi.ctdn.ods.biz.*;
import com.gi.ctdn.ods.pojo.*;
import com.gi.xm.platform.mongodb.pojo.BaiduNews;
import com.gi.xm.platform.mongodb.query.BaiduNewsQuery;
import com.gi.xm.platform.mongodb.service.BaiduNewsService;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("op")
public class OPController {

    @Autowired
    private AlexaPvUvBiz alexaPvUvBiz;

    @Autowired
    private AsoIosDownBiz asoIosDownBiz;
    @Autowired
    private AsoIosRateBiz asoIosRateBiz;
    @Autowired
    private AsoIosRateDailyBiz asoIosRateDailyBiz;
    @Autowired
    private OpIndiceSummaryBiz opIndiceSummaryBiz;
    @Autowired
    private QqAndroidDownBiz qqAndroidDownBiz;
    @Autowired
    private QqAndroidRateBiz qqAndroidRateBiz;
    @Autowired
    private QqAndroidRateDailyBiz qqAndroidRateDailyBiz;
    @Autowired
    private WeixinIndiceBiz weixinIndiceBiz;


    @RequestMapping("pvuv/{code}")
    @ResponseBody
    public MessageInfo<List<AlexaPvUv>> alexaPvUvpvuv(@PathVariable String code) {
        MessageInfo<List<AlexaPvUv>> messageInfo = alexaPvUvBiz.getListByCode(code);
        return messageInfo;
    }

    @RequestMapping("iosdown/{appid}")
    @ResponseBody
    public MessageInfo<List<AsoIosDown>> asoIosDowniosdown(@PathVariable Long appid){
        MessageInfo<List<AsoIosDown>> messageInfo = asoIosDownBiz.getListByAppid(appid);
        return messageInfo;
    }


    @RequestMapping("rateinfo/{appid}")
    @ResponseBody
    public MessageInfo<List<AsoIosRate>> asoIosRate(@PathVariable Long appid){
        MessageInfo<List<AsoIosRate>> messageInfo = asoIosRateBiz.getListByAppid(appid);
        return messageInfo;
    }

    @RequestMapping("iosratedaily/{appid}")
    @ResponseBody
    public MessageInfo<List<AsoIosRateDaily>> asoIosRateDaily(@PathVariable Long appid){
        MessageInfo<List<AsoIosRateDaily>> messageInfo = asoIosRateDailyBiz.getListByAppid(appid);
        return messageInfo;
    }



    @RequestMapping("is/{code}")
    @ResponseBody
    public MessageInfo<List<OpIndiceSummary>> opIndiceSummary(@PathVariable String code){
        MessageInfo<List<OpIndiceSummary>> messageInfo = opIndiceSummaryBiz.getListByCode(code);
        return messageInfo;
    }



    @RequestMapping("qqandroiddown/{appid}")
    @ResponseBody
    public MessageInfo<List<QqAndroidDown>> qqAndroidDown(@PathVariable Long appid){
        MessageInfo<List<QqAndroidDown>> messageInfo = qqAndroidDownBiz.getListByAppid(appid);
        return messageInfo;
    }
    @RequestMapping("qqandroidrate/{appid}")
    @ResponseBody
    public MessageInfo<List<QqAndroidRate>> qqAndroidRate(@PathVariable Long appid){
        MessageInfo<List<QqAndroidRate>> messageInfo = qqAndroidRateBiz.getListByAppid(appid);
        return messageInfo;
    }




    @RequestMapping("qqandroidratedaily/{appid}")
    @ResponseBody
    public MessageInfo<List<QqAndroidRateDaily>> getListByAppid(@PathVariable Long appid){
        MessageInfo<List<QqAndroidRateDaily>> messageInfo = qqAndroidRateDailyBiz.getListByAppid(appid);
        return messageInfo;
    }

    @RequestMapping("weixinindice/{wxid}")
    @ResponseBody
    public MessageInfo<List<WeixinIndice>> weixinIndice(@PathVariable String wxid){
        MessageInfo<List<WeixinIndice>> messageInfo = weixinIndiceBiz.getListByWxid(wxid);
        return messageInfo;
    }
}
