

package com.gi.ctdn.ods.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.ods.dao.ProjectRiskDAO;
import com.gi.xm.platform.view.common.MessageStatus;
import com.gi.xm.platform.view.common.MessageInfo;

import com.gi.ctdn.ods.pojo.ProjectRisk;

@Service("projectRiskBiz")
public class ProjectRiskBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectRiskBiz.class);

    @Autowired
	ProjectRiskDAO projectRiskDAO;


	


    public MessageInfo<List<ProjectRisk>> getAllProjectRisk(){

		MessageInfo<List<ProjectRisk>> messageInfo = new MessageInfo<List<ProjectRisk>>();
		try {
			List<ProjectRisk> projectRiskList = projectRiskDAO.selectAll();
			messageInfo.setData( projectRiskList);
		} catch (Exception e) {
			LOGGER.error("getAllProjectRisk","查询全部ProjectRisk失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
}