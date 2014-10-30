package ec.app.GETipado;

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
	
	@Override
	public void eval(EvolutionState state, int thread, GPData input,
			ADFStack stack, GPIndividual individual, Problem problem) 
	{
		for (int i = 0; i < 10000; i++) {
		}
	}
}
