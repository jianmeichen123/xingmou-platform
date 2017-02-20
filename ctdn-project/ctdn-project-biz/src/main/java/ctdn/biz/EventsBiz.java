

package ctdn.biz;

import com.gi.ctdn.dao.EventsDAO;
import com.gi.ctdn.pojo.EventsInfo;
import com.gi.ctdn.query.EventsQueryInfo;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("eventsBiz")
public class EventsBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(EventsBiz.class);

    @Autowired
	EventsDAO eventsDAO;



    public MessageInfo<Long> createEvents(EventsInfo events){
		MessageInfo<Long> messageInfo = new MessageInfo<Long>();
		try {
			eventsDAO.insert( events );
			messageInfo.setData(events.getId());

		} catch (Exception e) {
			LOGGER.error("createEvents","创建Events失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

		
	public MessageInfo<List<EventsInfo>> getListByProjectId(Long projectId){

		MessageInfo<List<EventsInfo>> messageInfo = new MessageInfo<List<EventsInfo>>();
		try {
			List<EventsInfo> eventsList = eventsDAO.selectByProjectId(projectId);
			messageInfo.setData(eventsList);
		} catch (Exception e) {
			LOGGER.error("getListByProjectId","查询Events失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
		


	public MessageInfo<QueryResultInfo<EventsInfo>> queryEvents(EventsQueryInfo eventsQuery) {
		MessageInfo<QueryResultInfo<EventsInfo>> messageInfo = new MessageInfo<QueryResultInfo<EventsInfo>>();
		try {
			QueryResultInfo<EventsInfo> queryResult = new QueryResultInfo<EventsInfo>();
			PageHelper.startPage(eventsQuery.getPageIndex(), eventsQuery.getPageSize());
			List<EventsInfo> eventsList = eventsDAO.queryEvents(eventsQuery);
			PageInfo<EventsInfo> pageInfo = new PageInfo<EventsInfo>(eventsList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(eventsList);
			messageInfo.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryEvents", "分页查询Events失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

}