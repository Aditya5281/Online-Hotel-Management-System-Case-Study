package com.microservice.staff.controller;

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

import com.microservice.staff.entity.Staff;
import com.microservice.staff.service.StaffServiceImpl;


@RestController
@RequestMapping("/staff")
public class StaffController {

	@Autowired
	private StaffServiceImpl staffService;
	
	@PostMapping("/add")
	public String addStaff(@RequestBody Staff Staff) {
		this.staffService.addStaff(Staff);
		return "Staff added with StaffId "+Staff.getStaffId();
	}
	
	@GetMapping("/get")
	public List<Staff> getAllStaff(){
		return this.staffService.getAllStaff();
	}
	
	@GetMapping("/get/{sId}")
	public Staff getStaffById(@PathVariable long sId){
		Optional<Staff> staff = staffService.getStaffById(sId);
		return staff.get();
	}
	
	@PutMapping("/update/{sId}")
	public String updateStaff(@RequestBody Staff Staff,@PathVariable long sId) {
		this.staffService.updateStaff(sId, Staff);
		return "Staff updated with StaffId "+sId;
	}
	
	@DeleteMapping("/delete/{sId}")
	public String deleteStaff(@PathVariable long sId) {
		this.staffService.deleteStaff(sId);
		return "Staff deleted with StaffId"+sId;
	}
	
	
}
