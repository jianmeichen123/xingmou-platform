package com.gi.ctdn.ods.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.ctdn.ods.pojo.AlexaPvUv;

public interface AlexaPvUvDAO {
	
			
	List<AlexaPvUv> selectByCode(@Param("code") String code);
		
}