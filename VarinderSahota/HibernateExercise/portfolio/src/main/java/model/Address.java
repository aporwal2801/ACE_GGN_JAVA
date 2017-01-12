package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Address {
	
	@Id
	@Column(name = "ADDRESS_ID")
	@GeneratedValue
	private Integer addressId;
	
	private String streetName;
	private Long contactNumber;
	private String emailId;
	
	public Address()
	{}
	
	public Address(String streetName, Long contactNumber, String emailId) {
		super();
		this.streetName = streetName;
		this.contactNumber = contactNumber;
		this.emailId = emailId;
	}
	
	
	public Integer getAddressId() {
		return addressId;
	}


	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}


	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public Long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
	@Override
	public String toString() {
		return "Address [streetName=" + streetName + ", contactNumber="
				+ contactNumber + ", emailId=" + emailId + "]";
	}
	
	
}
