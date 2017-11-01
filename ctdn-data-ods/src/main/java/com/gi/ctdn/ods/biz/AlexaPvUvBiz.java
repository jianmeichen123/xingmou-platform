

package com.gi.ctdn.ods.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.ods.dao.AlexaPvUvDAO;
import com.gi.ctdn.view.common.MessageStatus;
import com.gi.ctdn.view.common.MessageInfo;

import com.gi.ctdn.ods.pojo.AlexaPvUv;

@Service("alexaPvUvBiz")
public class AlexaPvUvBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(AlexaPvUvBiz.class);

    @Autowired
	AlexaPvUvDAO alexaPvUvDAO;


		
	public MessageInfo<List<AlexaPvUv>> getListByCode(String code){

		MessageInfo<List<AlexaPvUv>> messageInfo = new MessageInfo<List<AlexaPvUv>>();
		try {
			List<AlexaPvUv> alexaPvUvList = alexaPvUvDAO.selectByCode(code);
			messageInfo.setData(alexaPvUvList);
		} catch (Exception e) {
			LOGGER.error("getListByCode","查询AlexaPvUv失败", e);
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
		}
		return messageInfo;
	}

	public MessageInfo<List<AlexaPvUv>> getListByDoamin(String domain){

		MessageInfo<List<AlexaPvUv>> messageInfo = new MessageInfo<List<AlexaPvUv>>();
		try {
			List<AlexaPvUv> alexaPvUvList = alexaPvUvDAO.selectByDomain(domain);
			messageInfo.setData(alexaPvUvList);
		} catch (Exception e) {
			LOGGER.error("getListByCode","查询OpIndiceSummary失败", e);
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
		}
		return messageInfo;
	}


}