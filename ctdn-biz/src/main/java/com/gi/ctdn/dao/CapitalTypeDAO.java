package com.gi.ctdn.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.ctdn.pojo.CapitalType;

public interface CapitalTypeDAO {
	
	
	List<CapitalType> selectAll();
}