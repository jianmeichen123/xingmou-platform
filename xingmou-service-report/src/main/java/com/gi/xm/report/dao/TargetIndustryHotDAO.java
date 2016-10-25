package com.gi.xm.report.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gi.xm.report.pojo.TargetIndustryHot;
import com.gi.xm.report.query.TargetIndustryHotQueryInfo;

public interface TargetIndustryHotDAO {
	
    int insert(TargetIndustryHot targetIndustryHot);
			
	List<TargetIndustryHot> selectByIndustryLevel(@Param("industryLevel") Integer industryLevel);
		
    List<TargetIndustryHot> queryTargetIndustryHot(TargetIndustryHotQueryInfo targetIndustryHotQuery);
}