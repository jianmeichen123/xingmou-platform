

package com.gi.ctdn.biz;

import com.gi.ctdn.biz.me.UserIndustryBiz;
import com.gi.ctdn.dao.*;
import com.gi.ctdn.dao.me.UserIndustryDAO;
import com.gi.ctdn.pojo.*;
import com.gi.ctdn.pojo.me.UserIndustry;
import com.gi.ctdn.view.common.ListUtil;
import com.gi.ctdn.view.common.MessageInfo;
import com.gi.ctdn.view.common.MessageStatus;
import com.gi.ctdn.view.common.Pagination;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.*;

@Service("projectListBiz")
public class ProjectListBiz {


	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectListBiz.class);

	@Autowired
	ProjectListDAO projectListDAO;
	
	@Autowired
	UserIndustryDAO userIndustryDAO;
	
	@Autowired
	UserIndustryBiz userIndustryBiz;
	
	@Autowired
	private BusinessLineMappingIndustryDao  businessLineMappingIndustryDao;

	public MessageInfo<ProjectListInfo> queryCompetationlist(String sourceCode) {

		MessageInfo<ProjectListInfo> message = new MessageInfo<ProjectListInfo>();
		try {
			ProjectList projectList = getOneByCode(sourceCode);
			if(projectList != null){
				ProjectListInfo projectListInfo = new ProjectListInfo();
				List<ProjectList> directCompetationlist = new ArrayList<>();
				List<ProjectList> indirectCompetationlist = new ArrayList<>();
				List<ProjectList> cList = projectListDAO.selectCompetitiveSimilar(sourceCode);
				List<String> codeList = new ArrayList<>();
				Map<String,ProjectList> map = new HashMap<>();
				if(ListUtil.isNotEmpty(cList)){
					for(ProjectList c :cList){
						codeList.add(c.getProjCode());
						map.put(c.getProjCode(),c);
					}
					List<ProjectList> pList = projectListDAO.selectListByCodes(codeList);
					for(ProjectList p : pList){
						Integer same = map.get(p.getProjCode()).getIsSame();
						Double similar = map.get(p.getProjCode()).getSimilarity();
						p.setSimilarity(similar);
						if(same == 0){
							directCompetationlist.add(p);
						}else if(same == 1){
							indirectCompetationlist.add(p);
						}
					}
				}
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

	public List<ProjectList> selectByLoadDate(String userCode,Long departmentId) {
		List<UserIndustry> userIndustries = userIndustryDAO.getUserIndustry(userCode);
		List<Integer> industryIds  = null;
		if(userIndustries!=null && userIndustries.size()>0){
			for(UserIndustry industry : userIndustries){
				if(industryIds == null){
					industryIds = new ArrayList<Integer>();
				}
				industryIds.add(industry.getIndustryId());
			}
		}else{
			if(departmentId!=null){
				String isEmpty = businessLineMappingIndustryDao.getByDepartmentId(departmentId);
				if("0".equals(isEmpty)){ //重置状态
					List<Integer> ids = userIndustryBiz.getDefaultIndustry(departmentId);
					if(ids!=null && ids.size()>0){
						industryIds = new ArrayList<Integer>();
						industryIds.addAll(ids);
					}
				}
			}
		}
		if(industryIds!=null && industryIds.size() == 29){
			industryIds = null;
		}
		return projectListDAO.selectByLoadDate(industryIds);
	}

	public List<Integer> getUserIndustryIds(UserIndustry userIndustry){
		List<UserIndustry>  userIndustryList = userIndustryDAO.getUserIndustry(userIndustry.getUserCode());
		List<Integer> industryIds = null;
		if(userIndustryList != null && userIndustryList.size()>0){
			industryIds = new ArrayList<Integer>();
			for(UserIndustry ui : userIndustryList){
				industryIds.add(ui.getIndustryId());
			}
		}
		return industryIds;
	}
	public List<ProjectList> queryLastestFinanceProject(String userCode,Long departmentId) {
		List<UserIndustry> userIndustries = userIndustryDAO.getUserIndustry(userCode);
		List<Integer> industryIds  = null;
		if(userIndustries!=null && userIndustries.size()>0){
			for(UserIndustry industry : userIndustries){
				if(industryIds == null){
					industryIds = new ArrayList<Integer>();
				}
				industryIds.add(industry.getIndustryId());
			}
		}else{
			if(departmentId!=null){
				String isEmpty = businessLineMappingIndustryDao.getByDepartmentId(departmentId);
				if("0".equals(isEmpty)){ //重置状态
					List<Integer> ids = userIndustryBiz.getDefaultIndustry(departmentId);
					if(ids!=null && ids.size()>0){
						industryIds = new ArrayList<Integer>();
						industryIds.addAll(ids);
					}
				}
			}
		}
		if(industryIds!=null && industryIds.size() == 29){
			industryIds = null;
		}
		return projectListDAO.selectByLatestFinanceDate(industryIds);
	}


}