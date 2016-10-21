package com.gi.xm.report.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.report.pojo.ChartEventRoundYear;

public interface ChartEventRoundYearDAO {
	
    int insert(ChartEventRoundYear chartEventRoundYear);

	List<ChartEventRoundYear> select();

	List<Integer> selectYears();

	List<ChartEventRoundYear> selectByRoundYear();

	List<String> selectRoundNames();
		
}