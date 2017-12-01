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