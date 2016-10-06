package com.gi.xm.report.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.report.pojo.ChartEventIndustrySubMoneylevelYear;

public interface ChartEventIndustrySubMoneylevelYearDAO {
	
    int insert(ChartEventIndustrySubMoneylevelYear chartEventIndustrySubMoneylevelYear);


/*

	List<ChartEventIndustrySubMoneylevelYear> selectByIndustryId(@Param("industryId") Integer industryId);

	List<ChartEventIndustrySubMoneylevelYear> selectByMoneyLevelId(@Param("moneyLevelId") Integer moneyLevelId);
*/

	List<ChartEventIndustrySubMoneylevelYear> selectByYearIndustrySubId(@Param("years") Integer[] years,@Param("industrySubId") Integer industrySubId);
		
}