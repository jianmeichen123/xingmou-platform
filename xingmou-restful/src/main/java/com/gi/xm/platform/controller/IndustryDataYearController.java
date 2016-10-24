package com.gi.xm.platform.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.dubbo.config.annotation.Reference;

import com.gi.xm.platform.facede.IndustryFirstDataYearFacede;
import com.gi.xm.platform.view.IndustryFirstDataYearInfo;
import com.gi.xm.platform.view.IndustryFirstDataYearQueryInfo;
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
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.IndustryDataYearInfo;
import com.gi.xm.platform.view.IndustryDataYearQueryInfo;
import com.gi.xm.platform.facede.IndustryDataYearFacede;

/**
 * 年度、行业指标分析
 */
@Controller
@RequestMapping("industryDataYear")
public class IndustryDataYearController {

	@Reference(check = false)
	private IndustryDataYearFacede industryDataYearFacede;
    @Reference(check = false)
    private IndustryFirstDataYearFacede  industryFirstDataYearFacede;

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
/*

    @RequestMapping("create")
    @ResponseBody
    public MessageInfo<Long> createIndustryDataYear( IndustryDataYearInfo industryDataYearInfo){
        MessageInfo<Long> messageInfo =  industryDataYearFacede.createIndustryDataYear(industryDataYearInfo);
        return messageInfo;
    }

    @RequestMapping("update")
    @ResponseBody
	public MessageInfo<Integer> updateIndustryDataYear(IndustryDataYearInfo industryDataYearInfo){
		MessageInfo<Integer> messageInfo =  industryDataYearFacede.updateIndustryDataYear(industryDataYearInfo);
		return messageInfo;
	}
*/

    @RequestMapping("get")
    @ResponseBody
	public MessageInfo<IndustryDataYearInfo> getIndustryDataYear( Long id ){
		MessageInfo<IndustryDataYearInfo> messageInfo =  industryDataYearFacede.getIndustryDataYear(id);
		return messageInfo;
	}
/*

    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<IndustryDataYearInfo>> getAllIndustryDataYear(){
		MessageInfo<List<IndustryDataYearInfo>>  messageInfo = industryDataYearFacede.getAllIndustryDataYear();
		return messageInfo;
	}

*/

		
/*    @RequestMapping("getListByIndustryIdYaar")
    @ResponseBody
	public MessageInfo<List<IndustryDataYearInfo>> getListByIndustryIdYaar(Integer industryId, Integer[] years){
		MessageInfo<List<IndustryDataYearInfo>> messageInfo = industryDataYearFacede.getListByIndustryIdYaar(industryId, years);
		return messageInfo;
	}
			
    @RequestMapping("getListByYaarIndustrySubId")
    @ResponseBody
	public MessageInfo<List<IndustryDataYearInfo>> getListByYaarIndustrySubId(Integer[] years, Integer industrySubId){
		MessageInfo<List<IndustryDataYearInfo>> messageInfo = industryDataYearFacede.getListByYaarIndustrySubId(years, industrySubId);
		return messageInfo;
	}
			*/
    @RequestMapping("getListByIndustryId")
    @ResponseBody
	public MessageInfo<List<IndustryDataYearInfo>> getListByIndustryId(Integer industryId){
		MessageInfo<List<IndustryDataYearInfo>> messageInfo = industryDataYearFacede.getListByIndustryId(industryId);
		return messageInfo;
	}
			
/*    @RequestMapping("getListByYaar")
    @ResponseBody
	public MessageInfo<List<IndustryDataYearInfo>> getListByYaar(Integer[] years){
		MessageInfo<List<IndustryDataYearInfo>> messageInfo = industryDataYearFacede.getListByYaar(years);
		return messageInfo;
	}*/

    @RequestMapping("analysis/{year}/{industryId}/{industrySubId}")
    @ResponseBody
    public MessageInfo<List<IndustryDataYearInfo>> analysis(
            @PathVariable("year") Integer[] years,@PathVariable("industryId") Integer industryId,@PathVariable("industrySubId") Integer industrySubId){

        //子行业
        if (years != null  && industrySubId != 0){
            MessageInfo<List<IndustryDataYearInfo>> messageInfo = industryDataYearFacede.getListByYaarIndustrySubId(years, industrySubId);
            return messageInfo;
        }else if(years != null  && industryId != 0){
            MessageInfo<List<IndustryDataYearInfo>> messageInfo = industryFirstDataYearFacede.getListByIndustryIdYaar(industryId, years);
            return messageInfo;
        }else if (years != null){
            MessageInfo<List<IndustryDataYearInfo>> messageInfo = industryDataYearFacede.getListByYaar(years);
            return messageInfo;
        }else {
            return null;
        }
    }

}
