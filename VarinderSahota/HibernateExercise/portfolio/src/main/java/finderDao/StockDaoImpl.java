package finderDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import service.PortfolioStockInput;
import model.Stock;

public class StockDaoImpl implements StockDao{

	EntityManagerFactory entityManagerFactory  = null;
	
	public StockDaoImpl(){
		entityManagerFactory = EntityOrHibernateDaoAccess.getEntityManagerFactory();
	}
	
	public List<Stock> getStockList() {
		
		List<Stock> stockList = null;
		CriteriaQuery<Stock> stockCriteriaQuery = null;
		
		EntityManager entityManager  = entityManagerFactory.createEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		
		stockCriteriaQuery = builder.createQuery(Stock.class);
		
		entityManager.getTransaction().begin();
		stockList = (List<Stock>) entityManager.createQuery(stockCriteriaQuery).getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		
		return stockList;
	}

	public Stock getByStockName(Stock stockInfo) {
		
		EntityManager entityManager  = entityManagerFactory.createEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Stock> stockCriteriaQuery = builder.createQuery(Stock.class);
		Root<Stock> stockRoot = stockCriteriaQuery.from(Stock.class);
		
		Stock stockResult = null;
		
		entityManager.getTransaction().begin();
		
		stockCriteriaQuery.select(stockRoot);
		stockCriteriaQuery.where(builder.equal(stockRoot.get("stockName"),stockInfo.getStockName()));
		
		stockResult = (Stock) entityManager.createQuery(stockCriteriaQuery).getSingleResult();
		entityManager.getTransaction().commit();
		entityManager.close();
		return stockResult;
	}

	public void save(Stock stockInfo) {
		
		EntityManager entityManager  = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(stockInfo);
		entityManager.getTransaction().commit();
		entityManager.close();
		
	}

	public int updateById(Stock stockInfo) {
		
		EntityManager entityManager  = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		String jpqlUpdate = "update Stock set totalQuantity = :newtotalQuantity , currentQuantity = :newCurrentQuantity,"
				+ "stockPrice = :newStockPrice , stockName = :newStockName where stock_id = :stockId";
				int updatedEntities = entityManager.createQuery( jpqlUpdate )
				                            .setParameter( "newStockName", stockInfo.getStockName() )
				                            .setParameter( "newStockPrice", stockInfo.getStockPrice() )
				                            .setParameter("newCurrentQuantity", stockInfo.getCurrentQuantity())
				                            .setParameter("newtotalQuantity", stockInfo.getTotalQuantity())
				                            .setParameter("stockId", stockInfo.getStockId())
				                            .executeUpdate();
		
		entityManager.getTransaction().commit();
		entityManager.close();
		return updatedEntities;
		
	}

	public int deleteById(Stock stockInfo) {
		EntityManager entityManager  = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		String jpqlUpdate = "delete Stock where stock_id = :stockId";
				int updatedEntities = entityManager.createQuery( jpqlUpdate )
				                            .setParameter( "stockId", stockInfo.getStockId())
				                            .executeUpdate();
		
		entityManager.getTransaction().commit();
		entityManager.close();
		return updatedEntities;
	}
	
	public Stock getAndSetStockData(PortfolioStockInput psInfo)
	{
		
		Stock stockResult = getByStockName(psInfo.getStockInfo());
		System.out.println("Retrieved Stock Data = "+stockResult.toString());
		psInfo.setStockInfo(stockResult);
		return stockResult;
	}
	

}
