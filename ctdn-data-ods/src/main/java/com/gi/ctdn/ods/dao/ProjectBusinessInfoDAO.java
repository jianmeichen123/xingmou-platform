package com.gi.ctdn.ods.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;

import com.gi.ctdn.ods.pojo.ProjectBusinessInfo;
import com.gi.ctdn.ods.pojo.ProjectBusinessListInfo;
import org.apache.ibatis.annotations.Param;


public interface ProjectBusinessInfoDAO {
	
			
	ProjectBusinessListInfo selectProjectBusinessInfoBySourceCode(@Param("sourceCode") String sourceCode);

	List<ProjectBusinessInfo> selectBySourceCode(@Param("sourceCode") String sourceCode);

	List<ProjectBusinessInfo> selectAll();
}