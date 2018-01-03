

package com.gi.ctdn.biz.me;

import com.alibaba.fastjson.JSONObject;
import com.gi.ctdn.dao.BusinessLineMappingIndustryDao;
import com.gi.ctdn.dao.IndustryDAO;
import com.gi.ctdn.dao.me.UserIndustryDAO;
import com.gi.ctdn.pojo.Industry;
import com.gi.ctdn.pojo.me.UserIndustry;
import com.gi.ctdn.view.common.ListUtil;
import com.gi.ctdn.view.common.MessageInfo;
import com.gi.ctdn.view.common.MessageStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.Transient;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("userIndustryBiz")
public class UserIndustryBiz {


	private static final Logger LOGGER = LoggerFactory.getLogger(UserIndustryBiz.class);

	@Autowired
	UserIndustryDAO userIndustryDAO;

	@Autowired
	private IndustryDAO industryDAO;
	
	@Autowired
	private BusinessLineMappingIndustryDao  businessLineMappingIndustryDao;

	/**
	 * 查询用户关注行业idlist
	 * @param userCode
	 * @param deparmentId
	 * @return
	 */
	public MessageInfo<List<Integer>> getUserIndustry(String userCode,Long deparmentId) {
		MessageInfo<List<Integer>> messageInfo = new MessageInfo<List<Integer>>();
		List<Integer> industryIdList = new ArrayList<Integer>();
		try {
			//查已关注
			List<UserIndustry> list = selectUserIndustry(userCode);
			if(ListUtil.isNotEmpty(list)) {
				for (UserIndustry userIndustry : list) {
					industryIdList.add(userIndustry.getIndustryId());
				}
			}else{
				//查默认关注
				if(deparmentId != null){
					String isEmpty = businessLineMappingIndustryDao.getByDepartmentId(deparmentId);
					if("0".equals(isEmpty)){ //重置状态
						industryIdList = getDefaultIndustry(deparmentId);
					}
				}
			}
			messageInfo.setData(industryIdList);
		} catch (Exception e) {
			LOGGER.error("getUserIndustry", "查询用户关注行业失败!", e);
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
		}
		return messageInfo;
	}

	/**
	 * 增加,修改用户关注行业
	 * @param userIndustry
	 * @return
	 */
	@Transient
	public MessageInfo saveOrUpdateUerIndustry(String userJson,UserIndustry userIndustry) {
		MessageInfo messageInfo = new MessageInfo();
		try {
			String userCode = userIndustry.getUserCode();
			if(ListUtil.isNotEmpty(selectUserIndustry(userCode))){
				userIndustryDAO.deleteByUserCode(userCode);
			}
			List<UserIndustry> focusList = new ArrayList<>();
			if(ListUtil.isNotEmpty(userIndustry.getIndustryIdList())){
				UserIndustry temp = null;
				for(Integer id: userIndustry.getIndustryIdList()){
					temp = new UserIndustry();
					temp.setIndustryId(id);
					temp.setUserCode(userCode);
					focusList.add(temp);
				}
			}else{
				if(userJson!=null && userJson.trim().length() !=0){
					JSONObject jsonObject = (JSONObject) JSONObject.parse(URLDecoder.decode(userJson,"UTF-8"));
					Long  departmentId =null;
					if(jsonObject.containsKey("departmentId")){
						 departmentId = jsonObject.getLong("departmentId");
						 //更改为清空状态
						 businessLineMappingIndustryDao.updateIsEmptyStatus(departmentId,"1");
					}
				}
			}
			if(ListUtil.isNotEmpty(focusList)){
				userIndustryDAO.insert(focusList);
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("updateUserIndustry", "设置用户关注行业失败!", e);
			messageInfo = new MessageInfo<>(MessageStatus.ERROR_CODE,MessageStatus.ERROR_MESSAGE);
		}
		return messageInfo;
	}

	/**
	 * 查询内部用户默认关注:部门id关联行业id
	 * @param departmentId
	 * @return
	 */
	public List<Integer> getDefaultIndustry(Long departmentId) {
		String idStr = userIndustryDAO.selectDefaultIds(departmentId);
		List<Integer> idList =new ArrayList<Integer>();
		if(!StringUtils.isEmpty(idStr)){
			String[] ids = idStr.split(",");
			for(String id : ids){
				idList.add(Integer.parseInt(id));
			}
		}
		return idList;
	}

	/**
	 * 删除用户已关注行业
	 */
	public Integer deleteUserIndustry(String userCode) {
		Integer ret = null;
		try{
			ret =  userIndustryDAO.deleteByUserCode (userCode);
		}catch (Exception e){
			e.printStackTrace();
		}
		return ret;
	}

	/**
	 * 查询用户已关注行业
	 * @param userCode
	 * @return
	 */
	public List<UserIndustry> selectUserIndustry(String userCode) {
		List<UserIndustry> list = userIndustryDAO.getUserIndustry(userCode);
		return list;
	}

	public MessageInfo<UserIndustry> getUserIndustryIdsAndNames(UserIndustry userIndustry,Long departmentId) {
		MessageInfo<UserIndustry> messageInfo = new MessageInfo<UserIndustry>();
		List<UserIndustry> userIndustries = userIndustryDAO.getUserIndustry(userIndustry.getUserCode());
		List<Integer> industryIds  = null;
		if(userIndustries!=null && userIndustries.size()>0){
			industryIds = new ArrayList<Integer>();
			for(UserIndustry industry : userIndustries){
				industryIds.add(industry.getIndustryId());
			}
		}else{
			if(departmentId!=null){
					String isEmpty = businessLineMappingIndustryDao.getByDepartmentId(departmentId);
					if("0".equals(isEmpty)){ //重置状态
					List<Integer>	ids =  getDefaultIndustry(departmentId);
					if(ids!= null && ids.size()>0){
						industryIds = new ArrayList<Integer>();
						industryIds.addAll(ids);
					}
				}
			}
		}
		List<Industry> industries = industryDAO.getIndustryByIds(industryIds);
		StringBuffer industryNames = new StringBuffer();
		for(int i=0;i<industries.size();i++){
			Industry industry = industries.get(i);
			industryNames.append(industry.getName());
			if(i != industries.size() - 1){
				industryNames.append(",");
			}
		}
		userIndustry.setIndustryIdList(industryIds);
		userIndustry.setIndustryNames(industryNames.toString());
		messageInfo.setData(userIndustry);
		return messageInfo;
	}
}