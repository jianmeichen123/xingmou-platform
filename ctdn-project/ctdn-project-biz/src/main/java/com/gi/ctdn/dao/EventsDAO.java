package com.gi.ctdn.dao;

import com.gi.ctdn.pojo.EventsInfo;
import com.gi.ctdn.query.EventsQueryInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EventsDAO {
	
    Long insert(EventsInfo events);

    Long update(EventsInfo events);
			
	List<EventsInfo> queryByProjectId(@Param("projectId") Long projectId);
		
    EventsInfo queryById(Long id);

    List<EventsInfo> queryListByProjects(EventsQueryInfo eventQuery);

    int deleteById(Long id);
}