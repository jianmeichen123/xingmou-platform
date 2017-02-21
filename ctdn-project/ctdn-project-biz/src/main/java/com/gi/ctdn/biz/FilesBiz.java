

package com.gi.ctdn.biz;

import com.gi.ctdn.dao.FilesDAO;
import com.gi.ctdn.pojo.FilesInfo;
import com.gi.ctdn.query.FilesQueryInfo;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("filesBiz")
public class FilesBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(FilesBiz.class);

    @Autowired
	FilesDAO filesDAO;



    public MessageInfo<Long> updateFiles(FilesInfo files){
		MessageInfo<Long> messageInfo = new MessageInfo<Long>();
		try {
			filesDAO.update( files );
			messageInfo.setData(files.getId());

		} catch (Exception e) {
			LOGGER.error("createFiles","创建Files失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

	public MessageInfo<List<FilesInfo>> queryListByProjectId(Long projectId){
		MessageInfo<List<FilesInfo>> messageInfo = new MessageInfo<List<FilesInfo>>();
		try {
			List<FilesInfo> filesInfoList = filesDAO.queryListByProjectId(projectId);
			messageInfo.setData(filesInfoList);

		} catch (Exception e) {
			LOGGER.error("queryByProjectId","根据projectId 查询Files失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}


	public MessageInfo<QueryResultInfo<FilesInfo>> queryFiles(FilesQueryInfo filesQuery) {
		MessageInfo<QueryResultInfo<FilesInfo>> messageInfo = new MessageInfo<QueryResultInfo<FilesInfo>>();
		try {
			QueryResultInfo<FilesInfo> queryResult = new QueryResultInfo<FilesInfo>();
			PageHelper.startPage(filesQuery.getPageIndex(), filesQuery.getPageSize());
			List<FilesInfo> filesList = filesDAO.queryFiles(filesQuery);
			PageInfo<FilesInfo> pageInfo = new PageInfo<FilesInfo>(filesList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(filesList);
			messageInfo.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryFiles", "分页查询Files失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

}