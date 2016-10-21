package com.gi.xm.platform.facede;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.RoundInfo;
import com.gi.xm.platform.view.RoundQueryInfo;

public interface RoundFacede {

    MessageInfo<Integer> deleteRound(Integer id);
		
    MessageInfo<Integer> createRound(RoundInfo roundInfo);
		
	MessageInfo<Integer> updateRound(RoundInfo roundInfo);
		
	MessageInfo<RoundInfo> getRound(Integer id);
		
    MessageInfo<List<RoundInfo>> getAllRound();

    MessageInfo<QueryResultInfo<RoundInfo>> queryRound(RoundQueryInfo roundQueryInfo);

    /**
     * 根据类型和parentId查询轮次
     * 1.若要查询项目轮次 type =1 parentId = null
     *   并且手动移除返回list集合中 parentId = 0 的值
     * 2.若要查询投资机构关注轮次 type =2 parentId = null
     * @param type
     * @param parentId
     * @return
     */
    MessageInfo<List<RoundInfo>> selectByTypeParentId(Integer type,Integer parentId);

}