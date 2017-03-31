

package com.gi.ctdn.ods.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.ods.dao.QqAndroidRateDailyDAO;
import com.gi.xm.platform.view.common.MessageStatus;
import com.gi.xm.platform.view.common.MessageInfo;

import com.gi.ctdn.ods.pojo.QqAndroidRateDaily;

@Service("qqAndroidRateDailyBiz")
public class QqAndroidRateDailyBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(QqAndroidRateDailyBiz.class);

    @Autowired
	QqAndroidRateDailyDAO qqAndroidRateDailyDAO;


		
	public MessageInfo<List<QqAndroidRateDaily>> getListByAppid(Long appid){

		MessageInfo<List<QqAndroidRateDaily>> messageInfo = new MessageInfo<List<QqAndroidRateDaily>>();
		try {
			List<QqAndroidRateDaily> qqAndroidRateDailyList = qqAndroidRateDailyDAO.selectByAppid(appid);
			messageInfo.setData(qqAndroidRateDailyList);
		} catch (Exception e) {
			LOGGER.error("getListByAppid","查询QqAndroidRateDaily失败", e);
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
		}
		return messageInfo;
	}
		


}