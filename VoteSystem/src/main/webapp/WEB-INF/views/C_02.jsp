<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<!--bootstrap을 사용하기 위한 link-->
	<link rel="stylesheet" 
		  href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
		  integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" 
		  crossorigin="anonymous">
	<title>개표결과-성향분석</title>
	<style>
		.tapBox {
			display: inline-block;
			border: 2px solid blue;
			width: 110px;
			text-align: center;
			padding: 5px;
			font-size:20px;
			background-color: #fff;
		}
		.tableRowBox {
			border:1px solid black;
			border-collapse: collapse;
		}
        .graph {
        	width: 450px;
            padding: 2px;
            font-size:11px;
            text-align: left;
        }
        .graph .bar { 
        	display: inline-block;
            background: red;
            height: 20px;
            float: left;
        }
        .graph .empty { 
            height: 20px;
            padding: 5px;
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
			<input type="button" class="tapBox" value="투표" 
				   OnClick="javascript:location.href='vote'">
	    </span>
		<span>
			<input type="button" class="tapBox" style="background-color:yellow;" value="개표결과"
				   OnClick="javascript:location.href='result'">
		</span>
	</div>
	<p>
	<span style="margin-left: 35px;">${ id }. ${ hubo.name } 후보 득표 성향 분석</span><br>
	<div class="d-flex pl-2">
		<table>
			<c:forEach var="index" begin="0" end="${ ageList.size() - 1 }">
				<tr class="tableRowBox">
					<td class="tableRowBox" width="150">
						&nbsp${ ageList[index] }0대 
					</td>
					<td class="tableRowBox" width="500">
						<div class="graph">
							<!--연령대별 득표율을 width 속성의 % 값으로 지정-->
							<strong class="bar" style="width: ${ tendencyRateList[index] }%;"></strong>
							<!--bar 부분 외의 빈 부분에 연령대별 득표수와 득표율을 text로 표시-->
							<strong class="empty">${ voteCountList[index] } (${ tendencyRateList[index] }%)</strong>
						</div>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>