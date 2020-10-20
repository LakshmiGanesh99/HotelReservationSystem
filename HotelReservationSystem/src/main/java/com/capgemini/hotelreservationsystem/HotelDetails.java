package com.capgemini.hotelreservationsystem;

public class HotelDetails {

	private String name;
	private int weekdayRoomRate;
	private int weekendRoomRate;
	
	public HotelDetails(String name, int weekdayRoomRate, int weekendRoomRate) {
		this.name = name;
		this.weekdayRoomRate = weekdayRoomRate;
		this.weekendRoomRate = weekendRoomRate;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWeekdayRoomRate() {
		return weekdayRoomRate;
	}

	public void setWeekdayRoomRate(int weekdayRoomRate) {
		this.weekdayRoomRate = weekdayRoomRate;
	}

	public int getWeekendRoomRate() {
		return weekendRoomRate;
	}

	public void setWeekendRoomRate(int weekendRoomRate) {
		this.weekendRoomRate = weekendRoomRate;
	}
	
	@Override
	public String toString(){
		return "HotelDetails [hotelName=" + name + ", weekdayRoomRate=" + weekdayRoomRate + ", weekendRoomRate="
				+ weekendRoomRate + "]";
	}
}
