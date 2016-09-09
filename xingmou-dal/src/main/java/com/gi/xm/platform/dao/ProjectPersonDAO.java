package com.gi.xm.platform.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.platform.pojo.ProjectPerson;
import com.gi.xm.platform.query.ProjectPersonQuery;

public interface ProjectPersonDAO {
	
	int deleteByPrimaryKey(Integer id);
	
	
    int insert(ProjectPerson projectPerson);

    ProjectPerson selectByPrimaryKey(Integer id);

	ProjectPerson selectByPrimaryKeyForUpdate(Integer id);
	
    List<ProjectPerson> selectAll();

	List<ProjectPerson> queryProjectPerson(ProjectPersonQuery projectPersonQuery);
			
    int updateByPrimaryKey(ProjectPerson projectPerson);
	
		

}