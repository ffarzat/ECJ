package ec.app.GETipado;

import ec.*;
import ec.gp.*;
import ec.util.*;

import ec.EvolutionState;
import ec.Problem;
import ec.gp.ADFStack;
import ec.gp.GPData;
import ec.gp.GPIndividual;

public class Somar extends GPNode {

	public String toString() { return "SOMA"; }
	
	public void eval(final EvolutionState state, final int thread, final GPData input, final ADFStack stack, final GPIndividual individual, final Problem problem)
    {
        GETipadoData rd = ((GETipadoData)(input));
        children[0].eval(state,thread,input,stack,individual,problem);
        Integer resultado = rd.inteiro;
        
        children[1].eval(state,thread,input,stack,individual,problem);
        resultado +=rd.inteiro;
        
        //Faz a soma
        rd.inteiro = resultado;
    }

}
