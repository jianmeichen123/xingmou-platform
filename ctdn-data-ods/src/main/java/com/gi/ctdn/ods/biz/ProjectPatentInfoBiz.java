

package com.gi.ctdn.ods.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.ods.dao.ProjectPatentInfoDAO;
import com.gi.xm.platform.view.common.MessageStatus;
import com.gi.xm.platform.view.common.MessageInfo;

import com.gi.ctdn.ods.pojo.ProjectPatentInfo;

@Service("projectPatentInfoBiz")
public class ProjectPatentInfoBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectPatentInfoBiz.class);

    @Autowired
	ProjectPatentInfoDAO projectPatentInfoDAO;


		
	public MessageInfo<List<ProjectPatentInfo>> getListBySourceCode(String sourceCode){

		MessageInfo<List<ProjectPatentInfo>> messageInfo = new MessageInfo<List<ProjectPatentInfo>>();
		try {
			List<ProjectPatentInfo> projectPatentInfoList = projectPatentInfoDAO.selectBySourceCode(sourceCode);
			messageInfo.setData(projectPatentInfoList);
		} catch (Exception e) {
			LOGGER.error("getListBySourceCode","查询ProjectPatentInfo失败", e);
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
		}
		return messageInfo;
	}
		


    public MessageInfo<List<ProjectPatentInfo>> getAllProjectPatentInfo(){

		MessageInfo<List<ProjectPatentInfo>> messageInfo = new MessageInfo<List<ProjectPatentInfo>>();
		try {
			List<ProjectPatentInfo> projectPatentInfoList = projectPatentInfoDAO.selectAll();
			messageInfo.setData( projectPatentInfoList);
		} catch (Exception e) {
			LOGGER.error("getAllProjectPatentInfo","查询全部ProjectPatentInfo失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
}