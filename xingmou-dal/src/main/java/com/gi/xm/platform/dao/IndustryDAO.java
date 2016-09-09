package com.gi.xm.platform.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.platform.pojo.Industry;
import com.gi.xm.platform.query.IndustryQuery;

public interface IndustryDAO {
	
	int deleteByPrimaryKey(Integer id);
	
	
    int insert(Industry industry);

    Industry selectByPrimaryKey(Integer id);

	Industry selectByPrimaryKeyForUpdate(Integer id);
	
    List<Industry> selectAll();

	List<Industry> queryIndustry(IndustryQuery industryQuery);
			
    int updateByPrimaryKey(Industry industry);
	
		

}