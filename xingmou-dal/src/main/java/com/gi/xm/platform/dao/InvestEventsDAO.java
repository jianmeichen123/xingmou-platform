package com.gi.xm.platform.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.platform.pojo.InvestEvents;
import com.gi.xm.platform.query.InvestEventsQuery;

public interface InvestEventsDAO {
	
	int deleteByPrimaryKey(Long id);
	
	
    int insert(InvestEvents investEvents);

    InvestEvents selectByPrimaryKey(Long id);

	InvestEvents selectByPrimaryKeyForUpdate(Long id);
	
    List<InvestEvents> selectAll();

	List<InvestEvents> queryInvestEvents(InvestEventsQuery investEventsQuery);
			
    int updateByPrimaryKey(InvestEvents investEvents);

    /**
     * 根据投资事件查询项目
     * @param investEventsQuery
     * @return
     */
    List<InvestEvents>queryProject(InvestEventsQuery investEventsQuery);
}