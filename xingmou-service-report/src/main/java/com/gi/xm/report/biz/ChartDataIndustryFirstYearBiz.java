

package com.gi.xm.report.biz;

import java.util.List;

import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.report.query.ChartDataIndustryFirstYearQueryInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.report.dao.ChartDataIndustryFirstYearDAO;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.report.pojo.ChartDataIndustryFirstYear;

@Service("chartDataIndustryFirstYearBiz")
public class ChartDataIndustryFirstYearBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(ChartDataIndustryFirstYearBiz.class);

    @Autowired
	ChartDataIndustryFirstYearDAO chartDataIndustryFirstYearDAO;






	public MessageInfo<List<ChartDataIndustryFirstYear>> getListByIndustryIdYaar( Integer[] years,Integer industryId){

		MessageInfo<List<ChartDataIndustryFirstYear>> messageInfo = new MessageInfo<List<ChartDataIndustryFirstYear>>();
		try {
			List<ChartDataIndustryFirstYear> chartDataIndustryFirstYearList = chartDataIndustryFirstYearDAO.selectByIndustryIdYaar(years, industryId);
			messageInfo.setData(chartDataIndustryFirstYearList);
		} catch (Exception e) {
			LOGGER.error("getListByIndustryIdYaar","查询ChartDataIndustryFirstYear失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}



	public MessageInfo<QueryResultInfo<ChartDataIndustryFirstYear>> queryChartDataIndustryFirstYear(ChartDataIndustryFirstYearQueryInfo chartDataIndustryFirstYearQueryInfo) {
        MessageInfo<QueryResultInfo<ChartDataIndustryFirstYear>> messageInfo = new MessageInfo<QueryResultInfo<ChartDataIndustryFirstYear>>();
		try {
            QueryResultInfo<ChartDataIndustryFirstYear> queryResult = new QueryResultInfo<ChartDataIndustryFirstYear>();
			PageHelper.startPage(chartDataIndustryFirstYearQueryInfo.getPageIndex(), chartDataIndustryFirstYearQueryInfo.getPageSize());
			List<ChartDataIndustryFirstYear> chartDataIndustryFirstYearList = chartDataIndustryFirstYearDAO.queryChartDataIndustryFirstYear(chartDataIndustryFirstYearQueryInfo);
			PageInfo<ChartDataIndustryFirstYear> pageInfo = new PageInfo<ChartDataIndustryFirstYear>(chartDataIndustryFirstYearList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(chartDataIndustryFirstYearList);
            messageInfo.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryChartDataIndustryFirstYear", "分页查询ChartDataIndustryFirstYear失败", e);
            messageInfo.setStatus(10001);
		}
		return messageInfo;
    }
	/*public MessageInfo<List<ChartDataIndustryFirstYear>> getListByYaar(Integer yaar){

		MessageInfo<List<ChartDataIndustryFirstYear>> messageInfo = new MessageInfo<List<ChartDataIndustryFirstYear>>();
		try {
			List<ChartDataIndustryFirstYear> chartDataIndustryFirstYearList = chartDataIndustryFirstYearDAO.selectByYaar(yaar);
			messageInfo.setData(chartDataIndustryFirstYearList);
		} catch (Exception e) {
			LOGGER.error("getListByYaar","查询ChartDataIndustryFirstYear失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
			
	public MessageInfo<List<ChartDataIndustryFirstYear>> getListByIndustryId(Integer industryId){

		MessageInfo<List<ChartDataIndustryFirstYear>> messageInfo = new MessageInfo<List<ChartDataIndustryFirstYear>>();
		try {
			List<ChartDataIndustryFirstYear> chartDataIndustryFirstYearList = chartDataIndustryFirstYearDAO.selectByIndustryId(industryId);
			messageInfo.setData(chartDataIndustryFirstYearList);
		} catch (Exception e) {
			LOGGER.error("getListByIndustryId","查询ChartDataIndustryFirstYear失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
			
	public MessageInfo<List<ChartDataIndustryFirstYear>> getListByYaar(Integer yaar){

		MessageInfo<List<ChartDataIndustryFirstYear>> messageInfo = new MessageInfo<List<ChartDataIndustryFirstYear>>();
		try {
			List<ChartDataIndustryFirstYear> chartDataIndustryFirstYearList = chartDataIndustryFirstYearDAO.selectByYaar(yaar);
			messageInfo.setData(chartDataIndustryFirstYearList);
		} catch (Exception e) {
			LOGGER.error("getListByYaar","查询ChartDataIndustryFirstYear失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
		*/

}