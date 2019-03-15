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
			<form:form action="update.do" method="post">
				<form:hidden path="bid"/><br><br>
				图书名：<form:input path="bname"/><br><br>
				图书类型：<form:radiobuttons items="${type }" path="type.tid" itemLabel="tname" itemValue="tid"/><br><br>
				图书作者：<form:input path="bauthor"/><br><br>
				<input type="submit" value="确定">
				<input type="button" value="关闭" onclick="javascript:history.back(-1)">
			</form:form>
</body>
</html>