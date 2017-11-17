package com.gi.ctdn.dao;

import com.gi.ctdn.pojo.ProjectBusinessInfo;
import com.gi.ctdn.pojo.ProjectBusinessListInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ProjectBusinessInfoDAO {
	
			
	ProjectBusinessListInfo selectProjectBusinessInfoBySourceCode(@Param("sourceCode") String sourceCode);

	List<ProjectBusinessInfo> selectBySourceCode(@Param("sourceCode") String sourceCode);

	List<ProjectBusinessInfo> selectAll();

	ProjectBusinessInfo selectByRegName(@Param("regName") String regName);
}