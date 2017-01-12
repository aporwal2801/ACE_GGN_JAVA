package service;

import java.util.List;

import model.Customer;
import model.Stock;

public interface PortFolioStock {

	public Boolean buyStock(PortfolioStockInput psInfo);
	public Boolean sellStock(PortfolioStockInput psInfo);
	public List<String> selectCustomersWithNegativeBalance();
	public List<String> selectCustomersWithNoTransaction();
	public Double calculateInvestmentOfCustomer(Customer customerInfo);
	public void createCustomerWithAddressAndAccount(Customer customerInfo);
	public void createStock(Stock stockInfo);
	
}
