package com.gi.ctdn.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.ctdn.pojo.ListingType;

public interface ListingTypeDAO {
	
	
	List<ListingType> selectAll();

	List<ListingType> selectListingType();

	List<ListingType> selectSecondListingType(@Param("typeId") Integer typeId);
}