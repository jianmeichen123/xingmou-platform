package com.gi.xm.platform.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.platform.pojo.InvestfirmsDataYear;
import com.gi.xm.platform.query.InvestfirmsDataYearQuery;

public interface InvestfirmsDataYearDAO {
	
	int deleteByPrimaryKey(Long id);
	
	
    int insert(InvestfirmsDataYear investfirmsDataYear);

    InvestfirmsDataYear selectByPrimaryKey(Long id);

	InvestfirmsDataYear selectByPrimaryKeyForUpdate(Long id);
	
    List<InvestfirmsDataYear> selectAll();

	List<InvestfirmsDataYear> queryInvestfirmsDataYear(InvestfirmsDataYearQuery investfirmsDataYearQuery);
			
    int updateByPrimaryKey(InvestfirmsDataYear investfirmsDataYear);
	
				
	List<InvestfirmsDataYear> selectByInvestfirmId(@Param("investfirmId") Long investfirmId);
				
	List<InvestfirmsDataYear> selectByYear(@Param("year") Integer year);
		

}