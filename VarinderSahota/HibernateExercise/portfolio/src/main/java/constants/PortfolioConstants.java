package constants;

public class PortfolioConstants {
	
	public static String selectCustomerWithNoTransaction = "select c.fName || ' ' || c.lName "
			+ " from Customer c where c.customerId not in (select customerTransactionKey.customerId from CustomerTransaction)"; 
	
	public static String selectCustomerWithNegativeBalance = " select c.fName || ' ' || c.lName from "
			+ " Customer c , CustomerAccount ca where c.customerAccount.accountId = ca.accountId and ca.accountBalance < 0"; 
	
	public static String calculateCustomerInvestment = " select sum(ct.totalAmount) as investment "
			+ " from CustomerTransaction ct where ct.customerTransactionKey.transactionType = 'BUY'"
			+ " and ct.customerTransactionKey.customerId = :customerId "; 
	
}
