

package com.gi.ctdn.biz;

import com.gi.ctdn.dao.ProjectProductDAO;
import com.gi.ctdn.pojo.ProjectProductInfo;
import com.gi.ctdn.query.ProjectProductQueryInfo;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("projectProductBiz")
public class ProjectProductBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectProductBiz.class);

    @Autowired
	ProjectProductDAO projectProductDAO;

	public MessageInfo<Long> createProjectProduct(ProjectProductInfo projectProduct){
		MessageInfo<Long> messageInfo = new MessageInfo<Long>();
		try {
			projectProductDAO.insert( projectProduct );
			messageInfo.setData(projectProduct.getId());
		} catch (Exception e) {
			LOGGER.error("createProjectProduct","修改ProjectProduct失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

	public MessageInfo<Integer> deleteByProjectId(Long projectId){
		MessageInfo<Integer> messageInfo = new MessageInfo<Integer>();
		try {
			Integer ret = projectProductDAO.deleteByProjectId( projectId );
			messageInfo.setData(ret);
		} catch (Exception e) {
			LOGGER.error("deleteByProjectId","删除ProjectProduct失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

	public MessageInfo<List<ProjectProductInfo>> queryListByProjectId(Long projectId){
		MessageInfo<List<ProjectProductInfo>> messageInfo = new MessageInfo<List<ProjectProductInfo>>();
		try {
			List<ProjectProductInfo> projectProductInfoList = projectProductDAO.queryListByProjectId(projectId);
			messageInfo.setData(projectProductInfoList);
		} catch (Exception e) {
			LOGGER.error("queryListByProjectId","根据 projectId查询列表失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

}