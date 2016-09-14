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
 <title>投资机构</title>
 <base href="<%=basePath%>">
<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
</head>
  <body>
   <%@ include file="/WEB-INF/views/common/header.jsp"%>
<div class="container">
    <div class="panel" style="width:100%;height:450px;">
    	<div class='echarts_l' id='agency_echarts_l' ></div>
    	<div class='echarts_r' id='agency_echarts_r'></div>
	</div>
      <div class="panel" >
        <div class="panel-heading">
          <div class="row">
            <div class="form-group pull-left">
                <input type="text" name="title" class="form-control txt"  placeholder="请输入投资机构名称">
                <button class="sear" action="search"></button>
              </div>
            <div class="col-md-1 pull-right"><span class="more_btn">更多搜索<span class="caret"></span></span></div>            
          </div>          
        </div>

        <div class="panel-body" style="display:none">
          <div class="row">
            <div class="col-md-1 sear_title">领域</div>
            <div class="col-md-1 total blue pull-left">全部</div>
            <ul class="col-md-9 options options1 search_options" data-btn="box" id="industryId">
            </ul>
            <div class="col-md-1 pull_right">
              <a class="toggle blue dropup" data-btn="hide">收起<span class="caret"></span></a>
              <a class="toggle blue dropdown" data-btn="show" style='display:block'>展开<span class="caret"></span></a>
            </div>
          </div>
          <div class="row">
            <div class="col-md-1 sear_title">轮次</div>
            <div class="col-md-1 total blue pull-left">全部</div>
            <div class="col-md-9 options options2 search_options" data-btn="box" id="roundId">
            </div>
            <div class="col-md-1 pull_right">
              <a class="toggle blue dropup" data-btn="hide">收起<span class="caret"></span></a>
              <a class="toggle blue dropdown1" data-btn="show" style='display:block'>展开<span class="caret"></span></a>
            </div>
          </div>
      <!--     <div class="row">
            <div class="col-md-1 sear_title">地区</div>
            <div class="col-md-1 total blue">国内</div>
            <div class="col-md-9 options options3 search_options" data-btn="box" id="domestic">
            </div>
            <div class="col-md-1">
              <a class="toggle blue dropup" data-btn="hide">收起<span class="caret"></span></a>
              <a class="toggle blue dropdown2" data-btn="show" style='display:block'>展开<span class="caret"></span></a>
            </div>
          </div>
          <div class="row">
            <div class="col-md-1 sear_title"></div>
            <div class="col-md-1 total blue">国外</div>
            <div class="col-md-9 options options4 search_options" data-btn="box" id="abord">
            </div>
            <div class="col-md-1">
              <a class="toggle blue dropup" data-btn="hide">收起<span class="caret"></span></a>
              <a class="toggleblue dropdown3" data-btn="show" style='display:block'>展开<span class="caret"></span></a>
            </div> 
          </div> -->
         
          <div class="row">
            <div class="col-md-3 col-md-offset-5 button_action">
              <button type="button" class="btn btn-primary btn-long"  action="search">确认</button>
            </div>
          </div>
        </div>
      </div> 

      <!-- 表格部分      -->
      <button class="pull-right btn btn-primary export ico b3" onclick="exportData();">导出数据</button>
      <div class="table_block clearfix">
      	<div class="tab-pane active" id="view">		
		   <div id='searchtable'>
              <table id='dataId'>
              </table> 
       		</div>
	      </div>
      </div>
  </div>
  </body>
  <script src="<%=request.getContextPath() %>/js/init.js"></script>
  <script src="<%=request.getContextPath() %>/bootstrap/bootstrap-table/bootstrap-table-xhhl.js"></script>
  <script src="<%=request.getContextPath() %>/bootstrap/bootstrap-table/locale/bootstrap-table-zh-CN.js"></script>
  <script src="<%=request.getContextPath() %>/js/agency_echarts.js"></script>
  <script src="<%=request.getContextPath() %>/js/echarts.min.js"></script>
  <script src="<%=request.getContextPath() %>/js/agency_list.js"></script>


</html>