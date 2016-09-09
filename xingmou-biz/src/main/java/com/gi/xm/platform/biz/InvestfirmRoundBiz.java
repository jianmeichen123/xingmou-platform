

package com.gi.xm.platform.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.platform.dao.InvestfirmRoundDAO;

import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.MessageStatus;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.InvestfirmRound;
import com.gi.xm.platform.query.InvestfirmRoundQuery;

@Service("investfirmRoundBiz")
public class InvestfirmRoundBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(InvestfirmRoundBiz.class);

    @Autowired
	InvestfirmRoundDAO investfirmRoundDAO;



	
	public Message<Integer> deleteInvestfirmRound(Long id){
		Message<Integer> message = new Message<Integer>();
		try {

			int result = investfirmRoundDAO.deleteByPrimaryKey(id);
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete","删除失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	

    public Message<Long> createInvestfirmRound(InvestfirmRound investfirmRound){
		Message<Long> message = new Message<Long>();
		try {
						        							investfirmRoundDAO.insert( investfirmRound );
			message.setData(investfirmRound.getId());

		} catch (Exception e) {
			LOGGER.error("createInvestfirmRound","创建InvestfirmRound失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	public Message<Integer> updateInvestfirmRound(InvestfirmRound investfirmRound){
		Message<Integer> message = new Message<Integer>();
		try {

			InvestfirmRound investfirmRoundLast = investfirmRoundDAO.selectByPrimaryKeyForUpdate( investfirmRound.getId() );
			if( investfirmRoundLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}

						        							int result = investfirmRoundDAO.updateByPrimaryKey( investfirmRound );
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("updateInvestfirmRound","更新InvestfirmRound失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

		public Message<InvestfirmRound> getInvestfirmRound( Long id ){
		Message<InvestfirmRound> message = new Message<InvestfirmRound>();
		try {
			InvestfirmRound investfirmRound = investfirmRoundDAO.selectByPrimaryKey( id );
			message.setData(investfirmRound);

		} catch (Exception e) {
			LOGGER.error("getInvestfirmRound","根据主键查询InvestfirmRound失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    public Message<List<InvestfirmRound>> getAllInvestfirmRound(){

		Message<List<InvestfirmRound>> message = new Message<List<InvestfirmRound>>();
		try {
			List<InvestfirmRound> investfirmRoundList = investfirmRoundDAO.selectAll();
			message.setData( investfirmRoundList);
		} catch (Exception e) {
			LOGGER.error("getAllInvestfirmRound","查询全部InvestfirmRound失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	public Message<QueryResult<InvestfirmRound>> queryInvestfirmRound(InvestfirmRoundQuery investfirmRoundQuery) {
		Message<QueryResult<InvestfirmRound>> message = new Message<QueryResult<InvestfirmRound>>();
		try {
			QueryResult<InvestfirmRound> queryResult = new QueryResult<InvestfirmRound>();
			PageHelper.startPage(investfirmRoundQuery.getPageIndex(), investfirmRoundQuery.getPageSize());
			List<InvestfirmRound> investfirmRoundList = investfirmRoundDAO.queryInvestfirmRound(investfirmRoundQuery);
			PageInfo<InvestfirmRound> pageInfo = new PageInfo<InvestfirmRound>(investfirmRoundList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(investfirmRoundList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryInvestfirmRound", "分页查询InvestfirmRound失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

		
	public Message<List<InvestfirmRound>> getListByInvestfrimId(Integer investfrimId){

		Message<List<InvestfirmRound>> message = new Message<List<InvestfirmRound>>();
		try {
			List<InvestfirmRound> investfirmRoundList = investfirmRoundDAO.selectByInvestfrimId(investfrimId);
			message.setData(investfirmRoundList);
		} catch (Exception e) {
			LOGGER.error("getListByInvestfrimId","查询InvestfirmRound失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
		

}