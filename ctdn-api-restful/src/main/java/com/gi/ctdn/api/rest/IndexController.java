package com.gi.ctdn.api.rest;

import com.gi.ctdn.biz.EchartsBiz;
import com.gi.ctdn.biz.IndexHeaderStatBiz;
import com.gi.ctdn.biz.IndustryBiz;
import com.gi.ctdn.biz.OrgInfoBiz;
import com.gi.ctdn.biz.ProjectListBiz;
import com.gi.ctdn.biz.me.UserIndustryBiz;
import com.gi.ctdn.pojo.EchartsData;
import com.gi.ctdn.pojo.IndexHeaderStat;
import com.gi.ctdn.pojo.Industry;
import com.gi.ctdn.pojo.IndustryMonth;
import com.gi.ctdn.pojo.IndustryRoundMerger;
import com.gi.ctdn.pojo.OrgInfo;
import com.gi.ctdn.pojo.ProjectList;
import com.gi.ctdn.pojo.me.UserIndustry;
import com.gi.ctdn.view.common.MessageInfo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zcy on 17-9-5.
 */
@Controller
@RequestMapping("index")
public class IndexController implements EnvironmentAware{
	
	private Logger loger = LoggerFactory.getLogger(IndexController.class);


    @Autowired
    private UserIndustryBiz userIndustryBiz;

    @Autowired
    private IndexHeaderStatBiz indexHeaderStatBiz;
    
    @Autowired
    private ProjectListBiz projectListBiz;
    
    @Autowired
   	private OrgInfoBiz orgInfoBiz;
    
    @Autowired
    private IndustryBiz industryBiz;

    
	private String orgCodes = null;
	
	 @Autowired
	private EchartsBiz echartsBiz;
	
    /**
     *查询用户关注行业
     * @return messageInfo
     */
    @RequestMapping("userIndustry/{userId}")
    @ResponseBody
    public MessageInfo<UserIndustry> getUserIndustry (@PathVariable("userId") Integer userId){
        MessageInfo<UserIndustry> messageInfo = userIndustryBiz.getUserIndustry(userId);
        return messageInfo;
    }

    /**
     *设置用户关注行业
     * @return messageInfo
     */
    @RequestMapping("updateUserIndustry")
    @ResponseBody
    public MessageInfo<UserIndustry> updateUserIndustry (@RequestBody UserIndustry userIndustry){
        MessageInfo messageInfo = userIndustryBiz.updateUserIndustry(userIndustry);
        return messageInfo;
    }

    @RequestMapping("queryIndexHeaderStat")
    @ResponseBody
   // @Cacheable(value = "queryIndexHeaderStat",keyGenerator = "baseKG")
    public MessageInfo<IndexHeaderStat> queryIndexHeaderStat (){
        MessageInfo messageInfo = indexHeaderStatBiz.getIndexHeaderStat();
        return messageInfo;
    }
    

    /**
     * 获取最新发现项目
     * @return
     */
    @RequestMapping("queryLastestLoadProject")
    @ResponseBody
    public MessageInfo<List<ProjectList>> queryLastestLoadProject (){
		MessageInfo<List<ProjectList>> resultMessageInfo = new MessageInfo<List<ProjectList>>();
		try {
			List<ProjectList> projectLists  = projectListBiz.selectByLoadDate();
			resultMessageInfo.setData(projectLists);
		} catch (Exception e) {
			loger.error(" 获取最新发现项目,error:" + e.getMessage());
			resultMessageInfo.setStatus(0);
		}
		return resultMessageInfo;
    }
    
    /**
     * 获取最新获投项目
     * @return
     */
    @RequestMapping("queryLastestFinanceProject")
    @ResponseBody
    public MessageInfo<List<ProjectList>> queryLastestFinanceProject (){
		MessageInfo<List<ProjectList>> resultMessageInfo = new MessageInfo<List<ProjectList>>();
		try {
			List<ProjectList> projectLists  = projectListBiz.queryLastestFinanceProject();
			resultMessageInfo.setData(projectLists);
		} catch (Exception e) {
			e.printStackTrace();
			loger.error("获取最新获投项目,error:" + e.getMessage());
			resultMessageInfo.setStatus(0);
		}
		return resultMessageInfo;
    }
    
    /**
     * 获取上个月活跃机构
     * @param projectList
     * @return
     */
    @RequestMapping("queryLastestOrg")
    @ResponseBody
    public MessageInfo<List<OrgInfo>> getAllOrgInfo(){
		MessageInfo<List<OrgInfo>>  messageInfo = new MessageInfo<List<OrgInfo>>();
		try {
			List<OrgInfo> orgList = orgInfoBiz.getLatestOrg();
			messageInfo.setData(orgList);
		} catch (Exception e) {
			loger.error("获取上个月活跃机构,error:" + e.getMessage());
			messageInfo.setStatus(0);
		}
		return messageInfo;
	}
    
    
    /**
     * 获取一级行业机构
     * @param projectList
     * @return
     */
    @RequestMapping("getParentIndustrys")
    @ResponseBody
    public MessageInfo<List<Industry>> getParentIndustrys(){
		MessageInfo<List<Industry>>  messageInfo = new MessageInfo<List<Industry>>();
		try {
			List<Industry> industryList = industryBiz.getParentindustrys();
			messageInfo.setData(industryList);
		} catch (Exception e) {
			loger.error("获取一级行业机构失败,error:" + e.getMessage());
			messageInfo.setStatus(0);
		}
		return messageInfo;
	}
    
    /**
     * 保存或更新用户关注行业
     * @param projectList
     * @return
     */
    @RequestMapping("saveOrUpdateUerIndustry")
    @ResponseBody
    public MessageInfo<UserIndustry> saveOrUpdateUerIndustry(@RequestBody UserIndustry userIndustry){
		MessageInfo<UserIndustry>  messageInfo = new MessageInfo<UserIndustry>();
		try {
		    userIndustryBiz.saveOrUpdateUerIndustry(userIndustry);
		} catch (Exception e) {
			loger.error("保存或更新用户关注行业,error:" + e.getMessage());
			messageInfo.setStatus(0);
		}
		return messageInfo;
	}
    
    
//=========================================高管============================================================
    
    
    /**
     * 获取竞争动态
     * @return
     */
    @RequestMapping("getCompeteInfo")
    @ResponseBody
    public MessageInfo<List<OrgInfo>> getCompeteInfo(){
		MessageInfo<List<OrgInfo>>  messageInfo = new MessageInfo<List<OrgInfo>>();
		try {
			List<OrgInfo> orgInfoList = orgInfoBiz.getCompeteInfo(orgCodes);
			messageInfo.setData(orgInfoList);
		} catch (Exception e) {
			loger.error("获取高管数据模块,error:" + e.getMessage());
			messageInfo.setStatus(0);
		}
		return messageInfo;
	}
    
    
    @RequestMapping("queryGGTotalHeaderStat")
    @ResponseBody
    public MessageInfo<IndexHeaderStat> queryGGTotalHeaderStat (){
        MessageInfo<IndexHeaderStat> messageInfo = indexHeaderStatBiz.getGGTotalHeaderStat();
        return messageInfo;
    }
    
    @RequestMapping("queryGGCurMonthHeaderStat")
    @ResponseBody
    public MessageInfo<IndexHeaderStat> queryGGHeaderStat (){
        MessageInfo<IndexHeaderStat> messageInfo = indexHeaderStatBiz.getGGCurMonthHeaderStat();
        return messageInfo;
    }
    
    @RequestMapping("queryIndustryMonthForEchart")
    @ResponseBody
    public MessageInfo<EchartsData<IndustryMonth>> queryIndustryMonthForEchart (){
    	MessageInfo<EchartsData<IndustryMonth>> messageInfo = new MessageInfo<EchartsData<IndustryMonth>>();
		try {
			messageInfo = echartsBiz.getIndustryMonthForEchart();
		} catch (Exception e) {
			e.printStackTrace();
			loger.error("获取高管行业投资趋势,error:" + e.getMessage());
			messageInfo.setStatus(9999);
		}
        return messageInfo;
    }
    
    /**
     * 高管首页 ---行业融资对比
     * @return
     */
    @RequestMapping("queryIndustryMonthMergerForEchart")
    @ResponseBody
    public MessageInfo<EchartsData<IndustryRoundMerger>> queryIndustryMonthMergerForEchart (){
    	MessageInfo<EchartsData<IndustryRoundMerger>> messageInfo = new MessageInfo<EchartsData<IndustryRoundMerger>>();
		try {
			messageInfo = echartsBiz.getIndustryRoundMergerForEcharts();
		} catch (Exception e) {
			e.printStackTrace();
			loger.error("获取高管行业融资对比,error:" + e.getMessage());
			messageInfo.setStatus(9999);
		}
        return messageInfo;
    }
    
    
    

	@Override
	public void setEnvironment(Environment environment) {
		orgCodes = environment.getProperty("fixed_orgCode");
	}
}
