

package com.gi.ctdn.biz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.dao.ProjectTeamDAO;

@Service("projectTeamBiz")
public class ProjectTeamBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectTeamBiz.class);

    @Autowired
	ProjectTeamDAO projectTeamDAO;
//
//	public MessageInfo<List<ProjectTeam>> getListBySourcecode(String sourcecode){
//
//		MessageInfo<List<ProjectTeam>> messageInfo = new MessageInfo<List<ProjectTeam>>();
//		try {
//			List<ProjectTeam> projectTeamList = projectTeamDAO.selectBySourcecode(sourcecode);
//			messageInfo.setData(projectTeamList);
//		} catch (Exception e) {
//			LOGGER.error("getListBySourcecode","查询ProjectTeam失败", e);
//			messageInfo.setStatus(MessageStatus.ERROR_CODE);
//		}
//		return messageInfo;
//	}

}