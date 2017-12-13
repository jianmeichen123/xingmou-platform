package com.gi.ctdn.biz.me;

import com.gi.ctdn.biz.OrgInfoBiz;
import com.gi.ctdn.biz.ProjectListBiz;
import com.gi.ctdn.dao.me.UserCollectionDAO;
import com.gi.ctdn.pojo.OrgInfo;
import com.gi.ctdn.pojo.ProjectList;
import com.gi.ctdn.pojo.ProjectMediaInfo;
import com.gi.ctdn.pojo.me.UserCollection;
import com.gi.ctdn.view.common.MessageInfo;
import com.gi.ctdn.view.common.MessageStatus;
import com.gi.ctdn.view.common.Pagination;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.models.auth.In;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by zcy on 17-12-5.
 */
@Service("userCollectionBiz")
public class UserCollectionBiz {

    @Autowired
    private  UserCollectionDAO userCollectionDAO;

    @Autowired
    private ProjectListBiz projectListBiz;

    @Autowired
    private OrgInfoBiz orgInfoBiz;


    private static final Logger LOGGER = LoggerFactory.getLogger(UserCollectionBiz.class);

    @Transactional
    public MessageInfo insertCollection(UserCollection userCollection){
        MessageInfo messageInfo = new MessageInfo();
        try{
            int insertRet = userCollectionDAO.insertOne(userCollection);
            messageInfo.setData(insertRet);
        }catch (Exception e){
            LOGGER.info("收藏失败",e.getMessage());
            messageInfo.setStatus(MessageStatus.ERROR_CODE);
            messageInfo.setMessage(e.getMessage());
        }
        return messageInfo;
    }

    @Transactional
    public MessageInfo deleteOneCollection(UserCollection userCollection){
        MessageInfo messageInfo = new MessageInfo();
        try{
            int deleteRet =  userCollectionDAO.deleteOne(userCollection);
            messageInfo.setData(deleteRet);
        }catch (Exception e){
            LOGGER.info("取消删除失败",e.getMessage());
            messageInfo.setStatus(MessageStatus.ERROR_CODE);
            messageInfo.setMessage(e.getMessage());
        }
        return messageInfo;
    }



    public MessageInfo<List<String>> getCodeListByUT(Integer userId,Integer type){
        MessageInfo<List<String>> messageInfo = new MessageInfo<List<String>>();
        try{
            List<String> codeList = countCodeList(userId,type);
            messageInfo.setData(codeList);
        }catch (Exception e){
            LOGGER.info("用户查询收藏失败",e.getMessage());
            messageInfo.setStatus(MessageStatus.ERROR_CODE);
            messageInfo.setMessage(MessageStatus.ERROR_MESSAGE);
        }
        return messageInfo;
    }

    private List<String> countCodeList(Integer userId,Integer type){
        List<String> codeList = userCollectionDAO.selectCodesByUT(userId,type);
        return codeList;
    }

    public MessageInfo<UserCollection> getColListByUT(UserCollection userCollection){
        MessageInfo<UserCollection> messageInfo = new MessageInfo<UserCollection>();
        //查询code集合
        List<String> codeList  = countCodeList(userCollection.getUserId(),userCollection.getType());
        //查询分页数据
        List resultList = new ArrayList();
        PageHelper.startPage(userCollection.getPageNo()+1, userCollection.getPageSize());
        try{
            switch (userCollection.getType()){
                case 0:{
                    //查询项目
                    resultList = projectListBiz.getListByCodes(codeList);
                    break;
                }
                case 1:{
                    //查询机构
                    resultList = orgInfoBiz.getListByCodes(codeList);
                    break;
                }
                case 2:{
                    //查询投资人
                    //break;
                }
                case 3:{
                    //查询创业者
                    //break;
                }
                case 4:{
                    //查询报告
                    //break;
                }
            }
            PageInfo<ProjectMediaInfo> pageInfo = new PageInfo<ProjectMediaInfo>(resultList);
            Pagination page = new Pagination();
            page.setTotal(pageInfo.getTotal());
            page.setRecords(resultList);
            messageInfo = new MessageInfo(MessageStatus.OK_CODE,MessageStatus.OK_MESSAGE,  page);
        }catch (Exception e){
            LOGGER.info("用户查询收藏失败",e.getMessage());
            messageInfo.setStatus(MessageStatus.ERROR_CODE);
            messageInfo.setMessage(MessageStatus.ERROR_MESSAGE);
        }
        return messageInfo;
    }


    /**
     * 用户各个栏目收藏总数
     * @param userId
     * @return
     */
    public MessageInfo<Map<Integer,Integer>> countNum(Integer userId){
        MessageInfo<Map<Integer,Integer>> messageInfo = new MessageInfo<Map<Integer,Integer>>();
        Map<Integer,Integer> map = new LinkedHashMap<Integer,Integer>();
        try{
            List<UserCollection> userCollectionList = userCollectionDAO.selectCountByUserId(userId);
            for(UserCollection userCollection:userCollectionList){
                map.put(userCollection.getType(),userCollection.getTypeNum());
            }
            messageInfo.setData(map);
        }catch (Exception e){
            LOGGER.info("查询 用户各个栏目收藏总数失败",e.getMessage());
            messageInfo.setStatus(MessageStatus.ERROR_CODE);
            messageInfo.setMessage(MessageStatus.ERROR_MESSAGE);
        }
        return messageInfo;
    }
}
