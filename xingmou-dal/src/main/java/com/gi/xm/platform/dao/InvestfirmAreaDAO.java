package com.gi.xm.platform.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.platform.pojo.InvestfirmArea;
import com.gi.xm.platform.query.InvestfirmAreaQuery;

public interface InvestfirmAreaDAO {
	
	int deleteByPrimaryKey(Long id);
	
	
    int insert(InvestfirmArea investfirmArea);

    InvestfirmArea selectByPrimaryKey(Long id);

	InvestfirmArea selectByPrimaryKeyForUpdate(Long id);
	
    List<InvestfirmArea> selectAll();

	List<InvestfirmArea> queryInvestfirmArea(InvestfirmAreaQuery investfirmAreaQuery);
			
    int updateByPrimaryKey(InvestfirmArea investfirmArea);
	
				
	List<InvestfirmArea> selectByInvestfrimId(@Param("investfrimId") Integer investfrimId);
		

}