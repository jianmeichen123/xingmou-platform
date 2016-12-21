package com.gi.xm.platform.controller;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.report.biz.TargetMonthBiz;
import com.gi.xm.report.pojo.TargetMonth;
import com.gi.xm.report.query.TargetMonthQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("targetMonth")
public class TargetMonthController {

    @Autowired
    private TargetMonthBiz targetMonthBiz;

    @RequestMapping("query")
    @ResponseBody
    public MessageInfo<QueryResultInfo<TargetMonth>> queryTargetMonth (TargetMonthQuery targetMonthQueryInfo) {
        MessageInfo<QueryResultInfo<TargetMonth>> resultMessageInfo = targetMonthBiz.queryTargetMonth(targetMonthQueryInfo);
        return resultMessageInfo;
    }

    @RequestMapping("queryList")
    @ResponseBody
    public MessageInfo<List<TargetMonth>>  queryTargetMonthList (TargetMonthQuery targetMonthQueryInfo) {
        MessageInfo<List<TargetMonth>> resultMessageInfo = targetMonthBiz.queryTargetMonthList(targetMonthQueryInfo);
        return resultMessageInfo;
    }

}
