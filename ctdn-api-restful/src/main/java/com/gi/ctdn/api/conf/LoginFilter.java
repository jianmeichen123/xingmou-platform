package com.gi.ctdn.api.conf;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gi.ctdn.pojo.User;
import com.gi.ctdn.utils.BeanContextUtils;
import com.gi.ctdn.view.common.MessageInfo;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class LoginFilter implements  Filter{

	private static final String loginUrl  = "http://fx.local.galaxyinternet.com/user/userlogin/toLogin";
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
		
		
		ShardedJedis shardedJedis = BeanContextUtils.getBean(ShardedJedis.class);
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String urlPatterns = BeanContextUtils.getUrlPatterns();
		String reqUrl = req.getRequestURI();
		System.out.println("filter = " + shardedJedis + " ,reqUrl = " +  reqUrl + " ,urlPatterns = " + urlPatterns);
		if(urlPatterns !=null && urlPatterns.trim().length() !=0  && urlPatterns.indexOf(reqUrl) <0){
			chain.doFilter(request, response);
			return;
		}
		Cookie[] cookies = req.getCookies();
		String _uid_ = null; // sessionId
		String s_ = null; //来源（ctdn）
		if (cookies != null && cookies.length > 0)
		{
			for (Cookie cookie : cookies)
			{
				String name = cookie.getName();
				if("_uid_".equals(name)){
					_uid_ = cookie.getValue();
					continue;
				}
				if("s_".equals(name)){
					s_ = cookie.getValue();
					continue;
				}
			}
		}
		if(_uid_ != null && _uid_.trim().length()!=0  && s_ !=null && s_.trim().length()!=0  && "ctdn".equals(s_)){
			String key = "ctdn:ctdn:" + _uid_; 
			boolean exist = shardedJedis.exists(key);
			if(!exist){
				//未登录
				try {
					writeLoginMsg(req, res, "用户未登录或已过期,请重新登录");
					return;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else{
				chain.doFilter(request, response);
				return;
			}
		}else{
			//未登录
			try {
				writeLoginMsg(req, res, "用户未登录或已过期,请重新登录");
				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	

	private void writeLoginMsg(HttpServletRequest req, HttpServletResponse res, String msg) throws Exception {
		MessageInfo<User> data = new MessageInfo<>();
		data.setStatus(0);
		data.setMessage(msg);
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(data);
		res.setHeader("Content-type", "application/json;charset=UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.getWriter().write(result);
	}

	@Override
	public void destroy() {
		
	}

}
