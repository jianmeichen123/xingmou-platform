

package com.gi.ctdn.biz;

import com.gi.ctdn.pojo.EventInfo;
import com.gi.ctdn.pojo.ProjectMediaInfo;
import com.gi.ctdn.view.common.MessageStatus;
import com.gi.ctdn.view.common.Pagination;
import com.gi.ctdn.view.common.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.regexp.internal.RE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.dao.ProjectMediaInfoDAO;

import java.util.List;

@Service("projectMediaInfoBiz")
public class ProjectMediaInfoBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectMediaInfoBiz.class);

    @Autowired
	ProjectMediaInfoDAO projectMediaInfoDAO;

	public Result queryMediaInfoList(ProjectMediaInfo projectMediaInfo){

		Result result;
		try {
			PageHelper.startPage(projectMediaInfo.getPageNo(), projectMediaInfo.getPageSize());
			List<ProjectMediaInfo> projectMediaInfoList = projectMediaInfoDAO.selectBySourceCodeAndType(projectMediaInfo.getProjectCode(),projectMediaInfo.getType());
			PageInfo<ProjectMediaInfo> pageInfo = new PageInfo<ProjectMediaInfo>(projectMediaInfoList);
			Pagination page = new Pagination();
			page.setTotal(pageInfo.getTotal());
			page.setRecords(projectMediaInfoList);
			result = new Result(MessageStatus.OK_MESSAGE, MessageStatus.OK_CODE, page);
		} catch (Exception e) {
			LOGGER.error("getListByProjectCode","查询ProjectMediaInfo失败", e);
			return Result.addError();
		}
		return result;
	}

}