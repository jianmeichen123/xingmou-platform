package com.gi.xm.platform.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.platform.pojo.MoneyLevel;
import com.gi.xm.platform.query.MoneyLevelQuery;

public interface MoneyLevelDAO {
	
	int deleteByPrimaryKey(Integer id);
	
	
    int insert(MoneyLevel moneyLevel);

    MoneyLevel selectByPrimaryKey(Integer id);

	MoneyLevel selectByPrimaryKeyForUpdate(Integer id);
	
    List<MoneyLevel> selectAll();

	List<MoneyLevel> queryMoneyLevel(MoneyLevelQuery moneyLevelQuery);
			
    int updateByPrimaryKey(MoneyLevel moneyLevel);
	
		

}