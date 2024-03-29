package com.microservice.guest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.guest.entity.Guest;
import com.microservice.guest.repository.GuestRepository;

@Service
public class GuestServiceImpl {
	
	@Autowired
	private GuestRepository guestRepository;
	
	
	public void addGuest(Guest guest) {
		guestRepository.save(guest);
	}

	
	public List<Guest> getAllGuest() {
		return guestRepository.findAll();
	}

	
	public Optional<Guest> getGuestById(long guestId) {
		return guestRepository.findById(guestId);
	}

	
	public void updateGuest(long guestId, Guest guest) {
		guestRepository.save(guest);
	}

	
	public void deleteGuest(long guestId) {
		guestRepository.deleteById(guestId);
	}

}
