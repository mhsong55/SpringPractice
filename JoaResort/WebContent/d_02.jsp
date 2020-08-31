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
						<div class="row">
							<div class='col-md-6 col-xs-6'>
								<div class="form-group">
									<div class="input-group date" id="checkIn" data-target-input="nearest">
										<div class="input-group-prepend">
											<span class="input-group-text">Check-In</span>
										</div>
										<input type="text" id="checkInValue" class="form-control dateTimePicker datetimepicker-input" data-target="#checkIn" value="<%=LocalDate.now()%>">
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
										<input type="text" id="checkOutValue" class="form-control dateTimePicker datetimepicker-input" data-target="#checkOut" value="<%=LocalDate.now()%>">
										<div class="input-group-append" data-target="#checkOut" data-toggle="datetimepicker">
											<div class="input-group-text"><i class="fa fa-calendar"></i></div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
						
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript" src="js/top.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.1/js/tempusdominus-bootstrap-4.min.js"></script>
    <script type="text/javascript" src="js/ko.js"></script>
    <script>
    	$(function () {
    		$('#checkIn').datetimepicker({
    			locale: 'ko',
    			format: 'L',
    			minDate: moment().add(1, 'days'),

    		});
    		$('#checkOut').datetimepicker({
    			locale: 'ko',
    			format: 'L',
    			useCurrent: false,
    			minDate: moment().add(2, 'days'),
    			showClear: true
    		});
    		$("#checkIn").on("change.datetimepicker", function (e) {
    			$('#checkOut').datetimepicker('minDate', moment(e.date).add(1, 'days'));
    		});
    		$("#checkOut").on("change.datetimepicker", function (e) {
    			$('#checkIn').datetimepicker('maxDate', moment(e.date).subtract(1, 'days'));
    			
   			});
   		});
    </script>
</body>
</html>