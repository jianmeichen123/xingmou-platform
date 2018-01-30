package com.gi.ctdn.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;

import com.gi.ctdn.pojo.EventMergerInfoSon;
import org.apache.ibatis.annotations.Param;

import com.gi.ctdn.pojo.EventMergerInfo;

public interface EventMergerInfoDAO {
	
	List<EventMergerInfo> selectBySourceCode(@Param("sourceCode") String sourceCode);

	EventMergerInfoSon selectByEventId(@Param("eventId") Integer eventId);

	Integer selectMergerCount();
}