<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
 <title>投资详情</title>
 <base href="<%=basePath%>">
<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
</head>
  <body>
   <%@ include file="/WEB-INF/views/common/header.jsp"%>
    <div class="head_bj">
    	<div class="head_center">
        	<div class="head_center_img"><img src="img/default2.gif"></div>
            <div class="head_center_message">
            	<ul class="list-unstyled introduce_ul">
                	<li><span class="block_left introduce_size18">${entity.title}</span><!-- <span class="block_left margin_top5 color_red">（尚未获投）</span> --></li>
                    <li id='detail_region'>
                        <span class="block_left" id='detail_region_industryName'>暂无</span>
                        <span class="block_left ico_arrow"></span>
                        <span class="block_left" id='detail_region_industrySubName'>暂无</span>
                        <span class="block_left left_30px" id='detail_region_districtName'>暂无</span>
                        <span class="block_left ico_arrow"></span>
                        <span class="block_left" id='detail_region_districtSubName'>暂无</span>
                    </li>
                    <li>
                    <span class="block_left ico_screen"></span>
                    <span class="block_left" id='weblink'>
                    	
                    </span>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div class="center_all">
    	<div class="center_all_border">
            <div class="title_all">
                <div class="title_name" data-id="${entity.id}">简介</div>
            </div>
            <div class="title_all_js" ><div class="bj_dot"></div>
            	<span id='companyName'></span>
            </div>
            <!--信息-->
            <div class="bi_color_gray">
                <div class="bj_color_gren"></div>
                <div class="title_js_name">获投信息</div>
            </div>
            <div class="title_all_js" >
            	<table class="table table-hover" data-list='joblis'>
                   	<thead>
                        <tr>
                          <th class="color_gray">获投时间</th>
                          <th class="color_gray">投资轮次</th>
                          <th class="color_gray">投资金额</th>
                          <th class="color_gray">投资方</th>
                        </tr>
                      </thead>
                      <tr id='delete_rt' style='display:none'><td colspan=4>暂无数据</td></tr>
                      
             	</table>
            </div>
            <!--团队信息-->
            <div class="bi_color_gray">
                <div class="bj_color_gren"></div>
                <div class="title_js_name">团队信息</div>
            </div>
            <div class="title_all_js"><div class="bj_dot"></div>
            	暂无数据
               
                <!-- <ul class="list-unstyled introduce_ul_left img_ico_height">
                    <li>
                        <div class="block_left"><img src="img/default3.gif"></div>
                        <div class="block_left">杨晓</div>
                        <div class="block_left color_gray">合伙人</div>
                    </li>
                    <li>
                        <div class="block_left"><img src="img/default3.gif"></div>
                        <div class="block_left">杨晓</div>
                        <div class="block_left color_gray">合伙人</div>
                    </li>
                </ul> -->
            </div>
            <!--公司信息-->
            <div class="bi_color_gray">
                <div class="bj_color_gren"></div>
                <div class="title_js_name">公司信息</div>
            </div>
            <div class="title_all_js"><div class="bj_dot"></div>
            	<span id='companyName_2'></span>
            </div>
        
        
    </div>
    </div>
    
</body>
</html>
<script src="js/project_detail.js"></script>