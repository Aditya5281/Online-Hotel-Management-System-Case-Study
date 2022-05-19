package com.microservice.reservation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.reservation.entity.Reservation;
import com.microservice.reservation.service.ReservationServiceImpl;


@RestController
@RequestMapping("/reservation")
public class ReservationController {
	
	
	@Autowired
	private ReservationServiceImpl reservationService;
	
	@PostMapping("/add")
	public String addReservation(@RequestBody Reservation reservation) {
		return this.reservationService.addReservation(reservation);
	}
	
	@GetMapping("/get")
	public List<Reservation> getAllReservation(){
		return this.reservationService.getAllReservation();
	}
	
	@GetMapping("/get/{reservationId}")
	public Reservation getReservationById(@PathVariable String reservationId){
		Optional<Reservation> reservation = reservationService.getReservationById(reservationId);
		return reservation.get();
	} 
	
	@PutMapping("/update/{reservationId}")
	public String updateReservation (@RequestBody Reservation reservation,@PathVariable long resId) {
		this.reservationService.updateReservation(reservation, resId);
		return "Reservation updated for ID "+resId;
	}
	
	@DeleteMapping("/delete/{reservationId}")
	public String deleteReservation(@PathVariable String reservationId) {
		return this.reservationService.deleteReservation(reservationId);
	}

}
