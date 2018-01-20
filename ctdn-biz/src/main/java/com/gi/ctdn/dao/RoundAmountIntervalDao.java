package com.gi.ctdn.dao;

import com.gi.ctdn.pojo.IndustryEcharsQuery;
import com.gi.ctdn.pojo.echars.RoundAmountInterval;

import java.util.List;

/**
 * Created by zcy on 18-1-19.
 */
public interface RoundAmountIntervalDao {
    List<RoundAmountInterval> getRXGMFB(IndustryEcharsQuery industryEcharsQuery);
}
