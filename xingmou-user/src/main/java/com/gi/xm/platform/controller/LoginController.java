package com.gi.xm.platform.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.galaxyinternet.common.controller.BaseControllerImpl;
import com.galaxyinternet.framework.core.constants.Constants;
import com.galaxyinternet.framework.core.model.Header;
import com.galaxyinternet.framework.core.model.ResponseData;
import com.galaxyinternet.framework.core.model.Result;
import com.galaxyinternet.framework.core.model.Result.Status;
import com.galaxyinternet.framework.core.service.BaseService;
import com.galaxyinternet.framework.core.utils.SessionUtils;
import com.galaxyinternet.model.user.User;
import com.galaxyinternet.service.UserService;

@Controller
@RequestMapping("/userlogin")
public class LoginController extends BaseControllerImpl<User, User> {
    final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @Autowired
    com.galaxyinternet.framework.cache.Cache cache;

    @Override
    protected BaseService<User> getBaseService() {
        return this.userService;
    }

    private String xmIndex = "http://xmdev.gi.com/index.html";
    /**
     * 跳转登录
     */
    @RequestMapping(value = "/toLogin")
    public String toLogin(HttpServletResponse response, @CookieValue(name = "_uid_",required = false)String uid,@CookieValue(name = "s_",required = false)String s) {
        String key = "xm:"+s+":"+uid;
        String user = cache.getValue(key);
        if(user!=null){
            setCookie(response,uid,s);
            return "redirect:"+xmIndex;
        }
        return "login";
    }

    @RequestMapping(value = "/auth")
    public String auth(HttpServletResponse response,String uid) {
        User u = (User) cache.get(uid);
        if (u == null){
            return "login";
        }
        String key = "xm:fx:"+uid;
        String user = cache.getValue(key);
        if(user!=null) {
            return "redirect:" + xmIndex;
        }
        setCacheSessionId("fx", u, uid);
        setCookie(response,uid,"fx");
        return "login";
    }

    /**
     *
     * @param response
     * @param uid
     * @param s 来源
     */
    public void setCookie(HttpServletResponse response ,String uid,String s){
        Cookie cookie = new Cookie("_uid_", uid);
        cookie.setMaxAge(60*60*24*365*5);
        cookie.setDomain("xmdev.gi.com");
        cookie.setPath("/");
        response.addCookie(cookie);
        cookie = new Cookie("s_", s);
        cookie.setMaxAge(60*60*24*365*5);
        cookie.setDomain("xmdev.gi.com");
        cookie.setPath("/");
        response.addCookie(cookie);

    }
    @RequestMapping(value = "/me")
    @ResponseBody
    public String  me(HttpServletResponse response, @CookieValue(name = "_uid_")String uid,@CookieValue(name = "s_")String s) {
        String userJson = cache.getValue("xm:"+s+":"+uid);
        return userJson;
    }

    /**
     * 用户登录
     *
     * @author zcy
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseData<User> login(@RequestBody User user, HttpServletRequest request,HttpServletResponse response) {
        ResponseData<User> responsebody = new ResponseData<User>();
        String nickName= user.getNickName();
        String password = user.getPassword();

        if (StringUtils.isBlank(nickName) || StringUtils.isBlank(password)) {
            responsebody.setResult(new Result(Status.ERROR, Constants.IS_UP_EMPTY, "用户名或密码不能为空！"));
            return responsebody;
        }
        user.setNickName(null);
        user.setEmail(nickName);
        user = userService.queryUserByUP(user);

        if (user == null) {
            responsebody.setResult(new Result(Status.ERROR, Constants.IS_UP_WRONG, "用户名或密码错误！"));
        } else {

            String sessionId = SessionUtils.createWebSessionId(); // 生成sessionId
            setCacheSessionId("xm", user, sessionId);
            responsebody.setResult(new Result(Status.OK, Constants.OPTION_SUCCESS, "登录成功！"));


            setCookie(response,sessionId,"xm");
            logger.info(user.getEmail()+" login_success xm");
        }
        return responsebody;
    }

    /**
     * @author zcy
     * @param from
     * @param user
     */
    private void setCacheSessionId(String from, User user, String sessionId) {
        User u = new User();
        u.setEmail(user.getEmail());
        u.setRoleId(user.getRoleId());
        u.setRealName(user.getRealName());
        cache.setValue("xm:"+from+":"+sessionId, JSON.toJSONString(u)); // 将sessionId存入cache
    }

    /**
     * 用户注销
     *
     * @author zcy
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String logout(HttpServletRequest request,HttpServletResponse response,@CookieValue(name = "_uid_",required = false)String uid,@CookieValue(name = "s_",required = false)String s) {
        ResponseData<User> responsebody = new ResponseData<User>();
        cache.remove("xm:"+s+":"+uid);
        Cookie cookie = new Cookie("_uid_", null);
        cookie.setMaxAge(60*60*24*2);
        cookie.setDomain("xmdev.gi.com");
        cookie.setPath("/");
        response.addCookie(cookie);
        cookie = new Cookie("s_", null);
        cookie.setMaxAge(60*60*24*2);
        cookie.setDomain("xmdev.gi.com");
        cookie.setPath("/");
        response.addCookie(cookie);
        responsebody.setResult(new Result(Status.OK, Constants.OPTION_SUCCESS, "退出登录"));
        return "login";
    }

    /**
     * 删除session 和 cache中的 sessionId
     *
     * @author zcy
     */
    private boolean removeSessionId(String sessionId, HttpServletRequest request) {
        Object cahceUser = cache.get(sessionId);
        Object sessionUser = request.getSession().getAttribute(Constants.SESSION_USER_KEY);

        if (null == cahceUser || null == sessionUser) {
            return false;
        }
        request.getSession().removeAttribute(Constants.SESSION_USER_KEY); // 从本地session删除user
        //cache.remove(sessionId); // 从redis中删除sessionId
        return true;
    }




}
