

package com.gi.ctdn.biz;

import com.gi.ctdn.dao.InvestStagesDAO;
import com.gi.ctdn.pojo.InvestStages;
import com.gi.ctdn.view.common.MessageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("investStagesBiz")
public class InvestStagesBiz {


	private static final Logger LOGGER = LoggerFactory.getLogger(InvestStagesBiz.class);

    @Autowired
	InvestStagesDAO investStagesDAO;


	
    public MessageInfo<List<InvestStages>> getAllInvestStages(){

		MessageInfo<List<InvestStages>> messageInfo = new MessageInfo<List<InvestStages>>();
		try {
			List<InvestStages> investStagesList = investStagesDAO.selectAll();
			messageInfo.setData( investStagesList);
		} catch (Exception e) {
			LOGGER.error("getAllInvestStages","查询全部InvestRound失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
}