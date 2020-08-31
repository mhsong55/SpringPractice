package utilPack;

import java.util.*;
import dto.*;

public class resvViewDTO {
	private int year;
	private int month;
	private int date;
	private int calDayListVal;
	private String[] roomArray;
	private List<ReservationDTO> resvInformList;
	
	public resvViewDTO() {}
	public resvViewDTO(int year, int month, int calDayListVal, String[] roomArray, List<ReservationDTO> resvInformList) {
		super();
		this.year = year;
		this.month = month;
		this.calDayListVal = calDayListVal;
		this.roomArray = roomArray;
		this.resvInformList = resvInformList;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public int getCalDayListVal() {
		return calDayListVal;
	}
	public void setCalDayListVal(int calDayListVal) {
		this.calDayListVal = calDayListVal;
	}
	public String[] getRoomArray() {
		return roomArray;
	}
	public void setRoomArray(String[] roomArray) {
		this.roomArray = roomArray;
	}
	public List<ReservationDTO> getResvInformList() {
		return resvInformList;
	}
	public void setResvInformList(List<ReservationDTO> resvInformList) {
		this.resvInformList = resvInformList;
	}
}
