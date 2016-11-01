package com.gi.xm.report.dao;

import com.gi.xm.report.pojo.ChartEventIndustryRoundMerge;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChartEventIndustryRoundMergeDAO {
	

	
    List<ChartEventIndustryRoundMerge> chartAnalysis(ChartEventIndustryRoundMerge chartEventIndustryRoundMergeQuery);

	List<ChartEventIndustryRoundMerge> queryChartEventIndustryRoundMerge(ChartEventIndustryRoundMerge chartEventIndustryRoundMergeQuery);

    List<ChartEventIndustryRoundMerge> selectByYearsParentId(@Param("years") Integer[] years, @Param("parentId") Integer parentId, @Param("type") Integer type);
		

}