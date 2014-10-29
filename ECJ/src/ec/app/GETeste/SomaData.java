/*
  Copyright 2006 by Sean Luke
  Licensed under the Academic Free License version 3.0
  See the file "LICENSE" for more information
*/


package ec.app.GETeste;
import ec.gp.*;

public class SomaData extends GPData
    {
    public double valor_1;    // valor 1
    public double valor_2;    // valor 2
    public double total;    // Total

    public void copyTo(final GPData gpd)   // copy my stuff to another DoubleData
        { 
    	((SomaData)gpd).valor_1 = valor_1; 
    	((SomaData)gpd).valor_2 = valor_2;
    	((SomaData)gpd).total = total;
    	}
    }


