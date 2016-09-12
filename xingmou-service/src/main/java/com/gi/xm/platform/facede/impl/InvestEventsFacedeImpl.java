package com.gi.xm.platform.facede.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.gi.xm.platform.biz.InvestEventsBiz;
import com.gi.xm.platform.biz.InvestEventsInvestfirmBiz;
import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.facede.InvestEventsFacede;
import com.gi.xm.platform.facede.convertor.InvestEventsConvertor;
import com.gi.xm.platform.facede.convertor.MessageConvertor;
import com.gi.xm.platform.pojo.InvestEvents;
import com.gi.xm.platform.pojo.InvestEventsInvestfirm;
import com.gi.xm.platform.query.InvestEventsQuery;
import com.gi.xm.platform.view.InvestEventsInfo;
import com.gi.xm.platform.view.InvestEventsQueryInfo;
import com.gi.xm.platform.view.ProjectEventRelationInfo;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvestEventsFacedeImpl implements InvestEventsFacede {

    @Autowired
    private InvestEventsBiz investEventsBiz;

    @Autowired
    private InvestEventsInvestfirmBiz investEventsInvestfirmBiz;

    public MessageInfo<Integer> deleteInvestEvents(Long id) {

        Message<Integer> message = investEventsBiz.deleteInvestEvents(id);
        MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
        messageInfo.setData(message.getData());
        return messageInfo;
    }

    public MessageInfo<Long> createInvestEvents(InvestEventsInfo investEventsInfo) {

        InvestEvents investEvents = InvestEventsConvertor.toInvestEvents(investEventsInfo);
        Message<Long> message = investEventsBiz.createInvestEvents(investEvents);
        MessageInfo<Long> messageInfo = MessageConvertor.toMessageInfo(message);
        messageInfo.setData(message.getData());
        return messageInfo;
    }

    public MessageInfo<Integer> updateInvestEvents(InvestEventsInfo investEventsInfo) {

        InvestEvents investEvents = InvestEventsConvertor.toInvestEvents(investEventsInfo);
        Message<Integer> message = investEventsBiz.updateInvestEvents(investEvents);
        MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
        messageInfo.setData(message.getData());
        return messageInfo;
    }

    @Cacheable(value = "investEventsInfo", keyGenerator = "wiselyKeyGenerator")
    public MessageInfo<InvestEventsInfo> getInvestEvents(Long id) {

        Message<InvestEvents> message = investEventsBiz.getInvestEvents(id);
        MessageInfo<InvestEventsInfo> messageInfo = MessageConvertor.toMessageInfo(message);
        InvestEventsInfo investEventsInfo = InvestEventsConvertor.toInvestEventsInfo(message.getData());
        messageInfo.setData(investEventsInfo);
        return messageInfo;
    }

    @Cacheable(value = "investEventsInfo", keyGenerator = "wiselyKeyGenerator")
    public MessageInfo<List<InvestEventsInfo>> getAllInvestEvents() {

        Message<List<InvestEvents>> message = investEventsBiz.getAllInvestEvents();
        MessageInfo<List<InvestEventsInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
        List<InvestEventsInfo> investEventsInfoList = InvestEventsConvertor.toInvestEventsInfoList(message.getData());
        messageInfo.setData(investEventsInfoList);
        return messageInfo;
    }

    public MessageInfo<QueryResultInfo<InvestEventsInfo>> queryInvestEvents(InvestEventsQueryInfo investEventsQueryInfo) {
        InvestEventsQuery investEventsQuery = InvestEventsConvertor.toInvestEventsQuery(investEventsQueryInfo);
        Message<QueryResult<InvestEvents>> message = investEventsBiz.queryInvestEvents(investEventsQuery);
        MessageInfo<QueryResultInfo<InvestEventsInfo>> messageInfo = new MessageInfo<QueryResultInfo<InvestEventsInfo>>();
        QueryResultInfo<InvestEventsInfo> queryResultInfo = InvestEventsConvertor.toQueryResultInfo(message.getData());
        messageInfo.setData(queryResultInfo);
        return messageInfo;
    }

/*
    public MessageInfo getRelationByYear(Integer[] years) {

        Message<List<InvestEvents>> message = investEventsBiz.getListByYear(years);

        List<InvestEvents> investEventses = message.getData();
        if (message.getData().isEmpty()) {
            MessageInfo messageInfo = MessageConvertor.toMessageInfo(message);
            return messageInfo;
        }
        Long[] eventIds = new Long[investEventses.size()];
        List<ProjectEventRelationInfo> prs = new ArrayList<>(investEventses.size());

        int i = 0;
        for (InvestEvents investEvent : message.getData()) {
            eventIds[i] = investEvent.getId();
            makeProjectRelation(prs, investEvent);
        }
        Message<List<InvestEventsInvestfirm>> m1 = investEventsInvestfirmBiz.getListByEventId(eventIds);
        if (m1.getData().isEmpty()){
            MessageInfo messageInfo = MessageConvertor.toMessageInfo(m1);
            return messageInfo;
        }
        List<InvestfirmRelationInfo> irs = new ArrayList<>();
        for(InvestEventsInvestfirm iif:m1.getData()){
            makeInvestfirmRelation(irs,iif);
        }
        return null;
    }

    private void makeProjectRelation(List<ProjectEventRelationInfo> l, InvestEvents i) {
        ProjectEventRelationInfo o = null;
        for (ProjectEventRelationInfo p : l) {
            if (p.getProjectId().intValue() == o.getProjectId().intValue()) {
                p.setTotal(p.getTotal() + 1);
                o = p;
                break;
            }
        }
        if (o == null){
            o  = new ProjectEventRelationInfo();
            o.setProjectId(i.getProjectId());
            o.setProjectName(i.getTitle());
            o.setTotal(1);
            l.add(o);
        }
    }


    private void makeInvestfirmRelation(List<InvestfirmRelationInfo> l, InvestEventsInvestfirm i) {
        InvestfirmRelationInfo o = null;
        for (InvestfirmRelationInfo p : l) {
            if (p.getInvestfirmId().intValue() == i.getInvestfirmId().intValue()) {
                p.setTotal(p.getTotal() + 1);
                break;
            }
        }
        if (o == null){
            o.setInvestfirmId(i.getInvestfirmId());
            o.setName(i.getInvestfirmName());
            o.setTotal(1);
            l.add(o);
        }
    }*/
}