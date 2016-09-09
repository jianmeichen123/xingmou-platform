package com.gi.xm.platform.controller.common;

import com.gi.xm.platform.conf.rest.ServerStatusProperties;
import com.gi.xm.platform.view.common.MessageInfo;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by vincent on 16-9-9.
 */
@Controller
@RequestMapping(value = "error")
@EnableConfigurationProperties({ServerStatusProperties.class})
public class ErrorController {

    private ErrorAttributes errorAttributes;

    @Autowired
    private ServerProperties serverProperties;

    static  private MessageInfo<String> messageInfoerror = new MessageInfo<>(10001, "系统繁忙,请稍后重试");

    static  private MessageInfo<String> messageInfo404 = new MessageInfo<>(10002, "该api不存在");
    /**
     * 初始化ExceptionController
     * @param errorAttributes
     */
    @Autowired
    public ErrorController(ErrorAttributes errorAttributes) {
        Assert.notNull(errorAttributes, "ErrorAttributes must not be null");
        this.errorAttributes = errorAttributes;
    }



    /**
     * 定义404的JSON数据
     * @param request
     * @return
     */
    @RequestMapping(value = "404")
    @ResponseBody
    public MessageInfo<String> error404() {
        return messageInfo404;
    }


    /**
     * 定义500的错误JSON信息
     * @param request
     * @return
     */
    @RequestMapping(value = "500")
    @ResponseBody
    public MessageInfo<String> error500() {
        return messageInfoerror;
    }



}
