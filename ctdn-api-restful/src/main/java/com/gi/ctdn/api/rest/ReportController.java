package com.gi.ctdn.api.rest;

import com.gi.ctdn.biz.ReportBiz;
import com.gi.ctdn.pojo.Report;
import com.gi.ctdn.view.common.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
