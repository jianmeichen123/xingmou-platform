package com.gi.ctdn.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.ctdn.pojo.EventMergerDetail;

public interface EventMergerDetailDAO {
	
	
	List<EventMergerDetail> selectAll();

	List<EventMergerDetail> getEventMergerDetailByEventId(@Param("eventId") Integer eventId);

	List<EventMergerDetail> getEventMergerDetailByProjTitle(@Param("projTitle") String projTitle);
}