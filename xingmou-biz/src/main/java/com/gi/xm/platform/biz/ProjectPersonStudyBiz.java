

package com.gi.xm.platform.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.platform.dao.ProjectPersonStudyDAO;

import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.MessageStatus;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.ProjectPersonStudy;
import com.gi.xm.platform.query.ProjectPersonStudyQuery;

@Service("projectPersonStudyBiz")
public class ProjectPersonStudyBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectPersonStudyBiz.class);

    @Autowired
	ProjectPersonStudyDAO projectPersonStudyDAO;



	
	public Message<Integer> deleteProjectPersonStudy(Long id){
		Message<Integer> message = new Message<Integer>();
		try {

			int result = projectPersonStudyDAO.deleteByPrimaryKey(id);
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete","删除失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	

    public Message<Long> createProjectPersonStudy(ProjectPersonStudy projectPersonStudy){
		Message<Long> message = new Message<Long>();
		try {
									projectPersonStudyDAO.insert( projectPersonStudy );
			message.setData(projectPersonStudy.getId());

		} catch (Exception e) {
			LOGGER.error("createProjectPersonStudy","创建ProjectPersonStudy失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	public Message<Integer> updateProjectPersonStudy(ProjectPersonStudy projectPersonStudy){
		Message<Integer> message = new Message<Integer>();
		try {

			ProjectPersonStudy projectPersonStudyLast = projectPersonStudyDAO.selectByPrimaryKeyForUpdate( projectPersonStudy.getId() );
			if( projectPersonStudyLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}

									int result = projectPersonStudyDAO.updateByPrimaryKey( projectPersonStudy );
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("updateProjectPersonStudy","更新ProjectPersonStudy失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

		public Message<ProjectPersonStudy> getProjectPersonStudy( Long id ){
		Message<ProjectPersonStudy> message = new Message<ProjectPersonStudy>();
		try {
			ProjectPersonStudy projectPersonStudy = projectPersonStudyDAO.selectByPrimaryKey( id );
			message.setData(projectPersonStudy);

		} catch (Exception e) {
			LOGGER.error("getProjectPersonStudy","根据主键查询ProjectPersonStudy失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	/**
	 * 根据personId获取学习经历列表
	 * @return
	 */
	public Message<List<ProjectPersonStudy>> getStudyListByPid(List<Integer> idList){

			Message<List<ProjectPersonStudy>> message = new Message<List<ProjectPersonStudy>>();
			try {
				List<ProjectPersonStudy> projectPersonStudyList = projectPersonStudyDAO.selectListByPid(idList);
				message.setData( projectPersonStudyList);
			} catch (Exception e) {
				LOGGER.error("getStudyListByPid","根据personId获取学习经历列表getStudyListByPid失败", e);
				message.setMessageStatus(MessageStatus.SYS_ERROR);
			}
			return message;
	}
    public Message<List<ProjectPersonStudy>> getAllProjectPersonStudy(){

		Message<List<ProjectPersonStudy>> message = new Message<List<ProjectPersonStudy>>();
		try {
			List<ProjectPersonStudy> projectPersonStudyList = projectPersonStudyDAO.selectAll();
			message.setData( projectPersonStudyList);
		} catch (Exception e) {
			LOGGER.error("getAllProjectPersonStudy","查询全部ProjectPersonStudy失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	public Message<QueryResult<ProjectPersonStudy>> queryProjectPersonStudy(ProjectPersonStudyQuery projectPersonStudyQuery) {
		Message<QueryResult<ProjectPersonStudy>> message = new Message<QueryResult<ProjectPersonStudy>>();
		try {
			QueryResult<ProjectPersonStudy> queryResult = new QueryResult<ProjectPersonStudy>();
			PageHelper.startPage(projectPersonStudyQuery.getPageIndex(), projectPersonStudyQuery.getPageSize());
			List<ProjectPersonStudy> projectPersonStudyList = projectPersonStudyDAO.queryProjectPersonStudy(projectPersonStudyQuery);
			PageInfo<ProjectPersonStudy> pageInfo = new PageInfo<ProjectPersonStudy>(projectPersonStudyList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(projectPersonStudyList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryProjectPersonStudy", "分页查询ProjectPersonStudy失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	

}