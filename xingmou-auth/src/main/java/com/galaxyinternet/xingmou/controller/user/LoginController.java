package com.galaxyinternet.xingmou.controller.user;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
@RequestMapping("/galaxy/auth")
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

	/**
	 * 跳转登录
	 */
	@RequestMapping(value = "/toLogin")
	public String toLogin() {
		return "system/login";
	}

	/**
	 * 用户登录
	 * 
	 * @author zcy
	 */
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseData<User> login(@RequestBody User user, HttpServletRequest request) {
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
			setCacheSessionId(request, user, sessionId);
			Header header = getHeader(user, sessionId);
			responsebody.setHeader(header);
			responsebody.setResult(new Result(Status.OK, Constants.OPTION_SUCCESS, "登录成功！"));
		}
		return responsebody;
	}

	/**
	 * @author zcy
	 * @param user
	 * @param role
	 * @return
	 */
	private Header getHeader(User user, String sessionId) {
		Header header = new Header();
		header.setLoginName(user.getEmail());
		header.setSessionId(sessionId);
		header.setUserId(user.getId());
		return header;
	}

	/**
	 * @author zcy
	 * @param request
	 * @param user
	 */
	private void setCacheSessionId(HttpServletRequest request, User user, String sessionId) {
		user.setSessionId(sessionId);
		cache.set(sessionId, user); // 将sessionId存入cache
		request.getSession().setAttribute(Constants.SESSION_USER_KEY, user);
	}

	/**
	 * 用户注销
	 * @author zcy
	 */
	@ResponseBody
	@RequestMapping(value = "/logout", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseData<User> logout(HttpServletRequest request) {
		ResponseData<User> responsebody = new ResponseData<User>();
		String sessionId = request.getHeader(Constants.SESSION_ID_KEY);
		if (StringUtils.isBlank(sessionId)) {
			responsebody.setResult(new Result(Status.ERROR, Constants.IS_SESSIONID_EMPTY, "sessionId为空！"));
			return responsebody;
		}
		boolean flag = removeSessionId(sessionId, request); // 从session和cache中删除sessionId
		if (!flag) {
			responsebody.setResult(new Result(Status.ERROR, Constants.INVALID_SESSIONID, "sessionId错误！"));
			return responsebody;
		}
		responsebody.setResult(new Result(Status.OK, Constants.OPTION_SUCCESS, "退出登录"));
		return responsebody;
	}

	/**
	 * 删除session 和 cache中的 sessionId
	 * 
	 * @author zcy
	 * @param key
	 */
	private boolean removeSessionId(String sessionId, HttpServletRequest request) {
		Object cahceUser = cache.get(sessionId);
		Object sessionUser = request.getSession().getAttribute(Constants.SESSION_USER_KEY);

		if (null == cahceUser || null == sessionUser) {
			return false;
		}
		request.getSession().removeAttribute(Constants.SESSION_USER_KEY); // 从本地session删除user
		cache.remove(sessionId); // 从redis中删除sessionId
		return true;
	}

}
