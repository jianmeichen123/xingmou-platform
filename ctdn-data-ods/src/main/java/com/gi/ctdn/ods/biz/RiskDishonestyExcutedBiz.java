

package com.gi.ctdn.ods.biz;

import com.gi.ctdn.ods.dao.RiskDishonestyExcutedDAO;
import com.gi.ctdn.ods.pojo.RiskDishonestyExcuted;
import com.gi.ctdn.view.common.MessageInfo;
import com.gi.ctdn.view.common.MessageStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("riskDishonestyExcutedBiz")
public class RiskDishonestyExcutedBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(RiskDishonestyExcutedBiz.class);

    @Autowired
	RiskDishonestyExcutedDAO riskDishonestyExcutedDAO;

	public MessageInfo<List<RiskDishonestyExcuted>>getBySourceCode(String sourceCode){
		MessageInfo<List<RiskDishonestyExcuted>> messageInfo = new MessageInfo<List<RiskDishonestyExcuted>>();
		try {
			List<RiskDishonestyExcuted> riskDishonestyExcutedList =  riskDishonestyExcutedDAO.selectBySourceCode(sourceCode);
			messageInfo.setData( riskDishonestyExcutedList);
		} catch (Exception e) {
			LOGGER.error("getBySourceCode","查询RiskDishonestyExcuted失败", e);
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
		}
		return messageInfo;
	}
}