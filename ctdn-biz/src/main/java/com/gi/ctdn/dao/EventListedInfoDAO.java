package com.gi.ctdn.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.ctdn.pojo.EventListedInfo;

public interface EventListedInfoDAO {
	
			
	EventListedInfo selectByEventId(@Param("eventId") Integer eventId);
				
	List<EventListedInfo> selectBySourceCode(@Param("sourceCode") String sourceCode);
		
	List<EventListedInfo> selectAll();
}