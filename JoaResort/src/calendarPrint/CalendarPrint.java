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
	
	public int getMonth() {
		return this.monthVal;
	}
	public int getYear() {
		return this.year;
	}
	
	public List<String> getDayList() {
		List<String> dayList = new ArrayList<>();
		int firstDayOfThisMonth = LocalDate.of(this.year, this.monthVal, 1).getDayOfWeek().getValue();
		int lastDayOfThisMonth = LocalDate.of(this.year, this.monthVal, this.lengthOfMonth).getDayOfWeek().getValue();
		int yearOfPrevMonth = this.year;
		int prevMonth = this.monthVal - 1;
		if (prevMonth == 0) {
			yearOfPrevMonth -= 1;
			prevMonth = 12;
		}
		
		int lastDateOfPrevMonth = LocalDate.of(yearOfPrevMonth, prevMonth, 1).lengthOfMonth();
		int prevMonthDayCount = firstDayOfThisMonth == 7 ? 0 : firstDayOfThisMonth;
		int nextMonthDayCount = lastDayOfThisMonth == 7 ? 6 : 7 - (lastDayOfThisMonth + 1);
		
		for(int i = lastDateOfPrevMonth - prevMonthDayCount + 1; i < lastDateOfPrevMonth + 1; i++) {
			dayList.add("prevMonth");
		}
		
		for(int i = 1; i < this.lengthOfMonth + 1; i++) {
			dayList.add(Integer.toString(i));
		}		
		
		for(int i = 1; i < nextMonthDayCount + 1; i++) {
			dayList.add("nextMonth");
		}
		
		int weekCount = (int) Math.ceil(dayList.size()/7.0);
		int cnt = 0;
		
		System.out.println(String.format("%8s%2s월\n"," ",this.monthVal));
		
		for(int i = 0; i < weekCount; i++) {
			for(int j = 0; j < 7; j++) {
				if (dayList.get(cnt).equals("prevMonth") || dayList.get(cnt).equals("nextMonth")) {
					System.out.print(String.format("%2s ", " "));
				} else {
					System.out.print(String.format("%2s ", dayList.get(cnt)));
				}
				cnt++;
			}
			System.out.print("\n");
		}
		
		return dayList;
	}
}