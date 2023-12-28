package com.infra.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infra.entity.Room;

public interface RoomRepository extends JpaRepository<Room, String> {

	Optional<Room> findByCode(String code);

}
