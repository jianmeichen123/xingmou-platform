

package com.gi.xm.platform.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.platform.dao.InvestfirmsDataYearDAO;

import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.MessageStatus;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.InvestfirmsDataYear;
import com.gi.xm.platform.query.InvestfirmsDataYearQuery;

@Service("investfirmsDataYearBiz")
public class InvestfirmsDataYearBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(InvestfirmsDataYearBiz.class);

    @Autowired
	InvestfirmsDataYearDAO investfirmsDataYearDAO;



	
	public Message<Integer> deleteInvestfirmsDataYear(Long id){
		Message<Integer> message = new Message<Integer>();
		try {

			int result = investfirmsDataYearDAO.deleteByPrimaryKey(id);
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete","删除失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	

    public Message<Long> createInvestfirmsDataYear(InvestfirmsDataYear investfirmsDataYear){
		Message<Long> message = new Message<Long>();
		try {
						        				        							investfirmsDataYearDAO.insert( investfirmsDataYear );
			message.setData(investfirmsDataYear.getId());

		} catch (Exception e) {
			LOGGER.error("createInvestfirmsDataYear","创建InvestfirmsDataYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	public Message<Integer> updateInvestfirmsDataYear(InvestfirmsDataYear investfirmsDataYear){
		Message<Integer> message = new Message<Integer>();
		try {

			InvestfirmsDataYear investfirmsDataYearLast = investfirmsDataYearDAO.selectByPrimaryKeyForUpdate( investfirmsDataYear.getId() );
			if( investfirmsDataYearLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}

						        				        							int result = investfirmsDataYearDAO.updateByPrimaryKey( investfirmsDataYear );
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("updateInvestfirmsDataYear","更新InvestfirmsDataYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

		public Message<InvestfirmsDataYear> getInvestfirmsDataYear( Long id ){
		Message<InvestfirmsDataYear> message = new Message<InvestfirmsDataYear>();
		try {
			InvestfirmsDataYear investfirmsDataYear = investfirmsDataYearDAO.selectByPrimaryKey( id );
			message.setData(investfirmsDataYear);

		} catch (Exception e) {
			LOGGER.error("getInvestfirmsDataYear","根据主键查询InvestfirmsDataYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    public Message<List<InvestfirmsDataYear>> getAllInvestfirmsDataYear(){

		Message<List<InvestfirmsDataYear>> message = new Message<List<InvestfirmsDataYear>>();
		try {
			List<InvestfirmsDataYear> investfirmsDataYearList = investfirmsDataYearDAO.selectAll();
			message.setData( investfirmsDataYearList);
		} catch (Exception e) {
			LOGGER.error("getAllInvestfirmsDataYear","查询全部InvestfirmsDataYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	public Message<QueryResult<InvestfirmsDataYear>> queryInvestfirmsDataYear(InvestfirmsDataYearQuery investfirmsDataYearQuery) {
		Message<QueryResult<InvestfirmsDataYear>> message = new Message<QueryResult<InvestfirmsDataYear>>();
		try {
			QueryResult<InvestfirmsDataYear> queryResult = new QueryResult<InvestfirmsDataYear>();
			PageHelper.startPage(investfirmsDataYearQuery.getPageIndex(), investfirmsDataYearQuery.getPageSize());
			List<InvestfirmsDataYear> investfirmsDataYearList = investfirmsDataYearDAO.queryInvestfirmsDataYear(investfirmsDataYearQuery);
			PageInfo<InvestfirmsDataYear> pageInfo = new PageInfo<InvestfirmsDataYear>(investfirmsDataYearList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(investfirmsDataYearList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryInvestfirmsDataYear", "分页查询InvestfirmsDataYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

		
	public Message<List<InvestfirmsDataYear>> getListByInvestfirmId(Long investfirmId){

		Message<List<InvestfirmsDataYear>> message = new Message<List<InvestfirmsDataYear>>();
		try {
			List<InvestfirmsDataYear> investfirmsDataYearList = investfirmsDataYearDAO.selectByInvestfirmId(investfirmId);
			message.setData(investfirmsDataYearList);
		} catch (Exception e) {
			LOGGER.error("getListByInvestfirmId","查询InvestfirmsDataYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
			
	public Message<List<InvestfirmsDataYear>> getListByYear(Integer year){

		Message<List<InvestfirmsDataYear>> message = new Message<List<InvestfirmsDataYear>>();
		try {
			List<InvestfirmsDataYear> investfirmsDataYearList = investfirmsDataYearDAO.selectByYear(year);
			message.setData(investfirmsDataYearList);
		} catch (Exception e) {
			LOGGER.error("getListByYear","查询InvestfirmsDataYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
		

}