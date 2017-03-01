package com.gi.ctdn.dao;


import com.gi.ctdn.pojo.FilesInfo;
import com.gi.ctdn.query.FilesQueryInfo;

import java.util.List;

public interface FilesDAO {

    Long insert(FilesInfo files);

    List<FilesInfo> queryListByProjectId(Long projectId);

    Integer deleteByProjectId(Long id);
}