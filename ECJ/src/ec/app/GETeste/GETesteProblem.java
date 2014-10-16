package ec.app.GETeste;

import ec.EvolutionState;
import ec.Individual;
import ec.gp.GPIndividual;
import ec.gp.GPProblem;
import ec.gp.koza.KozaFitness;
import ec.simple.SimpleProblemForm;

public class GETesteProblem extends GPProblem implements SimpleProblemForm 
{
	
	public double currentX;
    public double currentY;
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Override
	public void evaluate(EvolutionState state, Individual ind, int subpopulation, int threadnum) 
	{

		if (!ind.evaluated) 
		{
			DoubleData input = (DoubleData)(this.input);
			
            
			double fitness = 0.0;
            
			long time = System.nanoTime();
            
			((GPIndividual)ind).trees[0].child.eval(state, threadnum, input, stack, (GPIndividual) ind, this);
						
			long totalTime = (System.nanoTime() - time) ; 
			
			//System.out.println(input.z);
			
			if(input.z == (input.x + input.y) ) //A soma bate?
			{
				fitness = totalTime ; 
				System.out.println(totalTime);
			}
			
			// the fitness better be KozaFitness!
	        KozaFitness f = ((KozaFitness)ind.fitness);
	        f.setStandardizedFitness(state,(fitness));
	        f.hits = Integer.parseInt(String.valueOf(totalTime));
	        ind.evaluated = true;
			
	        if(fitness > 0)
	        	ind.printIndividualForHumans(state, threadnum);
		}
		
		
		
		
	}

}
