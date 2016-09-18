

package com.gi.xm.platform.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.platform.dao.IndustryDataHalfYearDAO;

import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.MessageStatus;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.IndustryDataHalfYear;
import com.gi.xm.platform.query.IndustryDataHalfYearQuery;

@Service("industryDataHalfYearBiz")
public class IndustryDataHalfYearBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(IndustryDataHalfYearBiz.class);

    @Autowired
	IndustryDataHalfYearDAO industryDataHalfYearDAO;



	
	public Message<Integer> deleteIndustryDataHalfYear(Long id){
		Message<Integer> message = new Message<Integer>();
		try {

			int result = industryDataHalfYearDAO.deleteByPrimaryKey(id);
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete","删除失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	

    public Message<Long> createIndustryDataHalfYear(IndustryDataHalfYear industryDataHalfYear){
		Message<Long> message = new Message<Long>();
		try {
						        				        				        				        							industryDataHalfYearDAO.insert( industryDataHalfYear );
			message.setData(industryDataHalfYear.getId());

		} catch (Exception e) {
			LOGGER.error("createIndustryDataHalfYear","创建IndustryDataHalfYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	public Message<Integer> updateIndustryDataHalfYear(IndustryDataHalfYear industryDataHalfYear){
		Message<Integer> message = new Message<Integer>();
		try {

			IndustryDataHalfYear industryDataHalfYearLast = industryDataHalfYearDAO.selectByPrimaryKeyForUpdate( industryDataHalfYear.getId() );
			if( industryDataHalfYearLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}

						        				        				        				        							int result = industryDataHalfYearDAO.updateByPrimaryKey( industryDataHalfYear );
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("updateIndustryDataHalfYear","更新IndustryDataHalfYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

		public Message<IndustryDataHalfYear> getIndustryDataHalfYear( Long id ){
		Message<IndustryDataHalfYear> message = new Message<IndustryDataHalfYear>();
		try {
			IndustryDataHalfYear industryDataHalfYear = industryDataHalfYearDAO.selectByPrimaryKey( id );
			message.setData(industryDataHalfYear);

		} catch (Exception e) {
			LOGGER.error("getIndustryDataHalfYear","根据主键查询IndustryDataHalfYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    public Message<List<IndustryDataHalfYear>> getAllIndustryDataHalfYear(){

		Message<List<IndustryDataHalfYear>> message = new Message<List<IndustryDataHalfYear>>();
		try {
			List<IndustryDataHalfYear> industryDataHalfYearList = industryDataHalfYearDAO.selectAll();
			message.setData( industryDataHalfYearList);
		} catch (Exception e) {
			LOGGER.error("getAllIndustryDataHalfYear","查询全部IndustryDataHalfYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	public Message<QueryResult<IndustryDataHalfYear>> queryIndustryDataHalfYear(IndustryDataHalfYearQuery industryDataHalfYearQuery) {
		Message<QueryResult<IndustryDataHalfYear>> message = new Message<QueryResult<IndustryDataHalfYear>>();
		try {
			QueryResult<IndustryDataHalfYear> queryResult = new QueryResult<IndustryDataHalfYear>();
			PageHelper.startPage(industryDataHalfYearQuery.getPageIndex(), industryDataHalfYearQuery.getPageSize());
			List<IndustryDataHalfYear> industryDataHalfYearList = industryDataHalfYearDAO.queryIndustryDataHalfYear(industryDataHalfYearQuery);
			PageInfo<IndustryDataHalfYear> pageInfo = new PageInfo<IndustryDataHalfYear>(industryDataHalfYearList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(industryDataHalfYearList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryIndustryDataHalfYear", "分页查询IndustryDataHalfYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    	public Message<List<IndustryDataHalfYear>> query(IndustryDataHalfYearQuery industryDataHalfYearQuery) {
    		Message<List<IndustryDataHalfYear>> message = new Message<List<IndustryDataHalfYear>>();
    		try {
    			List<IndustryDataHalfYear> industryDataHalfYearList = industryDataHalfYearDAO.queryIndustryDataHalfYear(industryDataHalfYearQuery);
    			message.setData(industryDataHalfYearList);
    		} catch (Exception e) {
    			LOGGER.error("queryIndustryDataHalfYear", "多条件查询IndustryDataHalfYear失败", e);
    			message.setMessageStatus(MessageStatus.SYS_ERROR);
    		}
    		return message;
    	}

		
	public Message<List<IndustryDataHalfYear>> getListByIndustryIdYaar(Integer industryId, Integer yaar){

		Message<List<IndustryDataHalfYear>> message = new Message<List<IndustryDataHalfYear>>();
		try {
			List<IndustryDataHalfYear> industryDataHalfYearList = industryDataHalfYearDAO.selectByIndustryIdYaar(industryId, yaar);
			message.setData(industryDataHalfYearList);
		} catch (Exception e) {
			LOGGER.error("getListByIndustryIdYaar","查询IndustryDataHalfYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
			
	public Message<List<IndustryDataHalfYear>> getListByYaarIndustrySubId(Integer yaar, Integer industrySubId){

		Message<List<IndustryDataHalfYear>> message = new Message<List<IndustryDataHalfYear>>();
		try {
			List<IndustryDataHalfYear> industryDataHalfYearList = industryDataHalfYearDAO.selectByYaarIndustrySubId(yaar, industrySubId);
			message.setData(industryDataHalfYearList);
		} catch (Exception e) {
			LOGGER.error("getListByYaarIndustrySubId","查询IndustryDataHalfYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
			
	public Message<List<IndustryDataHalfYear>> getListByIndustryId(Integer industryId){

		Message<List<IndustryDataHalfYear>> message = new Message<List<IndustryDataHalfYear>>();
		try {
			List<IndustryDataHalfYear> industryDataHalfYearList = industryDataHalfYearDAO.selectByIndustryId(industryId);
			message.setData(industryDataHalfYearList);
		} catch (Exception e) {
			LOGGER.error("getListByIndustryId","查询IndustryDataHalfYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
			
	public Message<List<IndustryDataHalfYear>> getListByYaar(Integer yaar){

		Message<List<IndustryDataHalfYear>> message = new Message<List<IndustryDataHalfYear>>();
		try {
			List<IndustryDataHalfYear> industryDataHalfYearList = industryDataHalfYearDAO.selectByYaar(yaar);
			message.setData(industryDataHalfYearList);
		} catch (Exception e) {
			LOGGER.error("getListByYaar","查询IndustryDataHalfYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
		

}