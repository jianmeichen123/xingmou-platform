package com.gi.xm.platform.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.platform.pojo.Area;
import com.gi.xm.platform.query.AreaQuery;

public interface AreaDAO {
	
	int deleteByPrimaryKey(Long id);
	
	
    int insert(Area area);

    Area selectByPrimaryKey(Long id);

	Area selectByPrimaryKeyForUpdate(Long id);
	
    List<Area> selectAll();

	List<Area> queryArea(AreaQuery areaQuery);
			
    int updateByPrimaryKey(Area area);
	
		

}