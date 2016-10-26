package com.gi.xm.report.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;

import com.gi.xm.report.query.ChartDataIndustryYearQueryInfo;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.report.pojo.ChartDataIndustryYear;

public interface ChartDataIndustryYearDAO {
	
   /* int insert(ChartDataIndustryYear chartDataIndustryYear);

*/
			
	/*List<ChartDataIndustryYear> selectByIndustryIdYaar(@Param("industryId") Integer industryId, @Param("yaar") Integer yaar);*/
				
	List<ChartDataIndustryYear> selectByYaarIndustrySubId(@Param("years") Integer[] years, @Param("industrySubId") Integer industrySubId);
				
/*	List<ChartDataIndustryYear> selectByIndustryId(@Param("industryId") Integer industryId);
				
	List<ChartDataIndustryYear> selectByYaar(@Param("yaar") Integer yaar);*/
    List<ChartDataIndustryYear> selectAll(@Param("years") Integer[] years);
	List<ChartDataIndustryYear> selectByYaarIndustryId(@Param("years") Integer[] years, @Param("industryId") Integer industryId);


	List<ChartDataIndustryYear> queryChartDataIndustryYear(ChartDataIndustryYearQueryInfo chartDataIndustryYearQueryInfo);
}