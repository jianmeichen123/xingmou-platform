

package com.gi.xm.platform.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.platform.dao.InvestorJobDAO;

import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.MessageStatus;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.InvestorJob;
import com.gi.xm.platform.query.InvestorJobQuery;

@Service("investorJobBiz")
public class InvestorJobBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(InvestorJobBiz.class);

    @Autowired
	InvestorJobDAO investorJobDAO;



	
	public Message<Integer> deleteInvestorJob(Long id){
		Message<Integer> message = new Message<Integer>();
		try {

			int result = investorJobDAO.deleteByPrimaryKey(id);
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete","删除失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	

    public Message<Long> createInvestorJob(InvestorJob investorJob){
		Message<Long> message = new Message<Long>();
		try {
									investorJobDAO.insert( investorJob );
			message.setData(investorJob.getId());

		} catch (Exception e) {
			LOGGER.error("createInvestorJob","创建InvestorJob失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	public Message<Integer> updateInvestorJob(InvestorJob investorJob){
		Message<Integer> message = new Message<Integer>();
		try {

			InvestorJob investorJobLast = investorJobDAO.selectByPrimaryKeyForUpdate( investorJob.getId() );
			if( investorJobLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}

									int result = investorJobDAO.updateByPrimaryKey( investorJob );
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("updateInvestorJob","更新InvestorJob失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

		public Message<InvestorJob> getInvestorJob( Long id ){
		Message<InvestorJob> message = new Message<InvestorJob>();
		try {
			InvestorJob investorJob = investorJobDAO.selectByPrimaryKey( id );
			message.setData(investorJob);

		} catch (Exception e) {
			LOGGER.error("getInvestorJob","根据主键查询InvestorJob失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    public Message<List<InvestorJob>> getAllInvestorJob(){

		Message<List<InvestorJob>> message = new Message<List<InvestorJob>>();
		try {
			List<InvestorJob> investorJobList = investorJobDAO.selectAll();
			message.setData( investorJobList);
		} catch (Exception e) {
			LOGGER.error("getAllInvestorJob","查询全部InvestorJob失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	public Message<QueryResult<InvestorJob>> queryInvestorJob(InvestorJobQuery investorJobQuery) {
		Message<QueryResult<InvestorJob>> message = new Message<QueryResult<InvestorJob>>();
		try {
			QueryResult<InvestorJob> queryResult = new QueryResult<InvestorJob>();
			PageHelper.startPage(investorJobQuery.getPageIndex(), investorJobQuery.getPageSize());
			List<InvestorJob> investorJobList = investorJobDAO.queryInvestorJob(investorJobQuery);
			PageInfo<InvestorJob> pageInfo = new PageInfo<InvestorJob>(investorJobList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(investorJobList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryInvestorJob", "分页查询InvestorJob失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	

}