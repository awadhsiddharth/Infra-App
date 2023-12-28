package com.infra.serviceInterface;

import java.util.List;

import com.infra.entity.Booking;

public interface BookingService {

	Booking saveBooking(Booking b);
	void deleteBooking(Booking b);
	List<Booking> getAllBooking();
	Booking getBydId(int id);
}
