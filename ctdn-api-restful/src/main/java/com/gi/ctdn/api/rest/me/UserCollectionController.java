package com.gi.ctdn.api.rest.me;

import com.gi.ctdn.biz.me.UserCollectionBiz;
import com.gi.ctdn.pojo.me.UserCollection;
import com.gi.ctdn.view.common.MessageInfo;
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

    @RequestMapping("getAllCollection/{userId}")
    @ResponseBody
    public MessageInfo<UserCollection> getAllCollection(@PathVariable("userId") Integer userId){
        MessageInfo<UserCollection> messageInfo = userCollectionBiz.selectAllCollection(userId);
        return messageInfo;
    }

    @RequestMapping("getCodeList/{userId}/{type}")
    @ResponseBody
    public MessageInfo<List<String>>  getCodeList(@PathVariable("userId")Integer userId, @PathVariable("type")Integer type){
        MessageInfo<List<String>> messageInfo = userCollectionBiz.getCodeListByUT(userId,type);
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

//    @RequestMapping("countNum/{userId}")
//    @ResponseBody
//    public MessageInfo<Map<String,Integer>>  countNum(@RequestBody UserCollection userCollection){
//        MessageInfo<List<String>> messageInfo = userCollectionBiz.countNum(userCollection);
//        return messageInfo;
//    }
}
