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

<script type="text/javascript">

$(function () {

	var type = "${bid}";

	data=type.split(",");

	for (var i = 0; i < data.length; i++) {

		$("#ck[value='"+data[i]+"']").attr("checked",true);
		
	}
})

</script>

</head>
<body>
		<form action="choice.do" method="post">
			<table>
				<tr>
					<th>图书ID</th>
					<th>图书名称</th>
					<th>图书作者</th>
					<th>图书类型</th>
					<th>选择</th>
				</tr>
				<c:forEach items="${list }" var="l">
					<tr>
						<td>${l.bid }</td>
						<td>${l.bname }</td>
						<td>${l.bauthor }</td>
						<td>${l.type.tname }</td>
						<td><input type="checkbox" name="bid" value="${l.bid }" id="ck">喜欢</td>
					</tr>
				</c:forEach>
			</table>
				<input type="submit" value="确定">
				<input type="button" value="关闭" onclick="javascript:history.back(-1)">
		</form>
</body>
</html>