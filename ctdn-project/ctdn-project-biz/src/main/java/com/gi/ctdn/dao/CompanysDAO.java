package com.gi.ctdn.dao;



import com.gi.ctdn.query.CompanysQueryInfo;
import com.gi.ctdn.pojo.CompanysInfo;

import java.util.List;

public interface CompanysDAO {
	
    int insert(CompanysInfo companys);

    Long update(CompanysInfo companys);

    CompanysInfo queryById(Long projectId);
}