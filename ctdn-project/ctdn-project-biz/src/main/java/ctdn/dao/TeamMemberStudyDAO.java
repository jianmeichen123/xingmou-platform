package ctdn.dao;

import com.gi.ctdn.pojo.TeamMemberStudyInfo;
import com.gi.ctdn.query.TeamMemberStudyQueryInfo;

import java.util.List;


public interface TeamMemberStudyDAO {
	
    int insert(TeamMemberStudyInfo teamMemberStudy);


	
    List<TeamMemberStudyInfo> queryTeamMemberStudy(TeamMemberStudyQueryInfo teamMemberStudyQuery);
}