package ec.app.angularjs;

import ec.EvolutionState;
import ec.Individual;
import ec.gp.GPIndividual;
import ec.gp.GPProblem;
import ec.gp.koza.KozaFitness;
import ec.simple.SimpleFitness;
import ec.simple.SimpleProblemForm;
import ec.util.Parameter;

public class Problem extends GPProblem implements SimpleProblemForm
{
	
	public Integer currentX;
    public Integer currentY;
    public String texto;
	
    public void setup(final EvolutionState state,
            final Parameter base)
            {
    	
	        // very important, remember this
	        super.setup(state,base);

	        currentX = state.parameters.getInt(base.push("currentX"),null,0);
	        currentY = state.parameters.getInt(base.push("currentY"),null,0);
	        
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
			//GITesteData input = (GITesteData)(this.input);
            
            Integer total = currentX +currentY;

            
			double fitness = 100000.0;
			//input.inteiro = 0;
			
			long time = System.nanoTime();
            
			((GPIndividual)ind).trees[0].child.eval(state, threadnum, input, stack, (GPIndividual) ind, this);
			
			long totalTime = (System.nanoTime() - time); 
			
			
			//if(input.inteiro == 10)
			//{	
				//fitness = ((GPIndividual)ind).trees[0].child.children.length;
				//fitness = 10000 - fitness;

				fitness = totalTime ;
				
				//ind.printIndividualForHumans(state, threadnum);
				//System.out.println("fitness=" + fitness );


				//System.out.println("(input.inteiro=" + input.inteiro );
				//System.out.println("(total=" + total);
				//System.out.println("X=" + currentX );
				//System.out.println("Y=" + currentY );
			//}
			
			// the fitness better be KozaFitness!
	        KozaFitness f = ((KozaFitness)ind.fitness);
	        f.setStandardizedFitness(state,(fitness));
	        //f.hits = Integer.parseInt(String.valueOf(totalTime));
			
			//SimpleFitness f = ((SimpleFitness)ind.fitness);
			//f.setFitness(state, fitness);
			ind.evaluated = true;
			
			//
		
		}
		
		
		
		
	}

	
   
	
}
