

package com.gi.ctdn.biz;

import com.gi.ctdn.dao.CompanysDAO;
import com.gi.ctdn.pojo.CompanysInfo;
import com.gi.xm.platform.view.common.MessageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("companysBiz")
public class CompanysBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(CompanysBiz.class);

    @Autowired
	CompanysDAO companysDAO;



    public MessageInfo<Long> createCompanys(CompanysInfo companys){
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
			Long id = companysDAO.update( companys );
			messageInfo.setData(companys.getId());
		} catch (Exception e) {
			LOGGER.error("createCompanys","修改Companys失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

	public MessageInfo<CompanysInfo> queryByProjectId(Long projectId) {
		MessageInfo<CompanysInfo> messageInfo = new MessageInfo<CompanysInfo>();
		try {
			CompanysInfo companysInfo = companysDAO.queryByProjectId(projectId);
			messageInfo.setData(companysInfo);
		} catch (Exception e) {
			LOGGER.error("queryCompanys", "查询Companys失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

}