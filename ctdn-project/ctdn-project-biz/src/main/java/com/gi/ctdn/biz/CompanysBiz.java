

package com.gi.ctdn.biz;

import com.gi.ctdn.dao.CompanysDAO;
import com.gi.ctdn.pojo.CompanysInfo;
import com.gi.ctdn.pojo.ProjectsInfo;
import com.gi.xm.platform.view.common.MessageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("companysBiz")
public class CompanysBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(CompanysBiz.class);

    @Autowired
	CompanysDAO companysDAO;

	@Autowired
	ProjectsBiz projectsBiz;


    public MessageInfo<Long> createCompanys(CompanysInfo companys){
		MessageInfo<Long> messageInfo = new MessageInfo<Long>();
		try {
			companysDAO.insert( companys );
			messageInfo.setData(companys.getId());

		} catch (RuntimeException e) {
			LOGGER.error("createCompanys","创建Companys失败", e);
			messageInfo.setStatus(10001);
			throw e;
		}
		return messageInfo;
	}

	public MessageInfo<Long> update(CompanysInfo companysInfo){
		MessageInfo<Long> messageInfo = new MessageInfo<Long>();
		try {
			//根据projectId 查询 companyId 再update
			Long projectId = companysInfo.getProjectId();
			ProjectsInfo projectsInfo = projectsBiz.queryById(projectId).getData();
			if(projectsInfo == null || projectsInfo.getCompanyId()==null){
				messageInfo.setMessage("projectId 错误！");
				messageInfo.setStatus(10001);
				return messageInfo;
			}
			Long id = projectsInfo.getCompanyId();
			companysInfo.setId(id);
			companysDAO.update( companysInfo );
			messageInfo.setData(companysInfo.getId());
		} catch (Exception e) {
			LOGGER.error("createCompanys","修改Companys失败", e);
			messageInfo.setStatus(10001);
			throw e;
		}
		return messageInfo;
	}

	public MessageInfo<CompanysInfo> queryById(Long id) {
		MessageInfo<CompanysInfo> messageInfo = new MessageInfo<CompanysInfo>();
		try {
			CompanysInfo companysInfo = companysDAO.queryById(id);
			messageInfo.setData(companysInfo);
		} catch (Exception e) {
			LOGGER.error("queryById", "查询Companys失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

}