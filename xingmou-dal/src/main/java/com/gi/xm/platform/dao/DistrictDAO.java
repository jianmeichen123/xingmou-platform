package com.gi.xm.platform.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.platform.pojo.District;
import com.gi.xm.platform.query.DistrictQuery;

public interface DistrictDAO {
	
	int deleteByPrimaryKey(Integer id);
	
	
    int insert(District district);

    District selectByPrimaryKey(Integer id);

	District selectByPrimaryKeyForUpdate(Integer id);
	
    List<District> selectAll();

	List<District> queryDistrict(DistrictQuery districtQuery);
			
    int updateByPrimaryKey(District district);
	
				
	List<District> selectByUpidDisplayorder(@Param("upid") Integer upid, @Param("displayorder") Integer displayorder);
		

}