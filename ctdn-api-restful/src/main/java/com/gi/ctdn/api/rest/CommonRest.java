package com.gi.ctdn.api.rest;

import com.gi.ctdn.biz.*;
import com.gi.ctdn.pojo.*;
import com.gi.xm.platform.view.common.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
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

    @Autowired
    private CurrencyTypeBiz currencyTypeBiz;

    @Autowired
    private DistrictBiz districtBiz;

    @Autowired
    private IndustryBiz industryBiz;

    @Autowired
    private ListingTypeBiz listingTypeBiz;

    @Autowired
    private InvestRoundBiz investRoundBiz;

    @Autowired
    private MergeStatusBiz mergeStatusBiz;

    @Autowired
    private MergeTypeBiz mergeTypeBiz;

    @Autowired
    private OrgTypeBiz orgTypeBiz;

    @Autowired
    private QuitTypeBiz quitTypeBiz;


    @RequestMapping("capitalType")
    @ResponseBody
    @Cacheable(value = "capitalType",keyGenerator = "baseKG")
    public MessageInfo<List<CapitalType>> capitalType(){
        return capitalTypeBiz.getAllCapitalType();
    }


    @RequestMapping("currencyType")
    @ResponseBody
    @Cacheable(value = "currencyType",keyGenerator = "baseKG")
    public MessageInfo<List<CurrencyType>> currencyType() {
        return currencyTypeBiz.getAllCurrencyType();
    }


    @RequestMapping("district")
    @ResponseBody
    @Cacheable(value = "district",keyGenerator = "baseKG")
    public MessageInfo<List<District>> district() {
        return districtBiz.getAllDistrict();
    }


    @RequestMapping("industry")
    @ResponseBody
    @Cacheable(value = "industry",keyGenerator = "baseKG")
    public MessageInfo<List<Industry>> industry() {
        return industryBiz.getAllIndustry();
    }


    @RequestMapping("listingType")
    @ResponseBody
    @Cacheable(value = "listingType",keyGenerator = "baseKG")
    public MessageInfo<List<ListingType>> listingType() {
        return listingTypeBiz.getListingType();
    }


    @RequestMapping("investRound")
    @ResponseBody
    @Cacheable(value = "investRound",keyGenerator = "baseKG")
    public MessageInfo<List<InvestRound>> investRound() {
        return investRoundBiz.getAllInvestRound();
    }


    @RequestMapping("mergeStatus")
    @ResponseBody
    @Cacheable(value = "mergeStatus",keyGenerator = "baseKG")
    public MessageInfo<List<MergeStatus>> mergeStatus() {
        return mergeStatusBiz.getAllMergeStatus();
    }


    @RequestMapping("mergeType")
    @ResponseBody
    @Cacheable(value = "mergeType",keyGenerator = "baseKG")
    public MessageInfo<List<MergeType>> mergeType() {
        return mergeTypeBiz.getAllMergeType();
    }


    @RequestMapping("orgType")
    @ResponseBody
    @Cacheable(value = "orgType",keyGenerator = "baseKG")
    public MessageInfo<List<OrgType>> orgType() {
        return orgTypeBiz.getAllOrgType();
    }


    @RequestMapping("quitType")
    @ResponseBody
    @Cacheable(value = "quitType",keyGenerator = "baseKG")
    public MessageInfo<List<QuitType>> quitType() {
        return quitTypeBiz.getAllQuitType();
    }


    /**
     * 企业项目综合查询
     * @return
     */
    @RequestMapping("comQuery")
    @ResponseBody
    @Cacheable(value = "proQuery",keyGenerator = "baseKG")
    public MessageInfo<Map> proQuery(){

        Map<String,Object> map = new HashMap<>();
        MessageInfo<List<Industry>> industriesMessageInfo = industryBiz.getAllIndustry();
        if (industriesMessageInfo != null){
            map.put("industriesMessageInfo",industriesMessageInfo);
        }

        MessageInfo<List<InvestRound>> investRoundsMessageInfo = investRoundBiz.getAllInvestRound();
        if (investRoundsMessageInfo!= null){
            map.put("investRoundsMessageInfo",investRoundsMessageInfo);
        }

        MessageInfo<List<District>> districtsMessageInfo = districtBiz.getAllDistrict();
        if (districtsMessageInfo != null){
            map.put("districtsMessageInfo",districtsMessageInfo);
        }

        MessageInfo<Map> messageInfo = new MessageInfo<>();
        messageInfo.setData(map);
        return messageInfo;
    }

    /**
     * 投资事件综合查询
     * @return
     */
    @RequestMapping("investEventQuery")
    @ResponseBody
    @Cacheable(value = "investEventQuery",keyGenerator = "baseKG")
    public MessageInfo<Map> investEventQuery(){

        Map<String,Object> map = new HashMap<>();
        MessageInfo<List<Industry>> industriesMessageInfo = industryBiz.getAllIndustry();
        if (industriesMessageInfo != null){
            map.put("industriesMessageInfo",industriesMessageInfo);
        }

        MessageInfo<List<InvestRound>> investRoundsMessageInfo = investRoundBiz.getAllInvestRound();
        if (investRoundsMessageInfo!= null){
            map.put("investRoundsMessageInfo",investRoundsMessageInfo);
        }

        MessageInfo<List<District>> districtsMessageInfo = districtBiz.getAllDistrict();
        if (districtsMessageInfo != null){
            map.put("districtsMessageInfo",districtsMessageInfo);
        }

        MessageInfo<List<CurrencyType>> currencyTypeMessageInfo = currencyTypeBiz.getAllCurrencyType();
        if (currencyTypeMessageInfo != null){
            map.put("currencyTypeMessageInfo",currencyTypeMessageInfo);
        }

        MessageInfo<Map> messageInfo = new MessageInfo<>();
        messageInfo.setData(map);
        return messageInfo;
    }

    /**
     * 并购事件综合查询
     * @return
     */
    @RequestMapping("mergeEventQuery")
    @ResponseBody
    @Cacheable(value = "mergeEventQuery",keyGenerator = "baseKG")
    public MessageInfo<Map> mergeEventQuery(){

        Map<String,Object> map = new HashMap<>();
        MessageInfo<List<Industry>> industriesMessageInfo = industryBiz.getAllIndustry();
        if (industriesMessageInfo != null){
            map.put("industriesMessageInfo",industriesMessageInfo);
        }

        MessageInfo<List<MergeType>> mergeTypeMessageInfo = mergeTypeBiz.getAllMergeType();
        if (mergeTypeMessageInfo != null){
            map.put("mergeTypeMessageInfo",mergeTypeMessageInfo);
        }


        MessageInfo<List<MergeStatus>> mergeStatusMessageInfo = mergeStatusBiz.getAllMergeStatus();
        if (mergeTypeMessageInfo != null){
            map.put("mergeStatusMessageInfo",mergeStatusMessageInfo);
        }

        //股权比例暂缺

        MessageInfo<List<CurrencyType>> currencyTypeMessageInfo = currencyTypeBiz.getAllCurrencyType();
        if (currencyTypeMessageInfo != null){
            map.put("currencyTypeMessageInfo",currencyTypeMessageInfo);
        }

        MessageInfo<Map> messageInfo = new MessageInfo<>();
        messageInfo.setData(map);
        return messageInfo;
    }

    /**
     * 上市挂牌综合查询
     * @return
     */
    @RequestMapping("listingQuery")
    @ResponseBody
    @Cacheable(value = "listingQuery",keyGenerator = "baseKG")
    public MessageInfo<Map> listingQuery(){

        Map<String,Object> map = new HashMap<>();
        MessageInfo<List<Industry>> industriesMessageInfo = industryBiz.getAllIndustry();
        if (industriesMessageInfo != null){
            map.put("industriesMessageInfo",industriesMessageInfo);
        }

        MessageInfo<List<ListingType>> listingTypeMessageInfo = listingTypeBiz.getAllListingType();
        if (listingTypeMessageInfo!= null){
            map.put("listingTypeMessageInfo",listingTypeMessageInfo);
        }

        MessageInfo<Map> messageInfo = new MessageInfo<>();
        messageInfo.setData(map);
        return messageInfo;
    }

    /**
     * 退出事件综合查询
     * @return
     */
    @RequestMapping("quitEventQuery")
    @ResponseBody
    @Cacheable(value = "quitEventQuery",keyGenerator = "baseKG")
    public MessageInfo<Map> quitEventQuery(){

        Map<String,Object> map = new HashMap<>();
        MessageInfo<List<Industry>> industriesMessageInfo = industryBiz.getAllIndustry();
        if (industriesMessageInfo != null){
            map.put("industriesMessageInfo",industriesMessageInfo);
        }

        MessageInfo<List<QuitType>> quitTypeMessageInfo = quitTypeBiz.getAllQuitType();
        if (quitTypeMessageInfo!= null){
            map.put("quitTypeMessageInfo",quitTypeMessageInfo);
        }

        MessageInfo<List<District>> districtsMessageInfo = districtBiz.getAllDistrict();
        if (districtsMessageInfo != null){
            map.put("districtsMessageInfo",districtsMessageInfo);
        }

        MessageInfo<List<CurrencyType>> currencyTypeMessageInfo = currencyTypeBiz.getAllCurrencyType();
        if (currencyTypeMessageInfo != null){
            map.put("currencyTypeMessageInfo",currencyTypeMessageInfo);
        }

        MessageInfo<Map> messageInfo = new MessageInfo<>();
        messageInfo.setData(map);
        return messageInfo;
    }

    /**
     * 投资机构综合查询
     * @return
     */
    @RequestMapping("orgQuery")
    @ResponseBody
    @Cacheable(value = "orgQuery",keyGenerator = "baseKG")
    public MessageInfo<Map> orgQuery(){

        Map<String,Object> map = new HashMap<>();
        MessageInfo<List<Industry>> industriesMessageInfo = industryBiz.getAllIndustry();
        if (industriesMessageInfo != null){
            map.put("industriesMessageInfo",industriesMessageInfo);
        }

        MessageInfo<List<InvestRound>> investRoundMessageInfo = investRoundBiz.getAllInvestRound();
        if (investRoundMessageInfo!= null){
            map.put("investRoundMessageInfo",investRoundMessageInfo);
        }

        MessageInfo<List<District>> districtsMessageInfo = districtBiz.getAllDistrict();
        if (districtsMessageInfo != null){
            map.put("districtsMessageInfo",districtsMessageInfo);
        }

        MessageInfo<List<CurrencyType>> currencyTypeMessageInfo = currencyTypeBiz.getAllCurrencyType();
        if (currencyTypeMessageInfo != null){
            map.put("currencyTypeMessageInfo",currencyTypeMessageInfo);
        }

        MessageInfo<Map> messageInfo = new MessageInfo<>();
        messageInfo.setData(map);
        return messageInfo;
    }

}
