package com.infra.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infra.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking,Integer> {

}
