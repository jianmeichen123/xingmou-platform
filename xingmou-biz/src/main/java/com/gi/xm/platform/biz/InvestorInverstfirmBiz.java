

package com.gi.xm.platform.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.platform.dao.InvestorInverstfirmDAO;

import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.MessageStatus;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.InvestorInverstfirm;
import com.gi.xm.platform.query.InvestorInverstfirmQuery;

@Service("investorInverstfirmBiz")
public class InvestorInverstfirmBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(InvestorInverstfirmBiz.class);

    @Autowired
	InvestorInverstfirmDAO investorInverstfirmDAO;



	
	public Message<Integer> deleteInvestorInverstfirm(Long id){
		Message<Integer> message = new Message<Integer>();
		try {

			int result = investorInverstfirmDAO.deleteByPrimaryKey(id);
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete","删除失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	

    public Message<Long> createInvestorInverstfirm(InvestorInverstfirm investorInverstfirm){
		Message<Long> message = new Message<Long>();
		try {
									investorInverstfirmDAO.insert( investorInverstfirm );
			message.setData(investorInverstfirm.getId());

		} catch (Exception e) {
			LOGGER.error("createInvestorInverstfirm","创建InvestorInverstfirm失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	public Message<Integer> updateInvestorInverstfirm(InvestorInverstfirm investorInverstfirm){
		Message<Integer> message = new Message<Integer>();
		try {

			InvestorInverstfirm investorInverstfirmLast = investorInverstfirmDAO.selectByPrimaryKeyForUpdate( investorInverstfirm.getId() );
			if( investorInverstfirmLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}

									int result = investorInverstfirmDAO.updateByPrimaryKey( investorInverstfirm );
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("updateInvestorInverstfirm","更新InvestorInverstfirm失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

		public Message<InvestorInverstfirm> getInvestorInverstfirm( Long id ){
		Message<InvestorInverstfirm> message = new Message<InvestorInverstfirm>();
		try {
			InvestorInverstfirm investorInverstfirm = investorInverstfirmDAO.selectByPrimaryKey( id );
			message.setData(investorInverstfirm);

		} catch (Exception e) {
			LOGGER.error("getInvestorInverstfirm","根据主键查询InvestorInverstfirm失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    public Message<List<InvestorInverstfirm>> getAllInvestorInverstfirm(){

		Message<List<InvestorInverstfirm>> message = new Message<List<InvestorInverstfirm>>();
		try {
			List<InvestorInverstfirm> investorInverstfirmList = investorInverstfirmDAO.selectAll();
			message.setData( investorInverstfirmList);
		} catch (Exception e) {
			LOGGER.error("getAllInvestorInverstfirm","查询全部InvestorInverstfirm失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	public Message<QueryResult<InvestorInverstfirm>> queryInvestorInverstfirm(InvestorInverstfirmQuery investorInverstfirmQuery) {
		Message<QueryResult<InvestorInverstfirm>> message = new Message<QueryResult<InvestorInverstfirm>>();
		try {
			QueryResult<InvestorInverstfirm> queryResult = new QueryResult<InvestorInverstfirm>();
			PageHelper.startPage(investorInverstfirmQuery.getPageIndex(), investorInverstfirmQuery.getPageSize());
			List<InvestorInverstfirm> investorInverstfirmList = investorInverstfirmDAO.queryInvestorInverstfirm(investorInverstfirmQuery);
			PageInfo<InvestorInverstfirm> pageInfo = new PageInfo<InvestorInverstfirm>(investorInverstfirmList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(investorInverstfirmList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryInvestorInverstfirm", "分页查询InvestorInverstfirm失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	

}