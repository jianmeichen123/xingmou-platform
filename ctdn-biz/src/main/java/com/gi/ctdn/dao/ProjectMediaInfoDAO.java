package com.gi.ctdn.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.ctdn.pojo.ProjectMediaInfo;

public interface ProjectMediaInfoDAO {
	
			
	List<ProjectMediaInfo> selectBySourceCodeAndType(@Param("projectCode") String projectCode, @Param("type") String type);
				
}