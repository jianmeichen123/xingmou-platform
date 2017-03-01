package com.gi.ctdn.dao;


import com.gi.ctdn.pojo.ProjectProductInfo;
import com.gi.ctdn.query.ProjectProductQueryInfo;

import java.util.List;

public interface ProjectProductDAO {

    Long insert(ProjectProductInfo projectProduct);
	
    List<ProjectProductInfo> queryListByProjectId(Long projectId);

    Integer deleteByProjectId(Long projectId);

}