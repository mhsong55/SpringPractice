<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>calculator Example</title>
</head>
<body>
	<form action="calculatorEx.do" method="post">
		<input type = "text" name = "number1" width = 350>
		<select name = "operation">
			<option value = "plus">+</option>
			<option value = "minus">-</option>
			<option value = "multiple">*</option>
			<option value = "devide">/</option>
		</select>
		<input type = "text" name = "number2" width = 350>
		<input type = "submit" value = "=">
	</form>
</body>
</html>