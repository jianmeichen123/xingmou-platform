

package ctdn.biz;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ctdn.dao.ProjectProductDAO;
import ctdn.pojo.ProjectProductInfo;
import ctdn.query.ProjectProductQueryInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("projectProductBiz")
public class ProjectProductBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectProductBiz.class);

    @Autowired
	ProjectProductDAO projectProductDAO;



    public MessageInfo<Long> updateProjectProduct(ProjectProductInfo projectProduct){
		MessageInfo<Long> messageInfo = new MessageInfo<Long>();
		try {
			projectProductDAO.update( projectProduct );
			messageInfo.setData(projectProduct.getId());

		} catch (Exception e) {
			LOGGER.error("createProjectProduct","创建ProjectProduct失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

	


	public MessageInfo<QueryResultInfo<ProjectProductInfo>> queryProjectProduct(ProjectProductQueryInfo projectProductQuery) {
		MessageInfo<QueryResultInfo<ProjectProductInfo>> messageInfo = new MessageInfo<QueryResultInfo<ProjectProductInfo>>();
		try {
			QueryResultInfo<ProjectProductInfo> queryResult = new QueryResultInfo<ProjectProductInfo>();
			PageHelper.startPage(projectProductQuery.getPageIndex(), projectProductQuery.getPageSize());
			List<ProjectProductInfo> projectProductList = projectProductDAO.queryProjectProduct(projectProductQuery);
			PageInfo<ProjectProductInfo> pageInfo = new PageInfo<ProjectProductInfo>(projectProductList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(projectProductList);
			messageInfo.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryProjectProduct", "分页查询ProjectProduct失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

}