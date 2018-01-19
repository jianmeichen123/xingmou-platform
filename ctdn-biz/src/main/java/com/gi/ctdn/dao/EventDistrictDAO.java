package com.gi.ctdn.dao;

import com.gi.ctdn.pojo.EventDistrict;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EventDistrictDAO {
    List<EventDistrict> selectByTimeType(@Param("timeType") Integer timeType);

    List<EventDistrict> selectByTimeAndDistrict(@Param("timeType") Integer timeType,@Param("districtSubName") String districtSubName);
}
