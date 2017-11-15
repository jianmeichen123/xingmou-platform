

package com.gi.ctdn.biz;

import com.gi.ctdn.dao.AppProjectDemandDAO;
import com.gi.ctdn.pojo.AppProjectDemand;
import com.gi.ctdn.view.common.MessageInfo;
import com.gi.ctdn.view.common.MessageStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("appProjectDemandBiz")
public class AppProjectDemandBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(AppProjectDemandBiz.class);

    @Autowired
	AppProjectDemandDAO appProjectDemandDAO;

	public MessageInfo<Integer> createAppProjectDemand(AppProjectDemand appProjectDemand){
		MessageInfo messageInfo = new MessageInfo();
		try{
			Integer result = appProjectDemandDAO.insert(appProjectDemand);
			messageInfo.setData(result);
			messageInfo.setStatus(MessageStatus.OK_CODE);
			messageInfo.setMessage(MessageStatus.OK_MESSAGE);
		}catch (Exception e){
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
			messageInfo.setMessage(MessageStatus.ERROR_MESSAGE);
			LOGGER.error(e.getMessage());
		}
		return messageInfo;
	}

}