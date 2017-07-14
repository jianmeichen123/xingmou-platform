

package com.gi.ctdn.ods.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.ods.dao.ProjectSoftwareCopyrightInfoDAO;
import com.gi.xm.platform.view.common.MessageStatus;
import com.gi.xm.platform.view.common.MessageInfo;

import com.gi.ctdn.ods.pojo.ProjectSoftwareCopyrightInfo;

@Service("projectSoftwareCopyrightInfoBiz")
public class ProjectSoftwareCopyrightInfoBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectSoftwareCopyrightInfoBiz.class);

    @Autowired
	ProjectSoftwareCopyrightInfoDAO projectSoftwareCopyrightInfoDAO;


		
	public MessageInfo<List<ProjectSoftwareCopyrightInfo>> getListBySourceCode(String sourceCode){

		MessageInfo<List<ProjectSoftwareCopyrightInfo>> messageInfo = new MessageInfo<List<ProjectSoftwareCopyrightInfo>>();
		try {
			List<ProjectSoftwareCopyrightInfo> projectSoftwareCopyrightInfoList = projectSoftwareCopyrightInfoDAO.selectBySourceCode(sourceCode);
			messageInfo.setData(projectSoftwareCopyrightInfoList);
		} catch (Exception e) {
			LOGGER.error("getListBySourceCode","查询ProjectSoftwareCopyrightInfo失败", e);
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
		}
		return messageInfo;
	}
		


    public MessageInfo<List<ProjectSoftwareCopyrightInfo>> getAllProjectSoftwareCopyrightInfo(){

		MessageInfo<List<ProjectSoftwareCopyrightInfo>> messageInfo = new MessageInfo<List<ProjectSoftwareCopyrightInfo>>();
		try {
			List<ProjectSoftwareCopyrightInfo> projectSoftwareCopyrightInfoList = projectSoftwareCopyrightInfoDAO.selectAll();
			messageInfo.setData( projectSoftwareCopyrightInfoList);
		} catch (Exception e) {
			LOGGER.error("getAllProjectSoftwareCopyrightInfo","查询全部ProjectSoftwareCopyrightInfo失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
}