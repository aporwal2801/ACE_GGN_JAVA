package finderDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import model.Address;

public class AddressDaoImpl implements AddressDao{
	
EntityManagerFactory entityManagerFactory  = null;
	
	public AddressDaoImpl(){
		entityManagerFactory = EntityOrHibernateDaoAccess.getEntityManagerFactory();
	}

	public Address getByEmailId(Address addressInfo) {
		Address addressResult = null;
		
		EntityManager entityManager  = entityManagerFactory.createEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Address> addressCriteriaQuery = builder.createQuery(Address.class);
		Root<Address> addressRoot = addressCriteriaQuery.from(Address.class);
		
		addressCriteriaQuery.select(addressRoot);
		addressCriteriaQuery.where(builder.equal(addressRoot.get("emailId"),addressInfo.getEmailId()));
		
		entityManager.getTransaction().begin();
		addressResult = entityManager.createQuery(addressCriteriaQuery).getSingleResult();
		entityManager.getTransaction().commit();
		entityManager.close();
		
		return addressResult;
	
	}

	public int updateByEmailId(Address addressInfo) {
		EntityManager entityManager  = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		String jpqlUpdate = "update Address set streetName = :newStreetName , contactNumber = :newContactNumber,"
				+ "where emailId = :newEmailId";
				int updatedEntities = entityManager.createQuery( jpqlUpdate )
				                            .setParameter( "newEmailId", addressInfo.getEmailId() )
				                            .setParameter("newStreetName", addressInfo.getStreetName())
				                            .setParameter("newContactNumber", addressInfo.getContactNumber())
				                            .executeUpdate();
		
		entityManager.getTransaction().commit();
		entityManager.close();
		return updatedEntities;
		
	}

}
