function AvancaDias(lnDias, ldDia, ldMes, ldAno)
{
	var ndiasmes="";
	var ltDia, ltMes, ltAno
	ltDia = ldDia;
	ltMes = ldMes;
	ltAno = ldAno;

	//31, 30, 28 ou 29 dias?
	ndiasmes = DeterminarQuantidadeDeDias(ldMes, ldAno);
	
	//incrementa dias
	if ((ldDia + lnDias)<=ndiasmes)
	{
		ltDia= ldDia + lnDias
	}
	else
	{
		ltDia = parseInt((ldDia+lnDias)%ndiasmes)

		if (parseInt(ldMes +((ldDia+lnDias)/ndiasmes))<=12)
		{
			ltMes = parseInt(ldMes +((ldDia+lnDias)/ndiasmes))
		}
		else
		{
			ltMes = parseInt((ldMes +((ldDia+lnDias)/ndiasmes)) %12)
			ltAno = parseInt(ldAno + ((ldMes + ((ldDia+lnDias)/ndiasmes))/12))
		}
	}

	var resultado = ltDia + "/" + ltMes + "/" + ltAno;
	
	return (resultado);
}

/* Determina quantos dias tem o mês */
function DeterminarQuantidadeDeDias(ldMes, ldAno)
{
	if ((ldMes==01)||(ldMes==03)||(ldMes==05)||(ldMes==07)||(ldMes==08)||(ldMes==10)||(ldMes==12))
	{
		ndiasmes=31
	}
	else if ((ldMes==04)||(ldMes==06)||(ldMes==09)||(ldMes==11))	//30 dias
	{
		ndiasmes=30
	}
	else   //fevereiro
	{
		//Calcula ano bissexto
		if (((ldAno % 4) == 0) && ((ldAno % 100) == 0))
			ndiasmes=29
		else if ((ldAno % 400) == 0)
			ndiasmes=29
		else
			ndiasmes=28
	}

	return ndiasmes;
}

/*Escreve o resultado no console javascript*/
function escreverNaTela(texto)
{
	//print(texto); //Risco de não funcionar e precisar o env.js
}



