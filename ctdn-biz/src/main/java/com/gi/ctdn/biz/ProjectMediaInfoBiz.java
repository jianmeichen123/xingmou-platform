

package com.gi.ctdn.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.dao.ProjectMediaInfoDAO;
import com.gi.xm.platform.view.common.MessageStatus;
import com.gi.xm.platform.view.common.MessageInfo;

import com.gi.ctdn.pojo.ProjectMediaInfo;

@Service("projectMediaInfoBiz")
public class ProjectMediaInfoBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectMediaInfoBiz.class);

    @Autowired
	ProjectMediaInfoDAO projectMediaInfoDAO;

	public MessageInfo<List<ProjectMediaInfo>> queryMediaInfoList(String sourceCode,String type){

		MessageInfo<List<ProjectMediaInfo>> messageInfo = new MessageInfo<List<ProjectMediaInfo>>();
		try {
			List<ProjectMediaInfo> projectMediaInfoList = projectMediaInfoDAO.selectBySourceCodeAndType(sourceCode,type);
			messageInfo.setData(projectMediaInfoList);
		} catch (Exception e) {
			LOGGER.error("getListBySourceCode","查询ProjectMediaInfo失败", e);
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
		}
		return messageInfo;
	}

}