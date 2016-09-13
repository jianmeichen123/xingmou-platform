package com.gi.xm.platform.biz;

import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.MessageStatus;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.dao.IndustryDAO;
import com.gi.xm.platform.pojo.Industry;
import com.gi.xm.platform.query.IndustryQuery;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("industryBiz")
public class IndustryBiz {


    private static final Logger LOGGER = LoggerFactory.getLogger(IndustryBiz.class);

    @Autowired
    IndustryDAO industryDAO;


    public Message<Integer> deleteIndustry(Integer id) {
        Message<Integer> message = new Message<Integer>();
        try {

            int result = industryDAO.deleteByPrimaryKey(id);
            message.setData(result);

        } catch (Exception e) {
            LOGGER.error("delete", "删除失败", e);
            message.setMessageStatus(MessageStatus.SYS_ERROR);
        }
        return message;
    }


    public Message<Integer> createIndustry(Industry industry) {
        Message<Integer> message = new Message<Integer>();
        try {
            industryDAO.insert(industry);
            message.setData(industry.getId());

        } catch (Exception e) {
            LOGGER.error("createIndustry", "创建Industry失败", e);
            message.setMessageStatus(MessageStatus.SYS_ERROR);
        }
        return message;
    }

    public Message<Integer> updateIndustry(Industry industry) {
        Message<Integer> message = new Message<Integer>();
        try {

            Industry industryLast = industryDAO.selectByPrimaryKeyForUpdate(industry.getId());
            if (industryLast == null) {
                message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
                return message;
            }

            int result = industryDAO.updateByPrimaryKey(industry);
            message.setData(result);

        } catch (Exception e) {
            LOGGER.error("updateIndustry", "更新Industry失败", e);
            message.setMessageStatus(MessageStatus.SYS_ERROR);
        }
        return message;
    }

    public Message<Industry> getIndustry(Integer id) {
        Message<Industry> message = new Message<Industry>();
        try {
            Industry industry = industryDAO.selectByPrimaryKey(id);
            message.setData(industry);

        } catch (Exception e) {
            LOGGER.error("getIndustry", "根据主键查询Industry失败", e);
            message.setMessageStatus(MessageStatus.SYS_ERROR);
        }
        return message;
    }

    public Message<List<Industry>> getAllIndustry() {

        Message<List<Industry>> message = new Message<List<Industry>>();
        try {
            List<Industry> industryList = industryDAO.selectAll();
            message.setData(industryList);
        } catch (Exception e) {
            LOGGER.error("getAllIndustry", "查询全部Industry失败", e);
            message.setMessageStatus(MessageStatus.SYS_ERROR);
        }
        return message;
    }

    public Message<QueryResult<Industry>> queryIndustry(IndustryQuery industryQuery) {
        Message<QueryResult<Industry>> message = new Message<QueryResult<Industry>>();
        try {
            QueryResult<Industry> queryResult = new QueryResult<Industry>();
            PageHelper.startPage(industryQuery.getPageIndex(), industryQuery.getPageSize());
            List<Industry> industryList = industryDAO.queryIndustry(industryQuery);
            PageInfo<Industry> pageInfo = new PageInfo<Industry>(industryList);
            queryResult.setPages(pageInfo.getPages());
            queryResult.setTotal(pageInfo.getTotal());
            queryResult.setRecords(industryList);
            message.setData(queryResult);
        } catch (Exception e) {
            LOGGER.error("queryIndustry", "分页查询Industry失败", e);
            message.setMessageStatus(MessageStatus.SYS_ERROR);
        }
        return message;
    }


    public Message<List<Industry>> getListByParentId(Integer parentId) {

        Message<List<Industry>> message = new Message<List<Industry>>();
        try {
            List<Industry> industryList = industryDAO.selectByParentId(parentId);
            message.setData(industryList);
        } catch (Exception e) {
            LOGGER.error("getListByParentId", "查询Industry失败", e);
            message.setMessageStatus(MessageStatus.SYS_ERROR);
        }
        return message;
    }
}