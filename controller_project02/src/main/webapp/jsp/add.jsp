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

//追加下拉框
$.post("getTeam.do",function(data) {
	for (var i = 0; i < data.length; i++) {
		$("[name='team.tid']").append("<option value='"+data[i].tid+"'>"+data[i].tname+"</option>")
	}
}, "JSON")

//姓名唯一性验证
function yz() {
	var pname = $("[name='pname']").val();
	if(pname==null||pname==""){
		$("#sp").html("球员名不能为空！").css("color", "red");
	}else{
	$.post("findPlayer.do", {pname:pname}, function(data) {
		if(data=="yes"){
			$("#sp").html("OK!").css("color", "green");
		}else{
		$("#sp").html("此球员已存在！").css("color", "red");
		}
	}, "JSON")
}
}

</script>

</head>
<body>
		<form action="add.do" method="post">
			球员姓名：<input type="text" name="pname" onblur="yz()"><span style="margin-left: 15px;font-size: 20px" id="sp"></span><br><br>
			球员薪水：<input type="text" name="psalary"><br><br>
			球员司职：<input type="text" name="ploc"><br><br>
			所在球队：<select name="team.tid">
					<option value="">===请选择===</option>
					</select><br><br>
			<input type="submit" value="确定">
			<input type="button" value="返回" onclick="javascript:history.back(-1)">
		</form>
</body>
</html>