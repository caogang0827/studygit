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
					<form:hidden path="pid"/>
			球员姓名：<form:input path="pname"/><br><br>
			球员薪水：<form:input path="psalary"/><br><br>
			球员司职：<form:input path="ploc"/><br><br>
			所在球队：<form:select path="team.tid">
						<form:option value="">===请选择===</form:option>
						<form:options items="${team }" itemLabel="tname" itemValue="tid"/>
					</form:select><br><br>
			<input type="submit" value="确定">
			<input type="button" value="返回" onclick="javascript:history.back(-1)">		
		</form:form>
</body>
</html>