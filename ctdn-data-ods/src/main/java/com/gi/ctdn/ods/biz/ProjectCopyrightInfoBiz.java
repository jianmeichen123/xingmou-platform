

package com.gi.ctdn.ods.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.ods.dao.ProjectCopyrightInfoDAO;
import com.gi.xm.platform.view.common.MessageStatus;
import com.gi.xm.platform.view.common.MessageInfo;

import com.gi.ctdn.ods.pojo.ProjectCopyrightInfo;

@Service("projectCopyrightInfoBiz")
public class ProjectCopyrightInfoBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectCopyrightInfoBiz.class);

    @Autowired
	ProjectCopyrightInfoDAO projectCopyrightInfoDAO;


		
	public MessageInfo<List<ProjectCopyrightInfo>> getListBySourceCode(String sourceCode){

		MessageInfo<List<ProjectCopyrightInfo>> messageInfo = new MessageInfo<List<ProjectCopyrightInfo>>();
		try {
			List<ProjectCopyrightInfo> projectCopyrightInfoList = projectCopyrightInfoDAO.selectBySourceCode(sourceCode);
			messageInfo.setData(projectCopyrightInfoList);
		} catch (Exception e) {
			LOGGER.error("getListBySourceCode","查询ProjectCopyrightInfo失败", e);
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
		}
		return messageInfo;
	}
		


    public MessageInfo<List<ProjectCopyrightInfo>> getAllProjectCopyrightInfo(){

		MessageInfo<List<ProjectCopyrightInfo>> messageInfo = new MessageInfo<List<ProjectCopyrightInfo>>();
		try {
			List<ProjectCopyrightInfo> projectCopyrightInfoList = projectCopyrightInfoDAO.selectAll();
			messageInfo.setData( projectCopyrightInfoList);
		} catch (Exception e) {
			LOGGER.error("getAllProjectCopyrightInfo","查询全部ProjectCopyrightInfo失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
}