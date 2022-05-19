package com.microservice.room.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.room.entity.Room;
import com.microservice.room.repository.RoomRepository;


@Service
public class RoomServiceImpl {
	
	@Autowired
	private RoomRepository roomRepository;
	
	
	public void addRoom(Room room) {
		roomRepository.save(room);
	}

	public List<Room> getAllRoom() {
		return roomRepository.findAll();
	}
	
	public List<Room> getAvailableRoom(boolean roomAvailable) {
		return roomRepository.findByRoomAvailable(roomAvailable);
	}
	
	public Optional<Room> getRoomById(long roomId) {
		return roomRepository.findById(roomId);
	}
	
	public void updateRoom(long roomId, Room room) {
		roomRepository.save(room);
	}
	
	public void deleteRoom(long roomId) {
		roomRepository.deleteById(roomId);
	}
		

}
