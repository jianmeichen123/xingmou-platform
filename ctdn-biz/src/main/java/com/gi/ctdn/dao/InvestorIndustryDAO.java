package com.gi.ctdn.dao;

import com.gi.ctdn.pojo.Industry;
import com.gi.ctdn.pojo.InvestorIndustry;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InvestorIndustryDAO {

	List<InvestorIndustry> selectAll();

}