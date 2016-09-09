package com.gi.xm.platform.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.platform.pojo.Data;
import com.gi.xm.platform.query.DataQuery;

public interface DataDAO {
	
	int deleteByPrimaryKey(Integer id);
	
	
    int insert(Data data);

    Data selectByPrimaryKey(Integer id);

	Data selectByPrimaryKeyForUpdate(Integer id);
	
    List<Data> selectAll();

	List<Data> queryData(DataQuery dataQuery);
			
    int updateByPrimaryKey(Data data);
	
		

}