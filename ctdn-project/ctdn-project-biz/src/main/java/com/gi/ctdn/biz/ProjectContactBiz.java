

package com.gi.ctdn.biz;

import com.gi.ctdn.dao.ProjectContactDAO;
import com.gi.ctdn.pojo.ProjectContactInfo;
import com.gi.ctdn.query.ProjectContactQueryInfo;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("projectContactBiz")
public class ProjectContactBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectContactBiz.class);

    @Autowired
	ProjectContactDAO projectContactDAO;

    public MessageInfo<Long> createProjectContact(ProjectContactInfo projectContact){
		MessageInfo<Long> messageInfo = new MessageInfo<Long>();
		try {
			projectContactDAO.insert( projectContact );
			messageInfo.setData(projectContact.getId());

		} catch (Exception e) {
			LOGGER.error("createProjectContact","创建ProjectContact失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

	public MessageInfo<Long> updateProjectContact(ProjectContactInfo projectContact){
		MessageInfo<Long> messageInfo = new MessageInfo<Long>();
		try {
			projectContactDAO.insert( projectContact );
			messageInfo.setData(projectContact.getId());

		} catch (Exception e) {
			LOGGER.error("updateProjectContact","修改ProjectContact失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

	public MessageInfo<ProjectContactInfo> queryByProjectId(Long projectId){
		MessageInfo<ProjectContactInfo> messageInfo = new MessageInfo<ProjectContactInfo>();
		try {
			ProjectContactInfo projectContactInfo = projectContactDAO.queryByProjectId( projectId );
			messageInfo.setData(projectContactInfo);
		} catch (Exception e) {
			LOGGER.error("updateProjectContact","修改ProjectContact失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}


	public MessageInfo<QueryResultInfo<ProjectContactInfo>> queryProjectContact(ProjectContactQueryInfo projectContactQuery) {
		MessageInfo<QueryResultInfo<ProjectContactInfo>> messageInfo = new MessageInfo<QueryResultInfo<ProjectContactInfo>>();
		try {
			QueryResultInfo<ProjectContactInfo> queryResult = new QueryResultInfo<ProjectContactInfo>();
			PageHelper.startPage(projectContactQuery.getPageIndex(), projectContactQuery.getPageSize());
			List<ProjectContactInfo> projectContactList = projectContactDAO.queryProjectContact(projectContactQuery);
			PageInfo<ProjectContactInfo> pageInfo = new PageInfo<ProjectContactInfo>(projectContactList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(projectContactList);
			messageInfo.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryProjectContact", "分页查询ProjectContact失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

}