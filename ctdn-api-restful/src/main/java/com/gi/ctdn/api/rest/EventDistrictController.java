package com.gi.ctdn.api.rest;

import com.gi.ctdn.biz.EventDistrictBiz;
import com.gi.ctdn.pojo.EventDistrict;
import com.gi.ctdn.view.common.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("eventDistrict")
public class EventDistrictController {

    @Autowired
    EventDistrictBiz eventDistrictBiz;

    @ResponseBody
    @RequestMapping("getEventDistricts/{timeType}")
    public MessageInfo<List<EventDistrict>> getEventDistricts(@PathVariable Integer timeType){
        return eventDistrictBiz.getListByTimeType(timeType);
    }

    @ResponseBody
    @RequestMapping("getEventDistrictList/{timeType}/{districtSubName}")
    public MessageInfo<List<EventDistrict>> getEventDistrictList(@PathVariable Integer timeType,@PathVariable String districtSubName ){
        return eventDistrictBiz.getListByTimeAndDistrict(timeType,districtSubName);
    }
}
