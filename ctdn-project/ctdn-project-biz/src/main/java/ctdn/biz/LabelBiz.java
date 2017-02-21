

package ctdn.biz;

import com.gi.ctdn.dao.LabelDAO;
import com.gi.ctdn.pojo.LabelInfo;
import com.gi.ctdn.query.LabelQueryInfo;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("labelBiz")
public class LabelBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(LabelBiz.class);

    @Autowired
	LabelDAO labelDAO;



    public MessageInfo<Long> createLabel(LabelInfo label){
		MessageInfo<Long> messageInfo = new MessageInfo<Long>();
		try {
									labelDAO.insert( label );
			messageInfo.setData(label.getId());

		} catch (Exception e) {
			LOGGER.error("createLabel","创建Label失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

	


	public MessageInfo<QueryResultInfo<LabelInfo>> queryLabel(LabelQueryInfo labelQuery) {
		MessageInfo<QueryResultInfo<LabelInfo>> messageInfo = new MessageInfo<QueryResultInfo<LabelInfo>>();
		try {
			QueryResultInfo<LabelInfo> queryResult = new QueryResultInfo<LabelInfo>();
			PageHelper.startPage(labelQuery.getPageIndex(), labelQuery.getPageSize());
			List<LabelInfo> labelList = labelDAO.queryLabel(labelQuery);
			PageInfo<LabelInfo> pageInfo = new PageInfo<LabelInfo>(labelList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(labelList);
			messageInfo.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryLabel", "分页查询Label失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

}