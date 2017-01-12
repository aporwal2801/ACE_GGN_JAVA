package finderDao;

import java.util.List;

import model.Customer;

public interface CustomerDao {

	public List<Customer> getCustomerList();
	public Customer getCustomerByName(Customer customerInfo);
	public void save(Customer customerInfo);
	public int updateCustomerById(Customer customerInfo);
	public int deleteCustomerById(Customer customerInfo);
	public List<String> getCustomerWithNegativeBalance();
	
	
}
