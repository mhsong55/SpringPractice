package calendarPrint;
import java.time.*;
import java.util.*;
public class TestMain {
	public static void main(String[] args) {
		CalendarPrint calendarPrint = new CalendarPrint(2020, 5, 1);
		List<String> calDayList = calendarPrint.getDayList();
		LocalDate localDate = LocalDate.of(2020,5,1);
		System.out.println("lengthOfMonth: " + localDate.lengthOfMonth());
		int weekCount = (int) Math.ceil(calDayList.size()/7.0);
		int cnt = 0;
		
		System.out.println("\n");
		System.out.println(String.format("%8s%2s월\n"," ",calendarPrint.getMonth()));
		
		for(int i = 0; i < weekCount; i++) {
			for(int j = 0; j < 7; j++) {
				if (calDayList.get(i).equals("prevMonth") || (calDayList.get(i).equals("nextMonth"))) {
					System.out.print(String.format("%2s ", " "));
				} else {
					System.out.print(String.format("%2s ", calDayList.get(cnt)));
				}
				cnt++;
			}
			System.out.print("\n");
		}
	}
}