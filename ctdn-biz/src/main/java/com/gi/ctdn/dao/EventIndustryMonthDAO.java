package com.gi.ctdn.dao;

import com.gi.ctdn.pojo.EventIndustryMonth;
import com.gi.ctdn.pojo.EventIndustryMonthChart;

import java.util.List;

public interface EventIndustryMonthDAO {
	
			
	List<EventIndustryMonthChart> select(EventIndustryMonth  eventIndustryMonth);
				
}