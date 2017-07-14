

package com.gi.ctdn.ods.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.ods.dao.ProjectMarkInfoDAO;
import com.gi.xm.platform.view.common.MessageStatus;
import com.gi.xm.platform.view.common.MessageInfo;

import com.gi.ctdn.ods.pojo.ProjectMarkInfo;

@Service("projectMarkInfoBiz")
public class ProjectMarkInfoBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectMarkInfoBiz.class);

    @Autowired
	ProjectMarkInfoDAO projectMarkInfoDAO;


		
	public MessageInfo<List<ProjectMarkInfo>> getListBySourceCode(String sourceCode){

		MessageInfo<List<ProjectMarkInfo>> messageInfo = new MessageInfo<List<ProjectMarkInfo>>();
		try {
			List<ProjectMarkInfo> projectMarkInfoList = projectMarkInfoDAO.selectBySourceCode(sourceCode);
			messageInfo.setData(projectMarkInfoList);
		} catch (Exception e) {
			LOGGER.error("getListBySourceCode","查询ProjectMarkInfo失败", e);
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
		}
		return messageInfo;
	}
		


    public MessageInfo<List<ProjectMarkInfo>> getAllProjectMarkInfo(){

		MessageInfo<List<ProjectMarkInfo>> messageInfo = new MessageInfo<List<ProjectMarkInfo>>();
		try {
			List<ProjectMarkInfo> projectMarkInfoList = projectMarkInfoDAO.selectAll();
			messageInfo.setData( projectMarkInfoList);
		} catch (Exception e) {
			LOGGER.error("getAllProjectMarkInfo","查询全部ProjectMarkInfo失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
}