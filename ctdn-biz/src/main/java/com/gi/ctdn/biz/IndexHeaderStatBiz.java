

package com.gi.ctdn.biz;

import java.util.Calendar;

import com.gi.ctdn.view.common.MessageStatus;
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
			IndexHeaderStat query = new IndexHeaderStat();
			query.setType(1);
			IndexHeaderStat indexHeaderStat = indexHeaderStatDAO.selectByTypeOrDate(query);
			messageInfo.setData( indexHeaderStat);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("getAllIndexHeaderStat","查询全部IndexHeaderStat失败", e);
			messageInfo = new MessageInfo<>(MessageStatus.ERROR_CODE,MessageStatus.ERROR_MESSAGE);
		}
		return messageInfo;
	}


//    public MessageInfo<IndexHeaderStat> getGGTotalHeaderStat(){
//
//		MessageInfo<IndexHeaderStat> messageInfo = new MessageInfo<IndexHeaderStat>();
//		try {
//			IndexHeaderStat query = new IndexHeaderStat();
//			query.setType(1);
//			IndexHeaderStat indexHeaderStat = indexHeaderStatDAO.selectByTypeOrDate(query);
//			messageInfo.setData( indexHeaderStat);
//		} catch (Exception e) {
//			LOGGER.error("getAllIndexHeaderStat","查询GGIndexHeaderStat失败", e);
//			messageInfo.setStatus(10001);
//		}
//		return messageInfo;
//	}


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
			LOGGER.error("getGGCurMonthHeaderStat","查询GGIndexHeaderStat失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

//	public MessageInfo<IndexHeaderStat> getStatAdd(){
//		MessageInfo<IndexHeaderStat> messageInfo = new MessageInfo<IndexHeaderStat>();
//		try {
//			IndexHeaderStat query = new IndexHeaderStat();
//			query.setType(2);
//			IndexHeaderStat indexHeaderStat = indexHeaderStatDAO.selectByTypeOrDate(query);
//			messageInfo.setData( indexHeaderStat);
//			messageInfo.setStatus(MessageStatus.OK_CODE);
//			messageInfo.setMessage(MessageStatus.OK_MESSAGE);
//		} catch (Exception e) {
//			LOGGER.error("getStatAdd","查询StatAdd失败", e);
//			messageInfo.setStatus(10001);
//		}
//		return messageInfo;
//	}

	public MessageInfo<IndexHeaderStat> queryHeaderStatCommon(IndexHeaderStat query){
		MessageInfo<IndexHeaderStat> messageInfo = new MessageInfo<IndexHeaderStat>();
		try {
			IndexHeaderStat indexHeaderStat = indexHeaderStatDAO.selectByTypeOrDate(query);
			messageInfo.setData( indexHeaderStat);
			messageInfo.setStatus(MessageStatus.OK_CODE);
			messageInfo.setMessage(MessageStatus.OK_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("queryHeaderStatCommon","查询HeaderStatCommon失败", e);
			messageInfo = new MessageInfo<>(MessageStatus.ERROR_CODE,MessageStatus.ERROR_MESSAGE);
		}
		return messageInfo;
	}
}