

package com.gi.xm.platform.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.platform.dao.ProjectPersonDAO;

import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.MessageStatus;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.ProjectPerson;
import com.gi.xm.platform.query.ProjectPersonQuery;

@Service("projectPersonBiz")
public class ProjectPersonBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectPersonBiz.class);

    @Autowired
	ProjectPersonDAO projectPersonDAO;



	
	public Message<Integer> deleteProjectPerson(Integer id){
		Message<Integer> message = new Message<Integer>();
		try {

			int result = projectPersonDAO.deleteByPrimaryKey(id);
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete","删除失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	

    public Message<Integer> createProjectPerson(ProjectPerson projectPerson){
		Message<Integer> message = new Message<Integer>();
		try {
									projectPersonDAO.insert( projectPerson );
			message.setData(projectPerson.getId());

		} catch (Exception e) {
			LOGGER.error("createProjectPerson","创建ProjectPerson失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	public Message<Integer> updateProjectPerson(ProjectPerson projectPerson){
		Message<Integer> message = new Message<Integer>();
		try {

			ProjectPerson projectPersonLast = projectPersonDAO.selectByPrimaryKeyForUpdate( projectPerson.getId() );
			if( projectPersonLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}

									int result = projectPersonDAO.updateByPrimaryKey( projectPerson );
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("updateProjectPerson","更新ProjectPerson失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

		public Message<ProjectPerson> getProjectPerson( Integer id ){
		Message<ProjectPerson> message = new Message<ProjectPerson>();
		try {
			ProjectPerson projectPerson = projectPersonDAO.selectByPrimaryKey( id );
			message.setData(projectPerson);

		} catch (Exception e) {
			LOGGER.error("getProjectPerson","根据主键查询ProjectPerson失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    public Message<List<ProjectPerson>> getAllProjectPerson(){

		Message<List<ProjectPerson>> message = new Message<List<ProjectPerson>>();
		try {
			List<ProjectPerson> projectPersonList = projectPersonDAO.selectAll();
			message.setData( projectPersonList);
		} catch (Exception e) {
			LOGGER.error("getAllProjectPerson","查询全部ProjectPerson失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	public Message<QueryResult<ProjectPerson>> queryProjectPerson(ProjectPersonQuery projectPersonQuery) {
		Message<QueryResult<ProjectPerson>> message = new Message<QueryResult<ProjectPerson>>();
		try {
			QueryResult<ProjectPerson> queryResult = new QueryResult<ProjectPerson>();
			PageHelper.startPage(projectPersonQuery.getPageIndex(), projectPersonQuery.getPageSize());
			List<ProjectPerson> projectPersonList = projectPersonDAO.queryProjectPerson(projectPersonQuery);
			PageInfo<ProjectPerson> pageInfo = new PageInfo<ProjectPerson>(projectPersonList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(projectPersonList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryProjectPerson", "分页查询ProjectPerson失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	

}