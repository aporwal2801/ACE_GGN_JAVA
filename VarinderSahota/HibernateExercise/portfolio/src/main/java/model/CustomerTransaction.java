package model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class CustomerTransaction {

	@EmbeddedId()
	private CustomerTransactionKey customerTransactionKey;
	
	private Integer quantity;
	private Double totalAmount;
	
		
	public CustomerTransaction(CustomerTransactionKey key ,
			Integer quantity, Double totalAmount, String transactionType) {
		super();
		this.customerTransactionKey = key;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
	}
	
	public CustomerTransaction() {
		
	}

	public CustomerTransactionKey getCustomerTransactionKey() {
		return customerTransactionKey;
	}

	public void setCustomerTransactionKey(
			CustomerTransactionKey customerTransactionKey) {
		this.customerTransactionKey = customerTransactionKey;
	}

	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	@Override
	public String toString() {
		return "CustomerTransaction [customerTransactionKey="
				+ customerTransactionKey + ", quantity=" + quantity
				+ ", totalAmount=" + totalAmount + "]";
	}
	
}
