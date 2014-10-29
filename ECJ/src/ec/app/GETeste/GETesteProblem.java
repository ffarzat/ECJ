package ec.app.GETeste;

import ec.EvolutionState;
import ec.Individual;
import ec.gp.GPIndividual;
import ec.gp.GPProblem;
import ec.gp.koza.KozaFitness;
import ec.simple.SimpleFitness;
import ec.simple.SimpleProblemForm;
import ec.util.Parameter;

public class GETesteProblem extends GPProblem implements SimpleProblemForm
{
	
	public double currentX;
    public double currentY;
	
    public void setup(final EvolutionState state,
            final Parameter base)
            {
    	
	        // very important, remember this
	        super.setup(state,base);

	        currentX = state.parameters.getDouble(base.push("currentX"),null,0);
	        currentY = state.parameters.getDouble(base.push("currentY"),null,0);
	        
	        if (currentX==0)
	            state.output.error("The value of currentX was not defined");
	        
	        if (currentY==0)
	            state.output.error("The value of currentY was not defined");
    }
	
	@Override
	public void evaluate(EvolutionState state, Individual ind, int subpopulation, int threadnum) 
	{

		if (!ind.evaluated) 
		{
			SomaData input = (SomaData)(this.input);
            
            double total = currentX +currentY;
            
			double fitness = 0.0;
            
			long time = System.nanoTime();
            
			((GPIndividual)ind).trees[0].child.eval(state, threadnum, input, stack, (GPIndividual) ind, this);
			
			long totalTime = (System.nanoTime() - time); 
			
			if(input.total == total ) //A soma bate? Aqui executaria testes...
			{	
				fitness = totalTime - 100.99;
				//fitness = 100.99;
				SimpleFitness f = ((SimpleFitness) ind.fitness);
				 f.setFitness(state, fitness, false);
				ind.evaluated = true;
				//fitness = totalTime  - 1.0;
				ind.printIndividualForHumans(state, threadnum);
				System.out.println("X=" + currentX );
				System.out.println("Y=" + currentY );
			}
			
			// the fitness better be KozaFitness!
	        //KozaFitness f = ((KozaFitness)ind.fitness);
	        //f.setStandardizedFitness(state,(fitness));
	        //f.hits = Integer.parseInt(String.valueOf(totalTime));
	        
			
			 SimpleFitness f = ((SimpleFitness) ind.fitness);
			 f.setFitness(state, fitness, false);
			ind.evaluated = true;
		
		}
		
		
		
		
	}

	
   
	
}
