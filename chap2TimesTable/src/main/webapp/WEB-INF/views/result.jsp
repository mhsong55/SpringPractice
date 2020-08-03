<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<title>Calculated Result</title>
</head>
<body>
	<c:forEach var="j" begin="2" end="9">
		${number} × ${j} = ${number*j}<br>
	</c:forEach>
</body>
</html>