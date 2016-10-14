

package com.gi.xm.report.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.report.dao.ChartEventIndustrySubMoneylevelYearDAO;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.report.pojo.ChartEventIndustrySubMoneylevelYear;

@Service("chartEventIndustrySubMoneylevelYearBiz")
public class ChartEventIndustrySubMoneylevelYearBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(ChartEventIndustrySubMoneylevelYearBiz.class);

    @Autowired
	ChartEventIndustrySubMoneylevelYearDAO chartEventIndustrySubMoneylevelYearDAO;



    public MessageInfo<Long> createChartEventIndustrySubMoneylevelYear(ChartEventIndustrySubMoneylevelYear chartEventIndustrySubMoneylevelYear){
		MessageInfo<Long> messageInfo = new MessageInfo<Long>();
		try {
			chartEventIndustrySubMoneylevelYearDAO.insert( chartEventIndustrySubMoneylevelYear );
			messageInfo.setData(chartEventIndustrySubMoneylevelYear.getId());

		} catch (Exception e) {
			LOGGER.error("createChartEventIndustrySubMoneylevelYear","创建ChartEventIndustrySubMoneylevelYear失败", e);
			messageInfo.setStatus(10001);;
		}
		return messageInfo;
	}

/*

	public MessageInfo<List<ChartEventIndustrySubMoneylevelYear>> getListByIndustryId(Integer industryId){

		MessageInfo<List<ChartEventIndustrySubMoneylevelYear>> messageInfo = new MessageInfo<List<ChartEventIndustrySubMoneylevelYear>>();
		try {
			List<ChartEventIndustrySubMoneylevelYear> chartEventIndustrySubMoneylevelYearList = chartEventIndustrySubMoneylevelYearDAO.selectByIndustryId(industryId);
			messageInfo.setData(chartEventIndustrySubMoneylevelYearList);
		} catch (Exception e) {
			LOGGER.error("getListByIndustryId","查询ChartEventIndustrySubMoneylevelYear失败", e);
			messageInfo.setStatus(10001);;
		}
		return messageInfo;
	}
			
	public MessageInfo<List<ChartEventIndustrySubMoneylevelYear>> getListByMoneyLevelId(Integer moneyLevelId){

		MessageInfo<List<ChartEventIndustrySubMoneylevelYear>> messageInfo = new MessageInfo<List<ChartEventIndustrySubMoneylevelYear>>();
		try {
			List<ChartEventIndustrySubMoneylevelYear> chartEventIndustrySubMoneylevelYearList = chartEventIndustrySubMoneylevelYearDAO.selectByMoneyLevelId(moneyLevelId);
			messageInfo.setData(chartEventIndustrySubMoneylevelYearList);
		} catch (Exception e) {
			LOGGER.error("getListByMoneyLevelId","查询ChartEventIndustrySubMoneylevelYear失败", e);
			messageInfo.setStatus(10001);;
		}
		return messageInfo;
	}
*/

	public MessageInfo<List<ChartEventIndustrySubMoneylevelYear>> selectByYearIndustrySubId(Integer[] years,Integer industrySubId){

		MessageInfo<List<ChartEventIndustrySubMoneylevelYear>> messageInfo = new MessageInfo<List<ChartEventIndustrySubMoneylevelYear>>();
		try {
			List<ChartEventIndustrySubMoneylevelYear> chartEventIndustrySubMoneylevelYearList = chartEventIndustrySubMoneylevelYearDAO.selectByYearIndustrySubId(years, industrySubId);
			messageInfo.setData(chartEventIndustrySubMoneylevelYearList);
		} catch (Exception e) {
			LOGGER.error("getListByYear","查询ChartEventIndustrySubMoneylevelYear失败", e);
			messageInfo.setStatus(10001);;
		}
		return messageInfo;
	}
		

}