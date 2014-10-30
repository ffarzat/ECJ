/*
  Copyright 2006 by Sean Luke
  Licensed under the Academic Free License version 3.0
  See the file "LICENSE" for more information
*/


package ec.app.GETipado;
import ec.gp.*;

public class GETipadoData extends GPData
    {
    public Integer inteiro;
    public String texto;

    public void copyTo(final GPData gpd)   // copy my stuff to another DoubleData
        { 
    	((GETipadoData)gpd).inteiro = inteiro; 
    	((GETipadoData)gpd).texto = texto;
    	}
    }


