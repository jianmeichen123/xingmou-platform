


package com.gi.ctdn.biz;
import com.gi.ctdn.dao.IndustryLabelDAO;
import com.gi.ctdn.pojo.IndustryLabel;
import com.gi.xm.platform.view.common.MessageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("labelBiz")
public class IndustryLabelBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(IndustryLabelBiz.class);

    @Autowired
	IndustryLabelDAO labelDAO;

	public MessageInfo<List<IndustryLabel>> queryLabel(IndustryLabel labelQuery) {
		MessageInfo<List<IndustryLabel>> messageInfo = new MessageInfo<List<IndustryLabel>>();
		try {
			List<IndustryLabel> labelList = labelDAO.queryLabel(labelQuery);
			messageInfo.setData(labelList);
		} catch (Exception e) {
			LOGGER.error("queryLabel", "查询Label失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

}
