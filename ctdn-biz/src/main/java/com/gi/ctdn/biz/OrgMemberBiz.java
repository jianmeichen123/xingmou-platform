

package com.gi.ctdn.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.dao.OrgMemberDAO;
import com.gi.ctdn.view.common.MessageInfo;

import com.gi.ctdn.pojo.OrgMember;

@Service("orgMemberBiz")
public class OrgMemberBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(OrgMemberBiz.class);

    @Autowired
	OrgMemberDAO orgMemberDAO;


	


    public MessageInfo<List<OrgMember>> getAllOrgMember(){

		MessageInfo<List<OrgMember>> messageInfo = new MessageInfo<List<OrgMember>>();
		try {
			List<OrgMember> orgMemberList = orgMemberDAO.selectAll();
			messageInfo.setData( orgMemberList);
		} catch (Exception e) {
			LOGGER.error("getAllOrgMember","查询全部OrgMember失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
}