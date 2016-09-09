

package com.gi.xm.platform.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.platform.dao.UserDAO;

import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.MessageStatus;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.User;
import com.gi.xm.platform.query.UserQuery;

@Service("userBiz")
public class UserBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(UserBiz.class);

    @Autowired
	UserDAO userDAO;



	
	public Message<Integer> deleteUser(Long id){
		Message<Integer> message = new Message<Integer>();
		try {

			int result = userDAO.deleteByPrimaryKey(id);
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete","删除失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	

    public Message<Long> createUser(User user){
		Message<Long> message = new Message<Long>();
		try {
									userDAO.insert( user );
			message.setData(user.getId());

		} catch (Exception e) {
			LOGGER.error("createUser","创建User失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	public Message<Integer> updateUser(User user){
		Message<Integer> message = new Message<Integer>();
		try {

			User userLast = userDAO.selectByPrimaryKeyForUpdate( user.getId() );
			if( userLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}

									int result = userDAO.updateByPrimaryKey( user );
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("updateUser","更新User失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

		public Message<Integer> changeStatus(Long id,String status,String operatorId){
		Message<Integer> message = new Message<Integer>();
		try {

			User userLast = userDAO.selectByPrimaryKeyForUpdate(id );
			if( userLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}

			//TODO：其他判断

			int result = userDAO.changeStatus(id,status,operatorId);
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("changeStatus","更新User状态失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
		public Message<User> getUser( Long id ){
		Message<User> message = new Message<User>();
		try {
			User user = userDAO.selectByPrimaryKey( id );
			message.setData(user);

		} catch (Exception e) {
			LOGGER.error("getUser","根据主键查询User失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    public Message<List<User>> getAllUser(){

		Message<List<User>> message = new Message<List<User>>();
		try {
			List<User> userList = userDAO.selectAll();
			message.setData( userList);
		} catch (Exception e) {
			LOGGER.error("getAllUser","查询全部User失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	public Message<QueryResult<User>> queryUser(UserQuery userQuery) {
		Message<QueryResult<User>> message = new Message<QueryResult<User>>();
		try {
			QueryResult<User> queryResult = new QueryResult<User>();
			PageHelper.startPage(userQuery.getPageIndex(), userQuery.getPageSize());
			List<User> userList = userDAO.queryUser(userQuery);
			PageInfo<User> pageInfo = new PageInfo<User>(userList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(userList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryUser", "分页查询User失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	

}