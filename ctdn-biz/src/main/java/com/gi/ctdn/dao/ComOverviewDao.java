package com.gi.ctdn.dao;


import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ComOverviewDao {

    @Select("select districtSubName name,count(districtSubId) as value from app_project_list where districtSubName is not null and setupDT >= 2017 group by districtSubId order by value desc limit 20")
    List<Map<String, Object>> area(Integer year);

    @Select("select industryName n,count(districtSubId) as c from app_project_list where setupDT >= 2017 group by industryName order by c desc")
    List<Map<String, Object>> industry(Integer year);

    @Select("select industryName ,setupDT from app_project_list where setupDT >= 2017")
    List<Map<String, Object>> quarterOfIndustry(String date);
}
