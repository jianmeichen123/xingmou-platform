package com.gi.xm.platform.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.platform.pojo.IndustryDataHalfYear;
import com.gi.xm.platform.query.IndustryDataHalfYearQuery;

public interface IndustryDataHalfYearDAO {
	
	int deleteByPrimaryKey(Long id);
	
	
    int insert(IndustryDataHalfYear industryDataHalfYear);

    IndustryDataHalfYear selectByPrimaryKey(Long id);

	IndustryDataHalfYear selectByPrimaryKeyForUpdate(Long id);
	
    List<IndustryDataHalfYear> selectAll();

	List<IndustryDataHalfYear> queryIndustryDataHalfYear(IndustryDataHalfYearQuery industryDataHalfYearQuery);
			
    int updateByPrimaryKey(IndustryDataHalfYear industryDataHalfYear);
	
				
	List<IndustryDataHalfYear> selectByIndustryIdYaar(@Param("industryId") Integer industryId, @Param("yaar") Integer yaar);
				
	List<IndustryDataHalfYear> selectByYaarIndustrySubId(@Param("yaar") Integer yaar, @Param("industrySubId") Integer industrySubId);
				
	List<IndustryDataHalfYear> selectByIndustryId(@Param("industryId") Integer industryId);
				
	List<IndustryDataHalfYear> selectByYaar(@Param("yaar") Integer yaar);
		

}