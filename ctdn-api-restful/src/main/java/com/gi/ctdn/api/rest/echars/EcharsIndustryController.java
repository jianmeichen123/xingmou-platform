package com.gi.ctdn.api.rest.echars;

import com.gi.ctdn.api.rest.IndexController;
import com.gi.ctdn.biz.EchartsBiz;
import com.gi.ctdn.pojo.EchartsData;
import com.gi.ctdn.pojo.IndustryEcharsQuery;
import com.gi.ctdn.pojo.IndustryMonth;
import com.gi.ctdn.pojo.IndustryRoundMerger;
import com.gi.ctdn.pojo.echars.IndustryGroupDistrictRZBK;
import com.gi.ctdn.view.common.MessageInfo;
import com.gi.ctdn.view.common.MessageStatus;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zcy on 18-1-13.
 */
@Controller
@RequestMapping("echarsIndustryAnalyze")
public class EcharsIndustryController {

    private Logger loger = LoggerFactory.getLogger(EcharsIndustryController.class);

    @Autowired
    private EchartsBiz echartsBiz;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private static MessageInfo errorRet = new MessageInfo(MessageStatus.MISS_PARAMETER_CODE,MessageStatus.MISS_PARAMETER_MESSAGE);

    @ApiOperation("商业洞察-行业分析-行业融资趋势")
    @RequestMapping("getRZQS")
    @ResponseBody
    public MessageInfo<EchartsData<IndustryMonth>> getRZQS (@RequestBody IndustryEcharsQuery industryEcharsQuery){
        MessageInfo<EchartsData<IndustryMonth>> messageInfo = new MessageInfo<EchartsData<IndustryMonth>>();
        try {
            if(StringUtils.isEmpty(industryEcharsQuery.getTimeType())){
                return errorRet;
            }
            messageInfo = echartsBiz.getIndustryByTimeRoundDistrict(industryEcharsQuery);
        } catch (Exception e) {
            e.printStackTrace();
            loger.error("商业洞察-行业分析-行业融资对比接口失败,error:" + e.getMessage());
            messageInfo = new MessageInfo<>(MessageStatus.ERROR_CODE,MessageStatus.ERROR_MESSAGE);
        }
        return messageInfo;
    }

    @ApiOperation("商业洞察-行业分析-行业融资对比")
    @RequestMapping("getRZDB")
    @ResponseBody
    public MessageInfo<EchartsData<IndustryRoundMerger>> getRZDB (@RequestBody IndustryEcharsQuery industryEcharsQuery){
        MessageInfo<EchartsData<IndustryRoundMerger>> messageInfo = new MessageInfo<EchartsData<IndustryRoundMerger>>();
        try {
            if(StringUtils.isEmpty(industryEcharsQuery.getTimeType())){
                return errorRet;
            }
            messageInfo = echartsBiz.getIndustryRoundForEcharts(industryEcharsQuery);
        } catch (Exception e) {
            e.printStackTrace();
            loger.error("获取高管行业融资对比,error:" + e.getMessage());
            messageInfo = new MessageInfo<>(MessageStatus.ERROR_CODE,MessageStatus.ERROR_MESSAGE);
        }
        return messageInfo;
    }

    @ApiOperation("商业洞察-行业分析-融资板块")
    @RequestMapping("getRZBK")
    @ResponseBody
    public MessageInfo<EchartsData<IndustryGroupDistrictRZBK>> getRZBK (@RequestBody IndustryEcharsQuery industryEcharsQuery){
        MessageInfo<EchartsData<IndustryGroupDistrictRZBK>> messageInfo = new MessageInfo<EchartsData<IndustryGroupDistrictRZBK>>();
        try {
            if(StringUtils.isEmpty(industryEcharsQuery.getTimeType())){
                return errorRet;
            }
            messageInfo = echartsBiz.getRZBK(industryEcharsQuery);
        } catch (Exception e) {
            e.printStackTrace();
            loger.error("商业洞察-行业分析-融资板块,error:" + e.getMessage());
            messageInfo = new MessageInfo<>(MessageStatus.ERROR_CODE,MessageStatus.ERROR_MESSAGE);
        }
        return messageInfo;
    }

    @ApiOperation("商业洞察-行业分析-持续获投分析")
    @RequestMapping("getCXHTFX")
    @ResponseBody
    public MessageInfo<EchartsData> getCXHTFX (@RequestBody IndustryEcharsQuery industryEcharsQuery){
        MessageInfo<EchartsData> messageInfo = new MessageInfo<EchartsData>();
        try {
            if(industryEcharsQuery.getIndustryId() ==null || StringUtils.isEmpty(industryEcharsQuery.getTime())){
                return errorRet;
            }
            messageInfo = echartsBiz.getCXHTFX(industryEcharsQuery);
        } catch (Exception e) {
            e.printStackTrace();
            loger.error("商业洞察-行业分析-持续获投分析,error:" + e.getMessage());
            messageInfo = new MessageInfo<>(MessageStatus.ERROR_CODE,MessageStatus.ERROR_MESSAGE);
        }
        return messageInfo;
    }

}
