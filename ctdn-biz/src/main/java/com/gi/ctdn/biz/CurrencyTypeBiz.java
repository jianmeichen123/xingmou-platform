

package com.gi.ctdn.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.dao.CurrencyTypeDAO;
import com.gi.xm.platform.view.common.MessageStatus;
import com.gi.xm.platform.view.common.MessageInfo;

import com.gi.ctdn.pojo.CurrencyType;

@Service("currencyTypeBiz")
public class CurrencyTypeBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(CurrencyTypeBiz.class);

    @Autowired
	CurrencyTypeDAO currencyTypeDAO;


	


    public MessageInfo<List<CurrencyType>> getAllCurrencyType(){

		MessageInfo<List<CurrencyType>> messageInfo = new MessageInfo<List<CurrencyType>>();
		try {
			List<CurrencyType> currencyTypeList = currencyTypeDAO.selectAll();
			messageInfo.setData( currencyTypeList);
		} catch (Exception e) {
			LOGGER.error("getAllCurrencyType","查询全部CurrencyType失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
}