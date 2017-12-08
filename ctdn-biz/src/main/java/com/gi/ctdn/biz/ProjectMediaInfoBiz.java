

package com.gi.ctdn.biz;

import com.gi.ctdn.pojo.ProjectMediaInfo;
import com.gi.ctdn.view.common.MessageInfo;
import com.gi.ctdn.view.common.MessageStatus;
import com.gi.ctdn.view.common.Pagination;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.dao.ProjectMediaInfoDAO;

import java.util.List;

@Service("projectMediaInfoBiz")
public class ProjectMediaInfoBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectMediaInfoBiz.class);

    @Autowired
	ProjectMediaInfoDAO projectMediaInfoDAO;

	public MessageInfo<ProjectMediaInfo> queryMediaInfoList(ProjectMediaInfo projectMediaInfo){

		MessageInfo<ProjectMediaInfo> messageInfo;
		try {
			PageHelper.startPage(projectMediaInfo.getPageNo()+1, projectMediaInfo.getPageSize());
			List<ProjectMediaInfo> projectMediaInfoList = projectMediaInfoDAO.selectBySourceCodeAndType(projectMediaInfo.getProjectCode(),projectMediaInfo.getType());
			PageInfo<ProjectMediaInfo> pageInfo = new PageInfo<ProjectMediaInfo>(projectMediaInfoList);
			Pagination page = new Pagination();
			page.setTotal(pageInfo.getTotal());
			page.setRecords(projectMediaInfoList);
			messageInfo = new MessageInfo(MessageStatus.OK_CODE,MessageStatus.OK_MESSAGE,  page);
		} catch (Exception e) {
			LOGGER.error("getListByProjectCode","查询ProjectMediaInfo失败", e);
			messageInfo = new MessageInfo(MessageStatus.ERROR_CODE,e.getMessage());
		}
		return messageInfo;
	}

}