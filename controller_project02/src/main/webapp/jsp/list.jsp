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

//分页
function fenye(page) {
	$("#page").val(page);
	$("form").submit();
}

</script>

</head>
<body>
		欢迎<span style="margin-bottom: 15px;font-size: 25px;color: red">${user.uname }</span>登录
		<form action="list.do" method="post">
			<input type="text" name="page" id="page" hidden>
			<table>
				<tr>
					<td colspan="10">
						关键字：
						<input type="text" name="iname" value="${iname }">
						<input type="submit" value="搜索">
						<input type="button" value="添加" onclick="location.href='add.jsp'">
						<input type="button" value="退出" onclick="location.href='exit.do'">
					</td>
				</tr>
				<tr>
					<th>
						<input type="button" value="全选/全不选" id="qx">
						<input type="button" value="反选" onclick="fx()">
					</th>
					<th>球员编号</th>
					<th>球员姓名</th>
					<th>球员身价</th>
					<th>球员司职</th>
					<th>所在球队</th>
					<th>所在城市</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${list }" var="l">
					<tr>
						<td><input type="checkbox" name="id" value="${l.pid }"></td>
						<td>${l.pid }</td>
						<td>${l.pname }</td>
						<td>${l.psalary }</td>
						<td>${l.ploc }</td>
						<td>${l.team.tname }</td>
						<td>${l.team.taddr }</td>
						<td>
							<input type="button" value="删除" onclick="sc(${l.pid })">
							<input type="button" value="修改" onclick="location.href='toupdate.do?pid='+${l.pid}">
						</td>
					</tr>
				</c:forEach>
					<tr>
						<td colspan="10">
							当前第${pu.currentPage }/${pu.lastPage }页
							共${pu.lastPage }页
							<input type="button" value="首页" onclick="fenye(1)">
							<input type="button" value="上一页" onclick="fenye(${pu.frontPage })">
							<input type="button" value="下一页" onclick="fenye(${pu.nextPage })">
							<input type="button" value="末页" onclick="fenye(${pu.lastPage })">
						</td>
					</tr>
			</table>
		
		
		</form>
</body>
</html>