package com.gi.xm.platform.dao;

import java.util.List;

import com.gi.xm.platform.pojo.Company;
import com.gi.xm.platform.query.CompanyQuery;

public interface CompanyDAO {
	
    Company selectByPrimaryKey(Long id);

	List<Company> queryCompany(CompanyQuery companyQuery);

}