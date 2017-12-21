package com.gi.ctdn.dao;

import com.gi.ctdn.pojo.Report;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportDAO
{
    List<Report> selectReports();
    Integer selectReportNum();
    void updateReportState(@Param("id") Integer id);
    List<Report> selectByIds(@Param("ids") List<String> ids);
    Report selectById(@Param("id") Integer id);
}
