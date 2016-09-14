<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>投资人</title>
    <base href="<%=basePath%>">
<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
</head>
<body>
  <%@ include file="/WEB-INF/views/common/header.jsp"%>
    <div class="head_bj">
    
    	<div class="head_center">
        	<div class="m_center">
            	<div class="head_portrait_img"><img src="${entity.icon}"></div>
                <div class="head_center_message">
                    <ul class="list-unstyled introduce_ul_t5">
                        <li><span class="block_left introduce_size18 name">${entity.name}</span><span class="block_left color_blue margin_top5 bj_white">投资人</span></li>
                        <li>
                        	<span class="block_left ico_company"></span>
                            <span class="block_left">${entity.investfirmName}-${entity.investfirmPostionName}</span>
                        </li>
                        <li>
                        <span class="block_left ico_location"></span>
                        <span class="block_left">${entity.local}</span>
                        </li>
                        <!-- <li><div class="blue_button"><span class="block_left ico_star"></span>关注</div></li> -->
                    </ul>
                </div>
            </div>
            
        </div>
    </div>
    <div class="center_all">
    	<div class="center_all_border">
            <div class="title_all">
                <div class="title_name">简介</div>
            </div>
            <div class="title_all_js"><div class="bj_dot"></div>${entity.description}</div>
            <!--投资案例-->
  <!--           <div class="bi_color_gray">
                <div class="bj_color_gren"></div>
                <div class="title_js_name">投资案例</div>
            </div>
            <div class="title_all_js">
                 <ul class="list-unstyled introduce_ul_left position">
                    <li><div class="bj_dot"></div>滴滴打车</li>
                    <li><div class="bj_dot"></div>滴滴打车</li>
                </ul>
            </div> -->
            <!--工作经历-->
            <div class="bi_color_gray">
                <div class="bj_color_gren"></div>
                <div class="title_js_name" data-id="${entity.id}">工作经历</div>
            </div>
            <div class="title_all_js">
                 <ul class="list-unstyled introduce_ul_left position" data-list='joblis'>
                    <li><div class="bj_dot"></div>暂无数据</li>
                </ul>
            </div>
            <!--教育经历-->
            <div class="bi_color_gray">
                <div class="bj_color_gren"></div>
                <div class="title_js_name">教育经历</div>
               
            </div>
            <div class="title_all_js">
                 <ul class="list-unstyled introduce_ul_left style_border_ul" data-list='studylis'>
                    <li>暂无数据 </li>
                </ul>
            </div>
            <!--机构相关人物-->
            
            <div class="bi_color_gray">
                <div class="bj_color_gren"></div>
                <div class="title_js_name member" id="${entity.investfirmId}">机构相关人物</div>
               
              
            </div>
            <div class="title_all_js">
                <ul class="list-unstyled introduce_ul_left img_ico_height" data-list='investor-ui'>
                    <!-- <li>
                        <div class="block_left"><img src="img/default3.gif"></div>
                        <div class="block_left">杨晓</div>
                        <div class="block_left color_gray">合伙人</div>
                    </li>
                    <li>
                        <div class="block_left"><img src="img/default3.gif"></div>
                        <div class="block_left">杨晓</div>
                        <div class="block_left color_gray">合伙人</div>
                    </li> -->
                </ul>
            </div>
            
    
        </div>
        
    	
    </div>
    
</body>
  <script src="<%=request.getContextPath() %>/js/member.js"></script>
</html>