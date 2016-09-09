

package com.gi.xm.platform.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.platform.dao.DataDAO;

import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.MessageStatus;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.Data;
import com.gi.xm.platform.query.DataQuery;

@Service("dataBiz")
public class DataBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(DataBiz.class);

    @Autowired
	DataDAO dataDAO;



	
	public Message<Integer> deleteData(Integer id){
		Message<Integer> message = new Message<Integer>();
		try {

			int result = dataDAO.deleteByPrimaryKey(id);
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete","删除失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	

    public Message<Integer> createData(Data data){
		Message<Integer> message = new Message<Integer>();
		try {
									dataDAO.insert( data );
			message.setData(data.getId());

		} catch (Exception e) {
			LOGGER.error("createData","创建Data失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	public Message<Integer> updateData(Data data){
		Message<Integer> message = new Message<Integer>();
		try {

			Data dataLast = dataDAO.selectByPrimaryKeyForUpdate( data.getId() );
			if( dataLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}

									int result = dataDAO.updateByPrimaryKey( data );
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("updateData","更新Data失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

		public Message<Data> getData( Integer id ){
		Message<Data> message = new Message<Data>();
		try {
			Data data = dataDAO.selectByPrimaryKey( id );
			message.setData(data);

		} catch (Exception e) {
			LOGGER.error("getData","根据主键查询Data失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    public Message<List<Data>> getAllData(){

		Message<List<Data>> message = new Message<List<Data>>();
		try {
			List<Data> dataList = dataDAO.selectAll();
			message.setData( dataList);
		} catch (Exception e) {
			LOGGER.error("getAllData","查询全部Data失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	public Message<QueryResult<Data>> queryData(DataQuery dataQuery) {
		Message<QueryResult<Data>> message = new Message<QueryResult<Data>>();
		try {
			QueryResult<Data> queryResult = new QueryResult<Data>();
			PageHelper.startPage(dataQuery.getPageIndex(), dataQuery.getPageSize());
			List<Data> dataList = dataDAO.queryData(dataQuery);
			PageInfo<Data> pageInfo = new PageInfo<Data>(dataList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(dataList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryData", "分页查询Data失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	

}