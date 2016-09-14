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
<meta name="renderer" content="webkit"/>
 <title>投资详情</title>
 <base href="<%=basePath%>">
<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
</head>
  <body>
   <%@ include file="/WEB-INF/views/common/header.jsp"%>
    <div class="head_bj">
    	<div class="head_center">
        	<div class="head_center_img"><img src="img/ligo_gs.png" data-info="iconBig"></div>
            <div class="head_center_name">
            	<span class="block_left introduce_size18" data-info="name">暂无数据</span>
            </div>
            <!-- <div class="block_right blue_button margin_top50"><span class="block_left ico_star"></span>关注</div> -->
        </div>
    </div>
    <div class="center_all">
    	<div class="center_all_l">
        	<div class="center_all_border">
                <div class="title_all">
                    <div class="title_name" data-id="${entity.id}">基本信息</div>
                </div>
                <div class="title_all_js" data-info="description"><div class="bj_dot"></div>
                暂无数据
                </div>
    			<!--信息-->
                <div class="bi_color_gray">
                    <div class="bj_color_gren"></div>
                    <div class="title_js_name">投资阶段</div>
                </div>
                <div class="title_all_js">
                     <ul class="list-unstyled introduce_ul_left style_border_ul" id="roundil">
                        <li>暂无数据</li>
                    </ul>
                </div>
                <!--投资领域-->
                <div class="bi_color_gray">
                    <div class="bj_color_gren"></div>
                    <div class="title_js_name">投资领域</div>
                </div>
                <div class="title_all_js">
                     <ul class="list-unstyled introduce_ul_left style_border_ul" id="areail">
                        <li>暂无数据</li>
                    </ul>
                </div>
<!--                  投资轮次
                <div class="bi_color_gray">
                    <div class="bj_color_gren"></div>
                    <div class="title_js_name">投资轮次</div>
                </div>
                <div class="title_all_js">
                     <ul class="list-unstyled introduce_ul_left style_border_ul">
                         <li>A轮</li>
                        <li>Pre-A</li>
                    </ul>
                </div> -->
                <!--投资额度-->
                <div class="bi_color_gray">
                    <div class="bj_color_gren"></div>
                    <div class="title_js_name">投资额度</div>
                </div>
                <div class="title_all_js">
                     <ul class="list-unstyled introduce_ul_left">
                         <li>暂无数据</li>
                    </ul>
                </div>
<!--                 投资组合
                <div class="bi_color_gray">
                    <div class="bj_color_gren"></div>
                    <div class="title_js_name">投资组合</div>
                </div>
                <div class="title_all_js">
                     <ul class="list-unstyled introduce_ul_left">
                         <li>2000万美金</li>
                    </ul>
                </div> -->
        		<!--机构成员-->
                <div class="bi_color_gray">
                    <div class="bj_color_gren"></div>
                    <div class="title_js_name">机构成员</div>
                </div>
                <div class="title_all_js" >
                    <ul class="list-unstyled introduce_ul_left img_ico_height" data-list='investor-ui'>
<!--                         <li>
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
        <div class="center_all_r">
        	<!--投资数据-->
        	<div class="center_all_border">
                <div class="title_all">
                    <div class="title_name_color_reddish">投资数据</div>
                </div>
                <div class="title_all_js">
                     <ul class="list-unstyled width_50">
                     	<li>
                        	<div class="color_reddish data_one" data-info='historyNum'>11</div>
                            <div class="data_two">
                            	<span class="block_left ico_history"></span><span class="block_left">历史投资</span>
                            </div>
                        </li>
                        <li>
                        	<div class="color_reddish data_one" data-info='investorNum'>11</div>
                            <div class="data_two">
                            	<span class="block_left ico_institution"></span><span class="block_left" >机构成员</span>
                            </div>
                        </li>
                     </ul>
            	</div>
            </div>
            <!--联系信息-->
        	<div class="center_all_border margin_top20">
                <div class="title_all">
                    <div class="title_name_color_reddish">联系信息</div>
                </div>
                <div class="title_all_js">
                     <ul class="list-unstyled overflow">
                     	<li>
                            <span class="block_left message_one ico_pc"></span><span class="block_left" data-info="link">暂无</span>
                        </li>
                        <li>
                            <span class="block_left message_one ico_moble"></span><span class="block_left" data-info="phone">暂无</span>
                        </li>
                        <li>
                            <span class="block_left message_one ico_mail"></span><span class="block_left" data-info="email">暂无</span>
                        </li>
                     </ul>
            	</div>
            </div>
            
        </div>
    	
    </div>
    
</body>
</html>
<script src="<%=request.getContextPath() %>/js/platformUrl.js"></script>
<script src="<%=request.getContextPath() %>/js/common.js"></script>
<script src="<%=request.getContextPath() %>/js/investfirm_info.js"></script>