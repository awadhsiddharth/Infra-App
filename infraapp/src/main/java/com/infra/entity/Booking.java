package com.infra.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "tbl_booking")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@OneToMany
	List<Room> bookedRooms;
	@ManyToOne
	Employee stakeholder;
	String purpose;
	LocalDate dateOfBooking;
	int participants;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Room> getBookedRooms() {
		return bookedRooms;
	}
	public void setBookedRooms(List<Room> bookedRooms) {
		this.bookedRooms = bookedRooms;
	}
	public Employee getStakeholder() {
		return stakeholder;
	}
	public void setStakeholder(Employee stakeholder) {
		this.stakeholder = stakeholder;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public LocalDate getDateOfBooking() {
		return dateOfBooking;
	}
	public void setDateOfBooking(LocalDate dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}
	public int getParticipants() {
		return participants;
	}
	public void setParticipants(int participants) {
		this.participants = participants;
	}
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Booking(List<Room> bookedRooms, Employee stakeholder, String purpose, LocalDate dateOfBooking,
			int participants) {
		super();
		this.bookedRooms = bookedRooms;
		this.stakeholder = stakeholder;
		this.purpose = purpose;
		this.dateOfBooking = dateOfBooking;
		this.participants = participants;
	}
	@Override
	public String toString() {
		return "Booking [id=" + id + ", bookedRooms=" + bookedRooms + ", stakeholder=" + stakeholder + ", purpose="
				+ purpose + ", dateOfBooking=" + dateOfBooking + ", participants=" + participants + "]";
	}
	
	
}
