package com.gi.xm.platform.facede;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.FilesInfo;
import com.gi.xm.platform.view.FilesQueryInfo;

public interface FilesFacede {
	MessageInfo<Integer> deleteFiles(Long id);
		
    MessageInfo<Long> createFiles(FilesInfo filesInfo);
		
	MessageInfo<Integer> updateFiles(FilesInfo filesInfo);
		
	MessageInfo<FilesInfo> getFiles(Long id);
		
    MessageInfo<List<FilesInfo>> getAllFiles();
			
    MessageInfo<QueryResultInfo<FilesInfo>> queryFiles(FilesQueryInfo filesQueryInfo);


	/**
	 * 查询项目或投资机构图片
	 * @param sourceIds　sourceId
	 * @param Type
	 * 		1. 项目图标  2.机构图标 3.创业者图标 4.投资人图标
	 * @return
     */
	MessageInfo<List<FilesInfo>> getListBySourceIdsType(List<Long> sourceIds,Integer Type);
		

}