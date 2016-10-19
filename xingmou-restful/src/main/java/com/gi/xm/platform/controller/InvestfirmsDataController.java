package com.gi.xm.platform.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gi.xm.platform.facede.InvestfirmsFacede;
import com.gi.xm.platform.view.InvestfirmsInfo;
import com.gi.xm.platform.view.InvestfirmsQueryInfo;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.report.biz.InvestfirmsDataBiz;
import com.gi.xm.report.pojo.Area;
import com.gi.xm.report.pojo.InvestfirmsData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("tzjg")
public class InvestfirmsDataController {

	@Autowired
	private InvestfirmsDataBiz investfirmsDataBiz;

	

	@RequestMapping("search")
	@ResponseBody
	public MessageInfo<QueryResultInfo<InvestfirmsData>>  queryInvestfirms (InvestfirmsData investfirmsData) {
		if (investfirmsData.getOrder() != null&&investfirmsData.getOrderBy() != null){
			if (investfirmsData.getOrderBy().equalsIgnoreCase("createDate")){
				investfirmsData.setOrderBy("create_date");
			}else if (investfirmsData.getOrderBy().equalsIgnoreCase("investMonthRate")) {
				investfirmsData.setOrderBy("invest_month_rate");
			}else if (investfirmsData.getOrderBy().equalsIgnoreCase("investMoney")) {
				investfirmsData.setOrderBy("invest_money");
			}else if (investfirmsData.getOrderBy().equalsIgnoreCase("investNum")) {
				investfirmsData.setOrderBy("invest_num");
			}else {
				investfirmsData.setOrderBy("create_date");
			}
		}

		MessageInfo<QueryResultInfo<InvestfirmsData>> resultMessageInfo = investfirmsDataBiz.queryInvestfirmsData(investfirmsData);
		return resultMessageInfo;
	}
	@RequestMapping("top10InvestMoney")
	@ResponseBody
	public  MessageInfo<List<InvestfirmsData>>  top10InvestMoney () {
		MessageInfo<List<InvestfirmsData>> resultMessageInfo = investfirmsDataBiz.top10InvestMoney();
		return resultMessageInfo;
	}

	@RequestMapping("top10InvestNum")
	@ResponseBody
	public  MessageInfo<List<InvestfirmsData>>  top10InvestNum () {
		MessageInfo<List<InvestfirmsData>> resultMessageInfo = investfirmsDataBiz.top10InvestNum();
		return resultMessageInfo;
	}


	@RequestMapping("investfirmField")
	@ResponseBody
	public  MessageInfo<List<Area>> investfirmField() {
		MessageInfo<List<Area>> resultMessageInfo = investfirmsDataBiz.investfirmField();
		return resultMessageInfo;
	}


}
