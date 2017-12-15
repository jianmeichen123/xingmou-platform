

package com.gi.ctdn.biz;

import com.gi.ctdn.dao.*;
import com.gi.ctdn.pojo.*;
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
	@Autowired
	InvestPolicyDAO investPolicyDAO;
	@Autowired
	PersonComExprDAO personComExprDAO;
	@Autowired
	PersonWorkExprDAO personWorkExprDAO;
	@Autowired
	PersonEduExprDAO personEduExprDAO;

	/**
	 * 查询
	 * @param code
	 * @return
	 */
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

	public MessageInfo<Investor> queryInvestorBaseInfo(String code) {
		MessageInfo<Investor> message = new MessageInfo<Investor>();
		try {
			Investor investor = investorDAO.selectEntityByCode(code);
			if(investor != null){
				message.setData(investor);
			}
		} catch (Exception e) {
			LOGGER.error("queryInvestorBaseInfo", "查询投资人信息失败", e);
			message.setStatus(MessageStatus.ERROR_CODE);
		}
		return message;
	}

	/**
	 * 投资策略
	 * @param code
	 * @return
	 */
	public InvestPolicy queryInvestPolicyInfo(String code) {
		InvestPolicy investPolicy = investPolicyDAO.selectEntityByCode(code);
		return investPolicy;
	}

	/**
	 * 投资案例/创业经历列表
	 * @param code
	 * @param type
	 * @return
	 */
	public List<PersonComExpr> queryPersonComExpr(String code, String type) {
		List<PersonComExpr> personComExprs = personComExprDAO.selectPersonComList(code, type);
		return personComExprs;
	}

	/**
	 * 查询教育经历列表
	 * @param code
	 * @param type
	 * @return
	 */
	public List<PersonEduExpr> queryPersonEduExpr(String code, String type) {

		List<PersonEduExpr> personEduExprs = personEduExprDAO.selectEduList(code, type);

		for(int i=0;i<personEduExprs.size();i++){
			System.out.println(personEduExprs.get(i));
		}

		return personEduExprs;
	}

	public List<PersonWorkExpr> queryPersonWorkExpr(String code, String type) {
		List<PersonWorkExpr> personWorkExprs = personWorkExprDAO.selectWorkList(code, type);
		return personWorkExprs;
	}

	/**
	 * 根据code查询投资人列表
	 * @param codes
	 * @return
	 */
	public List<Investor> getInvestorListByCodes(List<String> codes) {
		List<Investor> projectLists = investorDAO.selectByCodeList(codes);
		return projectLists;
	}

	/**
	 * 根据code查询创业者列表
	 * @param codes
	 * @return
	 */
	public List<StartUp> getStartUpListByCodes(List<String> codes){
		List<StartUp> projectLists = startUpDAO.selectByCodeList(codes);
		return projectLists;
	}
}