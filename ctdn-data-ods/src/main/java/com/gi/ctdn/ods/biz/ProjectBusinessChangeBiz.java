

package com.gi.ctdn.ods.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.ods.dao.ProjectBusinessChangeDAO;
import com.gi.xm.platform.view.common.MessageStatus;
import com.gi.xm.platform.view.common.MessageInfo;

import com.gi.ctdn.ods.pojo.ProjectBusinessChange;

@Service("projectBusinessChangeBiz")
public class ProjectBusinessChangeBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectBusinessChangeBiz.class);

    @Autowired
	ProjectBusinessChangeDAO projectBusinessChangeDAO;


		
	public MessageInfo<List<ProjectBusinessChange>> getListBySourceCode(String sourceCode){

		MessageInfo<List<ProjectBusinessChange>> messageInfo = new MessageInfo<List<ProjectBusinessChange>>();
		try {
			List<ProjectBusinessChange> projectBusinessChangeList = projectBusinessChangeDAO.selectBySourceCode(sourceCode);
			messageInfo.setData(projectBusinessChangeList);
		} catch (Exception e) {
			LOGGER.error("getListBySourceCode","查询ProjectBusinessChange失败", e);
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
		}
		return messageInfo;
	}
		


    public MessageInfo<List<ProjectBusinessChange>> getAllProjectBusinessChange(){

		MessageInfo<List<ProjectBusinessChange>> messageInfo = new MessageInfo<List<ProjectBusinessChange>>();
		try {
			List<ProjectBusinessChange> projectBusinessChangeList = projectBusinessChangeDAO.selectAll();
			messageInfo.setData( projectBusinessChangeList);
		} catch (Exception e) {
			LOGGER.error("getAllProjectBusinessChange","查询全部ProjectBusinessChange失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
}