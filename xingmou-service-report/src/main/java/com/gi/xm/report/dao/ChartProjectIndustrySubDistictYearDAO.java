package com.gi.xm.report.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.report.pojo.ChartProjectIndustrySubDistictYear;

public interface ChartProjectIndustrySubDistictYearDAO {
	
    int insert(ChartProjectIndustrySubDistictYear chartProjectIndustrySubDistictYear);


			
	List<ChartProjectIndustrySubDistictYear> selectByIndustryId(@Param("industryId") Integer industryId);
				
	List<ChartProjectIndustrySubDistictYear> selectByDistrictId(@Param("districtId") Integer districtId);
				
	List<ChartProjectIndustrySubDistictYear> selectByYear(@Param("year") Integer year);
		
}