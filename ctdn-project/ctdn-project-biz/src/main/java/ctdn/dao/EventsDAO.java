package ctdn.dao;

import ctdn.pojo.EventsInfo;
import ctdn.query.EventsQueryInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EventsDAO {
	
    int insert(EventsInfo events);


			
	List<EventsInfo> selectByProjectId(@Param("projectId") Long projectId);
		
    List<EventsInfo> queryEvents(EventsQueryInfo eventsQuery);
}