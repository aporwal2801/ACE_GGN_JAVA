package finderDao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EntityOrHibernateDaoAccess {
	
	private static final EntityManagerFactory entityManagerFactory;
	
	static
	{
		entityManagerFactory = Persistence.createEntityManagerFactory("StockPortFolioApp");
		System.out.println("entityManagerFactory = "+ entityManagerFactory);
		
	}

	public static EntityManagerFactory getEntityManagerFactory()
	{
		 return entityManagerFactory;
	}
	
	
	public static SessionFactory getHibernateSessionFactory()
	{
		
		SessionFactory hibernateSessionFactory  = null;
		if(hibernateSessionFactory == null)
		{
			hibernateSessionFactory = new Configuration().configure().buildSessionFactory();
		}
			 return hibernateSessionFactory;
		 
	}
	
}
