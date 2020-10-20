package com.capgemini.hotelreservationsystem;


import java.util.ArrayList;


public class HotelReservation {
	
	private static ArrayList<Hotel> hotelList = new ArrayList<>();
	
	public ArrayList<Hotel> getHotelList() {
		return hotelList;
	}
	
	public static void addHotel(String name, int price){
		Hotel temporary = new Hotel(name,price);
		hotelList.add(temporary);
	}
	
	public static int countNoOfHotels() {
		return hotelList.size();
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to Hotel Reservation");
		Hotel lakeWood=new Hotel("Lakewood",110);
		Hotel bridgeWood=new Hotel("Bridgewood",110);
		Hotel ridgeWood=new Hotel("Ridgewood",110);
		hotelList.add(lakeWood);
		hotelList.add(bridgeWood);
		hotelList.add(ridgeWood);
		System.out.println(hotelList);
	}
}