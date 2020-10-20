package com.capgemini.hotelreservationsystem;

public class HotelDetails {

	private String name;
	private int weekdayRoomRate;
	private int weekendRoomRate;
	private int rating;
	
	public HotelDetails(String name, int weekdayRoomRate, int weekendRoomRate, int rating) {
		this.name = name;
		this.weekdayRoomRate = weekdayRoomRate;
		this.weekendRoomRate = weekendRoomRate;
		this.rating = rating;
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
	
	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString(){
		return "HotelDetails [hotelName=" + name + ", weekdayRoomRate=" + weekdayRoomRate + ", weekendRoomRate="
				+ weekendRoomRate + ", rating=" + rating + "]";
	}
}
