<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome! LOG ON TEST PAGE</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.1/css/bootstrap.min.css" integrity="sha384-VCmXjywReHh4PwowAiWNagnWcLhlEJLA5buUprzK8rxFgeH0kww/aWY76TfkUoSX" crossorigin="anonymous">
	<style>
		* {
		  font-family: -apple-system, BlinkMacSystemFont, "San Francisco", Helvetica, Arial, sans-serif;
		  font-weight: 300;
		  margin: 0;
		}
		button {
		  -webkit-appearance: none;
		  width: auto;
		  min-width: 100px;
		  border-radius: 24px;
		  text-align: center;
		  padding: 15px 40px;
		  margin-top: 5px;
		  background-color: #b08bf8;
		  color: #fff;
		  font-size: 14px;
		  margin-left: auto;
		  font-weight: 500;
		  box-shadow: 0px 2px 6px -1px rgba(0, 0, 0, 0.13);
		  border: none;
		  -webkit-transition: all 0.3s ease;
		  transition: all 0.3s ease;
		  outline: 0;
		}
		button:hover {
		  -webkit-transform: translateY(-3px);
		          transform: translateY(-3px);
		  box-shadow: 0 2px 6px -1px rgba(182, 157, 230, 0.65);
		}
		button:hover:active {
		  -webkit-transform: scale(0.99);
		          transform: scale(0.99);
		}
		th, td {
			text-align: center;
		}
	</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col text-center">
				<br><h1>Member Information</h1>
			</div>
		</div>
	</div>
	<div class="float-right">
		<button class="btn btn-secondary mr-2 mb-2"
				 onclick="location.href='/chap4Controller/'">LOG OUT</button>
		<br>
	</div>
	<div class="px-2">
		<table class="table table-striped table-dark">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Name</th>
					<th scope="col">E-mail</th>
					<th scope="col">Phone</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${user.id}</td>
					<td>${user.name}</td>
					<td>${user.email}</td>
					<td>${user.phone}</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>