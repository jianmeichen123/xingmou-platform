package com.gi.ctdn.dao;

import com.gi.ctdn.pojo.PersonComExpr;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PersonComExprDAO {

	List<PersonComExpr> selectPersonComList(@Param("code") String code, @Param("type") String type);
		
}