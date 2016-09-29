package com.gi.xm.report.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.report.pojo.ChartProjectIndustrySubYear;

public interface ChartProjectIndustrySubYearDAO {
	
    int insert(ChartProjectIndustrySubYear chartProjectIndustrySubYear);


			
	List<ChartProjectIndustrySubYear> selectByIndustrySubId(@Param("industrySubId") Integer industrySubId);
				
	List<ChartProjectIndustrySubYear> selectByIndustryId(@Param("industryId") Integer industryId);
				
	List<ChartProjectIndustrySubYear> selectByYear(@Param("year") Integer year);
		
}