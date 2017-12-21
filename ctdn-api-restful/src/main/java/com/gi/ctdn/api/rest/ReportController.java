package com.gi.ctdn.api.rest;

import com.gi.ctdn.biz.ReportBiz;
import com.gi.ctdn.pojo.Report;
import com.gi.ctdn.view.common.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@Validated
@RequestMapping("report")
public class ReportController {

    @Autowired
    ReportBiz reportBiz;

    @RequestMapping(value="/num")
    @ResponseBody
    public  Integer reportNum(){
        return reportBiz.getReportNum();
    }

    /**
     * 报告列表
     * @return
     */
    @RequestMapping(value = "/queryReportByPage",method = RequestMethod.POST)
    @ResponseBody
    public MessageInfo<Report> reports(@RequestBody Report report){
        MessageInfo<Report> messageInfo = new MessageInfo<>();
        messageInfo = reportBiz.getReportList(report);
        return messageInfo;
    }


    /**
     * 不分页 报告列表
     * @return
     */
    @RequestMapping(value = "/queryReports",method = RequestMethod.GET)
    @ResponseBody
    public MessageInfo<Report> getReports(){
        MessageInfo<Report> messageInfo = new MessageInfo<>();
        messageInfo = reportBiz.getReports();
        return messageInfo;
    }

    /**
     * 根据id查询报告
     * @return
     */
    @RequestMapping(value = "/getReport/{id}",method = RequestMethod.GET)
    @ResponseBody
    public MessageInfo<Report> getReport(@PathVariable Integer id){
        MessageInfo<Report> messageInfo = new MessageInfo<>();
        messageInfo = reportBiz.getReportById(id);
        return messageInfo;
    }
}
