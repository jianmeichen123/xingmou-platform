package com.gi.xm.platform.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.platform.pojo.ProjectPersonJob;
import com.gi.xm.platform.query.ProjectPersonJobQuery;

public interface ProjectPersonJobDAO {
	
	int deleteByPrimaryKey(Long id);
	
	
    int insert(ProjectPersonJob projectPersonJob);

    ProjectPersonJob selectByPrimaryKey(Long id);

	ProjectPersonJob selectByPrimaryKeyForUpdate(Long id);
	
    List<ProjectPersonJob> selectAll();

	List<ProjectPersonJob> queryProjectPersonJob(ProjectPersonJobQuery projectPersonJobQuery);
			
    int updateByPrimaryKey(ProjectPersonJob projectPersonJob);
	
		

}