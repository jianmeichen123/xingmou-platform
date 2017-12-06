package com.gi.ctdn.api.rest.me;

import com.gi.ctdn.biz.me.UserCollectionBiz;
import com.gi.ctdn.pojo.me.UserCollection;
import com.gi.ctdn.view.common.MessageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
    public MessageInfo<UserCollection> getAllCollection(@PathVariable("userId") Integer userId){
        MessageInfo<UserCollection> messageInfo = userCollectionBiz.selectAllCollection(userId);
        return messageInfo;
    }

    @RequestMapping("getCodeList/{userId}/{type}")
    public MessageInfo<List<String>>  getCodeList(@PathVariable("userId")Integer userId, @PathVariable("type")Integer type){
        MessageInfo<List<String>> messageInfo = userCollectionBiz.getCodeListByUT(userId,type);
        return messageInfo;
    }
}
