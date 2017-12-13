package com.gi.ctdn.api.rest.me;

import com.gi.ctdn.biz.me.UserCollectionBiz;
import com.gi.ctdn.pojo.me.UserCollection;
import com.gi.ctdn.view.common.MessageInfo;
import com.gi.ctdn.view.common.MessageStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by zcy on 17-12-5.
 */
@Controller
@RequestMapping("userCollection")
public class UserCollectionController {

    @Autowired
    private UserCollectionBiz userCollectionBiz;

    private static final Logger logger = LoggerFactory.getLogger(UserCollectionController.class);

    private static MessageInfo errorRet = new MessageInfo(MessageStatus.MISS_PARAMETER_CODE,MessageStatus.MISS_PARAMETER_MESSAGE);

    /**
     * 查询用户每种收藏codeList
     * @param userId
     * @param type
     * @return
     */
    @RequestMapping(value = "getCodeList/{userId}/{type}")
    @ResponseBody
    public MessageInfo<List<String>>  getCodeList(@PathVariable("userId")Integer userId, @PathVariable("type")Integer type){
        MessageInfo<List<String>> messageInfo = userCollectionBiz.getCodeListByUT(userId,type);
        return messageInfo;
    }

    /**
     * 查询用户每种收藏List
     * @return
     */
    @RequestMapping("getColList")
    @ResponseBody
    public MessageInfo<UserCollection>  getColList(@RequestBody UserCollection userCollection){
        if(userCollection.getPageNo()==null||userCollection.getPageSize()==null){
            return errorRet;
        }
        MessageInfo<UserCollection> messageInfo = userCollectionBiz.getColListByUT(userCollection);
        return messageInfo;
    }


    @RequestMapping("collectOne")
    @ResponseBody
    public MessageInfo<List<String>>  collectOne(@RequestBody UserCollection userCollection){
        MessageInfo<List<String>> messageInfo = userCollectionBiz.insertCollection(userCollection);
        return messageInfo;
    }

    @RequestMapping("cancelOneCol")
    @ResponseBody
    public MessageInfo<List<String>>  cancelOneCol(@RequestBody UserCollection userCollection){
        MessageInfo<List<String>> messageInfo = userCollectionBiz.deleteOneCollection(userCollection);
        return messageInfo;
    }

    @RequestMapping("countNum/{userId}")
    @ResponseBody
    public MessageInfo<Map<Integer,Integer>>  countNum(@PathVariable("userId")Integer userId){
        MessageInfo<Map<Integer,Integer>> messageInfo = userCollectionBiz.countNum(userId);
        return messageInfo;
    }
}
