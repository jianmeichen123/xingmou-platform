package com.gi.xm.platform.auth;

import com.galaxyinternet.model.user.User;
import com.galaxyinternet.service.UserService;

/**
 * Created by vincent on 16-9-6.
 */
public class AuthAction {

    UserService userService;


    public MessageInfo<String> auth(String name,String password){
        User user = userService.queryUserByRealName(name);
        MessageInfo<String> messageInfo = new MessageInfo<>();
        return  messageInfo;
    }
}
