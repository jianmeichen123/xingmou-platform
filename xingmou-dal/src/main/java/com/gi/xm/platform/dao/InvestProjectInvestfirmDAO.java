package com.gi.xm.platform.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.platform.pojo.InvestProjectInvestfirm;
import com.gi.xm.platform.query.InvestProjectInvestfirmQuery;

public interface InvestProjectInvestfirmDAO {
	
	int deleteByPrimaryKey(Long id);
	
	
    int insert(InvestProjectInvestfirm investProjectInvestfirm);

    InvestProjectInvestfirm selectByPrimaryKey(Long id);

	InvestProjectInvestfirm selectByPrimaryKeyForUpdate(Long id);
	
    List<InvestProjectInvestfirm> selectAll();

	List<InvestProjectInvestfirm> queryInvestProjectInvestfirm(InvestProjectInvestfirmQuery investProjectInvestfirmQuery);
			
    int updateByPrimaryKey(InvestProjectInvestfirm investProjectInvestfirm);
	
				
	List<InvestProjectInvestfirm> selectByInvestId(@Param("investId") Long investId);
				
	List<InvestProjectInvestfirm> selectByInvestfirmId(@Param("investfirmId") Long investfirmId);
				
	List<InvestProjectInvestfirm> selectByProjectId(@Param("projectId") Long projectId);
		

}