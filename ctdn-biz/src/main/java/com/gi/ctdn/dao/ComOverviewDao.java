package com.gi.ctdn.dao;


import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ComOverviewDao {

    @Select("select districtSubName name,count(districtSubId) as value from app_project_list where districtSubName is not null and setupDT >= #{date} group by districtSubId order by value desc limit 20")
    List<Map<String, Object>> area(String date);

    @Select("select industryName name,count(districtSubId) value from app_project_list where setupDT >= #{date} group by industryName order by value desc")
    List<Map<String, Object>> industry(String date);

    @Select("select industryName ,setupDT from app_project_list where setupDT >= #{date} ")
    List<Map<String, Object>> quarterOfIndustry(String date);

    @Select("select  * from app_chart_project_invested_rate")
    List<Map<String, String>> investedRate();

}
