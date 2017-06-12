package com.gi.ctdn.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.ctdn.pojo.EventListedDetail;

public interface EventListedDetailDAO {
	
			
	List<EventListedDetail> selectByEventId(@Param("eventId") Integer eventId);

	List<EventListedDetail> selectByProjTitle(@Param("projTitle") String projTitle);
		
	List<EventListedDetail> selectAll();
}