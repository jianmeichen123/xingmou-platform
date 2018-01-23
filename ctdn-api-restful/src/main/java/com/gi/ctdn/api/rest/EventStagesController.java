package com.gi.ctdn.api.rest;

import com.gi.ctdn.biz.EventStagesBiz;
import com.gi.ctdn.pojo.EventStages;
import com.gi.ctdn.view.common.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("eventStages")
public class EventStagesController {

    @Autowired
    EventStagesBiz eventStagesBiz;

    @ResponseBody
    @RequestMapping("getEventStagesList/{districtSubId}/{timeType}")
    public MessageInfo<List<EventStages>> getEventStagesList(@PathVariable Integer districtSubId,@PathVariable Integer timeType){
        return  eventStagesBiz.getEventStagesList(districtSubId,timeType);
    }
}
