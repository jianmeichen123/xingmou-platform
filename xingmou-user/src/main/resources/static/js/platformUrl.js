var Constants = {
	//platformContentURL: "http://ctdn.dev.userinternet.com/"

		//platformContentURL: "http://localhost:8080/user-xingmou-server/"
		platformContentURL: "http://ctdnqa.gi.com/user/",

		htmlContentUrl : "http://ctdnqa.gi.com.com"

		//platformContentURL: endpointObj["project.home.page.url"]
}


var platformUrl = {

	/**
	 * 跳转登录页
	 */
	toLoginPage :Constants.platformContentURL+ "/userlogin/toLogin",

	/**
	 * 退出登录
	 */
	logout:Constants.platformContentURL+ "/userlogin/logout",

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

	index : Constants.htmlContentUrl + "/index.html",
	loginByCode:Constants.platformContentURL + "userlogin/loginByCode",
	toRegister:Constants.platformContentURL + "userlogin/toRegister",
	register:Constants.platformContentURL + "userlogin/register",
	forgetPassword:Constants.platformContentURL + "userlogin/forgetPassword",
	updatePassword:Constants.platformContentURL + "userlogin/updatePassword",
	sendCode:Constants.platformContentURL + "userlogin/sendCode",
	loginByPassword:Constants.platformContentURL + "userlogin/loginByPassword",
}
var htmlPlatformUrl = {
		search:Constants.htmlContentUrl + "/search_index.html",
		search_finance:Constants.htmlContentUrl + "/seek_financing.html",
		index_head:Constants.htmlContentUrl + "/index.html",
		evaluating:Constants.htmlContentUrl+"/project_evaluating.html",
		report:Constants.htmlContentUrl+"/report_list.html",
		news_head:Constants.htmlContentUrl+"/news.html",
		investor:Constants.htmlContentUrl+"/list_page_investor.html",
		startup:Constants.htmlContentUrl+"/list_page_startup.html",
		org:Constants.htmlContentUrl+"/list_page_org.html",
		tz:Constants.htmlContentUrl+"/list_page_rz.html",
		com:Constants.htmlContentUrl+"/list_page_com.html",
		index_manager:Constants.htmlContentUrl+"/index_manager.html",
		index_senior:Constants.htmlContentUrl+"/index_senior.html",
		index_external:Constants.htmlContentUrl+"/index_external.html",
	}



