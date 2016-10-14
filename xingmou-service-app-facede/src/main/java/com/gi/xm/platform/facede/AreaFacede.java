package com.gi.xm.platform.facede;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.AreaInfo;
import com.gi.xm.platform.view.AreaQueryInfo;

public interface AreaFacede {

    MessageInfo<List<AreaInfo>> getAllArea();

}