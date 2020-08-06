<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<!-- login_Result.jsp -->
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert result</title>
	<script type="text/javascript">
		function resultPopup() {
			// if DB registration is successful
			if ("${result}" == "success") {
				window.alert("${member.name} 님의 회원 가입이 완료되었습니다.\n"
						+ "ID : ${member.id}\n"
						+ "E-mail : ${member.email}\n"
						+ "Phone number : ${member.phone}");
				
			// if DB registration is fails
			} else {
				window.alert("${result}");
			}
			
			// go to the registration form page
			location.href = "/chap4Controller/";
		}
	</script>
</head>
<body>
	<script type="text/javascript">
		resultPopup();
	</script>
</body>
</html>