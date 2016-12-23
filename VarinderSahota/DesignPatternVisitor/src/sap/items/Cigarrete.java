package sap.items;

import sap.intf.Visitable;
import sap.intf.Visitor;

public class Cigarrete implements Visitable{

	private String name;
	private float price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public float accept(Visitor visitor) {
		return visitor.visit(this);
		
	}
	
	
}
