package com.gi.ctdn.dao;


import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ComOverviewDao {

    @Select("select districtSubName name,count(districtSubId) as value from app_project_list where districtId = 45057 and districtSubName is not null and setupDT >= #{date} group by districtSubId order by value desc limit 20")
    List<Map<String, Object>> area(String date);

    @Select("select industryName name,count(districtSubId) value from app_project_list where setupDT >= #{date} group by industryName order by value desc")
    List<Map<String, Object>> industry(String date);

    @Select("select industryName ,setupDT from app_project_list where setupDT >= #{date} ")
    List<Map<String, Object>> quarterOfIndustry(String date);
    @Select("select  * from app_chart_project_invested_rate")
    List<Map<String, String>> investedRate();


    @Select("<script>"
            + "SELECT industryName , projNum ,investQuarter from app_chart_project_setup where investQuarter IN"
            + "<foreach item='item' index='index' collection='quarters' open='(' separator=',' close=')'>"
            + "#{item}"
            + "</foreach>"
            + "</script>")
    List<Map<String, Object>> projectSetup(@Param("quarters") String[] quarters);


}
