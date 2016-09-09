package com.gi.xm.platform.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.platform.pojo.Company;
import com.gi.xm.platform.query.CompanyQuery;

public interface CompanyDAO {
	
	int deleteByPrimaryKey(Long id);
	
	
    int insert(Company company);

    Company selectByPrimaryKey(Long id);

	Company selectByPrimaryKeyForUpdate(Long id);
	
    List<Company> selectAll();

	List<Company> queryCompany(CompanyQuery companyQuery);
			
    int updateByPrimaryKey(Company company);
	
		

}