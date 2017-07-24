

package com.gi.ctdn.ods.biz;

import java.util.List;

import com.gi.ctdn.ods.dao.ProjectBusinessChangeDAO;
import com.gi.ctdn.ods.dao.ProjectShareholderInfoDAO;
import com.gi.ctdn.ods.pojo.ProjectBusinessChange;
import com.gi.ctdn.ods.pojo.ProjectBusinessListInfo;
import com.gi.ctdn.ods.pojo.ProjectShareholderInfo;
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

    @Autowired
	ProjectBusinessChangeDAO projectBusinessChangeDAO;

    @Autowired
	ProjectShareholderInfoDAO projectShareholderInfoDAO;


    public MessageInfo<ProjectBusinessListInfo> getProjectBusinessListInfoBySourceCode(String sourceCode){
    	MessageInfo<ProjectBusinessListInfo> messageInfo = new MessageInfo<>();
		try {
			ProjectBusinessListInfo projectBusinessListInfo = projectBusinessInfoDAO.selectProjectBusinessInfoBySourceCode(sourceCode);
			if(projectBusinessListInfo!=null){
				List<ProjectShareholderInfo> projectShareholderInfoList = projectShareholderInfoDAO.selectBySourceCode(sourceCode);
				List<ProjectBusinessChange> projectBusinessChangeList = projectBusinessChangeDAO.selectBySourceCode(sourceCode);

				projectBusinessListInfo.setProjectShareholderInfoList(projectShareholderInfoList);
				projectBusinessListInfo.setProjectBusinessChangeList(projectBusinessChangeList);
			}
			messageInfo.setData(projectBusinessListInfo);
			System.out.println(messageInfo);
		} catch (Exception e) {
			LOGGER.error("getProjectBusinessListInfoBySourceCode","查询ProjectBusinessListInfo失败", e);
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
		}
		return messageInfo;
	}

		
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