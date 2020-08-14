<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<style>
		.borderingTD {
			border:1px solid black;
		}
	</style>
	<title>JSP 실습 : CRUD 게시판</title>
</head>
<body>
	<p><h1>&nbsp&nbspJSP 실습 : CRUD 게시판</h1>
	<p>
	<table width="600px" border="1px" cellspacing="1">
		<tr class="borderingTD">
			<td class="borderingTD" width="50"><p align="center">번호</p></td>
			<td class="borderingTD" width="500"><p align="center">제목</p></td>
			<td class="borderingTD" width="100"><p align="center">등록일</p></td>
		</tr>
		<c:forEach var="post" items="postList">
			<tr>
				<td class="borderingTD" width="50">
					<p align="center">${post.id}</p>
				</td>
				<td class="borderingTD" width="500">
					<p align="center">
						<a href="gongji_view.jsp?key=${post.id}">
							${post.title}
						</a>
					</p>
				</td>
				<td class="borderingTD" width="100">
					<p align="center">${post.date.toLocalDate()}</p>
				</td>
			</tr>
		</c:forEach>
	</table>
	<table width="650">
		<tr>
			<td width="500"></td>
			<td><input type="button" value="신규" OnClick="window.location='gongji_insert.jsp'"></td>
	</table>
</body>
</html>