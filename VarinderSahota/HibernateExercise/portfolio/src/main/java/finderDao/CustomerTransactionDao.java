package finderDao;

import java.util.List;

import model.Customer;
import model.CustomerTransaction;

public interface CustomerTransactionDao {

	public void save(CustomerTransaction customerTransactionInfo);
	public List<String> getCustomerWithNoTransaction();
	public Double calculateInvestmentOfCustomer(Customer customerInfo);
	
	
}
