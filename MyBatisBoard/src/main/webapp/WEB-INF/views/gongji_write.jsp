<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<SCRIPT LANGUAGE="JavaScript"></SCRIPT>
	<!--bootstrap을 사용하기 위한 link-->
	<link rel="stylesheet" 
		  href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
		  integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" 
		  crossorigin="anonymous">
	
</head>
<body>
	<SCRIPT LANGUAGE="JavaScript">
		window.alert("${resultState}");
		location.href="/controller/get/record?id=${postId}";
	</SCRIPT>
</body>
</html>