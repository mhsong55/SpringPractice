<%@page import="java.time.temporal.ChronoUnit"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.time.*, service.ReservationService, dto.ReservationDTO, java.sql.Date"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>예약결과</title>
	<meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="css/top.css" type="text/css" rel="stylesheet" />
    <link href="css/bootstrap.css" type="text/css" rel="stylesheet" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<%
		String checkIn = request.getParameter("checkInValue");
		
		String checkOut = request.getParameter("checkOutValue");
		String subscriber = request.getParameter("subscriberName");
		String roomType = request.getParameter("roomType");
		String phone = request.getParameter("phone1")
					 + request.getParameter("phone2")
					 + request.getParameter("phone3");
		String payer = request.getParameter("payerName");
		String address = request.getParameter("address");
		String comment = request.getParameter("comment") != null ? request.getParameter("comment") : "";
		
		String[] checkInArray = checkIn.split("\\.");
		String[] checkOutArray = checkOut.split("\\.");
		LocalDate checkInDate = LocalDate.of(Integer.parseInt(checkInArray[0]), 
											 Integer.parseInt(checkInArray[1]),
											 Integer.parseInt(checkInArray[2]));
		LocalDate checkOutDate = LocalDate.of(Integer.parseInt(checkOutArray[0]), 
											  Integer.parseInt(checkOutArray[1]),
											  Integer.parseInt(checkOutArray[2]));
		long days = ChronoUnit.DAYS.between(checkInDate, checkOutDate);
		ReservationDTO dto = new ReservationDTO();
		dto.setName(subscriber);
		dto.setDate(Date.valueOf(checkInDate));
		dto.setRoom(Integer.parseInt(roomType));
		dto.setAddr(address);
		dto.setPhone(phone);
		dto.setPayer(payer);
		dto.setComment(comment);
		dto.setWriteDate(Date.valueOf(LocalDate.now()));
		dto.setProcessing(0);
		
		ReservationService service = new ReservationService();
		ReservationDTO[] resvArray = service.dtoArraySet(dto, (int)days);
	%>
</head>
<body>
	<jsp:include page="top.jsp" flush="false" />
	<div class="container">
		<br>
		<div id="reservationBoard">
			<div class="card">
				<div class="card-header">
					<h5 class="card-title">예약결과</h5>
				</div>
				<div class="card-body">
					<div class="container">
						<p>checkIn : <%=checkIn %>
						<p>checkOut : <%=checkOut %>
						<p>days : <%=days %>
						<p>subscriber : <%=subscriber %>
						<p>roomType : <%=roomType %>
						<p>phone : <%=phone %>
						<p>address : <%=address %>
						<p>payer : <%=payer %>
						<p>comment : <%=comment %>
						<p>resvArrayLength : <%=resvArray.length %>
					<div>					
				</div> <!-- card-body div end -->
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript" src="js/top.js"></script>
</body>
</html>