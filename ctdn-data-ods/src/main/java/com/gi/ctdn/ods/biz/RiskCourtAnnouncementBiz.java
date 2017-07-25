

package com.gi.ctdn.ods.biz;

import com.gi.ctdn.ods.dao.RiskCourtAnnouncementDAO;
import com.gi.ctdn.ods.pojo.RiskCourtAnnouncement;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.MessageStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("riskCourtAnnouncementBiz")
public class RiskCourtAnnouncementBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(RiskCourtAnnouncementBiz.class);

    @Autowired
	RiskCourtAnnouncementDAO riskCourtAnnouncementDAO;

	public MessageInfo<List<RiskCourtAnnouncement>> getBysourceCode(String code){
		MessageInfo<List<RiskCourtAnnouncement>> messageInfo = new MessageInfo<List<RiskCourtAnnouncement>>();
		try {
			List<RiskCourtAnnouncement> ls = riskCourtAnnouncementDAO.selectBySourceCode(code);
			messageInfo.setData( ls);
		} catch (Exception e) {
			LOGGER.error("getByCode","查询RiskCourtAnnouncement失败", e);
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
		}
		return messageInfo;
	}
}