var Constants = {
	//platformContentURL: "http://ctdn.dev.userinternet.com/"

		//platformContentURL: "http://localhost:8080/user-xingmou-server/"
		platformContentURL: "http://ctdndev.gi.com/user/",

		htmlContentUrl : "http://ctdndev.gi.com/"

		//platformContentURL: endpointObj["project.home.page.url"]
}


var platformUrl = {

	/**
	 * 跳转登录页
	 */
	toLoginPage :Constants.platformContentURL+ "user/userlogin/toLogin",

	/**
	 * 退出登录
	 */
	logout:Constants.platformContentURL+ "user/userlogin/logout",

	/**
	 * 验证登录
	 */
	toLogin :Constants.platformContentURL+ "userlogin/login",

	/**
	 * 跳转到首页
	 */
    toIndex :Constants.platformContentURL+  "user/index",

	/**
	 * 查询密码
	 */
	checkPwd : Constants.platformContentURL + "user/user/checkPwd",

	/**
	 * 修改密码
	 */
	updatePwd : Constants.platformContentURL + "user/user/updatePwd",

	ctdncx : Constants.htmlContentUrl + "list_page_com.html",

	index : Constants.htmlContentUrl + "index.html",
}




