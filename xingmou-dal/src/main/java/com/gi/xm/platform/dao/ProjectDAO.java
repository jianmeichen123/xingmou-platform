package com.gi.xm.platform.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.platform.pojo.Project;
import com.gi.xm.platform.query.ProjectQuery;

public interface ProjectDAO {
	
	int deleteByPrimaryKey(Long id);
	
	
    int insert(Project project);

    Project selectByPrimaryKey(Long id);

	Project selectByPrimaryKeyForUpdate(Long id);
	
    List<Project> selectAll();

	List<Project> queryProject(ProjectQuery projectQuery);
			
    int updateByPrimaryKey(Project project);
	
			
	int changeStatus(
			@Param("id") Long id,
			@Param("status") Integer status,
			@Param("updateUserid") String updateUserid);
				
	List<Project> selectBySourceId(@Param("sourceId") Long sourceId);

	List<Project> searchProject(ProjectQuery projectQuery);


	List<Project> queryCompetationlist(ProjectQuery projectQuery);
}