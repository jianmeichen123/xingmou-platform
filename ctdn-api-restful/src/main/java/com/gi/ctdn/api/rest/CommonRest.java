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


    /**
     *资本类型查询
     * @return messageInfo
     */
    @RequestMapping("capitalType")
    @ResponseBody
    @Cacheable(value = "capitalType",keyGenerator = "baseKG")
    public MessageInfo<List<CapitalType>> capitalType(){
        MessageInfo<List<CapitalType>> messageInfo = capitalTypeBiz.getAllCapitalType();
        messageInfo.setMessage(messageInfo.getMessage());
        messageInfo.setStatus(messageInfo.getStatus());
        return messageInfo;
    }


    /**
     *货币类型查询
     * @return messageInfo
     */
    @RequestMapping("currencyType")
    @ResponseBody
    @Cacheable(value = "currencyType",keyGenerator = "baseKG")
    public MessageInfo<List<CurrencyType>> currencyType() {
        MessageInfo<List<CurrencyType>> messageInfo = currencyTypeBiz.getAllCurrencyType();
        messageInfo.setMessage(messageInfo.getMessage());
        messageInfo.setStatus(messageInfo.getStatus());
        return messageInfo;
    }


    /**
     *地区查询
     * @return messageInfo
     */
    @RequestMapping("district")
    @ResponseBody
    @Cacheable(value = "district",keyGenerator = "baseKG")
    public MessageInfo<List<District>> district() {
        MessageInfo<List<District>> districtMessageInfo = districtBiz.getAllDistrict();
        List<District> districts = districtMessageInfo.getData();
        List<District> fatherDistrictList = new ArrayList<>();
        for (District fatherDistrict: districts) {
            List<District> sonDistrictList = new ArrayList<>();
            for (District sonDistrict : districts) {
                if (sonDistrict.getParentId().intValue() == fatherDistrict.getId().intValue()){
                    sonDistrictList.add(sonDistrict);
                }
            }
            fatherDistrict.setChildren(sonDistrictList);
            if (fatherDistrict.getParentId() == 0){
                fatherDistrictList.add(fatherDistrict);
            }
        }
        districtMessageInfo.setData(fatherDistrictList);
        districtMessageInfo.setMessage(districtMessageInfo.getMessage());
        districtMessageInfo.setStatus(districtMessageInfo.getStatus());
        return districtMessageInfo;
    }


    /**
     *行业查询
     * @return messageInfo
     */
    @RequestMapping("industry")
    @ResponseBody
    @Cacheable(value = "industry",keyGenerator = "baseKG")
    public MessageInfo<List<Industry>> industry() {
        MessageInfo<List<Industry>> industryMessageInfo = industryBiz.getAllIndustry();
        List<Industry> industryList = industryMessageInfo.getData();
        List<Industry> fatherIndustryList = new ArrayList<>();
        for (Industry fatherIndustry : industryList) {
            List<Industry> sonIndustryList = new ArrayList<>();
            for (Industry sonIndustry : industryList) {
                if (sonIndustry.getParentId().intValue() == fatherIndustry.getId().intValue()) {
                    sonIndustryList.add(sonIndustry);
                }
            }
            fatherIndustry.setChildren(sonIndustryList);
            if (fatherIndustry.getParentId() == 0){
                fatherIndustryList.add(fatherIndustry);
            }
        }
        industryMessageInfo.setData(fatherIndustryList);
        industryMessageInfo.setMessage(industryMessageInfo.getMessage());
        industryMessageInfo.setStatus(industryMessageInfo.getStatus());
        return industryMessageInfo;
    }


    /**
     *上市类型查询
     * @return messageInfo
     */
    @RequestMapping("listingType")
    @ResponseBody
    @Cacheable(value = "listingType",keyGenerator = "baseKG")
    public MessageInfo<List<ListingType>> listingType() {
        MessageInfo<List<ListingType>> listingTypeMessageInfo = listingTypeBiz.getAllListingType();
        List<ListingType> listingTypeList = listingTypeMessageInfo.getData();
        List<ListingType> fatherListingTypeList = new ArrayList<>();
        for (ListingType fatherListingType : listingTypeList) {
            List<ListingType> sonListingTypeList = new ArrayList<>();
            for (ListingType sonListingType : listingTypeList) {
                if (sonListingType.getParentId().intValue() == fatherListingType.getId().intValue()){
                     sonListingTypeList.add(sonListingType);
                }
            }
            fatherListingType.setChildren(sonListingTypeList);
            if (fatherListingType.getParentId() ==0 ){
                fatherListingTypeList.add(fatherListingType);
            }
        }
        listingTypeMessageInfo.setData(fatherListingTypeList);
        listingTypeMessageInfo.setMessage(listingTypeMessageInfo.getMessage());
        listingTypeMessageInfo.setStatus(listingTypeMessageInfo.getStatus());
        return listingTypeMessageInfo;
    }


    /**
     *投资轮次查询
     * @return messageInfo
     */
    @RequestMapping("investRound")
    @ResponseBody
    @Cacheable(value = "investRound",keyGenerator = "baseKG")
    public MessageInfo<List<InvestRound>> investRound() {
        MessageInfo<List<InvestRound>> messageInfo = investRoundBiz.getAllInvestRound();
        messageInfo.setMessage(messageInfo.getMessage());
        messageInfo.setStatus(messageInfo.getStatus());
        return messageInfo;
    }


    /**
     *合并状态查询
     * @return messageInfo
     */
    @RequestMapping("mergeStatus")
    @ResponseBody
    @Cacheable(value = "mergeStatus",keyGenerator = "baseKG")
    public MessageInfo<List<MergeStatus>> mergeStatus() {
        MessageInfo<List<MergeStatus>> messageInfo = mergeStatusBiz.getAllMergeStatus();
        messageInfo.setMessage(messageInfo.getMessage());
        messageInfo.setStatus(messageInfo.getStatus());
        return messageInfo;
    }


    /**
     *合并类型查询
     * @return messageInfo
     */
    @RequestMapping("mergeType")
    @ResponseBody
    @Cacheable(value = "mergeType",keyGenerator = "baseKG")
    public MessageInfo<List<MergeType>> mergeType() {
        MessageInfo<List<MergeType>> messageInfo = mergeTypeBiz.getAllMergeType();
        messageInfo.setMessage(messageInfo.getMessage());
        messageInfo.setStatus(messageInfo.getStatus());
        return messageInfo;
    }


    /**
     *机构类型查询
     * @return messageInfo
     */
    @RequestMapping("orgType")
    @ResponseBody
    @Cacheable(value = "orgType",keyGenerator = "baseKG")
    public MessageInfo<List<OrgType>> orgType() {
        MessageInfo<List<OrgType>> messageInfo = orgTypeBiz.getAllOrgType();
        messageInfo.setMessage(messageInfo.getMessage());
        messageInfo.setStatus(messageInfo.getStatus());
        return messageInfo;
    }


    /**
     *退出类型查询
     * @return messageInfo
     */
    @RequestMapping("quitType")
    @ResponseBody
    @Cacheable(value = "quitType",keyGenerator = "baseKG")
    public MessageInfo<List<QuitType>> quitType() {
        MessageInfo<List<QuitType>> messageInfo = quitTypeBiz.getAllQuitType();
        messageInfo.setMessage(messageInfo.getMessage());
        messageInfo.setStatus(messageInfo.getStatus());
        return messageInfo;
    }


    /**
     *股权比例查询
     * @return messageInfo
     */
    @RequestMapping("equityRate")
    @ResponseBody
    @Cacheable(value = "equityRate",keyGenerator = "baseKG")
    public MessageInfo<List<EquityRate>> equityRate() {
        MessageInfo<List<EquityRate>> messageInfo = equityRateBiz.getAllEquityRate();
        messageInfo.setMessage(messageInfo.getMessage());
        messageInfo.setStatus(messageInfo.getStatus());
        return messageInfo;
    }

    /**
     * 企业项目综合查询
     * @return messageInfo
     */
    @RequestMapping("comQuery")
    @ResponseBody
    @Cacheable(value = "proQuery",keyGenerator = "baseKG")
    public MessageInfo<Map> proQuery(){
        MessageInfo<Map> messageInfo = new MessageInfo<>();
        Map<String,Object> map = new HashMap<>();
        MessageInfo<List<Industry>> industriesMessageInfo = industry();
        map.put("industry",industriesMessageInfo.getData());
        messageInfo.setMessage(industriesMessageInfo.getMessage());
        messageInfo.setStatus(industriesMessageInfo.getStatus());

        MessageInfo<List<InvestRound>> investRoundMessageInfo = investRoundBiz.getAllInvestRound();
        map.put("roundList",investRoundMessageInfo.getData());
        messageInfo.setMessage(industriesMessageInfo.getMessage());
        messageInfo.setStatus(industriesMessageInfo.getStatus());

        MessageInfo<List<District>> districtsMessageInfo = district();
        map.put("district",districtsMessageInfo.getData());
        messageInfo.setMessage(districtsMessageInfo.getMessage());
        messageInfo.setStatus(districtsMessageInfo.getStatus());

        MessageInfo<List<CurrencyType>> currencyTypeMessageInfo = currencyType();
        map.put("currencyType",currencyTypeMessageInfo.getData());
        messageInfo.setMessage(currencyTypeMessageInfo.getMessage());
        messageInfo.setStatus(currencyTypeMessageInfo.getStatus());


        messageInfo.setData(map);
        return messageInfo;
    }

    /**
     * 投资事件综合查询
     * @return messageInfo
     */
    @RequestMapping("investEventQuery")
    @ResponseBody
    @Cacheable(value = "investEventQuery",keyGenerator = "baseKG")
    public MessageInfo<Map> investEventQuery(){
        MessageInfo<Map> messageInfo = new MessageInfo<>();
        Map<String,Object> map = new HashMap<>();
        MessageInfo<List<Industry>> industriesMessageInfo = industry();
        map.put("industry",industriesMessageInfo.getData());
        messageInfo.setMessage(industriesMessageInfo.getMessage());
        messageInfo.setStatus(industriesMessageInfo.getStatus());

        MessageInfo<List<InvestRound>> investRoundMessageInfo = investRoundBiz.getAllInvestRound();
        map.put("roundList",investRoundMessageInfo.getData());
        messageInfo.setMessage(industriesMessageInfo.getMessage());
        messageInfo.setStatus(industriesMessageInfo.getStatus());

        MessageInfo<List<District>> districtsMessageInfo = district();
        map.put("district",districtsMessageInfo.getData());
        messageInfo.setMessage(districtsMessageInfo.getMessage());
        messageInfo.setStatus(districtsMessageInfo.getStatus());

        MessageInfo<List<CurrencyType>> currencyTypeMessageInfo = currencyTypeBiz.getAllCurrencyType();
        map.put("currencyType",currencyTypeMessageInfo.getData());
        currencyTypeMessageInfo.setMessage(currencyTypeMessageInfo.getMessage());

        messageInfo.setData(map);
        return messageInfo;
    }

    /**
     * 并购事件综合查询
     * @return messageInfo
     */
    @RequestMapping("mergeEventQuery")
    @ResponseBody
    @Cacheable(value = "mergeEventQuery",keyGenerator = "baseKG")
    public MessageInfo<Map> mergeEventQuery(){
        MessageInfo<Map> messageInfo = new MessageInfo<>();
        Map<String,Object> map = new HashMap<>();
        MessageInfo<List<Industry>> industriesMessageInfo = industry();
        map.put("industry",industriesMessageInfo.getData());
        messageInfo.setMessage(industriesMessageInfo.getMessage());
        messageInfo.setStatus(industriesMessageInfo.getStatus());

        MessageInfo<List<MergeType>> mergeTypeMessageInfo = mergeTypeBiz.getAllMergeType();
        map.put("mergeType",mergeTypeMessageInfo.getData());
        mergeTypeMessageInfo.setMessage(mergeTypeMessageInfo.getMessage());
        mergeTypeMessageInfo.setStatus(mergeTypeMessageInfo.getStatus());


        MessageInfo<List<MergeStatus>> mergeStatusMessageInfo = mergeStatusBiz.getAllMergeStatus();
        map.put("mergeStatus",mergeStatusMessageInfo.getData());
        mergeStatusMessageInfo.setMessage(mergeStatusMessageInfo.getMessage());
        mergeStatusMessageInfo.setStatus(mergeStatusMessageInfo.getStatus());

        MessageInfo<List<EquityRate>> equityRateMessageInfo = equityRateBiz.getAllEquityRate();
        map.put("equityRate",equityRateMessageInfo.getData());
        equityRateMessageInfo.setMessage(equityRateMessageInfo.getMessage());
        equityRateMessageInfo.setStatus(equityRateMessageInfo.getStatus());

        MessageInfo<List<CurrencyType>> currencyTypeMessageInfo = currencyTypeBiz.getAllCurrencyType();
        map.put("currencyType",currencyTypeMessageInfo.getData());
        currencyTypeMessageInfo.setMessage(currencyTypeMessageInfo.getMessage());
        currencyTypeMessageInfo.setStatus(currencyTypeMessageInfo.getStatus());


        messageInfo.setData(map);
        return messageInfo;
    }

    /**
     * 上市挂牌综合查询
     * @return messageInfo
     */
    @RequestMapping("listingQuery")
    @ResponseBody
    @Cacheable(value = "listingQuery",keyGenerator = "baseKG")
    public MessageInfo<Map> listingQuery(){
        MessageInfo<Map> messageInfo = new MessageInfo<>();
        Map<String,Object> map = new HashMap<>();
        MessageInfo<List<Industry>> industriesMessageInfo = industry();
        map.put("industry",industriesMessageInfo.getData());
        messageInfo.setMessage(industriesMessageInfo.getMessage());
        messageInfo.setStatus(industriesMessageInfo.getStatus());

        MessageInfo<List<ListingType>> listingTypeMessageInfo = listingType();
        map.put("listingType",listingTypeMessageInfo.getData());
        listingTypeMessageInfo.setMessage(listingTypeMessageInfo.getMessage());
        listingTypeMessageInfo.setStatus(listingTypeMessageInfo.getStatus());

        messageInfo.setData(map);
        return messageInfo;
    }

    /**
     * 退出事件综合查询
     * @return messageInfo
     */
    @RequestMapping("quitEventQuery")
    @ResponseBody
    @Cacheable(value = "quitEventQuery",keyGenerator = "baseKG")
    public MessageInfo<Map> quitEventQuery(){
        MessageInfo<Map> messageInfo = new MessageInfo<>();
        Map<String,Object> map = new HashMap<>();
        MessageInfo<List<Industry>> industriesMessageInfo = industry();
        map.put("industry",industriesMessageInfo.getData());
        messageInfo.setMessage(industriesMessageInfo.getMessage());
        messageInfo.setStatus(industriesMessageInfo.getStatus());

        MessageInfo<List<QuitType>> quitTypeMessageInfo = quitTypeBiz.getAllQuitType();
        map.put("quitType",quitTypeMessageInfo.getData());
        quitTypeMessageInfo.setMessage(quitTypeMessageInfo.getMessage());
        quitTypeMessageInfo.setStatus(quitTypeMessageInfo.getStatus());

        MessageInfo<List<District>> districtsMessageInfo = district();
        map.put("district",districtsMessageInfo.getData());
        messageInfo.setMessage(districtsMessageInfo.getMessage());
        messageInfo.setStatus(districtsMessageInfo.getStatus());

        MessageInfo<List<CurrencyType>> currencyTypeMessageInfo = currencyTypeBiz.getAllCurrencyType();
        map.put("currencyType",currencyTypeMessageInfo.getData());
        currencyTypeMessageInfo.setMessage(currencyTypeMessageInfo.getMessage());
        currencyTypeMessageInfo.setStatus(currencyTypeMessageInfo.getStatus());


        messageInfo.setData(map);
        return messageInfo;
    }

    /**
     * 投资机构综合查询
     * @return messageInfo
     */
    @RequestMapping("orgQuery")
    @ResponseBody
    @Cacheable(value = "orgQuery",keyGenerator = "baseKG")
    public MessageInfo<Map> orgQuery(){
        MessageInfo<Map> messageInfo = new MessageInfo<>();
        Map<String,Object> map = new HashMap<>();
        MessageInfo<List<Industry>> industriesMessageInfo = industry();
        map.put("industry",industriesMessageInfo.getData());
        messageInfo.setMessage(industriesMessageInfo.getMessage());
        messageInfo.setStatus(industriesMessageInfo.getStatus());

        MessageInfo<List<InvestRound>> investRoundMessageInfo = investRound();
        map.put("roundList",investRoundMessageInfo.getData());
        messageInfo.setMessage(industriesMessageInfo.getMessage());
        messageInfo.setStatus(industriesMessageInfo.getStatus());

        MessageInfo<List<District>> districtsMessageInfo = district();
        map.put("district",districtsMessageInfo.getData());
        messageInfo.setMessage(districtsMessageInfo.getMessage());
        messageInfo.setStatus(districtsMessageInfo.getStatus());

        MessageInfo<List<OrgType>> orgTypeTypeMessageInfo = orgType();
        map.put("orgType",orgTypeTypeMessageInfo.getData());
        messageInfo.setMessage(orgTypeTypeMessageInfo.getMessage());
        messageInfo.setStatus(orgTypeTypeMessageInfo.getStatus());

        MessageInfo<List<CurrencyType>> currencyTypeMessageInfo = currencyType();
        map.put("currencyType",currencyTypeMessageInfo.getData());
        messageInfo.setMessage(currencyTypeMessageInfo.getMessage());
        messageInfo.setStatus(currencyTypeMessageInfo.getStatus());


        MessageInfo<List<CapitalType>> capitalTypeMessageInfo = capitalType();
        map.put("capitalType",capitalTypeMessageInfo.getData());
        messageInfo.setMessage(capitalTypeMessageInfo.getMessage());
        messageInfo.setStatus(capitalTypeMessageInfo.getStatus());

        messageInfo.setData(map);
        return messageInfo;
    }



    /**
     *所有综合查询
     * @return messageInfo
     */
    @RequestMapping("allQuery")
    @ResponseBody
    @Cacheable(value = "allQuery",keyGenerator = "baseKG")
    public MessageInfo<Map> allQuery(){
        //企业
        MessageInfo<Map> messageInfo = new MessageInfo<>();
        Map<String,Object> map = new HashMap<>();
        MessageInfo<List<Industry>> industriesMessageInfo = industry();
        map.put("industry",industriesMessageInfo.getData());
        messageInfo.setMessage(industriesMessageInfo.getMessage());
        messageInfo.setStatus(industriesMessageInfo.getStatus());

        MessageInfo<List<InvestRound>> investRoundMessageInfo = investRound();
        map.put("roundList",investRoundMessageInfo.getData());
        messageInfo.setMessage(industriesMessageInfo.getMessage());
        messageInfo.setStatus(industriesMessageInfo.getStatus());

        MessageInfo<List<District>> districtsMessageInfo = district();
        map.put("district",districtsMessageInfo.getData());
        messageInfo.setMessage(districtsMessageInfo.getMessage());
        messageInfo.setStatus(districtsMessageInfo.getStatus());

        MessageInfo<List<CurrencyType>> currencyTypeMessageInfo = currencyType();
        map.put("currencyType",currencyTypeMessageInfo.getData());
        messageInfo.setMessage(currencyTypeMessageInfo.getMessage());
        messageInfo.setStatus(currencyTypeMessageInfo.getStatus());
        //融资

        //并购

        MessageInfo<List<MergeType>> mergeTypeMessageInfo = mergeType();
        map.put("mergeType",mergeTypeMessageInfo.getData());
        mergeTypeMessageInfo.setMessage(mergeTypeMessageInfo.getMessage());
        mergeTypeMessageInfo.setStatus(mergeTypeMessageInfo.getStatus());


        MessageInfo<List<MergeStatus>> mergeStatusMessageInfo = mergeStatus();
        map.put("mergeStatus",mergeStatusMessageInfo.getData());
        mergeStatusMessageInfo.setMessage(mergeStatusMessageInfo.getMessage());
        mergeStatusMessageInfo.setStatus(mergeStatusMessageInfo.getStatus());

        MessageInfo<List<EquityRate>> equityRateMessageInfo = equityRate();
        map.put("equityRate",equityRateMessageInfo.getData());
        equityRateMessageInfo.setMessage(equityRateMessageInfo.getMessage());
        equityRateMessageInfo.setStatus(equityRateMessageInfo.getStatus());


        //上市挂牌

        MessageInfo<List<ListingType>> listingTypeMessageInfo = listingType();
        map.put("listingType",listingTypeMessageInfo.getData());
        listingTypeMessageInfo.setMessage(listingTypeMessageInfo.getMessage());
        listingTypeMessageInfo.setStatus(listingTypeMessageInfo.getStatus());

        //退出
        map.put("industry",industriesMessageInfo.getData());
        messageInfo.setMessage(industriesMessageInfo.getMessage());
        messageInfo.setStatus(industriesMessageInfo.getStatus());

        MessageInfo<List<QuitType>> quitTypeMessageInfo = quitType();
        map.put("quitType",quitTypeMessageInfo.getData());
        quitTypeMessageInfo.setMessage(quitTypeMessageInfo.getMessage());
        quitTypeMessageInfo.setStatus(quitTypeMessageInfo.getStatus());

        //投资机构

        MessageInfo<List<OrgType>> orgTypeTypeMessageInfo = orgType();
        map.put("orgType",orgTypeTypeMessageInfo.getData());
        messageInfo.setMessage(orgTypeTypeMessageInfo.getMessage());
        messageInfo.setStatus(orgTypeTypeMessageInfo.getStatus());


        MessageInfo<List<CapitalType>> capitalTypeMessageInfo = capitalType();
        map.put("capitalType",capitalTypeMessageInfo.getData());
        messageInfo.setMessage(capitalTypeMessageInfo.getMessage());
        messageInfo.setStatus(capitalTypeMessageInfo.getStatus());

        messageInfo.setData(map);
        return messageInfo;
    }

}
