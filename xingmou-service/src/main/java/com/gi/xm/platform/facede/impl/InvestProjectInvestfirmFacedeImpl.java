package com.gi.xm.platform.facede.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.gi.xm.platform.biz.InvestProjectInvestfirmBiz;
import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.facede.InvestProjectInvestfirmFacede;
import com.gi.xm.platform.facede.convertor.InvestProjectInvestfirmConvertor;
import com.gi.xm.platform.facede.convertor.MessageConvertor;
import com.gi.xm.platform.pojo.InvestProjectInvestfirm;
import com.gi.xm.platform.query.InvestProjectInvestfirmQuery;
import com.gi.xm.platform.view.*;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class InvestProjectInvestfirmFacedeImpl implements InvestProjectInvestfirmFacede {

    @Autowired
    private InvestProjectInvestfirmBiz investProjectInvestfirmBiz;

    public MessageInfo<Integer> deleteInvestProjectInvestfirm(Long id) {

        Message<Integer> message = investProjectInvestfirmBiz.deleteInvestProjectInvestfirm(id);
        MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
        messageInfo.setData(message.getData());
        return messageInfo;
    }

    public MessageInfo<Long> createInvestProjectInvestfirm(InvestProjectInvestfirmInfo investProjectInvestfirmInfo) {

        InvestProjectInvestfirm investProjectInvestfirm = InvestProjectInvestfirmConvertor.toInvestProjectInvestfirm(investProjectInvestfirmInfo);
        Message<Long> message = investProjectInvestfirmBiz.createInvestProjectInvestfirm(investProjectInvestfirm);
        MessageInfo<Long> messageInfo = MessageConvertor.toMessageInfo(message);
        messageInfo.setData(message.getData());
        return messageInfo;
    }

    public MessageInfo<Integer> updateInvestProjectInvestfirm(InvestProjectInvestfirmInfo investProjectInvestfirmInfo) {

        InvestProjectInvestfirm investProjectInvestfirm = InvestProjectInvestfirmConvertor.toInvestProjectInvestfirm(investProjectInvestfirmInfo);
        Message<Integer> message = investProjectInvestfirmBiz.updateInvestProjectInvestfirm(investProjectInvestfirm);
        MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
        messageInfo.setData(message.getData());
        return messageInfo;
    }

    @Cacheable(value = "investProjectInvestfirmInfo", keyGenerator = "wiselyKeyGenerator")
    public MessageInfo<InvestProjectInvestfirmInfo> getInvestProjectInvestfirm(Long id) {

        Message<InvestProjectInvestfirm> message = investProjectInvestfirmBiz.getInvestProjectInvestfirm(id);
        MessageInfo<InvestProjectInvestfirmInfo> messageInfo = MessageConvertor.toMessageInfo(message);
        InvestProjectInvestfirmInfo investProjectInvestfirmInfo = InvestProjectInvestfirmConvertor.toInvestProjectInvestfirmInfo(message.getData());
        messageInfo.setData(investProjectInvestfirmInfo);
        return messageInfo;
    }

    @Cacheable(value = "investProjectInvestfirmInfo", keyGenerator = "wiselyKeyGenerator")
    public MessageInfo<List<InvestProjectInvestfirmInfo>> getAllInvestProjectInvestfirm() {

        Message<List<InvestProjectInvestfirm>> message = investProjectInvestfirmBiz.getAllInvestProjectInvestfirm();
        MessageInfo<List<InvestProjectInvestfirmInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
        List<InvestProjectInvestfirmInfo> investProjectInvestfirmInfoList = InvestProjectInvestfirmConvertor.toInvestProjectInvestfirmInfoList(message.getData());
        messageInfo.setData(investProjectInvestfirmInfoList);
        return messageInfo;
    }

    public MessageInfo<QueryResultInfo<InvestProjectInvestfirmInfo>> queryInvestProjectInvestfirm(InvestProjectInvestfirmQueryInfo investProjectInvestfirmQueryInfo) {
        InvestProjectInvestfirmQuery investProjectInvestfirmQuery = InvestProjectInvestfirmConvertor.toInvestProjectInvestfirmQuery(investProjectInvestfirmQueryInfo);
        Message<QueryResult<InvestProjectInvestfirm>> message = investProjectInvestfirmBiz.queryInvestProjectInvestfirm(investProjectInvestfirmQuery);
        MessageInfo<QueryResultInfo<InvestProjectInvestfirmInfo>> messageInfo = new MessageInfo<QueryResultInfo<InvestProjectInvestfirmInfo>>();
        QueryResultInfo<InvestProjectInvestfirmInfo> queryResultInfo = InvestProjectInvestfirmConvertor.toQueryResultInfo(message.getData());
        messageInfo.setData(queryResultInfo);
        return messageInfo;
    }


    public MessageInfo<List<InvestProjectInvestfirmInfo>> getListByInvestId(Long investId) {

        Message<List<InvestProjectInvestfirm>> message = investProjectInvestfirmBiz.getListByInvestId(investId);
        MessageInfo<List<InvestProjectInvestfirmInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
        List<InvestProjectInvestfirmInfo> investProjectInvestfirmInfoList = InvestProjectInvestfirmConvertor.toInvestProjectInvestfirmInfoList(message.getData());
        messageInfo.setData(investProjectInvestfirmInfoList);
        return messageInfo;
    }


    public MessageInfo<List<InvestProjectInvestfirmInfo>> getListByInvestfirmId(Long investfirmId) {

        Message<List<InvestProjectInvestfirm>> message = investProjectInvestfirmBiz.getListByInvestfirmId(investfirmId);
        MessageInfo<List<InvestProjectInvestfirmInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
        List<InvestProjectInvestfirmInfo> investProjectInvestfirmInfoList = InvestProjectInvestfirmConvertor.toInvestProjectInvestfirmInfoList(message.getData());
        messageInfo.setData(investProjectInvestfirmInfoList);
        return messageInfo;
    }


    public MessageInfo<List<InvestProjectInvestfirmInfo>> getListByProjectId(Long projectId) {
        Message<List<InvestProjectInvestfirm>> message = investProjectInvestfirmBiz.getListByProjectId(projectId);
        MessageInfo<List<InvestProjectInvestfirmInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
        List<InvestProjectInvestfirmInfo> investProjectInvestfirmInfoList = InvestProjectInvestfirmConvertor.toInvestProjectInvestfirmInfoList(message.getData());
        messageInfo.setData(investProjectInvestfirmInfoList);
        return messageInfo;
    }


    public MessageInfo<RelationInfo> getRelationInfo(Integer year, Integer industryId, Integer industrySubId) {
        InvestProjectInvestfirmQuery query = new InvestProjectInvestfirmQuery();
        query.setYear(year);
        query.setIndustryId(industryId);
        query.setIndustrySubId(industrySubId);
        Message<List<InvestProjectInvestfirm>> message = investProjectInvestfirmBiz.query(query);
        if (message == null) {
            MessageInfo<RelationInfo> messageInfo = MessageConvertor.toMessageInfo(message);
            return messageInfo;
        }
        List<ProjectEventRelationInfo> prs = new ArrayList<>();
        List<InvestfirmsRelationInfo> irs = new ArrayList<>();
        for (InvestProjectInvestfirm ipi :message.getData()){
            makeInvestfirmRelation(irs,ipi);
            makeProjectRelation(prs,ipi);
        }
        for (ProjectEventRelationInfo pr :prs){
          for(InvestProjectInvestfirm ipi :message.getData()){
              if ( pr.getProjectId().intValue() == ipi.getProjectId().intValue() && ipi.getInvestfirmId() !=null){
                  Set<Long> iids = pr.getInvestfirmId();
                  if (iids == null){
                      iids = new HashSet<>();
                      pr.setInvestfirmId(iids);
                  }
                  iids.add(ipi.getInvestfirmId());
              }
          }
        }
        RelationInfo r = new RelationInfo();
        r.setIs(irs);
        r.setPs(prs);
        MessageInfo<RelationInfo> m = new MessageInfo<>();
        m.setData(r);
        return m;
    }

    private void makeProjectRelation(List<ProjectEventRelationInfo> l, InvestProjectInvestfirm ip) {
        ProjectEventRelationInfo o = null;
        for (ProjectEventRelationInfo p : l) {
            if (p.getProjectId().intValue() == o.getProjectId().intValue()) {
                p.setTotal(p.getTotal() + 1);
                break;
            }
        }
        if (o == null){
            o  = new ProjectEventRelationInfo();
            o.setProjectId(ip.getProjectId());
            o.setProjectName(ip.getProjectName());
            o.setTotal(1);
            l.add(o);
        }
    }


    private void makeInvestfirmRelation(List<InvestfirmsRelationInfo> l, InvestProjectInvestfirm ip) {
        InvestfirmsRelationInfo o = null;
        for (InvestfirmsRelationInfo p : l) {
            if (ip.getInvestfirmId()!=null && p.getInvestfirmId().intValue() == ip.getInvestfirmId().intValue()) {
                p.setTotal(p.getTotal() + 1);
                break;
            }
        }
        if (o == null){
            o.setInvestfirmId(ip.getInvestfirmId());
            o.setName(ip.getInvestfirmName());
            o.setTotal(1);
            l.add(o);
        }
    }
}