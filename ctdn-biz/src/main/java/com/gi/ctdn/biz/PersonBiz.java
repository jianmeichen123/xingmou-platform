

package com.gi.ctdn.biz;

import com.gi.ctdn.dao.InvestorDAO;
import com.gi.ctdn.dao.StartUpDAO;
import com.gi.ctdn.pojo.Investor;
import com.gi.ctdn.pojo.StartUp;
import com.gi.ctdn.view.common.MessageInfo;
import com.gi.ctdn.view.common.MessageStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("startUpBiz")
public class PersonBiz {


	private static final Logger LOGGER = LoggerFactory.getLogger(PersonBiz.class);

	@Autowired
	StartUpDAO startUpDAO;

	@Autowired
	InvestorDAO investorDAO;

	public MessageInfo<StartUp> queryStartUpBaseInfo(String code) {

		MessageInfo<StartUp> message = new MessageInfo<StartUp>();
		try {
			StartUp startUp = startUpDAO.selectEntityByCode(code);
			if(startUp != null){
				message.setData(startUp);
			}
		} catch (Exception e) {
			LOGGER.error("getStartUpByCode", "查询创业者基本信息失败", e);
			message.setStatus(MessageStatus.ERROR_CODE);
		}
		return message;
	}

	/**
	 * 根据code查询创业者列表
	 * @param codes
	 * @return
	 */
	public List<StartUp> getStartUpListByCodes(List<String> codes){
		List<StartUp> projectLists = startUpDAO.selectListByCodes(codes);
		return projectLists;
	}

	/**
	 * 根据code查询投资人列表
	 * @param codes
	 * @return
	 */
	public List<Investor> getInvestorListByCodes(List<String> codes){
		List<Investor> projectLists = investorDAO.selectListByCodes(codes);
		return projectLists;
	}
}