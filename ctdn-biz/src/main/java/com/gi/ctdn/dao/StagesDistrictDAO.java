package com.gi.ctdn.dao;

import com.gi.ctdn.pojo.StagesDistrict;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StagesDistrictDAO {
    List<StagesDistrict> selectStagesDistricts(@Param("timeType") String timeType,@Param("districtSubName") String districtSubName);

    List<StagesDistrict> selectStages(@Param("timeType") String timeType,@Param("districtSubName") String districtSubName,@Param("stagesName") String stagesName);
}
