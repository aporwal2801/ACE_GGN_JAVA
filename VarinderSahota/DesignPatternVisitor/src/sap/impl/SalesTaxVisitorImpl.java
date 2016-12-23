package sap.impl;

import sap.intf.Visitor;
import sap.items.Cigarrete;
import sap.items.Tobacco;

public class SalesTaxVisitorImpl implements Visitor{

	float cost;
	
	@Override
	public float visit(Tobacco tobacco) {
		return cost = tobacco.getPrice()*2.0f;
	}

	@Override
	public float visit(Cigarrete cig) {
		return cost = cig.getPrice()*3.0f;
	}
}
