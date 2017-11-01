

package com.gi.ctdn.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.dao.EquityRateDAO;
import com.gi.ctdn.view.common.MessageInfo;

import com.gi.ctdn.pojo.EquityRate;

@Service("equityRateBiz")
public class EquityRateBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(EquityRateBiz.class);

    @Autowired
	EquityRateDAO equityRateDAO;


	


    public MessageInfo<List<EquityRate>> getAllEquityRate(){

		MessageInfo<List<EquityRate>> messageInfo = new MessageInfo<List<EquityRate>>();
		try {
			List<EquityRate> equityRateList = equityRateDAO.selectAll();
			messageInfo.setData( equityRateList);
		} catch (Exception e) {
			LOGGER.error("getAllEquityRate","查询全部EquityRate失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
}