package com.gi.ctdn.dao;



import com.gi.ctdn.pojo.TeamMemberStudyInfo;
import com.gi.ctdn.query.TeamMemberStudyQueryInfo;

import java.util.List;


public interface TeamMemberStudyDAO {
	
    Long insert(TeamMemberStudyInfo teamMemberStudy);

    Long update(TeamMemberStudyInfo teamMemberStudy);

    List<TeamMemberStudyInfo> queryTeamMemberStudy(TeamMemberStudyQueryInfo teamMemberStudyQuery);

    List<TeamMemberStudyInfo> queryByMemberId(Long memberId);

    Integer delete(TeamMemberStudyQueryInfo teamMemberStudyQueryInfo);
}