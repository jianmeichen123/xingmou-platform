package com.gi.ctdn.dao;

import java.util.List;

import com.gi.ctdn.pojo.EventInfoList;
import org.apache.ibatis.annotations.Param;

import com.gi.ctdn.pojo.EventInfo;

public interface EventInfoDAO {
	
			
	List<EventInfo> selectBySourceCode(@Param("sourceCode") String sourceCode);
				
	EventInfoList selectByEventId(@Param("eventId") Integer eventId);

	List<EventInfo> selectBySourceId(@Param("sourceId") Integer sourceId);

	List<EventInfo> selectByName(@Param("company") String name);

	List<EventInfo> selectByInvestDate();

}