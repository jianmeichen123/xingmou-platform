

package com.gi.ctdn.biz;

import com.gi.ctdn.dao.TeamMembersDAO;
import com.gi.ctdn.pojo.TeamMemberJobInfo;
import com.gi.ctdn.pojo.TeamMemberStudyInfo;
import com.gi.ctdn.pojo.TeamMembersInfo;
import com.gi.ctdn.query.TeamMemberJobQueryInfo;
import com.gi.ctdn.query.TeamMemberStudyQueryInfo;
import com.gi.ctdn.query.TeamMembersQueryInfo;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("teamMembersBiz")
public class TeamMembersBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(TeamMembersBiz.class);

    @Autowired
	TeamMembersDAO teamMembersDAO;

	@Autowired
	TeamMemberJobBiz teamMemberJobBiz;

	@Autowired
	TeamMemberStudyBiz teamMemberStudyBiz;


    public MessageInfo<Long> createTeamMembers(TeamMembersInfo teamMembers){
		MessageInfo<Long> messageInfo = new MessageInfo<Long>();
		try {
			teamMembersDAO.insert( teamMembers );
			messageInfo.setData(teamMembers.getId());

		} catch (Exception e) {
			LOGGER.error("createTeamMembers","创建TeamMembers失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

	public MessageInfo<Long> updateTeamMembers(TeamMembersInfo teamMembers){
		MessageInfo<Long> messageInfo = new MessageInfo<Long>();
		try {
			teamMembersDAO.update( teamMembers );
			messageInfo.setData(teamMembers.getId());

		} catch (Exception e) {
			LOGGER.error("createTeamMembers","创建TeamMembers失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}


	public MessageInfo<List<TeamMembersInfo>> queryByProjectId (Long projectId){
		MessageInfo<List<TeamMembersInfo>> messageInfo = new MessageInfo<List<TeamMembersInfo>>();
		try {
			List<TeamMembersInfo> teamMembersInfoList = teamMembersDAO.queryByProjectId( projectId );
			List<Long> memberIdList = new ArrayList<Long>();
			//通过memeberId 查询job study list
			if(!teamMembersInfoList.isEmpty()){
				for(TeamMembersInfo membersInfo:teamMembersInfoList){
					List<TeamMemberJobInfo> jobInfoList = teamMemberJobBiz.queryByMemberId(membersInfo.getId()).getData();
					List<TeamMemberStudyInfo> studyInfoList = teamMemberStudyBiz.queryByMemberId(membersInfo.getId()).getData();
					membersInfo.setJobInfoList(jobInfoList);
					membersInfo.setStudyInfoList(studyInfoList);
				}
			}
			messageInfo.setData(teamMembersInfoList);
		} catch (Exception e) {
			LOGGER.error("queryByProjectId","查询TeamMembers失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

	public MessageInfo<QueryResultInfo<TeamMembersInfo>> queryTeamMembers(TeamMembersQueryInfo teamMembersQuery) {
		MessageInfo<QueryResultInfo<TeamMembersInfo>> messageInfo = new MessageInfo<QueryResultInfo<TeamMembersInfo>>();
		try {
			QueryResultInfo<TeamMembersInfo> queryResult = new QueryResultInfo<TeamMembersInfo>();
			PageHelper.startPage(teamMembersQuery.getPageIndex(), teamMembersQuery.getPageSize());
			List<TeamMembersInfo> teamMembersList = teamMembersDAO.queryTeamMembers(teamMembersQuery);
			PageInfo<TeamMembersInfo> pageInfo = new PageInfo<TeamMembersInfo>(teamMembersList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(teamMembersList);
			messageInfo.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryTeamMembers", "分页查询TeamMembers失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

	public MessageInfo deleteMember(Long id) {
		MessageInfo messageInfo = new MessageInfo();
		try {
			//先删除study job 关联
			TeamMemberStudyQueryInfo study = new TeamMemberStudyQueryInfo();
			TeamMemberJobQueryInfo job = new TeamMemberJobQueryInfo();
			study.setMemberId(id);
			job.setMemberId(id);
			teamMemberStudyBiz.deleteMemberStudy(study);
			teamMemberJobBiz.deleteMemberJob(job);
			Integer ret  = teamMembersDAO.delete(id);
			messageInfo.setData(ret);
		} catch (Exception e) {
			LOGGER.error("deleteMember","删除TeamMembers失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

	public MessageInfo<TeamMembersInfo> queryById(Long id) {
		MessageInfo messageInfo = new MessageInfo();
		try {
			TeamMembersInfo info  = teamMembersDAO.queryById(id);
			messageInfo.setData(info);
		} catch (Exception e) {
			LOGGER.error("queryById","查询TeamMembers失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
}