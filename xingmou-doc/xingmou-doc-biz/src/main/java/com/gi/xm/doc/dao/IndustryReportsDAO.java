package com.gi.xm.doc.dao;

import java.util.List;

import com.gi.xm.doc.pojo.IndustryReportsInfo;
import com.gi.xm.doc.query.IndustryReportsQueryInfo;

public interface IndustryReportsDAO {
	
    int insert(IndustryReportsInfo industryReportsInfo);

    List<IndustryReportsInfo> queryIndustryReports(IndustryReportsQueryInfo industryReportsQueryInfo);

    IndustryReportsInfo selectByPrimaryKey(Integer id);

}