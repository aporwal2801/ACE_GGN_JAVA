package finderDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;

import model.Customer;
import model.CustomerTransaction;
import constants.PortfolioConstants;

public class CustomerTransactionDaoImpl implements CustomerTransactionDao{
	
	EntityManagerFactory entityManagerFactory  = null;
	
	public CustomerTransactionDaoImpl(){
		entityManagerFactory = EntityOrHibernateDaoAccess.getEntityManagerFactory();
	}


	public void save(CustomerTransaction customerTransactionInfo) {
	
		EntityManager entityManager  = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(customerTransactionInfo);
		entityManager.getTransaction().commit();
		entityManager.close();
		
	}


	public List<String> getCustomerWithNoTransaction() {
		
		System.out.println("In getCustomerWithNoTransaction");
		EntityManager entityManager  = entityManagerFactory.createEntityManager();
		
		List<String> customerResult = null;
		
		entityManager.getTransaction().begin();
		
		customerResult = (List<String>) entityManager.createQuery(PortfolioConstants.selectCustomerWithNoTransaction).getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		
		return customerResult;
		
	}


	public Double calculateInvestmentOfCustomer(Customer customerInfo) {
		
		System.out.println("In calculateInvestmentOfCustomer");
		EntityManager entityManager  = entityManagerFactory.createEntityManager();
		
		Double investment ;
		
		entityManager.getTransaction().begin();
		
		investment = (Double) entityManager.createQuery(PortfolioConstants.calculateCustomerInvestment).
				setParameter("customerId", customerInfo.getCustomerId()).getSingleResult();
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
		return investment;
	
	}

	
	
}
