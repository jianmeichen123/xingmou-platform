

package com.gi.ctdn.ods.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.ods.dao.QqAndroidDownDAO;
import com.gi.ctdn.view.common.MessageStatus;
import com.gi.ctdn.view.common.MessageInfo;

import com.gi.ctdn.ods.pojo.QqAndroidDown;

@Service("qqAndroidDownBiz")
public class QqAndroidDownBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(QqAndroidDownBiz.class);

    @Autowired
	QqAndroidDownDAO qqAndroidDownDAO;


		
	public MessageInfo<List<QqAndroidDown>> getListByAppid(Long appid){

		MessageInfo<List<QqAndroidDown>> messageInfo = new MessageInfo<List<QqAndroidDown>>();
		try {
			List<QqAndroidDown> qqAndroidDownList = qqAndroidDownDAO.selectByAppid(appid);
			messageInfo.setData(qqAndroidDownList);
		} catch (Exception e) {
			LOGGER.error("getListByAppid","查询QqAndroidDown失败", e);
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
		}
		return messageInfo;
	}
		


}