package com.gi.xm.report.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.report.pojo.ChartProjectIndustryDistictYear;

public interface ChartProjectIndustryDistictYearDAO {
	
    int insert(ChartProjectIndustryDistictYear chartProjectIndustryDistictYear);


			
	List<ChartProjectIndustryDistictYear> selectByIndustryId(@Param("industryId") Integer industryId);
				
	List<ChartProjectIndustryDistictYear> selectByDistrictId(@Param("districtId") Integer districtId);
				
	List<ChartProjectIndustryDistictYear> selectByYear(@Param("year") Integer year);
		
}