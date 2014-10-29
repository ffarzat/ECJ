package ec.app.GETeste;

import ec.EvolutionState;
import ec.Problem;
import ec.gp.ADFStack;
import ec.gp.GPData;
import ec.gp.GPIndividual;
import ec.gp.GPNode;

public class Escrever extends GPNode {

	@Override
	public String toString() {
		return "Escrever";
	}
	
    //public int expectedChildren() { return 2; }

	@Override
	public void eval(EvolutionState state, int thread, GPData input, ADFStack stack, GPIndividual individual, Problem problem)  
	{
		
/*		SomaData rd = ((SomaData)(input));
    	rd.valor_1 = 3;
    	rd.valor_2 = 4;
		rd.total += 50;*/
		
		for (int i = 0; i < 10000; i++) {			
		}

	}

}
