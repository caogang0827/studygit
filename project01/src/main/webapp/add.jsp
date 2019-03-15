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

		<form action="add.do" method="post">
			图书名：<input type="text" name="bname"><br><br>
			图书类别：	<c:forEach items="${type }" var="t">
						<input type="radio" name="type.tid" value="${t.tid }" id="ck">${t.tname }
					</c:forEach><br><br>
			图书作者：<input type="text" name="bauthor"><br><br>
				<input type="submit" value="确定">
				<input type="button" value="关闭" onclick="javascript:history.back(-1)">
		</form>
</body>
</html>