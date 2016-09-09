

package com.gi.xm.platform.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.platform.dao.InvestorStudyDAO;

import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.MessageStatus;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.InvestorStudy;
import com.gi.xm.platform.query.InvestorStudyQuery;

@Service("investorStudyBiz")
public class InvestorStudyBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(InvestorStudyBiz.class);

    @Autowired
	InvestorStudyDAO investorStudyDAO;



	
	public Message<Integer> deleteInvestorStudy(Long id){
		Message<Integer> message = new Message<Integer>();
		try {

			int result = investorStudyDAO.deleteByPrimaryKey(id);
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete","删除失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	

    public Message<Long> createInvestorStudy(InvestorStudy investorStudy){
		Message<Long> message = new Message<Long>();
		try {
									investorStudyDAO.insert( investorStudy );
			message.setData(investorStudy.getId());

		} catch (Exception e) {
			LOGGER.error("createInvestorStudy","创建InvestorStudy失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	public Message<Integer> updateInvestorStudy(InvestorStudy investorStudy){
		Message<Integer> message = new Message<Integer>();
		try {

			InvestorStudy investorStudyLast = investorStudyDAO.selectByPrimaryKeyForUpdate( investorStudy.getId() );
			if( investorStudyLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}

									int result = investorStudyDAO.updateByPrimaryKey( investorStudy );
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("updateInvestorStudy","更新InvestorStudy失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

		public Message<InvestorStudy> getInvestorStudy( Long id ){
		Message<InvestorStudy> message = new Message<InvestorStudy>();
		try {
			InvestorStudy investorStudy = investorStudyDAO.selectByPrimaryKey( id );
			message.setData(investorStudy);

		} catch (Exception e) {
			LOGGER.error("getInvestorStudy","根据主键查询InvestorStudy失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    public Message<List<InvestorStudy>> getAllInvestorStudy(){

		Message<List<InvestorStudy>> message = new Message<List<InvestorStudy>>();
		try {
			List<InvestorStudy> investorStudyList = investorStudyDAO.selectAll();
			message.setData( investorStudyList);
		} catch (Exception e) {
			LOGGER.error("getAllInvestorStudy","查询全部InvestorStudy失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	public Message<QueryResult<InvestorStudy>> queryInvestorStudy(InvestorStudyQuery investorStudyQuery) {
		Message<QueryResult<InvestorStudy>> message = new Message<QueryResult<InvestorStudy>>();
		try {
			QueryResult<InvestorStudy> queryResult = new QueryResult<InvestorStudy>();
			PageHelper.startPage(investorStudyQuery.getPageIndex(), investorStudyQuery.getPageSize());
			List<InvestorStudy> investorStudyList = investorStudyDAO.queryInvestorStudy(investorStudyQuery);
			PageInfo<InvestorStudy> pageInfo = new PageInfo<InvestorStudy>(investorStudyList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(investorStudyList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryInvestorStudy", "分页查询InvestorStudy失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	

}