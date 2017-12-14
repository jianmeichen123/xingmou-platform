

package com.gi.ctdn.biz;

import com.gi.ctdn.dao.*;
import com.gi.ctdn.dao.me.UserIndustryDAO;
import com.gi.ctdn.pojo.*;
import com.gi.ctdn.pojo.me.UserIndustry;
import com.gi.ctdn.view.common.MessageInfo;
import com.gi.ctdn.view.common.MessageStatus;
import com.gi.ctdn.view.common.Pagination;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("projectListBiz")
public class ProjectListBiz {


	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectListBiz.class);

	@Autowired
	ProjectListDAO projectListDAO;
	
	@Autowired
	UserIndustryDAO userIndustryDAO;

	public MessageInfo<ProjectListInfo> queryCompetationlist(String sourceCode) {

		MessageInfo<ProjectListInfo> message = new MessageInfo<ProjectListInfo>();
		try {
			ProjectList projectList = getOneByCode(sourceCode);
			if(projectList != null){
				ProjectListInfo projectListInfo = new ProjectListInfo();
				List<ProjectList> directCompetationlist = getNewList(sourceCode,0);
				List<ProjectList> indirectCompetationlist = getNewList(sourceCode,1);
				projectListInfo.setDirectCompetationlist(directCompetationlist);
				projectListInfo.setIndirectCompetationlist(indirectCompetationlist);
				message.setData(projectListInfo);
			}
		} catch (Exception e) {
			LOGGER.error("queryCompetationlist", "查询竞争对手失败", e);
			message.setStatus(MessageStatus.ERROR_CODE);
		}
		return message;
	}

	private List<ProjectList> getNewList(String sourceCode, Integer isSame) {
		List<ProjectList> newList = new ArrayList<>();
		//查询竞品列表
		List<ProjectList> pList = projectListDAO.selectCompetationlist(sourceCode, isSame);
		if (pList != null && !pList.isEmpty()) {
			List<ProjectList> cList = projectListDAO.selectCompetitiveSimilar(sourceCode, isSame);
			for (ProjectList s : cList) {
				String code = s.getProjCode();
				Double similar = s.getSimilarity();
				for (ProjectList p : pList) {
					if (code.equals(p.getProjCode())) {
						p.setSimilarity(similar);
						newList.add(p);
					}
				}
			}
		}
		return newList;
	}

	public ProjectList getOneByCode(String code){
		ProjectList projectList = projectListDAO.selectByCode(code);
		return projectList;
	}

	public List<ProjectList> getByFinanceDate(){
		List<ProjectList> projectLists = projectListDAO.selectByFinanceDate();
		return projectLists;
	}

	public List<ProjectList> getListByCodes(List<String> codes){
		List<ProjectList> projectLists = projectListDAO.selectListByCodes(codes);
		return projectLists;
	}

	public MessageInfo<ProjectList> queryByCompCode(ProjectList projectList){
		MessageInfo<ProjectList> messageInfo;
		try {
			PageHelper.startPage(projectList.getPageNo(), projectList.getPageSize());
			List<ProjectList> projectLists = projectListDAO.selectListByCode(projectList.getCompCode());
			PageInfo<ProjectList> pageInfo = new PageInfo<ProjectList>(projectLists);
			Pagination page = new Pagination();
			page.setTotal(pageInfo.getTotal());
			page.setRecords(projectLists);
			messageInfo = new MessageInfo( MessageStatus.OK_CODE,MessageStatus.OK_MESSAGE,page);
		} catch (Exception e) {
			LOGGER.error("querycompSubList","查询CompSub失败", e);
			messageInfo = new MessageInfo(MessageStatus.ERROR_CODE,e.getMessage());
		}
		return messageInfo;
	}

	public List<ProjectList> selectByLoadDate() {
		UserIndustry  userIndustry = userIndustryDAO.getUserIndustry(1);
		List<String> industryIds = null;
		if(userIndustry !=null && userIndustry.getIndustryIds()!=null  && !userIndustry.getIndustryIds().equals("")){
			industryIds = Arrays.asList(userIndustry.getIndustryIds().split(","));
		}
		return projectListDAO.selectByLoadDate(industryIds);
	}

	@SuppressWarnings("null")
	public List<ProjectList> queryLastestFinanceProject() {
		UserIndustry  userIndustry = userIndustryDAO.getUserIndustry(1);
		List<String> industryIds = null;
		if(userIndustry !=null && userIndustry.getIndustryIds()!=null && !userIndustry.getIndustryIds().equals("")){
			industryIds = Arrays.asList(userIndustry.getIndustryIds().split(","));
		}
		return projectListDAO.selectByLatestFinanceDate(industryIds);
	}


}