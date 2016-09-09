

package com.gi.xm.platform.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.platform.dao.InvestEventsInvestfirmDAO;

import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.MessageStatus;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.InvestEventsInvestfirm;
import com.gi.xm.platform.query.InvestEventsInvestfirmQuery;

@Service("investEventsInvestfirmBiz")
public class InvestEventsInvestfirmBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(InvestEventsInvestfirmBiz.class);

    @Autowired
	InvestEventsInvestfirmDAO investEventsInvestfirmDAO;



	
	public Message<Integer> deleteInvestEventsInvestfirm(Long id){
		Message<Integer> message = new Message<Integer>();
		try {

			int result = investEventsInvestfirmDAO.deleteByPrimaryKey(id);
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete","删除失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	

    public Message<Long> createInvestEventsInvestfirm(InvestEventsInvestfirm investEventsInvestfirm){
		Message<Long> message = new Message<Long>();
		try {
									investEventsInvestfirmDAO.insert( investEventsInvestfirm );
			message.setData(investEventsInvestfirm.getId());

		} catch (Exception e) {
			LOGGER.error("createInvestEventsInvestfirm","创建InvestEventsInvestfirm失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	public Message<Integer> updateInvestEventsInvestfirm(InvestEventsInvestfirm investEventsInvestfirm){
		Message<Integer> message = new Message<Integer>();
		try {

			InvestEventsInvestfirm investEventsInvestfirmLast = investEventsInvestfirmDAO.selectByPrimaryKeyForUpdate( investEventsInvestfirm.getId() );
			if( investEventsInvestfirmLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}

									int result = investEventsInvestfirmDAO.updateByPrimaryKey( investEventsInvestfirm );
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("updateInvestEventsInvestfirm","更新InvestEventsInvestfirm失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

		public Message<InvestEventsInvestfirm> getInvestEventsInvestfirm( Long id ){
		Message<InvestEventsInvestfirm> message = new Message<InvestEventsInvestfirm>();
		try {
			InvestEventsInvestfirm investEventsInvestfirm = investEventsInvestfirmDAO.selectByPrimaryKey( id );
			message.setData(investEventsInvestfirm);

		} catch (Exception e) {
			LOGGER.error("getInvestEventsInvestfirm","根据主键查询InvestEventsInvestfirm失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    public Message<List<InvestEventsInvestfirm>> getAllInvestEventsInvestfirm(){

		Message<List<InvestEventsInvestfirm>> message = new Message<List<InvestEventsInvestfirm>>();
		try {
			List<InvestEventsInvestfirm> investEventsInvestfirmList = investEventsInvestfirmDAO.selectAll();
			message.setData( investEventsInvestfirmList);
		} catch (Exception e) {
			LOGGER.error("getAllInvestEventsInvestfirm","查询全部InvestEventsInvestfirm失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	public Message<QueryResult<InvestEventsInvestfirm>> queryInvestEventsInvestfirm(InvestEventsInvestfirmQuery investEventsInvestfirmQuery) {
		Message<QueryResult<InvestEventsInvestfirm>> message = new Message<QueryResult<InvestEventsInvestfirm>>();
		try {
			QueryResult<InvestEventsInvestfirm> queryResult = new QueryResult<InvestEventsInvestfirm>();
			PageHelper.startPage(investEventsInvestfirmQuery.getPageIndex(), investEventsInvestfirmQuery.getPageSize());
			List<InvestEventsInvestfirm> investEventsInvestfirmList = investEventsInvestfirmDAO.queryInvestEventsInvestfirm(investEventsInvestfirmQuery);
			PageInfo<InvestEventsInvestfirm> pageInfo = new PageInfo<InvestEventsInvestfirm>(investEventsInvestfirmList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(investEventsInvestfirmList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryInvestEventsInvestfirm", "分页查询InvestEventsInvestfirm失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	

}