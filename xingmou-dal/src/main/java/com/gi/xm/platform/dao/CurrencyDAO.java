package com.gi.xm.platform.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.platform.pojo.Currency;
import com.gi.xm.platform.query.CurrencyQuery;

public interface CurrencyDAO {
	
	int deleteByPrimaryKey(Long id);
	
	
    int insert(Currency currency);

    Currency selectByPrimaryKey(Long id);

	Currency selectByPrimaryKeyForUpdate(Long id);
	
    List<Currency> selectAll();

	List<Currency> queryCurrency(CurrencyQuery currencyQuery);
			
    int updateByPrimaryKey(Currency currency);
	
		

}