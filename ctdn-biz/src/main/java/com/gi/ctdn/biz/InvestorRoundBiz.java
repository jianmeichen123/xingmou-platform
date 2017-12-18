

package com.gi.ctdn.biz;

import com.gi.ctdn.dao.InvestorIndustryDAO;
import com.gi.ctdn.dao.InvestorRoundDAO;
import com.gi.ctdn.pojo.InvestorIndustry;
import com.gi.ctdn.pojo.InvestorRound;
import com.gi.ctdn.view.common.MessageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("InvestorRoundBiz")
public class InvestorRoundBiz {


	private static final Logger LOGGER = LoggerFactory.getLogger(InvestorRoundBiz.class);

    @Autowired
	InvestorRoundDAO indDao;


    public MessageInfo<List<InvestorRound>> getAllRound(){

		MessageInfo<List<InvestorRound>> messageInfo = new MessageInfo<List<InvestorRound>>();
		try {
			List<InvestorRound> roundList = indDao.selectAll();
			messageInfo.setData( roundList);
		} catch (Exception e) {
			LOGGER.error("getAllRound","查询investor全部round失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}



}