package com.gi.ctdn.dao;

import com.gi.ctdn.pojo.MergerEquity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MergerEquityDAO {
    List<MergerEquity> selectMergerEquityList(@Param("timeType") Integer timeType);
}
