

package com.gi.ctdn.ods.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.ods.dao.AsoIosRateDAO;
import com.gi.xm.platform.view.common.MessageStatus;
import com.gi.xm.platform.view.common.MessageInfo;

import com.gi.ctdn.ods.pojo.AsoIosRate;

@Service("asoIosRateBiz")
public class AsoIosRateBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(AsoIosRateBiz.class);

    @Autowired
	AsoIosRateDAO asoIosRateDAO;


		
	public MessageInfo<List<AsoIosRate>> getListByAppid(Long appid){

		MessageInfo<List<AsoIosRate>> messageInfo = new MessageInfo<List<AsoIosRate>>();
		try {
			List<AsoIosRate> asoIosRateList = asoIosRateDAO.selectByAppid(appid);
			messageInfo.setData(asoIosRateList);
		} catch (Exception e) {
			LOGGER.error("getListByAppid","查询AsoIosRate失败", e);
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
		}
		return messageInfo;
	}
		


}