/*
  Copyright 2006 by Sean Luke
  Licensed under the Academic Free License version 3.0
  See the file "LICENSE" for more information
*/


package ec.app.GITeste;
import ec.*;
import ec.gp.*;
import ec.util.*;

public class X extends GPNode
    {

	public String toString() { return "X"; }

    public void eval(final EvolutionState state,
        final int thread,
        final GPData input,
        final ADFStack stack,
        final GPIndividual individual,
        final Problem problem)
        {
    		GITesteData rd = ((GITesteData)(input));
        	rd.inteiro = ((GITesteProblem)problem).currentX;
        }
    }

