package finderDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import constants.PortfolioConstants;
import service.PortfolioStockInput;
import model.Customer;

public class CustomerDaoImpl implements CustomerDao{
	
	EntityManagerFactory entityManagerFactory  = null;
	
	public CustomerDaoImpl(){
		entityManagerFactory = EntityOrHibernateDaoAccess.getEntityManagerFactory();
	}

	public List<Customer> getCustomerList() {
		List<Customer> customerList = null;
		CriteriaQuery<Customer> customerCriteriaQuery = null;
		
		EntityManager entityManager  = entityManagerFactory.createEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		
		customerCriteriaQuery = builder.createQuery(Customer.class);
		
		entityManager.getTransaction().begin();
		customerList = (List<Customer>) entityManager.createQuery(customerCriteriaQuery).getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		
		return customerList;
		}

	public Customer getCustomerByName(Customer customerInfo) {
		System.out.println("In getCustomerByName");
		EntityManager entityManager  = entityManagerFactory.createEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Customer> customerCriteriaQuery = builder.createQuery(Customer.class);
		Root<Customer> customerRoot = customerCriteriaQuery.from(Customer.class);
		
		Customer customerResult = null;
		
		entityManager.getTransaction().begin();
		
		customerCriteriaQuery.select(customerRoot);
		customerCriteriaQuery.where(builder.equal(customerRoot.get("fName"),customerInfo.getfName()));
		
		customerResult = entityManager.createQuery(customerCriteriaQuery).getSingleResult();
		entityManager.getTransaction().commit();
		entityManager.close();
		
		return customerResult;

	}

	public void save(Customer customerInfo) {
		
		EntityManager entityManager  = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(customerInfo);
		entityManager.getTransaction().commit();
		entityManager.close();
		
		
	}

	public int updateCustomerById(Customer customerInfo) {
		EntityManager entityManager  = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		String jpqlUpdate = "update Customer set fName = :newfName , lName = :newlName  where customer_id = :id";
				int updatedEntities = entityManager.createQuery(jpqlUpdate)
				                            .setParameter("id", customerInfo.getCustomerId())
				                            .setParameter("newlName", customerInfo.getlName())
				                            .setParameter("newfName", customerInfo.getfName())
				                            .executeUpdate();
		
		entityManager.getTransaction().commit();
		entityManager.close();
		return updatedEntities;
	}

	public int deleteCustomerById(Customer customerInfo) {
		EntityManager entityManager  = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		String jpqlUpdate = "delete Customer where customer_id = :id";
				int updatedEntities = entityManager.createQuery( jpqlUpdate )
				                            .setParameter( "id", customerInfo.getCustomerId())
				                            .executeUpdate();
		
		entityManager.getTransaction().commit();
		entityManager.close();
		return updatedEntities;
	
	}
	
	public Customer getAndSetCustomerData(PortfolioStockInput psInfo)
	{
		Customer customerResult = getCustomerByName(psInfo.getCustomerInfo());
		System.out.println("Retrieved Customer Data = "+customerResult.toString());
		psInfo.setCustomerInfo(customerResult);
		return customerResult;
		
	}

	public List<String> getCustomerWithNegativeBalance() {
		List<String> customerList = null;
		EntityManager entityManager  = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		customerList = (List<String>) entityManager.createQuery(PortfolioConstants.selectCustomerWithNegativeBalance).getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		
		return customerList;
		
	}

}
