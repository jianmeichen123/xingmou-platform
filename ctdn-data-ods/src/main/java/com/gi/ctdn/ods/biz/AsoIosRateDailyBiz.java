

package com.gi.ctdn.ods.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.ods.dao.AsoIosRateDailyDAO;
import com.gi.xm.platform.view.common.MessageStatus;
import com.gi.xm.platform.view.common.MessageInfo;

import com.gi.ctdn.ods.pojo.AsoIosRateDaily;

@Service("asoIosRateDailyBiz")
public class AsoIosRateDailyBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(AsoIosRateDailyBiz.class);

    @Autowired
	AsoIosRateDailyDAO asoIosRateDailyDAO;


		
	public MessageInfo<List<AsoIosRateDaily>> getListByAppid(Long appid){

		MessageInfo<List<AsoIosRateDaily>> messageInfo = new MessageInfo<List<AsoIosRateDaily>>();
		try {
			List<AsoIosRateDaily> asoIosRateDailyList = asoIosRateDailyDAO.selectByAppid(appid);
			messageInfo.setData(asoIosRateDailyList);
		} catch (Exception e) {
			LOGGER.error("getListByAppid","查询AsoIosRateDaily失败", e);
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
		}
		return messageInfo;
	}
		


}