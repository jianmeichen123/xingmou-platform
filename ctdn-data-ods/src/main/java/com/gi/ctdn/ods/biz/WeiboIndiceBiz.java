

package com.gi.ctdn.ods.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.ods.dao.WeiboIndiceDAO;
import com.gi.ctdn.view.common.MessageStatus;
import com.gi.ctdn.view.common.MessageInfo;

import com.gi.ctdn.ods.pojo.WeiboIndice;

@Service("weiboIndiceBiz")
public class WeiboIndiceBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(WeiboIndiceBiz.class);

    @Autowired
	WeiboIndiceDAO weiboIndiceDAO;


		
	public MessageInfo<List<WeiboIndice>> getListByWbid(Long wbid){

		MessageInfo<List<WeiboIndice>> messageInfo = new MessageInfo<List<WeiboIndice>>();
		try {
			List<WeiboIndice> weiboIndiceList = weiboIndiceDAO.selectByWbid(wbid);
			messageInfo.setData(weiboIndiceList);
		} catch (Exception e) {
			LOGGER.error("getListByWbid","查询WeiboIndice失败", e);
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
		}
		return messageInfo;
	}
		


}