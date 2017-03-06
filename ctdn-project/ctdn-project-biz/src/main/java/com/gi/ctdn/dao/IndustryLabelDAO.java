
package com.gi.ctdn.dao;


import com.gi.ctdn.pojo.IndustryLabel;

import java.util.List;

public interface IndustryLabelDAO {
	

    List<IndustryLabel> queryLabel(IndustryLabel labelQuery);
}
