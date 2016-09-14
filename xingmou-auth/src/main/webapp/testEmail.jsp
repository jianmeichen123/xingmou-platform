<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="<%=request.getContextPath() %>/js/jquery-1.12.3.min.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<style>
h2{ text-align:center}
.submit{ height:30px; width:66px;}
textarea{ width:400px; min-height:200px}
.input{width:400px;}
table{ background-color:#ccc; width:600px; overflow:hidden; margin-left:auto; margin-right:auto;}
	table .td_r{text-align:right; float:left; width:120px;}
</style>
<h2>测试纯文本邮件</h2>
<form  id="form1" >
		<table width="100%" border="0">
			<tr>
				<td class='td_r'>收件人 </td>
				<td><input class='input' type="text" name="toAddress" value="1175691309@qq.com" style="height:30px;"></td>
			</tr>
			<tr>
				<td class='td_r'>标题   </td>
				<td><input class='input' type="text" name="title" value="测试纯文本发送" style="height:30px;"></td>
			</tr>
			<tr>
				<td class='td_r'>正文  </td>
				<td><textarea  name="content" >测试纯文本发送测试纯文本发送测试纯文本发送</textarea></td>
			</tr>
			<tr>
				<td align='center' colspan='2'><input class='submit'  type="button" onclick="test1()" value="提交" id="asf" ></td>
			</tr>
		</table>
	</form> 
<h2>测试正文HTML</h2>
<form  id="form2">
		<table width="100%" border="0">
			<tr>
				<td class='td_r'>收件人</td>
				<td><input type="text" class='input'  name="toAddress" value="1175691309@qq.com" style="height:30px;"></td>
			</tr>
			<tr>
				<td class='td_r'>标题</td>
				<td><input  class='input'  type="text" name="title" value="测试正文HTML" style="height:30px;"></td>
			</tr>
			<tr>
				<td class='td_r'>正文</td>
				<td><textarea  name="content"  ><p>测试正文HTML</p><p>测试正文HTML</p></textarea></td>
			</tr>
			<tr>
				<td align='center' colspan='2'><input class='submit' type="button" onclick="test2()" value="提交"></td>
			</tr>
		</table>
	</form> 
<h2>测试多人发送</h2>
<form  id="form3">
		<table width="100%" border="0">
			<tr>
				<td class='td_r'>收件人</td>
				<td><input type="text" class='input' name="toAddress" value="1175691309@qq.com;13136698313@163.com" style="height:30px;"></td>
			</tr>
			<tr>
				<td class='td_r'>标题</td>
				<td><input  class='input'  value="测试多人发送" type="text" name="title" style="height:30px;"></td>
			</tr>
			<tr>
				<td class='td_r'>正文</td>
				<td><textarea  name="content"  >测试多人发送测试多人发送测试多人发送</textarea></td>
			</tr>
			<tr>
				<td align='center' colspan='2'><input class='submit' type="button" onclick="test3()" value="提交"></td>
			</tr>
		</table>
	</form> 
<h2>测试带附件邮件</h2>
<form id="form4"  >
		<table width="100%" border="0">
			<tr>
				<td class='td_r'>收件人</td>
				<td><input type="text" class='input' name="toAddress" value="1175691309@qq.com" style="height:30px;"></td>
			</tr>
			<tr>
				<td class='td_r'>标题</td>
				<td><input  class='input'  type="text" name="title" value="测试纯文本发送" style="height:30px;"></td>
			</tr>
			<tr>
				<td class='td_r'>附件地址</td>
				<td><input type="file"  class='input'  name="attachFile"  id="test2"   style="height:30px;">
				</td>
			</tr>
			<tr>
				<td class='td_r'>正文</td>
				<td><textarea  name="content" >测试带附件邮件测试带附件邮件测试带附件邮件测试带附件邮件</textarea></td>
			</tr>
			<tr>
				<td align='center' colspan='2'><input class='submit' type="button" onclick="test4()" value="提交"></td>
			</tr>
			
		</table>
	</form> 
</body>
<script  type="text/javascript">

function test1(){
	var array = $("#form1 input");
	var toAddress = array[0].value;
	var title = array[1].value;
	var content = $("#form1 textarea")[0].value;
	var data = {"toAddress":toAddress,"title":title,"content":content};
	  $.ajax({
	      cache: true,
	      type: "POST",
	      url:"./galaxy/mail/test1",
	      data : JSON.stringify(data),
		  contentType : "application/json; charset=UTF-8",
	      async: false,
	      success: function(data) {
	          alert(data.result);
	      }
	  });
}
function test2(){
	var array = $("#form2 input");
	var toAddress = array[0].value;
	var title = array[1].value;
	var content = $("#form2 textarea")[0].value;
	var data = {"toAddress":toAddress,"title":title,"content":content};
	 $.ajax({
	      cache: true,
	      type: "POST",
	      url:"./galaxy/mail/test2",
	      data : JSON.stringify(data),
		  contentType : "application/json; charset=UTF-8",
	      async: false,
	      success: function(data) {
	          alert(data.result);
	      }
	  }); 
}
function test3(){
	var array = $("#form3 input");
	var toAddress = array[0].value;
	var title = array[1].value;
	var content = $("#form3 textarea")[0].value;
	var data = {"toAddress":toAddress,"title":title,"content":content};
	 $.ajax({
	      cache: true,
	      type: "POST",
	      url:"./galaxy/mail/test3",
	      data : JSON.stringify(data),
		  contentType : "application/json; charset=UTF-8",
	      async: false,
	      success: function(data) {
	          alert(data.result);
	      }
	  }); 
}
function test4(){
	var array = $("#form4 input");
	var toAddress = array[0].value;
	var title = array[1].value;
	var content = $("#form4 textarea")[0].value;
	var attachFile = array[2].value;
	var data = {"toAddress":toAddress,"title":title,"content":content,"attachFile":attachFile};
	 $.ajax({
	      cache: true,
	      type: "POST",
	      url:"./galaxy/mail/test4",
	      data : JSON.stringify(data),
		  contentType : "application/json; charset=UTF-8",
	      async: false,
	      success: function(data) {
	          alert(data.result);
	      }
	  }); 
}

</script> 
</html>