package calendarPrint;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

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
	
	public int getMonth() {
		return this.monthVal;
	}
	public int getYear() {
		return this.year;
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
		int lastDayOfThisMonth = LocalDate.of(this.year, this.monthVal, this.lengthOfMonth).getDayOfWeek().getValue();
		int lastDateOfPrevMonth = LocalDate.of(this.year, this.monthVal - 1, 1).lengthOfMonth();
		int prevMonthDayCount = firstDayOfThisMonth;
		int nextMonthDayCount = 7 - (lastDayOfThisMonth + 1);
		
		for(int i = lastDateOfPrevMonth - prevMonthDayCount + 1; i < lastDateOfPrevMonth + 1; i++) {
			dayList.add("prevMonth");
		}

		for(int i = 1; i < this.lengthOfMonth + 1; i++) {

			dayList.add(Integer.toString(i));
		}
		
		for(int i = 1; i < nextMonthDayCount + 1; i++) {
			dayList.add("nextMonth");
		}
		
		return dayList;
	}
	
	public List<Integer> getPrevMonthDayCountList() {
		int firstDayOfThisMonth = LocalDate.of(this.year, this.monthVal, 1).getDayOfWeek().getValue();
		int lastDayOfThisMonth = LocalDate.of(this.year, this.monthVal, this.lengthOfMonth).getDayOfWeek().getValue();
		int lastDateOfPrevMonth = LocalDate.of(this.year, this.monthVal - 1, 1).lengthOfMonth();
		int prevMonthDayCount = firstDayOfThisMonth;
		List<Integer> prevMonthDayCountList = new ArrayList<>();
		
		for(int i = lastDateOfPrevMonth - prevMonthDayCount + 1; i < lastDateOfPrevMonth + 1; i++) {
			prevMonthDayCountList.add(i);
		}
		return prevMonthDayCountList;
	}
	
	public List<Integer> getNextMonthDayCountList() {
		int lastDayOfThisMonth = LocalDate.of(this.year, this.monthVal, this.lengthOfMonth).getDayOfWeek().getValue();
		int nextMonthDayCount = 7 - (lastDayOfThisMonth + 1);
		List<Integer> nextMonthDayCountList = new ArrayList<>();
		
		for(int i = 1; i < nextMonthDayCount + 1; i++) {
			nextMonthDayCountList.add(i);
		}
		return nextMonthDayCountList;
	}
}