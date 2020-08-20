package calendarPrint;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class CalendarPrint {
	
	private int year;
	private int monthVal;
	private int date;
	private int day;
	private Month month;
	private LocalDate localDate = LocalDate.now();
	private int lengthOfMonth;
	
	public CalendarPrint() {
		this.year = localDate.getYear();
		this.month = localDate.getMonth();
		this.monthVal = this.month.getValue();
		this.date = localDate.getDayOfMonth();
		this.day = localDate.getDayOfWeek().getValue();
		this.lengthOfMonth = localDate.lengthOfMonth();
	}
	
	public CalendarPrint(int year, int month, int date) {
		localDate = LocalDate.of(year, month, date);
		this.year = localDate.getYear();
		this.month = localDate.getMonth();
		this.monthVal = this.month.getValue();
		this.date = localDate.getDayOfMonth();
		this.day = localDate.getDayOfWeek().getValue();
		this.lengthOfMonth = localDate.lengthOfMonth();
	}
	
	public List<Integer> getCalendarPrintDate() {
		List<Integer> calPrintDateList = new ArrayList<>();
		
		int prevMonthVal = this.monthVal - 1;
		int nextMonthVal = this.monthVal + 1;
		
		
		return calPrintDateList;
	}
	
	public List<String> getDayList() {
		List<String> dayList = new ArrayList<>();
		int firstDayOfThisMonth = LocalDate.of(this.year, this.monthVal, 1).getDayOfWeek().getValue();
		int lastDateOfPrevMonth = LocalDate.of(this.year, this.monthVal - 1, 1).lengthOfMonth();
		for(int i = 0; i < 7; i++) {
			this.month.
		}
		return dayList;
	}
	
}
