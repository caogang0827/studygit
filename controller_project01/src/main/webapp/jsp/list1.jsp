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

function sc(bid) {
	if(confirm("是否删除这本图书？")){

		location.href="delete.do?bid="+bid;
		
	}else{

		location.href="list1.do";
	}
}

$(function () {

	var type = "${tid}";

	data=type.split(",");

	for (var i = 0; i < data.length; i++) {

		$("#ck[value='"+data[i]+"']").attr("checked",true);
		
	}
	
})

</script>

</head>
<body>
		

		<form action="list1.do" method="post">
			登录用户：<span style="color: red;font-size: 15px">${user.uname }</span><br>
			类别：<c:forEach items="${type }" var="t">
					<input type="checkbox" name="tid" value="${t.tid }" id="ck">${t.tname }
				</c:forEach>
			<table>
				<tr>
					<td colspan="10">
						关键字：
						<input type="text" name="iname" value="${iname }">
						<input type="submit" value="查询">
						<input type="button" value="添加" onclick="location.href='toadd.do'">
						<input type="button" value="退出" onclick="location.href='exit.do'">
					</td>
				</tr>				
				<tr>
					<th>图书ID</th>
					<th>图书名称</th>
					<th>图书作者</th>
					<th>图书类型</th>
					<th>受欢迎程度</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${list }" var="l">
					<tr>
						<td>${l.bid }</td>
						<td>${l.bname }</td>
						<td>${l.bauthor }</td>
						<td>${l.type.tname }</td>
						<td>${l.bpopular }</td>
						<td>
							<input type="button" value="修改" onclick="location.href='toupdate.do?bid='+${l.bid}">
							<input type="button" value="删除" onclick="sc(${l.bid})">
						</td>
					</tr>
				</c:forEach>
			</table>
		
		</form>
</body>
</html>