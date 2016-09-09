

package com.gi.xm.platform.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.platform.dao.FilesDAO;

import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.MessageStatus;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.Files;
import com.gi.xm.platform.query.FilesQuery;

@Service("filesBiz")
public class FilesBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(FilesBiz.class);

    @Autowired
	FilesDAO filesDAO;



	
	public Message<Integer> deleteFiles(Long id){
		Message<Integer> message = new Message<Integer>();
		try {

			int result = filesDAO.deleteByPrimaryKey(id);
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete","删除失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	

    public Message<Long> createFiles(Files files){
		Message<Long> message = new Message<Long>();
		try {
						        							filesDAO.insert( files );
			message.setData(files.getId());

		} catch (Exception e) {
			LOGGER.error("createFiles","创建Files失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	public Message<Integer> updateFiles(Files files){
		Message<Integer> message = new Message<Integer>();
		try {

			Files filesLast = filesDAO.selectByPrimaryKeyForUpdate( files.getId() );
			if( filesLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}

						        							int result = filesDAO.updateByPrimaryKey( files );
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("updateFiles","更新Files失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

		public Message<Files> getFiles( Long id ){
		Message<Files> message = new Message<Files>();
		try {
			Files files = filesDAO.selectByPrimaryKey( id );
			message.setData(files);

		} catch (Exception e) {
			LOGGER.error("getFiles","根据主键查询Files失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    public Message<List<Files>> getAllFiles(){

		Message<List<Files>> message = new Message<List<Files>>();
		try {
			List<Files> filesList = filesDAO.selectAll();
			message.setData( filesList);
		} catch (Exception e) {
			LOGGER.error("getAllFiles","查询全部Files失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	public Message<QueryResult<Files>> queryFiles(FilesQuery filesQuery) {
		Message<QueryResult<Files>> message = new Message<QueryResult<Files>>();
		try {
			QueryResult<Files> queryResult = new QueryResult<Files>();
			PageHelper.startPage(filesQuery.getPageIndex(), filesQuery.getPageSize());
			List<Files> filesList = filesDAO.queryFiles(filesQuery);
			PageInfo<Files> pageInfo = new PageInfo<Files>(filesList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(filesList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryFiles", "分页查询Files失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

		
	public Message<List<Files>> getListBySourceId(Long sourceId){

		Message<List<Files>> message = new Message<List<Files>>();
		try {
			List<Files> filesList = filesDAO.selectBySourceId(sourceId);
			message.setData(filesList);
		} catch (Exception e) {
			LOGGER.error("getListBySourceId","查询Files失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
		

}