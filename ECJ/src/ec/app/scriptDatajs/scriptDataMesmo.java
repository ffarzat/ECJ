package ec.app.scriptDatajs;

import ec.gp.*;

public class scriptDataMesmo extends GPData
    {
	public int Ano;
	public int Mes;
	public int Dia;
	public int DiasParaSomar;
	public String Texto;
	
	public String ResultadoExecucaoArvore;
    

    public void copyTo(final GPData gpd)   // copy my stuff to another DoubleData
        { 
    		((scriptDataMesmo)gpd).Ano = Ano; 
    		((scriptDataMesmo)gpd).Mes = Mes;
    		((scriptDataMesmo)gpd).Dia = Dia;
    		((scriptDataMesmo)gpd).DiasParaSomar = DiasParaSomar;
    		((scriptDataMesmo)gpd).Texto = Texto;
    		((scriptDataMesmo)gpd).ResultadoExecucaoArvore = ResultadoExecucaoArvore; 
    		
    	}
    }
