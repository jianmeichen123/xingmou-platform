package com.gi.ctdn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gi.ctdn.pojo.EventInfo;

public interface EventInfoDAO {
	
			
	List<EventInfo> selectBySourceCode(@Param("sourceCode") String sourceCode);
				
	EventInfo selectByEventId(@Param("eventId") Integer eventId);

}