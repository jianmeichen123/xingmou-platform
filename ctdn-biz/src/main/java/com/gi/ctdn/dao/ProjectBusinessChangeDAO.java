package com.gi.ctdn.dao;

import com.gi.ctdn.pojo.ProjectBusinessChange;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectBusinessChangeDAO {
	
			
	List<ProjectBusinessChange> selectBySourceCode(@Param("sourceCode") String sourceCode);
		
	List<ProjectBusinessChange> selectAll();
}