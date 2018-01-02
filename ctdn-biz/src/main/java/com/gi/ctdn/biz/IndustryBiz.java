

package com.gi.ctdn.biz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.biz.me.UserIndustryBiz;
import com.gi.ctdn.dao.BusinessLineMappingIndustryDao;
import com.gi.ctdn.dao.IndustryDAO;
import com.gi.ctdn.dao.me.UserIndustryDAO;
import com.gi.ctdn.view.common.MessageInfo;

import com.gi.ctdn.pojo.Industry;
import com.gi.ctdn.pojo.me.UserIndustry;

@Service("industryBiz")
public class IndustryBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(IndustryBiz.class);

    @Autowired
	IndustryDAO industryDAO;
    
    @Autowired
    private UserIndustryDAO userIndustryDAO;
    
    @Autowired
    private UserIndustryBiz userIndustryBiz;
    
	@Autowired
	private BusinessLineMappingIndustryDao  businessLineMappingIndustryDao;


	


    public MessageInfo<List<Industry>> getAllIndustry(){

		MessageInfo<List<Industry>> messageInfo = new MessageInfo<List<Industry>>();
		try {
			List<Industry> industryList = industryDAO.selectAll();
			messageInfo.setData( industryList);
		} catch (Exception e) {
			LOGGER.error("getAllIndustry","查询全部Industry失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

	public MessageInfo<List<Industry>> getIndustrysByStatus(Integer status){

		MessageInfo<List<Industry>> messageInfo = new MessageInfo<List<Industry>>();
		try {
			List<Industry> industryList = industryDAO.selectindustrysByStatus(status);
			messageInfo.setData( industryList);
		} catch (Exception e) {
			LOGGER.error("getIndustrysByStatus","查询Industry失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

	public MessageInfo<List<Industry>> selectOrgindustrystatus(){

		MessageInfo<List<Industry>> messageInfo = new MessageInfo<List<Industry>>();
		try {
			List<Industry> industryList = industryDAO.selectOrgindustrystatus();
			messageInfo.setData( industryList);
		} catch (Exception e) {
			LOGGER.error("getIndustrysByStatus","查询Industry失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
	
	public List<Industry> getParentindustrys( UserIndustry userIndustry,Long departmentId){
		List<UserIndustry> userIndustryList = userIndustryDAO.getUserIndustry(userIndustry.getUserCode());
		List<Integer> industryIds = new ArrayList<Integer>();
		if(userIndustryList!=null && userIndustryList.size()>0){
			for(UserIndustry uIndustry : userIndustryList){
				industryIds.add(uIndustry.getIndustryId());
			}
		}else{
			if(departmentId!=null){
				String isEmpty = businessLineMappingIndustryDao.getByDepartmentId(departmentId);
				if("0".equals(isEmpty)){ //重置状态
					industryIds = userIndustryBiz.getDefaultIndustry(departmentId);
				}
			}
		}
		List<Industry>  industryList = industryDAO.selectParentindustrys();
		for(Industry industry : industryList){
			if(industryIds.contains(industry.getId())){
				industry.setFlag("1");
			}else{
				industry.setFlag("0");
			}
		}
		return  industryList;
	}


}