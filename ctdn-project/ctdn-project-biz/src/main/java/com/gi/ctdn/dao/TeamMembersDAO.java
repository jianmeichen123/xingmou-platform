package com.gi.ctdn.dao;


import com.gi.ctdn.pojo.TeamMembersInfo;
import com.gi.ctdn.query.TeamMembersQueryInfo;

import java.util.List;

public interface TeamMembersDAO {
	
    Long insert(TeamMembersInfo teamMembers);

    Long update(TeamMembersInfo teamMembers);

    Integer delete(Long id);

    TeamMembersInfo queryById(Long id);

    List<TeamMembersInfo> queryByProjectId (Long projectId);

}