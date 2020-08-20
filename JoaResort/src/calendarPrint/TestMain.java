package calendarPrint;
import java.time.*;
import java.util.*;
public class TestMain {

	public static void main(String[] args) {
		CalendarPrint calendarPrint = new CalendarPrint();
		Map<String, Integer> calendarData = calendarPrint.getCalendarData();
		Set<String> keySet = calendarData.keySet();
		
		for(String key : keySet) {
			System.out.println(String.format("key : %s, value = %d", key,calendarData.get(key)));
		}
	}

}
