package ec.app.scriptDatajs;

import ec.gp.*;

public class scriptData extends GPData
    {
	public int Ano;
	public int Mes;
	public int Dia;
	public int DiasParaSomar;
	public String Texto;
	
	public String ResultadoExecucaoArvore;
    

    public void copyTo(final GPData gpd)   // copy my stuff to another DoubleData
        { 
    		((scriptData)gpd).Ano = Ano; 
    		((scriptData)gpd).Mes = Mes;
    		((scriptData)gpd).Dia = Dia;
    		((scriptData)gpd).DiasParaSomar = DiasParaSomar;
    		((scriptData)gpd).Texto = Texto;
    		((scriptData)gpd).ResultadoExecucaoArvore = ResultadoExecucaoArvore; 
    		
    	}
    }
