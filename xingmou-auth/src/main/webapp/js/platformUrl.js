var Constants = {
	//platformContentURL: "http://xm.dev.galaxyinternet.com/"

		//platformContentURL: "http://localhost:8080/galaxy-xingmou-server/"
		//platformContentURL: "http://localhost:8080/"
		
		platformContentURL: endpointObj["project.home.page.url"]
}


var platformUrl = {
		
	/**
	 * 跳转登录页
	 */
	toLoginPage :Constants.platformContentURL+ "galaxy/userlogin/toLogin",
	
	/**
	 * 退出登录
	 */
	logout:Constants.platformContentURL+ "galaxy/userlogin/logout",
	
	/**
	 * 验证登录
	 */
	toLogin :Constants.platformContentURL+ "galaxy/userlogin/login",
	
	/**
	 * 跳转到首页
	 */
    toIndex :Constants.platformContentURL+  "galaxy/index",
    
	/**
	 * 查询密码
	 */
	checkPwd : Constants.platformContentURL + "galaxy/user/checkPwd",
	
	/**
	 * 修改密码
	 */
	updatePwd : Constants.platformContentURL + "galaxy/user/updatePwd",
	/**
	 * 投资事件
	 */
	eventIndex:Constants.platformContentURL+"galaxy/investmentEvents",
	/**
	 * 投资机构
	 */
	agencyIndex:Constants.platformContentURL+"galaxy/investfirms",
	/**
	 * 项目库
	 */
	projectList:Constants.platformContentURL+"galaxy/project/list",
	/**
	 * 项目库到处数据
	 */
	exportProjectList:Constants.platformContentURL+"galaxy/project/exportProjectInfo",
	/**
	 * 项目库详情
	 */
	projectDetail:Constants.platformContentURL +"galaxy/project/projectDetail",
	/**
	 * 项目库详显示
	 */
	projectDetailList:Constants.platformContentURL+"galaxy/project/getDetail",
	/**
	 * 跳转到投资人
	 */
	investorDetail:Constants.platformContentURL+"galaxy/investfirms/investorDetail",
	/**
	 * 投资人 参数：id
	 */
	queryMember:Constants.platformContentURL+"galaxy/investfirms/queryMember",
	/**
	 * 工作经历
	 */
	queryJobList:Constants.platformContentURL+"galaxy/investfirms/queryJobList",
	/**
	 * 学习经历
	 */
	queryStudyList:Constants.platformContentURL+"galaxy/investfirms/queryStudyList",
	/**
	 * 获取地区列表
	 */
	getDistrictList:Constants.platformContentURL+"galaxy/project/getDistrictList",
	
	/**
	 * 导出投资事件数据
	 */
	exportInvestEvent:Constants.platformContentURL+"galaxy/investmentEvents/exportInvestEvent",
	/**
	 * 导出投资机构数据
	 */
	exportAgencyList:Constants.platformContentURL+"galaxy/investfirms/exportAgencyList",
	
	/**
	 * 查询投资事件，项目库行业
	 */
	getIndustryList:Constants.platformContentURL+"galaxy/project/getIndustryList",
	/**
	 *查询投资事件轮次
	 */
	getRoundList:Constants.platformContentURL+"galaxy/project/getRoundList",
	/**
	 * 查询投资机构领域
	 */
	getAreaList:Constants.platformContentURL+"galaxy/project/getAreaList",
	
	/**
	 * 导出投资事件数据
	 */
	exportInvestEvent:Constants.platformContentURL+"galaxy/investmentEvents/exportInvestEvent",
	/**
	 * 导出投资机构数据
	 */
	
	exportAgencyList:Constants.platformContentURL+"galaxy/investfirms/exportAgencyList",
	
	index_whole_month : Constants.platformContentURL+"galaxy/wholeMonth/wholeMonthStatis",
	
	index_industry_month :Constants.platformContentURL+"galaxy/industryMonth/industryMonthStatis",

	index_round_month :Constants.platformContentURL+"galaxy/roundMonth/roundMonthStatis",
	
	index_round_year :Constants.platformContentURL+"galaxy/roundMonth/roundYearStatis",
	
	index_district_month :Constants.platformContentURL+"galaxy/districtMonth/districtMonthStatis",
	
	agencyDetail:Constants.platformContentURL+"galaxy/investfirms/agencyDetail",
	
	queryMemberList:Constants.platformContentURL+"galaxy/investfirms/queryMemberList",
	
	statisticsRound :Constants.platformContentURL+"galaxy/wholeMonth/statisticsRound",
	
	statisticsAreas :Constants.platformContentURL+"galaxy/wholeMonth/statisticsAreas",
	
	investfirmsDetail:Constants.platformContentURL+"galaxy/investfirms/${id}/InvestfirmsDetail",
	
	//queryMember:Constants.platformContentURL+"galaxy/investfirms/queryMember",
	
	toAgencyDetal:Constants.platformContentURL +"galaxy/investfirms/agencyDetail",
	/**
	 * 项目详情
	 */
	toProjectDetal:Constants.platformContentURL +"galaxy/project/projectDetail",
	analysis:Constants.platformContentURL +"galaxy/analysis",

	project_getIndustryMontht: Constants.platformContentURL+"galaxy/project/getIndustryMonth",
	
	project_industryMonthTrendList :Constants.platformContentURL+"galaxy/project/getIndustryMonthTrendList",
	
	project_investIndustryList :Constants.platformContentURL +"galaxy/project/getInvestIndustryList",
	
	
	industryDistrictRound :Constants.platformContentURL +"galaxy/project/getIndustryDistrictRound",
	
	industryRoundRound :Constants.platformContentURL +"galaxy/project/getIndustryRoundRound",
	
	investMoneyLevelYearRate :Constants.platformContentURL +"galaxy/project/getInvestMoneyLevelYearRate",
	
	//新增统计接口
	/**
	 * 按轮次统计金额
	 */
	sumByRoundStatis:Constants.platformContentURL +"galaxy/roundInvestmoney/sumByRoundStatis",
	/**
	 * 金额统计
	 */
	sumStatis:Constants.platformContentURL +"galaxy/roundInvestmoney/sumStatis",
	/**
	 * 机构投资金额top10 接口
	 */
	rankingStatis:Constants.platformContentURL +"galaxy/investfirmStatis/rankingStatis",
	/**
	 * 投资事件行业分布
	 */
	getIndustryProjectTotalList:Constants.platformContentURL +"galaxy/project/getIndustryProjectTotalList",
	/**
	 * //项目库柱状图（已获投、未获投）
	 */
	getIndustryProjectList:Constants.platformContentURL +"galaxy/project/getIndustryProjectList",
	
	/**
	 * //项目库各轮次的项目数量、比例
	 */
	getRoundProjectList:Constants.platformContentURL +"galaxy/project/getRoundProjectList",
	
	/**
	 * 请求事件列表数据
	 */
	queryEventList:Constants.platformContentURL +"galaxy/investmentEvents/queryEventList",
	
	/**
	 * 项目库
	 */
	getProjectInfoList:Constants.platformContentURL +"galaxy/project/getProjectInfoList",
	
	/**
	 * 投资机构列表
	 */
	queryAgencyList: Constants.platformContentURL +"galaxy/investfirms/queryAgencyList",
	/**
	 * 项目库和投资机构logo地址
	 */
	logoPath:"http://static.galaxyinternet.com/xm",
	
	/**
	 * 数据更新时间
	 */
	indexUpdateTime:Constants.platformContentURL +"galaxy/project/getMetadata",
}




