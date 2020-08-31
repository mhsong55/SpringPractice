<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="utilPack.*, java.util.*, java.time.*, service.*, dto.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>PNF 리조트 - 예약상황</title>
	<meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link href="css/top.css" type="text/css" rel="stylesheet"/>
    <link href="css/calendar.css" type="text/css" rel="stylesheet"/>
    <link href="css/bootstrap.css" type="text/css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script language="javascript">
    	
    </script>
	<%	
		String getParamYear = request.getParameter("year");
		String getParamMonth = request.getParameter("month");
		String getParamDate = "1";
		LocalDate now = LocalDate.now();
		
		int year = getParamYear == null ? now.getYear() : Integer.parseInt(getParamYear);
		int month = getParamMonth == null ? now.getMonthValue() : Integer.parseInt(getParamMonth);
		int date = getParamDate == null ? now.getDayOfMonth() : Integer.parseInt(getParamDate);
		int prevMonth = month - 1;
		int nextMonth = month + 1;
		int yearOfPrevMonth = year;
		int yearOfNextMonth = year;
		ReservationService service = new ReservationService();

		if (prevMonth == 0) {
			prevMonth = 12;
			yearOfPrevMonth -= 1;
		}
		if (nextMonth == 13) {
			nextMonth = 1;
			yearOfNextMonth += 1;
		}
		
		CalendarPrint calendarPrint = new CalendarPrint(year, month, date);
		List<String> calDayList = calendarPrint.getDayList();
		List<LocalDate> localDateList = calendarPrint.getDayToLocalDateList();
		
		int weekCount = (int) Math.ceil(calDayList.size()/7.0);
		
		int cnt = 0;
		String[] dayArray = {"일","월","화","수","목","금","토"};
		String[] roomArray = {"VIP룸", "일반룸", "합리룸"};
		List<ReservationDTO> resvInformList = service.getReservInformListByMonth(month);
	%>
</head>
<body>
	<jsp:include page="top.jsp" flush="false"/>
	<div class="container">
		<p></p>
		<div id="pageTitle"><h3><b>빈 방 현황</b></h3></div>
		<p></p>
		<div class="calendar">
			<div class="calendarMonthYear">
				<div>
					<button type="button" class="btn btn-outline-primary" 
						    onclick="location.href='d_01.jsp?year=<%=yearOfPrevMonth %>&month=<%=prevMonth%>'">&lt</button>
				</div>
				<div><%=year %> 년 <%=month %> 월</div>
				<div>
					<button type="button" class="btn btn-outline-primary"
							onclick="location.href='d_01.jsp?year=<%=yearOfNextMonth%>&month=<%=nextMonth%>'">&gt</button>
				</div>
			</div>
			<div class="calendarHeader">
			<% 	for(int i = 0; i < dayArray.length; i++) { %>
				<div class="weekOfDayContainer horizontalGutter verticalGutter">
					<div class="weekOfDay">
						<%=dayArray[i] %>
					</div>
				</div>
			<%	}	%>
			</div>
			<div class="dayContainer">
			<%
			// i = 1 주일을 의미
			for(int i = 0; i < weekCount; i++) {
				// j = 요일을 의미, j == 0 : 일, j == 7 : 토,
				for(int j = 0; j < 7; j++) {
					// 해당 month의 달력 페이지에서 이전 달의 날짜인 경우
					if (calDayList.get(cnt).equals("prevMonth")) {%>
								
						<div class="calendarDay horizontalGutter verticalGutter prevMonth"></div>
					<!-- 해당 month의 달력 페이지에서 다음 달의 날짜인 경우 -->
			<%		} else if (calDayList.get(cnt).equals("nextMonth")) {%>
			
						<div class="calendarDay horizontalGutter verticalGutter nextMonth"></div>
					<!-- 해당 month의 날짜인 경우 -->
			<%		} else if (localDateList.get(cnt).getDayOfWeek().getValue() == 7) { // 일요일인 경우 %>
			
						<div id="day<%=calDayList.get(cnt) %>" class="calendarDay horizontalGutter verticalGutter thisMonth"
							 onclick="dayClicked('day<%=calDayList.get(cnt) %>')">
							<div class="sunday bolderFont">
								<%=calDayList.get(cnt)%>
							</div>
							<div class="resv">	
						
							<!-- 각각의 room -->
						<%  for(int room = 0; room < roomArray.length; room++) {
								if (resvInformList.size() > 0) {
									// 예약 정보 중
									for(ReservationDTO resvInform : resvInformList) {
										// 해당 일자에 예약 정보가 있는 경우
										if (resvInform.getDate().toLocalDate().getDayOfMonth() == Integer.parseInt(calDayList.get(cnt))) {
											// 해당 room은 출력하지 않고
											if (resvInform.getRoom() == room) {
											// 예약 정보가 없는 방만 출력
											} else { 
						%>
												<div><a href="d_02.jsp?y=<%=year%>&m=<%=month%>&d=<%=calDayList.get(cnt)%>&r=<%=room%>"><%=roomArray[room] %></a></div>
						<%					}
										} 
									}
								} else if (year < now.getYear() 
										  || (year <= now.getYear() && month < now.getMonthValue())
										  || (year <= now.getYear() 
										  	  && month <= now.getMonthValue() 
										  	  && Integer.parseInt(calDayList.get(cnt)) <= now.getDayOfMonth())) {
									// 날짜 지난 경우 미출력
								} else {
						%>
									<div><a href="d_02.jsp?y=<%=year%>&m=<%=month%>&d=<%=calDayList.get(cnt)%>&r=<%=room%>"><%=roomArray[room] %></a></div>
						<%		}
							} 
						%>
							</div>
						</div>
			<%		} else if (localDateList.get(cnt).getDayOfWeek().getValue() == 6) { // 토요일인 경우 %>
						<div id="day<%=calDayList.get(cnt) %>" class="calendarDay horizontalGutter verticalGutter thisMonth"
							 onclick="dayClicked('day<%=calDayList.get(cnt) %>')">
							<div class="saturday bolderFont">
								<%=calDayList.get(cnt)%>
							</div>
							<div class="resv">
							
							<!-- 각각의 room -->
						<%  for(int room = 0; room < roomArray.length; room++) {
								if (resvInformList.size() > 0) {
									// 예약 정보 중
									for(ReservationDTO resvInform : resvInformList) {
										// 해당 일자에 예약 정보가 있는 경우
										if (resvInform.getDate().toLocalDate().getDayOfMonth() == Integer.parseInt(calDayList.get(cnt))) {
											// 해당 room은 출력하지 않고
											if (resvInform.getRoom() == room) {
											// 예약 정보가 없는 방만 출력
											} else { 
						%>
												<div><a href="d_02.jsp?y=<%=year%>&m=<%=month%>&d=<%=calDayList.get(cnt)%>&r=<%=room%>"><%=roomArray[room] %></a></div>
						<%					}
										} 
									}
								} else if (year < now.getYear() 
										  || (year <= now.getYear() && month < now.getMonthValue())
										  || (year <= now.getYear() 
										  	  && month <= now.getMonthValue() 
										  	  && Integer.parseInt(calDayList.get(cnt)) <= now.getDayOfMonth())) {
									// 날짜 지난 경우 미출력
								} else {
						%>
									<div><a href="d_02.jsp?y=<%=year%>&m=<%=month%>&d=<%=calDayList.get(cnt)%>&r=<%=room%>"><%=roomArray[room] %></a></div>
						<%		}
							} 
						%>
							</div>
						</div>
			<%	    } else { %>
						<div id="day<%=calDayList.get(cnt) %>" class="calendarDay horizontalGutter verticalGutter thisMonth"
							 onclick="dayClicked('day<%=calDayList.get(cnt) %>')">
							<div class="notWeekend bolderFont">
								<%=calDayList.get(cnt)%>
							</div>
							<div class="resv">
							
							<!-- 각각의 room -->
						<%  for(int room = 0; room < roomArray.length; room++) {
								if (resvInformList.size() > 0) {
									// 예약 정보 중
									for(ReservationDTO resvInform : resvInformList) {
										// 해당 일자에 예약 정보가 있는 경우
										if (resvInform.getDate().toLocalDate().getDayOfMonth() == Integer.parseInt(calDayList.get(cnt))) {
											// 해당 room은 출력하지 않고
											if (resvInform.getRoom() == room) {
											// 예약 정보가 없는 방만 출력
											} else { 
						%>
												<div><a href="d_02.jsp?y=<%=year%>&m=<%=month%>&d=<%=calDayList.get(cnt)%>&r=<%=room%>"><%=roomArray[room] %></a></div>
						<%					}
										} 
									}
								} else if (year < now.getYear() 
										  || (year <= now.getYear() && month < now.getMonthValue())
										  || (year <= now.getYear() 
										  	  && month <= now.getMonthValue() 
										  	  && Integer.parseInt(calDayList.get(cnt)) <= now.getDayOfMonth())) {
									// 날짜 지난 경우 미출력
								} else {
						%>
									<div><a href="d_02.jsp?y=<%=year%>&m=<%=month%>&d=<%=calDayList.get(cnt)%>&r=<%=room%>"><%=roomArray[room] %></a></div>
						<%		}
							} 
						%>
							</div>
						</div>
			<%		}
				cnt++;
				}
			}	%>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/calendar.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript" src="js/top.js"></script>
</body>
</html>