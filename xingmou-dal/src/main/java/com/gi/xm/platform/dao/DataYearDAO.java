package com.gi.xm.platform.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.platform.pojo.DataYear;
import com.gi.xm.platform.query.DataYearQuery;

public interface DataYearDAO {
	
	int deleteByPrimaryKey(Long id);
	
	
    int insert(DataYear dataYear);

    DataYear selectByPrimaryKey(Long id);

	DataYear selectByPrimaryKeyForUpdate(Long id);
	
    List<DataYear> selectAll();

	List<DataYear> queryDataYear(DataYearQuery dataYearQuery);
			
    int updateByPrimaryKey(DataYear dataYear);
	
				
	List<DataYear> selectByDistrictId(@Param("districtId") Integer districtId);
				
	List<DataYear> selectByIndustryId(@Param("industryId") Integer industryId);
				
	List<DataYear> selectByMoneyLevelId(@Param("moneyLevelId") Integer moneyLevelId);
				
	List<DataYear> selectByRoundId(@Param("roundId") Integer roundId);
				
	List<DataYear> selectByYear(@Param("year") Integer year);
		

}