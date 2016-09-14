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
 <title>竞情分析</title>
 <base href="<%=basePath%>">
 <meta name="renderer" content="webkit"/>
<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
</head>
  <body>
   <%@ include file="/WEB-INF/views/common/header.jsp"%>
    <div class="container">
      <div class="row clearfix">
        <div class="col-md-12 row1">
          <div class="select1 pull-left">
           <!--  <input type="text" class="time" placeholder="时间"> -->
            <select  class="time" placeholder="时间" id="year_select">
            
            <option value="2016">2016</option>
            <option value="2015" selected="selected">2015</option>
            <option value="2014">2014</option>
            <option value="2013">2013</option>
            <option value="2012">2012</option>
            <option value="2011">2011</option>
            <option value="2010">2010</option>
            
            <!-- <option value="2009">2009</option>
            <option value="2008">2008</option>
            <option value="2007">2007</option>
            <option value="2006">2006</option>
            <option value="2005">2005</option>
            <option value="2004">2004</option>
            <option value="2003">2003</option>
            <option value="2002">2002</option>
            <option value="2001">2001</option>
            <option value="2000">2000</option> -->
            </select>
           <!--  <span class="ico xiala b2">下拉</span> -->
          </div>
        <div class="select2 pull-left">
          <!-- <input type="text" class="time" placeholder="行业"> -->
           <select  class="time" placeholder="行业" id="industry_select">
            </select>
          <!-- <span class="ico xiala b2">下拉</span> -->
        </div>
          <button class="btn btn-primary btn-sm">确定</button>
        </div>      
      </div>

      <div class="row">
        <div class="col-md-12 row4 chart_name">
          <div class="chart_name">
          
          
          
          
          
          <span class='block_left'>行业投资走势分析</span>
		  <a href='javascript:void(0);' class='block_left'  
title='
总投资额：总投资金额
投资额增长率：(本期(年)总投资额－上期(年)总投资额)／上期(年)总投资额 *100
总投资量：总投资笔数
投资量增长率：(本期(年)总投资笔数－上期(年)总投资笔数)／上期(年)总投资笔数 *100'><span  class="b4 block_left tooltips" >帮助</span></a> 
          </div>
        </div>
        <div class="col-md-12 row6">
          <div class="trend_l pull-left" >
              <dl>
                <dt class="blue" analysis-info="current_money_total">¥<span>25.2</span>亿</dt>
                <dd>总投资额</dd>
              </dl>
              <dl>
                <dt class="light_blue" analysis-info="invest_money_rate">暂无数据</dt>
                <dd>投资额增长率</dd>
              </dl>
              <dl>
                <dt class="red" analysis-info="current_num_toal">暂无数据</dt>
                <dd>总投资量</dd>
              </dl>
              <dl>
                <dt class="orange" analysis-info="invest_num_rate">暂无数据</dt>
                <dd>投资量增长率</dd>
              </dl>
          </div>
          <div class="trend_r pull-right" >
              <div class="col-md-6 nopad pull-right" style='width:50%'>
                <div id="tzjy" style="width:98%;height:310px;"></div>
              </div>
              <div class="col-md-6 nopad pull-left" style='width:50%'>
                <div id="tzbs" style="width:98%;height:310px;"></div>
              </div>
          </div>        
        </div>
      </div>
      <div class="row">
        <div class="col-md-12 row4 chart_name">
          <div class="chart_name" id="titile_tip">行业投资次数分布分析</div>
        </div>
        <div class="col-md-12 row5">            
              <div class=" pull_left_33">
                <div id="area" style="width:100%;height:280px;"></div>
                <!-- <span class="label label-gray">按地区分布</span> -->
              </div>  
              <div class="pull_left_33">
                <div id="round" style="width:100%;height:280px;"></div>
                <!-- <span class="label label-gray">按轮次分布</span> -->

              </div>  
              <div class="pull_left_33">
                <div id="quota" style="width:100%;height:280px;"></div>
                <!-- <span class="label label-gray">按额度分布</span> -->
              </div>  
        </div>
      </div> 
      <div class="row">
        <div class="col-md-12 row4 chart_name">
          <div class="chart_name"><span class='block_left'>行业获投情况分析</span>
		  <a href='javascript:void(0);' class='block_left'  
title='
成立项目数：月成立项目数
项目获投数：月获投项目数（任何轮次都算，获投项目不一定是当月成立项目）'><span  class="b4 block_left tooltips" >帮助</span></a> </div>
        </div>
        <div class="col-md-12 row5  pad_b">
            <div  id="line_hyht" style="width:100%;height:310px;"></div>
        </div>
      </div>
      <!-- 表格部分 -->
      <div class="row"> 
        <div class="table_block clearfix col-md-12">
          <table class="table table-striped">
            <thead>
              <tr>
                <th>行业</th>
                <th><span class='block_left'>投资金额</span>
		  <a href='javascript:void(0);' class='block_left'  
title='
投资金额：
1. 未透漏：0
2. 模糊金额: 数十万计10万，数百万计100万，数千万计1000万，亿元及以上计1亿
3. 具体金额：具体金额＊投资当日平均汇率
4. 币种为其它 ： 计相等数量人民币'><span  class="b4 block_left tooltips" >帮助</span></a> </th>
                <th>投资笔数</th>
                <th>成立项目数量</th>
                <th>项目获投数量</th>
                <th><span class='block_left'>项目获投率</span><span data-toggle="tooltip" title="(项目获投数量/成立项目数量)*100" class="b4 block_left tooltips" >帮助</span></th>
                <th>公司数</th>
              </tr>
            </thead>
            <tbody id="industry_year_list">
            </tbody>
          </table>
        </div>
      </div>




    </div>

  </body>
 <script src="<%=request.getContextPath() %>/js/echarts.min.js"></script>
 <script  src="<%=request.getContextPath() %>/js/echarts_competeAnalysis.js"></script>
 <script  src="<%=request.getContextPath() %>/js/competeAnalysis.js"></script>
</html>
 
 
 