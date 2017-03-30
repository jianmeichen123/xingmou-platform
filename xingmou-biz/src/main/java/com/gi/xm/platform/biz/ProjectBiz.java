package com.gi.xm.platform.biz;

import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.MessageStatus;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.dao.ProjectDAO;
import com.gi.xm.platform.pojo.Project;
import com.gi.xm.platform.query.ProjectQuery;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("projectBiz")
public class ProjectBiz {


    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectBiz.class);

    @Autowired
    ProjectDAO projectDAO;


    public Message<Integer> deleteProject(Long id) {
        Message<Integer> message = new Message<Integer>();
        try {

            int result = projectDAO.deleteByPrimaryKey(id);
            message.setData(result);

        } catch (Exception e) {
            LOGGER.error("delete", "删除失败", e);
            message.setMessageStatus(MessageStatus.SYS_ERROR);
        }
        return message;
    }


    public Message<Long> createProject(Project project) {
        Message<Long> message = new Message<Long>();
        try {
            projectDAO.insert(project);
            message.setData(project.getId());

        } catch (Exception e) {
            LOGGER.error("createProject", "创建Project失败", e);
            message.setMessageStatus(MessageStatus.SYS_ERROR);
        }
        return message;
    }

    public Message<Integer> updateProject(Project project) {
        Message<Integer> message = new Message<Integer>();
        try {

            Project projectLast = projectDAO.selectByPrimaryKeyForUpdate(project.getId());
            if (projectLast == null) {
                message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
                return message;
            }

            int result = projectDAO.updateByPrimaryKey(project);
            message.setData(result);

        } catch (Exception e) {
            LOGGER.error("updateProject", "更新Project失败", e);
            message.setMessageStatus(MessageStatus.SYS_ERROR);
        }
        return message;
    }

    public Message<Integer> changeStatus(Long id, Integer status, String operatorId) {
        Message<Integer> message = new Message<Integer>();
        try {

            Project projectLast = projectDAO.selectByPrimaryKeyForUpdate(id);
            if (projectLast == null) {
                message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
                return message;
            }

            //TODO：其他判断

            int result = projectDAO.changeStatus(id, status, operatorId);
            message.setData(result);

        } catch (Exception e) {
            LOGGER.error("changeStatus", "更新Project状态失败", e);
            message.setMessageStatus(MessageStatus.SYS_ERROR);
        }
        return message;
    }

    public Message<Project> getProject(Long id) {
        Message<Project> message = new Message<Project>();
        try {
            Project project = projectDAO.selectByPrimaryKey(id);
            message.setData(project);

        } catch (Exception e) {
            LOGGER.error("getProject", "根据主键查询Project失败", e);
            message.setMessageStatus(MessageStatus.SYS_ERROR);
        }
        return message;
    }

    public Message<List<Project>> getAllProject() {

        Message<List<Project>> message = new Message<List<Project>>();
        try {
            List<Project> projectList = projectDAO.selectAll();
            message.setData(projectList);
        } catch (Exception e) {
            LOGGER.error("getAllProject", "查询全部Project失败", e);
            message.setMessageStatus(MessageStatus.SYS_ERROR);
        }
        return message;
    }

    public Message<QueryResult<Project>> queryProject(ProjectQuery projectQuery) {
        Message<QueryResult<Project>> message = new Message<QueryResult<Project>>();
        try {
            QueryResult<Project> queryResult = new QueryResult<Project>();
            PageHelper.startPage(projectQuery.getPageIndex(), projectQuery.getPageSize());
            List<Project> projectList = projectDAO.queryProject(projectQuery);
            PageInfo<Project> pageInfo = new PageInfo<Project>(projectList);
            queryResult.setPages(pageInfo.getPages());
            queryResult.setTotal(pageInfo.getTotal());
            queryResult.setRecords(projectList);
            message.setData(queryResult);
        } catch (Exception e) {
            LOGGER.error("queryProject", "分页查询Project失败", e);
            message.setMessageStatus(MessageStatus.SYS_ERROR);
        }
        return message;
    }

    public Message<QueryResult<Project>> searchProject(ProjectQuery projectQuery) {
        Message<QueryResult<Project>> message = new Message<QueryResult<Project>>();
        try {
            QueryResult<Project> queryResult = new QueryResult<Project>();
            PageHelper.startPage(projectQuery.getPageIndex(), projectQuery.getPageSize());
            List<Project> projectList = projectDAO.searchProject(projectQuery);
            PageInfo<Project> pageInfo = new PageInfo<Project>(projectList);
            queryResult.setPages(pageInfo.getPages());
            queryResult.setTotal(pageInfo.getTotal());
            queryResult.setRecords(projectList);
            message.setData(queryResult);
        } catch (Exception e) {
            LOGGER.error("queryProject", "分页查询Project失败", e);
            message.setMessageStatus(MessageStatus.SYS_ERROR);
        }
        return message;
    }

    public Message<List<Project>> getListBySourceId(Long sourceId) {

        Message<List<Project>> message = new Message<List<Project>>();
        try {
            List<Project> projectList = projectDAO.selectBySourceId(sourceId);
            message.setData(projectList);
        } catch (Exception e) {
            LOGGER.error("getListBySourceId", "查询Project失败", e);
            message.setMessageStatus(MessageStatus.SYS_ERROR);
        }
        return message;
    }


	public Message<QueryResult<Project>> queryCompetationlist(ProjectQuery projectQuery) {
		Message<QueryResult<Project>> message = new Message<QueryResult<Project>>();
        try {
            QueryResult<Project> queryResult = new QueryResult<Project>();
            List<Project> newList =  new ArrayList<>();
           // PageHelper.startPage(projectQuery.getPageIndex(), projectQuery.getPageSize());
            //查询竞品列表
            List<Project> pList = projectDAO.queryCompetationlist(projectQuery.getId());
            if(pList != null && !pList.isEmpty()){
                List<Project> cList =  projectDAO.queryCompetitiveSimilar(projectQuery.getId());
                for(Project s :cList){
                    String code = s.getCode();
                    Double similar = s.getSimilar();
                    for(Project p :pList){
                        if(code.equals(p.getCode())){
                            p.setSimilar(similar);
                            newList.add(p);
                        }
                    }
                }
            }
            PageInfo<Project> pageInfo = new PageInfo<Project>(newList);
          /*  queryResult.setPages(pageInfo.getPages());
            queryResult.setTotal(pageInfo.getTotal());*/
            queryResult.setRecords(newList);
            message.setData(queryResult);
        } catch (Exception e) {
            LOGGER.error("queryProject", "分页查询Project失败", e);
            message.setMessageStatus(MessageStatus.SYS_ERROR);
        }
        return message;
	}


}