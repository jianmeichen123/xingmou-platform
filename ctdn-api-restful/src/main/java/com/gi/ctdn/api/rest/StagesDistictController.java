package com.gi.ctdn.api.rest;

import com.gi.ctdn.biz.StagesDistictBiz;
import com.gi.ctdn.pojo.StagesDistrict;
import com.gi.ctdn.view.common.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("stagesDistrict")
public class StagesDistictController {

    @Autowired
    StagesDistictBiz stagesDistictBiz;

    @ResponseBody
    @RequestMapping("getStagesDistics/{timeType}/{districtSubName}")
    public MessageInfo<List<StagesDistrict>> getStagesDistics(@PathVariable String timeType,@PathVariable String districtSubName){
        return stagesDistictBiz.getStagesDistricts(timeType,districtSubName);
    }

    @ResponseBody
    @RequestMapping("getStages/{timeType}/{districtSubName}")
    public MessageInfo<List<List<StagesDistrict>>> getStages(@PathVariable String timeType,@PathVariable String districtSubName){
        return stagesDistictBiz.getStages(timeType,districtSubName);
    }
}
