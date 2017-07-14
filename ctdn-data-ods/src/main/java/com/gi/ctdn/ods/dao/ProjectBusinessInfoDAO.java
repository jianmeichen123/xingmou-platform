package com.gi.ctdn.ods.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;

import com.gi.ctdn.ods.pojo.ProjectBusinessInfo;
import org.apache.ibatis.annotations.Param;


public interface ProjectBusinessInfoDAO {
	
			
	List<ProjectBusinessInfo> selectBySourceCode(@Param("sourceCode") String sourceCode);
		
	List<ProjectBusinessInfo> selectAll();
}