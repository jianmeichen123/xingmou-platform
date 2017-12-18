package com.gi.ctdn.utils;

import java.util.HashMap;
import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;


public class BeanContextUtils implements ApplicationContextAware,EnvironmentAware
{
	private static Logger logger = LoggerFactory.getLogger(BeanContextUtils.class);
	
	private static String UrlPatterns = null;
	
	private static Map<String,ApplicationContext> ctxCache = new HashMap<>();
	
	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException
	{
		if(ctx != null)
		{
			logger.info("Add Application Cache "+ctx.getDisplayName());
			ctxCache.put(ctx.getDisplayName(), ctx);
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<?> clazz)
	{
		Object obj = null;
		for(ApplicationContext ctx : ctxCache.values())
		{
			obj = ctx.getBean(clazz);
			if(obj != null)
			{
				return (T)obj;
			}
		}
		return null;
	}

	@Override
	public void setEnvironment(Environment environment) {
		UrlPatterns = environment.getProperty("url_patterns");
	}

	public static String getUrlPatterns() {
		return UrlPatterns;
	}

}
