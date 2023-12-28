package com.infra.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infra.entity.Room;
import com.infra.repo.RoomRepository;
import com.infra.serviceInterface.RoomService;

@Service
public class RoomServiceImp implements RoomService {

	@Autowired
	RoomRepository rs;
	
	@Override
	public Room saveRooms(Room room) {
		return rs.save(room);
	}

	@Override
	public void deleteRoom(Room room) {
		rs.delete(room);

	}

	@Override
	public List<Room> saveAllRoom(List<Room> rooms) {
		List<Room> addedRoom=new ArrayList<>();
		for(Room r:rooms) addedRoom.add(saveRooms(r));
		return addedRoom;
	}

	@Override
	public Optional<Room> getRoom(String name) {

			return rs.findByCode(name);
	}

	@Override
	public List<Room> getAllRoom() {
		return rs.findAll();
	
	}

}
