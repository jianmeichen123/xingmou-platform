/**
 * 
 */
var timer;
var count;
var $btn;
function countDown()
{
	count--;
	console.log(count);
	$btn.html("验证码"+count+"s");
//	$btn.addClass('disabled_btn')
	if(count<=0)
	{
		$btn.removeClass("disabled");
		$btn.text("重新获取");
        clearInterval(timer);
	}
}

function send_code(e,type){
	$('.login-tips').css('display','none')
	$('input').removeClass('inputDanger');
	$('input').removeClass('invalid');
	
	var val = $('#mobile').val()
	if(val == null || val.trim().length == 0)
	{
		$("#mobile").addClass('inputDanger');
		$("#mobile").addClass('invalid');
		$('#mobile_tip').css('display','block').html('请输入登录手机号');
		return;
	}
	if(!/^1[0-9]{10}$/.test(val))
	{
		$("#mobile").addClass('inputDanger');
		$("#mobile").addClass('invalid');
		$("#mobile_tip").css('display','block').html('请输入有效手机号码');
		return;
	}
	if(count<=0)
	{	
		e.setAttribute('onclick','send_code(this)')
		$('#find_code').html("重新获取");
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
//	var url = orderUrl.checkUserExists;
//	var data = {phoneNumber:val};
//	var callback = function(data){
//		if(data.result.status=='OK')
//		{
//			if(data.userData.exists == true)
//			{
//				$this.parent().append('<span class="xh_y m_l_10 error">该手机号码已被注册</span>');
//			}
//		}
//	};
//	$.ajaxPost(url,JSON.stringify(data),callback);
});