

package com.gi.ctdn.biz;

import com.gi.ctdn.pojo.EventInfo;
import com.gi.ctdn.pojo.ProjectMediaInfo;
import com.gi.ctdn.pojo.ProjectTeam;
import com.gi.ctdn.view.common.MessageInfo;
import com.gi.ctdn.view.common.MessageStatus;
import com.gi.ctdn.view.common.Pagination;
import com.gi.ctdn.view.common.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.regexp.internal.RE;
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

	public MessageInfo<List<ProjectMediaInfo>> queryMediaInfoList(ProjectMediaInfo projectMediaInfo){

		MessageInfo<List<ProjectMediaInfo>> messageInfo = new MessageInfo<List<ProjectMediaInfo>>();
		try {
			List<ProjectMediaInfo> projectMediaInfoList = projectMediaInfoDAO.selectBySourceCodeAndType(projectMediaInfo.getProjectCode(),projectMediaInfo.getType());
			messageInfo.setData(projectMediaInfoList);
		} catch (Exception e) {
			LOGGER.error("getListBySourcecode","查询ProjectTeam失败", e);
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
		}
		return messageInfo;
	}

}