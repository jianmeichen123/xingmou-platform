package com.gi.ctdn.biz;

import com.gi.ctdn.dao.CompSubDao;
import com.gi.ctdn.pojo.CompSub;
import com.gi.ctdn.view.common.MessageInfo;
import com.gi.ctdn.view.common.MessageStatus;
import com.gi.ctdn.view.common.Pagination;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wanghao on 17-11-15.
 */
@Service("CompSubBiz")
public class CompSubBiz {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompSubBiz.class);

    @Autowired
    CompSubDao compSubDao;

    public MessageInfo<List<CompSub>> getCompSubList(String compCode){

        MessageInfo<List<CompSub>> messageInfo = new MessageInfo<List<CompSub>>();
        try {
            List<CompSub> compSubList = compSubDao.selectCompSubs(compCode);
            messageInfo.setData( compSubList);
        } catch (Exception e) {
            LOGGER.error("getCompSubList","查询全部CompSub失败", e);
            messageInfo.setStatus(10001);
        }
        return messageInfo;
    }


    public MessageInfo<CompSub> querycompSubList(CompSub compSub){
        MessageInfo<CompSub> messageInfo;
        try {
            PageHelper.startPage(compSub.getPageNo(), compSub.getPageSize());
            List<CompSub> compSubList = compSubDao.selectCompSubs(compSub.getCompCode());
            PageInfo<CompSub> pageInfo = new PageInfo<CompSub>(compSubList);
            Pagination page = new Pagination();
            page.setTotal(pageInfo.getTotal());
            page.setRecords(compSubList);
            messageInfo = new MessageInfo(MessageStatus.OK_CODE,MessageStatus.OK_MESSAGE,page);
        } catch (Exception e) {
            LOGGER.error("querycompSubList","查询CompSub失败", e);
            messageInfo = new MessageInfo(MessageStatus.ERROR_CODE,e.getMessage());
        }
        return messageInfo;
    }
}
