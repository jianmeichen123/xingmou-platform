

package com.gi.ctdn.ods.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.ods.dao.ProjectWebInfoDAO;
import com.gi.xm.platform.view.common.MessageStatus;
import com.gi.xm.platform.view.common.MessageInfo;

import com.gi.ctdn.ods.pojo.ProjectWebInfo;

@Service("projectWebInfoBiz")
public class ProjectWebInfoBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectWebInfoBiz.class);

    @Autowired
	ProjectWebInfoDAO projectWebInfoDAO;


		
	public MessageInfo<List<ProjectWebInfo>> getListBySourceCode(String sourceCode){

		MessageInfo<List<ProjectWebInfo>> messageInfo = new MessageInfo<List<ProjectWebInfo>>();
		try {
			List<ProjectWebInfo> projectWebInfoList = projectWebInfoDAO.selectBySourceCode(sourceCode);
			messageInfo.setData(projectWebInfoList);
		} catch (Exception e) {
			LOGGER.error("getListBySourceCode","查询ProjectWebInfo失败", e);
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
		}
		return messageInfo;
	}
		


    public MessageInfo<List<ProjectWebInfo>> getAllProjectWebInfo(){

		MessageInfo<List<ProjectWebInfo>> messageInfo = new MessageInfo<List<ProjectWebInfo>>();
		try {
			List<ProjectWebInfo> projectWebInfoList = projectWebInfoDAO.selectAll();
			messageInfo.setData( projectWebInfoList);
		} catch (Exception e) {
			LOGGER.error("getAllProjectWebInfo","查询全部ProjectWebInfo失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
}