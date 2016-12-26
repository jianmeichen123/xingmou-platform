package com.gi.xm.report.dao;

import com.gi.xm.report.pojo.TargetMonth;
import com.gi.xm.report.query.TargetMonthQuery;

import java.util.List;

public interface TargetMonthDAO {
	
    int insert(TargetMonth targetMonth);


	
    List<TargetMonth> queryTargetMonth(TargetMonthQuery targetMonthQuery);
}