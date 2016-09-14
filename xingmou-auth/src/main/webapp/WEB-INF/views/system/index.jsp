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
 <title>首页</title>
 <base href="<%=basePath%>">
<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
</head>
  <body>
    <%@ include file="/WEB-INF/views/common/header.jsp"%>
    <div class="container">
      <div class="row">
        <div class="col-md-12 row1">
          <input type="text" class="time" placeholder="请选择日期" id="datetimepicker">
          <span class="ico time_area b1">时间</span>
          <button class="btn btn-primary btn-sm">确定</button>
        </div>      
      </div>
       <div class="row">
        <div class="col-md-12 row2">
          <span class="pull-left">数据来源：IT桔子</span>
          <span class="pull-right" id="update-time"></span>
        </div>      
      </div> 
      <div class="row row3 clearfix row">
        <div class="pull-left title red" id="month-div">上月</div>
        <div class="pull-right con col-md-11 clearfix">
            <div class="block pull-left col-md-3">
              <dl  whole-month="projectNum">
                <dt class="red">项目数量</dt>
                <dd class="red num">暂无数据</span></dd>
              </dl>
            </div>
            <div class="block pull-left col-md-3">
              <dl whole-month="investMoney">
                <dt class="red">融资金额</dt>
                <dd class="red num">暂无数据</dd>
              </dl>
            </div>
            <div class="block pull-left col-md-3">
              <dl >
                <dt class="red">投资人</dt>
                <dd class="red num" id="investorNum">暂无数据</dd>
              </dl>
            </div>
            <div class="block pull-left col-md-3">
              <dl >
                <dt class="red">投资机构</dt>
                <dd class="red num" id="investfirmNum" >暂无数据</dd>
              </dl>
            </div>
<!--             <div class="block block1 pull-left">
              <dl>
                <dt class="red">创业者</dt>
                <dd class="red num">暂无数据</dd>
              </dl>
            </div> -->
        </div>
      </div>
      <div class="row">
        <div class="col-md-12 row4 chart_name">
          <div class="chart_name"><span class='block_left'>行业投资占比分析</span>
		  <a href='javascript:void(0);' class='block_left'  
title='项目数量：成立的项目数 
投资金额： 
1. 未透漏：计0
2. 模糊金额: 数十万计10万，数百万计100万，数千万计1000万，亿元及以上计1亿
3. 具体金额：具体金额＊投资当日平均汇率
4. 币种为其它 ： 计相等数量人民币'><span  class="b4 block_left tooltips" >帮助</span></a> 
		  </div>
        </div>
        <div class="col-md-12 row5">
          <div class="bs-example bs-example-tabs" data-example-id="togglable-tabs">
            <ul id="myTabs" class="nav nav-tabs tablist">
              <li class="active no1"><a href="#histogram_xmsl" id="home-tab" data-toggle="tab" aria-expanded="true">项目数量</a></li>
              <li><a href="#histogram_tzje" id="profile-tab" data-toggle="tab">投资金额</a></li>
            </ul>
            <div id="myTabContent" class="tab-content">
              <div class="tab-pane fade in active" id="histogram_xmsl" style="width:1170px;height:300px;"></div>
              <div class="tab-pane fade"  id="histogram_tzje" style="width:1170px;height:300px; "></div>
            </div>
          </div>        
        </div>
      </div>
      <div class="row">
        <div class="pull-left charts_area">
          <div class="chart_name"><span class='block_left'>融资轮次占比分析</span><span data-toggle="tooltip" title="每个轮次的成立项目数和占比" class="b4 block_left tooltips" >帮助</span></div>
          <div class="bs-example bs-example-tabs" data-example-id="togglable-tabs">
            <ul id="myTabs1" class="nav nav-tabs tablist">
              <li class="active no1"><a href="#circle_all" id="home-tab" data-toggle="tab" aria-expanded="true">当月</a></li>
<!--               <li><a href="#circle_week" id="profile-tab" data-toggle="tab">当周</a></li>
              <li class="active no1"><a href="#circle_month" id="#circle_all" data-toggle="tab" >当月</a></li> -->
              <li><a href="#circle_year" id="profile-tab" data-toggle="tab">当年</a></li>
            </ul>
            <div id="myTabContent1" class="tab-content">
              <div class="tab-pane fade in active" id="circle_all" style="height:560px;width:570px"></div>
              <div class="tab-pane fade" id="circle_week" style="height:560px;width:570px"></div>
              <div class="tab-pane fade" id="circle_month" style="height:560px;width:570px"></div>
              <div class="tab-pane fade" id="circle_year" style="height:560px;width:570px"></div>
            </div>
          </div>
        </div>
        <div class="pull-right map">
          <div class="chart_name"><span class='block_left'>地区成立项目数分布</span><span data-toggle="tooltip" title="地区成立项目数分布" class="b4 block_left tooltips" >帮助</span></div>
          <div class="bs-example">
            <div id="map" style="width:100%;height:560px;"></div>            
          </div>
        </div>
      </div>
      <div class="row">
        <div class="pull-left charts_area">
          <div class="chart_name">机构关注行业分布</div>
          <div class="bs-example bs1">
              <div id="line_hy" style="width:100%;height:280px;"></div>
          </div>
        </div>
        <div class="pull-right charts_area">
          <div class="chart_name">机构关注投融阶段分布</div>
          <div class="bs-example bs1">
            <div id="line_jd" style="width:100%;height:280px;"></div>        
          </div>
        </div>
      </div>

    </div>
  </body>
 <script src="<%=request.getContextPath() %>/js/echarts.min.js"></script>
 <script src="<%=request.getContextPath() %>/js/china.js"></script>
 <script  src="<%=request.getContextPath() %>/js/echarts_index.js"></script>
 <script type="text/javascript" src="<%=request.getContextPath() %>/js/datetimepicker/bootstrap-datetimepicker.js" charset="UTF-8"></script>
 <script type="text/javascript" src="<%=request.getContextPath() %>/js/datetimepicker/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
 <script src="<%=request.getContextPath() %>/js/index.js"></script>
</html>