

package com.gi.ctdn.biz;

import com.gi.ctdn.dao.*;
import com.gi.ctdn.pojo.*;
import com.gi.ctdn.view.common.MessageInfo;
import com.gi.ctdn.view.common.MessageStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("projectBusinessInfoBiz")
public class ProjectBusinessInfoBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectBusinessInfoBiz.class);

    @Autowired
	ProjectBusinessInfoDAO projectBusinessInfoDAO;

    @Autowired
	ProjectBusinessChangeDAO projectBusinessChangeDAO;

    @Autowired
	ProjectShareholderInfoDAO projectShareholderInfoDAO;

    @Autowired
	ProjectContactDAO projectContactDAO;

    @Autowired
	EventInfoDAO eventInfoDAO;

    public MessageInfo<ProjectBusinessListInfo> getProjectBusinessListInfoBySourceCode(String sourceCode){
    	MessageInfo<ProjectBusinessListInfo> messageInfo = new MessageInfo<>();
		try {
			ProjectBusinessListInfo projectBusinessListInfo = projectBusinessInfoDAO.selectProjectBusinessInfoBySourceCode(sourceCode);
			if(projectBusinessListInfo!=null){
				List<ProjectShareholderInfo> projectShareholderInfoList = projectShareholderInfoDAO.selectBySourceCode(sourceCode);
				List<ProjectBusinessChange> projectBusinessChangeList = projectBusinessChangeDAO.selectBySourceCode(sourceCode);
				List<ProjectContact> projectContactList = projectContactDAO.selectByProjectCode(sourceCode);

				projectBusinessListInfo.setProjectShareholderInfoList(projectShareholderInfoList);
				projectBusinessListInfo.setProjectBusinessChangeList(projectBusinessChangeList);
				projectBusinessListInfo.setProjectContactList(projectContactList);
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


	public MessageInfo<ProjectBusinessInfo> getListByRegName(String regName){
		MessageInfo<ProjectBusinessInfo> messageInfo = new MessageInfo<ProjectBusinessInfo>();
		try {
			ProjectBusinessInfo projectBusinessInfo = projectBusinessInfoDAO.selectByRegName(regName);
			messageInfo.setData(projectBusinessInfo);
		} catch (Exception e) {
			LOGGER.error("getListByRegName","查询ProjectBusinessInfo失败", e);
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