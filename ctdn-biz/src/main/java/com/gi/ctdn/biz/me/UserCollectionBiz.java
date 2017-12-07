package com.gi.ctdn.biz.me;

import com.gi.ctdn.biz.OrgInfoBiz;
import com.gi.ctdn.biz.ProjectListBiz;
import com.gi.ctdn.dao.me.UserCollectionDAO;
import com.gi.ctdn.pojo.OrgInfo;
import com.gi.ctdn.pojo.ProjectList;
import com.gi.ctdn.pojo.me.UserCollection;
import com.gi.ctdn.view.common.MessageInfo;
import com.gi.ctdn.view.common.MessageStatus;
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
            List<String> codeList = userCollectionDAO.selectCodesByUT(userId,type);
            messageInfo.setData(codeList);
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
    public MessageInfo<Map<String,Integer>> countNum(Integer userId){
        MessageInfo<Map<String,Integer>> messageInfo = new MessageInfo<Map<String,Integer>>();
        try{
            Map<String,Integer> map = new HashMap<String,Integer>();
            messageInfo.setData(map);
        }catch (Exception e){
            LOGGER.info("查询总数失败",e.getMessage());
            messageInfo.setStatus(MessageStatus.ERROR_CODE);
            messageInfo.setMessage(MessageStatus.ERROR_MESSAGE);
        }
        return messageInfo;
    }
//
//    private Map<String,Integer> hh(Integer userId){
//        LinkedHashMap<String,Long> totalNumMap = new LinkedHashMap<String,Long>();
//        totalNumMap.put("project",projectNum);
//        totalNumMap.put("investfirms",investfirmsNum);
//        totalNumMap.put("investEvent",investEventNum);
//        totalNumMap.put("mergeEvent",mergeEventNum);
//        totalNumMap.put("launchEvent",launchEventNum);
//        return totalNumMap;
//    }
    public MessageInfo<UserCollection> selectAllCollection(Integer userId){
        MessageInfo<UserCollection> messageInfo = new MessageInfo<UserCollection>();
        UserCollection userCollection = new UserCollection();
        List<UserCollection> list = userCollectionDAO.selectByUserId(userId);
        List<String> pCodes = new ArrayList<String>();
        List<String> oCodes = new ArrayList<String>();
        List<String> iCodes = new ArrayList<String>();
        List<String> sCodes = new ArrayList<String>();
        List<String> rCodes = new ArrayList<String>();
        Map<String,Integer> map = new HashMap<String,Integer>();
        for(UserCollection u :list){
            switch (u.getType()){
                case 0:{
                    pCodes.add(u.getCode());
                }
                case 1:{
                    oCodes.add(u.getCode());
                }
                case 2:{
                    iCodes.add(u.getCode());
                }
                case 3:{
                    sCodes.add(u.getCode());
                }
                case 4:{
                    rCodes.add(u.getCode());
                }
            }
        }
        try{
            if(pCodes.isEmpty()){
                List<ProjectList> projectList = projectListBiz.getListByCodes(pCodes);
                userCollection.setProjectList(projectList);
            }
            if(oCodes.isEmpty()) {
                List<OrgInfo> orgInfoList = orgInfoBiz.getListByCodes(oCodes);
                userCollection.setOrgInfoList(orgInfoList);
            }
            messageInfo.setData(userCollection);
            messageInfo.setMessage(MessageStatus.OK_MESSAGE);
        }catch (Exception e){
            LOGGER.info("用户查询收藏失败",e.getMessage());
            messageInfo.setStatus(MessageStatus.ERROR_CODE);
            messageInfo.setMessage(e.getMessage());
        }
        return messageInfo;
    }

}
