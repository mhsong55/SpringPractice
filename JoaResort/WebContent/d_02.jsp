<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.time.*"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>예약하기</title>
	<meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="css/top.css" type="text/css" rel="stylesheet" />
    <link href="css/bootstrap.css" type="text/css" rel="stylesheet" />
    <link href="css/d_02.css" type="text/css" rel="stylesheet" />
    <!-- jQuery가 먼저 로드 된 후 datepicker가 로드 되어야함.-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.1/css/tempusdominus-bootstrap-4.min.css" />
	<link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.css" />
	<%
		String getYear = request.getParameter("y");
		String getMonth = request.getParameter("m");
		String getDay = request.getParameter("d");
		String getRoomType = request.getParameter("r");
		LocalDate resvDate = LocalDate.now().plusDays(1);
		int year = resvDate.getYear();
		int month = resvDate.getMonthValue();
		int day = resvDate.getDayOfMonth();
		
		if (getYear != null && getMonth != null && getDay != null) {
			year = Integer.parseInt(getYear);
			month = Integer.parseInt(getMonth);
			day = Integer.parseInt(getDay);
			resvDate = LocalDate.of(year, month, day);
		}
		int roomType = getRoomType != null ? Integer.parseInt(getRoomType) : 0;
	%>
</head>
<body>
	<jsp:include page="top.jsp" flush="false" />
	<div class="container">
		<br>
		<div id="reservationBoard">
			<div class="card">
				<div class="card-header">
					<h5 class="card-title">예약하기</h5>
				</div>
				<div class="card-body">
					<div class="container">
						<form method="post" name="resvForm" action="d_02_write.jsp">
							<div class="row">
								<div class='col-md-6 col-xs-6'>
									<div class="form-group">
										<div class="input-group date" id="checkIn" data-target-input="nearest">
											<div class="input-group-prepend">
												<span class="input-group-text">Check-In</span>
											</div>
											<input type="text" id="checkInValue" name="checkInValue" class="form-control dateTimePicker datetimepicker-input" data-target="#checkIn" value="<%=resvDate%>">
											<div class="input-group-append" data-target="#checkIn" data-toggle="datetimepicker">
												<div class="input-group-text"><i class="fa fa-calendar"></i></div>
											</div>
										</div>
									</div>
								</div>
								<div class='col-md-6 col-xs-6'>
									<div class="form-group">
										<div class="input-group date" id="checkOut" data-target-input="nearest">
											<div class="input-group-prepend">
												<span class="input-group-text">Check-Out</span>
											</div>
											<input type="text" id="checkOutValue" name="checkOutValue" class="form-control dateTimePicker datetimepicker-input" data-target="#checkOut">
											<div class="input-group-append" data-target="#checkOut" data-toggle="datetimepicker">
												<div class="input-group-text"><i class="fa fa-calendar"></i></div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6 col-xs-6">
									<div class="input-group">
										<div class="input-group-prepend">
											<label class="input-group-text" for="subscriberName">예약자 명</label>
										</div>
										<input type="text" id="subscriberName" name="subscriberName" class="form-control" required>
									</div>
								</div>
								<div class='col-md-6 col-xs-6'>
									<div class="input-group">
										<div class="input-group-prepend">
											<label class="input-group-text" for="roomType">예약방</label>
										</div>
										<select class="custom-select" id="roomType" name="roomType">
											<option selected>방 종류</option>
											<option value="0">VIP 룸</option>
											<option value="1">일반 룸</option>
											<option value="2">합리적인 룸</option>
										</select>
									</div>
								</div>
							</div>
							<p>
							<div class="row">
								<div class='col-md-3 col-xs-3'>
									<div class="input-group">
										<div class="input-group-prepend">
											<label class="input-group-text" for="phone1">전화번호</label>
										</div>
										<select class="custom-select" id="phone1" name="phone1">
											<option selected></option>
											<option value="010">010</option>
											<option value="011">011</option>
											<option value="016">016</option>
											<option value="017">017</option>
										</select>
									</div>
								</div>
								-
								<div class="col-md-2 col-xs-2">
									<div class="input-group">
										<input type="tel" id="phone2" name="phone2" class="form-control" maxlength="4" size="4" required onkeydown="return numberCheck(event);">
									</div>
								</div>
								-
								<div class="col-md-2 col-xs-2">
									<div class="input-group">
										<input type="tel" id="phone3" name="phone3" class="form-control" maxlength="4" size="4" required onkeydown="return numberCheck(event);">
									</div>
								</div>
							</div>
							<p>
							<div class="row">
								<div class="col-md-12 col-xs-124">
									<div class="input-group">
										<div class="input-group-prepend">
											<label class="input-group-text" for="address">주소</label>
										</div>
										<input type="text" id="payerName" name="address" class="form-control" required>
									</div>
								</div>
							</div>
							<p>
							<div class="row">
								<div class="col-md-4 col-xs-4">
									<div class="input-group">
										<div class="input-group-prepend">
											<label class="input-group-text" for="payerName">입금자 명</label>
										</div>
										<input type="text" id="payerName" name="payerName" class="form-control" required>
									</div>
								</div>
								<div class='col-md-8 col-xs-8'>
									<div class="input-group">
										<div class="input-group-prepend">
											<label class="input-group-text" for="comment">남기실 말씀</label>
										</div>
										<input type="text" id="commment" name="comment" class="form-control">
									</div>
								</div>
							</div>
							<p>
							<div class="submitButton-div">
								<input class="btn btn-success" type="submit" value="전송">
							</div>
						</form>
						
					</div> <!-- container div end -->
					
				</div> <!-- card-body div end -->
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript" src="js/top.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.1/js/tempusdominus-bootstrap-4.min.js"></script>
    <script type="text/javascript" src="js/ko.js"></script>
    <script type="text/javascript" src="js/d_02.js"></script>
    <script>
    	$(function () {
    		$('#checkIn').datetimepicker({
    			locale: 'ko',
    			format: 'L',
    			minDate: moment().add(1, 'days')
    		});
    		$('#checkOut').datetimepicker({
    			locale: 'ko',
    			format: 'L',
    			useCurrent: false,
    			minDate: moment().add(1, 'days'),
    		});
    		$("#checkIn").on("change.datetimepicker", function (e) {
    			$('#checkOut').datetimepicker('minDate', moment(e.date));
    		});
    		$("#checkOut").on("change.datetimepicker", function (e) {
    			$('#checkIn').datetimepicker('maxDate', moment(e.date).subtract(1, 'days'));
   			});
    		// d_01.jsp에서 받아온 날짜 값을 초기값으로 지정
    		$('#checkInValue').val('<%=year%>.<%=month%>.<%=day%>');
   		});
    	
    	// d_01.jsp에서 받아온 룸타입 값을 초기값으로 지정
    	$('#roomType').val('<%=roomType%>').prop("selected", true);
    </script>
</body>
</html>