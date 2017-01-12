package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class CustomerAccount {

	@Id
	@Column(name = "ACCOUNT_ID")
	@GeneratedValue
	private Integer accountId;
	
	private String accountType;
	private Double accountBalance;
	
	public CustomerAccount()
	{}
	
	public CustomerAccount(String accountType, Double accountBalance) {
		super();
		this.accountType = accountType;
		this.accountBalance = accountBalance;
	}
	
	
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	@Override
	public String toString() {
		return "CustomerAccount [ accountId="
				+ accountId + ", accountType=" + accountType
				+ ", accountBalance=" + accountBalance + "]";
	}

}
