

package com.gi.ctdn.ods.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.ods.dao.ProjectBusinessInfoDAO;
import com.gi.xm.platform.view.common.MessageStatus;
import com.gi.xm.platform.view.common.MessageInfo;

import com.gi.ctdn.ods.pojo.ProjectBusinessInfo;

@Service("projectBusinessInfoBiz")
public class ProjectBusinessInfoBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectBusinessInfoBiz.class);

    @Autowired
	ProjectBusinessInfoDAO projectBusinessInfoDAO;


		
	public MessageInfo<List<ProjectBusinessInfo>> getListBySourceCode(String sourceCode){

		MessageInfo<List<ProjectBusinessInfo>> messageInfo = new MessageInfo<List<ProjectBusinessInfo>>();
		try {
			List<ProjectBusinessInfo> projectBusinessInfoList = projectBusinessInfoDAO.selectBySourceCode(sourceCode);
			messageInfo.setData(projectBusinessInfoList);
		} catch (Exception e) {
			LOGGER.error("getListBySourceCode","查询ProjectBusinessInfo失败", e);
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
		}
		return messageInfo;
	}
		


    public MessageInfo<List<ProjectBusinessInfo>> getAllProjectBusinessInfo(){

		MessageInfo<List<ProjectBusinessInfo>> messageInfo = new MessageInfo<List<ProjectBusinessInfo>>();
		try {
			List<ProjectBusinessInfo> projectBusinessInfoList = projectBusinessInfoDAO.selectAll();
			messageInfo.setData( projectBusinessInfoList);
		} catch (Exception e) {
			LOGGER.error("getAllProjectBusinessInfo","查询全部ProjectBusinessInfo失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
}