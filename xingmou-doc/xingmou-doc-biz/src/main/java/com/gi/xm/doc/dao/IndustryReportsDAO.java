package com.gi.xm.doc.dao;

import java.util.List;

import com.gi.xm.doc.pojo.IndustryReportsInfo;
import com.gi.xm.doc.query.IndustryReportsQueryInfo;
import org.apache.ibatis.annotations.Param;

public interface IndustryReportsDAO {
	
    int insert(IndustryReportsInfo industryReportsInfo);

    List<IndustryReportsInfo> queryIndustryReports(IndustryReportsQueryInfo industryReportsQueryInfo);

    IndustryReportsInfo selectByPrimaryKey(Integer id);

    IndustryReportsInfo nextPage(Integer id);

    IndustryReportsInfo prePage(Integer id);

    /**
     * 搜索标签相近的
     * @param id 自身id,没有传null
     * @param tag
     * @return
     */
    List<IndustryReportsInfo> selectByTag(@Param("id") Integer id ,@Param("tag") String tag);
}