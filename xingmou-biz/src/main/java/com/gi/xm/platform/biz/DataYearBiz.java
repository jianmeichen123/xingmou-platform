

package com.gi.xm.platform.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.platform.dao.DataYearDAO;

import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.MessageStatus;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.DataYear;
import com.gi.xm.platform.query.DataYearQuery;

@Service("dataYearBiz")
public class DataYearBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(DataYearBiz.class);

    @Autowired
	DataYearDAO dataYearDAO;



	
	public Message<Integer> deleteDataYear(Long id){
		Message<Integer> message = new Message<Integer>();
		try {

			int result = dataYearDAO.deleteByPrimaryKey(id);
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete","删除失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	

    public Message<Long> createDataYear(DataYear dataYear){
		Message<Long> message = new Message<Long>();
		try {
						        				        				        				        				        							dataYearDAO.insert( dataYear );
			message.setData(dataYear.getId());

		} catch (Exception e) {
			LOGGER.error("createDataYear","创建DataYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	public Message<Integer> updateDataYear(DataYear dataYear){
		Message<Integer> message = new Message<Integer>();
		try {

			DataYear dataYearLast = dataYearDAO.selectByPrimaryKeyForUpdate( dataYear.getId() );
			if( dataYearLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}

						        				        				        				        				        							int result = dataYearDAO.updateByPrimaryKey( dataYear );
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("updateDataYear","更新DataYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

		public Message<DataYear> getDataYear( Long id ){
		Message<DataYear> message = new Message<DataYear>();
		try {
			DataYear dataYear = dataYearDAO.selectByPrimaryKey( id );
			message.setData(dataYear);

		} catch (Exception e) {
			LOGGER.error("getDataYear","根据主键查询DataYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    public Message<List<DataYear>> getAllDataYear(){

		Message<List<DataYear>> message = new Message<List<DataYear>>();
		try {
			List<DataYear> dataYearList = dataYearDAO.selectAll();
			message.setData( dataYearList);
		} catch (Exception e) {
			LOGGER.error("getAllDataYear","查询全部DataYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	public Message<QueryResult<DataYear>> queryDataYear(DataYearQuery dataYearQuery) {
		Message<QueryResult<DataYear>> message = new Message<QueryResult<DataYear>>();
		try {
			QueryResult<DataYear> queryResult = new QueryResult<DataYear>();
			PageHelper.startPage(dataYearQuery.getPageIndex(), dataYearQuery.getPageSize());
			List<DataYear> dataYearList = dataYearDAO.queryDataYear(dataYearQuery);
			PageInfo<DataYear> pageInfo = new PageInfo<DataYear>(dataYearList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(dataYearList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryDataYear", "分页查询DataYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

		
	public Message<List<DataYear>> getListByDistrictId(Integer districtId){

		Message<List<DataYear>> message = new Message<List<DataYear>>();
		try {
			List<DataYear> dataYearList = dataYearDAO.selectByDistrictId(districtId);
			message.setData(dataYearList);
		} catch (Exception e) {
			LOGGER.error("getListByDistrictId","查询DataYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
			
	public Message<List<DataYear>> getListByIndustryId(Integer industryId){

		Message<List<DataYear>> message = new Message<List<DataYear>>();
		try {
			List<DataYear> dataYearList = dataYearDAO.selectByIndustryId(industryId);
			message.setData(dataYearList);
		} catch (Exception e) {
			LOGGER.error("getListByIndustryId","查询DataYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
			
	public Message<List<DataYear>> getListByMoneyLevelId(Integer moneyLevelId){

		Message<List<DataYear>> message = new Message<List<DataYear>>();
		try {
			List<DataYear> dataYearList = dataYearDAO.selectByMoneyLevelId(moneyLevelId);
			message.setData(dataYearList);
		} catch (Exception e) {
			LOGGER.error("getListByMoneyLevelId","查询DataYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
			
	public Message<List<DataYear>> getListByRoundId(Integer roundId){

		Message<List<DataYear>> message = new Message<List<DataYear>>();
		try {
			List<DataYear> dataYearList = dataYearDAO.selectByRoundId(roundId);
			message.setData(dataYearList);
		} catch (Exception e) {
			LOGGER.error("getListByRoundId","查询DataYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
			
	public Message<List<DataYear>> getListByYear(Integer[] years){

		Message<List<DataYear>> message = new Message<List<DataYear>>();
		try {
			List<DataYear> dataYearList = dataYearDAO.selectByYear(years);
			message.setData(dataYearList);
		} catch (Exception e) {
			LOGGER.error("getListByYear","查询DataYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}


	public Message<List<DataYear>> getListByYearIndustryId(Integer[] years, Integer industryId){

		Message<List<DataYear>> message = new Message<List<DataYear>>();
		try {
			List<DataYear> dataYearList = dataYearDAO.selectByYearIndustryId(years, industryId);
			message.setData(dataYearList);
		} catch (Exception e) {
			LOGGER.error("getListByYearIndustryId","查询DataYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	public Message<List<DataYear>> getListByYearIndustrySubId(Integer[] years, Integer industrySubId){

		Message<List<DataYear>> message = new Message<List<DataYear>>();
		try {
			List<DataYear> dataYearList = dataYearDAO.selectByYearIndustrySubId(years, industrySubId);
			message.setData(dataYearList);
		} catch (Exception e) {
			LOGGER.error("getListByYearIndustrySubId","查询DataYear失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

}