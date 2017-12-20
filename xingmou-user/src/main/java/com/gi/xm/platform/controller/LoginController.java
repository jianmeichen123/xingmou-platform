package com.gi.xm.platform.controller;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.galaxyinternet.framework.core.constants.Constants;
import com.galaxyinternet.framework.core.model.ResponseData;
import com.galaxyinternet.framework.core.model.Result;
import com.galaxyinternet.framework.core.model.Result.Status;
import com.galaxyinternet.framework.core.utils.SessionUtils;
import com.galaxyinternet.service.UserService;
import com.gi.xm.platform.biz.UserBiz;
import com.gi.xm.platform.pojo.ExternalUser;
import com.gi.xm.platform.pojo.User;
import com.gi.xm.platform.pojo.UserResult;
import com.gi.xm.platform.utils.AuthRequest;
import com.gi.xm.platform.utils.PWDUtils;
import com.gi.xm.platform.utils.SmsUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Controller
@RequestMapping("/userlogin")
public class LoginController implements EnvironmentAware{
	
    final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @Autowired
    com.galaxyinternet.framework.cache.Cache cache;

    @Autowired
    AuthRequest authReq;
    
    @Autowired
    private UserBiz userBiz;

    private String ctdn_index ="";

    private String ctdn_domain ="";

	private static final Long  TZJL_ROLECODE = 10000l;

    private static final Long  GG_ROLECODE = 20000l;


	@Autowired
	private StringRedisTemplate stringRedisTemplate;


    /**
     * 跳转登录
     */
    @RequestMapping(value = "/toLogin")	
    public String toLogin(HttpServletResponse response, @CookieValue(name = "_uid_",required = false)String uid,@CookieValue(name = "s_",required = false)String s) {
        String key = "ctdn:"+s+":"+uid;
        //String user = (String) cache.getByRedis(key);
		String user = (String)stringRedisTemplate.opsForValue().get(key);
        if(user!=null){
//            setCookie(response,uid,s,false);
            return "redirect:"+ctdn_index;
        }
        return "login";
    }

//    @RequestMapping(value = "/auth")
//    public String auth(HttpServletResponse response,String uid) {
//        User u = (User) cache.get(uid);
//        if (u == null){
//            return "login";
//        }
//        String key = "ctdn:fx:"+uid;
//        String user = cache.getValue(key);
//        if(user!=null) {
//            return "redirect:" + ctdn_index;
//        }
//        setCacheSessionId("fx", u, uid,false);
//        setCookie(response,uid,"fx",false);
//        return "redirect:"+ctdn_index;
//    }

    /**
     *
     * @param response
     * @param uid
     * @param s 来源
     */
    public void setCookie(HttpServletResponse response ,String uid,String s,boolean notAuto){
        Cookie cookie = new Cookie("_uid_", uid);
        cookie.setMaxAge(notAutoLogin(notAuto));
        cookie.setDomain(ctdn_domain);
        cookie.setPath("/");
        response.addCookie(cookie);
        cookie = new Cookie("s_", s);
        cookie.setMaxAge(notAutoLogin(notAuto));
        cookie.setDomain(ctdn_domain);
        cookie.setPath("/");
        response.addCookie(cookie);

    }
    @RequestMapping(value = "/me")
    @ResponseBody
    public String  me(HttpServletResponse response, @CookieValue(name = "_uid_")String uid,@CookieValue(name = "s_")String s) {
		String userJson = (String) stringRedisTemplate.opsForValue().get("ctdn:"+s+":"+uid);
//        String userJson = (String) cache.getByRedis("ctdn:"+s+":"+uid);
        System.out.println(userJson);
        return userJson;
    }

    /**
     * 用户登录
     *
     * @author zcy
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseData<User> login(boolean notAuto, @RequestBody User user, HttpServletRequest request, HttpServletResponse response) {
        ResponseData<User> responsebody = new ResponseData<User>();
        String nickName= user.getNickName();
        String password = user.getPassword();
        if (StringUtils.isBlank(nickName) || StringUtils.isBlank(password)) {
            responsebody.setResult(new Result(Status.ERROR, Constants.IS_UP_EMPTY, "用户名或密码不能为空！"));
            return responsebody;
        }
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
                msg = "您的账号与密码不匹配~";
            }
            responsebody.setResult(new Result(Status.ERROR, Constants.IS_UP_WRONG, msg));
            return responsebody;
        }
        user = rtn.getValue();
		//内部用户查询roleCode 用roleId字段存值
		List<Long> roleCodes = authReq.selectRoleCodeByUserId(user.getId());
		if(roleCodes.indexOf(GG_ROLECODE)>-1){
			user.setRoleCode(GG_ROLECODE);
		}else if(roleCodes.indexOf(TZJL_ROLECODE)>-1){
			user.setRoleCode(TZJL_ROLECODE);
		}

		String key = "ctdn-firstLogin:internal:"+user.getId();         //判断用户是否第一次登录创投大脑
		if(stringRedisTemplate.opsForValue().get(key) == null){
			stringRedisTemplate.opsForValue().set(key,"true",0);
		}else{
			stringRedisTemplate.opsForValue().set(key,"false",0);
		}

		String sessionId = SessionUtils.createWebSessionId(); // 生成sessionId
        setCacheSessionId("internal", user, sessionId,notAuto);
        responsebody.setEntity(user);
        responsebody.setResult(new Result(Status.OK, Constants.OPTION_SUCCESS, "登录成功！"));
        setCookie(response,sessionId,"internal",notAuto);
        logger.info(user.getRealName()+" login_success ctdn");
        return responsebody;
    }

    /**
     * @author zcy
     * @param from
     * @param user
     */
    private void setCacheSessionId(String from, User user, String sessionId,boolean notAuto) {
		User u = new User();
        u.setRealName(user.getRealName());
        //是否是第一次登录
        String status =  stringRedisTemplate.opsForValue().get("ctdn-firstLogin:" + from + ":"+user.getId());
        System.out.println("status:"+status);
        u.setStatus(status);
        //部门信息,用于关联行业
        u.setDepartmentId(user.getDepartmentId());
        u.setRoleCode(user.getRoleCode());
        String json = null;
        try {
            json = URLEncoder.encode(JSON.toJSONString(u),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("json utf8-8编码失败");
        }
        if (json!=null){
			stringRedisTemplate.boundValueOps("ctdn:"+from+":"+sessionId+":code").set(user.getEmail());
			stringRedisTemplate.boundValueOps("ctdn:"+from+":"+sessionId).set(json);
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
		//cache.remove("ctdn:"+s+":"+uid);
		stringRedisTemplate.delete("ctdn:"+s+":"+uid);
        Cookie cookie = new Cookie("_uid_", null);
        cookie.setMaxAge(1);
        cookie.setDomain(ctdn_domain);
        cookie.setPath("/");
        response.addCookie(cookie);
        cookie = new Cookie("s_", null);
        cookie.setMaxAge(1);
        cookie.setDomain(ctdn_domain);
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
       // Object cahceUser = cache.get(sessionId);
		Object cahceUser = stringRedisTemplate.opsForValue().get(sessionId);
        Object sessionUser = request.getSession().getAttribute(Constants.SESSION_USER_KEY);

        if (null == cahceUser || null == sessionUser) {
            return false;
        }
        request.getSession().removeAttribute(Constants.SESSION_USER_KEY); // 从本地session删除user
        //cache.remove(sessionId); // 从redis中删除sessionId
		stringRedisTemplate.delete(sessionId);
        return true;
    }

    private int notAutoLogin(boolean notAuto){
        return !notAuto?60*60*24*7:60*30;
    }
    
    
    /**
     * 注册
     * @param request
     * @param user
     * @return
     */
	@RequestMapping("/register")
	@ResponseBody
	public ResponseData<ExternalUser> register(HttpServletRequest request, @RequestBody ExternalUser user)
	{

		ResponseData<ExternalUser> messageInfo = new ResponseData<ExternalUser>();
		try
		{
			if(user == null || user.getMobile()== null || user.getPassword() == null || user.getCode() == null
					|| user.getConfirmPassword() == null)
			{
				messageInfo.setResult(new Result(Status.ERROR,"0","用户信息不完整"));
				return messageInfo;
			}
			ExternalUser entity = userBiz.getUser(user.getMobile());
			if(entity != null)
			{
				messageInfo.setResult(new Result(Status.ERROR, "1","您输入的手机号已被注册~"));
				return messageInfo;
			}else{
				String key = "user:register:" + user.getMobile();
				//String code = (String) cache.get(key);
				String code = (String)stringRedisTemplate.opsForValue().get(key);
				if(!user.getCode().equals(code)){
					messageInfo.setResult(new Result(Status.ERROR,"2", "验证码错误~"));
				}else{
					user.setPassword(PWDUtils.genernateNewPasswordByBase64(user.getPassword()));
					userBiz.insert(user);
					messageInfo.setResult(new Result(Status.OK, "注册成功"));
					//cache.remove(key);
					stringRedisTemplate.delete(key);
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			messageInfo.setResult(new Result(Status.ERROR, "注册失败，请稍后再试"));
		}
		return messageInfo;
	}
	
	/*
	 * 外部用户密码登录
	 */
	@RequestMapping("/loginByPassword")
	@ResponseBody
	public ResponseData<ExternalUser> loginByPassword(boolean notAuto,@RequestBody ExternalUser user,HttpServletResponse response)
	{
		ResponseData<ExternalUser> messageInfo = new  ResponseData<ExternalUser>();
		if(user == null || StringUtils.isBlank(user.getMobile())
				|| StringUtils.isBlank(user.getPassword())){
			messageInfo.setResult(new Result(Status.ERROR, "0","信息不全"));
			return messageInfo;
		}
		ExternalUser query = userBiz.getUser(user.getMobile());
		if(query == null){
			messageInfo.setResult(new Result(Status.ERROR, "1","您输入的账号不存在~"));
			return messageInfo;
		}
		if(!query.getPassword().equals(PWDUtils.genernateNewPasswordByBase64(user.getPassword()))){
			messageInfo.setResult(new Result(Status.ERROR, "0","您的账号与密码不匹配~"));
			return messageInfo;
		}
		String key = "ctdn-firstLogin:external:"+query.getId();

		if(stringRedisTemplate.opsForValue().get(key) == null){
			stringRedisTemplate.opsForValue().set(key, "true",0);
		}else{
			stringRedisTemplate.opsForValue().set(key, "false",0);
		}
//		if(cache.getByRedis(key) == null){
//			cache.setByRedis(key, "true",0);
//		}else{
//			cache.setByRedis(key, "false",0);
//		}
		String sessionId = SessionUtils.createWebSessionId(); // 生成sessionId
		setCacheSessionId(query,"external", sessionId,notAuto);
		messageInfo.setEntity(query);
		messageInfo.setResult(new Result(Status.OK, Constants.OPTION_SUCCESS, "登录成功！"));
		setCookie(response,sessionId,"external",notAuto);
		
		return messageInfo;
	}
	
	/**
	 * 外部用户验证码登录
	 * @param isAuto
	 * @param user
	 * @param request
	 * @param response
	 * @return
	 */
	 @ResponseBody
	 @RequestMapping(value = "/loginByCode", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
     public ResponseData<ExternalUser> loginByCode(boolean isAuto,@RequestBody ExternalUser user, HttpServletRequest request,HttpServletResponse response) {
        ResponseData<ExternalUser> responsebody = new ResponseData<ExternalUser>();
        try {
			String mobile= user.getMobile();
			String code = user.getCode();
			if (StringUtils.isBlank(mobile) || StringUtils.isBlank(code)) {
			    responsebody.setResult(new Result(Status.ERROR, Constants.IS_UP_EMPTY, "手机号或验证码不能为空！"));
			    return responsebody;
			}
			String key = "user:login:"+user.getMobile();
			String codeFromRedis  = (String) stringRedisTemplate.opsForValue().get(key);
			System.out.println(codeFromRedis);
			if(!code.equals(codeFromRedis)){
				responsebody.setResult(new Result(Status.ERROR, Constants.IS_UP_WRONG, "验证码错误"));//1
				return responsebody;
			}
			ExternalUser rtn = userBiz.getUser(mobile);
			if(rtn == null)
			{
				userBiz.insert(user);
			    responsebody.setResult(new Result(Status.OK, Constants.IS_UP_WRONG, "此手机号未曾注册"));//1
			    return responsebody;
			}
			
			String firstLoginKey = "ctdn-firstLogin:external:"+rtn.getId();

			if(stringRedisTemplate.opsForValue().get(firstLoginKey) == null){
				stringRedisTemplate.opsForValue().set(firstLoginKey, "true",0);
			}else{
				stringRedisTemplate.opsForValue().set(firstLoginKey, "false",0);
			}

//			if(cache.getByRedis(firstLoginKey) == null){
//				cache.setByRedis(firstLoginKey, "true",0);
//			}else{
//				cache.setByRedis(firstLoginKey, "false",0);
//			}
			
			String sessionId = SessionUtils.createWebSessionId(); // 生成sessionId
			setCacheSessionId(rtn,"external", sessionId,isAuto);
			responsebody.setEntity(rtn);
			responsebody.setResult(new Result(Status.OK, Constants.OPTION_SUCCESS, "登录成功！"));
			setCookie(response,sessionId,"external",isAuto);
			//cache.remove(key);
			stringRedisTemplate.delete(key);
			logger.info(user.getMobile()+"external user login success ctdn");
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(user.getMobile()+"external user login failed ctdn");
		}
        return responsebody;
    }
	 
	 private void setCacheSessionId(ExternalUser user,String from,  String sessionId,boolean notAuto) {
	        String json = null;
	        //String status =  cache.getValue("ctdn-firstLogin:" + from + ":"+user.getId());
		 	String status = (String)stringRedisTemplate.opsForValue().get("ctdn-firstLogin:" + from + ":"+user.getId());
			user.setStatus(status);
	        try {
	            json = URLEncoder.encode(JSON.toJSONString(user),"UTF-8");
	        } catch (UnsupportedEncodingException e) {
	            logger.error("json utf8-8编码失败");
	        }
	        if (json!=null){
	            //cache.setByRedis("ctdn:"+from+":"+sessionId, json,notAutoLogin(notAuto)); // 将sessionId存入cache
				stringRedisTemplate.opsForValue().set("ctdn:"+from+":"+sessionId+":code", user.getMobile(),notAutoLogin(notAuto)); // 将sessionId存入cache
				stringRedisTemplate.opsForValue().set("ctdn:"+from+":"+sessionId, json,notAutoLogin(notAuto)); // 将sessionId存入cache
	            logger.info(sessionId+" "+json);
	        }
	    }
	 
	 @RequestMapping("/toRegister")
	 public String toRegister(){
		 return "register";
	 }
	 
	 @RequestMapping("/forgetPassword")
	 public String forgetPassword(){
		 return "forget_password";
	 }
	 
	/**
	 * 检测手机号是否已经注册
	 * @param user
	 * @return
	 */
	@RequestMapping("/checkUserExists")
	@ResponseBody
	public ResponseData<ExternalUser> checkUserExists(@RequestBody ExternalUser user)
	{
		ResponseData<ExternalUser> messageInfo = new  ResponseData<ExternalUser>();
		try {
			ExternalUser query = userBiz.getUser(user.getMobile());
			if(query != null){
				user.setExists(true);
			}
			messageInfo.setEntity(user);
		} catch (Exception e) {
			e.printStackTrace();
			messageInfo.setResult(new Result(Status.ERROR, "系统繁忙"));
		}
		return messageInfo;
	}
	
	/**
	 * 找回密码
	 * @param user
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updatePassword", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseData<ExternalUser> updatePassword(@RequestBody ExternalUser user, HttpServletRequest request,HttpServletResponse response) {
		ResponseData<ExternalUser> res = new ResponseData<ExternalUser>();
		try{
			if(user == null || user.getMobile()== null || user.getPassword() == null
					|| user.getConfirmPassword() == null || user.getCode() == null)
			{
				res.setResult(new Result(Status.ERROR,"0","用户信息不完整"));
				return res;
			}
			 ExternalUser rtn = userBiz.getUser(user.getMobile());
			 if(rtn == null){
				 res.setResult(new Result(Status.ERROR,"1","此手机号未曾注册"));
				 return res;
			 }
			 String key = "user:forget:"+user.getMobile();
			 //String codeFromRedis = (String) cache.getByRedis(key);
			 String codeFromRedis = (String) (String)stringRedisTemplate.opsForValue().get(key);
			 if(!user.getCode().equals(codeFromRedis)){
				 res.setResult(new Result(Status.ERROR,"2","验证码错误"));
				 return res;
			 }
			 if(!user.getPassword().equals(user.getConfirmPassword())){
				 res.setResult(new Result(Status.ERROR,"0", "密码不一致"));
				 return res;
			 }
			 rtn.setPassword(PWDUtils.genernateNewPasswordByBase64(user.getPassword()));
			 userBiz.update(rtn);
			 //cache.remove(key);
			stringRedisTemplate.delete(key);
		}catch(Exception e){
			e.printStackTrace();
			res.setResult(new Result(Status.ERROR,"0", "找回密码失败"));
		}
		
		return res;
	}
	
	/**
	 * 发送验证码
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/sendCode", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseData<ExternalUser> sendCode(@RequestBody ExternalUser user) {
		ResponseData<ExternalUser> res = new ResponseData<ExternalUser>();
		try {
			if(user ==null || StringUtils.isBlank(user.getMobile()) || StringUtils.isBlank(user.getType())){
				res.setResult(new Result(Status.ERROR, "参数不全"));
				return res;
			}
			String key = null;
			ExternalUser query = userBiz.getUser(user.getMobile());
			if("1".equals(user.getType())){//登录
				key = "user:login:"+user.getMobile();
			}
			if("2".equals(user.getType())){//找回密码
				if(query == null){
					res.setResult(new Result(Status.ERROR, "0","您输入账号不存在"));
					return res;
				}
				key = "user:forget:"+query.getMobile();
			}

			if("3".equals(user.getType())){//注册
				if(query != null){
					res.setResult(new Result(Status.ERROR, "1","您输入的手机号已被注册~"));
					return res;
				}
				key = "user:register:"+user.getMobile();
			}
			String code = getShortCode();
			SendSmsResponse response = SmsUtils.sendSms(code);
			if(response!=null && "OK".equals(response.getCode())){
				//cache.setByRedis(key, code, 60*10);
				stringRedisTemplate.opsForValue().set(key, code, 60*10);
			}else{
				logger.error("验证码发送失败,err_msg:" + response.getMessage());
				res.setResult(new Result(Status.ERROR,"2", "验证码发送失败"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setResult(new Result(Status.ERROR,"2", "验证码发送失败"));
		}
		return res;
	}

	public String getShortCode(){
		Random rand = new Random();
    	StringBuilder sb = new StringBuilder();
    	for(int i=0;i<4;i++){
    		sb.append(rand.nextInt(9));
    	}
    	return sb.toString();
	}

	@Override
	public void setEnvironment(Environment environment) {
		ctdn_index = environment.getProperty("ctdn_index");
		ctdn_domain = environment.getProperty("ctdn_domain");
		System.out.println("index:" + ctdn_index + "domain:"+ctdn_domain);
	}
	
	public void afterLogin(){
		long userId = 1l;
		String sessionId = "";
		String key = "session_user_prefix_" + userId;
		//Set<String> sIds = cache.getJedis().smembers(key);
		Set<String> sIds = stringRedisTemplate.opsForSet().members(key);
		if(sIds != null && sIds.size()>0){
			for(String sId : sIds){
				//cache.set("user_forced_online_"+sId, true);
				stringRedisTemplate.opsForValue().set("user_forced_online_"+sId, "true");
			}
		}
		long rtn = stringRedisTemplate.opsForSet().add(key, sessionId);
		if(rtn == 0){
			//cache.remove("user_forced_online_" + sessionId);
			stringRedisTemplate.delete("user_forced_online_" + sessionId);
		}
	}
}
