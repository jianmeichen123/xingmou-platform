

package com.gi.ctdn.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.dao.OrgTypeDAO;
import com.gi.ctdn.view.common.MessageInfo;

import com.gi.ctdn.pojo.OrgType;

@Service("orgTypeBiz")
public class OrgTypeBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(OrgTypeBiz.class);

    @Autowired
	OrgTypeDAO orgTypeDAO;


	


    public MessageInfo<List<OrgType>> getAllOrgType(){

		MessageInfo<List<OrgType>> messageInfo = new MessageInfo<List<OrgType>>();
		try {
			List<OrgType> orgTypeList = orgTypeDAO.selectAll();
			messageInfo.setData( orgTypeList);
		} catch (Exception e) {
			LOGGER.error("getAllOrgType","查询全部OrgType失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
}