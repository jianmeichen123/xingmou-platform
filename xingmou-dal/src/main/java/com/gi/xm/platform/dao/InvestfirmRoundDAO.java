package com.gi.xm.platform.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.platform.pojo.InvestfirmRound;
import com.gi.xm.platform.query.InvestfirmRoundQuery;

public interface InvestfirmRoundDAO {
	
	int deleteByPrimaryKey(Long id);
	
	
    int insert(InvestfirmRound investfirmRound);

    InvestfirmRound selectByPrimaryKey(Long id);

	InvestfirmRound selectByPrimaryKeyForUpdate(Long id);
	
    List<InvestfirmRound> selectAll();

	List<InvestfirmRound> queryInvestfirmRound(InvestfirmRoundQuery investfirmRoundQuery);
			
    int updateByPrimaryKey(InvestfirmRound investfirmRound);
	
				
	List<InvestfirmRound> selectByInvestfrimId(@Param("investfrimId") Integer investfrimId);
		

}