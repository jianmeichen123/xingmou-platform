

package com.gi.xm.platform.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.platform.dao.IndustryFirstDataYearDAO;

import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.MessageStatus;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.IndustryFirstDataYear;
import com.gi.xm.platform.query.IndustryFirstDataYearQuery;

@Service("industryFirstDataYearBiz")
public class IndustryFirstDataYearBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(IndustryFirstDataYearBiz.class);

    @Autowired
	IndustryFirstDataYearDAO industryFirstDataYearDAO;



	
	public Message<Integer> deleteIndustryFirstDataYear(Long id){
		Message<Integer> message = new Message<Integer>();
		try {

			int result = industryFirstDataYearDAO.deleteByPrimaryKey(id);
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete","删除失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	

    public Message<Long> createIndustryFirstDataYear(IndustryFirstDataYear industryFirstDataYear){
		Message<Long> message = new Message<Long>();
		try {
						        				        				        				        							industryFirstDataYearDAO.insert( industryFirstDataYear );
			message.setData(industryFirstDataYear.getId());

		} catch (Exception e) {
			LOGGER.error("createIndustryFirstDataYear","创建IndustryFirstDataYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	public Message<Integer> updateIndustryFirstDataYear(IndustryFirstDataYear industryFirstDataYear){
		Message<Integer> message = new Message<Integer>();
		try {

			IndustryFirstDataYear industryFirstDataYearLast = industryFirstDataYearDAO.selectByPrimaryKeyForUpdate( industryFirstDataYear.getId() );
			if( industryFirstDataYearLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}

						        				        				        				        							int result = industryFirstDataYearDAO.updateByPrimaryKey( industryFirstDataYear );
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("updateIndustryFirstDataYear","更新IndustryFirstDataYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

		public Message<IndustryFirstDataYear> getIndustryFirstDataYear( Long id ){
		Message<IndustryFirstDataYear> message = new Message<IndustryFirstDataYear>();
		try {
			IndustryFirstDataYear industryFirstDataYear = industryFirstDataYearDAO.selectByPrimaryKey( id );
			message.setData(industryFirstDataYear);

		} catch (Exception e) {
			LOGGER.error("getIndustryFirstDataYear","根据主键查询IndustryFirstDataYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    public Message<List<IndustryFirstDataYear>> getAllIndustryFirstDataYear(){

		Message<List<IndustryFirstDataYear>> message = new Message<List<IndustryFirstDataYear>>();
		try {
			List<IndustryFirstDataYear> industryFirstDataYearList = industryFirstDataYearDAO.selectAll();
			message.setData( industryFirstDataYearList);
		} catch (Exception e) {
			LOGGER.error("getAllIndustryFirstDataYear","查询全部IndustryFirstDataYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	public Message<QueryResult<IndustryFirstDataYear>> queryIndustryFirstDataYear(IndustryFirstDataYearQuery industryFirstDataYearQuery) {
		Message<QueryResult<IndustryFirstDataYear>> message = new Message<QueryResult<IndustryFirstDataYear>>();
		try {
			QueryResult<IndustryFirstDataYear> queryResult = new QueryResult<IndustryFirstDataYear>();
			PageHelper.startPage(industryFirstDataYearQuery.getPageIndex(), industryFirstDataYearQuery.getPageSize());
			List<IndustryFirstDataYear> industryFirstDataYearList = industryFirstDataYearDAO.queryIndustryFirstDataYear(industryFirstDataYearQuery);
			PageInfo<IndustryFirstDataYear> pageInfo = new PageInfo<IndustryFirstDataYear>(industryFirstDataYearList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(industryFirstDataYearList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryIndustryFirstDataYear", "分页查询IndustryFirstDataYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    	public Message<List<IndustryFirstDataYear>> query(IndustryFirstDataYearQuery industryFirstDataYearQuery) {
    		Message<List<IndustryFirstDataYear>> message = new Message<List<IndustryFirstDataYear>>();
    		try {
    			List<IndustryFirstDataYear> industryFirstDataYearList = industryFirstDataYearDAO.queryIndustryFirstDataYear(industryFirstDataYearQuery);
    			message.setData(industryFirstDataYearList);
    		} catch (Exception e) {
    			LOGGER.error("queryIndustryFirstDataYear", "多条件查询IndustryFirstDataYear失败", e);
    			message.setMessageStatus(MessageStatus.SYS_ERROR);
    		}
    		return message;
    	}

		
	public Message<List<IndustryFirstDataYear>> getListByIndustryIdYaar(Integer industryId,Integer[] yaars){

		Message<List<IndustryFirstDataYear>> message = new Message<List<IndustryFirstDataYear>>();
		try {
			List<IndustryFirstDataYear> industryFirstDataYearList = industryFirstDataYearDAO.selectByIndustryIdYaar(industryId, yaars);
			message.setData(industryFirstDataYearList);
		} catch (Exception e) {
			LOGGER.error("getListByIndustryIdYaar","查询IndustryFirstDataYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
			
	public Message<List<IndustryFirstDataYear>> getListByYaar(Integer[] yaars){

		Message<List<IndustryFirstDataYear>> message = new Message<List<IndustryFirstDataYear>>();
		try {
			List<IndustryFirstDataYear> industryFirstDataYearList = industryFirstDataYearDAO.selectByYaar(yaars);
			message.setData(industryFirstDataYearList);
		} catch (Exception e) {
			LOGGER.error("getListByYaar","查询IndustryFirstDataYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
			
	public Message<List<IndustryFirstDataYear>> getListByIndustryId(Integer industryId){

		Message<List<IndustryFirstDataYear>> message = new Message<List<IndustryFirstDataYear>>();
		try {
			List<IndustryFirstDataYear> industryFirstDataYearList = industryFirstDataYearDAO.selectByIndustryId(industryId);
			message.setData(industryFirstDataYearList);
		} catch (Exception e) {
			LOGGER.error("getListByIndustryId","查询IndustryFirstDataYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
			

		

}