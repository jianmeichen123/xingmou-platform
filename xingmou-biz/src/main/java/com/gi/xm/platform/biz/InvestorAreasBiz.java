

package com.gi.xm.platform.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.platform.dao.InvestorAreasDAO;

import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.MessageStatus;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.InvestorAreas;
import com.gi.xm.platform.query.InvestorAreasQuery;

@Service("investorAreasBiz")
public class InvestorAreasBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(InvestorAreasBiz.class);

    @Autowired
	InvestorAreasDAO investorAreasDAO;



	
	public Message<Integer> deleteInvestorAreas(Long id){
		Message<Integer> message = new Message<Integer>();
		try {

			int result = investorAreasDAO.deleteByPrimaryKey(id);
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete","删除失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	

    public Message<Long> createInvestorAreas(InvestorAreas investorAreas){
		Message<Long> message = new Message<Long>();
		try {
									investorAreasDAO.insert( investorAreas );
			message.setData(investorAreas.getId());

		} catch (Exception e) {
			LOGGER.error("createInvestorAreas","创建InvestorAreas失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	public Message<Integer> updateInvestorAreas(InvestorAreas investorAreas){
		Message<Integer> message = new Message<Integer>();
		try {

			InvestorAreas investorAreasLast = investorAreasDAO.selectByPrimaryKeyForUpdate( investorAreas.getId() );
			if( investorAreasLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}

									int result = investorAreasDAO.updateByPrimaryKey( investorAreas );
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("updateInvestorAreas","更新InvestorAreas失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

		public Message<InvestorAreas> getInvestorAreas( Long id ){
		Message<InvestorAreas> message = new Message<InvestorAreas>();
		try {
			InvestorAreas investorAreas = investorAreasDAO.selectByPrimaryKey( id );
			message.setData(investorAreas);

		} catch (Exception e) {
			LOGGER.error("getInvestorAreas","根据主键查询InvestorAreas失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    public Message<List<InvestorAreas>> getAllInvestorAreas(){

		Message<List<InvestorAreas>> message = new Message<List<InvestorAreas>>();
		try {
			List<InvestorAreas> investorAreasList = investorAreasDAO.selectAll();
			message.setData( investorAreasList);
		} catch (Exception e) {
			LOGGER.error("getAllInvestorAreas","查询全部InvestorAreas失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	public Message<QueryResult<InvestorAreas>> queryInvestorAreas(InvestorAreasQuery investorAreasQuery) {
		Message<QueryResult<InvestorAreas>> message = new Message<QueryResult<InvestorAreas>>();
		try {
			QueryResult<InvestorAreas> queryResult = new QueryResult<InvestorAreas>();
			PageHelper.startPage(investorAreasQuery.getPageIndex(), investorAreasQuery.getPageSize());
			List<InvestorAreas> investorAreasList = investorAreasDAO.queryInvestorAreas(investorAreasQuery);
			PageInfo<InvestorAreas> pageInfo = new PageInfo<InvestorAreas>(investorAreasList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(investorAreasList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryInvestorAreas", "分页查询InvestorAreas失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	

}