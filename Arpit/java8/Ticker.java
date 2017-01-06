package java8;

import java.util.Date;

public class Ticker{
	
	private Date timeStamp;
	private String ticker;
	private String currencyFrom;
	private String currencyTo;
	private Double exchangeRate;
	
	public Ticker(Date timeStamp, String ticker, String currencyFrom,
			String currencyTo, Double exchangeRate) {
		this.timeStamp = timeStamp;
		this.ticker = ticker;
		this.currencyFrom = currencyFrom;
		this.currencyTo = currencyTo;
		this.exchangeRate = exchangeRate;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public String getCurrencyFrom() {
		return currencyFrom;
	}

	public void setCurrencyFrom(String currencyFrom) {
		this.currencyFrom = currencyFrom;
	}

	public String getCurrencyTo() {
		return currencyTo;
	}

	public void setCurrencyTo(String currencyTo) {
		this.currencyTo = currencyTo;
	}

	public Double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(Double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	
	
}