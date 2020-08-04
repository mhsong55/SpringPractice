<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<meta charset="UTF-8">
<title>Sign up</title>
</head>
<body>
	<h1>Join our page!</h1>
	<p>
	<form method="post" action="memberList">
		<!-- <form method = "post" action = "openPopup()"> -->
		아래 항목은 모두 필수 입력 항목 입니다.<br>
		<table border="1">
			<tr>
				<tr><td width="120px">ID</td><td><input type="text" name="id" id="id" required></td></tr>
				<tr><td width="120px">Password</td><td><input type="password" name="pw" id="pw" required></td></tr>
				<tr><td width="120px">Name</td><td><input type="text" name="name" id="name" required></td></tr>
				<tr><td width="120px">E-mail</td><td><input type="email" name="email" id="eamil" required></td></tr>
				<tr><td width="120px">Phone Number</td><td><input type="number" name="phone" size="11" id="phone" required></td></tr>
		</table>
		<span style="display:inline-block; width:200px"></span><input type = "submit" value = "Sign On">
	</form>
</body>
</html>
