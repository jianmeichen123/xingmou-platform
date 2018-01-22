package com.gi.xm.platform.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.galaxyinternet.framework.core.constants.Constants;
import com.galaxyinternet.framework.core.model.ResponseData;
import com.galaxyinternet.framework.core.model.Result;
import com.galaxyinternet.framework.core.model.Result.Status;
import com.galaxyinternet.framework.core.utils.SessionUtils;
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
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/userlogin")
public class LoginController implements EnvironmentAware{
	
    final Logger logger = LoggerFactory.getLogger(LoginController.class);

//    @Autowired
//    private UserService userService;
//
    @Autowired
    com.galaxyinternet.framework.cache.Cache cache;

    @Autowired
    AuthRequest authReq;
    
    @Autowired
    private UserBiz userBiz;

    private String ctdn_normal_index ="";
    private String ctdn_external_index = "";
    private String ctdn_senior_index = "";
    private String ctdn_manager_index = "";
	private String ctdn_index = "";
    private String ctdn_domain ="";
    private String ctdn_login="";

	private static final Long  TZJL_ROLECODE = 10000l;		//星河投内部用户 投资经理用户code

    private static final Long  GG_ROLECODE = 20000l;		//星河投内部用户  高管用户code

	private static final Long  VISITOR_ROLECODE = 30000l;	// 游客角色用户code


	@Autowired
	private StringRedisTemplate stringRedisTemplate;


	/**
	 * 跳转登录
	 */
	@RequestMapping(value = "/index")
	public String index(HttpServletResponse response, @CookieValue(name = "_uid_",required = false)String uid,@CookieValue(name = "s_",required = false)String s) {
		try {
			if (uid ==null ||s==null){
				return "redirect:"+ctdn_index;
			}
			String key = "ctdn:"+s+":"+uid;
			String user = (String)stringRedisTemplate.opsForValue().get(key);
			String res_uir = ctdn_normal_index;
			if(user!=null){
				JSONObject jsonObject = (JSONObject) JSONObject.parse(URLDecoder.decode(user,"UTF-8"));
				long roleCode  = jsonObject.getLongValue("roleCode");
				if(roleCode == TZJL_ROLECODE){
					res_uir =ctdn_manager_index ;
				}else if(roleCode == GG_ROLECODE){
					res_uir = ctdn_senior_index;
				}else{
					res_uir = ctdn_external_index;
				}
				return "redirect:"+res_uir;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "redirect:"+ctdn_login;
	}

    /**
     * 跳转登录
     */
    @RequestMapping(value = "/toLogin")
    public String toLogin(HttpServletResponse response, @CookieValue(name = "_uid_",required = false)String uid,@CookieValue(name = "s_",required = false)String s) {
    	try {
    		String key = "ctdn:"+s+":"+uid;
    		String user = (String)stringRedisTemplate.opsForValue().get(key);
    		String res_uir = ctdn_normal_index;
    		if(user!=null){
    			JSONObject jsonObject = (JSONObject) JSONObject.parse(URLDecoder.decode(user,"UTF-8"));
    			long roleCode  = jsonObject.getLongValue("roleCode");
    			if(roleCode == TZJL_ROLECODE){
    				res_uir =ctdn_manager_index ;
    			}else if(roleCode == GG_ROLECODE){
    				res_uir = ctdn_senior_index;
    			}else{
    				res_uir = ctdn_external_index;
    			}
    			return "redirect:"+res_uir;
    		}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        return "redirect:"+ctdn_login;
    }

    @RequestMapping(value = "/auth")
    public String auth(HttpServletResponse response,String uid) {
		com.galaxyinternet.model.user.User u =  (com.galaxyinternet.model.user.User)cache.get(uid);
		if (u == null) {
			return "redirect:"+ctdn_login;
		}
		String key = "ctdn:internal:" + uid;
		String user = stringRedisTemplate.opsForValue().get(key);
		String res_uir = ctdn_normal_index;
		if (user != null) {
			JSONObject jsonObject = null;
			try {
				jsonObject = (JSONObject) JSONObject.parse(URLDecoder.decode(user, "UTF-8"));
				long roleCode = jsonObject.getLongValue("roleCode");
				if (roleCode == TZJL_ROLECODE) {
					res_uir = ctdn_manager_index;
				} else if (roleCode == GG_ROLECODE) {
					res_uir = ctdn_senior_index;
				} else  {
					res_uir = ctdn_external_index;
				}
				logger.info("***user is not null**********"+roleCode+":"+res_uir);
				return "redirect:" + res_uir;
			}catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		//如果创投大脑未登录,设置redis,设置cookie 跳转首页变为已登录状态
		User ctdnUser = new User();
		String userCode = PWDUtils.generateUserCode(u.getId(),"internal");
		Long roleCode = getRoleCode(u.getId());
		if (roleCode == TZJL_ROLECODE) {
			res_uir = ctdn_manager_index;
		} else if (roleCode == GG_ROLECODE) {
			res_uir = ctdn_senior_index;
		} else  {
			res_uir = ctdn_external_index;
		}
		logger.info("***user is  null**********"+roleCode+":"+res_uir);
		ctdnUser.setUserCode(userCode);
		ctdnUser.setRoleCode(roleCode);
		ctdnUser.setRealName(u.getEmail());
		ctdnUser.setDepartmentId(u.getDepartmentId());
		setCacheSessionId("internal", ctdnUser, uid,false);
		setCookie(response,userCode,uid,"internal",false);
		return "redirect:" + res_uir;
    }

    private Long getRoleCode(Long userId){
		//内部用户查询roleCode 用roleId字段存值
		List<Long> roleCodes = authReq.selectRoleCodeByUserId(userId);
		if(roleCodes.indexOf(GG_ROLECODE)>-1){
			return GG_ROLECODE;
		}else if(roleCodes.indexOf(TZJL_ROLECODE)>-1){
			return TZJL_ROLECODE;
		}else{
			return VISITOR_ROLECODE;
		}
	}
    /**
     *
     * @param response
     * @param uid
     * @param s 来源
     */
    public void setCookie(HttpServletResponse response ,String userCode,String uid,String s,boolean notAuto){
		Cookie cookie = new Cookie("_usercode_", userCode);
		cookie.setMaxAge(notAutoLogin(notAuto));
		cookie.setDomain(ctdn_domain);
		cookie.setPath("/");
		response.addCookie(cookie);
		cookie = new Cookie("_uid_", uid);
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
		try {
			//判断外部用户密码是否为空
			JSONObject jsonObject = (JSONObject) JSONObject.parse(URLDecoder.decode(userJson,"UTF-8"));
			if(jsonObject != null && jsonObject.containsKey("mobile")){
				String mobile = jsonObject.getString("mobile");
				ExternalUser user = userBiz.getUser(mobile);
				if(StringUtils.isEmpty(user.getPassword())){
					jsonObject.put("isEmptyPassword","1"); //密码为空
				}else{
					jsonObject.put("isEmptyPassword","0"); //不为空
				}
				jsonObject.put("ancientPWD", user.getPassword());
				userJson = URLEncoder.encode(jsonObject.toJSONString(),"UTF-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
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
            responsebody.setResult(new Result(Status.ERROR, Constants.IS_UP_WRONG, "您的账号与密码不匹配~"));
            return responsebody;
        }
        user = rtn.getValue();
		//内部用户查询roleCode 用roleId字段存值
		Long roleCode = getRoleCode(user.getId());
		user.setRoleCode(roleCode);
		//生成usercode
		user.setUserCode(PWDUtils.generateUserCode(user.getId(),"internal"));
		String key = "ctdn-firstLogin:internal:"+user.getId();         //判断用户是否第一次登录创投大脑
		if(stringRedisTemplate.opsForValue().get(key) == null){
			stringRedisTemplate.opsForValue().set(key,"true");
		}else{
			stringRedisTemplate.opsForValue().set(key,"false");
		}
		String sessionId = SessionUtils.createWebSessionId(); // 生成sessionId
        setCacheSessionId("internal", user, sessionId,notAuto);
        responsebody.setEntity(user);
        responsebody.setResult(new Result(Status.OK, Constants.OPTION_SUCCESS, "登录成功！"));
        setCookie(response,user.getUserCode(),sessionId,"internal",notAuto);
        logger.info(user.getRealName()+" login_success ctdn");
        return responsebody;
    }

    /**
     * @author zcy
     * @param from
     * @param user
     */
    private void setCacheSessionId(String from, User user, String sessionId,boolean notAuto) {
        //是否是第一次登录
        String status =  stringRedisTemplate.opsForValue().get("ctdn-firstLogin:" + from + ":"+user.getId());
        user.setStatus(status);
        String json = null;
        try {
            json = URLEncoder.encode(JSON.toJSONString(user),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("json utf8-8编码失败");
        }
        if (json!=null){
			stringRedisTemplate.boundValueOps("ctdn:"+from+":"+sessionId+":code").set(user.getUserCode());
			stringRedisTemplate.boundValueOps("ctdn:"+from+":"+sessionId).set(json,notAutoLogin(notAuto),TimeUnit.SECONDS);
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
		cookie = new Cookie("_usercode_", null);
		cookie.setMaxAge(1);
		cookie.setDomain(ctdn_domain);
		cookie.setPath("/");
		response.addCookie(cookie);
		cookie = new Cookie("_realName_", null);
		cookie.setMaxAge(1);
		cookie.setDomain(ctdn_domain);
		cookie.setPath("/");
		response.addCookie(cookie);
        responsebody.setResult(new Result(Status.OK, Constants.OPTION_SUCCESS, "退出登录"));
        return "redirect:"+ctdn_login;
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
			messageInfo.setResult(new Result(Status.ERROR, "2","您输入的账号不存在~"));
			return messageInfo;
		}
		if(!PWDUtils.genernateNewPasswordByBase64(user.getPassword()).equals(query.getPassword())){
			messageInfo.setResult(new Result(Status.ERROR, "1","您的账号与密码不匹配~"));
			return messageInfo;
		}
		String key = "ctdn-firstLogin:external:"+query.getId();

		if(stringRedisTemplate.opsForValue().get(key) == null){
			stringRedisTemplate.opsForValue().set(key, "true");
		}else{
			stringRedisTemplate.opsForValue().set(key, "false");
		}
		//生成usercode
		query.setUserCode(PWDUtils.generateUserCode(query.getId(),"external"));
		query.setRoleCode(VISITOR_ROLECODE);
		String sessionId = SessionUtils.createWebSessionId(); // 生成sessionId
		setCacheSessionId(query,"external", sessionId,notAuto);
		messageInfo.setEntity(query);
		messageInfo.setResult(new Result(Status.OK, Constants.OPTION_SUCCESS, "登录成功！"));
		setCookie(response,query.getUserCode(),sessionId,"external",notAuto);
		
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
			    responsebody.setResult(new Result(Status.ERROR, Constants.IS_UP_EMPTY, "手机号或验证码不能为空！")); //0
			    return responsebody;
			}
			String key = "user:login:"+user.getMobile();
			String codeFromRedis  = (String) stringRedisTemplate.opsForValue().get(key);
			System.out.println(codeFromRedis);
			if(!code.equals(codeFromRedis)){
				responsebody.setResult(new Result(Status.ERROR, "1", "验证码错误"));//1
				return responsebody;
			}
			ExternalUser rtn = userBiz.getUser(mobile);
			if(rtn == null)
			{
				userBiz.insert(user);
				rtn = user;
			}
			
			String firstLoginKey = "ctdn-firstLogin:external:"+rtn.getId();

			if(stringRedisTemplate.opsForValue().get(firstLoginKey) == null){
				stringRedisTemplate.opsForValue().set(firstLoginKey, "true");
			}else{
				stringRedisTemplate.opsForValue().set(firstLoginKey, "false");
			}
			rtn.setUserCode(PWDUtils.generateUserCode(rtn.getId(),"external"));
			rtn.setRoleCode(VISITOR_ROLECODE);
			String sessionId = SessionUtils.createWebSessionId(); // 生成sessionId
			setCacheSessionId(rtn,"external", sessionId,isAuto);
			responsebody.setEntity(rtn);
			responsebody.setResult(new Result(Status.OK, Constants.OPTION_SUCCESS, "登录成功！"));
			setCookie(response,rtn.getUserCode(),sessionId,"external",isAuto);
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
	        ExternalUser externalUser = new ExternalUser();
		 	String status = (String)stringRedisTemplate.opsForValue().get("ctdn-firstLogin:" + from + ":"+user.getId());
		 	externalUser.setStatus(status);
		 	externalUser.setMobile(user.getMobile());
		 	externalUser.setUserCode(user.getUserCode());
//		 	externalUser.setPassword(user.getPassword());
		 	externalUser.setRoleCode(user.getRoleCode());
	        try {
	            json = URLEncoder.encode(JSON.toJSONString(externalUser),"UTF-8");
	        } catch (UnsupportedEncodingException e) {
	            logger.error("json utf8-8编码失败");
	        }
	        if (json!=null){
	            //cache.setByRedis("ctdn:"+from+":"+sessionId, json,notAutoLogin(notAuto)); // 将sessionId存入cache
				stringRedisTemplate.opsForValue().set("ctdn:"+from+":"+sessionId+":code", externalUser.getUserCode()); // 将sessionId存入cache
				stringRedisTemplate.opsForValue().set("ctdn:"+from+":"+sessionId, json,notAutoLogin(notAuto),TimeUnit.SECONDS); // 将sessionId存入cache
	            logger.info(sessionId+" "+json);
	        }
	    }
	 
//	 @RequestMapping("/toRegister")
//	 public String toRegister(){
//		 return "redirect:"+ctdn_register;
//	 }
//
//	 @RequestMapping("/forgetPassword")
//	 public String forgetPassword(){
//		 return "redirect:"+ctdn_forgetpass;
//	 }
	 
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
			 String codeFromRedis = stringRedisTemplate.opsForValue().get(key);
//			 codeFromRedis = "1234";
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
			res.setResult(new Result(Status.OK, "","密码重置成功"));
		}catch(Exception e){
			e.printStackTrace();
			res.setResult(new Result(Status.ERROR,"0", "密码重置失败，请稍后再试"));
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
			//防止外部恶意刷验证码key=user:login|register|forget:mobile:
			String brushSmsKey  = "user:code:" + user.getMobile();
			String brushSmsValue = stringRedisTemplate.opsForValue().get(brushSmsKey);
			if(brushSmsValue != null){
				res.setResult(new Result(Status.ERROR,"3", "验证码已发送，请稍候重试"));
				return res;
			}
			String code = getShortCode();
			SendSmsResponse response = SmsUtils.sendSms(code,user.getMobile());
			if(response!=null && "OK".equals(response.getCode())){
				stringRedisTemplate.opsForValue().set(brushSmsKey, "exists", 60,TimeUnit.SECONDS); //
				stringRedisTemplate.opsForValue().set(key, code, 60*10,TimeUnit.SECONDS);
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
		ctdn_normal_index = environment.getProperty("ctdn_normal_index");
		ctdn_domain = environment.getProperty("ctdn_domain");
		ctdn_manager_index = environment.getProperty("ctdn_manager_index");
		ctdn_external_index = environment.getProperty("ctdn_external_index");
		ctdn_senior_index = environment.getProperty("ctdn_senior_index");
		ctdn_index = environment.getProperty("ctdn_index");
		ctdn_login = environment.getProperty("ctdn_login");
		System.out.println("ctdn_normal_index:" + ctdn_normal_index + "domain:"+ctdn_domain + ",ctdn_manager_index:"+ctdn_manager_index
				+",ctdn_external_index:" +ctdn_external_index +",ctdn_senior_index:"+ctdn_senior_index);
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
	
	/**
	 * 测试验证码是或否正确
	 * @param user
	 * @return
	 */
	@RequestMapping("/checkCode")
	@ResponseBody
	public ResponseData<ExternalUser> checkCode(@RequestBody ExternalUser user)
	{
		ResponseData<ExternalUser> messageInfo = new  ResponseData<ExternalUser>();
		try {
			if(user == null || StringUtils.isBlank(user.getMobile())
					|| StringUtils.isBlank(user.getCode())
					|| StringUtils.isBlank(user.getType())){
				messageInfo.setResult(new Result(Status.ERROR, "0", "参数错误"));//1
				return messageInfo;
			}
			String key = "";
			if("2".equals(user.getType())){
				key = "user:forget:"+user.getMobile();
			}
			if("3".equals(user.getType())){
				key  = "user:register:"+user.getMobile();
			}
			String codeFromRedis  = (String) stringRedisTemplate.opsForValue().get(key);
//			codeFromRedis = "1234";
			System.out.println(codeFromRedis);
			if(codeFromRedis == null || !user.getCode().equals(codeFromRedis)){
				messageInfo.setResult(new Result(Status.ERROR, "1", "验证码错误"));//1
				return messageInfo;
			}
		} catch (Exception e) {
			e.printStackTrace();
			messageInfo.setResult(new Result(Status.ERROR,"2" ,"系统繁忙"));
		}
		return messageInfo;
	}


	@ResponseBody
	@RequestMapping(value = "/modifyPass", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseData<ExternalUser> modifyPass(@RequestBody ExternalUser user) {
		ResponseData<ExternalUser> res = new ResponseData<ExternalUser>();
		if(user == null || StringUtils.isEmpty(user.getMobile()) || StringUtils.isEmpty(user.getPassword()) || StringUtils.isEmpty(user.getConfirmPassword())){
			res.setResult(new Result(Status.ERROR, "参数不全"));
			return res;
		}
		if(!user.getPassword().equals(user.getConfirmPassword())){
			res.setResult(new Result(Status.ERROR,"0", "密码不一致"));
			return res;
		}
		ExternalUser rtn = userBiz.getUser(user.getMobile());
		rtn.setPassword(PWDUtils.genernateNewPasswordByBase64(user.getPassword()));
		userBiz.update(rtn);
		String sessionId = SessionUtils.createWebSessionId(); // 生成sessionId
		//setCacheSessionId( rtn,"external", sessionId,false);
		return res;
	}
    @ResponseBody
  	@SuppressWarnings("unchecked")
    @RequestMapping(value = "/checkInternalUserExists", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseData<User> checkInternalUserExists( @RequestBody User user) {
        ResponseData<User> responsebody = new ResponseData<User>();
        try {
			if (user == null || StringUtils.isBlank(user.getNickName())) {
			    responsebody.setResult(new Result(Status.ERROR, Constants.IS_UP_EMPTY, "用户名不能为空！"));
			    return responsebody;
			}
			HashMap<String,Object> rtn = (HashMap<String, Object>) authReq.checkUserExists(user.getNickName());
			int value =  (int) rtn.get("value");
			user.setStatus(value +"");
			responsebody.setEntity(user);
			responsebody.setResult(new Result(Status.OK,""));
		} catch (Exception e) {
			e.printStackTrace();
			responsebody.setResult(new Result(Status.ERROR,"系统繁忙"));
		}
        return responsebody;
    }
}
