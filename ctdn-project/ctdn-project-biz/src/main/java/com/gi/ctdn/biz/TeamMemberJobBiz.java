

package com.gi.ctdn.biz;


import com.gi.ctdn.dao.TeamMemberJobDAO;
import com.gi.ctdn.pojo.TeamMemberJobInfo;
import com.gi.ctdn.query.TeamMemberJobQueryInfo;
import com.gi.ctdn.util.DateUtil;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("teamMemberJobBiz")
public class TeamMemberJobBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(TeamMemberJobBiz.class);

    @Autowired
	TeamMemberJobDAO teamMemberJobDAO;



    public MessageInfo<Long> createTeamMemberJob(TeamMemberJobInfo teamMemberJobInfo){
		MessageInfo<Long> messageInfo = new MessageInfo<Long>();
		try {
			teamMemberJobInfo.setAddTime(DateUtil.getNow());
			teamMemberJobDAO.insert( teamMemberJobInfo );
			messageInfo.setData(teamMemberJobInfo.getId());
		} catch (Exception e) {
			LOGGER.error("createTeamMemberJob","创建TeamMemberJob失败", e);
			messageInfo.setStatus(10001);
			messageInfo.setMessage("失败");
		}
		return messageInfo;
	}

	public MessageInfo<Long> updateTeamMemberJob(TeamMemberJobInfo teamMemberJob){
		MessageInfo<Long> messageInfo = new MessageInfo<Long>();
		try {
			teamMemberJob.setUpdateTime(DateUtil.getNow());
			teamMemberJobDAO.update( teamMemberJob );
			messageInfo.setData(teamMemberJob.getId());
		} catch (Exception e) {
			LOGGER.error("updateTeamMemberJob","修改TeamMemberJob失败", e);
			messageInfo.setStatus(10001);
			messageInfo.setMessage("失败");
		}
		return messageInfo;
	}

	public MessageInfo deleteMemberJob(TeamMemberJobQueryInfo teamMemberJob) {
		MessageInfo messageInfo = new MessageInfo();
		try {
			Integer ret  = teamMemberJobDAO.delete(teamMemberJob);
			messageInfo.setData(ret);
		} catch (Exception e) {
			LOGGER.error("deleteMemberJob","删除TeamMember job失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

	public MessageInfo<List<TeamMemberJobInfo>> queryByMemberId (Long memberId){
		MessageInfo<List<TeamMemberJobInfo>> messageInfo = new MessageInfo<List<TeamMemberJobInfo>>();
		try {
			List<TeamMemberJobInfo> teamMemberJobInfoList = teamMemberJobDAO.queryByMemberId( memberId );
			messageInfo.setData(teamMemberJobInfoList);
		} catch (Exception e) {
			LOGGER.error("queryByMemberId","根据memberId查询列表失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

}