package com.gi.xm.platform.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.platform.pojo.Round;
import com.gi.xm.platform.query.RoundQuery;

public interface RoundDAO {
	
	int deleteByPrimaryKey(Integer id);
	
	
    int insert(Round round);

    Round selectByPrimaryKey(Integer id);

	Round selectByPrimaryKeyForUpdate(Integer id);
	
    List<Round> selectAll();

	List<Round> queryRound(RoundQuery roundQuery);
			
    int updateByPrimaryKey(Round round);

    List<Round> selectByType(@Param("type") Integer type);

}