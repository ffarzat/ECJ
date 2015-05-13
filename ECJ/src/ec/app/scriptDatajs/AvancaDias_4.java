package ec.app.scriptDatajs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;





import ec.*;
import ec.gp.*;
import ec.util.*;
import ec.EvolutionState;
import ec.Problem;
import ec.gp.ADFStack;
import ec.gp.GPData;
import ec.gp.GPIndividual;

public class AvancaDias_4 extends GPNode {

	public String toString() { return "AvancaDias_4"; }
    

	public void eval(final EvolutionState state, final int thread, final GPData input, final ADFStack stack, final GPIndividual individual, final Problem problem)
    {
		scriptDataMesmo dadosEntrada = (scriptDataMesmo)(input);
		dadosEntrada.ResultadoExecucaoArvore = executarFuncao(problem, dadosEntrada);
    }


    public String executarFuncao(Problem problem, scriptDataMesmo dadosEntrada)  {
    	
    	ScriptEngineManager engineManager = new ScriptEngineManager();
		@SuppressWarnings("unused")
		ScriptEngine engine = engineManager.getEngineByName("nashorn");
		try 
		{
			String scriptAExecutar = ((ec.app.scriptDatajs.Problem)problem).scriptOrigem;
			
			engine.eval(new FileReader(scriptAExecutar));
			Invocable invocable = (Invocable) engine;

			 try 
			 {
				Object result = invocable.invokeFunction("AvancaDias", dadosEntrada.DiasParaSomar, dadosEntrada.Dia, dadosEntrada.Mes, dadosEntrada.Ano);
				return result.toString();
			 } 
			 catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
    }
    
 }
