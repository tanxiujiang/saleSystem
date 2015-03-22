<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>职工信息列表</title>
</head>
<body>
	<table>
		<tr>
			<td>序号</td>
			<td>姓名</td>
			<td>性别</td>
			<td>电话</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${staffList }" var="staff" varStatus="Index">
			<tr>
				<td>${Index.count}</td>
				<td>${staff.name}</td>
				<td>${staff.sex}</td>
				<td>${staff.tel}</td>
				<td><a href="javascript:void(0)">销售分析</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>