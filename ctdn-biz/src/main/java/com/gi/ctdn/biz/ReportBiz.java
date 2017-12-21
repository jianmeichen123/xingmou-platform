package com.gi.ctdn.biz;

import com.gi.ctdn.dao.ReportDAO;
import com.gi.ctdn.pojo.Report;
import com.gi.ctdn.view.common.MessageInfo;
import com.gi.ctdn.view.common.MessageStatus;
import com.gi.ctdn.view.common.Pagination;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ReportBiz {
    @Autowired
    ReportDAO reportDAO;

    private static final Logger LOGGER = LoggerFactory.getLogger(ReportBiz.class);

    public Integer getReportNum(){
        return reportDAO.selectReportNum();
    }

    //报告列表分页
    public MessageInfo<Report> getReportList(Report report){
        MessageInfo<Report> messageInfo;
        try {
            PageHelper.startPage(report.getPageNo(),report.getPageSize());
            List<Report> reportList = reportDAO.selectReports();
            Pagination page = new Pagination();
            if(reportList!=null){
                PageInfo pageInfo = new PageInfo<>(reportList);
                page.setRecords(reportList);
                page.setTotal(pageInfo.getTotal());
            }
            messageInfo = new MessageInfo<>(MessageStatus.OK_CODE,MessageStatus.OK_MESSAGE,page);
        }catch (Exception e){
            e.printStackTrace();
            messageInfo = new MessageInfo<>(MessageStatus.ERROR_CODE,MessageStatus.ERROR_MESSAGE);
        }
        return messageInfo;
    }

    public void updateState(Integer id){
        reportDAO.updateReportState(id);
    }

    public List<Report> selectByIds (List<String> ids){
        List<Report> reportList= reportDAO.selectByIds(ids);
        return reportList;
    }

    //详情报告列表，不分页
    public MessageInfo<Report> getReports(){
        MessageInfo<Report> messageInfo = new MessageInfo<>();
        try {
            List<Report> reports = reportDAO.selectReports();
            Pagination page = new Pagination();
            if(reports!=null){
                page.setRecords(reports);
                messageInfo.setPage(page);
            }
            messageInfo = new MessageInfo<>(MessageStatus.OK_CODE,MessageStatus.OK_MESSAGE,page);
        }catch (Exception e){
            messageInfo = new MessageInfo<>(MessageStatus.ERROR_CODE,MessageStatus.ERROR_MESSAGE);
            LOGGER.error(e.getMessage());
        }
        return  messageInfo;
    }

    public MessageInfo<Report> getReportById(Integer id){
        MessageInfo<Report> messageInfo = new MessageInfo<>();
        try{
            Report report = reportDAO.selectById(id);
            if(report!=null){
                messageInfo.setData(report);
                messageInfo.setStatus(MessageStatus.OK_CODE);
                messageInfo.setMessage(MessageStatus.OK_MESSAGE);
            }
        }catch (Exception e){
            messageInfo.setStatus(MessageStatus.ERROR_CODE);
            messageInfo.setMessage(MessageStatus.ERROR_MESSAGE);
            LOGGER.error(e.getMessage());
        }
        return messageInfo;
    }
}
