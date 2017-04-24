

package com.gi.ctdn.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.dao.QuitTypeDAO;
import com.gi.xm.platform.view.common.MessageStatus;
import com.gi.xm.platform.view.common.MessageInfo;

import com.gi.ctdn.pojo.QuitType;

@Service("quitTypeBiz")
public class QuitTypeBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(QuitTypeBiz.class);

    @Autowired
	QuitTypeDAO quitTypeDAO;


	


    public MessageInfo<List<QuitType>> getAllQuitType(){

		MessageInfo<List<QuitType>> messageInfo = new MessageInfo<List<QuitType>>();
		try {
			List<QuitType> quitTypeList = quitTypeDAO.selectAll();
			messageInfo.setData( quitTypeList);
		} catch (Exception e) {
			LOGGER.error("getAllQuitType","查询全部QuitType失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
}