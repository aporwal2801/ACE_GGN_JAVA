package sap.main;

import sap.impl.EntertainmentTaxVisitor;
import sap.impl.SalesTaxVisitorImpl;
import sap.intf.Visitable;
import sap.intf.Visitor;
import sap.items.Cigarrete;
import sap.items.Tobacco;

public class Main {

	public static void main(String[] args) {

		Tobacco tobby = new Tobacco();
		tobby.setName("JhatkaPanMasala");
		tobby.setPrice(10.0f);

		Cigarrete cig = new Cigarrete();
		cig.setName("Goldflake");
		cig.setPrice(15.0f);

		Visitor salesTax = new SalesTaxVisitorImpl();
		Visitor entTax = new EntertainmentTaxVisitor();

		Visitable[] visitableItems = new Visitable[]{cig, tobby};
		float sum = 0f;
		
		for(Visitable item : visitableItems){
			sum = sum + item.accept(salesTax) + item.accept(entTax);
		}
		
		System.out.println("Total Sum of Items :"
				+ sum);

	}
}
