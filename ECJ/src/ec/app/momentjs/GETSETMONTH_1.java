package ec.app.momentjs;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

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

public class GETSETMONTH_1 extends GPNode {

	public String toString() { return "GETSETMONTH_1"; }
    

	public void eval(final EvolutionState state, final int thread, final GPData input, final ADFStack stack, final GPIndividual individual, final Problem problem)
    {
		//TODO: parametros...
		executarFuncao();
    }


    public void executarFuncao()  {
        Context context = Context.enter();
        context.setOptimizationLevel(-1); // disable bytecode generation because of large code
        try {
            Scriptable scope = context.initStandardObjects();
            
            loadResource(context, scope, "env-fix.js");
            loadResource(context, scope, "env.rhino.1.2.js");
            loadResource(context, scope, "angular.min.js");
            loadResource(context, scope, "angular-app.js");
            
            Scriptable testService = (Scriptable)context.evaluateString(scope, "injector.get('testService')", "test", 1, null);
            Function helloWorldFunc = (Function)ScriptableObject.getProperty(testService, "helloWorld");
            Object result = helloWorldFunc.call(context, scope, testService, new Object[]{});
            System.out.println(result);
        }
        catch(Exception ex)
        {
        	
        }
        finally 
        {
            Context.exit();
        }
    }
    
    private static void loadResource(Context context, Scriptable scope, String resourceName) throws IOException {
        String resourceUrl = "src/main/resources/" + resourceName;
        String resourceContents = readFile(resourceUrl);
        
        context.evaluateString(scope, resourceContents, resourceName, 1, null);
    }
    
    private static String readFile(String pathname) throws IOException {

	    File file = new File(pathname);
	    StringBuilder fileContents = new StringBuilder((int)file.length());
	    Scanner scanner = new Scanner(file);
	    String lineSeparator = System.getProperty("line.separator");

	    try {
	        while(scanner.hasNextLine()) {        
	            fileContents.append(scanner.nextLine() + lineSeparator);
	        }
	        return fileContents.toString();
	    } finally {
	        scanner.close();
	    }
	}
}
