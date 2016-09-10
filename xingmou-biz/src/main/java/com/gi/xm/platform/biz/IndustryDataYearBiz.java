

package com.gi.xm.platform.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.platform.dao.IndustryDataYearDAO;

import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.MessageStatus;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.IndustryDataYear;
import com.gi.xm.platform.query.IndustryDataYearQuery;

@Service("industryDataYearBiz")
public class IndustryDataYearBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(IndustryDataYearBiz.class);

    @Autowired
	IndustryDataYearDAO industryDataYearDAO;



	
	public Message<Integer> deleteIndustryDataYear(Long id){
		Message<Integer> message = new Message<Integer>();
		try {

			int result = industryDataYearDAO.deleteByPrimaryKey(id);
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete","删除失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	

    public Message<Long> createIndustryDataYear(IndustryDataYear industryDataYear){
		Message<Long> message = new Message<Long>();
		try {
						        				        				        				        							industryDataYearDAO.insert( industryDataYear );
			message.setData(industryDataYear.getId());

		} catch (Exception e) {
			LOGGER.error("createIndustryDataYear","创建IndustryDataYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	public Message<Integer> updateIndustryDataYear(IndustryDataYear industryDataYear){
		Message<Integer> message = new Message<Integer>();
		try {

			IndustryDataYear industryDataYearLast = industryDataYearDAO.selectByPrimaryKeyForUpdate( industryDataYear.getId() );
			if( industryDataYearLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}

						        				        				        				        							int result = industryDataYearDAO.updateByPrimaryKey( industryDataYear );
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("updateIndustryDataYear","更新IndustryDataYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

		public Message<IndustryDataYear> getIndustryDataYear( Long id ){
		Message<IndustryDataYear> message = new Message<IndustryDataYear>();
		try {
			IndustryDataYear industryDataYear = industryDataYearDAO.selectByPrimaryKey( id );
			message.setData(industryDataYear);

		} catch (Exception e) {
			LOGGER.error("getIndustryDataYear","根据主键查询IndustryDataYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    public Message<List<IndustryDataYear>> getAllIndustryDataYear(){

		Message<List<IndustryDataYear>> message = new Message<List<IndustryDataYear>>();
		try {
			List<IndustryDataYear> industryDataYearList = industryDataYearDAO.selectAll();
			message.setData( industryDataYearList);
		} catch (Exception e) {
			LOGGER.error("getAllIndustryDataYear","查询全部IndustryDataYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	public Message<QueryResult<IndustryDataYear>> queryIndustryDataYear(IndustryDataYearQuery industryDataYearQuery) {
		Message<QueryResult<IndustryDataYear>> message = new Message<QueryResult<IndustryDataYear>>();
		try {
			QueryResult<IndustryDataYear> queryResult = new QueryResult<IndustryDataYear>();
			PageHelper.startPage(industryDataYearQuery.getPageIndex(), industryDataYearQuery.getPageSize());
			List<IndustryDataYear> industryDataYearList = industryDataYearDAO.queryIndustryDataYear(industryDataYearQuery);
			PageInfo<IndustryDataYear> pageInfo = new PageInfo<IndustryDataYear>(industryDataYearList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(industryDataYearList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryIndustryDataYear", "分页查询IndustryDataYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

		
	public Message<List<IndustryDataYear>> getListByIndustryIdYaar(Integer industryId, Integer[] yaars){

		Message<List<IndustryDataYear>> message = new Message<List<IndustryDataYear>>();
		try {
			List<IndustryDataYear> industryDataYearList = industryDataYearDAO.selectByIndustryIdYaar(industryId, yaars);
			message.setData(industryDataYearList);
		} catch (Exception e) {
			LOGGER.error("getListByIndustryIdYaar","查询IndustryDataYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
			
	public Message<List<IndustryDataYear>> getListByYaarIndustrySubId(Integer[] yaars, Integer industrySubId){

		Message<List<IndustryDataYear>> message = new Message<List<IndustryDataYear>>();
		try {
			List<IndustryDataYear> industryDataYearList = industryDataYearDAO.selectByYaarIndustrySubId(yaars, industrySubId);
			message.setData(industryDataYearList);
		} catch (Exception e) {
			LOGGER.error("getListByYaarIndustrySubId","查询IndustryDataYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
			
	public Message<List<IndustryDataYear>> getListByIndustryId(Integer industryId){

		Message<List<IndustryDataYear>> message = new Message<List<IndustryDataYear>>();
		try {
			List<IndustryDataYear> industryDataYearList = industryDataYearDAO.selectByIndustryId(industryId);
			message.setData(industryDataYearList);
		} catch (Exception e) {
			LOGGER.error("getListByIndustryId","查询IndustryDataYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
			
	public Message<List<IndustryDataYear>> getListByYaar(Integer[] yaars){

		Message<List<IndustryDataYear>> message = new Message<List<IndustryDataYear>>();
		try {
			List<IndustryDataYear> industryDataYearList = industryDataYearDAO.selectByYaar(yaars);
			message.setData(industryDataYearList);
		} catch (Exception e) {
			LOGGER.error("getListByYaar","查询IndustryDataYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
		

}