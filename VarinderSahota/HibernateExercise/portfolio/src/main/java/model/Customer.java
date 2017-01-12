package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Customer {

	@Id
	@Column(name = "CUSTOMER_ID")
	@GeneratedValue
	private Integer customerId;
	private String fName;
	private String lName;
	
	@OneToOne(fetch = FetchType.EAGER,
			cascade=CascadeType.ALL)
	@JoinColumn(name = "ADDRESS_ID")
	private Address customerAddress;
	
	
	@OneToOne(fetch = FetchType.EAGER,
			cascade=CascadeType.ALL)
	@JoinColumn(name = "ACCOUNT_ID")
	private CustomerAccount customerAccount;
	
		
	public Customer(String fName, String lName,
			Address customerAddress, CustomerAccount customerAccount) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.customerAddress = customerAddress;
		this.customerAccount = customerAccount;
	}
	
	
	public Customer() {
		
	}


	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	
	public Address getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(Address customerAddress) {
		this.customerAddress = customerAddress;
	}
	
	public CustomerAccount getCustomerAccount() {
		return customerAccount;
	}
	public void setCustomerAccount(CustomerAccount customerAccount) {
		this.customerAccount = customerAccount;
	}
	
	@Override
	public String toString() {
		return "Client [customerId=" + customerId + ", fName=" + fName
				+ ", lName=" + lName + ", customerAddress=" + customerAddress
				+ ", customerAccount=" + customerAccount + "]";
	}
	
	
	
}
