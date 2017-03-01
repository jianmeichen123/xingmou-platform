

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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("filesBiz")
public class FilesBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(FilesBiz.class);

    @Autowired
	FilesDAO filesDAO;


	public MessageInfo<Long> createFiles(FilesInfo files){
		MessageInfo<Long> messageInfo = new MessageInfo<Long>();
		try {
			filesDAO.insert( files );
			messageInfo.setData(files.getId());
		} catch (Exception e) {
			LOGGER.error("createFiles","创建Files失败", e);
			messageInfo.setStatus(10001);
			throw e;
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

	public  MessageInfo<Integer>  deleteByProjectId(Long projectId) {
		MessageInfo<Integer> messageInfo = new MessageInfo<Integer>();
		try {
			Integer ret= filesDAO.deleteByProjectId(projectId);
			messageInfo.setData(ret);
		} catch (Exception e) {
			LOGGER.error("deleteByProjectId","根据projectId 删除Files失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
}