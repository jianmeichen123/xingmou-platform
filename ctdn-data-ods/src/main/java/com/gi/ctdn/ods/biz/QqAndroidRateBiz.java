

package com.gi.ctdn.ods.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.ods.dao.QqAndroidRateDAO;
import com.gi.ctdn.view.common.MessageStatus;
import com.gi.ctdn.view.common.MessageInfo;

import com.gi.ctdn.ods.pojo.QqAndroidRate;

@Service("qqAndroidRateBiz")
public class QqAndroidRateBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(QqAndroidRateBiz.class);

    @Autowired
	QqAndroidRateDAO qqAndroidRateDAO;


		
	public MessageInfo<List<QqAndroidRate>> getListByAppid(Long appid){

		MessageInfo<List<QqAndroidRate>> messageInfo = new MessageInfo<List<QqAndroidRate>>();
		try {
			List<QqAndroidRate> qqAndroidRateList = qqAndroidRateDAO.selectByAppid(appid);
			messageInfo.setData(qqAndroidRateList);
		} catch (Exception e) {
			LOGGER.error("getListByAppid","查询QqAndroidRate失败", e);
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
		}
		return messageInfo;
	}
		


}