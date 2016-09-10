package com.gi.xm.platform.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.platform.pojo.IndustryDataYear;
import com.gi.xm.platform.query.IndustryDataYearQuery;

public interface IndustryDataYearDAO {
	
	int deleteByPrimaryKey(Long id);
	
	
    int insert(IndustryDataYear industryDataYear);

    IndustryDataYear selectByPrimaryKey(Long id);

	IndustryDataYear selectByPrimaryKeyForUpdate(Long id);
	
    List<IndustryDataYear> selectAll();

	List<IndustryDataYear> queryIndustryDataYear(IndustryDataYearQuery industryDataYearQuery);

    int updateByPrimaryKey(IndustryDataYear industryDataYear);


	List<IndustryDataYear> selectByIndustryId(@Param("industryId") Integer industryId);


	List<IndustryDataYear> selectByIndustryIdYaar(@Param("industryId") Integer industryId, @Param("yaars") Integer[] yaars);

	List<IndustryDataYear> selectByYaarIndustrySubId(@Param("yaars") Integer yaars[], @Param("industrySubId") Integer industrySubId);

	List<IndustryDataYear> selectByYaar(@Param("yaars") Integer[] yaars);


}