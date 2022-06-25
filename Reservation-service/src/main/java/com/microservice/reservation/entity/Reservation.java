package com.microservice.reservation.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ReservationDetails")
public class Reservation {
	
	
	@Id
	private long reservationId;
	private long roomId;
	private long guestId;
	private String checkInDate;
	private String checkOutDate;
	private int numOfGuest;
	private double totalPrice;
	
	
	public long getReservationId() {
		return reservationId;
	}
	public void setReservationId(long reservationId) {
		this.reservationId = reservationId;
	}
	public long getRoomId() {
		return roomId;
	}
	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}
	public long getGuestId() {
		return guestId;
	}
	public void setGuestId(long guestId) {
		this.guestId = guestId;
	}
	public String getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}
	public String getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public int getNumOfGuest() {
		return numOfGuest;
	}
	public void setNumOfGuest(int numOfGuest) {
		this.numOfGuest = numOfGuest;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public Reservation(
	long reservationId, long roomId, long guestId,
	String checkInDate,
	String checkOutDate,
			int numOfGuest, double totalPrice) {
		super();
		this.reservationId = reservationId;
		this.roomId = roomId;
		this.guestId = guestId;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.numOfGuest = numOfGuest;
		this.totalPrice = totalPrice;
	}
	public Reservation() {
		
	}
	
	@Override
	public String toString() {
		return "Reservation [reservationId=" + reservationId + ", roomId=" + roomId + ", guestId=" + guestId
				+ ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate + ", numOfGuest=" + numOfGuest
				+ ", totalPrice=" + totalPrice + "]";
	}
		
}
