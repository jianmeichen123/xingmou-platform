package com.gi.ctdn.dao;



import com.gi.ctdn.pojo.TeamMemberJobInfo;
import com.gi.ctdn.query.TeamMemberJobQueryInfo;

import java.util.List;

public interface TeamMemberJobDAO {
	
    Long insert(TeamMemberJobInfo teamMemberJob);

    Long update(TeamMemberJobInfo teamMemberJob);

    Integer delete(TeamMemberJobQueryInfo teamMemberJobQueryInfo);

    List<TeamMemberJobInfo> queryByMemberId(Long memberId);

    TeamMemberJobInfo queryById(Long id);
}