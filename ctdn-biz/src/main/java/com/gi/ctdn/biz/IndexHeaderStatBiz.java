

package com.gi.ctdn.biz;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.dao.IndexHeaderStatDAO;
import com.gi.ctdn.view.common.MessageInfo;

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
    
    
    public MessageInfo<IndexHeaderStat> getGGTotalHeaderStat(){

		MessageInfo<IndexHeaderStat> messageInfo = new MessageInfo<IndexHeaderStat>();
		try {
			IndexHeaderStat query = new IndexHeaderStat();
			query.setType(1);
			IndexHeaderStat indexHeaderStat = indexHeaderStatDAO.selectByTypeOrDate(query);
			messageInfo.setData( indexHeaderStat);
		} catch (Exception e) {
			LOGGER.error("getAllIndexHeaderStat","查询GGIndexHeaderStat失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}


	public MessageInfo<IndexHeaderStat> getGGCurMonthHeaderStat() {
		MessageInfo<IndexHeaderStat> messageInfo = new MessageInfo<IndexHeaderStat>();
		try {
			Calendar cal = Calendar.getInstance();
			IndexHeaderStat query = new IndexHeaderStat();
			query.setType(2);
			query.setYear(cal.get(Calendar.YEAR));
			query.setMonth(cal.get(Calendar.MONTH)+1);
			IndexHeaderStat indexHeaderStat = indexHeaderStatDAO.selectByTypeOrDate(query);
			messageInfo.setData( indexHeaderStat);
		} catch (Exception e) {
			LOGGER.error("getAllIndexHeaderStat","查询GGIndexHeaderStat失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
}