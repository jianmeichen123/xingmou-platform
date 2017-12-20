

package com.gi.ctdn.biz.me;

import com.gi.ctdn.dao.me.UserIndustryDAO;
import com.gi.ctdn.pojo.me.UserIndustry;
import com.gi.ctdn.view.common.ListUtil;
import com.gi.ctdn.view.common.MessageInfo;
import com.gi.ctdn.view.common.MessageStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("userIndustryBiz")
public class UserIndustryBiz {


	private static final Logger LOGGER = LoggerFactory.getLogger(UserIndustryBiz.class);

	@Autowired
	UserIndustryDAO userIndustryDAO;

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
					industryIdList = getDefaultIndustry(deparmentId);
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
	public MessageInfo saveOrUpdateUerIndustry(UserIndustry userIndustry) {
		MessageInfo messageInfo = new MessageInfo();
		try {
			String userCode = userIndustry.getUserCode();
			if(ListUtil.isNotEmpty(selectUserIndustry(userCode))){
				userIndustryDAO.deleteByUserId(userCode);
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
		List<Integer> ids = userIndustryDAO.selectDefaultIds(departmentId);
		return ids;
	}

	/**
	 * 查询用户已关注行业
	 * @param userCode
	 * @return
	 */
	private List<UserIndustry> selectUserIndustry(String userCode) {
		List<UserIndustry> list = userIndustryDAO.getUserIndustry(userCode);
		return list;
	}
}