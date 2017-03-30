package com.gi.ctdn.ods.dao;

import java.util.List;

import com.gi.ctdn.ods.pojo.OpIndiceSummary;
import org.apache.ibatis.annotations.Param;

import com.gi.ctdn.ods.pojo.AlexaPvUv;

public interface AlexaPvUvDAO {
	
			
	List<AlexaPvUv> selectByCode(@Param("code") String code);

	List<AlexaPvUv> selectByDomain(@Param("domain") String domain);
}