

package com.gi.ctdn.biz;

import com.gi.ctdn.dao.TeamMemberStudyDAO;
import com.gi.ctdn.pojo.TeamMemberStudyInfo;
import com.gi.ctdn.query.TeamMemberStudyQueryInfo;
import com.gi.ctdn.util.DateUtil;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("teamMemberStudyBiz")
public class TeamMemberStudyBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(TeamMemberStudyBiz.class);

    @Autowired
	TeamMemberStudyDAO teamMemberStudyDAO;

    public MessageInfo<Long> createTeamMemberStudy(TeamMemberStudyInfo teamMemberStudyInfo){
		MessageInfo<Long> messageInfo = new MessageInfo<Long>();
		try {
			teamMemberStudyInfo.setAddTime(DateUtil.getNow());
			teamMemberStudyDAO.insert( teamMemberStudyInfo );
			messageInfo.setData(teamMemberStudyInfo.getId());
		} catch (Exception e) {
			LOGGER.error("createTeamMemberStudy","创建TeamMemberStudy失败", e);
			messageInfo.setMessage("失败");
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

	public MessageInfo<Long> updateTeamMemberStudy(TeamMemberStudyInfo teamMemberStudyInfo){
		MessageInfo<Long> messageInfo = new MessageInfo<Long>();
		try {
			teamMemberStudyInfo.setUpdateTime(DateUtil.getNow());
			teamMemberStudyDAO.update( teamMemberStudyInfo );
			messageInfo.setData(teamMemberStudyInfo.getId());
		} catch (Exception e) {
			LOGGER.error("updateTeamMemberStudy","修改TeamMemberStudy失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

	public MessageInfo deleteMemberStudy(TeamMemberStudyQueryInfo teamMemberStudyQueryInfo) {
		MessageInfo messageInfo = new MessageInfo();
		try {
			Integer ret  = teamMemberStudyDAO.delete(teamMemberStudyQueryInfo);
			messageInfo.setData(ret);
		} catch (Exception e) {
			LOGGER.error("deleteMember","删除TeamMembers失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

	public MessageInfo<List<TeamMemberStudyInfo>> queryByMemberId (Long memberId){
		MessageInfo<List<TeamMemberStudyInfo>> messageInfo = new MessageInfo<List<TeamMemberStudyInfo>>();
		try {
			List<TeamMemberStudyInfo> teamMemberStudyInfoList = teamMemberStudyDAO.queryByMemberId( memberId );
			messageInfo.setData(teamMemberStudyInfoList);
		} catch (Exception e) {
			LOGGER.error("queryByMemberId","根据memberId查询列表失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
}