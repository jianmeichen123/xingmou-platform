

package com.gi.xm.platform.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.platform.dao.PostionDAO;

import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.MessageStatus;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.Postion;
import com.gi.xm.platform.query.PostionQuery;

@Service("postionBiz")
public class PostionBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(PostionBiz.class);

    @Autowired
	PostionDAO postionDAO;



	
	public Message<Integer> deletePostion(Long id){
		Message<Integer> message = new Message<Integer>();
		try {

			int result = postionDAO.deleteByPrimaryKey(id);
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete","删除失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	

    public Message<Long> createPostion(Postion postion){
		Message<Long> message = new Message<Long>();
		try {
									postionDAO.insert( postion );
			message.setData(postion.getId());

		} catch (Exception e) {
			LOGGER.error("createPostion","创建Postion失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	public Message<Integer> updatePostion(Postion postion){
		Message<Integer> message = new Message<Integer>();
		try {

			Postion postionLast = postionDAO.selectByPrimaryKeyForUpdate( postion.getId() );
			if( postionLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}

									int result = postionDAO.updateByPrimaryKey( postion );
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("updatePostion","更新Postion失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

		public Message<Postion> getPostion( Long id ){
		Message<Postion> message = new Message<Postion>();
		try {
			Postion postion = postionDAO.selectByPrimaryKey( id );
			message.setData(postion);

		} catch (Exception e) {
			LOGGER.error("getPostion","根据主键查询Postion失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    public Message<List<Postion>> getAllPostion(){

		Message<List<Postion>> message = new Message<List<Postion>>();
		try {
			List<Postion> postionList = postionDAO.selectAll();
			message.setData( postionList);
		} catch (Exception e) {
			LOGGER.error("getAllPostion","查询全部Postion失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	public Message<QueryResult<Postion>> queryPostion(PostionQuery postionQuery) {
		Message<QueryResult<Postion>> message = new Message<QueryResult<Postion>>();
		try {
			QueryResult<Postion> queryResult = new QueryResult<Postion>();
			PageHelper.startPage(postionQuery.getPageIndex(), postionQuery.getPageSize());
			List<Postion> postionList = postionDAO.queryPostion(postionQuery);
			PageInfo<Postion> pageInfo = new PageInfo<Postion>(postionList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(postionList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryPostion", "分页查询Postion失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	

}