package com.gi.xm.platform.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.platform.pojo.InvestfirmsData;
import com.gi.xm.platform.query.InvestfirmsDataQuery;

public interface InvestfirmsDataDAO {
	
	int deleteByPrimaryKey(Integer id);
	
	
    int insert(InvestfirmsData investfirmsData);

    InvestfirmsData selectByPrimaryKey(Integer id);

	InvestfirmsData selectByPrimaryKeyForUpdate(Integer id);
	
    List<InvestfirmsData> selectAll();

	List<InvestfirmsData> queryInvestfirmsData(InvestfirmsDataQuery investfirmsDataQuery);
			
    int updateByPrimaryKey(InvestfirmsData investfirmsData);
	
				
	List<InvestfirmsData> selectByInvestfirmId(@Param("investfirmId") Long investfirmId);
		

}