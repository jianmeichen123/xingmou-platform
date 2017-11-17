package com.gi.ctdn.dao;

import com.gi.ctdn.pojo.ProjectShareholderInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectShareholderInfoDAO {
	
			
	List<ProjectShareholderInfo> selectBySourceCode(@Param("sourceCode") String sourceCode);
		
	List<ProjectShareholderInfo> selectAll();
}