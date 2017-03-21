

package com.gi.ctdn.ods.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.ods.dao.AsoIosDownDAO;
import com.gi.xm.platform.view.common.MessageStatus;
import com.gi.xm.platform.view.common.MessageInfo;

import com.gi.ctdn.ods.pojo.AsoIosDown;

@Service("asoIosDownBiz")
public class AsoIosDownBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(AsoIosDownBiz.class);

    @Autowired
	AsoIosDownDAO asoIosDownDAO;


		
	public MessageInfo<List<AsoIosDown>> getListByAppid(Long appid){

		MessageInfo<List<AsoIosDown>> messageInfo = new MessageInfo<List<AsoIosDown>>();
		try {
			List<AsoIosDown> asoIosDownList = asoIosDownDAO.selectByAppid(appid);
			messageInfo.setData(asoIosDownList);
		} catch (Exception e) {
			LOGGER.error("getListByAppid","查询AsoIosDown失败", e);
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
		}
		return messageInfo;
	}
		


}