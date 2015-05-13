package ec.app.scriptDatajs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import ec.EvolutionState;
import ec.Individual;
import ec.app.tutorial4.DoubleData;
import ec.gp.GPIndividual;
import ec.gp.GPProblem;
import ec.gp.koza.KozaFitness;
import ec.simple.SimpleFitness;
import ec.simple.SimpleProblemForm;
import ec.util.Parameter;

public class Problem extends GPProblem implements SimpleProblemForm
{
	public String scriptOrigem;
	public String scriptTestes;
	
	public int Ano;
	public int Mes;
	public int Dia;
	public int DiasParaSomar;
	
	public String Texto;
	
    public void setup(final EvolutionState state,
            final Parameter base)
            {
    	
	        // very important, remember this
	        super.setup(state,base);

	        scriptOrigem = state.parameters.getStringWithDefault(base.push("scriptOrigem"), null, "");
	        scriptTestes = state.parameters.getStringWithDefault(base.push("scriptTestes"),null,"");
	        
	        Texto = state.parameters.getStringWithDefault(base.push("Texto"),null,"");
	        
	        Ano = state.parameters.getInt(base.push("Ano"),null,0);
	        Mes = state.parameters.getInt(base.push("Mes"),null,0);
	        Dia = state.parameters.getInt(base.push("Dia"),null,0);
	        DiasParaSomar= state.parameters.getInt(base.push("DiasParaSomar"),null,0);
	        
	        
	        if (scriptOrigem=="")
	            state.output.error("Não foi definido o script alvo da otimização");
	        
	        if (scriptTestes=="")
	            state.output.error("Não foi definido script de Testes");
	        
	        if (Ano == 0)
	            state.output.error("Ano não foi informado");
	        
	        if (Mes == 0)
	            state.output.error("Mês não foi informado");
	        
	        if (Dia == 0)
	            state.output.error("Dia não foi informado");
	        
	        if (DiasParaSomar == 0)
	            state.output.error("Dias para somar a Data não foi informado");
	        
	        
    }
	
	@Override
	public void evaluate(EvolutionState state, Individual ind, int subpopulation, int threadnum) 
	{
		
		scriptDataMesmo dadosEntrada = (scriptDataMesmo)(this.input);
		
		
		dadosEntrada.DiasParaSomar = this.DiasParaSomar;
		dadosEntrada.Dia = this.Dia;
		dadosEntrada.Ano = this.Ano;
		dadosEntrada.Mes = this.Mes;
		dadosEntrada.Texto = this.Texto;
				
		if (!ind.evaluated) 
		{
			double fitness = 0.0;
			
			
			long time = System.nanoTime();
            
			((GPIndividual)ind).trees[0].child.eval(state, threadnum, dadosEntrada, stack, (GPIndividual) ind, this);

			long totalTime = (System.nanoTime() - time); //Calculo o tempo de execução
			
//			System.out.println(totalTime);
//			System.out.println(dadosEntrada.ResultadoExecucaoArvore);
//			ind.printIndividualForHumans(state, threadnum);
			
			if(dadosEntrada.ResultadoExecucaoArvore.equals("7/5/2015")) //Correto! Individuo válido!
			{	
				fitness = totalTime ;
				//ind.printIndividualForHumans(state, threadnum);
			}
			
			// the fitness better be KozaFitness!
	        KozaFitness f = ((KozaFitness)ind.fitness);
	        f.setStandardizedFitness(state,(fitness));
			ind.evaluated = true;
		}
	}
}
