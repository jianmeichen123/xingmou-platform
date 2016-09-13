

package com.gi.xm.platform.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.platform.dao.InvestEventsDAO;

import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.MessageStatus;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.InvestEvents;
import com.gi.xm.platform.query.InvestEventsQuery;

@Service("investEventsBiz")
public class InvestEventsBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(InvestEventsBiz.class);

    @Autowired
	InvestEventsDAO investEventsDAO;



	
	public Message<Integer> deleteInvestEvents(Long id){
		Message<Integer> message = new Message<Integer>();
		try {

			int result = investEventsDAO.deleteByPrimaryKey(id);
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete","删除失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	

    public Message<Long> createInvestEvents(InvestEvents investEvents){
		Message<Long> message = new Message<Long>();
		try {
						        							investEventsDAO.insert( investEvents );
			message.setData(investEvents.getId());

		} catch (Exception e) {
			LOGGER.error("createInvestEvents","创建InvestEvents失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	public Message<Integer> updateInvestEvents(InvestEvents investEvents){
		Message<Integer> message = new Message<Integer>();
		try {

			InvestEvents investEventsLast = investEventsDAO.selectByPrimaryKeyForUpdate( investEvents.getId() );
			if( investEventsLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}

						        							int result = investEventsDAO.updateByPrimaryKey( investEvents );
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("updateInvestEvents","更新InvestEvents失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

		public Message<InvestEvents> getInvestEvents( Long id ){
		Message<InvestEvents> message = new Message<InvestEvents>();
		try {
			InvestEvents investEvents = investEventsDAO.selectByPrimaryKey( id );
			message.setData(investEvents);

		} catch (Exception e) {
			LOGGER.error("getInvestEvents","根据主键查询InvestEvents失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    public Message<List<InvestEvents>> getAllInvestEvents(){

		Message<List<InvestEvents>> message = new Message<List<InvestEvents>>();
		try {
			List<InvestEvents> investEventsList = investEventsDAO.selectAll();
			message.setData( investEventsList);
		} catch (Exception e) {
			LOGGER.error("getAllInvestEvents","查询全部InvestEvents失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	public Message<QueryResult<InvestEvents>> queryInvestEvents(InvestEventsQuery investEventsQuery) {
		Message<QueryResult<InvestEvents>> message = new Message<QueryResult<InvestEvents>>();
		try {
			QueryResult<InvestEvents> queryResult = new QueryResult<InvestEvents>();
			PageHelper.startPage(investEventsQuery.getPageIndex(), investEventsQuery.getPageSize());
			List<InvestEvents> investEventsList = investEventsDAO.queryInvestEvents(investEventsQuery);
			PageInfo<InvestEvents> pageInfo = new PageInfo<InvestEvents>(investEventsList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(investEventsList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryInvestEvents", "分页查询InvestEvents失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

}