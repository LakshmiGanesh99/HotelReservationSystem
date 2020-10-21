package com.capgemini.hotelreservationsystem;

import java.awt.List;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class HotelReservationTest {

	@Test
	public void givendetailsOf3Hotels_WhenAddedToHotelList_SizeOfListIs3() {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 110, 90, 3);
		hotelReservation.addHotel("Bridgewood", 160, 60, 4);
		hotelReservation.addHotel("Ridgewood", 220, 150, 5);
		int noOfHotelsAdded = hotelReservation.countNoOfHotels();
		Assert.assertEquals(3, noOfHotelsAdded);
	}

	@Test
	public void givenDetailsOf3Hotels_InAGivenDataRage_shouldReturnCheapesthotel() {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 110, 90,3);
		hotelReservation.addHotel("Bridgewood", 160, 60,4);
		hotelReservation.addHotel("Ridgewood", 220, 150,5);
		String cheapestHotelInfo = hotelReservation.findCheapestHotel("10 Sep 2020", "11 Sep 2020");
		Assert.assertEquals("Lakewood Total Cost: $220", cheapestHotelInfo);
	}

	@Test
	public void givenDetailsOf3Hotels_WhenWeekdayAndWeekendRatesAdded_ShouldReturnThoseRates() {
		HotelReservation hotelReservation = new HotelReservation();
		HotelReservation.addHotel("Lakewood", 110, 90,3);
		HotelReservation.addHotel("Bridgewood", 160, 60,4);
		HotelReservation.addHotel("Ridgewood", 220, 150,5);
		List<Integer> weekendRoomRates = new ArrayList<>();
		List<Integer> weekdayRoomRates = new ArrayList<>();
		HotelReservation.hotelList.stream().forEach(hotelDetails -> {
			weekendRoomRates.add(hotelDetails.getWeekendRoomRate());
			weekdayRoomRates.add(hotelDetails.getWeekdayRoomRate());
			String cheapestHotelInfo = HotelReservation.findCheapestHotel("10 Sep 2020", "11 Sep 2020");
			Assert.assertEquals("Lakewood Total Cost: $220", cheapestHotelInfo);
		});
		Assert.assertEquals(110, (int) weekdayRoomRates.get(0));
		Assert.assertEquals(160, (int) weekdayRoomRates.get(1));
		Assert.assertEquals(220, (int) weekdayRoomRates.get(2));
		Assert.assertEquals(90, (int) weekendRoomRates.get(0));
		Assert.assertEquals(60, (int) weekendRoomRates.get(1));
		Assert.assertEquals(150, (int) weekendRoomRates.get(2));
	}

	@Test
	public void given3Hotels_InAGivenDateRange_ShouldReturnCheapestHotelBasedOnWeekdayAndWeekend() {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 110, 90,3);
		hotelReservation.addHotel("Bridgewood", 160, 60,4);
		hotelReservation.addHotel("Ridgewood", 220, 150,5);
		String cheapestHotelInfo = hotelReservation.findCheapestHotel("11 Sep 2020", "12 Sep 2020");
		Assert.assertEquals("Lakewood, Bridgewood Total Cost: $200", cheapestHotelInfo);
	}
	
	@Test
	public void given3Hotels_WhenRatingsAdded_ShouldReturnRates() {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 110, 90,3);
		hotelReservation.addHotel("Bridgewood", 160, 60,4);
		hotelReservation.addHotel("Ridgewood", 220, 150,5);
		List<Integer> ratingList = new ArrayList<>();
		hotelReservation.hotelList.stream().forEach(hotelDetails -> {
			ratingList.add(hotelDetails.getRating());
		});
		Assert.assertEquals(3, (int) ratingList.get(0));
		Assert.assertEquals(4, (int) ratingList.get(1));
		Assert.assertEquals(5, (int) ratingList.get(2));
	}
	
	@Test
	public void given3Hotels_InAGivenDateRange_ShouldReturnCheapestBestRatedHotel() {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 110, 90, 3);
		hotelReservation.addHotel("Bridgewood", 150, 50, 4);
		hotelReservation.addHotel("Ridgewood", 220, 150, 5);
		String cheapestBestRatedHotelInfo = hotelReservation.getCheapestBestRatedHotel("11 Sep 2020", "12 Sep 2020");
		Assert.assertEquals("Bridgewood, Rating: 4, Total Cost: $200", cheapestBestRatedHotelInfo);
	}	
	
	@Test
	public void given3Hotels_InAGivenDateRange_ShouldReturnBestRatedHotel() {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 110, 90, 3);
		hotelReservation.addHotel("Bridgewood", 150, 50, 4);
		hotelReservation.addHotel("Ridgewood", 220, 150, 5);
		String bestRatedHotelInfo = hotelReservation.getBestRatedHotel("11 Sep 2020", "12 Sep 2020");
		Assert.assertEquals("Ridgewood, Total Cost: $370", bestRatedHotelInfo);
	}	
}