package com.gi.ctdn.dao;

import com.gi.ctdn.pojo.PersonEduExpr;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PersonEduExprDAO {

	// 创业者 投资人 教育经历
	List<PersonEduExpr> selectEduList(@Param("code") String code, @Param("type") String type);
		
}