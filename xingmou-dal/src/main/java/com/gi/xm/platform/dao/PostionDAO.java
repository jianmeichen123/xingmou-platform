package com.gi.xm.platform.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.platform.pojo.Postion;
import com.gi.xm.platform.query.PostionQuery;

public interface PostionDAO {
	
	int deleteByPrimaryKey(Long id);
	
	
    int insert(Postion postion);

    Postion selectByPrimaryKey(Long id);

	Postion selectByPrimaryKeyForUpdate(Long id);
	
    List<Postion> selectAll();

	List<Postion> queryPostion(PostionQuery postionQuery);
			
    int updateByPrimaryKey(Postion postion);
	
		

}