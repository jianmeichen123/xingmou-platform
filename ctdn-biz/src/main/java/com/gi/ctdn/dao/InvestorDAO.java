package com.gi.ctdn.dao;

import com.gi.ctdn.pojo.Investor;
import com.gi.ctdn.pojo.ProjectList;
import com.gi.ctdn.pojo.ProjectListInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InvestorDAO {
	Investor selectEntityByCode(@Param("code") String code);

	List<Investor> selectListByCodes (@Param("codes") List<String> cods);
}