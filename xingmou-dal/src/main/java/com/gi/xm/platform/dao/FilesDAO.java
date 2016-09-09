package com.gi.xm.platform.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.platform.pojo.Files;
import com.gi.xm.platform.query.FilesQuery;

public interface FilesDAO {
	
	int deleteByPrimaryKey(Long id);
	
	
    int insert(Files files);

    Files selectByPrimaryKey(Long id);

	Files selectByPrimaryKeyForUpdate(Long id);
	
    List<Files> selectAll();

	List<Files> queryFiles(FilesQuery filesQuery);
			
    int updateByPrimaryKey(Files files);
	
				
	List<Files> selectBySourceId(@Param("sourceId") Long sourceId);
		

}