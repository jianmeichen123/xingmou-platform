package com.gi.ctdn.api.conf;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.alibaba.fastjson.JSONObject;
import com.gi.ctdn.dao.IndustryMonthDao;
import com.gi.ctdn.dao.IndustryRoundMergerDao;
import com.gi.ctdn.pojo.IndustryMonth;
import com.gi.ctdn.pojo.IndustryRoundMerger;
import com.gi.ctdn.utils.BeanContextUtils;
import com.gi.ctdn.utils.Constants;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * 初始化--高管首页图表信息
 * @author root
 *
 */
public class InitListener implements  ApplicationListener<ContextRefreshedEvent>{
	
	private Logger logger = LoggerFactory.getLogger(InitListener.class);

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		try {
			ShardedJedis shardedJedis = BeanContextUtils.getBean(ShardedJedis.class);
			IndustryMonthDao industryMonthDao =  BeanContextUtils.getBean(IndustryMonthDao.class);
			IndustryRoundMergerDao industryRoundMergerDao =  BeanContextUtils.getBean(IndustryRoundMergerDao.class);
			List<IndustryMonth> industryMonthList = industryMonthDao.getIndustryMonthForEcharts();
			List<IndustryRoundMerger> industryRoundMergerList = industryRoundMergerDao.getIndustryRoundMergerForEcharts();
			shardedJedis.set(Constants.INDUSTRY_INVESTED_TREND,JSONObject.toJSONString(industryMonthList));
			shardedJedis.set(Constants.INDUSTRY_INVESTED_COMPARE,JSONObject.toJSONString(industryRoundMergerList));
			shardedJedis.close();
			logger.debug("init echarts data succes....................................................");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("初始化图表信息失败，error:" + e.getMessage());
		}
	}

}
