package com.gi.ctdn.dao;


import com.gi.ctdn.pojo.ProjectsInfo;
import com.gi.ctdn.query.ProjectsQueryInfo;

import java.util.List;

public interface ProjectsDAO {
	
    int insert(ProjectsInfo projects);

    int update(ProjectsInfo projects);

    List<ProjectsInfo> queryProjects(ProjectsQueryInfo projectsQuery);

    ProjectsInfo queryById(Long id);

    Integer deteleById(Long id);
}