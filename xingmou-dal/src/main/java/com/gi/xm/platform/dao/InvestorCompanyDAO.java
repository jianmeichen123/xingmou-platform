package com.gi.xm.platform.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.platform.pojo.InvestorCompany;
import com.gi.xm.platform.query.InvestorCompanyQuery;

public interface InvestorCompanyDAO {
	
	int deleteByPrimaryKey(Long id);
	
	
    int insert(InvestorCompany investorCompany);

    InvestorCompany selectByPrimaryKey(Long id);

	InvestorCompany selectByPrimaryKeyForUpdate(Long id);
	
    List<InvestorCompany> selectAll();

	List<InvestorCompany> queryInvestorCompany(InvestorCompanyQuery investorCompanyQuery);
			
    int updateByPrimaryKey(InvestorCompany investorCompany);
	
			
	int changeStatus(
			@Param("id") Long id,
			@Param("status") Integer status,
			@Param("updateUserid") String updateUserid);
		

}