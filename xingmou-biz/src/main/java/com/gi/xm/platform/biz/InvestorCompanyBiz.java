

package com.gi.xm.platform.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.platform.dao.InvestorCompanyDAO;

import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.MessageStatus;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.InvestorCompany;
import com.gi.xm.platform.query.InvestorCompanyQuery;

@Service("investorCompanyBiz")
public class InvestorCompanyBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(InvestorCompanyBiz.class);

    @Autowired
	InvestorCompanyDAO investorCompanyDAO;



	
	public Message<Integer> deleteInvestorCompany(Long id){
		Message<Integer> message = new Message<Integer>();
		try {

			int result = investorCompanyDAO.deleteByPrimaryKey(id);
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete","删除失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	

    public Message<Long> createInvestorCompany(InvestorCompany investorCompany){
		Message<Long> message = new Message<Long>();
		try {
									investorCompanyDAO.insert( investorCompany );
			message.setData(investorCompany.getId());

		} catch (Exception e) {
			LOGGER.error("createInvestorCompany","创建InvestorCompany失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	public Message<Integer> updateInvestorCompany(InvestorCompany investorCompany){
		Message<Integer> message = new Message<Integer>();
		try {

			InvestorCompany investorCompanyLast = investorCompanyDAO.selectByPrimaryKeyForUpdate( investorCompany.getId() );
			if( investorCompanyLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}

									int result = investorCompanyDAO.updateByPrimaryKey( investorCompany );
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("updateInvestorCompany","更新InvestorCompany失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

		public Message<Integer> changeStatus(Long id,Integer status,String operatorId){
		Message<Integer> message = new Message<Integer>();
		try {

			InvestorCompany investorCompanyLast = investorCompanyDAO.selectByPrimaryKeyForUpdate(id );
			if( investorCompanyLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}

			//TODO：其他判断

			int result = investorCompanyDAO.changeStatus(id,status,operatorId);
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("changeStatus","更新InvestorCompany状态失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
		public Message<InvestorCompany> getInvestorCompany( Long id ){
		Message<InvestorCompany> message = new Message<InvestorCompany>();
		try {
			InvestorCompany investorCompany = investorCompanyDAO.selectByPrimaryKey( id );
			message.setData(investorCompany);

		} catch (Exception e) {
			LOGGER.error("getInvestorCompany","根据主键查询InvestorCompany失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    public Message<List<InvestorCompany>> getAllInvestorCompany(){

		Message<List<InvestorCompany>> message = new Message<List<InvestorCompany>>();
		try {
			List<InvestorCompany> investorCompanyList = investorCompanyDAO.selectAll();
			message.setData( investorCompanyList);
		} catch (Exception e) {
			LOGGER.error("getAllInvestorCompany","查询全部InvestorCompany失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	public Message<QueryResult<InvestorCompany>> queryInvestorCompany(InvestorCompanyQuery investorCompanyQuery) {
		Message<QueryResult<InvestorCompany>> message = new Message<QueryResult<InvestorCompany>>();
		try {
			QueryResult<InvestorCompany> queryResult = new QueryResult<InvestorCompany>();
			PageHelper.startPage(investorCompanyQuery.getPageIndex(), investorCompanyQuery.getPageSize());
			List<InvestorCompany> investorCompanyList = investorCompanyDAO.queryInvestorCompany(investorCompanyQuery);
			PageInfo<InvestorCompany> pageInfo = new PageInfo<InvestorCompany>(investorCompanyList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(investorCompanyList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryInvestorCompany", "分页查询InvestorCompany失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	

}