

package com.gi.xm.platform.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.platform.dao.InvestfirmAreaDAO;

import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.MessageStatus;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.InvestfirmArea;
import com.gi.xm.platform.query.InvestfirmAreaQuery;

@Service("investfirmAreaBiz")
public class InvestfirmAreaBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(InvestfirmAreaBiz.class);

    @Autowired
	InvestfirmAreaDAO investfirmAreaDAO;



	
	public Message<Integer> deleteInvestfirmArea(Long id){
		Message<Integer> message = new Message<Integer>();
		try {

			int result = investfirmAreaDAO.deleteByPrimaryKey(id);
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete","删除失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	

    public Message<Long> createInvestfirmArea(InvestfirmArea investfirmArea){
		Message<Long> message = new Message<Long>();
		try {
						        							investfirmAreaDAO.insert( investfirmArea );
			message.setData(investfirmArea.getId());

		} catch (Exception e) {
			LOGGER.error("createInvestfirmArea","创建InvestfirmArea失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	public Message<Integer> updateInvestfirmArea(InvestfirmArea investfirmArea){
		Message<Integer> message = new Message<Integer>();
		try {

			InvestfirmArea investfirmAreaLast = investfirmAreaDAO.selectByPrimaryKeyForUpdate( investfirmArea.getId() );
			if( investfirmAreaLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}

						        							int result = investfirmAreaDAO.updateByPrimaryKey( investfirmArea );
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("updateInvestfirmArea","更新InvestfirmArea失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

		public Message<InvestfirmArea> getInvestfirmArea( Long id ){
		Message<InvestfirmArea> message = new Message<InvestfirmArea>();
		try {
			InvestfirmArea investfirmArea = investfirmAreaDAO.selectByPrimaryKey( id );
			message.setData(investfirmArea);

		} catch (Exception e) {
			LOGGER.error("getInvestfirmArea","根据主键查询InvestfirmArea失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    public Message<List<InvestfirmArea>> getAllInvestfirmArea(){

		Message<List<InvestfirmArea>> message = new Message<List<InvestfirmArea>>();
		try {
			List<InvestfirmArea> investfirmAreaList = investfirmAreaDAO.selectAll();
			message.setData( investfirmAreaList);
		} catch (Exception e) {
			LOGGER.error("getAllInvestfirmArea","查询全部InvestfirmArea失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	public Message<QueryResult<InvestfirmArea>> queryInvestfirmArea(InvestfirmAreaQuery investfirmAreaQuery) {
		Message<QueryResult<InvestfirmArea>> message = new Message<QueryResult<InvestfirmArea>>();
		try {
			QueryResult<InvestfirmArea> queryResult = new QueryResult<InvestfirmArea>();
			PageHelper.startPage(investfirmAreaQuery.getPageIndex(), investfirmAreaQuery.getPageSize());
			List<InvestfirmArea> investfirmAreaList = investfirmAreaDAO.queryInvestfirmArea(investfirmAreaQuery);
			PageInfo<InvestfirmArea> pageInfo = new PageInfo<InvestfirmArea>(investfirmAreaList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(investfirmAreaList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryInvestfirmArea", "分页查询InvestfirmArea失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

		
	public Message<List<InvestfirmArea>> getListByInvestfrimId(Integer investfrimId){

		Message<List<InvestfirmArea>> message = new Message<List<InvestfirmArea>>();
		try {
			List<InvestfirmArea> investfirmAreaList = investfirmAreaDAO.selectByInvestfrimId(investfrimId);
			message.setData(investfirmAreaList);
		} catch (Exception e) {
			LOGGER.error("getListByInvestfrimId","查询InvestfirmArea失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
		

}