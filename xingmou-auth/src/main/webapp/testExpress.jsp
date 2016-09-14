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
.{ height:30px; width:66px;}
.input{width:400px;height:40px;}
table {  background-color: #fbfbfb;
    border: 1px solid #90bfff; width:600px; overflow:hidden; margin-left:auto; margin-right:auto;margin-bottom:50px;}
#falseText{border: 1px solid #90bfff;background-color:#fbfbfb; width:600px; overflow:hidden; margin-left:auto; margin-right:auto;}
.result-top {
    width: 608px;
    height: 43px;
    background-color: #fbfbfb;
}
</style>
<h2>请输入快递单号和快递公司编码</h2>
		<table width="100%" border="0">
			<tr>
				<td class='td_r'>快递单号</td>
				<td><input type="text" class='input' name="expNo" value="210001633605" />
			<tr>
				<td class='td_r'>快递公司编码</td>
				<td><input type="text" class='input' name="expCode" value="ANE" ></td>
			</tr>
			
			<tr>
			<td align='center' colspan='2'><input class='submit' type="button" onclick="query();" value="查询"></td>
			</tr>
		</table>
		<!-- <div id="falseText"  hidden="hidden"></div> -->
		<table id="result" class="result-top" hidden="hidden"></table>
</body>
<script  type="text/javascript">
 
function query(){
	var expNo = $("input[name='expNo']").val();
	var expCode =  $("input[name='expCode']").val();
	var data = {"expNo":expNo,"expCode":expCode};
	  $.ajax({
	      cache: true,
	      type: "POST",
	      url:"./galaxy/express/queryTrace",
	      data : JSON.stringify(data),
		  contentType : "application/json; charset=UTF-8",
	      async: false,
	      success: function(data) {
	    	if(!data.Success){
	    		$("#result").removeAttr("hidden")
	    		$("#result").empty();
	    		var traceHtml = "<tr><td colspan='2' style='text-align:center'>"+data.Reason+"</td></tr>";
	    		$("#result").html(traceHtml);
	    	}else{
	    		$("#result").removeAttr("hidden")
	    		$("#result").empty();
	    		
	    		var trace  = data.Traces;
	    		if(trace.length<=0){
	    			var traceHtml = "<tr><td colspan='2' style='text-align:center'>"+data.Reason+"</td></tr>";
	    		}else{
	    			var traceHtml = "<tr><th>时间</th><th>地点和跟踪进度</th></tr>";
	    			$(trace).each(function(){
		    			var templ = $(this)[0];
		    			traceHtml=traceHtml+"<tr><td>"+templ.AcceptTime+"</td><td>"+templ.AcceptStation+"</td></tr>";
		    		})
	    		}
	    		
	    		$("#result").html(traceHtml);
	    	}
	      }
	  });
} 
</script> 
</html>