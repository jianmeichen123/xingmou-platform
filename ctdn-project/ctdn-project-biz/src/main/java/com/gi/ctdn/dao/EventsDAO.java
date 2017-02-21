package com.gi.ctdn.dao;

import com.gi.ctdn.pojo.EventsInfo;
import com.gi.ctdn.query.EventsQueryInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EventsDAO {
	
    Long insert(EventsInfo events);

    Long update(EventsInfo events);
			
	List<EventsInfo> selectByProjectId(@Param("projectId") Long projectId);
		
    List<EventsInfo> queryEvents(EventsQueryInfo eventsQuery);

    EventsInfo queryById(Long id);
}