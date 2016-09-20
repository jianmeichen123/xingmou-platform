package com.gi.xm.platform.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gi.xm.platform.pojo.Label;

public interface LabelDAO {
	
	List<Label> selectByTypeRelationId(@Param("type") Integer type, @Param("relationId") Long relationId);

	List<Label> selectByIdList(@Param("type") Integer type, @Param("idList") List<Integer> idList);

}