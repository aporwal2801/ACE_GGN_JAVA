package service;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import model.Address;
import model.Customer;
import model.CustomerAccount;
import model.CustomerTransaction;
import model.CustomerTransactionKey;
import model.Stock;
import finderDao.CustomerDao;
import finderDao.CustomerDaoImpl;
import finderDao.CustomerTransactionDao;
import finderDao.CustomerTransactionDaoImpl;
import finderDao.EntityOrHibernateDaoAccess;
import finderDao.StockDaoImpl;


public class PortFolioStockImpl implements PortFolioStock {
	
	
	
	public Boolean buyStock(PortfolioStockInput psInfo) 
	{
		
		Boolean result = false;
		
		CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();  
		StockDaoImpl stockDaoImpl  = new StockDaoImpl(); 
		
		Customer customerResult = customerDaoImpl.getAndSetCustomerData(psInfo);
		Stock stockResult = stockDaoImpl.getAndSetStockData(psInfo);
		
		System.out.println("Stock Purchase Request Quantity : "+psInfo.getStockRequestQuantity());
		System.out.println("Stock Name : "+psInfo.getStockInfo().getStockName()+" Price : "+psInfo.getStockInfo().getStockPrice());
		
		double totalPurchaseAmount = psInfo.getStockInfo().getStockPrice() * psInfo.getStockRequestQuantity();
		System.out.println("Calculated Price of Requested Stocks : "+totalPurchaseAmount);
		
		
		if(psInfo.getStockInfo().getCurrentQuantity() >= psInfo.getStockRequestQuantity())
		{
			System.out.println("Stock Avaliable");
			
			if(psInfo.getCustomerInfo().getCustomerAccount().getAccountBalance() > 0.0D &&
					psInfo.getCustomerInfo().getCustomerAccount().getAccountBalance() >= totalPurchaseAmount)
			{
				
				System.out.println("Customer Balance Avaliable for Transaction");
				
				customerResult.getCustomerAccount().setAccountBalance(customerResult.getCustomerAccount().getAccountBalance() - totalPurchaseAmount);
				stockResult.setCurrentQuantity(stockResult.getCurrentQuantity() - psInfo.getStockRequestQuantity());
				
				EntityManagerFactory emf = EntityOrHibernateDaoAccess.getEntityManagerFactory();
				EntityManager em = emf.createEntityManager();
				
				Customer customerPersisted = em.find(Customer.class, psInfo.getCustomerInfo().getCustomerId());
				
				customerPersisted.getCustomerAccount().setAccountBalance(Double.valueOf(customerPersisted.getCustomerAccount().getAccountBalance() - totalPurchaseAmount));
				
				em.getTransaction().begin();
				em.persist(customerPersisted);
				em.getTransaction().commit();
				em.close();
				
				stockDaoImpl.updateById(stockResult);
				
				System.out.println("Customer and Stock Table Updated");
				
				CustomerTransaction customerTransactionInfo = new CustomerTransaction();
				customerTransactionInfo.setQuantity(psInfo.getStockRequestQuantity());
				customerTransactionInfo.setTotalAmount(psInfo.getStockInfo().getStockPrice() * psInfo.getStockRequestQuantity());
				
				CustomerTransactionKey customerTransactionKey = new CustomerTransactionKey();
				
				customerTransactionKey.setCustomerId(psInfo.getCustomerInfo().getCustomerId());
				customerTransactionKey.setStockId(psInfo.getStockInfo().getStockId());
				customerTransactionKey.setTransactionType("BUY");
				
				customerTransactionInfo.setCustomerTransactionKey(customerTransactionKey);
				
				createStockTransactionEntry(customerTransactionInfo);
				
				System.out.println("Transaction Inserted");
				result = true;
			}
		}
		
		return result;
	}
	
	public void createStockTransactionEntry(CustomerTransaction customerTransactionInfo)
	{
		CustomerTransactionDao finderCustomerTransaction = new CustomerTransactionDaoImpl();
		finderCustomerTransaction.save(customerTransactionInfo);
		
	}

	public Boolean sellStock(PortfolioStockInput psInfo) {
		
		Boolean result = false;
		
		CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();  
		StockDaoImpl stockDaoImpl  = new StockDaoImpl(); 
		
		Customer customerResult = customerDaoImpl.getAndSetCustomerData(psInfo);
		Stock stockResult = stockDaoImpl.getAndSetStockData(psInfo);
		
		System.out.println("Stock Sell Request Quantity : "+psInfo.getStockRequestQuantity());
		System.out.println("Stock Name : "+psInfo.getStockInfo().getStockName()+" Price : "+psInfo.getStockInfo().getStockPrice());
		
		double totalSaleAmount = psInfo.getStockInfo().getStockPrice() * psInfo.getStockRequestQuantity();
		System.out.println("Calculated Price of Requested Sale Stocks : "+totalSaleAmount);
		
				stockResult.setCurrentQuantity(stockResult.getCurrentQuantity() + psInfo.getStockRequestQuantity());
				
				EntityManagerFactory emf = EntityOrHibernateDaoAccess.getEntityManagerFactory();
				EntityManager em = emf.createEntityManager();
				
				Customer customerPersisted = em.find(Customer.class, psInfo.getCustomerInfo().getCustomerId());
				
				customerPersisted.getCustomerAccount().setAccountBalance(Double.valueOf(customerPersisted.getCustomerAccount().getAccountBalance() + totalSaleAmount));
				
				em.getTransaction().begin();
				em.persist(customerPersisted);
				em.getTransaction().commit();
				em.close();
				
				stockDaoImpl.updateById(stockResult);
				
				System.out.println("Customer and Stock Table Updated");
				
				CustomerTransaction customerTransactionInfo = new CustomerTransaction();
				customerTransactionInfo.setQuantity(psInfo.getStockRequestQuantity());
				customerTransactionInfo.setTotalAmount(psInfo.getStockInfo().getStockPrice() * psInfo.getStockRequestQuantity());
				
				CustomerTransactionKey customerTransactionKey = new CustomerTransactionKey();
				
				customerTransactionKey.setCustomerId(psInfo.getCustomerInfo().getCustomerId());
				customerTransactionKey.setStockId(psInfo.getStockInfo().getStockId());
				customerTransactionKey.setTransactionType("SELL");
				
				customerTransactionInfo.setCustomerTransactionKey(customerTransactionKey);
				
				createStockTransactionEntry(customerTransactionInfo);
				
				System.out.println("Transaction Inserted");
				result = true;
		
		return result;
	}

	public List<String> selectCustomersWithNegativeBalance() {
		List<String> customerList = null;
		CustomerDao customerDao = new CustomerDaoImpl();
		customerList = customerDao.getCustomerWithNegativeBalance();
		return customerList;
	}

	public List<String> selectCustomersWithNoTransaction() {
		List<String> customerList = null;
		CustomerTransactionDao customerTransactionDao = new CustomerTransactionDaoImpl();
		customerList = customerTransactionDao.getCustomerWithNoTransaction();
		return customerList;
}

	public Double calculateInvestmentOfCustomer(Customer customerInfo) {
		Double investment = 0.0d;
		CustomerTransactionDao customerTransactionDao = new CustomerTransactionDaoImpl();
		CustomerDao customerDao = new CustomerDaoImpl();
		customerInfo = customerDao.getCustomerByName(customerInfo);
		System.out.println("customer id = "+customerInfo.getCustomerId());
		investment = customerTransactionDao.calculateInvestmentOfCustomer(customerInfo);
		return investment;
		
	}
	
	public void createCustomerWithAddressAndAccount(Customer customerInfo)
	{
		EntityManagerFactory entityManagerFactory = EntityOrHibernateDaoAccess.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(customerInfo);
		entityManager.getTransaction().commit();
		entityManager.close();
		
	}
	
	public void createStock(Stock stockInfo)
	{
		EntityManagerFactory entityManagerFactory = EntityOrHibernateDaoAccess.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(stockInfo);
		entityManager.getTransaction().commit();
		entityManager.close();
		
	}
	
	
	public static void main(String[] args)
	{
		PortFolioStock portFolioStock = new PortFolioStockImpl();
		
		Customer customerInfo = new Customer();
		customerInfo.setfName("Ishan");			//Mandatory
		customerInfo.setlName("Aggarwal");
		customerInfo.setCustomerAccount(new CustomerAccount("DEBIT_CARD", 2000d));
		customerInfo.setCustomerAddress(new Address("Sector 15", 8010143005l, "ishan_aggarwal@ymail.com"));
		
		Stock stockInfo = new Stock();
		stockInfo.setStockName("DCBA");		//Mandatory
		stockInfo.setStockPrice(20d);
		stockInfo.setTotalQuantity(100);
		stockInfo.setCurrentQuantity(100);
		
		//Pre-requiste to create the customer and Stock
		portFolioStock.createCustomerWithAddressAndAccount(customerInfo);
		portFolioStock.createStock(stockInfo);		
		
		PortfolioStockInput psInfo = new PortfolioStockInput();
		
		psInfo.setCustomerInfo(customerInfo);
		psInfo.setStockInfo(stockInfo);
		
		psInfo.setStockRequestQuantity(20);		//Buy or Sell Quantity.
		
		
		//Actual Methods that can be called as per Client Requirement 
		portFolioStock.buyStock(psInfo);
		portFolioStock.sellStock(psInfo);
		Double customerInvestment = portFolioStock.calculateInvestmentOfCustomer(customerInfo);
		System.out.println(" Customer Investment Amount = "+customerInvestment);
		
		//List<String> customerNameList = portFolioStock.selectCustomersWithNegativeBalance();
		List<String> customerNameList = portFolioStock.selectCustomersWithNoTransaction();
		
		System.out.println("list size = "+customerNameList.size());
		for(String s : customerNameList)
		System.out.println(" Customer Name = "+s.toString());
		
			
	}

	
}
