package com.gi.xm.platform.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.platform.pojo.Investfirms;
import com.gi.xm.platform.query.InvestfirmsQuery;

public interface InvestfirmsDAO {
	
	int deleteByPrimaryKey(Long id);
	
	
    int insert(Investfirms investfirms);

    Investfirms selectByPrimaryKey(Long id);

	Investfirms selectByPrimaryKeyForUpdate(Long id);
	
    List<Investfirms> selectAll();

	List<Investfirms> queryInvestfirms(InvestfirmsQuery investfirmsQuery);
			
    int updateByPrimaryKey(Investfirms investfirms);
	
				
	List<Investfirms> selectBySourceId(@Param("sourceId") Long sourceId);
		

}