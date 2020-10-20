package com.capgemini.hotelreservationsystem;

import java.awt.List;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class HotelReservationTest {

	@Test
	public void givendetailsOf3Hotels_WhenAddedToHotelList_SizeOfListIs3() {

		HotelReservation.addHotel("Lakewood", 110, 90);
		HotelReservation.addHotel("Bridgewood", 160, 60);
		HotelReservation.addHotel("Ridgewood", 220, 150);
		Assert.assertEquals(3, HotelReservation.countNoOfHotels());
	}

	@Test
	public void givenDetailsOf3Hotels_InAGivenDataRage_shouldReturnCheapesthotel() {

		HotelReservation.addHotel("Lakewood", 110, 90);
		HotelReservation.addHotel("Bridgewood", 160, 60);
		HotelReservation.addHotel("Ridgewood", 220, 150);
		String cheapestHotelInfo = HotelReservation.findCheapestHotel("10 Sep 2020", "11 Sep 2020");
		Assert.assertEquals("Lakewood Total Cost: $220", cheapestHotelInfo);
	}

	@Test
	public void givenDetailsOf3Hotels_WhenWeekdayAndWeekendRatesAdded_ShouldReturnThoseRates() {

		HotelReservation.addHotel("Lakewood", 110, 90);
		HotelReservation.addHotel("Bridgewood", 160, 60);
		HotelReservation.addHotel("Ridgewood", 220, 150);
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
		HotelReservation.addHotel("Lakewood", 110, 90);
		HotelReservation.addHotel("Bridgewood", 150, 50);
		HotelReservation.addHotel("Ridgewood", 220, 150);
		String cheapestHotelInfo = HotelReservation.findCheapestHotel("11 Sep 2020", "12 Sep 2020");
		Assert.assertEquals("Lakewood, Bridgewood Total Cost: $200", cheapestHotelInfo);
	}
}