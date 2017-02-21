

package ctdn.biz;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ctdn.dao.TeamMembersDAO;
import ctdn.pojo.TeamMembersInfo;
import ctdn.query.TeamMembersQueryInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("teamMembersBiz")
public class TeamMembersBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(TeamMembersBiz.class);

    @Autowired
	TeamMembersDAO teamMembersDAO;



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

}