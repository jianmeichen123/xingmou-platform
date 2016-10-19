package com.gi.xm.report.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;

import com.gi.xm.report.query.ChartDataIndustryFirstYearQueryInfo;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.report.pojo.ChartDataIndustryFirstYear;

public interface ChartDataIndustryFirstYearDAO {
	
    int insert(ChartDataIndustryFirstYear chartDataIndustryFirstYear);


			
	List<ChartDataIndustryFirstYear> selectByIndustryIdYaar( @Param("years") Integer[] years,@Param("industryId") Integer industryId);
				
	/*List<ChartDataIndustryFirstYear> selectByYaar(@Param("years") Integer[] years);
				
	List<ChartDataIndustryFirstYear> selectByIndustryId(@Param("industryId") Integer industryId);*/

    List<ChartDataIndustryFirstYear> queryChartDataIndustryFirstYear(ChartDataIndustryFirstYearQueryInfo chartDataIndustryFirstYearQueryInfo);
}