

package ctdn.biz;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ctdn.dao.CompanysDAO;
import ctdn.pojo.CompanysInfo;
import ctdn.query.CompanysQueryInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("companysBiz")
public class CompanysBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(CompanysBiz.class);

    @Autowired
	CompanysDAO companysDAO;



    public MessageInfo<Long> create(CompanysInfo companys){
		MessageInfo<Long> messageInfo = new MessageInfo<Long>();
		try {
			companysDAO.insert( companys );
			messageInfo.setData(companys.getId());

		} catch (Exception e) {
			LOGGER.error("createCompanys","创建Companys失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}


	public MessageInfo<Long> update(CompanysInfo companys){
		MessageInfo<Long> messageInfo = new MessageInfo<Long>();
		try {
			Long id = companysDAO.upda( companys );
			messageInfo.setData(companys.getId());

		} catch (Exception e) {
			LOGGER.error("createCompanys","创建Companys失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

	public MessageInfo<QueryResultInfo<CompanysInfo>> queryCompanys(CompanysQueryInfo companysQuery) {
		MessageInfo<QueryResultInfo<CompanysInfo>> messageInfo = new MessageInfo<QueryResultInfo<CompanysInfo>>();
		try {
			QueryResultInfo<CompanysInfo> queryResult = new QueryResultInfo<CompanysInfo>();
			PageHelper.startPage(companysQuery.getPageIndex(), companysQuery.getPageSize());
			List<CompanysInfo> companysList = companysDAO.queryCompanys(companysQuery);
			PageInfo<CompanysInfo> pageInfo = new PageInfo<CompanysInfo>(companysList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(companysList);
			messageInfo.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryCompanys", "分页查询Companys失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

}