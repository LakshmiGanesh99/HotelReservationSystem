package com.capgemini.hotelreservationsystem;

public class HotelDetails {

	private String hotelName;
	private int weekdayRoomRateRegular;
	private int weekendRoomRateRegular;
	private int weekdayRoomRateRewards;
	private int weekendRoomRateRewards;
	private int rating;
	
	public HotelDetails(String name, int weekdayRoomRateRegular, int weekendRoomRateRegular, int weekdayRoomRateRewards, int weekendRoomRateRewards, int rating) {
		this.hotelName = name;
		this.weekdayRoomRateRegular = weekdayRoomRateRegular;
		this.weekendRoomRateRegular = weekendRoomRateRegular;
		this.weekdayRoomRateRewards = weekdayRoomRateRewards;
		this.weekendRoomRateRewards = weekendRoomRateRewards;
		this.rating = rating;
	}
	
	public String getName() {
		return hotelName;
	}
	public void setName(String name) {
		this.hotelName = name;
	}
	public int getWeekdayRoomRateRegular() {
		return weekdayRoomRateRegular;
	}

	public void setWeekdayRoomRateRegular(int weekdayRoomRateRegular) {
		this.weekdayRoomRateRegular = weekdayRoomRateRegular;
	}

	public int getWeekendRoomRateRegular() {
		return weekendRoomRateRegular;
	}

	public void setWeekendRoomRateRegular(int weekendRoomRateReuglar) {
		this.weekendRoomRateRegular = weekendRoomRateReuglar;
	}
	public int getWeekdayRoomRateRewards() {
		return weekdayRoomRateRewards;
	}

	public void setWeekdayRoomRateRewards(int weekdayRoomRateRewards) {
		this.weekdayRoomRateRewards = weekdayRoomRateRewards;
	}

	public int getWeekendRoomRateRewards() {
		return weekendRoomRateRewards;
	}

	public void setWeekendRoomRateRewards(int weekendRoomRateRewards) {
		this.weekendRoomRateRewards = weekendRoomRateRewards;
	}
	
	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString(){
		return "HotelDetails [hotelName=" + hotelName + ", weekdayRoomRate=" + weekdayRoomRateRegular + ", weekendRoomRate="
				+ weekendRoomRateRegular + ", rating=" + rating + "]";
	}
}
