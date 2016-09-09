package com.gi.xm.platform.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.platform.pojo.Label;
import com.gi.xm.platform.query.LabelQuery;

public interface LabelDAO {
	
	int deleteByPrimaryKey(Long id);
	
	
    int insert(Label label);

    Label selectByPrimaryKey(Long id);

	Label selectByPrimaryKeyForUpdate(Long id);
	
    List<Label> selectAll();

	List<Label> queryLabel(LabelQuery labelQuery);
			
    int updateByPrimaryKey(Label label);
	
		

}