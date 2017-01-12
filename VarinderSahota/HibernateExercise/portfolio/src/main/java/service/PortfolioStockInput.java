package service;

import model.Customer;
import model.Stock;

public class PortfolioStockInput {

	private Customer customerInfo;
	private Stock stockInfo;
	private Integer stockRequestQuantity;
	
	
	
	public PortfolioStockInput(Customer customerInfo, Stock stockInfo) {
		super();
		this.customerInfo = customerInfo;
		this.stockInfo = stockInfo;
	}
	
	
	public PortfolioStockInput() {
	}

	
	public Integer getStockRequestQuantity() {
		return stockRequestQuantity;
	}


	public void setStockRequestQuantity(Integer stockRequestQuantity) {
		this.stockRequestQuantity = stockRequestQuantity;
	}


	public Customer getCustomerInfo() {
		return customerInfo;
	}
	public void setCustomerInfo(Customer customerInfo) {
		this.customerInfo = customerInfo;
	}
	public Stock getStockInfo() {
		return stockInfo;
	}
	public void setStockInfo(Stock stockInfo) {
		this.stockInfo = stockInfo;
	}


	@Override
	public String toString() {
		return "PortfolioStockInput [customerInfo=" + customerInfo + ", stockInfo="
				+ stockInfo + "]";
	}
	
	
}
