package com.sapient.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EQUITY")
public class Equity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EQUITY_ID")
	private Integer equityId;

	@Column(name = "SYMBOL")
	private String symbol;

	@Column(name = "SECURITY_NAME")
	private String securityName;

	@Column(name = "SECURITY_TYPE")
	private String type;

	@Column(name = "QUANTITY")
	private Integer quantity;

	public Equity() {
		super();
	}

	public Equity(String symbol, String securityName, String type,
			Integer quantity) {
		super();
		this.symbol = symbol;
		this.securityName = securityName;
		this.type = type;
		this.quantity = quantity;
	}

	public Integer getEquityId() {
		return equityId;
	}

	public void setEquityId(Integer equityId) {
		this.equityId = equityId;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getSecurityName() {
		return securityName;
	}

	public void setSecurityName(String securityName) {
		this.securityName = securityName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Equity [equityId=" + equityId + ", symbol=" + symbol
				+ ", securityName=" + securityName + ", type=" + type
				+ ", quantity=" + quantity + "]";
	}

}
