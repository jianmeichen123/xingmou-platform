package ctdn.dao;


import ctdn.pojo.ProjectProductInfo;
import ctdn.query.ProjectProductQueryInfo;

import java.util.List;

public interface ProjectProductDAO {
	
    Long update(ProjectProductInfo projectProduct);


	
    List<ProjectProductInfo> queryProjectProduct(ProjectProductQueryInfo projectProductQuery);
}