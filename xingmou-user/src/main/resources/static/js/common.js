var index_href = htmlPlatformUrl.index_normal
if(getCookie("_uid_")){
    me()
}

function me(){
	$.ajax({
        url : platformUrl.me,
        type : "GET",
        cache : false,
        contentType : "application/json; charset=UTF-8",
        async : false,
        error : function(request) {
        	index_href = htmlPlatformUrl.index_normal
        },
        success : function(data) {
        	var entity = JSON.parse(decodeURIComponent(data))
        	if(entity.roleCode ==10000 ){
        		index_href = htmlPlatformUrl.index_manager
        		return
        	}
        	if(entity.roleCode == 20000){
        		index_href = htmlPlatformUrl.index_senior
        		return
        	}
        	if(entity.roleCode == 30000 ){
        		index_href = htmlPlatformUrl.index_external
        		return
        	}
        }
    });
}
function getCookie(c_name)
{
	if (document.cookie.length>0)
	{
		c_start=document.cookie.indexOf(c_name + "=")
		if (c_start!=-1)
		{
            c_start=c_start + c_name.length+1
            c_end=document.cookie.indexOf(";",c_start)
            if (c_end==-1) c_end=document.cookie.length
            return unescape(document.cookie.substring(c_start,c_end))
        }
	}
	return ""
}

function setCookie(c_name,value,expiredays)
{
    var exdate=new Date()
    exdate.setDate(exdate.getDate()+expiredays)
    document.cookie=c_name+ "=" +escape(value)+
    ((expiredays==null) ? "" : ";expires="+exdate.toGMTString())
}

function removeCookie(c_name){
  setCookie(c_name, 1, -1);
}
/**
 * 发送post请求
 * 
 * @param reqUrl
 *            请求地址
 * @param jsonObj
 *            请求json对象
 * @param sessionId
 *            请求头中需携带的sessionid
 * @param callbackFun
 *            处理成功后的回调方法
 */

function sendPostRequestByJsonObj(reqUrl, jsonObj, callbackFun) {
	$.ajax({
		url : reqUrl,
		type : "POST",
		data : JSON.stringify(jsonObj),
		dataType : "json",
		cache : false,
		contentType : "application/json; charset=UTF-8",
		beforeSend : function(xhr) {
			// if (sessionId) {
			// xhr.setRequestHeader("sessionId", sessionId);
			// }
			// if(userId){
			// xhr.setRequestHeader("guserId", userId);
			// }
		},
		async : false,
		error : function(request) {
			// alert("connetion error");
		},
		success : function(data) {
			if (data) {
				var type = typeof (data);
				if (type == 'string') {
					if (data.indexOf("<!DOCTYPE html>")) {
						location.href = platformUrl.toLoginPage;
					}
				}
			}
			/*
			 * if(data.hasOwnProperty("result")&&data.result.errorCode=="3"){
			 * location.href = platformUrl.toLoginPage; }
			 */
			if (callbackFun) {
				callbackFun(data);
			}
		}
	});
}
/**
 * 发送post请求
 * 
 * @param reqUrl
 *            请求地址
 * @param jsonStr
 *            请求json字符串
 * @param sessionId
 *            请求头中需携带的sessionid
 * @param callbackFun
 *            处理成功后的回调方法
 */
function sendPostRequestByJsonStr(reqUrl, jsonStr, callbackFun) {
	sendPostRequestByJsonObj(reqUrl, JSON.parse(jsonStr), callbackFun);
}

/**
 * 发送get请求
 * 
 * @param reqUrl
 *            请求地址
 * @param jsonObj
 *            请求json对象
 * @param sessionId
 *            请求头中需携带的sessionid
 * @param callbackFun
 *            处理成功后的回调方法
 */
function sendGetRequest(reqUrl, jsonObj, callbackFun) {
	$.ajax({
		url : reqUrl,
		type : "GET",
		data : jsonObj,
		dataType : "json",
		cache : false,
		contentType : "application/json; charset=UTF-8",
		beforeSend : function(xhr) {
			/*
			 * if (sessionId) { xhr.setRequestHeader("sessionId", sessionId); }
			 * if(userId){ xhr.setRequestHeader("guserId", userId); }
			 */
		},
		async : false,
		error : function(request) {
			// alert("connetion error");
		},
		success : function(data) {
			if (data) {
				var type = typeof (data);
				if (type == 'string') {
					if (data.indexOf("<!DOCTYPE html>")) {
						location.href = platformUrl.toLoginPage;
					}
				}
			}
			/*
			 * if(data.hasOwnProperty("result")&&data.result.errorCode=="3"){
			 * location.href = platformUrl.toLoginPage; }
			 */
			if (callbackFun) {
				callbackFun(data);
			}
		}
	});
}
/**
 * 发送post请求
 * 
 * @param reqUrl
 *            请求地址
 * @param sessionId
 *            请求头中需携带的sessionid
 * @param callbackFun
 *            处理成功后的回调方法
 */
function sendPostRequest(reqUrl, callbackFun) {
	$.ajax({
		url : reqUrl,
		type : "POST",
		cache : false,
		contentType : "application/json; charset=UTF-8",
		/*beforeSend : function(xhr) {
			if (sessionId) {
				xhr.setRequestHeader("sessionId", sessionId);
			}
			if (userId) {
				xhr.setRequestHeader("guserId", userId);
			}
		},*/
		async : false,
		error : function(request) {
			// alert("connetion error");
		},
		success : function(data) {
			if (data) {
				var type = typeof (data);
				if (type == 'string') {
					if (data.indexOf("<!DOCTYPE html>")) {
						location.href = platformUrl.toLoginPage;
					}
				}
			}
			/*
			 * if(data.hasOwnProperty("result")&&data.result.errorCode=="3"){
			 * location.href = platformUrl.toLoginPage; }
			 */
			if (callbackFun) {
				callbackFun(data);
			}
		}
	});
}

/**
 * url:统一跳转url
 * 
 */
function forwardWithHeader(url) {
	window.location.href = url;
	/*if (url.indexOf("?") == -1) {
		window.location.href = url + "?sid=" + sessionId + "&guid=" + userId;
		return false;
	} else {
		window.location.href = url + "&sid=" + sessionId + "&guid=" + userId;
		return false;
	}*/
}

/*function forwardIndexWithHeader(url, sessionId, userId) {
	if (url.indexOf("?") == -1) {
		window.location.href = url + "?sid=" + sessionId + "&guid=" + userId;
	} else {
		window.location.href = url + "&sid=" + sessionId + "&guid=" + userId;
	}
}*/

/**
 * 使用localstage存储数据 <br/>
 * 注意：IE、Firefox测试的时候需要把文件上传到服务器上（或者localhost），直接点开本地的HTML文件，是不行的。
 * 
 * DataStrore.
 */
DataStrore = {
	storage : window.localStorage,
	checkBrowerSupport : function() {
		if (window.localStorage) {
			alert('This browser supports localStorage');
			return true;
		} else {
			alert('This browser does not support localStorage');
			return false;
		}
	},
	addElement : function(key, value) {
		dataStrore.stroage.setItem(key, value);
	},
	getElement : function(key) {
		dataStrore.stroage.getItem(key);
	},
	removeElement : function(key) {
		dataStrore.stroage.removeItem(key);
	},
	removeAll : function() {
		dataStrore.stroage.clear();
	},
	showKeysAndValues : function() {
		for (var i = 0; i < dataStrore.storage.length; i++) {
			document.write(storage.key(i) + " : "
					+ storage.getItem(storage.key(i)) + "<br>");
		}
	}
}
function delHtmlTag(str) {
	if (str) {
		return str.replace(/<[^>]+>/g, "");// 去掉所有的html标记
	}
}
/* 数字千分符 */
function rendererZhMoney(v) {
	if (isNaN(v)) {
		return v;
	}
	/*
	 * v = (Math.round((v - 0) * 100)) / 100; v = (v == Math.floor(v)) ? v +
	 * ".00" : ((v * 10 == Math.floor(v * 10)) ? v + "0" : v); v = String(v);
	 * var ps = v.split('.'); var whole = ps[0]; var sub = ps[1] ? '.' + ps[1] :
	 * '.00'; var r = /(\d+)(\d{3})/; while (r.test(whole)) { whole =
	 * whole.replace(r, '$1' + ',' + '$2'); } v = whole + sub;
	 */
	return v;
}
function ZhMoney(v) {
	if (isNaN(v)) {
		return v;
	}
	v = Math.abs(v);
	if (v * 0.00000001 >= 1) {
		return rendererZhMoneyyi(v);
	} else if (v * 0.000000 >= 1 && v * 0.00000001 < 1) {
		return rendererZhMoneyQianWan(v);
	} else if (v * 0.0001 >= 1 && v * 0.000000 < 1) {
		return rendererZhMoneyWan(v);
	} else {
		return rendererZhMoney(v);
	}
}
/* 转为以万为单位 */
function rendererZhMoneyWan(v) {
	if (isNaN(v)) {
		return v;
	}
	v = v * 0.0001;// 10000;
	v = parseInt(v);
	rendererZhMoney(v);
	return v + "万";
}
/* 转为以千万为单位 */
function rendererZhMoneyQianWan(v) {
	if (isNaN(v)) {
		return v;
	}
	v = v * 0.0000001;// 10000000;
	v = parseInt(v);
	rendererZhMoney(v);
	return v + "千万";
}

function rendererZhMoneyyi(v) {
	if (isNaN(v)) {
		return v;
	}
	v = v * 0.00000001;// 100000000;
	v = parseInt(v);
	rendererZhMoney(v);
	return v + "亿";
}
function changeTwoDecimal_f(x) {
	var f_x = parseFloat(x);
	if (isNaN(f_x)) {
		return "-";
	}
	var f_x = Math.round(x * 100) / 100;
	var s_x = f_x.toString();
	var pos_decimal = s_x.indexOf('.');
	if (pos_decimal < 0) {
		pos_decimal = s_x.length;
		s_x += '.';
	}
	while (s_x.length <= pos_decimal + 2) {
		s_x += '0';
	}
	return s_x+"%";
}


/**
 * 发送get请求
 * 
 * @param reqUrl
 *            请求地址
 * @param jsonObj
 *            请求json对象
 * @param sessionId
 *            请求头中需携带的sessionid
 * @param callbackFun
 *            处理成功后的回调方法
 */
function sendLuaRequest(reqUrl, callbackFun) {
	$.ajax({
		url : reqUrl,
		type : "GET",
		dataType : "json",
		cache : false,
		beforeSend : function(xhr) {
			/*
			 * if (sessionId) { xhr.setRequestHeader("sessionId", sessionId); }
			 * if(userId){ xhr.setRequestHeader("guserId", userId); }
			 */
		},
		async : false,
		error : function(request) {
			// alert("connetion error");
		},
		success : function(data) {
			if (data) {
				var type = typeof (data);
				if (type == 'string') {
					if (data.indexOf("<!DOCTYPE html>")) {
						location.href = platformUrl.toLoginPage;
					}
				}
			}
			/*
			 * if(data.hasOwnProperty("result")&&data.result.errorCode=="3"){
			 * location.href = platformUrl.toLoginPage; }
			 */
			if (callbackFun) {
				callbackFun(data);
			}
		}
	});
}
function getHrefParamter(name){
    var url=decodeURI(location.search);
    var q = url.substr(1);
    var qs = q.split("&");
    if (qs) {
        for (var i = 0; i < qs.length; i++) {
            if (qs[i].substring(0, qs[i].indexOf("=")) == name) {
                var ss = qs[i].substring(qs[i].indexOf("=") + 1)
                return ss;
            }
        }
    }
}
//导航位置定位
function nav_locaton(first_level,second_level,three_level,four_level){
	 $('.nav_all [page_tab='+first_level+']').addClass("nav_on");
	 $('.nav_two [page_tab='+second_level+']').addClass("nav_on");
	 $('.nav_list_data [page_tab='+second_level+']').addClass("nav_on");
	 if(three_level !=''){
		 $('.column_ul [page_tab='+three_level+']').addClass("nav_on");
	 }
	 if(four_level !=''){
		 $('.project_nav [page_tab='+four_level+']').addClass("nav_on");
	 }
}
//创投数据库
$('body').delegate('.nav_list_data_all','mouseenter mouseleave', function(event){
	event.stopPropagation();
	if(event.type == "mouseenter"){
		$('.nav_list_data_all .nav_list_data').addClass("nav_list_data_on");
	}else if(event.type == "mouseleave" ){
		$('.nav_list_data_all .nav_list_data').removeClass("nav_list_data_on");
	}
})
//名字事件
$('body').delegate('.nav_all_name','mouseenter mouseleave', function(event){
	event.stopPropagation();
	if(event.type == "mouseenter"){
		$('.nav_all_name .brain_ico_name').addClass("brain_ico_name_on");
		$('.list_click_ul').show();		
	}else if(event.type == "mouseleave" ){
		$('.nav_all_name .brain_ico_name').removeClass("brain_ico_name_on");
		$('.list_click_ul').hide();
	}
})

//导航搜索相关
$('body').delegate('.dn_ico_search','click', function(event){
	event.stopPropagation();
	$(".info-search .hot_speech").hide(); 
	$('.nav_all_seek').hide();
	$('.nav_all_input').show();
	$('#nav_all_input').focus();
	$("#executive_pop").hide();
	$("#trade_pop").hide();
})
function com(){
  location.href= htmlPlatformUrl.com						
}
function tz(){
	  location.href=htmlPlatformUrl.tz						
}
function org(){
	  location.href=htmlPlatformUrl.org
}
function startup(){
	  location.href= htmlPlatformUrl.startup						
}
function investor(){
	  location.href= htmlPlatformUrl.investor					
}
function register_page(){
	location.href= platformUrl.toRegister
}
function login_page(){
	location.href= platformUrl.toLoginPage
}
function news_head(){
	location.href= htmlPlatformUrl.news_head
}
function report(){
	location.href= htmlPlatformUrl.report
}
function evaluating(){
	location.href= htmlPlatformUrl.evaluating
}
function search_head(){
	window.open(htmlPlatformUrl.search_finance, "_blank"); 
}
function index_head(){
	location.href=index_href
}
function logout(){
	location.href=platformUrl.logout
}
function find_password_page(){
	location.href=platformUrl.forgetPassword
}
//密码遮罩
$('#password_eye').click(function(){
	 $(this).toggleClass('login-eye-abled')
	 if($(this).hasClass('login-eye-abled')){
		 $('#password').attr('type','text')
	 }else{
		 $('#password').attr('type','password')
	 }
})
$('#confirmpassword_eye').click(function(){
	 $(this).toggleClass('login-eye-abled')
	 if($(this).hasClass('login-eye-abled')){
		 $('#confirmPassword').attr('type','text')
	 }else{
		 $('#confirmPassword').attr('type','password')
	 }
})
 $("#globalsearch_index").on("click",function(){
           var value = $("input[data-search='globalsearch_index']").val()
           if(value.trim() != ""){
              location.href = htmlPlatformUrl.search+"?keyword="+value
           }

 })
 $("input[data-search='globalsearch_index']").bind('keypress',function(event){
          var value =  $("input[data-search='globalsearch_index']").val()
               if(value.trim() != "") {
                 if(event.keyCode == '13'){
                      location.href =  htmlPlatformUrl.search+"?keyword="+value
                 }
               }
 });

 $(".hotKeyword").delegate("li","click",function(){
  	var value = $(this).text();
	   if(value.trim() != "") {
			  location.href =  htmlPlatformUrl.search+"?keyword="+value
	   }
});