package com.gi.xm.platform.controller;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.report.biz.ChartDataIndustryBiz;
import com.gi.xm.report.pojo.ChartDataIndustry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
/**
 * 事件行业分布气泡图
 * @author zhangchunyuan
 *
 */
@Controller
@RequestMapping("chartDataIndustry")
public class ChartDataIndustryController {

	@Autowired
	private ChartDataIndustryBiz chartDataIndustryBiz;
    
	/**
	 * 查询投资事件行业分布
	 * @param chartDataIndustryQueryInfo
	 * @return
	 */
	@RequestMapping("pop")
	@ResponseBody
	@Cacheable(value = "pop",keyGenerator = "reportKG")
	public MessageInfo pop () {
		MessageInfo<List<ChartDataIndustry>> resultMessageInfo = chartDataIndustryBiz.queryIndustryDistribution();
		if(!resultMessageInfo.isSuccess()){
			return resultMessageInfo;
		}
		
		MessageInfo<List<List<Object>>>  message = new MessageInfo<List<List<Object>>>();
		List<ChartDataIndustry> results = resultMessageInfo.getData();
		
		List<List<Object>> data = new ArrayList<List<Object>>();
		for(ChartDataIndustry  cd : results){
			List<Object> ls = new ArrayList<Object>();
			ls.add(cd.getInvestedNum());
			ls.add(cd.getProjectNum());
			ls.add(cd.getInvestedNum());
			ls.add(cd.getInvestedMoney());
			ls.add(cd.getIndustryName());
			data.add(ls);
		}
		message.setData(data);
		return message;
	}
	

	
		
}
