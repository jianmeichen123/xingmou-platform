package ctdn.dao;


import ctdn.pojo.TeamMembersInfo;
import ctdn.query.TeamMembersQueryInfo;

import java.util.List;

public interface TeamMembersDAO {
	
    int insert(TeamMembersInfo teamMembers);


	
    List<TeamMembersInfo> queryTeamMembers(TeamMembersQueryInfo teamMembersQuery);
}