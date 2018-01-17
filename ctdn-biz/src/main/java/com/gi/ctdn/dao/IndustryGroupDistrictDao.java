package com.gi.ctdn.dao;

import com.gi.ctdn.pojo.IndustryEcharsQuery;
import com.gi.ctdn.pojo.IndustryMonth;
import com.gi.ctdn.pojo.IndustryRoundMerger;

import java.util.List;

/**
 * Created by zcy on 18-1-15.
 */
public interface IndustryGroupDistrictDao {

    List<IndustryMonth> getIndustryByTimeRoundDistrict(IndustryEcharsQuery industryEcharsQuery);

    List<IndustryRoundMerger> getRoundByTimeDistrict(IndustryEcharsQuery industryEcharsQuery);
}
