package com.gi.ctdn.dao;

import com.gi.ctdn.pojo.EventStages;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EventStagesDAO {

    List<EventStages> selectByDistrictAndTimeType(@Param("districtSubId") Integer districtSubId,@Param("timeType") Integer timeType);
}
