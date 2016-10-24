

package com.gi.xm.report.biz;

import java.util.List;

import com.gi.xm.report.pojo.Area;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.report.dao.InvestfirmsDataDAO;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.report.pojo.InvestfirmsData;

@Service("investfirmsDataBiz")
public class InvestfirmsDataBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(InvestfirmsDataBiz.class);

    @Autowired
	InvestfirmsDataDAO investfirmsDataDAO;




	public MessageInfo<QueryResultInfo<InvestfirmsData>> queryInvestfirmsData(InvestfirmsData investfirmsDataQuery) {
		MessageInfo<QueryResultInfo<InvestfirmsData>> message = new MessageInfo<QueryResultInfo<InvestfirmsData>>();
		try {
			QueryResultInfo<InvestfirmsData> queryResult = new QueryResultInfo<InvestfirmsData>();
			PageHelper.startPage(investfirmsDataQuery.getPageIndex(), investfirmsDataQuery.getPageSize());
			List<InvestfirmsData> investfirmsDataList = investfirmsDataDAO.queryInvestfirmsData(investfirmsDataQuery);
			PageInfo<InvestfirmsData> pageInfo = new PageInfo<InvestfirmsData>(investfirmsDataList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(investfirmsDataList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryInvestfirmsData", "分页查询queryInvestfirmsData失败", e);
			message.setStatus(10001);
		}
		return message;
	}


	public MessageInfo<List<Area>> investfirmField() {

		MessageInfo<List<Area>> messageInfo = new MessageInfo<List<Area>>();
		try {
			List<Area> areaList = investfirmsDataDAO.investfirmField();
			messageInfo.setData(areaList);
		} catch (Exception e) {
			LOGGER.error("investfirmField","查询investfirmField失败", e);
			messageInfo.setStatus(10001);;
		}
		return messageInfo;

	}
	public  MessageInfo<List<InvestfirmsData>>top10InvestMoney(){
		MessageInfo<List<InvestfirmsData>> messageInfo = new MessageInfo<List<InvestfirmsData>>();
		try {
			List<InvestfirmsData> investfirmsDataList = investfirmsDataDAO.top10InvestMoney();
			messageInfo.setData(investfirmsDataList);
		} catch (Exception e) {
			LOGGER.error("investfirmsDataList","查询investfirmsDataList失败", e);
			messageInfo.setStatus(10001);;
		}
		return messageInfo;

	}
	public  MessageInfo<List<InvestfirmsData>> top10InvestNum() {
		MessageInfo<List<InvestfirmsData>> messageInfo = new MessageInfo<List<InvestfirmsData>>();
		try {
			List<InvestfirmsData> investfirmsDataList = investfirmsDataDAO.top10InvestNum();
			messageInfo.setData(investfirmsDataList);
		} catch (Exception e) {
			LOGGER.error("top10InvestNum","查询top10InvestNumt失败", e);
			messageInfo.setStatus(10001);;
		}
		return messageInfo;
	}
}