package ctdn.dao;

import com.gi.ctdn.pojo.LabelInfo;
import com.gi.ctdn.query.LabelQueryInfo;

import java.util.List;

public interface LabelDAO {
	
    int insert(LabelInfo label);


	
    List<LabelInfo> queryLabel(LabelQueryInfo labelQuery);
}