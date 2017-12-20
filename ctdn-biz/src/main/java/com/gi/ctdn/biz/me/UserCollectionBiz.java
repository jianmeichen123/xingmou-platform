package com.gi.ctdn.biz.me;

import com.gi.ctdn.biz.OrgInfoBiz;
import com.gi.ctdn.biz.PersonBiz;
import com.gi.ctdn.biz.ProjectListBiz;
import com.gi.ctdn.biz.ReportBiz;
import com.gi.ctdn.dao.me.UserCollectionDAO;
import com.gi.ctdn.pojo.me.UserCollection;
import com.gi.ctdn.view.common.ListUtil;
import com.gi.ctdn.view.common.MessageInfo;
import com.gi.ctdn.view.common.MessageStatus;
import com.gi.ctdn.view.common.Pagination;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private PersonBiz personBiz;

    @Autowired
    ReportBiz reportBiz;



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



    public MessageInfo<List<String>> getCodeListByUT(String userCode,Integer type){
        MessageInfo<List<String>> messageInfo = new MessageInfo<List<String>>();
        try{
            List<String> codeList = countCodeList(userCode,type);
            messageInfo.setData(codeList);
        }catch (Exception e){
            LOGGER.info("用户查询收藏codeList失败",e.getMessage());
            messageInfo.setStatus(MessageStatus.ERROR_CODE);
            messageInfo.setMessage(MessageStatus.ERROR_MESSAGE);
        }
        return messageInfo;
    }

    private List<String> countCodeList(String userCode,Integer type){
        List<String> codeList = userCollectionDAO.selectCodesByUT(userCode,type);
        return codeList;
    }

    public MessageInfo<UserCollection> getColListByUT(UserCollection userCollection){
        MessageInfo<UserCollection> messageInfo = new MessageInfo<UserCollection>();
        //查询code集合
        List<String> codeList  = countCodeList(userCollection.getUserCode(),userCollection.getType());
        //查询分页数据
        List resultList = new ArrayList();
        PageHelper.startPage(userCollection.getPageNo()+1, userCollection.getPageSize());
        try{
            switch (userCollection.getType()){
                case 0:{
                    //查询项目
                    if(ListUtil.isNotEmpty(codeList)) {
                        resultList = projectListBiz.getListByCodes(codeList);
                    }
                    break;
                }
                case 1:{
                    //查询机构
                    if(ListUtil.isNotEmpty(codeList)) {
                        resultList = orgInfoBiz.getListByCodes(codeList);
                    }
                    break;
                }
                case 2:{
                    //查询创业者
                    if(ListUtil.isNotEmpty(codeList)) {
                        resultList = personBiz.getStartUpListByCodes(codeList);
                    }
                    break;
                }
                case 3:{
                    //查询投资人
                    if(ListUtil.isNotEmpty(codeList)){
                        resultList = personBiz.getInvestorListByCodes(codeList);
                    }
                    break;
                }
                case 4:{
                    //查询报告
                    if(ListUtil.isNotEmpty(codeList)) {
                        resultList = reportBiz.selectByIds(codeList);
                    }
                    break;
                }
            }
            PageInfo pageInfo = new PageInfo(resultList);
            Pagination page = new Pagination();
            page.setTotal(pageInfo.getTotal());
            page.setRecords(resultList);
            messageInfo = new MessageInfo(MessageStatus.OK_CODE,MessageStatus.OK_MESSAGE,  page);
        }catch (Exception e){
            e.printStackTrace();
            LOGGER.info("用户查询收藏列表失败",e.getMessage());
            messageInfo.setStatus(MessageStatus.ERROR_CODE);
            messageInfo.setMessage(MessageStatus.ERROR_MESSAGE);
        }
        return messageInfo;
    }

    /**
     * 用户各个栏目收藏总数
     * @param userCode
     * @return
     */
    public MessageInfo<Map<Integer,Integer>> countNum(String userCode){
        MessageInfo<Map<Integer,Integer>> messageInfo = new MessageInfo<Map<Integer,Integer>>();
        Map<Integer,Integer> map = new LinkedHashMap<Integer,Integer>();
        try{
            List<UserCollection> userCollectionList = userCollectionDAO.selectCountByUserCode(userCode);
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
