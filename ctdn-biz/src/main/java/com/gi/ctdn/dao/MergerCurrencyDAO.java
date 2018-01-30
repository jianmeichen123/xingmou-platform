package com.gi.ctdn.dao;

import com.gi.ctdn.pojo.MergerCurrency;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MergerCurrencyDAO {
    List<MergerCurrency> selectMergerCurrencyList(@Param("timeType") Integer timeType);
}
