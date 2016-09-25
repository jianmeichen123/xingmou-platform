package com.gi.xm.platform.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.platform.pojo.DataEventYear;
import com.gi.xm.platform.query.DataEventYearQuery;

public interface DataEventYearDAO {
	
	int deleteByPrimaryKey(Long id);
	
	
    int insert(DataEventYear dataEventYear);

    DataEventYear selectByPrimaryKey(Long id);

	DataEventYear selectByPrimaryKeyForUpdate(Long id);
	
    List<DataEventYear> selectAll();

	List<DataEventYear> queryDataEventYear(DataEventYearQuery dataEventYearQuery);
			
    int updateByPrimaryKey(DataEventYear dataEventYear);
	
				
	List<DataEventYear> selectByYearIndustryId(@Param("years") Integer years[], @Param("industryId") Integer industryId);
				
	List<DataEventYear> selectByYearIndustrySubId(@Param("years") Integer years[], @Param("industrySubId") Integer industrySubId);
				
	List<DataEventYear> selectByDistrictId(@Param("districtId") Integer districtId);
				
	List<DataEventYear> selectByIndustryId(@Param("industryId") Integer industryId);
				
	List<DataEventYear> selectByMoneyLevelId(@Param("moneyLevelId") Integer moneyLevelId);
				
	List<DataEventYear> selectByRoundId(@Param("roundId") Integer roundId);
				
	List<DataEventYear> selectByYear(@Param("years") Integer years[]);
		

}