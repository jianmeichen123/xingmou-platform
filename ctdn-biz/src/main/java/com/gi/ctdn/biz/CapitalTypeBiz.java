

package com.gi.ctdn.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.dao.CapitalTypeDAO;
import com.gi.xm.platform.view.common.MessageStatus;
import com.gi.xm.platform.view.common.MessageInfo;

import com.gi.ctdn.pojo.CapitalType;

@Service("capitalTypeBiz")
public class CapitalTypeBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(CapitalTypeBiz.class);

    @Autowired
	CapitalTypeDAO capitalTypeDAO;


	


    public MessageInfo<List<CapitalType>> getAllCapitalType(){

		MessageInfo<List<CapitalType>> messageInfo = new MessageInfo<List<CapitalType>>();
		try {
			List<CapitalType> capitalTypeList = capitalTypeDAO.selectAll();
			messageInfo.setData( capitalTypeList);
		} catch (Exception e) {
			LOGGER.error("getAllCapitalType","查询全部CapitalType失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
}