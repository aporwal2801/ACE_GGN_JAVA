package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Stock {

	@Id
	@Column(name="STOCK_ID")
	@GeneratedValue
	private Integer stockId;
	
	private String stockName;
	private Integer totalQuantity;
	private Integer currentQuantity;
	private Double stockPrice;
		
	public Stock()
	{}
	
	public Stock(String stockName, Integer totalQuantity,
			Integer currentQuantity, Double stockPrice) {
		super();
		this.stockName = stockName;
		this.totalQuantity = totalQuantity;
		this.currentQuantity = currentQuantity;
		this.stockPrice = stockPrice;
	}
	
	
	public Integer getStockId() {
		return stockId;
	}
	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public Integer getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(Integer totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public Integer getCurrentQuantity() {
		return currentQuantity;
	}
	public void setCurrentQuantity(Integer currentQuantity) {
		this.currentQuantity = currentQuantity;
	}
	public Double getStockPrice() {
		return stockPrice;
	}
	public void setStockPrice(Double stockPrice) {
		this.stockPrice = stockPrice;
	}


	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", stockName=" + stockName
				+ ", totalQuantity=" + totalQuantity + ", currentQuantity="
				+ currentQuantity + ", stockPrice=" + stockPrice + "]";
	}
	
	
	
}
