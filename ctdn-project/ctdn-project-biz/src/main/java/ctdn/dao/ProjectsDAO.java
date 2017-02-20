package ctdn.dao;


import ctdn.pojo.ProjectsInfo;
import ctdn.query.ProjectsQueryInfo;

import java.util.List;

public interface ProjectsDAO {
	
    Long insert(ProjectsInfo projects);

    List<ProjectsInfo> queryProjects(ProjectsQueryInfo projectsQuery);

    ProjectsInfo getById(Long id);

    Long update(ProjectsInfo projects);
}