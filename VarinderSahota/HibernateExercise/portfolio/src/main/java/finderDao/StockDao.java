package finderDao;

import java.util.List;

import model.Stock;

public interface StockDao {

	public List<Stock> getStockList();
	public Stock getByStockName(Stock stockInfo);
	public void save(Stock stockInfo);
	public int updateById(Stock stockInfo);
	public int deleteById(Stock stockInfo);
}
