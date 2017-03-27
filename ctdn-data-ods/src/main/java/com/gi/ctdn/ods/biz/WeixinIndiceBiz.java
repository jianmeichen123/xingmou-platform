

package com.gi.ctdn.ods.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.ods.dao.WeixinIndiceDAO;
import com.gi.xm.platform.view.common.MessageStatus;
import com.gi.xm.platform.view.common.MessageInfo;

import com.gi.ctdn.ods.pojo.WeixinIndice;

@Service("weixinIndiceBiz")
public class WeixinIndiceBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(WeixinIndiceBiz.class);

    @Autowired
	WeixinIndiceDAO weixinIndiceDAO;


		
	public MessageInfo<List<WeixinIndice>> getListByWxid(String wxid){

		MessageInfo<List<WeixinIndice>> messageInfo = new MessageInfo<List<WeixinIndice>>();
		try {
			List<WeixinIndice> weixinIndiceList = weixinIndiceDAO.selectByWxid(wxid);
			messageInfo.setData(weixinIndiceList);
		} catch (Exception e) {
			LOGGER.error("getListByWxid","查询WeixinIndice失败", e);
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
		}
		return messageInfo;
	}
		


}