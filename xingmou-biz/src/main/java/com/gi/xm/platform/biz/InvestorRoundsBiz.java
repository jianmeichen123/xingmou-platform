

package com.gi.xm.platform.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.platform.dao.InvestorRoundsDAO;

import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.MessageStatus;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.InvestorRounds;
import com.gi.xm.platform.query.InvestorRoundsQuery;

@Service("investorRoundsBiz")
public class InvestorRoundsBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(InvestorRoundsBiz.class);

    @Autowired
	InvestorRoundsDAO investorRoundsDAO;



	
	public Message<Integer> deleteInvestorRounds(Long id){
		Message<Integer> message = new Message<Integer>();
		try {

			int result = investorRoundsDAO.deleteByPrimaryKey(id);
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete","删除失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	

    public Message<Long> createInvestorRounds(InvestorRounds investorRounds){
		Message<Long> message = new Message<Long>();
		try {
									investorRoundsDAO.insert( investorRounds );
			message.setData(investorRounds.getId());

		} catch (Exception e) {
			LOGGER.error("createInvestorRounds","创建InvestorRounds失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	public Message<Integer> updateInvestorRounds(InvestorRounds investorRounds){
		Message<Integer> message = new Message<Integer>();
		try {

			InvestorRounds investorRoundsLast = investorRoundsDAO.selectByPrimaryKeyForUpdate( investorRounds.getId() );
			if( investorRoundsLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}

									int result = investorRoundsDAO.updateByPrimaryKey( investorRounds );
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("updateInvestorRounds","更新InvestorRounds失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

		public Message<InvestorRounds> getInvestorRounds( Long id ){
		Message<InvestorRounds> message = new Message<InvestorRounds>();
		try {
			InvestorRounds investorRounds = investorRoundsDAO.selectByPrimaryKey( id );
			message.setData(investorRounds);

		} catch (Exception e) {
			LOGGER.error("getInvestorRounds","根据主键查询InvestorRounds失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    public Message<List<InvestorRounds>> getAllInvestorRounds(){

		Message<List<InvestorRounds>> message = new Message<List<InvestorRounds>>();
		try {
			List<InvestorRounds> investorRoundsList = investorRoundsDAO.selectAll();
			message.setData( investorRoundsList);
		} catch (Exception e) {
			LOGGER.error("getAllInvestorRounds","查询全部InvestorRounds失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	public Message<QueryResult<InvestorRounds>> queryInvestorRounds(InvestorRoundsQuery investorRoundsQuery) {
		Message<QueryResult<InvestorRounds>> message = new Message<QueryResult<InvestorRounds>>();
		try {
			QueryResult<InvestorRounds> queryResult = new QueryResult<InvestorRounds>();
			PageHelper.startPage(investorRoundsQuery.getPageIndex(), investorRoundsQuery.getPageSize());
			List<InvestorRounds> investorRoundsList = investorRoundsDAO.queryInvestorRounds(investorRoundsQuery);
			PageInfo<InvestorRounds> pageInfo = new PageInfo<InvestorRounds>(investorRoundsList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(investorRoundsList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryInvestorRounds", "分页查询InvestorRounds失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	

}