package com.gi.ctdn.biz;

import com.gi.ctdn.dao.CompMemberDao;
import com.gi.ctdn.pojo.CompMember;
import com.gi.ctdn.view.common.MessageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wanghao on 17-11-15.
 */
@Service("compMemberBiz")
public class CompMemberBiz {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompMemberBiz.class);

    @Autowired
    CompMemberDao compMemberDao;

    public MessageInfo<List<CompMember>> getCompMemberList(String compCode){

        MessageInfo<List<CompMember>> messageInfo = new MessageInfo<List<CompMember>>();
        try {
            List<CompMember> compMemberList = compMemberDao.selectCompMembers(compCode);
            messageInfo.setData( compMemberList);
        } catch (Exception e) {
            LOGGER.error("getCompMemberList","查询全部CompMember失败", e);
            messageInfo.setStatus(10001);
        }
        return messageInfo;
    }
}
