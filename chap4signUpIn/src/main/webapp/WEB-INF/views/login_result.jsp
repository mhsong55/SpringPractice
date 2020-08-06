<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>LOG IN RESULT</title>
	<script type="text/javascript">
		function logInPopup() {
			// if Log In is successful
			if ("${result}" == "success") {
				window.alert("${user.name} 님의 방문을 환영합니다.");
				
				// create element (form)
				var newForm = document.createElement('form');
				
				// set attribute (form)
				newForm.name = 'messenger'
				newForm.method = 'post';
				newForm.target = '_self';
				newForm.action = 'logon.do'
				
				// create element (input)
				var newInput = document.createElement('input');
				var userInfo = {
					id : "${user.id}",
					name : "${user.name}",
					email : "${user.email}",
					phone : "${user.phone}"
				};
				var jsonInfo = JSON.stringify(userInfo);
				// set attribute (input)
				newInput.setAttribute("type", "hidden");
				newInput.setAttribute("name", "user");
				newInput.setAttribute("value", jsonInfo);
				// console.log(jsonInfo);
				
				// append input (to form)
				newForm.appendChild(newInput);
				
				// append form (to body)
				document.body.appendChild(newForm);
				
				// submit form
				newForm.submit();
				
			// if Log In is fails
			} else {
				if("${reason}" == "id") {
					window.alert("존재하지 않는 ID 입니다.");
				} else if("${rease}" == "pw") {
					window.alert("비밀번호가 틀렸습니다.");
				}
				// go to the Log In page
				location.href = "/chap4Controller/";
			}
		}
	</script>
</head>
<body>
	<script type="text/javascript">
		logInPopup();
	</script>
</body>
</html>