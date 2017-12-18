

package com.gi.ctdn.biz;

import com.gi.ctdn.dao.IndustryDAO;
import com.gi.ctdn.dao.InvestorIndustryDAO;
import com.gi.ctdn.dao.me.UserIndustryDAO;
import com.gi.ctdn.pojo.Industry;
import com.gi.ctdn.pojo.InvestorIndustry;
import com.gi.ctdn.pojo.me.UserIndustry;
import com.gi.ctdn.view.common.MessageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("InvestorIndustryBiz")
public class InvestorIndustryBiz {


	private static final Logger LOGGER = LoggerFactory.getLogger(InvestorIndustryBiz.class);

    @Autowired
	InvestorIndustryDAO indDao;


    public MessageInfo<List<InvestorIndustry>> getAllIndustry(){

		MessageInfo<List<InvestorIndustry>> messageInfo = new MessageInfo<List<InvestorIndustry>>();
		try {
			List<InvestorIndustry> industryList = indDao.selectAll();
			messageInfo.setData( industryList);
		} catch (Exception e) {
			LOGGER.error("getAllIndustry","查询investor全部Industry失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}



}