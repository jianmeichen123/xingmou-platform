package com.gi.ctdn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gi.ctdn.pojo.BusinessLineMappingIndustry;

public interface BusinessLineMappingIndustryDao {

	List<BusinessLineMappingIndustry> selectAll();

	int updateIsEmptyStatus(@Param("departmentId")Long departmentId, @Param("isEmpty")String isEmpty);

	String getByDepartmentId(@Param("departmentId")Long deparmentId);
	
}
