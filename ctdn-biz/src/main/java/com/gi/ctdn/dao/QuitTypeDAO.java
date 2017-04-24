package com.gi.ctdn.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.ctdn.pojo.QuitType;

public interface QuitTypeDAO {
	
	
	List<QuitType> selectAll();
}