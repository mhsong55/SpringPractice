<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>투표-투표</title>
	<!--bootstrap을 사용하기 위한 link-->
	<link rel="stylesheet" 
		  href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
		  integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" 
		  crossorigin="anonymous">
	<style>
		.tapBox {
			display: inline-block;
			border: 2px solid blue;
			width: 110px;
			text-align: center;
			padding: 5px;
			font-size:20px;
		}
		.button {
			display: inline-block;
			padding: 0.3em 1.2em 0.3em 1.2em;
			border-radius: 0.35em;
			letter-spacing: 0.20em;
			text-decoration: none;
			font-weigth: 400;
			font-size: 0.90em;
			color: black;
			background-color: #68dc97;
			border: 2px solid #429E6C;
			outline: 1;
		}
		.tableRowBox {
			border:1px solid black;
			padding: 2px;
			height: 50px;
		}
		tr {
			height: 50px;
		}
	</style>
	
</head>
<body>
	<!--메뉴 이동 부분-->
	<div class="d-flex p-2">
		<span>
			<input type="button" class="tapBox" value="후보등록"
				   OnClick="javascript:location.href='registration'">
	    </span>
		<span>
			<input type="button" class="tapBox" style="background-color:yellow;" value="투표" 
				   OnClick="javascript:location.href='vote'">
	    </span>
		<span>
			<input type="button" class="tapBox" value="개표결과"
				   OnClick="javascript:location.href='result'">
		</span>
	</div>
	<p>
	<!--ComboBox 형태 투표 화면 부분-->
	<div class="d-flex pl-2">
		<table>
			<!--submit 후 key="id, age"로 B_02.jsp에 기호, 투표자 연령대를 parameter로 넘김-->
			<form class="form-inline" name="vote" method="post" action="vote.do">
				<tr class="tableRowBox">	
					<td width="150" align="center">
						<select class="custom-select" name="id" style="height:auto;min-height:30px;">
							<option selected>후보자 명단</option>
							<!--전체 후보 목록 출력-->
							<c:forEach var="hubo" items="${huboList}">
								<option value="${hubo.id}">${hubo.id}번 ${hubo.name}</option>
							</c:forEach>
						</select>
					</td>
					<td width="150">
						<select class="custom-select" name="age" style="margin-left:40px;height:auto;min-height:30px;">
							<option selected>투표자 연령</option>
							<!--투표자 연령 선택 입력-->
							<c:forEach var="age" begin="1" end="9">
								<option value="${age}">${age}0대</option>
							</c:forEach>
						</select>
					</td>
					<td width="100"></td>
					<td width="150" align="right" style="padding-right: 0.7em;">
						<input class="button" type="submit" id="marginLeft" value="투표하기">
					</td>
				</tr>
			</form>
		</table>
	</div>
</body>
</html>