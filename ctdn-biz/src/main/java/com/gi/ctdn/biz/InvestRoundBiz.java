

package com.gi.ctdn.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.dao.InvestRoundDAO;
import com.gi.xm.platform.view.common.MessageStatus;
import com.gi.xm.platform.view.common.MessageInfo;

import com.gi.ctdn.pojo.InvestRound;

@Service("investRoundBiz")
public class InvestRoundBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(InvestRoundBiz.class);

    @Autowired
	InvestRoundDAO investRoundDAO;


	


    public MessageInfo<List<InvestRound>> getAllInvestRound(){

		MessageInfo<List<InvestRound>> messageInfo = new MessageInfo<List<InvestRound>>();
		try {
			List<InvestRound> investRoundList = investRoundDAO.selectAll();
			messageInfo.setData( investRoundList);
		} catch (Exception e) {
			LOGGER.error("getAllInvestRound","查询全部InvestRound失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

	public MessageInfo<List<InvestRound>> getInvestRoundsByStatus(int status){

		MessageInfo<List<InvestRound>> messageInfo = new MessageInfo<List<InvestRound>>();
		try {
			List<InvestRound> investRoundList = investRoundDAO.selectInvestRoundsByStatus(status);
			messageInfo.setData( investRoundList);
		} catch (Exception e) {
			LOGGER.error("getInvestRoundsByStatus","查询InvestRounds失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
}