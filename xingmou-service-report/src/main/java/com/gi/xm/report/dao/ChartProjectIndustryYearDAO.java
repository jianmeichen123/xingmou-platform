package com.gi.xm.report.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.report.pojo.ChartProjectIndustryYear;

public interface ChartProjectIndustryYearDAO {
	
    int insert(ChartProjectIndustryYear chartProjectIndustryYear);


			
	List<ChartProjectIndustryYear> selectByIndustryId(@Param("industryId") Integer industryId);
				
	List<ChartProjectIndustryYear> selectByYear(@Param("year") Integer year);
		
}