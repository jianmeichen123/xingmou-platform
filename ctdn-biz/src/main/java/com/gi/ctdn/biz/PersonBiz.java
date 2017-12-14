

package com.gi.ctdn.biz;

import com.gi.ctdn.dao.StartUpDAO;
import com.gi.ctdn.pojo.StartUp;
import com.gi.ctdn.view.common.MessageInfo;
import com.gi.ctdn.view.common.MessageStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("startUpBiz")
public class PersonBiz {


	private static final Logger LOGGER = LoggerFactory.getLogger(PersonBiz.class);

	@Autowired
	StartUpDAO dao;

	public MessageInfo<StartUp> queryStartUpBaseInfo(String code) {

		MessageInfo<StartUp> message = new MessageInfo<StartUp>();
		try {
			StartUp startUp = dao.selectEntityByCode(code);
			if(startUp != null){
				message.setData(startUp);
			}
		} catch (Exception e) {
			LOGGER.error("getStartUpByCode", "查询创业者基本信息失败", e);
			message.setStatus(MessageStatus.ERROR_CODE);
		}
		return message;
	}


}