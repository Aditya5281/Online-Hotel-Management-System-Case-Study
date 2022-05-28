package com.microservice.guest.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
//import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Guest")
public class Guest {
	
	@Id
	@NotNull
	private long guestId;
	@NotNull
	private String guestName;
	@NotNull
	@Size(min=10,message="Guest Contact should be minimum 10 digits")
	private long guestContact;
	@NotNull
	private String guestEmail;
	@NotNull
	private String guestGender;
	@NotNull
	private String guestAddress;
	
	public long getGuestId() {
		return guestId;
	}
	public void setGuestId(long guestId) {
		this.guestId = guestId;
	}
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public long getGuestContact() {
		return guestContact;
	}
	public void setGuestContact(long guestContact) {
		this.guestContact = guestContact;
	}
	public String getGuestEmail() {
		return guestEmail;
	}
	public void setGuestEmail(String guestEmail) {
		this.guestEmail = guestEmail;
	}
	public String getGuestGender() {
		return guestGender;
	}
	public void setGuestGender(String guestGender) {
		this.guestGender = guestGender;
	}
	public String getGuestAddress() {
		return guestAddress;
	}
	public void setGuestAddress(String guestAddress) {
		this.guestAddress = guestAddress;
	}
	
	public Guest(@NotNull(message="Guest ID cannnot be null")long guestId, 
			@NotNull(message="Guest Name cannnot be null")String guestName,
			@NotNull(message="Guest Contact cannnot be null")@Size(min=10,message="Guest Contact should be minimum 10 digits")long guestContact,
			@NotNull(message="Guest MailID cannnot be null")String guestEmail,
			@NotNull(message="Guest Gender cannnot be null")String guestGender,
			@NotNull(message="Guest Address cannnot be null")String guestAddress) {
		super();
		this.guestId = guestId;
		this.guestName = guestName;
		this.guestContact = guestContact;
		this.guestEmail = guestEmail;
		this.guestGender = guestGender;
		this.guestAddress = guestAddress;
	}
	public Guest() {
		
	}
	
	@Override
	public String toString() {
		return "Guest [guestId=" + guestId + ", guestName=" + guestName + ", guestContact=" + guestContact
				+ ", guestEmail=" + guestEmail + ", guestGender=" + guestGender + ", guestAddress=" + guestAddress
				+ "]";
	}
		
}
