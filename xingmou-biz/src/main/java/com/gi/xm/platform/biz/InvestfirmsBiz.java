

package com.gi.xm.platform.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.platform.dao.InvestfirmsDAO;

import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.MessageStatus;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.Investfirms;
import com.gi.xm.platform.query.InvestfirmsQuery;

@Service("investfirmsBiz")
public class InvestfirmsBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(InvestfirmsBiz.class);

    @Autowired
	InvestfirmsDAO investfirmsDAO;



	
	public Message<Integer> deleteInvestfirms(Long id){
		Message<Integer> message = new Message<Integer>();
		try {

			int result = investfirmsDAO.deleteByPrimaryKey(id);
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete","删除失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	

    public Message<Long> createInvestfirms(Investfirms investfirms){
		Message<Long> message = new Message<Long>();
		try {
						        							investfirmsDAO.insert( investfirms );
			message.setData(investfirms.getId());

		} catch (Exception e) {
			LOGGER.error("createInvestfirms","创建Investfirms失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	public Message<Integer> updateInvestfirms(Investfirms investfirms){
		Message<Integer> message = new Message<Integer>();
		try {

			Investfirms investfirmsLast = investfirmsDAO.selectByPrimaryKeyForUpdate( investfirms.getId() );
			if( investfirmsLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}

						        							int result = investfirmsDAO.updateByPrimaryKey( investfirms );
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("updateInvestfirms","更新Investfirms失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

		public Message<Investfirms> getInvestfirms( Long id ){
		Message<Investfirms> message = new Message<Investfirms>();
		try {
			Investfirms investfirms = investfirmsDAO.selectByPrimaryKey( id );
			message.setData(investfirms);

		} catch (Exception e) {
			LOGGER.error("getInvestfirms","根据主键查询Investfirms失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    public Message<List<Investfirms>> getAllInvestfirms(){

		Message<List<Investfirms>> message = new Message<List<Investfirms>>();
		try {
			List<Investfirms> investfirmsList = investfirmsDAO.selectAll();
			message.setData( investfirmsList);
		} catch (Exception e) {
			LOGGER.error("getAllInvestfirms","查询全部Investfirms失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	public Message<QueryResult<Investfirms>> queryInvestfirms(InvestfirmsQuery investfirmsQuery) {
		Message<QueryResult<Investfirms>> message = new Message<QueryResult<Investfirms>>();
		try {
			QueryResult<Investfirms> queryResult = new QueryResult<Investfirms>();
			PageHelper.startPage(investfirmsQuery.getPageIndex(), investfirmsQuery.getPageSize());
			List<Investfirms> investfirmsList = investfirmsDAO.queryInvestfirms(investfirmsQuery);
			PageInfo<Investfirms> pageInfo = new PageInfo<Investfirms>(investfirmsList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(investfirmsList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryInvestfirms", "分页查询Investfirms失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

		
	public Message<List<Investfirms>> getListBySourceId(Long sourceId){

		Message<List<Investfirms>> message = new Message<List<Investfirms>>();
		try {
			List<Investfirms> investfirmsList = investfirmsDAO.selectBySourceId(sourceId);
			message.setData(investfirmsList);
		} catch (Exception e) {
			LOGGER.error("getListBySourceId","查询Investfirms失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
		

}