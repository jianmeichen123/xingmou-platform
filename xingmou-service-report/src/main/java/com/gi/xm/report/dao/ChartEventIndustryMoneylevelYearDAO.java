package com.gi.xm.report.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.report.pojo.ChartEventIndustryMoneylevelYear;

public interface ChartEventIndustryMoneylevelYearDAO {
	
    int insert(ChartEventIndustryMoneylevelYear chartEventIndustryMoneylevelYear);


			
	List<ChartEventIndustryMoneylevelYear> selectByIndustryId(@Param("industryId") Integer industryId);
				
	List<ChartEventIndustryMoneylevelYear> selectByMoneyLevelId(@Param("moneyLevelId") Integer moneyLevelId);
				
	List<ChartEventIndustryMoneylevelYear> selectByYear(@Param("year") Integer year);
		
}