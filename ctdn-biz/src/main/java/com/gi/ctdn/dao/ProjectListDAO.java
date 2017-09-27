package com.gi.ctdn.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;

import com.gi.ctdn.pojo.ProjectListInfo;
import org.apache.ibatis.annotations.Param;

import com.gi.ctdn.pojo.ProjectList;

public interface ProjectListDAO {

	ProjectListInfo selectByCode(@Param("code") String code);

	List<ProjectList> queryCompetationlist(@Param("sourceCode") String sourceCode ,@Param("isSame") Integer isSame);

	List<ProjectList> queryCompetitiveSimilar(@Param("sourceCode") String sourceCode ,@Param("isSame") Integer isSame);

	List<ProjectList> selectByFinanceDate();
		
}