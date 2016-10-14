package com.gi.xm.report.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.report.pojo.ChartDataYear;

public interface ChartDataYearDAO {

	List<ChartDataYear> selectByYaar(@Param("years") Integer[] years);
				

		
}