package ec.app.GETeste;

import ec.EvolutionState;
import ec.Problem;
import ec.gp.ADFStack;
import ec.gp.GPData;
import ec.gp.GPIndividual;
import ec.gp.GPNode;

public class Salvarlog extends GPNode {

	@Override
	public String toString() {
		return "Log";
	}

	//public int expectedChildren() { return 2; }
	
	@Override
	public void eval(EvolutionState state, int thread, GPData input,
			ADFStack stack, GPIndividual individual, Problem problem) 
	{
/*		SomaData rd = ((SomaData)(input));
    	rd.valor_1 = 1;
    	rd.valor_2 = 2;
		rd.total += 100;*/
    	
		for (int i = 0; i < 10000; i++) {
		}
	}
}
