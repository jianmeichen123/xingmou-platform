package com.gi.ctdn.restful.controller;

import com.gi.ctdn.query.EventsQueryInfo;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.ctdn.biz.EventsBiz;
import com.gi.ctdn.pojo.EventsInfo;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * Created by zcy on 17-2-20.
 */
@Controller
@RequestMapping("investEvents")
public class InvestEventsController {

    @Reference
    private EventsBiz eventsBiz;

    @RequestMapping("createInvestEvents")
    @ResponseBody
    public MessageInfo<Long> createCompany(@RequestBody EventsInfo eventsInfo){
        MessageInfo<Long> messageInfo = new MessageInfo<>();
        //验证表单必填项
        if(eventsInfo.getProjectId() == null || eventsInfo.getRoundName()== null ||
            eventsInfo.getRoundId() == null ||eventsInfo.getEventDate() == null ||
            eventsInfo.getInvestfirmNames() == null || eventsInfo.getEventMoney() == null||
            eventsInfo.getCurrencyName() == null ){

            messageInfo.setStatus(10001);
            messageInfo.setMessage("必填项未填写完整!");
            return messageInfo;
        }
        eventsInfo.setAddTime(new Date());
        messageInfo = eventsBiz.createEvents(eventsInfo);
        return messageInfo;
    }

    @RequestMapping("updateInvestEvents")
    @ResponseBody
    public MessageInfo<Long> updateInvestEvents(@RequestBody EventsInfo eventsInfo){
        MessageInfo<Long> messageInfo = new MessageInfo<>();
        if(eventsInfo.getId()==null){
            messageInfo.setStatus(10001);
            messageInfo.setMessage("eventId　缺失！");
            return messageInfo;
        }
        //验证表单必填项
        if(eventsInfo.getProjectId() == null || eventsInfo.getRoundName()== null ||
                eventsInfo.getRoundId() == null ||eventsInfo.getEventDate() == null ||
                eventsInfo.getInvestfirmNames() == null || eventsInfo.getEventMoney() == null||
                eventsInfo.getCurrencyName() == null ){

            messageInfo.setStatus(10001);
            messageInfo.setMessage("必填项未填写完整!");
            return messageInfo;
        }
        eventsInfo.setUpdateTime(new Date());
        messageInfo = eventsBiz.updateEvents(eventsInfo);
        return messageInfo;
    }

    @RequestMapping("queryById")
    @ResponseBody
    public MessageInfo<EventsInfo> queryById (Long id){
        MessageInfo<EventsInfo> messageInfo = new MessageInfo<EventsInfo>();
        if(null!= id ){
            messageInfo.setStatus(10001);
            messageInfo.setMessage("event id 缺失!");
            return messageInfo;
        }
        EventsInfo eventsInfo = eventsBiz.queryById(id).getData();
        if(null != eventsInfo){
            messageInfo.setData(eventsInfo);
        }else{
            messageInfo.setMessage("event id 错误！");
            messageInfo.setStatus(10001);
        }
        return messageInfo;
    }

    @RequestMapping("queryList")
    @ResponseBody
    public MessageInfo<List<EventsInfo>> query (Long projectId){
        MessageInfo<List<EventsInfo>> messageInfo = new MessageInfo<List<EventsInfo>>();
        messageInfo = eventsBiz.getListByProjectId(projectId);
        return messageInfo;
    }
}
