<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="calendarPrint.*, java.util.*, java.time.*"%>
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
		String getParamDate = request.getParameter("date");
		LocalDate now = LocalDate.now();
		
		int year = getParamYear == null ? now.getYear() : Integer.parseInt(getParamYear);
		int month = getParamMonth == null ? now.getMonthValue() : Integer.parseInt(getParamMonth);
		int date = getParamDate == null ? now.getDayOfMonth() : Integer.parseInt(getParamDate);
		int prevMonth = month - 1;
		int nextMonth = month + 1;
		int yearOfPrevMonth = year;
		int yearOfNextMonth = year;
		System.out.println("\nyear = " + year + ", month = " + month);

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
			for(int i = 0; i < weekCount; i++) {
				for(int j = 0; j < 7; j++) {
					if (calDayList.get(cnt).equals("prevMonth")) {%>			
						<div class="calendarDay horizontalGutter verticalGutter prevMonth"></div>
			<%		} else if (calDayList.get(cnt).equals("nextMonth")) {%>
						<div class="calendarDay horizontalGutter verticalGutter nextMonth"></div>
			<%		} else if (localDateList.get(cnt).getDayOfWeek().getValue() == 7) { // 일요일인 경우 %>
						<div id="day<%=calDayList.get(cnt) %>" class="calendarDay horizontalGutter verticalGutter thisMonth"
							 onclick="dayClicked('day<%=calDayList.get(cnt) %>')">
							<div class="sunday bolderFont">
								<%=calDayList.get(cnt)%>
							</div>
							<div class="resv">
								<div>
									VIP 룸
								</div>
								<div>
									일반 룸
								</div>
								<div>
									합리 룸
								</div>
							</div>
						</div>
			<%		} else if (localDateList.get(cnt).getDayOfWeek().getValue() == 6) { // 토요일인 경우 %>
						<div id="day<%=calDayList.get(cnt) %>" class="calendarDay horizontalGutter verticalGutter thisMonth"
							 onclick="dayClicked('day<%=calDayList.get(cnt) %>')">
							<div class="saturday bolderFont">
								<%=calDayList.get(cnt)%>
							</div>
							<div class="resv">
								<div>
									VIP 룸
								</div>
								<div>
									일반 룸
								</div>
								<div>
									합리 룸
								</div>
							</div>
						</div>
			<%	    } else { %>
						<div id="day<%=calDayList.get(cnt) %>" class="calendarDay horizontalGutter verticalGutter thisMonth"
							 onclick="dayClicked('day<%=calDayList.get(cnt) %>')">
							<div class="notWeekend bolderFont">
								<%=calDayList.get(cnt)%>
							</div>
							<div class="resv">
								<div>
									VIP 룸
								</div>
								<div>
									일반 룸
								</div>
								<div>
									합리 룸
								</div>
							</div>
						</div>
			<%		}
				cnt++;
				}
			}	%>
			</div>
		</div>
		<br>
		<div id="reservationBoard">
			<div class="card">
				<div class="card-header">
					<h5 class="card-title">VIP 룸</h5>
				</div>
				<div class="card-body">
					뿌잉뿌잉뿌잉
				</div>
			</div>
		</div>
		<br>
	</div>
	<script type="text/javascript" src="js/calendar.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript" src="js/top.js"></script>
</body>
</html>