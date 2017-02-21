package com.gi.ctdn.dao;


import com.gi.ctdn.pojo.FilesInfo;
import com.gi.ctdn.query.FilesQueryInfo;

import java.util.List;

public interface FilesDAO {
	
    Long update(FilesInfo files);


    List<FilesInfo> queryFiles(FilesQueryInfo filesQuery);

    List<FilesInfo> queryListByProjectId(Long projectId);
}