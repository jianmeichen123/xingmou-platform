package com.gi.ctdn.api.rest.me;

import com.gi.ctdn.biz.me.UserCollectionBiz;
import com.gi.ctdn.pojo.me.UserCollection;
import com.gi.ctdn.view.common.MessageInfo;
import com.gi.ctdn.view.common.MessageStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
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
     * @param userCode
     * @param type
     * @return
     */
    @RequestMapping(value = "getCodeList/{userCode}/{type}")
    @ResponseBody
    public MessageInfo<List<String>>  getCodeList(@PathVariable("userCode")String userCode, @PathVariable("type")Integer type){
        MessageInfo<List<String>> messageInfo = userCollectionBiz.getCodeListByUT(userCode,type);
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
        if(StringUtils.isEmpty(userCollection.getUserCode())){
            return new MessageInfo<>(MessageStatus.NO_LOGIN,MessageStatus.NO_LOGIN_MESSAGE);
        }
        if(StringUtils.isEmpty(userCollection.getCode()) || StringUtils.isEmpty(userCollection.getType())){
            return new MessageInfo<>(MessageStatus.MISS_PARAMETER_CODE,MessageStatus.MISS_PARAMETER_MESSAGE);
        }
        userCollection.setCreateTime(System.currentTimeMillis());
        MessageInfo<List<String>> messageInfo = userCollectionBiz.insertCollection(userCollection);
        return messageInfo;
    }

    @RequestMapping("cancelOneCol")
    @ResponseBody
    public MessageInfo<List<String>>  cancelOneCol(@RequestBody UserCollection userCollection){
        if(StringUtils.isEmpty(userCollection.getUserCode())){
            return new MessageInfo<>(MessageStatus.NO_LOGIN,MessageStatus.NO_LOGIN_MESSAGE);
        }
        if(StringUtils.isEmpty(userCollection.getCode()) || StringUtils.isEmpty(userCollection.getType())){
            return new MessageInfo<>(MessageStatus.MISS_PARAMETER_CODE,MessageStatus.MISS_PARAMETER_MESSAGE);
        }
        MessageInfo<List<String>> messageInfo = userCollectionBiz.deleteOneCollection(userCollection);
        return messageInfo;
    }

    @RequestMapping("countNum/{userCode}")
    @ResponseBody
    public MessageInfo<Map<Integer,Integer>>  countNum(@PathVariable("userCode") String userCode){
        MessageInfo<Map<Integer,Integer>> messageInfo = userCollectionBiz.countNum(userCode);
        return messageInfo;
    }
}
