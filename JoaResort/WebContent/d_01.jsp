<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="calendarPrint.*, java.util.*, java.time.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link href="css/top.css" type="text/css" rel="stylesheet"/>
    <link href="css/calendar.css" type="text/css" rel="stylesheet"/>
    <link href="css/bootstrap.css" type="text/css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script language="javascript">
    	var clickCount = 0;
    	
    </script>
	<%	
		String getParamYear = request.getParameter("year");
		String getParamMonth = request.getParameter("month");
		String getParamDate = request.getParameter("date");
		LocalDate now = LocalDate.now();
		
		int year = getParamYear == null ? now.getYear() : Integer.parseInt(getParamYear);
		int month = getParamMonth == null ? now.getMonthValue() : Integer.parseInt(getParamMonth);
		int date = getParamDate == null ? now.getDayOfMonth() : Integer.parseInt(getParamDate);
		System.out.println("year = " + year + "month = " + month);
		if (month == 0) {
			month = 12;
			year -= 1;
		} else if (month == 13) {
			month = 1;
			year += 1;
		}
		
		CalendarPrint calendarPrint = new CalendarPrint(year, month, date);
		List<String> calDayList = calendarPrint.getDayList();
		int weekCount = calDayList.size()/7;
		int cnt = 0;
		String[] dayArray = {"일","월","화","수","목","금","토"};
		
	%>
</head>
<body>
	<jsp:include page="top.jsp" flush="false"/>
	<div class="container">
		<p></p>
		<div class="" id="calendar">
			<div id="calendarMonthYear">
				<div>
					<button type="button" class="btn btn-outline-primary" 
						    onclick="location.href='d_01.jsp?year=<%=year %>&month=<%=month - 1%>'">&lt</button>
				</div>
				<div><%=year %> 년 <%=month %> 월</div>
				<div>
					<button type="button" class="btn btn-outline-primary"
							onclick="location.href='d_01.jsp?year=<%=year %>&month=<%=month + 1%>'">&gt</button>
				</div>
			</div>
			<div id="calendarHeader">
			<% 	for(int i = 0; i < dayArray.length; i++) { %>
				<div class="weekOfDayContainer horizontalGutter verticalGutter">
					<div class="weekOfDay">
						<%=dayArray[i] %>
					</div>
				</div>
			<%	}	%>
			</div>
			<div id="dayContainer">
			<%
			for(int i = 0; i < weekCount; i++) {
				for(int j = 0; j < 7; j++) {
					if (calDayList.get(cnt).equals("prevMonth")) {%>			
						<div class="calendarDay horizontalGutter verticalGutter prevMonth"></div>
			<%		} else if (calDayList.get(cnt).equals("nextMonth")) {%>
						<div class="calendarDay horizontalGutter verticalGutter nextMonth"></div>
			<%		} else { %>
						<div id="day<%=calDayList.get(cnt) %>" class="calendarDay horizontalGutter verticalGutter thisMonth">
							<%=calDayList.get(cnt)%>
						</div>
			<%		}
				cnt++;
				}
			}	%>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript" src="js/top.js"></script>
</body>
</html>