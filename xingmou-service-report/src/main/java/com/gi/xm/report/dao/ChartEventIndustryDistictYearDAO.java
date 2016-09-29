package com.gi.xm.report.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.report.pojo.ChartEventIndustryDistictYear;

public interface ChartEventIndustryDistictYearDAO {
	
    int insert(ChartEventIndustryDistictYear chartEventIndustryDistictYear);


			
	List<ChartEventIndustryDistictYear> selectByIndustryId(@Param("industryId") Integer industryId);
				
	List<ChartEventIndustryDistictYear> selectByDistrictId(@Param("districtId") Integer districtId);
				
	List<ChartEventIndustryDistictYear> selectByYear(@Param("years") Integer[] years);
		
}