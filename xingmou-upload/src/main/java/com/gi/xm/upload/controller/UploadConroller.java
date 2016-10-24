package com.gi.xm.upload.controller;

import com.gi.xm.platform.view.common.MessageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by vincent on 16-10-21.
 */

@Controller
public class UploadConroller {


    @RequestMapping("face")
    public MessageInfo face(){
        MessageInfo messageInfo = new MessageInfo();
        return messageInfo;
    }

    @RequestMapping("single")
    public MessageInfo single(){
        MessageInfo messageInfo = new MessageInfo();
        return messageInfo;
    }

    @RequestMapping("batch")
    public MessageInfo batch(){
        MessageInfo messageInfo = new MessageInfo();
        return messageInfo;
    }

}
