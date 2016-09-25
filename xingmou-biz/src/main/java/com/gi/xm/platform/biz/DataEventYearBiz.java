

package com.gi.xm.platform.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.platform.dao.DataEventYearDAO;

import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.MessageStatus;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.DataEventYear;
import com.gi.xm.platform.query.DataEventYearQuery;

@Service("dataEventYearBiz")
public class DataEventYearBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(DataEventYearBiz.class);

    @Autowired
	DataEventYearDAO dataEventYearDAO;



	
	public Message<Integer> deleteDataEventYear(Long id){
		Message<Integer> message = new Message<Integer>();
		try {

			int result = dataEventYearDAO.deleteByPrimaryKey(id);
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete","删除失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	

    public Message<Long> createDataEventYear(DataEventYear dataEventYear){
		Message<Long> message = new Message<Long>();
		try {
						        				        				        				        				        				        				        							dataEventYearDAO.insert( dataEventYear );
			message.setData(dataEventYear.getId());

		} catch (Exception e) {
			LOGGER.error("createDataEventYear","创建DataEventYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	public Message<Integer> updateDataEventYear(DataEventYear dataEventYear){
		Message<Integer> message = new Message<Integer>();
		try {

			DataEventYear dataEventYearLast = dataEventYearDAO.selectByPrimaryKeyForUpdate( dataEventYear.getId() );
			if( dataEventYearLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}

						        				        				        				        				        				        				        							int result = dataEventYearDAO.updateByPrimaryKey( dataEventYear );
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("updateDataEventYear","更新DataEventYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

		public Message<DataEventYear> getDataEventYear( Long id ){
		Message<DataEventYear> message = new Message<DataEventYear>();
		try {
			DataEventYear dataEventYear = dataEventYearDAO.selectByPrimaryKey( id );
			message.setData(dataEventYear);

		} catch (Exception e) {
			LOGGER.error("getDataEventYear","根据主键查询DataEventYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    public Message<List<DataEventYear>> getAllDataEventYear(){

		Message<List<DataEventYear>> message = new Message<List<DataEventYear>>();
		try {
			List<DataEventYear> dataEventYearList = dataEventYearDAO.selectAll();
			message.setData( dataEventYearList);
		} catch (Exception e) {
			LOGGER.error("getAllDataEventYear","查询全部DataEventYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	public Message<QueryResult<DataEventYear>> queryDataEventYear(DataEventYearQuery dataEventYearQuery) {
		Message<QueryResult<DataEventYear>> message = new Message<QueryResult<DataEventYear>>();
		try {
			QueryResult<DataEventYear> queryResult = new QueryResult<DataEventYear>();
			PageHelper.startPage(dataEventYearQuery.getPageIndex(), dataEventYearQuery.getPageSize());
			List<DataEventYear> dataEventYearList = dataEventYearDAO.queryDataEventYear(dataEventYearQuery);
			PageInfo<DataEventYear> pageInfo = new PageInfo<DataEventYear>(dataEventYearList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(dataEventYearList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryDataEventYear", "分页查询DataEventYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    	public Message<List<DataEventYear>> query(DataEventYearQuery dataEventYearQuery) {
    		Message<List<DataEventYear>> message = new Message<List<DataEventYear>>();
    		try {
    			List<DataEventYear> dataEventYearList = dataEventYearDAO.queryDataEventYear(dataEventYearQuery);
    			message.setData(dataEventYearList);
    		} catch (Exception e) {
    			LOGGER.error("queryDataEventYear", "多条件查询DataEventYear失败", e);
    			message.setMessageStatus(MessageStatus.SYS_ERROR);
    		}
    		return message;
    	}

		
	public Message<List<DataEventYear>> getListByYearIndustryId(Integer years[], Integer industryId){

		Message<List<DataEventYear>> message = new Message<List<DataEventYear>>();
		try {
			List<DataEventYear> dataEventYearList = dataEventYearDAO.selectByYearIndustryId(years, industryId);
			message.setData(dataEventYearList);
		} catch (Exception e) {
			LOGGER.error("getListByYearIndustryId","查询DataEventYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
			
	public Message<List<DataEventYear>> getListByYearIndustrySubId(Integer[] years, Integer industrySubId){

		Message<List<DataEventYear>> message = new Message<List<DataEventYear>>();
		try {
			List<DataEventYear> dataEventYearList = dataEventYearDAO.selectByYearIndustrySubId(years, industrySubId);
			message.setData(dataEventYearList);
		} catch (Exception e) {
			LOGGER.error("getListByYearIndustrySubId","查询DataEventYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
			
	public Message<List<DataEventYear>> getListByDistrictId(Integer districtId){

		Message<List<DataEventYear>> message = new Message<List<DataEventYear>>();
		try {
			List<DataEventYear> dataEventYearList = dataEventYearDAO.selectByDistrictId(districtId);
			message.setData(dataEventYearList);
		} catch (Exception e) {
			LOGGER.error("getListByDistrictId","查询DataEventYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
			
	public Message<List<DataEventYear>> getListByIndustryId(Integer industryId){

		Message<List<DataEventYear>> message = new Message<List<DataEventYear>>();
		try {
			List<DataEventYear> dataEventYearList = dataEventYearDAO.selectByIndustryId(industryId);
			message.setData(dataEventYearList);
		} catch (Exception e) {
			LOGGER.error("getListByIndustryId","查询DataEventYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
			
	public Message<List<DataEventYear>> getListByMoneyLevelId(Integer moneyLevelId){

		Message<List<DataEventYear>> message = new Message<List<DataEventYear>>();
		try {
			List<DataEventYear> dataEventYearList = dataEventYearDAO.selectByMoneyLevelId(moneyLevelId);
			message.setData(dataEventYearList);
		} catch (Exception e) {
			LOGGER.error("getListByMoneyLevelId","查询DataEventYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
			
	public Message<List<DataEventYear>> getListByRoundId(Integer roundId){

		Message<List<DataEventYear>> message = new Message<List<DataEventYear>>();
		try {
			List<DataEventYear> dataEventYearList = dataEventYearDAO.selectByRoundId(roundId);
			message.setData(dataEventYearList);
		} catch (Exception e) {
			LOGGER.error("getListByRoundId","查询DataEventYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
			
	public Message<List<DataEventYear>> getListByYear(Integer years[]){

		Message<List<DataEventYear>> message = new Message<List<DataEventYear>>();
		try {
			List<DataEventYear> dataEventYearList = dataEventYearDAO.selectByYear(years);
			message.setData(dataEventYearList);
		} catch (Exception e) {
			LOGGER.error("getListByYear","查询DataEventYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
		

}