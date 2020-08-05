<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% request.setCharacterEncoding("UTF-8"); %>

<!-- home.jsp -->
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Sign up</title>
	<script type="text/javascript">
  		function numberCheck(e) {
  			var keyValue = event.keyCode;
  			if( ((keyValue >= 48) && (keyValue <= 57)) // number
  				|| (keyValue == 9)		// tab key
  				|| (keyValue == 8)		// backspace key
  				|| (keyValue == 46))	// delete key
  				return true;
  			else
  				return false;
  		}
	</script>
</head>
<body>
	<h1>Join our page!</h1>
	<p>
	<form method="post" name="registForm" action="memberList">
	
		아래 항목은 모두 필수 입력 항목 입니다.<br>
		<table border="1">
			<tr>
				<tr>
					<!-- "required" attribute applied to all input fields -->
					<td width="120px">ID</td>
					<td><input type="text" name="id" required></td>
				</tr>
				<tr>
					<!-- type="password" attribute on -->
					<td width="120px">Password</td>
					<td><input type="password" name="pw" required></td>
				</tr>
				<tr>
					<td width="120px">Name</td>
					<td><input type="text" name="name" required></td>
				</tr>
				<tr>
					<!-- type="email", The input value should always be in "%" @ "%" form. -->
					<td width="120px">E-mail</td>
					<td><input type="email" name="email" required></td>
				</tr>
				<tr>
					<!-- Input values must be 4 characters or less -->
					<td width="120px">Phone Number</td>
					<td>
						<!-- Prevent non-numeric input with OnKeyDown event listeners -->
						<input type="tel" name="phone1" maxlength="4" size="4" 
								value="010" required OnKeyDown="return numberCheck(event);">-
						<input type="tel" name="phone2" maxlength="4" size="4" 
								required OnKeyDown="return numberCheck(event);">-
						<input type="tel" name="phone3" maxlength="4" size="4" 
								required OnKeyDown="return numberCheck(event);">
					</td>
				</tr>
		</table>
		<p>
		<span style="display:inline-block; width:290px"></span><input type="submit" value="Sign On">
	</form>
</body>
</html>
