

package com.gi.xm.platform.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.platform.dao.AreaDAO;

import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.MessageStatus;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.Area;
import com.gi.xm.platform.query.AreaQuery;

@Service("areaBiz")
public class AreaBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(AreaBiz.class);

    @Autowired
	AreaDAO areaDAO;



	
	public Message<Integer> deleteArea(Long id){
		Message<Integer> message = new Message<Integer>();
		try {

			int result = areaDAO.deleteByPrimaryKey(id);
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete","删除失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	

    public Message<Long> createArea(Area area){
		Message<Long> message = new Message<Long>();
		try {
									areaDAO.insert( area );
			message.setData(area.getId());

		} catch (Exception e) {
			LOGGER.error("createArea","创建Area失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	public Message<Integer> updateArea(Area area){
		Message<Integer> message = new Message<Integer>();
		try {

			Area areaLast = areaDAO.selectByPrimaryKeyForUpdate( area.getId() );
			if( areaLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}

									int result = areaDAO.updateByPrimaryKey( area );
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("updateArea","更新Area失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

		public Message<Area> getArea( Long id ){
		Message<Area> message = new Message<Area>();
		try {
			Area area = areaDAO.selectByPrimaryKey( id );
			message.setData(area);

		} catch (Exception e) {
			LOGGER.error("getArea","根据主键查询Area失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    public Message<List<Area>> getAllArea(){

		Message<List<Area>> message = new Message<List<Area>>();
		try {
			List<Area> areaList = areaDAO.selectAll();
			message.setData( areaList);
		} catch (Exception e) {
			LOGGER.error("getAllArea","查询全部Area失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	public Message<QueryResult<Area>> queryArea(AreaQuery areaQuery) {
		Message<QueryResult<Area>> message = new Message<QueryResult<Area>>();
		try {
			QueryResult<Area> queryResult = new QueryResult<Area>();
			PageHelper.startPage(areaQuery.getPageIndex(), areaQuery.getPageSize());
			List<Area> areaList = areaDAO.queryArea(areaQuery);
			PageInfo<Area> pageInfo = new PageInfo<Area>(areaList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(areaList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryArea", "分页查询Area失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	

}