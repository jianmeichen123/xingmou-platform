var Constants = {
	//platformContentURL: "http://xm.dev.galaxyinternet.com/"

		//platformContentURL: "http://localhost:8080/galaxy-xingmou-server/"
		platformContentURL: "http://xmdev.gi.com/user/",

		htmlContentUrl : "http://xmdev.gi.com/html/"

		//platformContentURL: endpointObj["project.home.page.url"]
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
	toLogin :Constants.platformContentURL+ "userlogin/login",
	
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

	xmcx : Constants.htmlContentUrl + "xmcx.html",
}




