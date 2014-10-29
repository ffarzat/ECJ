package ec.app.GETeste;

import ec.*;
import ec.gp.*;
import ec.util.*;

import ec.EvolutionState;
import ec.Problem;
import ec.gp.ADFStack;
import ec.gp.GPData;
import ec.gp.GPIndividual;

public class Somar extends GPNode {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public String toString() { return "SOMA"; }
	
	//public int expectedChildren() { return 2; }
	
	
	public void eval(final EvolutionState state, final int thread, final GPData input, final ADFStack stack, final GPIndividual individual, final Problem problem)
    {
        double result;
        SomaData rd = ((SomaData)(input));

        children[0].eval(state,thread,input,stack,individual,problem);
     
        children[1].eval(state,thread,input,stack,individual,problem);
        
        //Faz a soma (acumula para errar quando chamar a soma várias vezes
        rd.total += (rd.valor_1 + rd.valor_2);
    }

}
