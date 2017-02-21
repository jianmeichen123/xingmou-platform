package ctdn.dao;

import com.gi.ctdn.pojo.TeamMemberJobInfo;
import com.gi.ctdn.query.TeamMemberJobQueryInfo;

import java.util.List;

public interface TeamMemberJobDAO {
	
    int insert(TeamMemberJobInfo teamMemberJob);


	
    List<TeamMemberJobInfo> queryTeamMemberJob(TeamMemberJobQueryInfo teamMemberJobQuery);
}