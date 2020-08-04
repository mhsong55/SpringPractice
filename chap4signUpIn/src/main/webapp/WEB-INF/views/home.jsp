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
		<table border="1">
			<tr>
				<tr><td>ID</td><td><input type="text" name="id" id="id"></td></tr>
				<tr><td>Password</td><td><input type="text" name="pw" id="pw"></td></tr>
				<tr><td>Name</td><td><input type="text" name="name" id="name"></td></tr>
				<tr><td>E-mail</td><td><input type="text" name="email" id="eamil"></td></tr>
				<tr><td>Phone Number</td><td><input type="text" name="phone" id="phone"></td></tr>
		</table>
	</form>
	<!--
	<P>
	<form action="insert.do" method="post">
		<span style="display:inline-block; width:75px">ID : </span><input type = "text" name = "id" width = 250><br>
		<span style="display:inline-block; width:75px">PW : </span><input type = "password" name = "pw" width = 250><br>
		<span style="display:inline-block; width:75px">NAME : </span><input type = "text" name = "name" width = 250><br>
		<span style="display:inline-block; width:150px"></span><input type = "submit" value = "Sign On">
	</form>
	-->
</body>
</html>
