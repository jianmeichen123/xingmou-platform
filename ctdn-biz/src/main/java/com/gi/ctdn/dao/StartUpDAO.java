package com.gi.ctdn.dao;

import com.gi.ctdn.pojo.StartUp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StartUpDAO {
	//创业者
	StartUp selectEntityByCode(@Param("code") String code);

	List<StartUp> selectByCodeList (@Param("codes") List<String> cods);
}