<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>

	<table>
		<thead>
			<tr>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${select1}" var="member">
				<tr>
					<td>${member.id}</td>
					<td>${member.pw}</td>
					<td>${member.name}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<P>
	<form action="insert.do" method="post">
		<span style="display:inline-block; width:75px">ID : </span><input type = "text" name = "id" width = 250><br>
		<span style="display:inline-block; width:75px">PW : </span><input type = "password" name = "pw" width = 250><br>
		<span style="display:inline-block; width:75px">NAME : </span><input type = "text" name = "name" width = 250><br>
		<span style="display:inline-block; width:150px"></span><input type = "submit" value = "Sign On">
	</form>

</body>
</html>
