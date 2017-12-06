

package com.gi.ctdn.biz.me;

import com.gi.ctdn.dao.me.UserIndustryDAO;
import com.gi.ctdn.pojo.me.UserIndustry;
import com.gi.ctdn.view.common.MessageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("userIndustryBiz")
public class UserIndustryBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(UserIndustryBiz.class);

    @Autowired
	UserIndustryDAO userIndustryDAO;

    public MessageInfo<UserIndustry> getUserIndustry(Integer userId){

		MessageInfo<UserIndustry> messageInfo = new MessageInfo<UserIndustry>();
		try {
			UserIndustry userIndustry = userIndustryDAO.getUserIndustry(userId);
			if(userIndustry != null && userIndustry.getIndustryIds() != null && userIndustry.getIndustryNames()!=null){
				//字符串转换成List
				String[] idArray =  userIndustry.getIndustryIds().split(",");
				String[] nameArray = userIndustry.getIndustryNames().split(",");
				List<Integer> industryIdList = new ArrayList<Integer>();
				for(int i =0 ;i<idArray.length;i++){
					industryIdList.add(Integer.parseInt(idArray[i]));
				}
				List<String> industryNameList= Arrays.asList(nameArray);
				userIndustry.setIndustryNameList(industryNameList);
				userIndustry.setIndustryIdList(industryIdList);
			}
			messageInfo.setData( userIndustry);
		} catch (Exception e) {
			LOGGER.error("getUserIndustry","查询用户关注行业失败!", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

	public MessageInfo updateUserIndustry(UserIndustry userIndustry){

		MessageInfo messageInfo = new MessageInfo();
		try {
			int ret = userIndustryDAO.updateUserIndustry(userIndustry);
			messageInfo.setData(ret);
		} catch (Exception e) {
			LOGGER.error("updateUserIndustry","设置用户关注行业失败!", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
}