package model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CustomerTransactionKey  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5740891283783722375L;
	private Integer customerId;
	private Integer stockId;
	private String transactionType;
	
	
	
	public CustomerTransactionKey(Integer customerId, Integer stockId) {
		super();
		this.customerId = customerId;
		this.stockId = stockId;
	}
	
	
	public CustomerTransactionKey() {
	}

	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getStockId() {
		return stockId;
	}
	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}
	
	
}
