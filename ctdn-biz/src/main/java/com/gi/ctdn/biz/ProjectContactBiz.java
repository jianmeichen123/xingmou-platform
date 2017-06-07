

package com.gi.ctdn.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.dao.ProjectContactDAO;
import com.gi.xm.platform.view.common.MessageStatus;
import com.gi.xm.platform.view.common.MessageInfo;

import com.gi.ctdn.pojo.ProjectContact;

@Service("projectContactBiz")
public class ProjectContactBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectContactBiz.class);

    @Autowired
	ProjectContactDAO projectContactDAO;

//	public MessageInfo<List<ProjectContact>> getListBySourceCode(String sourceCode){
//
//		MessageInfo<List<ProjectContact>> messageInfo = new MessageInfo<List<ProjectContact>>();
//		try {
//			List<ProjectContact> projectContactList = projectContactDAO.selectBySourceCode(sourceCode);
//			messageInfo.setData(projectContactList);
//		} catch (Exception e) {
//			LOGGER.error("getListBySourceCode","查询ProjectContact失败", e);
//			messageInfo.setStatus(MessageStatus.ERROR_CODE);
//		}
//		return messageInfo;
//	}

}