package com.microservice.reservation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;

import com.microservice.reservation.entity.Guest;
import com.microservice.reservation.entity.Reservation;
import com.microservice.reservation.entity.Room;
import com.microservice.reservation.repository.ReservationRepo;

@Service
public class ReservationServiceImpl{
	
	@Autowired
	private ReservationRepo reservationRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
		
	public String addReservation(Reservation reservation) {
		Room room= restTemplate.getForObject("http://localhost:8083/room/get/"+reservation.getRoomId(), Room.class);
		Guest guest=restTemplate.getForObject("http://localhost:8081/guest/get/"+reservation.getGuestId(), Guest.class);
		if(room.isRoomAvailable()) {
			reservationRepository.save(reservation);
			room.setRoomAvailable(false);
			restTemplate.put("http://localhost:8083/room/update/"+reservation.getRoomId(), room);
			return "Room Number "+room.getRoomId()+" reserved for Guest "+guest.getGuestId();
		}
		else {
			return "Room Already Booked";
		}
	}

	public List<Reservation> getAllReservation() {
		return reservationRepository.findAll();
	}

	
	public Optional<Reservation> getReservationById(String reservId) {
		return reservationRepository.findById(reservId);
	}

	
	public void updateReservation(Reservation reservation, long reservId) {
		reservationRepository.save(reservation);
	}

	
	public String deleteReservation(String reservId) {
		Optional<Reservation> reOptional=reservationRepository.findById(reservId);
		Reservation reservation=reOptional.get();
		Room room= restTemplate.getForObject("http://localhost:8083/room/get/"+reservation.getRoomId(), Room.class);
		room.setRoomAvailable(true);
		restTemplate.put("http://localhost:8083/room/update/"+reservation.getRoomId(), room);
		reservationRepository.deleteById(reservId);
		return "Reservation deleted for ID "+reservId;
	}
	
}