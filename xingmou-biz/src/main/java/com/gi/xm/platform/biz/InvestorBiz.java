

package com.gi.xm.platform.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.platform.dao.InvestorDAO;

import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.MessageStatus;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.Investor;
import com.gi.xm.platform.query.InvestorQuery;

@Service("investorBiz")
public class InvestorBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(InvestorBiz.class);

    @Autowired
	InvestorDAO investorDAO;



	
	public Message<Integer> deleteInvestor(Long id){
		Message<Integer> message = new Message<Integer>();
		try {

			int result = investorDAO.deleteByPrimaryKey(id);
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete","删除失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	

    public Message<Long> createInvestor(Investor investor){
		Message<Long> message = new Message<Long>();
		try {
									investorDAO.insert( investor );
			message.setData(investor.getId());

		} catch (Exception e) {
			LOGGER.error("createInvestor","创建Investor失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	public Message<Integer> updateInvestor(Investor investor){
		Message<Integer> message = new Message<Integer>();
		try {

			Investor investorLast = investorDAO.selectByPrimaryKeyForUpdate( investor.getId() );
			if( investorLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}

									int result = investorDAO.updateByPrimaryKey( investor );
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("updateInvestor","更新Investor失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

		public Message<Investor> getInvestor( Long id ){
		Message<Investor> message = new Message<Investor>();
		try {
			Investor investor = investorDAO.selectByPrimaryKey( id );
			message.setData(investor);

		} catch (Exception e) {
			LOGGER.error("getInvestor","根据主键查询Investor失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    public Message<List<Investor>> getAllInvestor(){

		Message<List<Investor>> message = new Message<List<Investor>>();
		try {
			List<Investor> investorList = investorDAO.selectAll();
			message.setData( investorList);
		} catch (Exception e) {
			LOGGER.error("getAllInvestor","查询全部Investor失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	public Message<QueryResult<Investor>> queryInvestor(InvestorQuery investorQuery) {
		Message<QueryResult<Investor>> message = new Message<QueryResult<Investor>>();
		try {
			QueryResult<Investor> queryResult = new QueryResult<Investor>();
			PageHelper.startPage(investorQuery.getPageIndex(), investorQuery.getPageSize());
			List<Investor> investorList = investorDAO.queryInvestor(investorQuery);
			PageInfo<Investor> pageInfo = new PageInfo<Investor>(investorList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(investorList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryInvestor", "分页查询Investor失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	

}