package com.gi.xm.report.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.report.pojo.ChartEventIndustrySubDistictYear;

public interface ChartEventIndustrySubDistictYearDAO {
	
    int insert(ChartEventIndustrySubDistictYear chartEventIndustrySubDistictYear);


/*

	List<ChartEventIndustrySubDistictYear> selectByIndustryId(@Param("industryId") Integer industryId);
				
	List<ChartEventIndustrySubDistictYear> selectByDistrictId(@Param("districtId") Integer districtId);
*/

	List<ChartEventIndustrySubDistictYear> selectByYearIndustrySubId(@Param("years") Integer[] years,@Param("industrySubId") Integer industrySubId);

    List<ChartEventIndustrySubDistictYear> selectByYearIndustryId(@Param("years") Integer[] years,@Param("industryId")  Integer industryId);
}