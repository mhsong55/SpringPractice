<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<form method="post" name="viewForm" action="put/record?id=${post.id}">
		<table width="650px" border="1px" cellspacing="0" cellpadding="5">
			<tr>
				<td><b>번호</b></td>
				<td>${post.id}</td>
			</tr>
			<tr>
				<td><b>제목</b></td>
				<td>${post.title}</td>
			</tr>
			<tr>
				<td><b>일자</b></td>
				<td>${post.date.toLocalDate()}</td>
			</tr>
			<tr>
				<td><b>내용</b></td>
				<td>${post.content}</td>
			</tr>
		</table>
		<input type="hidden" name="_method" value="put">
		<table width="650">
			<tr>
				<td width="600"></td>
				<td><input type="button" value="목록" OnClick="location.href='get/list'"></td>
				<!--gongji_update.jsp에 parameter: "id = postId" submit-->
				<td><input type="submit" value="수정"></td>
		</table>
	</form>
</body>
</html>