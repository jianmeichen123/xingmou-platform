package com.gi.xm.platform.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.platform.pojo.ProjectPersonStudy;
import com.gi.xm.platform.query.ProjectPersonStudyQuery;

public interface ProjectPersonStudyDAO {
	
	int deleteByPrimaryKey(Long id);
	
	
    int insert(ProjectPersonStudy projectPersonStudy);

    ProjectPersonStudy selectByPrimaryKey(Long id);

	ProjectPersonStudy selectByPrimaryKeyForUpdate(Long id);
	
    List<ProjectPersonStudy> selectAll();

	List<ProjectPersonStudy> queryProjectPersonStudy(ProjectPersonStudyQuery projectPersonStudyQuery);
			
    int updateByPrimaryKey(ProjectPersonStudy projectPersonStudy);
	
		

}