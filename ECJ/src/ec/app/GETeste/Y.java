/*
  Copyright 2006 by Sean Luke
  Licensed under the Academic Free License version 3.0
  See the file "LICENSE" for more information
*/


package ec.app.GETeste;
import ec.*;
import ec.gp.*;
import ec.util.*;

public class Y extends GPNode
    {
	public String toString() { return "Y"; }
	
    //public int expectedChildren() { return 0; }

    public void eval(final EvolutionState state,
        final int thread,
        final GPData input,
        final ADFStack stack,
        final GPIndividual individual,
        final Problem problem)
        {
        	SomaData rd = ((SomaData)(input));
        	rd.valor_2 = ((GETesteProblem)problem).currentY;
        }
    }

