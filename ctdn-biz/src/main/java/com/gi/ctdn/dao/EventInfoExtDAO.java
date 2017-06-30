package com.gi.ctdn.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.ctdn.pojo.EventInfoExt;

public interface EventInfoExtDAO {
	
			
	List<EventInfoExt> selectByInvstoridType(@Param("invstorid") Integer invstorid);
		
	List<EventInfoExt> selectAll();
}