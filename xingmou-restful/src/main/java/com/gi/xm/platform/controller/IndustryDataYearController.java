package com.gi.xm.platform.controller;

import com.gi.xm.platform.view.IndustryDataYearQueryInfo;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.report.biz.ChartDataIndustryFirstYearBiz;
import com.gi.xm.report.biz.ChartDataIndustryYearBiz;
import com.gi.xm.report.biz.ChartDataYearBiz;
import com.gi.xm.report.pojo.ChartDataIndustryFirstYear;
import com.gi.xm.report.pojo.ChartDataIndustryYear;
import com.gi.xm.report.pojo.ChartDataYear;
import com.gi.xm.report.query.ChartDataIndustryFirstYearQueryInfo;
import com.gi.xm.report.query.ChartDataIndustryYearQueryInfo;
import com.gi.xm.report.query.ChartDataYearQueryInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 年度、行业指标分析
 */
@Controller
@RequestMapping("industryDataYear")
public class IndustryDataYearController {


    @Autowired
    private ChartDataIndustryFirstYearBiz chartDataIndustryFirstYearBiz;

    @Autowired
    private ChartDataYearBiz chartDataYearBiz;

    @Autowired
    private ChartDataIndustryYearBiz chartDataIndustryYearBiz;

	@RequestMapping("query")
	@ResponseBody
	public MessageInfo  queryIndustryDataYear (@RequestBody IndustryDataYearQueryInfo industryDataYearQueryInfo) {


        //查子行业
        if (industryDataYearQueryInfo != null && industryDataYearQueryInfo.getIndustrySubId()!=null) {
            //resultMessageInfo =  industryDataYearFacede.queryIndustryDataYear(industryDataYearQueryInfo);
            MessageInfo<QueryResultInfo<ChartDataIndustryYear>> messageInfo =  new MessageInfo<QueryResultInfo<ChartDataIndustryYear>>();
            ChartDataIndustryYearQueryInfo chartDataIndustryYearQueryInfo = new ChartDataIndustryYearQueryInfo();
            chartDataIndustryYearQueryInfo.setPageIndex(industryDataYearQueryInfo.getPageIndex());
            chartDataIndustryYearQueryInfo.setPageSize(industryDataYearQueryInfo.getPageSize());
            chartDataIndustryYearQueryInfo.setYears(industryDataYearQueryInfo.getYearList());
            chartDataIndustryYearQueryInfo.setIndustrySubId(industryDataYearQueryInfo.getIndustrySubId());
            messageInfo =  chartDataIndustryYearBiz.queryChartDataIndustryYear(chartDataIndustryYearQueryInfo);
            return  messageInfo;
        } else if(industryDataYearQueryInfo != null && industryDataYearQueryInfo.getIndustryId()!=null){
            //一级行业
            MessageInfo<QueryResultInfo<ChartDataIndustryFirstYear>> messageInfo =  new MessageInfo<QueryResultInfo<ChartDataIndustryFirstYear>>();
            ChartDataIndustryFirstYearQueryInfo chartDataIndustryFirstYearQueryInfo = new ChartDataIndustryFirstYearQueryInfo();
            chartDataIndustryFirstYearQueryInfo.setIndustryId(industryDataYearQueryInfo.getIndustryId());
            chartDataIndustryFirstYearQueryInfo.setYears(industryDataYearQueryInfo.getYearList());
            chartDataIndustryFirstYearQueryInfo.setYaar(industryDataYearQueryInfo.getYaar());
            chartDataIndustryFirstYearQueryInfo.setPageIndex(industryDataYearQueryInfo.getPageIndex());
            chartDataIndustryFirstYearQueryInfo.setPageSize(industryDataYearQueryInfo.getPageSize());
            messageInfo =  chartDataIndustryFirstYearBiz.queryChartDataIndustryFirstYear(chartDataIndustryFirstYearQueryInfo);
            return  messageInfo;
        } else {
            //全部行业
            MessageInfo<QueryResultInfo<ChartDataYear>> messageInfo =  new MessageInfo<QueryResultInfo<ChartDataYear>>();
            ChartDataYearQueryInfo industryFirstDataYearQueryInfo = new ChartDataYearQueryInfo();
          //  industryFirstDataYearQueryInfo.setIndustryId(industryDataYearQueryInfo.getIndustryId());
            industryFirstDataYearQueryInfo.setYears(industryDataYearQueryInfo.getYearList());
            industryFirstDataYearQueryInfo.setPageIndex(industryDataYearQueryInfo.getPageIndex());
            industryFirstDataYearQueryInfo.setPageSize(industryDataYearQueryInfo.getPageSize());
            messageInfo =  chartDataYearBiz.queryChartDataYear(industryFirstDataYearQueryInfo);
            return  messageInfo;
        }

	}

}
