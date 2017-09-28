

package com.gi.ctdn.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.dao.IndexHeaderStatDAO;
import com.gi.xm.platform.view.common.MessageStatus;
import com.gi.xm.platform.view.common.MessageInfo;

import com.gi.ctdn.pojo.IndexHeaderStat;

@Service("indexHeaderStatBiz")
public class IndexHeaderStatBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(IndexHeaderStatBiz.class);

    @Autowired
	IndexHeaderStatDAO indexHeaderStatDAO;

    public MessageInfo<IndexHeaderStat> getIndexHeaderStat(){

		MessageInfo<IndexHeaderStat> messageInfo = new MessageInfo<IndexHeaderStat>();
		try {
			IndexHeaderStat indexHeaderStat = indexHeaderStatDAO.select();
			messageInfo.setData( indexHeaderStat);
		} catch (Exception e) {
			LOGGER.error("getAllIndexHeaderStat","查询全部IndexHeaderStat失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
}