

package com.gi.xm.platform.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.MessageStatus;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.dao.ProjectPersonJobDAO;
import com.gi.xm.platform.pojo.ProjectPersonJob;
import com.gi.xm.platform.query.ProjectPersonJobQuery;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("projectPersonJobBiz")
public class ProjectPersonJobBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectPersonJobBiz.class);

    @Autowired
	ProjectPersonJobDAO projectPersonJobDAO;



	
	public Message<Integer> deleteProjectPersonJob(Long id){
		Message<Integer> message = new Message<Integer>();
		try {

			int result = projectPersonJobDAO.deleteByPrimaryKey(id);
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete","删除失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	

    public Message<Long> createProjectPersonJob(ProjectPersonJob projectPersonJob){
		Message<Long> message = new Message<Long>();
		try {
									projectPersonJobDAO.insert( projectPersonJob );
			message.setData(projectPersonJob.getId());

		} catch (Exception e) {
			LOGGER.error("createProjectPersonJob","创建ProjectPersonJob失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	public Message<Integer> updateProjectPersonJob(ProjectPersonJob projectPersonJob){
		Message<Integer> message = new Message<Integer>();
		try {

			ProjectPersonJob projectPersonJobLast = projectPersonJobDAO.selectByPrimaryKeyForUpdate( projectPersonJob.getId() );
			if( projectPersonJobLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}

									int result = projectPersonJobDAO.updateByPrimaryKey( projectPersonJob );
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("updateProjectPersonJob","更新ProjectPersonJob失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	public Message<ProjectPersonJob> getProjectPersonJob( Long id ){
		Message<ProjectPersonJob> message = new Message<ProjectPersonJob>();
		try {
			ProjectPersonJob projectPersonJob = projectPersonJobDAO.selectByPrimaryKey( id );
			message.setData(projectPersonJob);

		} catch (Exception e) {
			LOGGER.error("getProjectPersonJob","根据主键查询ProjectPersonJob失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	
	/**
	 * 根据personId获取教育经历列表不分页
	 * @param idList
	 * @return
	 */
	public Message<List<ProjectPersonJob>> getPersonJobByPid(List<Integer> idList){
	
			Message<List<ProjectPersonJob>> message = new Message<List<ProjectPersonJob>>();
			try {
				List<ProjectPersonJob> projectPersonJobList = projectPersonJobDAO.selectByPersonId(idList);
				message.setData( projectPersonJobList);
			} catch (Exception e) {
				LOGGER.error("getPersonJobByPid","根据personId获取教育经历列表失败", e);
				message.setMessageStatus(MessageStatus.SYS_ERROR);
			}
			return message;
	}
	
    public Message<List<ProjectPersonJob>> getAllProjectPersonJob(){

		Message<List<ProjectPersonJob>> message = new Message<List<ProjectPersonJob>>();
		try {
			List<ProjectPersonJob> projectPersonJobList = projectPersonJobDAO.selectAll();
			message.setData( projectPersonJobList);
		} catch (Exception e) {
			LOGGER.error("getAllProjectPersonJob","查询全部ProjectPersonJob失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	public Message<QueryResult<ProjectPersonJob>> queryProjectPersonJob(ProjectPersonJobQuery projectPersonJobQuery) {
		Message<QueryResult<ProjectPersonJob>> message = new Message<QueryResult<ProjectPersonJob>>();
		try {
			QueryResult<ProjectPersonJob> queryResult = new QueryResult<ProjectPersonJob>();
			PageHelper.startPage(projectPersonJobQuery.getPageIndex(), projectPersonJobQuery.getPageSize());
			List<ProjectPersonJob> projectPersonJobList = projectPersonJobDAO.queryProjectPersonJob(projectPersonJobQuery);
			PageInfo<ProjectPersonJob> pageInfo = new PageInfo<ProjectPersonJob>(projectPersonJobList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(projectPersonJobList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryProjectPersonJob", "分页查询ProjectPersonJob失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	
	

	

}