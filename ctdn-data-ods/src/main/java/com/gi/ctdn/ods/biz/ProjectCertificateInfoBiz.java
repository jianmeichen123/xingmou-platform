

package com.gi.ctdn.ods.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.ods.dao.ProjectCertificateInfoDAO;
import com.gi.xm.platform.view.common.MessageStatus;
import com.gi.xm.platform.view.common.MessageInfo;

import com.gi.ctdn.ods.pojo.ProjectCertificateInfo;

@Service("projectCertificateInfoBiz")
public class ProjectCertificateInfoBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectCertificateInfoBiz.class);

    @Autowired
	ProjectCertificateInfoDAO projectCertificateInfoDAO;


		
	public MessageInfo<List<ProjectCertificateInfo>> getListBySourceCode(String sourceCode){

		MessageInfo<List<ProjectCertificateInfo>> messageInfo = new MessageInfo<List<ProjectCertificateInfo>>();
		try {
			List<ProjectCertificateInfo> projectCertificateInfoList = projectCertificateInfoDAO.selectBySourceCode(sourceCode);
			messageInfo.setData(projectCertificateInfoList);
		} catch (Exception e) {
			LOGGER.error("getListBySourceCode","查询ProjectCertificateInfo失败", e);
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
		}
		return messageInfo;
	}
		


    public MessageInfo<List<ProjectCertificateInfo>> getAllProjectCertificateInfo(){

		MessageInfo<List<ProjectCertificateInfo>> messageInfo = new MessageInfo<List<ProjectCertificateInfo>>();
		try {
			List<ProjectCertificateInfo> projectCertificateInfoList = projectCertificateInfoDAO.selectAll();
			messageInfo.setData( projectCertificateInfoList);
		} catch (Exception e) {
			LOGGER.error("getAllProjectCertificateInfo","查询全部ProjectCertificateInfo失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
}