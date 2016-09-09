

package com.gi.xm.platform.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.platform.dao.MoneyLevelDAO;

import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.MessageStatus;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.MoneyLevel;
import com.gi.xm.platform.query.MoneyLevelQuery;

@Service("moneyLevelBiz")
public class MoneyLevelBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(MoneyLevelBiz.class);

    @Autowired
	MoneyLevelDAO moneyLevelDAO;



	
	public Message<Integer> deleteMoneyLevel(Integer id){
		Message<Integer> message = new Message<Integer>();
		try {

			int result = moneyLevelDAO.deleteByPrimaryKey(id);
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete","删除失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	

    public Message<Integer> createMoneyLevel(MoneyLevel moneyLevel){
		Message<Integer> message = new Message<Integer>();
		try {
									moneyLevelDAO.insert( moneyLevel );
			message.setData(moneyLevel.getId());

		} catch (Exception e) {
			LOGGER.error("createMoneyLevel","创建MoneyLevel失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	public Message<Integer> updateMoneyLevel(MoneyLevel moneyLevel){
		Message<Integer> message = new Message<Integer>();
		try {

			MoneyLevel moneyLevelLast = moneyLevelDAO.selectByPrimaryKeyForUpdate( moneyLevel.getId() );
			if( moneyLevelLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}

									int result = moneyLevelDAO.updateByPrimaryKey( moneyLevel );
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("updateMoneyLevel","更新MoneyLevel失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

		public Message<MoneyLevel> getMoneyLevel( Integer id ){
		Message<MoneyLevel> message = new Message<MoneyLevel>();
		try {
			MoneyLevel moneyLevel = moneyLevelDAO.selectByPrimaryKey( id );
			message.setData(moneyLevel);

		} catch (Exception e) {
			LOGGER.error("getMoneyLevel","根据主键查询MoneyLevel失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    public Message<List<MoneyLevel>> getAllMoneyLevel(){

		Message<List<MoneyLevel>> message = new Message<List<MoneyLevel>>();
		try {
			List<MoneyLevel> moneyLevelList = moneyLevelDAO.selectAll();
			message.setData( moneyLevelList);
		} catch (Exception e) {
			LOGGER.error("getAllMoneyLevel","查询全部MoneyLevel失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	public Message<QueryResult<MoneyLevel>> queryMoneyLevel(MoneyLevelQuery moneyLevelQuery) {
		Message<QueryResult<MoneyLevel>> message = new Message<QueryResult<MoneyLevel>>();
		try {
			QueryResult<MoneyLevel> queryResult = new QueryResult<MoneyLevel>();
			PageHelper.startPage(moneyLevelQuery.getPageIndex(), moneyLevelQuery.getPageSize());
			List<MoneyLevel> moneyLevelList = moneyLevelDAO.queryMoneyLevel(moneyLevelQuery);
			PageInfo<MoneyLevel> pageInfo = new PageInfo<MoneyLevel>(moneyLevelList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(moneyLevelList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryMoneyLevel", "分页查询MoneyLevel失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	

}