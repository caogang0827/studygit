<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>.
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript"  src="<%=request.getContextPath() %>/js/My97DatePicker/WdatePicker.js"></script>
<link href="<%=request.getContextPath() %>/css/index_work.css" rel="stylesheet"/>
<title>Insert title here</title>
</head>
<body>
		<form action="login.do" method="post">
			用户名：<input type="text" name="uname"><br><br>
			密码：<input type="password" name="pwd"><br><br>
				<input type="submit" value="登录">
		</form>
		
		<span style="color: red;font-size: 25px;margin-top: 25px">${error}</span>
</body>
</html>