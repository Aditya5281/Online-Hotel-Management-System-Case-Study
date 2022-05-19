package com.microservice.room.controller;

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

import com.microservice.room.entity.Room;
import com.microservice.room.service.RoomServiceImpl;


@RestController
@RequestMapping("/room")
public class RoomController {
	
	@Autowired
	private RoomServiceImpl roomService;
	
	@PostMapping("/add")
	public String addRoom(@RequestBody Room room) {
		try {
				this.roomService.addRoom(room);
				return "Room added with roomNumber "+room.getRoomId();
		} catch (Exception e) {
			System.out.println(e);
			return "Use Valid Input";
		}	
	}
	
	@GetMapping("/get")
	public List<Room> getAllRooms(){
		try {
			return this.roomService.getAllRoom();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@GetMapping("/get/{roomId}")
	public Room getInventoryById(@PathVariable long roomId) {
		try {
			Optional<Room> room = roomService.getRoomById(roomId);
			return room.get();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@GetMapping("/search/{roomAvailable}")
	public List<Room> getAvailableRoom(@PathVariable boolean roomAvailable){
	        return this.roomService.getAvailableRoom(roomAvailable);
	}
	
	@PutMapping("/update/{roomId}")
	public String updateRoom(@RequestBody Room room,@PathVariable long roomId) {
		try {
			this.roomService.updateRoom(roomId, room);
			return "Room updated with roomNumber "+roomId;
		} catch (Exception e) {
			System.out.println(e);
			return "Use Valid Input";
		}
	}
	
	@DeleteMapping("/delete/{roomId}")
	public String deleteRoom(@PathVariable long roomId) {
		try {
			this.roomService.deleteRoom(roomId);
			return "Room deleted with roomNumber "+roomId;
		} catch (Exception e) {
			System.out.println(e);
			return "Use Valid Input";
		}
	}
	
	
}
