package com.gi.ctdn.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.ctdn.pojo.ProjectList;

public interface ProjectListDAO {

	List<ProjectList> selectByCode(@Param("code") String code);

	List<ProjectList> queryCompetationlist(ProjectList projectQuery);

	List<ProjectList> queryCompetitiveSimilar(ProjectList projectQuery);
		
}