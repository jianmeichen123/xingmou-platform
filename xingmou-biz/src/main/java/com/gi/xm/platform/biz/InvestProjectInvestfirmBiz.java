

package com.gi.xm.platform.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.platform.dao.InvestProjectInvestfirmDAO;

import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.MessageStatus;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.InvestProjectInvestfirm;
import com.gi.xm.platform.query.InvestProjectInvestfirmQuery;

@Service("investProjectInvestfirmBiz")
public class InvestProjectInvestfirmBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(InvestProjectInvestfirmBiz.class);

    @Autowired
	InvestProjectInvestfirmDAO investProjectInvestfirmDAO;



	
	public Message<Integer> deleteInvestProjectInvestfirm(Long id){
		Message<Integer> message = new Message<Integer>();
		try {

			int result = investProjectInvestfirmDAO.deleteByPrimaryKey(id);
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete","删除失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	

    public Message<Long> createInvestProjectInvestfirm(InvestProjectInvestfirm investProjectInvestfirm){
		Message<Long> message = new Message<Long>();
		try {
						        				        				        							investProjectInvestfirmDAO.insert( investProjectInvestfirm );
			message.setData(investProjectInvestfirm.getId());

		} catch (Exception e) {
			LOGGER.error("createInvestProjectInvestfirm","创建InvestProjectInvestfirm失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	public Message<Integer> updateInvestProjectInvestfirm(InvestProjectInvestfirm investProjectInvestfirm){
		Message<Integer> message = new Message<Integer>();
		try {

			InvestProjectInvestfirm investProjectInvestfirmLast = investProjectInvestfirmDAO.selectByPrimaryKeyForUpdate( investProjectInvestfirm.getId() );
			if( investProjectInvestfirmLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}

						        				        				        							int result = investProjectInvestfirmDAO.updateByPrimaryKey( investProjectInvestfirm );
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("updateInvestProjectInvestfirm","更新InvestProjectInvestfirm失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

		public Message<InvestProjectInvestfirm> getInvestProjectInvestfirm( Long id ){
		Message<InvestProjectInvestfirm> message = new Message<InvestProjectInvestfirm>();
		try {
			InvestProjectInvestfirm investProjectInvestfirm = investProjectInvestfirmDAO.selectByPrimaryKey( id );
			message.setData(investProjectInvestfirm);

		} catch (Exception e) {
			LOGGER.error("getInvestProjectInvestfirm","根据主键查询InvestProjectInvestfirm失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    public Message<List<InvestProjectInvestfirm>> getAllInvestProjectInvestfirm(){

		Message<List<InvestProjectInvestfirm>> message = new Message<List<InvestProjectInvestfirm>>();
		try {
			List<InvestProjectInvestfirm> investProjectInvestfirmList = investProjectInvestfirmDAO.selectAll();
			message.setData( investProjectInvestfirmList);
		} catch (Exception e) {
			LOGGER.error("getAllInvestProjectInvestfirm","查询全部InvestProjectInvestfirm失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	public Message<QueryResult<InvestProjectInvestfirm>> queryInvestProjectInvestfirm(InvestProjectInvestfirmQuery investProjectInvestfirmQuery) {
		Message<QueryResult<InvestProjectInvestfirm>> message = new Message<QueryResult<InvestProjectInvestfirm>>();
		try {
			QueryResult<InvestProjectInvestfirm> queryResult = new QueryResult<InvestProjectInvestfirm>();
			PageHelper.startPage(investProjectInvestfirmQuery.getPageIndex(), investProjectInvestfirmQuery.getPageSize());
			List<InvestProjectInvestfirm> investProjectInvestfirmList = investProjectInvestfirmDAO.queryInvestProjectInvestfirm(investProjectInvestfirmQuery);
			PageInfo<InvestProjectInvestfirm> pageInfo = new PageInfo<InvestProjectInvestfirm>(investProjectInvestfirmList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(investProjectInvestfirmList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryInvestProjectInvestfirm", "分页查询InvestProjectInvestfirm失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}


	public Message<List<InvestProjectInvestfirm>> query(InvestProjectInvestfirmQuery investProjectInvestfirmQuery) {
		Message<List<InvestProjectInvestfirm>> message = new Message<List<InvestProjectInvestfirm>>();
		try {
            investProjectInvestfirmQuery.setDoOrder(false);
			List<InvestProjectInvestfirm> investProjectInvestfirmList = investProjectInvestfirmDAO.queryInvestProjectInvestfirm(investProjectInvestfirmQuery);
			message.setData(investProjectInvestfirmList);
		} catch (Exception e) {
			LOGGER.error("queryInvestProjectInvestfirm", "查询InvestProjectInvestfirm失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}


	public Message<List<InvestProjectInvestfirm>> getListByInvestId(Long investId){

		Message<List<InvestProjectInvestfirm>> message = new Message<List<InvestProjectInvestfirm>>();
		try {
			List<InvestProjectInvestfirm> investProjectInvestfirmList = investProjectInvestfirmDAO.selectByInvestId(investId);
			message.setData(investProjectInvestfirmList);
		} catch (Exception e) {
			LOGGER.error("getListByInvestId","查询InvestProjectInvestfirm失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
			
	public Message<List<InvestProjectInvestfirm>> getListByInvestfirmId(Long investfirmId){

		Message<List<InvestProjectInvestfirm>> message = new Message<List<InvestProjectInvestfirm>>();
		try {
			List<InvestProjectInvestfirm> investProjectInvestfirmList = investProjectInvestfirmDAO.selectByInvestfirmId(investfirmId);
			message.setData(investProjectInvestfirmList);
		} catch (Exception e) {
			LOGGER.error("getListByInvestfirmId","查询InvestProjectInvestfirm失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
			
	public Message<List<InvestProjectInvestfirm>> getListByProjectId(Long projectId){

		Message<List<InvestProjectInvestfirm>> message = new Message<List<InvestProjectInvestfirm>>();
		try {
			List<InvestProjectInvestfirm> investProjectInvestfirmList = investProjectInvestfirmDAO.selectByProjectId(projectId);
			message.setData(investProjectInvestfirmList);
		} catch (Exception e) {
			LOGGER.error("getListByProjectId","查询InvestProjectInvestfirm失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
		

}