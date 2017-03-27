package com.gi.ctdn.ods.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.ctdn.ods.pojo.WeixinIndice;

public interface WeixinIndiceDAO {
	
			
	List<WeixinIndice> selectByWxid(@Param("wxid") String wxid);
		
}