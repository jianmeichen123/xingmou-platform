package com.gi.ctdn.dao;


import com.gi.ctdn.pojo.ProjectContactInfo;
import com.gi.ctdn.query.ProjectContactQueryInfo;

import java.util.List;

public interface ProjectContactDAO {
	
    Long insert(ProjectContactInfo projectContact);

    Long update(ProjectContactInfo projectContact);

    ProjectContactInfo queryByProjectId(Long projectId);
}