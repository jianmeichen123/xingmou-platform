package com.gi.ctdn.api.rest;

import com.gi.ctdn.biz.*;
import com.gi.ctdn.pojo.*;
import com.gi.xm.platform.view.common.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

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

    @Autowired
    private EquityRateBiz equityRateBiz;


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
    public MessageInfo<Map> district() {
        MessageInfo<Map> messageInfo = new MessageInfo<>();
        Map<String,Object> map = new HashMap<>();
        MessageInfo<List<District>> districtMessageInfo = districtBiz.getAllDistrict();
        List<District> districts = districtMessageInfo.getData();
        List<District> districtFatherInfo = new ArrayList<>();
        List<District> districtSonInfo = new ArrayList<>();
        for (District district: districts) {
            if (district.getParentId().intValue()==0){
                districtFatherInfo.add(district);
            }else {
                districtSonInfo.add(district);
            }
        }
        map.put("districtSonInfo",districtSonInfo);
        map.put("districtFatherInfo",districtFatherInfo);
        messageInfo.setData(map);
        return messageInfo;
    }


    @RequestMapping("industry")
    @ResponseBody
    @Cacheable(value = "industry",keyGenerator = "baseKG")
    public MessageInfo<List<Industry>> industry() {
        MessageInfo<List<Industry>> industryMessageInfo = industryBiz.getAllIndustry();
        List<Industry> industryList = industryMessageInfo.getData();
        List<Industry> fatherIndustryList = new ArrayList<>();
        for (Industry fatherIndustry : industryList) {
            if (fatherIndustry.getParentId().intValue() !=0 ) {
                List<Industry> sonIndustryList = new ArrayList<>();
                for (Industry sonIndustry : industryList) {
                    if (sonIndustry.getParentId().intValue() == fatherIndustry.getIndustryId().intValue()) {
                        sonIndustryList.add(sonIndustry);
                    }
                }
                fatherIndustry.setIndustrylist(sonIndustryList);
            }else{
                fatherIndustryList.add(fatherIndustry);
            }
        }
        industryMessageInfo.setData(fatherIndustryList);
        return industryMessageInfo;
    }


    @RequestMapping("listingType")
    @ResponseBody
    @Cacheable(value = "listingType",keyGenerator = "baseKG")
    public MessageInfo<Map> listingType() {
        MessageInfo<Map> messageInfo = new MessageInfo<>();
        Map<String,Object> map = new HashMap<>();
        MessageInfo<List<ListingType>> listingTypeMessageInfo = listingTypeBiz.getAllListingType();
        List<ListingType> listingTypeList = listingTypeMessageInfo.getData();
        List<ListingType> fatherListingTypeInfo = new ArrayList<>();
        List<ListingType> sonListingTypeInfo = new ArrayList<>();
        for (ListingType listingType : listingTypeList) {
            if (listingType.getParentId().intValue() != 0){
                sonListingTypeInfo.add(listingType);
            }else {
                fatherListingTypeInfo.add(listingType);
            }
        }
        map.put("fatherListingTypeInfo",fatherListingTypeInfo);
        map.put("sonListingTypeInfo",sonListingTypeInfo);
        messageInfo.setData(map);
        return messageInfo;
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


    @RequestMapping("equityRate")
    @ResponseBody
    @Cacheable(value = "equityRate",keyGenerator = "baseKG")
    public MessageInfo<List<EquityRate>> equityRate() {
        return equityRateBiz.getAllEquityRate();
    }

    /**
     * 企业项目综合查询
     * @return
     */
    @RequestMapping("comQuery")
    @ResponseBody
    @Cacheable(value = "proQuery",keyGenerator = "baseKG")
    public MessageInfo<Map> proQuery(){
        MessageInfo<Map> messageInfo = new MessageInfo<>();
        Map<String,Object> map = new HashMap<>();
        MessageInfo<List<Industry>> industriesMessageInfo = industry();
        map.put("industriesMessageInfo",industriesMessageInfo.getData());
        messageInfo.setMessage(industriesMessageInfo.getMessage());
        messageInfo.setStatus(industriesMessageInfo.getStatus());

        MessageInfo<List<InvestRound>> investRoundMessageInfo = investRoundBiz.getAllInvestRound();
        map.put("investRoundMessageInfo",investRoundMessageInfo.getData());
        messageInfo.setMessage(industriesMessageInfo.getMessage());
        messageInfo.setStatus(industriesMessageInfo.getStatus());

        MessageInfo<Map> districtsMessageInfo = district();
        map.put("districtsMessageInfo",districtsMessageInfo.getData());
        messageInfo.setMessage(districtsMessageInfo.getMessage());
        messageInfo.setStatus(districtsMessageInfo.getStatus());

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
        MessageInfo<Map> messageInfo = new MessageInfo<>();
        Map<String,Object> map = new HashMap<>();
        MessageInfo<List<Industry>> industriesMessageInfo = industry();
        map.put("industriesMessageInfo",industriesMessageInfo.getData());
        messageInfo.setMessage(industriesMessageInfo.getMessage());
        messageInfo.setStatus(industriesMessageInfo.getStatus());

        MessageInfo<List<InvestRound>> investRoundMessageInfo = investRoundBiz.getAllInvestRound();
        map.put("investRoundMessageInfo",investRoundMessageInfo.getData());
        messageInfo.setMessage(industriesMessageInfo.getMessage());
        messageInfo.setStatus(industriesMessageInfo.getStatus());

        MessageInfo<Map> districtsMessageInfo = district();
        map.put("districtsMessageInfo",districtsMessageInfo.getData());
        messageInfo.setMessage(districtsMessageInfo.getMessage());
        messageInfo.setStatus(districtsMessageInfo.getStatus());

        MessageInfo<List<CurrencyType>> currencyTypeMessageInfo = currencyTypeBiz.getAllCurrencyType();
        map.put("currencyTypeMessageInfo",currencyTypeMessageInfo.getData());
        currencyTypeMessageInfo.setMessage(currencyTypeMessageInfo.getMessage());

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
        MessageInfo<Map> messageInfo = new MessageInfo<>();
        Map<String,Object> map = new HashMap<>();
        MessageInfo<List<Industry>> industriesMessageInfo = industry();
        map.put("industriesMessageInfo",industriesMessageInfo.getData());
        messageInfo.setMessage(industriesMessageInfo.getMessage());
        messageInfo.setStatus(industriesMessageInfo.getStatus());

        MessageInfo<List<MergeType>> mergeTypeMessageInfo = mergeTypeBiz.getAllMergeType();
        map.put("mergeTypeMessageInfo",mergeTypeMessageInfo.getData());
        mergeTypeMessageInfo.setMessage(mergeTypeMessageInfo.getMessage());
        mergeTypeMessageInfo.setStatus(mergeTypeMessageInfo.getStatus());


        MessageInfo<List<MergeStatus>> mergeStatusMessageInfo = mergeStatusBiz.getAllMergeStatus();
        map.put("mergeStatusMessageInfo",mergeStatusMessageInfo.getData());
        mergeStatusMessageInfo.setMessage(mergeStatusMessageInfo.getMessage());
        mergeStatusMessageInfo.setStatus(mergeStatusMessageInfo.getStatus());

        MessageInfo<List<EquityRate>> equityRateMessageInfo = equityRateBiz.getAllEquityRate();
        map.put("equityRateMessageInfo",equityRateMessageInfo.getData());
        equityRateMessageInfo.setMessage(equityRateMessageInfo.getMessage());
        equityRateMessageInfo.setStatus(equityRateMessageInfo.getStatus());

        MessageInfo<List<CurrencyType>> currencyTypeMessageInfo = currencyTypeBiz.getAllCurrencyType();
        map.put("currencyTypeMessageInfo",currencyTypeMessageInfo.getData());
        currencyTypeMessageInfo.setMessage(currencyTypeMessageInfo.getMessage());
        currencyTypeMessageInfo.setStatus(currencyTypeMessageInfo.getStatus());


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
        MessageInfo<Map> messageInfo = new MessageInfo<>();
        Map<String,Object> map = new HashMap<>();
        MessageInfo<List<Industry>> industriesMessageInfo = industry();
        map.put("industriesMessageInfo",industriesMessageInfo.getData());
        messageInfo.setMessage(industriesMessageInfo.getMessage());
        messageInfo.setStatus(industriesMessageInfo.getStatus());

        MessageInfo<Map> listingTypeMessageInfo = listingType();
        map.put("listingTypeMessageInfo",listingTypeMessageInfo.getData());
        listingTypeMessageInfo.setMessage(listingTypeMessageInfo.getMessage());
        listingTypeMessageInfo.setStatus(listingTypeMessageInfo.getStatus());

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
        MessageInfo<Map> messageInfo = new MessageInfo<>();
        Map<String,Object> map = new HashMap<>();
        MessageInfo<List<Industry>> industriesMessageInfo = industry();
        map.put("industriesMessageInfo",industriesMessageInfo.getData());
        messageInfo.setMessage(industriesMessageInfo.getMessage());
        messageInfo.setStatus(industriesMessageInfo.getStatus());

        MessageInfo<List<QuitType>> quitTypeMessageInfo = quitTypeBiz.getAllQuitType();
        map.put("quitTypeMessageInfo",quitTypeMessageInfo.getData());
        quitTypeMessageInfo.setMessage(quitTypeMessageInfo.getMessage());
        quitTypeMessageInfo.setStatus(quitTypeMessageInfo.getStatus());

        MessageInfo<Map> districtsMessageInfo = district();
        map.put("districtsMessageInfo",districtsMessageInfo.getData());
        messageInfo.setMessage(districtsMessageInfo.getMessage());
        messageInfo.setStatus(districtsMessageInfo.getStatus());

        MessageInfo<List<CurrencyType>> currencyTypeMessageInfo = currencyTypeBiz.getAllCurrencyType();
        map.put("currencyTypeMessageInfo",currencyTypeMessageInfo.getData());
        currencyTypeMessageInfo.setMessage(currencyTypeMessageInfo.getMessage());
        currencyTypeMessageInfo.setStatus(currencyTypeMessageInfo.getStatus());


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
        MessageInfo<Map> messageInfo = new MessageInfo<>();
        Map<String,Object> map = new HashMap<>();
        MessageInfo<List<Industry>> industriesMessageInfo = industry();
        map.put("industriesMessageInfo",industriesMessageInfo.getData());
        messageInfo.setMessage(industriesMessageInfo.getMessage());
        messageInfo.setStatus(industriesMessageInfo.getStatus());

        MessageInfo<List<InvestRound>> investRoundMessageInfo = investRoundBiz.getAllInvestRound();
        map.put("investRoundMessageInfo",investRoundMessageInfo.getData());
        messageInfo.setMessage(industriesMessageInfo.getMessage());
        messageInfo.setStatus(industriesMessageInfo.getStatus());

        MessageInfo<Map> districtsMessageInfo = district();
        map.put("districtsMessageInfo",districtsMessageInfo.getData());
        messageInfo.setMessage(districtsMessageInfo.getMessage());
        messageInfo.setStatus(districtsMessageInfo.getStatus());

        MessageInfo<List<CurrencyType>> currencyTypeMessageInfo = currencyTypeBiz.getAllCurrencyType();
        map.put("currencyTypeMessageInfo",currencyTypeMessageInfo.getData());
        messageInfo.setMessage(currencyTypeMessageInfo.getMessage());
        messageInfo.setStatus(currencyTypeMessageInfo.getStatus());
        messageInfo.setData(map);
        return messageInfo;
    }

}
