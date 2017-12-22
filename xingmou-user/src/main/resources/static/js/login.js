
function checkform(){
	  var nickName =$("#nickName").val();
	  var password =$("#password").val();
	    
	    if(nickName==""){
	    	$("#nickName").addClass('inputDanger');
	    	$("#nickName").addClass('invalid');
			if($("#nickName").hasClass('valid')){
				$("#nickname").removeClass('inputDanger');
				$("#nickname").removeClass('invalid');
			}
			$("#nickname_tip").css('display','block').html("请输入登录用户名/手机号")
	        return false;
	    } 
	    if(password==""){
	    	$("#password").addClass('inputDanger');
	    	$("#password").addClass('invalid');
			if($("#password").hasClass('valid')){
				$("#password").removeClass('inputDanger');
				$("#password").removeClass('invalid');
			}
			$("#password_tip").css('display','block').html("请输入登录密码")
	        return false;
	    }
	    return true;
 }

 function login(){
	$("#nickname").removeClass('inputDanger');
	$("#nickname").removeClass('invalid');
	$("#password").removeClass('inputDanger');
	$("#password").removeClass('invalid');
	$('.login-tips').css('display','none')
    if (!checkform()){return};
	 
     //判断是否勾选了自动登录
   
    var nickName = $("#nickName").val();
    if(/^1[0-9]{10}$/.test(nickName)){
    	login_password();
    	return
    }
    var b = new Base64();
    var nickName = b.encode($("#nickName").val());
    var password = b.encode($("#password").val());
    var jsonData={"nickName":nickName,"password":password};
    if (!$("#autoLogin").prop('checked')){
        sendPostRequestByJsonObj(platformUrl.toLogin+"?notAuto=true",jsonData,logincallback);
        return
    }

     sendPostRequestByJsonObj(platformUrl.toLogin,jsonData,logincallback);
		 
		 
  }
 
 
 function logincallback(data){
	 if(data.result.status=="OK"){
		 var entity = data.entity
		 if(entity.roleCode == 10000||entity.roleCode == 30000){ //投机经理
			 location.href = htmlPlatformUrl.index_manager
			 return
		 }
		 if(entity.roleCode == 20000){ //高管
			 location.href = htmlPlatformUrl.index_senior
			 return
		 }
		 if(!entity.roleCode){ //外部用户
			 location.href = htmlPlatformUrl.index_external
			 return
		 }

	 }else{
	     layer.msg(data.result.message)
	 }
 }
 function keylogin(){
	 if (event.keyCode == 13)
	  {
	    login();
	  }
 }
 //外部用户密码登录u
function login_password(){
    var nickName = $("#nickName").val();
    var password = $("#password").val();
    var jsonData={"mobile":nickName,"password":password};
    var login_password_callback=function(data){
    	 if(data.result.status=="OK"){
    			 location.href = htmlPlatformUrl.index_external
    	 }else{
    		 var error_code = data.result.errorCode
    		 if(error_code!=null && error_code=='1'){
    			 $("#nickName").addClass('inputDanger');
				 $("#nickName").addClass('invalid');
    		 }
    	     layer.msg(data.result.message)
    	 }
    }
    if (!$("#autoLogin").prop('checked')){
        sendPostRequestByJsonObj(platformUrl.loginByPassword+"?notAuto=true",jsonData,login_password_callback);
        return
    }	
    sendPostRequestByJsonObj(platformUrl.loginByPassword,jsonData,login_password_callback);
}
 $('#login_eye').click(function(){
	 $(this).toggleClass('login-eye-abled')
	 if($(this).hasClass('login-eye-abled')){
		 $('#password').attr('type','text')
	 }else{
		 $('#password').attr('type','password')
	 }
 })

//单独进行验证，高亮
	$('#nickName').blur(function(){
		var _this = $(this);
		var val= $(this).val()
		if(val == null || val.trim().length==0){
			_this.addClass('inputDanger');
			_this.addClass('invalid');
		}
		if(_this.hasClass('valid')){
			_this.removeClass('inputDanger');
			_this.removeClass('invalid');
		}
	});
	$('#nickName').focus(function(){
		var _this = $(this);
		$("#nickname_tip").attr('style','none')
		_this.removeClass('inputDanger');
		_this.removeClass('invalid');
	});
	$('#password').blur(function(){
		var _this = $(this);
		var val= $(this).val()
		if(val == null || val.trim().length==0){
			_this.addClass('inputDanger');
			_this.addClass('invalid');
		}
		if(_this.hasClass('valid')){
			_this.removeClass('inputDanger');
			_this.removeClass('invalid');
		}
	});
	$('#password').focus(function(){
		var _this = $(this);
		$("#password_tip").attr('style','none')
		_this.removeClass('inputDanger');
		_this.removeClass('invalid');
	});
//	var timer;
//	var count;
//	var $btn;
//	function countDown()
//	{
//		count--;
//		console.log(count);
//		$btn.text(count+"s");
//		if(count<=0)
//		{
//			$btn.removeClass("disabled");
//			$btn.text("重新获取");
//	        clearInterval(timer);
//		}
//	}
//	$("#login_code").click(function(){
//		clearInterval(timer);
//		$btn = $(this);
//		count=60
//		$(this).addClass('disabled')
//		timer = setInterval("countDown()",1000);
//	})
	function login_bycode(){
		var mobile =$('#mobile').val()
		var code = $('#code').val()
		var jsonData = {"mobile" : mobile,"code":code}
		sendPostRequestByJsonObj(platformUrl.loginByCode,jsonData,loginByCodecallback);
	}
	function loginByCodecallback(data){
		if(data.result.status=="OK"){
				location.href = htmlPlatformUrl.index_external
		 }else{
		     layer.msg(data.result.message)
		 }
	}
	var timer;
	var count;
	var $btn;
	function send_code(e,type){
		var val = $('#mobile').val()
		if(val == null || val.trim().length == 0)
		{
			$("#mobile_tip").css('display','inline').html('请输入登录手机号');
			return;
		}
		if(/^[0-9a-zA-Z]{6-14}$/.test(val))
		{
			$("#mobile_tip").css('display','inline').html('请输入有效手机号码');
			return;
		}
		if(count<=0)
		{	
			e.setAttribute('onclick','send_code(this)')
			$('#login_code').html("重新获取");
	        clearInterval(timer);
		}else{
			clearInterval(timer);
			$btn = $(e);
			var jsonData = {"mobile" : val,"type":type}
			var success=function(data){
				if(data.result.status=="OK"){
					count=60
					e.removeAttribute('onclick','')
					timer = setInterval("countDown()",1000);
				}else{
					$("#mobile_tip").css('display','inline').html('您输入账号不存在~');
					layer.msg('您输入账号不存在~')
				}
			}
			sendPostRequestByJsonObj(platformUrl.sendCode,jsonData,success);
		}
	}
	function countDown()
	{
		count--;
		console.log(count);
		$btn.html("验证码"+count+"s");
//		$btn.addClass('disabled_btn')
		if(count<=0)
		{
			$btn.removeClass("disabled");
			$btn.text("重新获取");
	        clearInterval(timer);
		}
	}
	$("#mobile").change(function(){
		var $this = $(this);
		var val = $(this).val();
		if(val == null || val.trim().length == 0)
		{
			$("#mobile_tip").css('display','inline').html('请输入登录手机号1');
			return;
		}
		if(/^[0-9a-zA-Z]{6-14}$/.test(val))
		{
			$("#mobile_tip").css('display','inline').html('请输入有效手机号码');
			return;
		}
		$("#mobile_tip").css('display','none')
	})