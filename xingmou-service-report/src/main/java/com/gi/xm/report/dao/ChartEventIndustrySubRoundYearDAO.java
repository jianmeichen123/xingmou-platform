package com.gi.xm.report.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.report.pojo.ChartEventIndustrySubRoundYear;

public interface ChartEventIndustrySubRoundYearDAO {
	
    int insert(ChartEventIndustrySubRoundYear chartEventIndustrySubRoundYear);


			
	List<ChartEventIndustrySubRoundYear> selectByIndustryId(@Param("industryId") Integer industryId);
				
	List<ChartEventIndustrySubRoundYear> selectByRoundId(@Param("roundId") Integer roundId);
				
	List<ChartEventIndustrySubRoundYear> selectByYearIndustryId(@Param("years") Integer[] years,@Param("industryId")Integer industryId);
		
}