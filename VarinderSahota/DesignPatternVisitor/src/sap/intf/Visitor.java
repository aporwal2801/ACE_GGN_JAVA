package sap.intf;

import sap.items.Cigarrete;
import sap.items.Tobacco;

public interface Visitor{

	  public float visit(Tobacco tobacco);	

	  public float visit(Cigarrete cig);

	}