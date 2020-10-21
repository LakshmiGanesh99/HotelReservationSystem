package com.capgemini.hotelreservationsystem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HotelReservation {

	public static ArrayList<HotelDetails> hotelList = new ArrayList<>();

	public ArrayList<HotelDetails> getHotelList() {
		return hotelList;
	}

	public static void addHotel(String name, int weekdayRoomRateRegular, int weekendRoomRateRegular, int weekdayRoomRateRewards, int weekendRoomRateRewards, int rating) {
		HotelDetails temporary = new HotelDetails(name, weekdayRoomRateRegular, weekendRoomRateRegular, weekdayRoomRateRewards, weekendRoomRateRewards, rating);
		hotelList.add(temporary);
	}

	public static int countNoOfHotels() {
		return hotelList.size();
	}

	public static String findCheapestHotel(String startDate, String endDate) {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd MMM yyyy");
		LocalDate startDateInput = LocalDate.parse(startDate, dateFormat);
		LocalDate endDateInput = LocalDate.parse(endDate, dateFormat);
		int noOfDaysToBook = (int) ChronoUnit.DAYS.between(startDateInput, endDateInput) + 1;
		List<DayOfWeek> daysList = new ArrayList<>();
		daysList = Stream.iterate(startDateInput.getDayOfWeek(), day -> day.plus(1)).limit(noOfDaysToBook).collect(Collectors.toList());
		int noOfWeekends = (int) daysList.stream().filter(day -> 
		day.equals(DayOfWeek.SATURDAY) || day.equals(DayOfWeek.SUNDAY)).count();
		int noOfWeekdays = daysList.size() - noOfWeekends;
		int minCost = hotelList.get(0).getWeekdayRoomRateRegular() * noOfWeekdays + hotelList.get(0).getWeekendRoomRateRegular() * noOfWeekends ;
		List<String> cheapestHotelNameList = new ArrayList<>();
		cheapestHotelNameList.add(hotelList.get(0).getName());
		
		for(int i = 1; i < hotelList.size(); i++) {
			if(hotelList.get(i).getWeekdayRoomRateRegular() * noOfWeekdays + hotelList.get(i).getWeekendRoomRateRegular() * noOfWeekends < minCost) {
				minCost = hotelList.get(i).getWeekdayRoomRateRegular() * noOfWeekdays + hotelList.get(i).getWeekendRoomRateRegular() * noOfWeekends;
				for(int j = 0; j < cheapestHotelNameList.size(); j++) 
					cheapestHotelNameList.remove(j);
				cheapestHotelNameList.add(hotelList.get(i).getName());
			}
			if(hotelList.get(i).getWeekdayRoomRateRegular() * noOfWeekdays + hotelList.get(i).getWeekendRoomRateRegular() * noOfWeekends == minCost)
				cheapestHotelNameList.add(hotelList.get(i).getName());
		}
		String hotelNameString = cheapestHotelNameList.stream().collect(Collectors.joining(", "));
		String cheapestHotelInfo = hotelNameString + " Total Cost: $" + minCost;
		return cheapestHotelInfo;
	}
	
	public String getCheapestBestRatedHotel(String startDate, String endDate) {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd MMM yyyy");
		LocalDate startDateInput = LocalDate.parse(startDate, dateFormat);
		LocalDate endDateInput = LocalDate.parse(endDate, dateFormat);
		int noOfDaysToBook = (int) ChronoUnit.DAYS.between(startDateInput, endDateInput) + 1;
		List<DayOfWeek> daysList = new ArrayList<>();
		daysList = Stream.iterate(startDateInput.getDayOfWeek(), day -> day.plus(1)).limit(noOfDaysToBook).collect(Collectors.toList());
		int noOfWeekends = (int) daysList.stream().filter(day -> 
		day.equals(DayOfWeek.SATURDAY) || day.equals(DayOfWeek.SUNDAY)).count();
		int noOfWeekdays = daysList.size() - noOfWeekends;
		int minCost = hotelList.get(0).getWeekdayRoomRateRegular() * noOfWeekdays + hotelList.get(0).getWeekendRoomRateRegular() * noOfWeekends ;
		List<HotelDetails> cheapestHotelList = new ArrayList<>();
		cheapestHotelList.add(hotelList.get(0));
		for(int i = 1; i < hotelList.size(); i++) {
			if(hotelList.get(i).getWeekdayRoomRateRegular() * noOfWeekdays + hotelList.get(i).getWeekendRoomRateRegular() * noOfWeekends < minCost) {
				minCost = hotelList.get(i).getWeekdayRoomRateRegular() * noOfWeekdays + hotelList.get(i).getWeekendRoomRateRegular() * noOfWeekends;
				for(int j = 0; j < cheapestHotelList.size(); j++) 
					cheapestHotelList.remove(j);
				cheapestHotelList.add(hotelList.get(i));
			}
			if(hotelList.get(i).getWeekdayRoomRateRegular() * noOfWeekdays + hotelList.get(i).getWeekendRoomRateRegular() * noOfWeekends == minCost)
				cheapestHotelList.add(hotelList.get(i));
		}
		HotelDetails cheapestBestRatedHotel = cheapestHotelList.stream().max((hotelOne, hotelTwo) -> hotelOne.getRating() - hotelTwo.getRating()).orElse(null);
		String cheapestBestRatedHotelInfo = cheapestBestRatedHotel.getName() + ", Rating: " + cheapestBestRatedHotel.getRating() + ", Total Cost: $" + minCost;
		return cheapestBestRatedHotelInfo;
	}
	
	public String getBestRatedHotel(String startDate, String endDate) {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd MMM yyyy");
		LocalDate startDateInput = LocalDate.parse(startDate, dateFormat);
		LocalDate endDateInput = LocalDate.parse(endDate, dateFormat);
		int noOfDaysToBook = (int) ChronoUnit.DAYS.between(startDateInput, endDateInput) + 1;
		List<DayOfWeek> daysList = new ArrayList<>();
		daysList = Stream.iterate(startDateInput.getDayOfWeek(), day -> day.plus(1)).limit(noOfDaysToBook).collect(Collectors.toList());
		int noOfWeekends = (int) daysList.stream().filter(day -> 
		day.equals(DayOfWeek.SATURDAY) || day.equals(DayOfWeek.SUNDAY)).count();
		int noOfWeekdays = daysList.size() - noOfWeekends;
		HotelDetails bestRatedHotel = hotelList.stream().max((hotelOne, hotelTwo) -> hotelOne.getRating() - hotelTwo.getRating()).orElse(null);
		int bestRatedCost = bestRatedHotel.getWeekdayRoomRateRegular() * noOfWeekdays + bestRatedHotel.getWeekendRoomRateRegular() * noOfWeekends;
		String bestRatedHotelInfo = bestRatedHotel.getName() + ", Total Cost: $" + bestRatedCost;
		return bestRatedHotelInfo;
	}
	}