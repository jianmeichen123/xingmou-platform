package com.gi.xm.report.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.report.pojo.ChartEventIndustryRoundYear;

public interface ChartEventIndustryRoundYearDAO {
	
    int insert(ChartEventIndustryRoundYear chartEventIndustryRoundYear);


			
	List<ChartEventIndustryRoundYear> selectByIndustryId(@Param("industryId") Integer industryId);
				
	List<ChartEventIndustryRoundYear> selectByRoundId(@Param("roundId") Integer roundId);
				
	List<ChartEventIndustryRoundYear> selectByYear(@Param("year") Integer year);
		
}