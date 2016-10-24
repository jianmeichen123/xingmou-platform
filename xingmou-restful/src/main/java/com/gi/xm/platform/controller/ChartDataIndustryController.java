package com.gi.xm.platform.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.report.biz.ChartDataIndustryBiz;
import com.gi.xm.report.pojo.ChartDataIndustry;
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
    
    

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		return new ModelAndView("chartDataIndustry/index", modelMap);
	}


	
	/**
	 * 查询投资事件行业分布
	 * @param chartDataIndustryQueryInfo
	 * @return
	 */
	@RequestMapping("pop")
	@ResponseBody
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
