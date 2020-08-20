package calendarPrint;
import java.time.*;
import java.util.*;
public class TestMain {
	public static void main(String[] args) {
		CalendarPrint calendarPrint = new CalendarPrint();
		List<String> calDayList = calendarPrint.getDayList();
		int weekCount = calDayList.size()/7;
		int cnt = 0;
		
		System.out.println("\n");
		System.out.println(String.format("%8s%2s월\n"," ",calendarPrint.getMonth()));
		
		for(int i = 0; i < weekCount; i++) {
			for(int j = 0; j < 7; j++) {
				System.out.print(String.format("%2s ", calDayList.get(cnt)));
				cnt++;
			}
			System.out.print("\n");
		}
	
	}
}