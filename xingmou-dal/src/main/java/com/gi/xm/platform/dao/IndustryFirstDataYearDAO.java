package com.gi.xm.platform.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.platform.pojo.IndustryFirstDataYear;
import com.gi.xm.platform.query.IndustryFirstDataYearQuery;

public interface IndustryFirstDataYearDAO {
	
	int deleteByPrimaryKey(Long id);
	
	
    int insert(IndustryFirstDataYear industryFirstDataYear);

    IndustryFirstDataYear selectByPrimaryKey(Long id);

	IndustryFirstDataYear selectByPrimaryKeyForUpdate(Long id);
	
    List<IndustryFirstDataYear> selectAll();

	List<IndustryFirstDataYear> queryIndustryFirstDataYear(IndustryFirstDataYearQuery industryFirstDataYearQuery);
			
    int updateByPrimaryKey(IndustryFirstDataYear industryFirstDataYear);
	
				
	List<IndustryFirstDataYear> selectByIndustryIdYaar(@Param("industryId") Integer industryId, @Param("yaar") Integer yaar);
				

	List<IndustryFirstDataYear> selectByIndustryId(@Param("industryId") Integer industryId);
				
	List<IndustryFirstDataYear> selectByYaar(@Param("yaars") Integer[] yaars);
		

}