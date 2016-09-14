<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit"/>
 <title>登录</title>
 <base href="<%=basePath%>">
    <!-- Bootstrap -->
    
<!-- jsp文件头和头部 -->
<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
</head>
<body style=" background:url(img/bj.jpg) no-repeat;background-size:cover;">
   <div class="log_tit"><img src="img/saasa_03.png"></div>
   <div class="wicket">
   		<div class="log_in">
            
               <div class="form-group group">
                    <input type="text" name="nickName" class="ico_log_close" id="nickName" placeholder="请输入用户名">
                </div>
                <div class="form-group group">
                    <input type="password" name="password" class="ico_log_open" id="password" placeholder="请输入密码">
                </div>
                
            <div class="log_button " onclick="login()">登录</div>
        </div>
   </div>
</body>
<script type="text/javascript" src="js/json2.js"></script>
<script type="text/javascript" src="js/base64.js"></script>
<script type="text/javascript" src="js/login.js"></script>
</html>
