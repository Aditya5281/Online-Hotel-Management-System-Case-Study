package com.microservice.staff.entity;

import org.springframework.data.annotation.Id;


public class Staff {
	
	@Id
	private long staffId;
	private String staffName;
	private int staffAge;
	private String staffAddress;
	private double staffSalary;
	private String staffEmail;
	
		
	public Staff(long staffId, String staffName, int staffAge, String staffAddress, double staffSalary,
			String staffEmail) {
		super();
		this.staffId = staffId;
		this.staffName = staffName;
		this.staffAge = staffAge;
		this.staffAddress = staffAddress;
		this.staffSalary = staffSalary;
		this.staffEmail = staffEmail;
	}

	public Staff() {
		
	}
	
	
	
	public long getStaffId() {
		return staffId;
	}
	public void setStaffId(long staffId) {
		this.staffId = staffId;
	}
	
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	
	public int getStaffAge() {
		return staffAge;
	}
	public void setStaffAge(int staffAge) {
		this.staffAge = staffAge;
	}

	public String getStaffAddress() {
		return staffAddress;
	}
	public void setStaffAddress(String staffAddress) {
		this.staffAddress = staffAddress;
	}
	
	public double getStaffSalary() {
		return staffSalary;
	}
	public void setStaffSalary(double staffSalary) {
		this.staffSalary = staffSalary;
	}
	
	public String getStaffEmail() {
		return staffEmail;
	}
	public void setStaffEmail(String staffEmail) {
		this.staffEmail = staffEmail;
	}

	@Override
	public String toString() {
		return "Staff [staffId=" + staffId + ", staffName=" + staffName + ", staffAge=" + staffAge + ", staffAddress="
				+ staffAddress + ", staffSalary=" + staffSalary + ", staffEmail=" + staffEmail + "]";
	}
	
	
}
