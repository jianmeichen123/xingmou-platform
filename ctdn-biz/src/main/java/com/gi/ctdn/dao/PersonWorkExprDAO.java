package com.gi.ctdn.dao;

import com.gi.ctdn.pojo.PersonWorkExpr;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PersonWorkExprDAO {

	// 创业者，投资人 工作\教育
	List<PersonWorkExpr> selectWorkList(@Param("code") String code, @Param("type") String type);

		
}