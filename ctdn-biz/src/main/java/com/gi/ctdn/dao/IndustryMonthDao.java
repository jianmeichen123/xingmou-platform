package com.gi.ctdn.dao;

import java.util.List;

import com.gi.ctdn.pojo.IndustryEcharsQuery;
import com.gi.ctdn.pojo.IndustryMonth;
import org.apache.ibatis.annotations.Param;

public interface IndustryMonthDao {

	List<IndustryMonth> getIndustryMonthForEcharts();

}
