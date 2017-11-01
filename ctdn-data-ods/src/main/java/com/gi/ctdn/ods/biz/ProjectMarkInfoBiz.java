

package com.gi.ctdn.ods.biz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gi.ctdn.ods.dao.*;
import com.gi.ctdn.ods.pojo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.view.common.MessageStatus;
import com.gi.ctdn.view.common.MessageInfo;

@Service("projectMarkInfoBiz")
public class ProjectMarkInfoBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectMarkInfoBiz.class);

    @Autowired
	ProjectMarkInfoDAO projectMarkInfoDAO;

    @Autowired
	ProjectPatentInfoDAO projectPatentInfoDAO;

    @Autowired
	ProjectCopyrightInfoDAO projectCopyrightInfoDAO;

    @Autowired
	ProjectSoftwareCopyrightInfoDAO projectSoftwareCopyrightInfoDAO;

    @Autowired
	ProjectWebInfoDAO projectWebInfoDAO;

    @Autowired
	ProjectCertificateInfoDAO projectCertificateInfoDAO;

		
	public MessageInfo<Map> getListBySourceCode(String sourceCode){

		MessageInfo<Map> messageInfo = new MessageInfo<Map>();
		Map<String,Object> map = new HashMap<>();

		try {
			List<ProjectMarkInfo> projectMarkInfoList = projectMarkInfoDAO.selectBySourceCode(sourceCode);
			List<ProjectPatentInfo> projectPatentInfoList = projectPatentInfoDAO.selectBySourceCode(sourceCode);
			List<ProjectCopyrightInfo> projectCopyrightInfoList = projectCopyrightInfoDAO.selectBySourceCode(sourceCode);
			List<ProjectSoftwareCopyrightInfo> softwareCopyrightInfoList = projectSoftwareCopyrightInfoDAO.selectBySourceCode(sourceCode);
			List<ProjectWebInfo> projectWebInfoList = projectWebInfoDAO.selectBySourceCode(sourceCode);
			List<ProjectCertificateInfo> certificateInfoList = projectCertificateInfoDAO.selectBySourceCode(sourceCode);

			map.put("projectMarkInfoList",projectMarkInfoList);
			map.put("projectPatentInfoList",projectPatentInfoList);
			map.put("projectCopyrightInfoList",projectCopyrightInfoList);
			map.put("softwareCopyrightInfoList",softwareCopyrightInfoList);
			map.put("projectWebInfoList",projectWebInfoList);
			map.put("certificateInfoList",certificateInfoList);

			messageInfo.setData(map);

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