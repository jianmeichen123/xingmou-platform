package com.gi.ctdn.dao;

import com.gi.ctdn.pojo.InvestPolicy;
import com.gi.ctdn.pojo.Investor;
import org.apache.ibatis.annotations.Param;

public interface InvestPolicyDAO {
	//投资策略
	InvestPolicy selectEntityByCode(@Param("code") String code);
}