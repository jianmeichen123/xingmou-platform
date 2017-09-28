

package com.gi.ctdn.biz;

import com.gi.ctdn.dao.EventIndustryMonthDAO;
import com.gi.ctdn.pojo.EventIndustryMonth;
import com.gi.ctdn.pojo.EventIndustryMonthChart;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.MessageStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("eventIndustryMonthBiz")
public class EventIndustryMonthBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(EventIndustryMonthBiz.class);

    @Autowired
	EventIndustryMonthDAO eventIndustryMonthDAO;


	public MessageInfo<EventIndustryMonthChart> getChartDataByCondition(EventIndustryMonth eventIndustryMonth){

		MessageInfo<EventIndustryMonthChart> messageInfo = new MessageInfo<EventIndustryMonthChart>();
		try {
			List<EventIndustryMonthChart> eventIndustryMonthList = eventIndustryMonthDAO.select(eventIndustryMonth);
			List<String> industryNameList = new ArrayList<>();
			EventIndustryMonthChart entity = new EventIndustryMonthChart();

			List<Integer> round1 = new ArrayList<Integer>();
			List<Integer> round2 = new ArrayList<Integer>();
			List<Integer> round3 = new ArrayList<Integer>();
			List<Integer> round4 = new ArrayList<Integer>();
			List<Integer> round5 = new ArrayList<Integer>();
			List<Integer> round6 = new ArrayList<Integer>();
			List<Integer> round7 = new ArrayList<Integer>();

			//mysql查询结果 行业-轮次 数据结构行转列
			for(EventIndustryMonthChart tmp:eventIndustryMonthList){
				industryNameList.add(tmp.getIndustryname());
				round1.add(tmp.getRounda());
				round2.add(tmp.getRoundb());
				round3.add(tmp.getRoundc());
				round4.add(tmp.getRoundd());
				round5.add(tmp.getRounde());
				round6.add(tmp.getRoundf());
				round7.add(tmp.getRoundg());
			}
			List<List<Integer>> roundNumList = new ArrayList<List<Integer>>();
			roundNumList.add(round1);
			roundNumList.add(round2);
			roundNumList.add(round3);
			roundNumList.add(round4);
			roundNumList.add(round5);
			roundNumList.add(round6);
			roundNumList.add(round7);

			entity.setRoundNumList(roundNumList);
			entity.setIndustryNameList(industryNameList);
			messageInfo.setData(entity);
		} catch (Exception e) {
			LOGGER.error("getChartDataByCondition","查询EventIndustryMonthChart失败", e);
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
		}
		return messageInfo;
	}
}