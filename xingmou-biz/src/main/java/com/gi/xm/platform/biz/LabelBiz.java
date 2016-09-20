

package com.gi.xm.platform.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.MessageStatus;
import com.gi.xm.platform.dao.LabelDAO;
import com.gi.xm.platform.pojo.Label;
import com.gi.xm.platform.pojo.ProjectPersonStudy;

@Service("labelBiz")
public class LabelBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(LabelBiz.class);

    @Autowired
	LabelDAO labelDAO;

		
	public Message<List<Label>> getListByTypeRelationId(Integer type, Long relationId){

		Message<List<Label>> message = new Message<List<Label>>();
		try {
			List<Label> labelList = labelDAO.selectByTypeRelationId(type, relationId);
			message.setData(labelList);
		} catch (Exception e) {
			LOGGER.error("getListByTypeRelationId","查询Label失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}


	public Message<List<Label>> getListByTypeRelationId(Integer type, List<Integer> idList) {
		Message<List<Label>> message = new Message<List<Label>>();
		try {
			List<Label> labelList = labelDAO.selectByIdList(type, idList);
			message.setData(labelList);
		} catch (Exception e) {
			LOGGER.error("getListByTypeRelationId","查询Label失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
}