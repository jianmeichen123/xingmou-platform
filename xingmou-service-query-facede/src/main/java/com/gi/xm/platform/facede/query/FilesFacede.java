package com.gi.xm.platform.facede.query;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.FilesInfo;
import com.gi.xm.platform.view.FilesQueryInfo;

public interface FilesFacede {


	MessageInfo<FilesInfo> getFiles(Long id);
		
    MessageInfo<List<FilesInfo>> getAllFiles();
			
    MessageInfo<QueryResultInfo<FilesInfo>> queryFiles(FilesQueryInfo filesQueryInfo);
	
		
	MessageInfo<List<FilesInfo>> getListBySourceId(Long sourceId);
		

}