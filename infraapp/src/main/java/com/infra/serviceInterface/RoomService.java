package com.infra.serviceInterface;

import java.util.List;
import java.util.Optional;

//import com.infra.entity.Employee;
import com.infra.entity.Room;

public interface RoomService {

	Room saveRooms(Room room);
	Optional<Room> getRoom(String name);
	void deleteRoom(Room room);
	List<Room> saveAllRoom(List<Room> rooms);
	List<Room> getAllRoom();
}
