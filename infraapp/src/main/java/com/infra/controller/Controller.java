package com.infra.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infra.entity.Booking;
import com.infra.entity.Employee;
import com.infra.entity.Role;
import com.infra.entity.Room;
import com.infra.serviceInterface.BookingService;
//import com.infra.entity.Role;
import com.infra.serviceInterface.EmployeeService;
import com.infra.serviceInterface.RoleService;
import com.infra.serviceInterface.RoomService;

@RestController
@RequestMapping("api/infra")
public class Controller {
	@Autowired
	private EmployeeService iS;
	@Autowired
	private RoleService rs;
	@Autowired
	private RoomService rS;
	@Autowired
	private BookingService bs;

	@PostMapping("/employe")
	ResponseEntity<Employee> saveEmploye(@RequestBody Employee e){
		Employee employeToBeinserted;
		employeToBeinserted=iS.saveEmployee(e);
		ResponseEntity<Employee> employee = new ResponseEntity<Employee>(employeToBeinserted,HttpStatus.CREATED);
		
		return employee;
	}

	
	@PostMapping("/booking")
	ResponseEntity<Booking> saveBooking(@RequestBody Map<String,Object> data
			){
		String[] room=String.valueOf(data.get("rooms")).split(",");
		List<Room> rooms=new ArrayList<>();
//		List<Object> t=Arrays.asList(data.get("roles"));
//		System.out.println(room[1]);
		for(String s:room) {
			Optional<Room> tR=rS.getRoom(s);
			if(tR.isPresent()) rooms.add(tR.get());
		}
		Employee e = iS.getById(Integer.parseInt(String.valueOf(data.get("empId"))));
		Booking booking = new Booking(rooms,e,String.valueOf(data.get("purpose")),
				LocalDate.now(),
				Integer.parseInt(String.valueOf(data.get("participants"))));
//		Employee employee=new Employee(String.valueOf(data.get("email")),String.valueOf(data.get("password")),roles);
//		System.out.println(booking);
//		return null;
		return new ResponseEntity<>(bs.saveBooking(booking),HttpStatus.CREATED);
	}
	
	@GetMapping("/booking")
	ResponseEntity<List<Booking>> getAllBooking(){
		return new ResponseEntity<>(bs.getAllBooking(),HttpStatus.OK);
	}
	
	@DeleteMapping("/booking/{id}")
	void deleteBooking(@PathVariable("id")int id) {
		Booking b=bs.getBydId(id);
		if(b!=null)bs.deleteBooking(b);
	}

	
	@PostMapping("/role")
	ResponseEntity<Role> saveRole(@RequestBody Role role) {
		return new ResponseEntity<>(rs.saveRoel(role),HttpStatus.CREATED);
//		return new ResponseEntity<>(rs.saveRoel(new Role(role)),HttpStatus.OK);
	}
	
	@PostMapping("/room")
	ResponseEntity<Room> saveRoom(@RequestBody Room room) {
		return new ResponseEntity<>(rS.saveRooms(room),HttpStatus.CREATED);
	}
	
	@GetMapping("/room")
	ResponseEntity<List<Room>> getAllRoom(){
		return new ResponseEntity<>(rS.getAllRoom(),HttpStatus.OK);
	}
	
	@GetMapping("/employee")
	ResponseEntity<List<Employee>> getAllEmployee(){
	 return new ResponseEntity<>(iS.getAllEmployee(),HttpStatus.OK);	
	}
	
	

}
