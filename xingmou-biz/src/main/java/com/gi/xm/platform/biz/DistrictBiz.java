

package com.gi.xm.platform.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.platform.dao.DistrictDAO;

import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.MessageStatus;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.District;
import com.gi.xm.platform.query.DistrictQuery;

@Service("districtBiz")
public class DistrictBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(DistrictBiz.class);

    @Autowired
	DistrictDAO districtDAO;



	
	public Message<Integer> deleteDistrict(Integer id){
		Message<Integer> message = new Message<Integer>();
		try {

			int result = districtDAO.deleteByPrimaryKey(id);
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete","删除失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	

    public Message<Integer> createDistrict(District district){
		Message<Integer> message = new Message<Integer>();
		try {
						        				        							districtDAO.insert( district );
			message.setData(district.getId());

		} catch (Exception e) {
			LOGGER.error("createDistrict","创建District失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	public Message<Integer> updateDistrict(District district){
		Message<Integer> message = new Message<Integer>();
		try {

			District districtLast = districtDAO.selectByPrimaryKeyForUpdate( district.getId() );
			if( districtLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}

						        				        							int result = districtDAO.updateByPrimaryKey( district );
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("updateDistrict","更新District失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

		public Message<District> getDistrict( Integer id ){
		Message<District> message = new Message<District>();
		try {
			District district = districtDAO.selectByPrimaryKey( id );
			message.setData(district);

		} catch (Exception e) {
			LOGGER.error("getDistrict","根据主键查询District失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    public Message<List<District>> getAllDistrict(){

		Message<List<District>> message = new Message<List<District>>();
		try {
			List<District> districtList = districtDAO.selectAll();
			message.setData( districtList);
		} catch (Exception e) {
			LOGGER.error("getAllDistrict","查询全部District失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	public Message<QueryResult<District>> queryDistrict(DistrictQuery districtQuery) {
		Message<QueryResult<District>> message = new Message<QueryResult<District>>();
		try {
			QueryResult<District> queryResult = new QueryResult<District>();
			PageHelper.startPage(districtQuery.getPageIndex(), districtQuery.getPageSize());
			List<District> districtList = districtDAO.queryDistrict(districtQuery);
			PageInfo<District> pageInfo = new PageInfo<District>(districtList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(districtList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryDistrict", "分页查询District失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

		
	public Message<List<District>> getListByTypeLevel(Integer type, Integer level){

		Message<List<District>> message = new Message<List<District>>();
		try {
			List<District> districtList = districtDAO.selectByTypeLevel(type, level);
			message.setData(districtList);
		} catch (Exception e) {
			LOGGER.error("getListByTypeLevel","查询District失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
			
	public Message<List<District>> getListByUpidDisplayorder(Integer upid, Integer displayorder){

		Message<List<District>> message = new Message<List<District>>();
		try {
			List<District> districtList = districtDAO.selectByUpidDisplayorder(upid, displayorder);
			message.setData(districtList);
		} catch (Exception e) {
			LOGGER.error("getListByUpidDisplayorder","查询District失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
		

}