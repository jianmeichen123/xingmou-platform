

package com.gi.xm.platform.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.platform.dao.LabelDAO;

import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.MessageStatus;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.Label;
import com.gi.xm.platform.query.LabelQuery;

@Service("labelBiz")
public class LabelBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(LabelBiz.class);

    @Autowired
	LabelDAO labelDAO;



	
	public Message<Integer> deleteLabel(Long id){
		Message<Integer> message = new Message<Integer>();
		try {

			int result = labelDAO.deleteByPrimaryKey(id);
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete","删除失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	

    public Message<Long> createLabel(Label label){
		Message<Long> message = new Message<Long>();
		try {
									labelDAO.insert( label );
			message.setData(label.getId());

		} catch (Exception e) {
			LOGGER.error("createLabel","创建Label失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	public Message<Integer> updateLabel(Label label){
		Message<Integer> message = new Message<Integer>();
		try {

			Label labelLast = labelDAO.selectByPrimaryKeyForUpdate( label.getId() );
			if( labelLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}

									int result = labelDAO.updateByPrimaryKey( label );
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("updateLabel","更新Label失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

		public Message<Label> getLabel( Long id ){
		Message<Label> message = new Message<Label>();
		try {
			Label label = labelDAO.selectByPrimaryKey( id );
			message.setData(label);

		} catch (Exception e) {
			LOGGER.error("getLabel","根据主键查询Label失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    public Message<List<Label>> getAllLabel(){

		Message<List<Label>> message = new Message<List<Label>>();
		try {
			List<Label> labelList = labelDAO.selectAll();
			message.setData( labelList);
		} catch (Exception e) {
			LOGGER.error("getAllLabel","查询全部Label失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	public Message<QueryResult<Label>> queryLabel(LabelQuery labelQuery) {
		Message<QueryResult<Label>> message = new Message<QueryResult<Label>>();
		try {
			QueryResult<Label> queryResult = new QueryResult<Label>();
			PageHelper.startPage(labelQuery.getPageIndex(), labelQuery.getPageSize());
			List<Label> labelList = labelDAO.queryLabel(labelQuery);
			PageInfo<Label> pageInfo = new PageInfo<Label>(labelList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(labelList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryLabel", "分页查询Label失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	

}