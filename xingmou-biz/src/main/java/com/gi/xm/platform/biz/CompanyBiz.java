

package com.gi.xm.platform.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.platform.dao.CompanyDAO;

import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.MessageStatus;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.Company;
import com.gi.xm.platform.query.CompanyQuery;

@Service("companyBiz")
public class CompanyBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(CompanyBiz.class);

    @Autowired
	CompanyDAO companyDAO;



	
	public Message<Integer> deleteCompany(Long id){
		Message<Integer> message = new Message<Integer>();
		try {

			int result = companyDAO.deleteByPrimaryKey(id);
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete","删除失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	

    public Message<Long> createCompany(Company company){
		Message<Long> message = new Message<Long>();
		try {
									companyDAO.insert( company );
			message.setData(company.getId());

		} catch (Exception e) {
			LOGGER.error("createCompany","创建Company失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	public Message<Integer> updateCompany(Company company){
		Message<Integer> message = new Message<Integer>();
		try {

			Company companyLast = companyDAO.selectByPrimaryKeyForUpdate( company.getId() );
			if( companyLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}

									int result = companyDAO.updateByPrimaryKey( company );
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("updateCompany","更新Company失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

		public Message<Company> getCompany( Long id ){
		Message<Company> message = new Message<Company>();
		try {
			Company company = companyDAO.selectByPrimaryKey( id );
			message.setData(company);

		} catch (Exception e) {
			LOGGER.error("getCompany","根据主键查询Company失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    public Message<List<Company>> getAllCompany(){

		Message<List<Company>> message = new Message<List<Company>>();
		try {
			List<Company> companyList = companyDAO.selectAll();
			message.setData( companyList);
		} catch (Exception e) {
			LOGGER.error("getAllCompany","查询全部Company失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	public Message<QueryResult<Company>> queryCompany(CompanyQuery companyQuery) {
		Message<QueryResult<Company>> message = new Message<QueryResult<Company>>();
		try {
			QueryResult<Company> queryResult = new QueryResult<Company>();
			PageHelper.startPage(companyQuery.getPageIndex(), companyQuery.getPageSize());
			List<Company> companyList = companyDAO.queryCompany(companyQuery);
			PageInfo<Company> pageInfo = new PageInfo<Company>(companyList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(companyList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryCompany", "分页查询Company失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	

}