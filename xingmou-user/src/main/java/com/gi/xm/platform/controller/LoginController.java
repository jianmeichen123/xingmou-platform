package com.gi.xm.platform.controller;

import com.alibaba.fastjson.JSON;
import com.galaxyinternet.common.controller.BaseControllerImpl;
import com.galaxyinternet.framework.core.constants.Constants;
import com.galaxyinternet.framework.core.model.ResponseData;
import com.galaxyinternet.framework.core.model.Result;
import com.galaxyinternet.framework.core.model.Result.Status;
import com.galaxyinternet.framework.core.service.BaseService;
import com.galaxyinternet.framework.core.utils.SessionUtils;
import com.galaxyinternet.model.auth.UserResult;
import com.galaxyinternet.model.user.User;
import com.galaxyinternet.service.UserService;
import com.gi.xm.platform.utils.AuthRequest;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
@RequestMapping("/userlogin")
public class LoginController extends BaseControllerImpl<User, User> {
    final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @Autowired
    com.galaxyinternet.framework.cache.Cache cache;

    @Autowired
    AuthRequest authReq;

    @Override
    protected BaseService<User> getBaseService() {
        return this.userService;
    }

    private String ctdnIndex ="http://ctdndev.gi.com/index.html";

    private String domain ="ctdndev.gi.com";


    /**
     * 跳转登录
     */
    @RequestMapping(value = "/toLogin")
    public String toLogin(HttpServletResponse response, @CookieValue(name = "_uid_",required = false)String uid,@CookieValue(name = "s_",required = false)String s) {
        String key = "ctdn:"+s+":"+uid;
        String user = cache.getValue(key);
        if(user!=null){
            setCookie(response,uid,s,false);
            return "redirect:"+ctdnIndex;
        }
        return "login";
    }

    @RequestMapping(value = "/auth")
    public String auth(HttpServletResponse response,String uid) {
        User u = (User) cache.get(uid);
        if (u == null){
            return "login";
        }
        String key = "ctdn:fx:"+uid;
        String user = cache.getValue(key);
        if(user!=null) {
            return "redirect:" + ctdnIndex;
        }
        setCacheSessionId("fx", u, uid,false);
        setCookie(response,uid,"fx",false);
        return "redirect:"+ctdnIndex;
    }

    /**
     *
     * @param response
     * @param uid
     * @param s 来源
     */
    public void setCookie(HttpServletResponse response ,String uid,String s,boolean notAuto){
        Cookie cookie = new Cookie("_uid_", uid);
        cookie.setMaxAge(notAutoLogin(notAuto));
        cookie.setDomain(domain);
        cookie.setPath("/");
        response.addCookie(cookie);
        cookie = new Cookie("s_", s);
        cookie.setMaxAge(notAutoLogin(notAuto));
        cookie.setDomain(domain);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
    @RequestMapping(value = "/me")
    @ResponseBody
    public String  me(HttpServletResponse response, @CookieValue(name = "_uid_")String uid,@CookieValue(name = "s_")String s) {
        String userJson = cache.getValue("ctdn:"+s+":"+uid);
        return userJson;
    }

    /**
     * 用户登录
     *
     * @author zcy
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseData<User> login(boolean notAuto,@RequestBody User user, HttpServletRequest request,HttpServletResponse response) {
        ResponseData<User> responsebody = new ResponseData<User>();
        String nickName= user.getNickName();
        String password = user.getPassword();

        if (StringUtils.isBlank(nickName) || StringUtils.isBlank(password)) {
            responsebody.setResult(new Result(Status.ERROR, Constants.IS_UP_EMPTY, "用户名或密码不能为空！"));
            return responsebody;
        }
//        user.setNickName(null);
//        user.setEmail(nickName);
//        user = userService.queryUserByUP(user);
        UserResult rtn = authReq.login(nickName, password);
        if(rtn == null || rtn.isSuccess() == false)
        {
            String msg = "";
            if(rtn.getMessage() != null)
            {
                msg = rtn.getMessage();
            }
            else
            {
                msg = "用户名或密码错误！";
            }
            responsebody.setResult(new Result(Status.ERROR, Constants.IS_UP_WRONG, msg));
            return responsebody;
        }
        user = rtn.getValue();
        String sessionId = SessionUtils.createWebSessionId(); // 生成sessionId
        setCacheSessionId("ctdn", user, sessionId,notAuto);
        String key = "ctdn-firstLogin:"+user.getId();         //判断用户是否第一次登录创投大脑
        if(cache.getValue(key) == null){
            cache.setValue(key,"true");
        }else{
            cache.setValue(key,"false");
        }
        responsebody.setResult(new Result(Status.OK, Constants.OPTION_SUCCESS, "登录成功！"));
        setCookie(response,sessionId,"ctdn",notAuto);
        logger.info(user.getEmail()+" login_success ctdn");
        return responsebody;
    }

    /**
     * @author zcy
     * @param from
     * @param user
     */
    private void setCacheSessionId(String from, User user, String sessionId,boolean notAuto) {
        User u = new User();
        u.setEmail(user.getEmail());
        u.setRoleId(user.getRoleId());
        u.setRealName(user.getRealName());
        //是否是第一次登录
        String status =  cache.getValue("ctdn-firstLogin:"+user.getId());
        u.setStatus(status);
        //部门信息,用于关联行业
        u.setDepartmentId(user.getDepartmentId());
        u.setDepartmentName(user.getDepartmentName());
        String json = null;
        try {
            json = URLEncoder.encode(JSON.toJSONString(u),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("json utf8-8编码失败");
        }
        if (json!=null){
            cache.setValue("ctdn:"+from+":"+sessionId, json,notAutoLogin(notAuto)); // 将sessionId存入cache
            logger.info(sessionId+" "+json);
        }
    }

    /**
     * 用户注销
     *
     * @author zcy
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String logout(HttpServletRequest request,HttpServletResponse response,@CookieValue(name = "_uid_",required = false)String uid,@CookieValue(name = "s_",required = false)String s) {
        ResponseData<User> responsebody = new ResponseData<User>();
        cache.remove("ctdn:"+s+":"+uid);
        Cookie cookie = new Cookie("_uid_", null);
        cookie.setMaxAge(1);
        cookie.setDomain(domain);
        cookie.setPath("/");
        response.addCookie(cookie);
        cookie = new Cookie("s_", null);
        cookie.setMaxAge(1);
        cookie.setDomain(domain);
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

    private int notAutoLogin(boolean isAuto){
        return !isAuto?60*60*24*30:60*60*2;
    }


}
