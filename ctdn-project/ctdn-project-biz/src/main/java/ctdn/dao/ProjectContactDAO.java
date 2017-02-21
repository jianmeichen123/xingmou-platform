package ctdn.dao;

import com.gi.ctdn.pojo.ProjectContactInfo;
import com.gi.ctdn.query.ProjectContactQueryInfo;

import java.util.List;

public interface ProjectContactDAO {
	
    int insert(ProjectContactInfo projectContact);


	
    List<ProjectContactInfo> queryProjectContact(ProjectContactQueryInfo projectContactQuery);
}