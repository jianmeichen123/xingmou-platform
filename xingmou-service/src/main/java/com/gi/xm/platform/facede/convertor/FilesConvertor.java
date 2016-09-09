package com.gi.xm.platform.facede.convertor;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import org.springframework.cglib.beans.BeanCopier;

import com.gi.xm.platform.view.FilesInfo;
import com.gi.xm.platform.view.FilesQueryInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.pojo.Files;
import com.gi.xm.platform.query.FilesQuery;
import com.gi.xm.platform.biz.common.QueryResult;

public abstract class FilesConvertor {

	private static final BeanCopier beanCopierForFilesInfo = BeanCopier.create(Files.class, FilesInfo.class, false);
	private static final BeanCopier beanCopierForFiles = BeanCopier.create(FilesInfo.class, Files.class, false);
	private static final BeanCopier beanCopierForFilesQuery = BeanCopier.create(FilesQueryInfo.class, FilesQuery.class, false);

	public static FilesInfo toFilesInfo(Files files)
	{
		if (files == null) {
			return null;
		}
		FilesInfo filesInfo = new FilesInfo();
		beanCopierForFilesInfo.copy(files, filesInfo, null);
		return filesInfo;
	}

	public static Files toFiles(FilesInfo filesInfo)
	{
		Files files = new Files();
		beanCopierForFiles.copy(filesInfo, files, null);
		return files;
	}

	public static List<FilesInfo> toFilesInfoList(List<Files> filesList)
	{
		if (filesList == null || filesList.isEmpty()) {
			return null;
		}
		List<FilesInfo> filesInfoList = new ArrayList<FilesInfo>(filesList.size());
		for (Files files : filesList) {
			filesInfoList.add(toFilesInfo(files));
		}
		return filesInfoList;
	}

	public static List<Files> toFilesList(List<FilesInfo> filesInfoList)
	{
		if (filesInfoList == null || filesInfoList.isEmpty()) {
			return null;
		}
		List<Files> filesList = new ArrayList<Files>(filesInfoList.size());
		for (FilesInfo filesInfo : filesInfoList) {
			filesList.add(toFiles(filesInfo));
		}
		return filesList;
	}
	
	public static FilesQuery toFilesQuery(FilesQueryInfo filesQueryInfo)
	{
		if (filesQueryInfo== null) {
			return null;
		}
		FilesQuery filesQuery = new FilesQuery();
		beanCopierForFilesQuery.copy(filesQueryInfo, filesQuery, null);
		return filesQuery;
	}

	public static QueryResultInfo<FilesInfo> toQueryResultInfo(QueryResult<Files> queryResult)
	{
		QueryResultInfo<FilesInfo> queryResultInfo = new QueryResultInfo<FilesInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toFilesInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}