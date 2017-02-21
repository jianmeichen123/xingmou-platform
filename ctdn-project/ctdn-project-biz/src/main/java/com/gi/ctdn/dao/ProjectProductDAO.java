package com.gi.ctdn.dao;


import com.gi.ctdn.pojo.ProjectProductInfo;
import com.gi.ctdn.query.ProjectProductQueryInfo;

import java.util.List;

public interface ProjectProductDAO {
	
    Long update(ProjectProductInfo projectProduct);

	
    List<ProjectProductInfo> queryProjectProduct(ProjectProductQueryInfo projectProductQuery);

    List<ProjectProductInfo> queryListByProjectId(Long projectId);
}