package com.gi.xm.platform.dao;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.platform.pojo.DmCompany;
import com.gi.xm.platform.query.DmCompanyQuery;

public interface DmCompanyDAO {
	
	int deleteByPrimaryKey(Long id);
	
	
    int insert(DmCompany dmCompany);

    DmCompany selectByPrimaryKey(Long id);

	DmCompany selectByPrimaryKeyForUpdate(Long id);
	
    List<DmCompany> selectAll();

	List<DmCompany> queryDmCompany(DmCompanyQuery dmCompanyQuery);
			
    int updateByPrimaryKey(DmCompany dmCompany);
	
		

}