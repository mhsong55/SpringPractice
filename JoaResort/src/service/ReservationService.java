package service;

import dao.*;
import dto.*;

import java.time.LocalDate;
import java.util.*;

public class ReservationService {
	
	private static ReservationDAO dao = ReservationDAO.getInstance();
	
	public List<ReservationDTO> getReservInformListByMonth(int month) {
		List<ReservationDTO> resvInformList = dao.selectMonthList(month);
		
		return resvInformList;

	}
	
	public String resvViewAtCalendar(int year, int month, int calDayListVal
									 , String[] roomArray, List<ReservationDTO> resvInformList) {
		
		for(int room = 0; room < roomArray.length; room++) {
			// 오늘 날짜 이 후 인 경우
			if (calDayListVal > LocalDate.now().getDayOfMonth()){
				if (resvInformList.size() > 0) {
					// 예약 정보 중
					for(ReservationDTO resvInform : resvInformList) {
						// 해당 일자에 예약 정보가 있는 경우
						if (resvInform.getDate().toLocalDate().getDayOfMonth() == calDayListVal) {
							// 해당 room은 출력하지 않고
							if (resvInform.getRoom() == room) {
							// 예약 정보가 없는 방만 출력
							} else { 
								return "<div><a href=\"d_02.jsp?y=" + year 
										+ "&m=" + month 
										+ "&d=" + calDayListVal 
										+ "&r=" + room + "\">"
										+ roomArray[room] + "</a></div>";
							}
						} 
					}
				} else {
					return "<div><a href=\"d_02.jsp?y=" + year 
							+ "&m=" + month
							+ "&d=" + calDayListVal
							+ "&r=" + room + "\">"
							+ roomArray[room] + "</a></div>";
				}
			}
		}		
		return "";
	}
}
