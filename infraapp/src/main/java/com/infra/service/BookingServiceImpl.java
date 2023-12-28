package com.infra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infra.entity.Booking;
import com.infra.repo.BookingRepository;
import com.infra.serviceInterface.BookingService;
@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepository br;
	
	@Override
	public Booking saveBooking(Booking b) {
		return br.save(b);
	}

	@Override
	public void deleteBooking(Booking b) {
			br.delete(b);
	}

	@Override
	public List<Booking> getAllBooking() {
		return br.findAll();
	}

	@Override
	public Booking getBydId(int id) {
		Optional<Booking> b = br.findById(id);
		return b.isPresent()==false? null: b.get();
	}

}
