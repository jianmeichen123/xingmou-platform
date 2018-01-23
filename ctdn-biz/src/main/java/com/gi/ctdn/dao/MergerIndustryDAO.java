package com.gi.ctdn.dao;

import com.gi.ctdn.pojo.MergerIndustry;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MergerIndustryDAO {
    List<MergerIndustry> selectMergerIndustryList(@Param("timeType") String timeType);
}
