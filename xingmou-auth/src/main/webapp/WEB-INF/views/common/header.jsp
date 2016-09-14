<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class='header'>
      <div class="header_cen">
        <div class="header_nav" id="bs-example-navbar-collapse-1">
          <a  action = "index_logo" class="navbar-brand"></a>
          <ul class="nav_header navbar-nav" id='on_click'>
            <li><a action = "index" >首页</a></li>
            <li><a action = "project">项目库</a></li>
            <li><a action = "agency">投资机构</a></li>
            <li><a action = "investEvent">投资事件</a></li>
            <li><a action = "competition">竞情分析</a></li>
          </ul>
          <ul class="navbar-right sign">
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <%=realName%><span>&nbsp;&nbsp;</span>
              </a>
              <ul class="dropdown-menu">
                <li><a href="<%=path %>/html/password.html" data-btn="password" data-name='修改密码'>修改密码</a></li>
                <li><a href="javascript:logout()" class="loginout">退出</a></li>
              </ul>
            </li>
          </ul>
        </div>
      </div>
</div>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/header.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/login.js"></script>

 

