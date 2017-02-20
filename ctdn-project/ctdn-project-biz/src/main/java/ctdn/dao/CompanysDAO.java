package ctdn.dao;



import ctdn.pojo.CompanysInfo;
import ctdn.query.CompanysQueryInfo;

import java.util.List;

public interface CompanysDAO {
	
    Long insert(CompanysInfo companys);

    Long update(CompanysInfo companys);

    List<CompanysInfo> queryCompanys(CompanysQueryInfo companysQuery);
}