package com.capgemini.hotelreservationsystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HotelReservation {

	private static ArrayList<Hotel> hotelList = new ArrayList<>();

	public ArrayList<Hotel> getHotelList() {
		return hotelList;
	}

	// UC1
	public static void addHotel(String name, int price) {
		Hotel temporary = new Hotel(name, price);
		hotelList.add(temporary);
	}

	public static int countNoOfHotels() {
		return hotelList.size();
	}

	// UC2
	public static String findCheapestHotel(String startDate, String endDate) {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd MMM yyyy");
		LocalDate startDateInput = LocalDate.parse(startDate, dateFormat);
		LocalDate endDateInput = LocalDate.parse(endDate, dateFormat);
		int noOfDaysToBook = (int) ChronoUnit.DAYS.between(startDateInput, endDateInput) + 1;
		Map<String, Integer> hotelNameToTotalCostMap = hotelList.stream().collect(Collectors.toMap(hotel -> hotel.getName(), hotel -> hotel.getPrice() * noOfDaysToBook));
		String cheapestHotelName = hotelNameToTotalCostMap.keySet().stream().min((hotel1, hotel2) -> hotelNameToTotalCostMap.get(hotel1) - hotelNameToTotalCostMap.get(hotel2)).orElse(null);
		String cheapestHotelInfo = cheapestHotelName + ", Total Cost: $" + hotelNameToTotalCostMap.get(cheapestHotelName);
		return cheapestHotelInfo;
	}
}