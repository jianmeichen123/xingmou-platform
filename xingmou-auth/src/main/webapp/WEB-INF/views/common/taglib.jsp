<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.galaxyinternet.framework.core.constants.Constants,com.galaxyinternet.framework.core.oss.OSSConstant,com.galaxyinternet.model.user.User"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%User user = (User)request.getSession().getAttribute(Constants.SESSION_USER_KEY);
String sessionId = "";
String realName = "";
Long userId=null;
if(null != user) {
	sessionId = user.getSessionId();
	if(null != user.getRealName()){
		realName = user.getRealName();
	}
	userId = user.getId();
}

String endpointUrl = (String)application.getAttribute(OSSConstant.GALAXYINTERNET_FX_ENDPOINT);
%>
<script type="text/javascript">
var contextEndPoint = '<%=endpointUrl%>';
endpointObj = JSON.parse(contextEndPoint);
</script>


<link href="<%=request.getContextPath() %>/css/axure.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
<link rel="shortcut icon" href="<%=request.getContextPath() %>/img/favicon.ico" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/bootstrap/bootstrap-table/bootstrap-table.css"  type="text/css">
<link href="<%=request.getContextPath() %>/css/introduce.css" rel="stylesheet">
<script src="<%=request.getContextPath() %>/js/jquery-1.12.3.min.js"></script>
<script src="<%=request.getContextPath() %>/js/layer/layer.js" type="text/javascript"></script>
<script type="text/javascript">
	sessionId = '<%=sessionId%>',realName = '<%=realName%>',userId = '<%=userId%>';
</script>
<script type="text/javascript" src="js/json2.js"></script>
<script src="<%=request.getContextPath() %>/js/common.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/platformUrl.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/bootstrap/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath() %>/js/jquery.placeholder.js"></script>
<script src="<%=request.getContextPath() %>/js/axure.js"></script>
<script src="<%=request.getContextPath() %>/js/axure_ext.js"></script>
