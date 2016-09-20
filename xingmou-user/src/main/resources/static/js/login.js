

function checkform(){
	  var nickName =$("#nickName").val();
	  var password =$("#password").val();
	    
	    if(nickName==""){
			$("#nickName").focus();
	        layer.tips('请输入用户名', '#nickName');
	        return false;
	    } 
	    if(password==""){
			$("#password").focus();
	        layer.tips('请输入密码', '#password');
	        return false;
	    }
	    return true;
 }

 function login(){
	
	 checkform();
	 
		 //判断是否勾选了自动登录
		 var b = new Base64();  
	     var nickName = b.encode($("#nickName").val());  
	     var password = b.encode($("#password").val());  
	     var jsonData={"nickName":nickName,"password":password};
		 sendPostRequestByJsonObj(platformUrl.toLogin,jsonData,logincallback);
		 
		 
  }
 
 
 function logincallback(data){
	 if(data.result.status=="OK"){
		 var sessionId = data.header.sessionId;
		 var userId = data.header.userId;
		 forwardWithHeader(platformUrl.xmcx,sessionId,userId);
		return false;
	 }else{
		 layer.msg(data.result.message);
	 }
 }
 function keylogin(){
	 if (event.keyCode == 13)
	  {
	    login();
	  }
 }
 
 function logout(){
		$.ajax({
			url : platformUrl.logout,
			type : "POST",
			dataType : "json",
			contentType : "application/json; charset=UTF-8",
			async : false,
			beforeSend : function(xhr) {
				if (sessionId) {
					xhr.setRequestHeader("sessionId", sessionId);
				}
				if(userId){
					xhr.setRequestHeader("guserId", userId);
				}
			},
			error : function(request) {
				alert("connetion error");
			},
			success : function(data) {
				if(data.result.status=="OK"){
					location.href=platformUrl.toLoginPage;
				}
			}
		}); 
	} 
