package sap.impl;

import sap.intf.Visitor;
import sap.items.Cigarrete;
import sap.items.Tobacco;

public class EntertainmentTaxVisitor implements Visitor{

	float cost;
	
	@Override
	public float visit(Tobacco tobacco) {
		return cost=tobacco.getPrice()*0.05f;
	}

	@Override
	public float visit(Cigarrete cig) {
		return cost=cig.getPrice()*0.01f;
	}

}
